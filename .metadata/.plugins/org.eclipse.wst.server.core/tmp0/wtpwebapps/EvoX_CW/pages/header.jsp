<%@page import="java.sql.*, utils.StringUtils, java.io.*, javax.imageio.*, java.util.Base64"%>
<%@ page import="java.util.ArrayList" %>


<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute(StringUtils.USERNAME);
    String contextPath = request.getContextPath();
    
    String userRole = ""; 

    Connection conn = null;

    PreparedStatement roleStmt = null;
    ResultSet roleRs = null;
    try {
        conn = DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME, StringUtils.LOCALHOST_PASSWORD);
        String roleQuery = "SELECT role FROM users WHERE user_name = ?";
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

<div id="header">
    <header class="header">
    	<% String userName = (String) session.getAttribute(StringUtils.USERNAME);%>>
        <h1 class="logo"><a href=""><img src="${contextPath}/assets/logo.png"/></a></h1>
        <ul class="main-nav">
            <li><a href="#">Home</a></li>
            <li><a href="./pages/aboutus.jsp">About Us</a></li>
           	<li><a href="AdminServlet">Admint Us</a></li>
            
            <li><a href="./pages/cart.jsp">Cart</a></li>
            <li><a href="<%=contextPath %>/getDetails">Profile</a></li>
            
            <li>
            
                <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + StringUtils.SERVLET_URL_LOGOUT);
                    } else {
                        out.print(contextPath + StringUtils.PAGE_URL_LOGIN);
                    }
                %>" method="post">
                    <input type="submit" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print(StringUtils.LOGOUT);
                        } else {
                            out.print(StringUtils.LOGIN);
                        }
                    %>"/>
                </form>
            </li>
        </ul>
    </header>
</div>
