<%@page import="java.sql.*, utils.StringUtils, java.io.*, javax.imageio.*, java.util.Base64"%>
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
        String roleQuery = "SELECT id FROM users WHERE user_name = ?";
        roleStmt = conn.prepareStatement(roleQuery);
        roleStmt.setString(1, currentUser);
        roleRs = roleStmt.executeQuery();

        if (roleRs.next()) {
            userRole = roleRs.getString("id");
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
    <title>Selected Product Details</title>
    <!-- Your JavaScript code and other imports here -->
</head>
<body>
    <h2>Selected Product Details</h2>
    <div>
        <p>Product Name: <%= request.getParameter("name") %></p>
        <p>Product Image:</p>
        <p>User Id: <%= userRole %></p>
        <img src="../assets/<%= request.getParameter("path") %>" alt="Selected Product Image" height="200px" width="200px">
        <!-- Add a form for adding the product to the cart -->
        <form action="<%=contextPath%>/UploadCartServlet" method="post">
            <!-- Hidden input field to store the user ID -->
            <input type="hidden" name="userId" value="<%= userRole %>">
            <!-- Hidden input field to store the product name -->
            <input type="hidden" name="product_name" value="<%= request.getParameter("name") %>">
            <!-- Button to submit the form -->
            <button type="submit">Add to Cart</button>
        </form>
    </div>
</body>
</html>
