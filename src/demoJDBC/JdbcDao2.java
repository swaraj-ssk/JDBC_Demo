package demoJDBC;

import java.sql.*;

class StudentNew{
	public int rollno;
	public String name;
	public int marks;
	public int age;
}

class StudentDAO2{
	
	String url = "jdbc:mysql://localhost:3306/abc";
	String uname = "root";
	String pass = "Swaraj@2001";
	Connection con = null;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, uname, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
	
	public StudentNew getStudent(int rollno) {
		String query = "Select name from student where rollno = " + rollno ;
		StudentNew s = new StudentNew();
		s.rollno = rollno;
	
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			s.name = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}

	public void addStudent(StudentNew s) {
		String query = "insert into student values (?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, s.rollno);
			st.setString(2, s.name);
			st.setInt(3, s.marks);
			st.setInt(4, s.age);
			int count = st.executeUpdate();
			
			System.out.println("Updated "+count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
public class JdbcDao2 {

	public static void main(String[] args) {
		//insert into table
		StudentNew s = new StudentNew();
		s.age = 19;
		s.name = "Aryan";
		s.marks = 55;
		s.rollno = 9;
		StudentDAO2 dao = new StudentDAO2();
		dao.connect();
		dao.addStudent(s);

	}

}
