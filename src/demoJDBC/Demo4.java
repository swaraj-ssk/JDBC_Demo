package demoJDBC;

import java.sql.*;

public class Demo4 {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3306/abc";
		String uname = "root";
		String pass = "Swaraj@2001";
		//Prepared statement
		int userid = 8;
		String username = "Sachin";
		int marks = 100;
		int age = 23;
		
//		 No need to write String query = "insert into student values ("+userid+ ","+ username + ","+ marks +"," + age+")";
		String query = "insert into student values (?,?,?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		PreparedStatement st = con.prepareStatement(query); //PrepareStatment
		//set value in place of ? in sql
		st.setInt(1, userid);
		st.setString(2, username);
		st.setInt(3, marks);
		st.setInt(4, age);
		int count = st.executeUpdate(); //no need to mention query here
		
		System.out.println(count + " updated.");
		
		st.close();
		con.close();
	}

}
