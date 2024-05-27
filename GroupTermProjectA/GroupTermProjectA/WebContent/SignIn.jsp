<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - GroupA Immigration Services</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="style1.css"> 
</head>
<body>

<header class="site-header">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS99nqcI5QAKfHWsncxRepkFUx0Fbg1eu7yxvIBgoWMHQ&s" alt="GroupA Logo" class="logo" style="height:40px;"> <!-- Ensure the image path is correct -->
    <h1>GroupA Immigration Services</h1>
    <nav class="site-nav">
        <ul>
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="Services.jsp">Services</a></li>
            <li><a href="AboutUs.jsp">About Us</a></li>
            <li><a href="SignIn.jsp">Login</a></li>
            <li><a href="index.jsp">Sign Up</a></li>
        </ul>
    </nav>
</header>

<div class="login-container">
    <h2><i class="fa fa-lock"></i> Login to Your Account</h2>
    <%-- Display error message if present --%>
    <% String errorMessage = (String) request.getAttribute("errorMessage");
       if (errorMessage != null && !errorMessage.isEmpty()) { %>
       <div class="error-message"><%= errorMessage %></div>
    <% } %>
    <form action="Application" method="post">
        <div class="input-group">
            <i class="fa fa-user icon"></i>
            <input type="text" name="username" placeholder="Username" required>
        </div>
        <div class="input-group">
            <i class="fa fa-key icon"></i>
            <input type="password" name="password" placeholder="Password" required>
        </div>
        <button type="submit" class="login-btn">Login</button>
    </form>
    <p>Don't have an account? <a href="index.jsp">Register now</a></p>
    <p>Delete Your Account?</p>
</div>
<footer class="site-footer" >
    <p style="color:white;">&copy; 2024 GroupA Immigration Services. All rights reserved.</p>
</footer>

</body>
</html>
