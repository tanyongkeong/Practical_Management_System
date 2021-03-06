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
 
@WebServlet(urlPatterns = { "/deleteStudent" })

public class AdminDeleteStudent extends HttpServlet {
     private static final long serialVersionUID = 1L;
     
     
    public AdminDeleteStudent() {
        super();
    
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String stuId = (String) request.getParameter("id");
 
        Student stu = null;
 
        String errorString = null;
        
        
        
        try {
           DBUtils.deleteStudent(conn, stuId);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && stu == null) {
            // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("student", stu);
            response.sendRedirect(request.getContextPath() + "/studentList");
            return;
        }
        
        else{
            response.sendRedirect(request.getContextPath() + "/studentList");
        }
 
        
 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    
}
