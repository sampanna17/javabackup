<%@page import="utils.StringUtils" %>
<%@page import="java.sql.*" %>

<%
String username1 = request.getParameter("username");
String password1 = request.getParameter("password");

if(username1.equalsIgnoreCase("admin") && password1.equalsIgnoreCase("admin"))
{
	session.setAttribute("username", username1);
	response.sendRedirect("adminHome.jsp");
	}
else
	response.sendRedirect("errorAdminLogin.jsp");
	
%>