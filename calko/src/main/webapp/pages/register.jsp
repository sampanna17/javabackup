<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
        <link rel="stylesheet" href="./reg.css">
    
    <meta name="viewport" content="device-width, initial-scale=1.0">
</head>
<body>
    <div class="container">
        <div class="title">Registration</div>
        <form action="../registerstudent" method="post">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">First Name</span> 
                    <input type="text"  name="firstName">
                </div>
                <div class="input-box">
                    <span class="details">Last Name</span> 
                    <input type="text"  name="lastName">
                </div>
                <div class="input-box">
                    <span class="details">Username</span> 
                    <input type="text"  name="username">
                </div>
                <div class="input-box">
                    <span class="details">Email</span> 
                    <input type="text"  name="email">
                </div>
                <div class="input-box">
                    <span class="details">Phone Number</span> 
                    <input type="text"  name="phoneNumber">
                </div>
                <div class="input-box">
                    <span class="details">DOB</span> 
                    <input type="date"  name="birthday">
                </div>
                
                <div class="col">
					<label for="subject">Subject:</label> <select id="subject"
						name="subject" required>
						<option value="computing">Computing</option>
						<option value="multimedia">Multimedia</option>
						<option value="networking">Networking</option>
					</select>
				</div>
				
				<div class="row">
				<div class="col">
					<label for="gender">Gender:</label> 
					<select id="gender"
						name="gender" required>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				
			</div>
                
                <div class="input-box">
                    <span class="details">Password</span> 
                    <input type="password"  name="password">
                </div>
                <div class="input-box">
                    <span class="details">Confirm Password</span> 
                    <input type="password"  name="confirmpassword">
                </div>
            </div>
            
            			<button type="submit">Submit</button>

        </form>
    </div>
</body>
</html>
