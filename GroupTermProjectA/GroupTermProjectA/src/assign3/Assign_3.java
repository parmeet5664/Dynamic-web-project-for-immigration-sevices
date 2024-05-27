package assign3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assign_3
 */
@WebServlet("/Assign_3")
public class Assign_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assign_3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    try {
	        Connection con = DatabaseConnection.intializeDatabase();

	        PreparedStatement st = con.prepareStatement("INSERT INTO visa (username, password,firstName, lastName, age, gender, email, visaType, immigrationReason, skills, language) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        st.setString(1, request.getParameter("username"));
	        st.setString(2, request.getParameter("password"));
	        st.setString(3, request.getParameter("firstName"));
	        st.setString(4, request.getParameter("lastName"));
	        st.setInt(5, Integer.parseInt(request.getParameter("age")));
	        st.setString(6, request.getParameter("gender"));
	        st.setString(7, request.getParameter("email"));
	        st.setString(8, request.getParameter("visaType"));
	        st.setString(9, request.getParameter("immigrationReason"));
	        st.setString(10, request.getParameter("skills"));
	        
	        // Handling multiple checkbox values for languages
	        String[] languageValues = request.getParameterValues("language");
	        String languages = (languageValues != null) ? String.join(", ", languageValues) : "";
	        st.setString(11, languages);
	        
	        st.executeUpdate();
	        
	        st.close();
	        con.close();
	        
	        out.println("<html><body><b>Successfully Registered!</b></body></html>");
	        out.println("<a href='SignIn.jsp'>Go to Sign In page</a>");
	    } catch (Exception e) {
	        out.println("<html><body><b>Error occurred: " + e.getMessage() + "</b></body></html>");
	        e.printStackTrace();
	    

	    } finally {
	        out.close();
	    }
	}
	}