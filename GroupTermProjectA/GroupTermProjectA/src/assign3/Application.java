package assign3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Application")
public class Application extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Connection con = null;
        try {
            // Initialize database connection
            con = DatabaseConnection.intializeDatabase();
            PreparedStatement ps = con.prepareStatement("SELECT firstName, lastName, age, gender, email, visaType, immigrationReason, skills, language FROM visa WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

           if (rs.next()) {
    // Authentication successful
    HttpSession session = request.getSession();
    session.setAttribute("username", username);
    
    // Retrieve user information from the result set
    String firstName = rs.getString("firstName");
    String lastName = rs.getString("lastName");
    int age = rs.getInt("age");
    String gender = rs.getString("gender");
    String email = rs.getString("email");
    String visaType = rs.getString("visaType");
    String immigrationReason = rs.getString("immigrationReason");
    String skills = rs.getString("skills");
    String language = rs.getString("language");

    // Print out user information in a table format
    PrintWriter out = response.getWriter();
    out.println("<table border=\"1\" style=\"border-collapse: collapse; width: 100%; background-color:light-grey\">");
    out.println("<tr style=\"background-color: #f4f4f4;\"><th style=\"padding: 10px;\">Field</th><th style=\"padding: 10px;\">Value</th></tr>");
    out.println("<tr><td style=\"padding: 10px;\">First Name</td><td style=\"padding: 10px;\">" + firstName + "</td></tr>");
    out.println("<tr><td style=\"padding: 10px;\">Last Name</td><td style=\"padding: 10px;\">" + lastName + "</td></tr>");
    out.println("<tr><td style=\"padding: 10px;\">Age</td><td style=\"padding: 10px;\">" + age + "</td></tr>");
    out.println("<tr><td style=\"padding: 10px;\">Gender</td><td style=\"padding: 10px;\">" + gender + "</td></tr>");
    out.println("<tr><td style=\"padding: 10px;\">Email</td><td style=\"padding: 10px;\">" + email + "</td></tr>");
    out.println("<tr><td style=\"padding: 10px;\">Visa Type</td><td style=\"padding: 10px;\">" + visaType + "</td></tr>");
    out.println("<tr><td style=\"padding: 10px;\">Immigration Reason</td><td style=\"padding: 10px;\">" + immigrationReason + "</td></tr>");
    out.println("<tr><td style=\"padding: 10px;\">Skills</td><td style=\"padding: 10px;\">" + skills + "</td></tr>");
    out.println("<tr><td style=\"padding: 10px;\">Language</td><td style=\"padding: 10px;\">" + language + "</td></tr>");
    out.println("</table>");
    out.println("<p><a href='Home.jsp' style=\"text-decoration: none; color: #0056b3; padding: 10px; background-color: red; border: 1px solid #0056b3;\">Log Out</a></p>");

} else {
    // Authentication failed
    request.setAttribute("errorMessage", "Invalid Username or Password");
    request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
}


        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("SignIn.jsp");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}