<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);
String username = (String) request.getAttribute(StringUtils.USERNAME);
String successParam = request.getParameter(StringUtils.SUCCESS);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../stylesheets/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>	

	<div class="main">
        <form action="<%= contextPath + StringUtils.SERVLET_URL_LOGIN%>" method="post">
            <h1>Login</h1>
            
            <div class="input-box">
                <input type="text" placeholder="User Name" name="username" required>
                <i class="fa fa-user"></i>
            </div>
            <div class="input-box">
                <input type="password" placeholder="Password" name="password" required>
                <i class="fa fa-lock"></i>
            </div>
            <div class="remember-forget">
                <label><input type="checkbox">Remember me</label>
                <a href="#">Forgot password?</a>
            </div>
            <button type="submit" class="btn">Login</button>
            <div class="register-link">
                <p>Don't have an account?<a href="register.jsp">Register now</a></p>
            </div>
        </form>
        <%
			if (errMsg != null) {
			%>
			<p class="error-msg">
				<%
				out.println(errMsg);
				%>
			</p>
			<%
			}
			
			if (successParam != null && successParam.equals(StringUtils.TRUE)) {
			    %>
			    <h2 class="success-msg">Registration Successful!</h2>
			    <%
			}
			%>
    </div>

</body>

</html>
		
			
			
