package controller.servlets;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.StudentModel;
import model.UserModel;
import utils.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_URL_REGISTER })
public class RegisterUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final DBController dbController;

	public RegisterUserServlet() {
		this.dbController = new DBController();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Extract student information from request parameters
		String username = request.getParameter(StringUtils.USERNAME);
		String firstname = request.getParameter(StringUtils.FIRST_NAME);
		String lastname = request.getParameter(StringUtils.LAST_NAME);
		String email = request.getParameter(StringUtils.EMAIL);
		String phonenumber = request.getParameter(StringUtils.PHONE_NUMBER);
		String gender = request.getParameter(StringUtils.GENDER);
		String password = request.getParameter(StringUtils.PASSWORD);
		String role = "0";

		// Implement data validation here (e.g., check for empty fields, email format,
		// etc.)

		// Create a StudentModel object to hold student information
		UserModel user = new UserModel(username, firstname, lastname, email, phonenumber, gender, password, role);

		// Call DBController to register the user
		int result = dbController.registerUser(user);

		if (result == 1) {
			request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN);
		} else if (result == 0) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		} else {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
	}
}