package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionConfig {
	public Connection getDbConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/college_app";
			String userName = "root";
			String password = "";
			
			conn = DriverManager.getConnection(url, userName, password);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return conn;
	}
}
