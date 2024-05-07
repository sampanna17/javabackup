package controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.StudentRegistrationModel;
import services.StudentRegistrationService;

@WebServlet(asyncSupported = true, urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentRegistrationService studentregistrationservice = new StudentRegistrationService();

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dobString = request.getParameter("birthday");
        LocalDate dob = LocalDate.parse(dobString);
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String subject = request.getParameter("subject");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");
        

       StudentRegistrationModel studentModel = new StudentRegistrationModel(userName, dob);
       //username and dob not passed as they are initially passed in the parameter
       studentModel.setFirstName(firstName);
       studentModel.setLastName(lastName);
       studentModel.setGender(gender);
       studentModel.setPhoneNumber(phoneNumber);
       studentModel.setEmail(email);
       studentModel.setSubject(subject);
       studentModel.setPassword(password);
       
        int result = studentregistrationservice.registerStudent(studentModel);
        
        

        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/pages/login.html");
             
        } else {
            // Handle the case when result is not greater than 0
            // You can add specific error handling or redirect to an error page
        }
    }
}