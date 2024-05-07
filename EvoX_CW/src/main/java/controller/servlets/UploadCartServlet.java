package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.AdminModel;
import model.CartModel;
import utils.StringUtils;

/**
 * Servlet implementation class UploadCartServlet
 */
@WebServlet("/UploadCartServlet")
public class UploadCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadCartServlet() {
		this.dbController = new DBController();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve userId and product_name parameters from the request
        String userId = request.getParameter(StringUtils.USERID); 
        String product_name = request.getParameter(StringUtils.PRODUCT_NAME);
        
        // Check if product_name is not null
        if (product_name != null) {
            // Create a CartModel object with the retrieved parameters
            CartModel cart = new CartModel(userId, product_name);
            
            // Call the DBController to add the cart to the database
            int result = dbController.addCart(cart);
            
            // Handle the result accordingly
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
        } else {
            // Handle case where product_name is null
            request.setAttribute(StringUtils.MESSAGE_ERROR, "Product name cannot be null.");
            request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
        }
    }



}
