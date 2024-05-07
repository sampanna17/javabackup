package com.collegeapp.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class Test
*/

@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StudentRegister() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Not implemented
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

        response.setContentType("text/html");
        PrintWriter printOut = response.getWriter();
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String date_of_birth = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String subject_details = request.getParameter("subject");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/student_info";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "INSERT INTO students_data (first_name, last_name, date_of_birth, gender, email, phone, subject_details) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, first_name);
            st.setString(2, last_name);
            st.setString(3, date_of_birth);
            st.setString(4, gender);
            st.setString(5, email);
            st.setString(6, phone);
            st.setString(7, subject_details);

            int result = st.executeUpdate();
            if (result > 0) {
                printOut.println("<h1>Your account is registered as</h1>");
                printOut.println("<h3>First Name: " + first_name + "</h3>");
                printOut.println("<h3>Last Name: " + last_name + "</h3>");
                printOut.println("<h3>Email: " + email + "</h3>");
                printOut.println("<h3>Gender: " + gender + "</h3>");
                printOut.println("<h3>Date of Birth: " + date_of_birth + "</h3>");
                printOut.println("<h3>Phone: " + phone + "</h3>");
                printOut.println("<h3>Subject details: " + subject_details + "</h3>");
            } else {
                printOut.println("<h1>Sorry! Your data is not registered</h1>");
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            printOut.println("<h1>Please enter the correct data</h1>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

