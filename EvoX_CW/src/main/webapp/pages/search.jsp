<%@page import="java.sql.*, utils.StringUtils, java.io.*, javax.imageio.*, java.util.Base64"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="controller.servlets.SearchServlet" %>

 <% String userRole = (String) request.getAttribute("userRole"); %>
<%
String contextPath = request.getContextPath();
HttpSession userSession = request.getSession();
String currentUser = (String) userSession.getAttribute(StringUtils.USERNAME);
String p = ""; // Initialize user role as an empty string

Connection conn = null; // Declare the Connection variable only once

// Fetch user's role from the database based on the username
PreparedStatement roleStmt = null;
ResultSet roleRs = null;
try {
    conn = DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME, StringUtils.LOCALHOST_PASSWORD);
    String roleQuery = "SELECT path from admin WHERE name = ?";
    roleStmt = conn.prepareStatement(roleQuery);
    roleStmt.setString(1, userRole);
    roleRs = roleStmt.executeQuery();
    

    if (roleRs.next()) {
        p = roleRs.getString("path");
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

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Search</title>
  </head>
  <body>
    <h1>The product is <%= userRole %></h1>
    <img src="<%=contextPath%>/assets/<%= p %>" alt="Selected Product Image" height="200px" width="200px">
  </body>
</html>