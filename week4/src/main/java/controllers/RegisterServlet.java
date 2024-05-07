package controllers;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.buf.StringUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported	= true, urlPatterns	= {StringUtils.REGISTER SERVLET})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dobString = request.getParameter("birthday");
        LocalDate dob = LocalDate.parse(dobString);
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String subject = request.getParameter("subject");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");
		
		// TODO Auto-generated method stub
		doGet(request, response);
		
		DatabaseController dbController = new DatabaseController();
		int result = dbController.addStudent(StudentModel);
		
		// Redirect based on the result of the registration attempt
        if (result == 1) {
            // Registration successful
            request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
            response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
        } else if (result == 0) {
            // Form data mistake
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.REGISTER_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
        } else {
            // Server error
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
        }
	}
}
