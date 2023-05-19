package demoJDBC;

import java.sql.*;

public class Demo2 {
	public static void main(String srgs[]) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/abc";
		String uname = "root";
		String pass = "Swaraj@2001";
		
		String query = "Select * from student";
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query); // this will give whole table
		//Prints whole table
		while(rs.next()) {
			String userdata =  rs.getInt(1) + " : " + rs.getString(2);
			
			System.out.println(userdata);
		}
		st.close();
		con.close();
	};

}
