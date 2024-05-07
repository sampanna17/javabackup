package controllers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Replace this with your actual authentication logic
        boolean isAuthenticated = authenticateUser(username, password);

        if (isAuthenticated) {
            // Check if the user has admin privileges (You should replace this with your own logic)
            boolean isAdmin = isAdminUser(username);

            if (isAdmin) {
                // Set session attribute to mark the user as admin
                HttpSession session = request.getSession();
                session.setAttribute("adminLoggedIn", true);
            }

            // Redirect to appropriate dashboard
            if (isAdmin) {
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("userDashboard.jsp");
            }
        } else {
            // Authentication failed, redirect back to login page with error message
            response.sendRedirect("login.jsp?error=authentication_failed");
        }
    }

    
    private boolean authenticateUser(String username, String password) {
        
        return true;
    }

    // Replace this with your actual logic to determine if the user is an admin
    private boolean isAdminUser(String username) {
        return "admin".equals(username);
    }
}