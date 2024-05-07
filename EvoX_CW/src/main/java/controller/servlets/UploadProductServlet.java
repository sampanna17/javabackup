package controller.servlets;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.AdminModel;
import model.ProductModel;
import utils.StringUtils;

@WebServlet("/UploadProductServlet")
public class UploadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadProductServlet() {
		this.dbController = new DBController();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter(StringUtils.PRODUCT_NAME);
		String discription = request.getParameter(StringUtils.DISCRIPTION);
		String category = request.getParameter(StringUtils.CATEGORY);
		String price = request.getParameter(StringUtils.PRICE);
		String stock = request.getParameter(StringUtils.STOCK);
		String path = request.getParameter(StringUtils.PATH);
		
		ProductModel product = new ProductModel(name, discription, category, price, stock, path);
		
		int result = dbController.registerProduct(product);
		
		
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
