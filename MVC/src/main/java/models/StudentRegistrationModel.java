package models;

import java.time.LocalDate; // Import LocalDate class

public class StudentRegistrationModel {
    private String firstName;
    private String lastName;
    private LocalDate dob; 
    private String gender;
    private String email;
    private String phoneNumber;
    private String subject;
    private String userName;
    private String password;

    public StudentRegistrationModel(String userName,LocalDate dob) {
        // TODO Auto-generated constructor stub
        this.userName = userName;
        this.dob = dob;
    }
    

    // Getter to read firstName
    public String getUserName() {
        return this.userName;
    }
    
    // Setter to set firstName
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    // Getter to read firstName
    public String getFirstName() {
        return this.firstName;
    }
    
    
    // Setter to set firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter to read LastName
    public String getLastName() {
        return this.lastName;
    }
    
    // Setter to set lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    // Getter to read dob
    public LocalDate getDob() {
        return this.dob;
    }
            
    // Setter to set dob
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    // Getter to read gender
    public String getGender() {
        return this.gender;
    }
                    
    // Setter to set gender
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    // Getter to read email
    public String getEmail() {
        return this.email;
    }
                        
    // Setter to set email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter to read phoneNumber
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
                        
    // Setter to set phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    // Getter to read Subject
    public String getSubject() {
        return this.subject;
    }
                        
    // Setter to set Subject
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    
    // Getter to read Password
    public String getPassword() {
        return this.password;
    }
                                
    // Setter to set password
    public void setPassword(String password) {
        this.password = password;
    }
}
