package controller.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import utils.StringUtils;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/getDetails")
public class GetDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        String currentUser = (String) userSession.getAttribute(StringUtils.USERNAME);

        String userRole = "";
        String userName = "";
        String firstName = "";
        String lastName = "";
        String email = "";
        String phone = "";

        Connection conn = null;

        PreparedStatement roleStmt = null;
        ResultSet roleRs = null;
        try {
        	DBController dbObj = new DBController();
            conn = dbObj.getConnection();
            String roleQuery = "SELECT * FROM users WHERE user_name = ?";
            roleStmt = conn.prepareStatement(roleQuery);
            roleStmt.setString(1, currentUser);
            roleRs = roleStmt.executeQuery();

            if (roleRs.next()) {
            	userName = roleRs.getString("user_name");
            	firstName = roleRs.getString("first_name");
            	lastName = roleRs.getString("last_name");
            	email = roleRs.getString("email");
            	phone = roleRs.getString("number");
            	userRole = roleRs.getString("role");

            }

            // Set userRole as an attribute in the request object
            request.setAttribute("userRole", userRole);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("userName", userName);

            

            // Forward the request to the JSP
            request.getRequestDispatcher("./pages/profile.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (roleRs != null) roleRs.close();
                if (roleStmt != null) roleStmt.close();
                if (conn != null) conn.close(); // Close connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
