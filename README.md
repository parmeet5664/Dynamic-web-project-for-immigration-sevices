GroupA Immigration Services - Dynamic Web Project
Project Overview:
This project is a dynamic web application developed using Java EE and JSP for an immigration service provider. It includes the following main pages:
1. 	Home
2. 	About Us
3. 	Services
4.  Login
5.	Sign Up
   
The core functionalities are implemented on the Login and Sign-Up pages, where users can register and log in to their accounts.
Technologies Used:
1.	Java EE
2.	JSP (JavaServer Pages)
3.	HTML
4.	CSS
5.	JDBC (Java Database Connectivity)
6.	MySQL (Database)

Pages and Servlets
1. Home.jsp
This is the home page of the application.
2. Services.jsp
This page provides information about the services offered.
3. AboutUs.jsp
This page provides information about the organization.
4. SignIn.jsp
The login page where users can enter their credentials to log in.
5. SignUp.jsp
The sign-up page where new users can register.
   Explanation:
doPost Method:
This method is invoked when the login form is submitted.
It retrieves the username and password from the request.
A database connection is established using the DatabaseConnection utility class.
A PreparedStatement is created to query the visa table for the given username and password.
If a matching record is found (rs.next() returns true), authentication is successful.
A session is created and the username is stored in it.
User information is retrieved from the result set and displayed in an HTML table.
A "Log Out" link is provided.
If no matching record is found, an error message is set in the request, and the request is forwarded back to the SignIn.jsp page.
Finally, the database connection is closed.
6. Assign_3.java (Servlet)
This servlet handles the sign-up form submission and inserts the user data into the database.
Explanation:Servlet Initialization:
The servlet is annotated with @WebServlet("/Assign_3"), making it accessible at the URL pattern /Assign_3.
doGet Method:
The doGet method simply responds with the context path. It's not used for the registration process but is defined for completeness.
doPost Method:
The doPost method is triggered when the form is submitted.
It sets the response content type and gets a PrintWriter to write responses.
It then attempts to establish a database connection using a utility class DatabaseConnection.
A PreparedStatement is created to insert the form data into the visa table.
The form data is retrieved using request.getParameter() and set into the PreparedStatement.
The languages are handled as a comma-separated string since multiple checkboxes can be selected.
The statement is executed, and the connection is closed.
On success, a success message is displayed; otherwise, an error message is shown.
Application.java
This servlet handles the login form submission and validates the user credentials.
These servlets handle user registration and login, interacting with the database to store and validate user data, and providing appropriate responses based on the actions taken.
DatabaseConnection.java
This servlet handles the database connectivity, it has details about the localhost, database driver, username and password

Database Setup
  	Install MySQL and create a database named groupa_immigration.
  	Create a table named visa with the following structure:
CREATE TABLE visa (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    age INT,
    gender VARCHAR(10),
    email VARCHAR(50),
    visaType VARCHAR(20),
    immigrationReason TEXT,
    skills VARCHAR(100),
    language VARCHAR(100)
);

Configuration:
    Ensure you have a database connection utility class DatabaseConnection.java to handle the connection to the MySQL database.
    Update the database credentials in DatabaseConnection.java as needed.
    Add the mysql connector .jar file in the web deployment assembly of deployment assembly under properties of the project
    
Running the Project:
    Import the project into Eclipse.
    Ensure that your MySQL server is running, and the database is set up.
    Run the project on a server (e.g., Apache Tomcat).
    Access the application via http://localhost:8080/GroupAImmigrationServices.
    
Usage:
    Navigate to the Sign Up page to create a new account.
    Log in using the credentials created.
    View user details upon successful login.

