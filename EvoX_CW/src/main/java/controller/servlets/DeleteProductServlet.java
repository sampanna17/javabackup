package controller.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve product name from request parameter
        String productName = request.getParameter("productName");
        String userId = request.getParameter("userID");
        // Call a method to delete the product from the database
        boolean deleted = deleteProductFromDatabase(productName, userId);

        if (deleted) {
            response.sendRedirect("pages/cart.jsp?deleted=true");
        } else {
            response.sendRedirect("pages/cart.jsp?deleted=false");
        }
    }

    private boolean deleteProductFromDatabase(String productName, String userId) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/shadowpack";
        String username = "root";
        String password = "";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Connect to the database
            conn = DriverManager.getConnection(url, username, password);
            
            // Prepare the SQL statement to delete the product
            String sql = "DELETE FROM cart WHERE product_name = ? and userId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productName);     
            pstmt.setString(2, userId);

            
            // Execute the delete operation
            int rowsAffected = pstmt.executeUpdate();
            
            // If rowsAffected is greater than 0, deletion was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Close the PreparedStatement and Connection
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
