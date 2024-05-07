package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.database.DBController;
import model.LoginModel;
import utils.StringUtils;

@WebServlet(urlPatterns = StringUtils.SERVLET_URL_LOGIN, asyncSupported = true)
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final DBController dbController;

    public LoginServlet() {
        this.dbController = new DBController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract username and password from the request parameters
        String username = request.getParameter(StringUtils.USERNAME);
        String password = request.getParameter(StringUtils.PASSWORD);

        // Create a LoginModel object to hold user credentials
        LoginModel loginModel = new LoginModel(username, password);

        // Call DBController to validate login credentials
        int loginResult = dbController.getStudentLoginInfo(loginModel);

        // Handle login results with appropriate messages and redirects
        if (loginResult == 1) {
            // Login successful
        	HttpSession userSession = request.getSession();
			userSession.setAttribute(StringUtils.USERNAME, username);
			userSession.setMaxInactiveInterval(30*60);
			
			Cookie userCookie= new Cookie(StringUtils.USER, username);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);
			
            request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_WELCOME);
        } else if (loginResult == 0) {
            // Username or password mismatch
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);
			request.setAttribute(StringUtils.USERNAME, username);
            request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
        } else if (loginResult == -1) {
            // Username not found
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
			request.setAttribute(StringUtils.USERNAME, username);
            request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
        } else {
            // Internal server error
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
			request.setAttribute(StringUtils.USERNAME, username);
            request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
        }
    }
}
