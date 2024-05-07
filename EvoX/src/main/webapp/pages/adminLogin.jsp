<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../stylesheets/adminLogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="main">
        <form action="">
            <h1>Login</h1>
            <div class="choice-container">
                <a href="adminLogin.jsp" class="choice-button" id="admin-button">Admin</a>
                <a href="userLogin.jsp" class="choice-button" id="user-button">User</a>
            </div>


            <div class="input-box">
                <input type="text" placeholder="Admin Name" required>
                <i class="fa fa-user"></i>
            </div>
            <div class="input-box">
                <input type="password" placeholder="Password" required>
                <i class="fa fa-lock"></i>
            </div>
            <div class="remember-forget">
                <label><input type="checkbox">Remember me</label>
                <a href="#">Forgot password?</a>
            </div>
            <button type="submit" class="btn">Login</button>

        </form>
    </div>

</body>

</html>