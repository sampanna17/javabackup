<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="./login.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <div class="container">
            <form action="../login" method='post'>
                <h1>LOGIN</h1>
                <div class="input-box">
                    <input type="text" placeholder="Username" name="username">
                    <i class='bx bxs-user' ></i>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Password" name="password">
                    <i class='bx bxs-lock-alt'></i>
                </div>
                <div class="remember">
                    <label>
                      <input type="checkbox" name="remember">Remember me</label>
                      <a href="#">Forgot Password</a>
                </div>
                <button type="submit" class="btn">Login</button>
                
                <div class="register-link">
                    <p>Don't have an account?<a href="./register.jsp"> Register</a></p>
                </div>
            </form>
        </div>
    </body>
</html>
