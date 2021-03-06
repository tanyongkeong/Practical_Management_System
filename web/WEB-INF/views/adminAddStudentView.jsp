<%-- 
    Document   : adminAddStudentView
    Created on : Dec 5, 2017, 8:23:17 AM
    Author     : NURUL AIMAN
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <jsp:include page="_bootstrapHead.jsp"></jsp:include>
        </head>
        <body class="hold-transition skin-purple sidebar-mini">

            <!-- Site wrapper -->
            <div class="wrapper">

                <header class="main-header">
                    <!-- Logo -->
                    <a href="${pageContext.request.contextPath}/" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>UTM</b>P</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>UTM</b>Practical</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">

                            <!-- Notifications: style can be found in dropdown.less -->
                            <li class="dropdown notifications-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-bell-o"></i>
                                    <span class="label label-warning">10</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">You have 10 notifications</li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#">View all</a></li>
                                </ul>
                            </li>
                            <!-- Tasks: style can be found in dropdown.less -->
                            <li class="dropdown tasks-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-flag-o"></i>
                                    <span class="label label-danger">9</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">You have 9 tasks</li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Design some buttons
                                                        <small class="pull-right">20%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">20% Complete</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                        </ul>
                                    </li>
                                    <li class="footer">
                                        <a href="#">View all tasks</a>
                                    </li>
                                </ul>
                            </li>
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <span class="hidden-xs"><c:out value="${sessionScope.loginedUser.adminName}" /></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        
                                        <p>
                                            <c:out value="${sessionScope.loginedUser.adminName}" />
                                            <small><c:out value="${sessionScope.loginedUser.adminId}" /></small>
                                        </p>
                                    </li>
                                    
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                       <div class="pull-right">
                                            <a href="${pageContext.request.contextPath}/LogoutServlet" class="btn btn-default btn-flat">Sign out</a>
                                             </div>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                </nav>
            </header>

            <!-- =============================================== -->

            <!-- Left side column. contains the sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">MAIN NAVIGATION</li>
                        <li>
                            <a href="${pageContext.request.contextPath}/adminMain">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span></a>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-user-circle"></i>
                                <span> Manage Students</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li class="active">><a href=${pageContext.request.contextPath}/createStudent><i class="fa fa-circle-o"></i> Add New Student</a></li>
                                <li><a href= ${pageContext.request.contextPath}/studentList><i class="fa fa-circle-o"></i> View Students List</a></li>
                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-files-o"></i>
                                <span> Manage Coordinators</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="${pageContext.request.contextPath}/createCoordinator"><i class="fa fa-circle-o"></i> Add New Coordinator</a></li>
                                <li><a href="${pageContext.request.contextPath}/coordinatorList"><i class="fa fa-circle-o"></i> View Coordinators List</a></li>
                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-address-card"></i>
                                <span> Manage Application</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href= ${pageContext.request.contextPath}/createApplication><i class="fa fa-circle-o"></i>Open New Application</a></li>
                                <li><a href= ${pageContext.request.contextPath}/applicationList><i class="fa fa-circle-o"></i> View Application List</a></li>
                            <li><a href= ${pageContext.request.contextPath}/historyList><i class="fa fa-circle-o"></i>Application History</a></li>
                            </ul>
                        </li>

                        <li class="header">LABELS</li>
                        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- =============================================== -->

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Manage Coordinator
                        <small>Manage student of UTM Practical Management System</small>
                    </h1>
                   
                </section>

                <!-- Main content -->
                <section class="content">

                    <!-- Default box -->
                    <div class="box">


                        <div class="box-header">
                            
                            <h3 class="box-title">CREATE NEW STUDENT ACCOUNT</h3>
                            
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">

                            <p style="color: red;">${errorString}</p>

                                <form method="POST" action="${pageContext.request.contextPath}/createStudent" enctype="multipart/form-data">
                                    
                                    <table border="0">
                                        <tr>
                                            <th>Student's ID:   &nbsp;&nbsp;&nbsp;</th>
                                            <td>
                                                <input type="text" style="color:red;" readonly name="std_id" value="${newId}">
                                            </td>
                                        </tr>
                                        
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>Name: </th>
                                            <td><input type="text" name="name" required/></td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>Gender:</th>
                                            <td>
                                                <select name='gender' required>
                                                    <option value='F'>Female</option>
                                                    <option value='M'>Male</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>Contact Number:</th>
                                            <td><input type="text" name="contact" required/></td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>Email:</th>
                                            <td><input type="text" name="email" required/></td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>Matric Number:</th>
                                            <td><input type="text" name="matric" required/></td>
                                        </tr>
                                         <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>Course:</th>
                                            <td>
                                            <select name='course' required>
                                                    <option value='SCSJ'>SCSJ</option>
                                                    <option value='SCSR'>SCSR</option>
                                                    <option value='SCSB'>SCSB</option>
                                                    <option value='SCSV'>SCSV</option>
                                                    <option value='SCSD'>SCSD</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>CGPA:</th>
                                            <td>
                                                <input type="number" min='0' max='4' step='0.01' name="cgpa" required />
                                            </td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>Practical Year:</th>
                                            <td>
                                                <input type="number" min='2016' max='2050' step='1' name="year" required />
                                            </td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                         <tr>
                                             <th>Coordinator's Name: &nbsp;&nbsp;&nbsp;</th>
                                            
                                            <td>
                                                <select  name="coID" required>
                                                    <c:forEach items="${coordinatorList}" var="coordinator">
                                                        <option value="${coordinator.coordinatorId}">${coordinator.coordinatorId} - ${coordinator.coordinatorName}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                        </tr>
                                       <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <th>Upload Photo:&nbsp;</th>
                                            <td><input type="file" name="photo" size="50" required></td>
                                        </tr>
                                        
                                        <tr><td>&nbsp;</td></tr>
                                       <tr>
                                            <td colspan = "2">
                                                <input type="submit" value="Submit" />
                                                <a href="${pageContext.request.contextPath}/studentList">Cancel</a>
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                            
                                        
                                        
                                       

                        </div>
                        <!-- /.box-body -->

                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        
                    </div>
                    <!-- /.box-footer-->





                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.4.0
                </div>
                <strong>Copyright &copy; 2017 <a href="https://adminlte.io">ASTF Dev.</a>.</strong> All rights
                reserved.
            </footer>



            <!-- ./wrapper -->


            <jsp:include page="_bootstrapEnd.jsp"></jsp:include>

    </body>
</html>

