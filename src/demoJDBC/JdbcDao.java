package demoJDBC;

import java.sql.*;

class Student{
	public int rollno;
	public String name;
	public int marks;
	public int age;
}

class StudentDAO{
	
	String url = "jdbc:mysql://localhost:3306/abc";
	String uname = "root";
	String pass = "Swaraj@2001";
	
	public Student getStudent(int rollno) {
		String query = "Select name from student where rollno = " + rollno ;
		Student s = new Student();
		s.rollno = rollno;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			s.name = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
}

public class JdbcDao {
	public static void main(String args[]) {
		StudentDAO dao = new StudentDAO();
		Student s = dao.getStudent(6);
		System.out.println("Student is : " + s.name);		
	}
}
