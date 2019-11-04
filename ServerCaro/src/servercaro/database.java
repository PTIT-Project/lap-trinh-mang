package servercaro;

import java.sql.*;

public class database {
	public Connection con;
	public PreparedStatement pst;
	private ResultSet rs;

	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "31101998";
	public static final String DB_NAME = "caro";
	

	public database() {
		try {

			// MAKE SURE YOU KEEP THE mysql_connector.jar file in java/lib folder
			// ALSO SET THE CLASSPATH
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/caro", DB_USERNAME, DB_PASSWORD);
			pst = con.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ip:username,password
	// return boolean
	public Boolean checkLogin(String uname, String pwd) {
		try {

			pst.setString(1, uname); // this replaces the 1st "?" in the query for username
			pst.setString(2, pwd); // this replaces the 2st "?" in the query for password
			// executes the prepared statement
			rs = pst.executeQuery();
			if (rs.next()) {
				// TRUE if the query founds any corresponding data
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("error while validating" + e);
			return false;
		}
	}
}