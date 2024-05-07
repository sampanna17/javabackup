<%@page import="java.sql.*, utils.StringUtils, java.io.*, javax.imageio.*, java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute(StringUtils.USERNAME);
    String contextPath = request.getContextPath();
    String userRole = ""; // Initialize user role as an empty string

    Connection conn = null; // Declare the Connection variable only once

    // Fetch user's role from the database based on the username
    PreparedStatement roleStmt = null;
    ResultSet roleRs = null;
    try {
        conn = DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME, StringUtils.LOCALHOST_PASSWORD);
        String roleQuery = "SELECT role FROM student_info WHERE user_name = ?";
        roleStmt = conn.prepareStatement(roleQuery);
        roleStmt.setString(1, currentUser);
        roleRs = roleStmt.executeQuery();

        if (roleRs.next()) {
            userRole = roleRs.getString("role");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (roleRs != null) roleRs.close();
            if (roleStmt != null) roleStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Inventory</title>
    <link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/header.css" />
	<link rel="stylesheet" type="text/css"
		href="<%=contextPath%>/stylesheets/footer.css" />
	</head>
     <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }
        nav {
            background-color: #444;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }
        nav a {
            color: #fff;
            text-decoration: none;
            margin: 0 10px;
        }
        h2 {
            text-align: center;
            margin-top: 20px;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            width: 100%;
            bottom: 0;
       }
    </style>
</head>
<body>
   <header>
    <jsp:include page="<%=StringUtils.PAGE_URL_HEADER%>" />
    <% if("1".equals(userRole)) { %>
        <a href="${pageContext.request.contextPath}/pages/createcar.jsp">
            <button class="home-button">Admin Panel</button>
        </a>        
    <% } %>
</header>


    <nav>
        <a href="<%=request.getContextPath() + StringUtils.PAGE_URL_REGISTER%>">Register a new Student</a>
        <a href="<%=request.getContextPath() + StringUtils.PAGE_URL_LOGIN%>">Login</a>
        <!-- Display user's role -->
        <p>Session username: <%=currentUser %></p>
        <p>User role: <%= userRole %></p>
    </nav>

    <h2>Car Inventory</h2>
    <table>
        <tr>
            <th>Car Name</th>
            <th>Car Image</th>
        </tr>
        <% 
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                // Ensure conn is properly initialized within the try block
                conn = DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME, StringUtils.LOCALHOST_PASSWORD);
                stmt = conn.prepareStatement(StringUtils.QUERY_GET_ALL_PRODUCTS);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    // Fetch the image BLOB data
                    
        %>
        
        <tr>
            <td><%= rs.getString("name") %></td>
<td>
    <a href="./pages/SelectedProduct.jsp?name=<%= rs.getString("name") %>&path=<%= rs.getString("path") %>">
        <img src="./assets/<%= rs.getString("path") %>" alt="<%= rs.getString("path") %> Image" height="200px" width="200px">
    </a>
</td>

			
        </tr>
        <%
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        %>
    </table>

     <footer>
    <jsp:include page="<%=StringUtils.PAGE_URL_FOOTER%>" />
   
	</footer>
</body>
</html>