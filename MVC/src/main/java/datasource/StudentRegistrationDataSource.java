package datasource;

public class StudentRegistrationDataSource {
	public static final String INSERT_STUDENT = "INSERT INTO students"
			+ "(user_name, first_name, last_name, dob, gender, email, phone_number, subject, password)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
	
	public static final String SELECT_STUDENT_LOGIN_INFO = "SELECT students.user_name,students.password FROM students WHERE user_name = ? and password = ?";

	//End SQL Queries
	
	//Start messages
	
	//ENd messages
	}
