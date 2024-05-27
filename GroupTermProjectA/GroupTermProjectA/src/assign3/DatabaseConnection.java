package assign3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	protected static Connection intializeDatabase()
		throws SQLException, ClassNotFoundException
	{
		String url = "jdbc:mysql://localhost:3306/";
		String db = "demo";
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);		
		Connection con = DriverManager.getConnection(url + db, "root", "9544");
		return con;
	}
}
