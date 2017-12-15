/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**
 *
 * @author NURUL AIMAN
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import beans.*;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/editCoordinator" })
public class EditCoordinatorServlet  extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    public EditCoordinatorServlet(){
        super();
    }
    
     // Show coordinator edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String coId = (String) request.getParameter("id");
 
        Coordinator co = null;
 
        String errorString = null;
 
        try {
            co = DBUtils.findCoordinator(conn, coId);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && co == null) {
            response.sendRedirect(request.getServletPath() + "/coordinatorList");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("coordinator", co);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editCoordinatorView.jsp");
            
     //     RequestDispatcher dispatcher = request.getServletContext()
     //           .getRequestDispatcher("/WEB-INF/views/adminCoordinatorListView.jsp#modal-edit");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String id = (String) request.getParameter("co_id");
        String name = (String) request.getParameter("name");
        String dept = (String) request.getParameter("department");
        String post = (String) request.getParameter("position");
        String pass = (String) request.getParameter("password");
        
        
        String errorString = null;
        
        String levelStr = (String) request.getParameter("level");
        int level = 0;
        try {
            level = Integer.parseInt(levelStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
       
        Coordinator c = new Coordinator(id,pass,level,name,dept,post);
        
 
        try {
            DBUtils.updateCoordinator(conn, c);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("coordinator", c);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            //RequestDispatcher dispatcher = request.getServletContext()
                    //.getRequestDispatcher("/WEB-INF/views/editCoordinatorView.jsp");
            //dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/coordinatorList");
        }
    }
    
}
