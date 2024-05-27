<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Immigration Services Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="style.css">
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
<div class="form-container">
	<div class="div1">
    <form   action="Assign_3"  method="post"> 
     
        <fieldset>
            <legend>Personal Information:</legend>
            User Name: <input type="text" name="username" required><br>
            Password: <input type="text" name="password" required><br>
            First Name: <input type="text" name="firstName" required><br>
            Last Name: <input type="text" name="lastName" required><br>
            Age: <input type="number" name="age" min="0" required><br>
            Gender:
            <input type="radio" name="gender" value="Male" required> Male
            <input type="radio" name="gender" value="Female"> Female<br>
            Email: <input type="email" name="email" required><br>
        </fieldset>

        <fieldset>
            <legend>Immigration Details:</legend>
            Type of Visa:
            <select name="visaType">
                <option value="Work">Work</option>
                <option value="Study">Study</option>
                <option value="Tourist">Tourist</option>
                <option value="Permanent Residency">Permanent Residency</option>
            </select><br>
            Reason for Immigration: <textarea name="immigrationReason" rows="5" cols="50" required></textarea><br>
            Skills/Qualifications: <input type="text" name="skills"><br>
            Languages Spoken:
            <input type="checkbox" name="language" value="English"> English
            <input type="checkbox" name="language" value="Spanish"> Spanish
            <input type="checkbox" name="language" value="French"> French
            <input type="checkbox" name="language" value="Other"> Other<br>
        </fieldset>
	 
        <input type="submit" value="Submit Application">
        </form>
        </div>
        
        
		
		<div class="div2">
        <h2>Contact Information</h2>
        <p>If you have any questions or need assistance, please do not hesitate to reach out to our team. Here are our contact details:</p>
        <p><strong>Email:</strong> contact@immigrationservices.com</p>
        <p><strong>Phone:</strong> +1 555-0102</p>
        <p><strong>Address:</strong> 123 Immigration Lane, Suite 101, City, State, Zip Code</p>
        <p>Our office hours are Monday to Friday, 9:00 AM to 5:00 PM.</p>

    </div>
    </div>
    
    

		
 <footer class="site-footer">
    <p>&copy; 2024 GroupA Immigration Services. All rights reserved.</p>
</footer>
   
</body>
</html>