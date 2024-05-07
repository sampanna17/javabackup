package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AdminModel;
import model.CartModel;
import model.LoginModel;
import model.PasswordEncryptionWithAes;
import model.ProductModel;
import model.StudentModel;
import model.UserModel;
import utils.StringUtils;

public class DBController {
	public Connection getConnection() throws SQLException, ClassNotFoundException {

	    // Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
	    Class.forName(StringUtils.DRIVER_NAME);

	    // Create a connection to the database using the provided credentials
	    return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
	                                      StringUtils.LOCALHOST_PASSWORD);
	}


	public int registerUser(UserModel user) {

	    try {
	        // Prepare a statement using the predefined query for student registration
	        PreparedStatement stmt = getConnection()
	        		.prepareStatement(StringUtils.QUERY_REGISTER_USER);

	        // Set the student information in the prepared statement
	        stmt.setString(1, user.getUsername());
	        stmt.setString(2, user.getFirstName());
	        stmt.setString(3, user.getLastName());
	        stmt.setString(4, user.getGender());
	        stmt.setString(5, user.getEmail());	   
	        stmt.setString(6, user.getPhoneNumber());	
	        stmt.setString(7, PasswordEncryptionWithAes.encrypt(
	        		user.getUsername(), user.getPassword()));
	        stmt.setString(8, "0");


	        // Execute the update statement and store the number of affected rows
	        int result = stmt.executeUpdate();

	        // Check if the update was successful (i.e., at least one row affected)
	        if (result > 0) {
	            return 1; // Registration successful
	        } else {
	            return 0; // Registration failed (no rows affected)
	        }

	    } catch (ClassNotFoundException | SQLException ex) {
	        // Print the stack trace for debugging purposes
	        ex.printStackTrace();
	        return -1; // Internal error
	    }
	}
	
	
	public int registerProduct(ProductModel product) {
		 try {
		        PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_PRODUCT);
		        
		        stmt.setString(1, product.getProductName());
		        stmt.setString(2, product.getPrice());
		        stmt.setString(3, product.getPath());
		        stmt.setString(4, product.getCategory());
		        stmt.setString(5, product.getStock());
		     	        
		        int result = stmt.executeUpdate();

		        // Return the number of affected rows
		        return result; 
		    } catch (ClassNotFoundException | SQLException ex) {
		        // Print the stack trace for debugging purposes
		        ex.printStackTrace();
		        return -1; // Internal error
		    }
	}
		
	public int addCart(CartModel cart) {
		 try {
		        PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_ADD_CART);
		        
		        stmt.setString(1, cart.getStudentID());
		        stmt.setString(2, cart.getItemName());
		        		        
		        int result = stmt.executeUpdate();

		        // Return the number of affected rows
		        return result; 
		    } catch (ClassNotFoundException | SQLException ex) {
		        // Print the stack trace for debugging purposes
		        ex.printStackTrace();
		        return -1; // Internal error
		    }
	}
	
	public int getStudentLoginInfo(LoginModel loginModel) {
	    // Try-catch block to handle potential SQL or ClassNotFound exceptions
	    try {
	        // Prepare a statement using the predefined query for login check
	        PreparedStatement st = getConnection()
	        		.prepareStatement(StringUtils.QUERY_LOGIN_USER_CHECK);

	        // Set the username in the first parameter of the prepared statement
	        st.setString(1, loginModel.getUsername());

	        // Execute the query and store the result set
	        ResultSet result = st.executeQuery();

	        // Check if there's a record returned from the query
	        if (result.next()) {
	            // Get the username from the database
	            String userDb = result.getString(StringUtils.USER_NAME);

	            // Get the password from the database
	            String encryptedPwd = result.getString(StringUtils.PASSWORD);

	            String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);
	            // Check if the username and password match the credentials from the database
	            if (userDb.equals(loginModel.getUsername()) 
	            		&& decryptedPwd.equals(loginModel.getPassword())) {
	                // Login successful, return 1
	                return 1;
	            } else {
	                // Username or password mismatch, return 0
	                return 0;
	            }
	        } else {
	            // Username not found in the database, return -1
	            return -1;
	        }

	    // Catch SQLException and ClassNotFoundException if they occur
	    } catch (SQLException | ClassNotFoundException ex) {
	        // Print the stack trace for debugging purposes
	        ex.printStackTrace();
	        // Return -2 to indicate an internal error
	        return -2;
	    }
	}
	
	public Boolean checkEmailIfExists(String email) {
	    // TODO: Implement logic to check if the provided email address exists in the database
	    // This method should likely query the database using DBController and return true if the email exists, false otherwise.
	    return false;
	}

	public Boolean checkNumberIfExists(String number) {
	    // TODO: Implement logic to check if the provided phone number exists in the database
	    // This method should likely query the database using DBController and return true if the phone number exists, false otherwise.
	    return false;
	}

	public Boolean checkUsernameIfExists(String username) {
	    // TODO: Implement logic to check if the provided username exists in the database
	    // This method should likely query the database using DBController and return true if the username exists, false otherwise.
	    return false;
	}

}