package controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.StudentLoginService;
import utils.StringUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
	StudentLoginService studentloginservice = new StudentLoginService();

	String username = request.getParameter("username");
	String password = request.getParameter("password");

	int loginResult =  studentloginservice.getStudentLoginInfo(username, password);

	if (loginResult == 1) {
	response.sendRedirect(request.getContextPath() + "/pages/welcome.html");
	}else if(loginResult == 0){
		 // Invalid credentials
        request.setAttribute("message", StringUtils.INVALID_CREDENTIAL);
        request.getRequestDispatcher("/login.html").forward(request, response);
	}else {
		// Other errors
        response.sendRedirect(request.getContextPath() + "/pages/error.html");
	}
}

}


