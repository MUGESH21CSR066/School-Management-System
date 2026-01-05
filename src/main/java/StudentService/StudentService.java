package StudentService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Student.Student;

public class StudentService {

    private static String url = "jdbc:postgresql://localhost:5432/college";
    private static String user = "postgres";
    private static String password = "123";

    static Connection con;
    String sql = "INSERT INTO student VALUES(?,?,?)";
    static {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int save(Student st) {
        int res = 0;
        String sql = "INSERT INTO student VALUES(?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, st.getId());
            pstm.setString(2, st.getName());
            pstm.setInt(3, st.getAge());

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


	public int update(Student student) {
		int res = 0;
        String sql = "UPDATE student set age=?,name=? where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, student.getAge());
            pstm.setString(2, student.getName());
            pstm.setInt(3, student.getId());
            

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
	}


	public int delete(Student studentd) {
		int res = 0;
        String sql = "DELETE from student where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
           
            pstm.setInt(1, studentd.getId());
            

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
	}

	public void select(Student students) {
		String sql = "SELECT * from student where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
           
            pstm.setInt(1, students.getId());
           ResultSet rs=pstm.executeQuery();
           while(rs.next()) {
			System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}


	public List<Student> getAll(String sort) {
	    List<Student> l = new ArrayList<Student>();
	    String sql = "SELECT * FROM student";
	    if ("name".equals(sort)) {
	        sql += " ORDER BY name";
	    }else if ("age".equals(sort)) {
	        sql += " ORDER BY age";
	    }

	    try {
	        PreparedStatement pstm = con.prepareStatement(sql);
	        ResultSet rs = pstm.executeQuery();

	        while (rs.next()) {
	            Student st = new Student();
	            st.setId(rs.getInt(1));      
	            st.setName(rs.getString(2)); 
	            st.setAge(rs.getInt(3));     

	            l.add(st);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return l;
	}
	public List<Student> getAll() {
	    List<Student> l = new ArrayList<Student>();
	    String sql = "SELECT * FROM student";
	    
	    try {
	        PreparedStatement pstm = con.prepareStatement(sql);
	        ResultSet rs = pstm.executeQuery();

	        while (rs.next()) {
	            Student st = new Student();
	            st.setId(rs.getInt(1));     
	            st.setName(rs.getString(2)); 
	            st.setAge(rs.getInt(3));     

	            l.add(st);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return l;
	}


	
}

