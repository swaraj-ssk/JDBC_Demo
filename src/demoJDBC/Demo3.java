package demoJDBC;

import java.sql.*;

public class Demo3 {
	public static void main(String srgs[]) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/abc";
		String uname = "root";
		String pass = "Swaraj@2001";
		
		String query = "insert into student values (7, 'Mayur', 10, 24)";
		//delete from student where marks=100
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		int count = st.executeUpdate(query);
		
		System.out.println(count + " updated.");
		
		st.close();
		con.close();
	}

}
