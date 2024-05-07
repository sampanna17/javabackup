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
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        String currentUser = (String) userSession.getAttribute(StringUtils.USERNAME);
        String contextPath = request.getContextPath();

        int userRole = 0;

        Connection conn = null;

        PreparedStatement roleStmt = null;
        ResultSet roleRs = null;
        try {
        	DBController dbObj = new DBController();
            conn = dbObj.getConnection();
            String roleQuery = "SELECT count(name) as count from admin";
            roleStmt = conn.prepareStatement(roleQuery);
            roleRs = roleStmt.executeQuery();

            if (roleRs.next()) {
            	userRole = roleRs.getInt("count");
                System.out.println(userRole);
            }

            // Set userRole as an attribute in the request object
            request.setAttribute("userRole", userRole);

            // Forward the request to the JSP
            request.getRequestDispatcher("./pages/docadmin.jsp").forward(request, response);
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
