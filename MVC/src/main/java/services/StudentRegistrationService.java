package services;

import java.sql.Date;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import configs.DbConnectionConfig;
import datasource.StudentRegistrationDataSource;
import models.StudentRegistrationModel;

public class StudentRegistrationService {

		DbConnectionConfig dbObj = new DbConnectionConfig();
	
		public int registerStudent(StudentRegistrationModel studentObj) {
		 try (Connection conn = dbObj.getDbConnection()){
			 PreparedStatement st = conn.prepareStatement(StudentRegistrationDataSource.INSERT_STUDENT);
			 
			 st.setString(1,  studentObj.getUserName());
			 st.setString(2,  studentObj.getFirstName());
			 st.setString(3,  studentObj.getLastName());
			 st.setDate(4,  Date.valueOf(studentObj.getDob()));
			 st.setString(5,  studentObj.getGender());
			 st.setString(6,  studentObj.getEmail());
			 st.setString(7,  studentObj.getPhoneNumber());
			 st.setString(8,  studentObj.getSubject());
			 st.setString(9,  studentObj.getPassword());
			  
			 int result = st.executeUpdate();
			 
			 return result > 0 ? 1 : 0;
		 } catch (SQLException ex) {
	            ex.printStackTrace();
	            return -1;
		 }
	}
		
	
		
	}	


