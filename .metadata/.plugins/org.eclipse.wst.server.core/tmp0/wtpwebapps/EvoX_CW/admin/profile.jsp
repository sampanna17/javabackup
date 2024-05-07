<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%String userRole = (String) request.getAttribute("userRole");
String userName = (String) request.getAttribute("userName");
String firstName = (String) request.getAttribute("firstName");
String lastName = (String) request.getAttribute("lastName");
String email = (String) request.getAttribute("email");
String phonenumber = (String) request.getAttribute("phonenumber");
String contextPath = request.getContextPath();

%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%= contextPath %>/stylesheets/adminprofile.css" />
    <title></title>
  </head>
  <body>
    <header>
      <button class="edit-btn">
        &#9998; Edit <span class="edit-sign"></span>
      </button>
    </header>
    <div class="navbar">
      <div class="dropdown">
        <button class="dropbtn">&#9776;</button>
        <div class="dropdown-content">
          <a href="profile.html"
            ><img src="profile.png" alt="Profile Logo" /> Profile</a
          >
          <a href="./pages/dashboard.jsp"
            ><img src="dashboard.jpg" alt="Dashboard Logo" /> Dashboard</a
          >
          <a href="addproducts.html"
            ><img src="addproducts.png" alt="Profile Logo" /> Add Products</a
          >
          <a href="total-products.html"
            ><img src="product.jpg" alt="Total Products Logo" /> Total
            Products</a
          >
          <a href="order-list.html"
            ><img src="order.png" alt="Order List Logo" /> Order List</a
          >
          <a href="users.html"><img src="user.png" alt="Users Logo" /> Users</a>
        </div>
      </div>
    </div>
    <!-- profile -->
    <h1>My Profile</h1>
    <h2><%= firstName %> <%= lastName %></h2>
    <p>
      <a href="mailto:<%=email %>>" style="text-decoration: none"
        ><%=email %></a
      >
    </p>
    <small> Administrator</small>

    <img src="insta.jpg" alt="instagram" class="instagram" />
    <img src="facebook.jpg" alt="facebook" class="facebook" />
    <img src="linkedin.jpg" alt="linkedin" class="linkedin" />
    <section>
      <img src="sampanna.png" alt="Profile Picture" />

      <p class="acc-details">Account Details</p>
      <table class="profile-table">
        <tr>
          <td>First Name</td>
          <td class="vertical-line"></td>
          <td><%=firstName %></td>
        </tr>
        <tr>
          <td>Surname</td>
          <td class="vertical-line"></td>
          <td><%=lastName %></td>
        </tr>
        <tr>
          <td>Email</td>
          <td class="vertical-line"></td>
          <td><%=email %></td>
        </tr>
        <tr>
          <td>Phone</td>
          <td class="vertical-line"></td>
          <td><%=phonenumber %></td>
        </tr>
        <tr>
          <td>UserName</td>
          <td class="vertical-line"></td>
          <td><%= userName %></td>
        </tr>
        <tr>
          <td>Password</td>
          <td class="vertical-line"></td>
          <td>********</td>
        </tr>
      </table>
    </section>
  </body>
</html>
