/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.*;
/**
 *
 * @author NURUL AIMAN
 */
@WebServlet(urlPatterns = { "/coordinatorList" })
public class CoordinatorListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CoordinatorListServlet() {
        super();
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        Coordinator coordinator = null;
        HttpSession session = request.getSession();
        //admin = MyUtils.getLoginedAdmin(session);
        String errorString = null;
        List<Coordinator> list = null;
        try {
            list = DBUtils.queryCoordinator(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("coordinatorList", list);
       // request.setAttribute("coordinator", coordinator);
         
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/adminCoordinatorListView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
 
    
}
