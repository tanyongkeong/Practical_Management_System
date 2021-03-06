/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Application;
import beans.UserAccount;
import java.io.IOException;
import static java.lang.System.out;
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
import utils.CoordinatorFunctionUtils;
import utils.DBUtils;
import utils.MyUtils;
import utils.StudentFunctionsUtils;

/**
 *
 * @author NURUL AIMAN
 */
@WebServlet(urlPatterns = {"/applicationList"})
public class AdminApplicationListServlet extends HttpServlet {

    public AdminApplicationListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
        errorString = (String) request.getParameter("errorString");
        List<Application> list = null;
        request.setAttribute("errorString", errorString);
        //Forwarding page based on user level
        UserAccount user = null;
        HttpSession session = request.getSession();
        user = MyUtils.getLoginedUser(session);
        RequestDispatcher dispatcher = null;

        if (user == null) {
            // Forward to /WEB-INF/views/loginView.jsp
            // (Users can not access directly into JSP pages placed in WEB-INF)
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
        } else {
            switch (user.getUserLevel()) {
                case 1:
                    try {
                        list = DBUtils.queryCompany(conn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        errorString = e.getMessage();
                    }
                    // Store info in request attribute, before forward to views
                    request.setAttribute("errorString", errorString);
                    request.setAttribute("companyList", list);

                    dispatcher = request.getServletContext()
                            .getRequestDispatcher("/WEB-INF/views/adminApplicationListView.jsp");
                    break;
                case 2:
                    //response.sendRedirect(request.getContextPath() + "/coordinatorMain");
                    break;
                case 3:

                    try {
                        list = StudentFunctionsUtils.queryApplyCompany(conn);

                    } catch (SQLException e) {
                        e.printStackTrace();
                        errorString = e.getMessage();
                    }
                    // Store info in request attribute, before forward to views
                    //request.setAttribute("errorString", errorString);
                    request.setAttribute("companyList", list);

                    if (MyUtils.getLoginedStudent(session).getStd_status().equals("P")) {
                        dispatcher = request.getServletContext()
                                .getRequestDispatcher("/WEB-INF/views/studentNewApplyError.jsp");
                    } else {
                        dispatcher = request.getServletContext()
                                .getRequestDispatcher("/WEB-INF/views/studentApplicationListView.jsp");
                    }

                    break;
                default:
                    dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

                    break;
            }
        }

        dispatcher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
