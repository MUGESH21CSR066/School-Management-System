package StudentManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Student.Student;
import StudentService.StudentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/getall")
public class Getall extends HttpServlet{
	String sort;
	List<Student>list;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 sort = req.getParameter("sort");
		StudentService service=new StudentService();
		
		if(sort!=null) {
			list=service.getAll(sort);
		}else {
			list=service.getAll();
		}
		
		
				
		req.setAttribute("studentList", list);
		RequestDispatcher r = req.getRequestDispatcher("getall.jsp");
		r.forward(req, resp);
		

	}

}
