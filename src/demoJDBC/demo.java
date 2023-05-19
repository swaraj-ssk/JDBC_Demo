package demoJDBC;

import java.sql.*;


public class demo {
	public static void main(String srgs[]) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/abc";
		String uname = "root";
		String pass = "Swaraj@2001";
		
		String query = "Select name from student where rollno=2";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query); // this will give whole table
		rs.next();
		String name = rs.getString("name");
		
		System.out.println(name);
		
		st.close();
		con.close();
	};
}
