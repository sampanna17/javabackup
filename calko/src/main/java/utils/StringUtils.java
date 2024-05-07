package utils;


public class StringUtils{

	// Start: DB Connection
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/student_management";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	// End: DB Connection

	// Start: Queries
	public static final String QUERY_REGISTER_STUDENT = "INSERT INTO student_info ("
			+ "first_name, last_name, birthday, gender, email, number, subject, user_name, password, role) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String QUERY_LOGIN_USER_CHECK = "SELECT * FROM student_info WHERE user_name = ?";
	// End: Queries


	// Start: Parameter names
	public static final String USERNAME = "username";
	public static final String USER_NAME = "user_name";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String BIRTHDAY = "birthday";
	public static final String GENDER = "gender";
	public static final String EMAIL = "email";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String SUBJECT = "subject";
	public static final String PASSWORD = "password";
	public static final String RETYPE_PASSWORD = "retypePassword";
	public static final String ROLE = "role";
	
	
	public static final String QUERY_LOGIN_ROLE_CHECK = "SELECT role FROM student_info WHERE user_name = ?";


	
	

	// End: Parameter names
	
	//carname queries
    public static final String QUERY_GET_ALL_CARS = "SELECT * FROM cars";
    
    public static final String QUERY_GET_ALL_PRODUCTS = "SELECT * FROM admin";

	
    
    

    // Now you can read the file content and convert it into a byte array or store it in a temporary file
    
    public static final String QUERY_REGISTER_PRODUCT = "INSERT INTO admin ("
            + "name, path)"
            + "VALUES (?, ?)";
    public static final String CARNAME = "name";
    public static final String CARPATH = "path";
    


    
    public static final String QUERY_REGISTER_CAR = "INSERT INTO cars ("
            + "car_name, car_brand, car_makeyear, car_image)"
            + "VALUES (?, ?, ?, ?)";


 


	// Start: Validation Messages
	// Register Page Messages
	public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
	public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";

	// Login Page Messages
	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

	// Other Messages
	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";

	public static final String MESSAGE_SUCCESS = "successMessage";
	public static final String MESSAGE_ERROR = "errorMessage";
	// End: Validation Messages

	// Start: JSP Route
	public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
	public static final String PAGE_URL_REGISTER = "/pages/register.jsp";
	public static final String PAGE_URL_WELCOME = "/pages/welcome.jsp";
	public static final String PAGE_URL_FOOTER = "pages/footer.jsp";
	public static final String PAGE_URL_HEADER = "pages/header.jsp";
	public static final String URL_LOGIN = "/login.jsp";
	public static final String URL_INDEX = "/index.jsp";
	// End: JSP Route

	// Start: Servlet Route
	public static final String SERVLET_URL_LOGIN = "/login";
	public static final String SERVLET_URL_REGISTER = "/registerstudent";
	public static final String SERVLET_URL_LOGOUT = "/logout";
	public static final String SERVLET_URL_CAR = "/createcar";

	// End: Servlet Route

	// Start: Normal Text
	public static final String USER = "user";
	public static final String JSESSIONID = "JSESSIONID";
	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";
	// End: Normal Text
}