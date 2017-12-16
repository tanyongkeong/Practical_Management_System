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
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/createStudent" })

public class AdminCreateStudentServlet extends HttpServlet{

    public AdminCreateStudentServlet() {
        super();
    }
    
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
        int numOfRow = 0;
        String newId = "S";
        
        try {
            numOfRow = DBUtils.getNumOfStudent(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        
        if(numOfRow<10){
            String num = "00"+(numOfRow+1);
            newId+=num;
        }
        
        else if(numOfRow>=10){
            String num = "0"+(numOfRow+1);
            newId+=num;
        }
        
        else{
            errorString = "limit of creating new coordinator reached";
        }
        
        if (errorString != null) {
            response.sendRedirect(request.getServletPath() + "/adminMain");
            return;
        }
        
        
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("newId", newId);
        
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/adminAddStudentView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String id = (String) request.getParameter("std_id");
        String password="123";
        int level=3;
        String name = (String) request.getParameter("name");
        String gender = (String) request.getParameter("gender");
        String contact = (String) request.getParameter("contact");
        String email = (String) request.getParameter("email");
        String matric = (String) request.getParameter("matric");
        String course = (String) request.getParameter("course");
        float cgpa = 0;
        String coId = (String) request.getParameter("coID");
        
        
        String errorString = null;
        
        String cgpaStr = (String) request.getParameter("cgpa");
        
        try {
            cgpa = Float.parseFloat(cgpaStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
       //checks for valid coordinator ID
        try {
            if(DBUtils.findCoordinator(conn, coId)==null){
                errorString = "Invalid Coordinator ID!";
            }
        } catch (SQLException ex) {
            errorString = ex.getMessage();
        }
        
        
        //checks for valid email
        if(!MyUtils.isValidEmailAddress(email)){
            errorString = "Invalid e-mail format!";
        }
        Student stu = new Student(id,password,level,name,gender,contact,email,matric,course,cgpa,"N",coId,"");
 
        try {
            DBUtils.insertStudent(conn, stu);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("student", stu);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/adminAddStudentView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/studentList");
        }
    }
 
}