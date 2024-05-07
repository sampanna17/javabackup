package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import configs.DbConnectionConfig;
import datasource.StudentRegistrationDataSource;

public class StudentLoginService {

	DbConnectionConfig dbObj = new DbConnectionConfig();
	
	public int getStudentLoginInfo(String userName, String password) {
		try(Connection con = dbObj.getDbConnection()){
			PreparedStatement st = con.prepareStatement(StudentRegistrationDataSource.SELECT_STUDENT_LOGIN_INFO);
			st.setString(1, userName);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				//Username and password match in the database
				return 1;
			}else {
				// No matching record found
				return 0;
			}
		}catch(SQLException ex) {
				ex.printStackTrace();
				return -1;
			}
		}

}
