package StudentManagement;

import java.io.IOException;
import Student.Student;
import StudentService.StudentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		StudentService service=new StudentService();
		
		 Student st = new Student();
         st.setId(id);
         st.setName(name);
         st.setAge(age);
         
         int res=service.update(st);
         if(res>0) {
        	
             RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
             dispatcher.include(req, resp);
             resp.getWriter().print("Updated Suceesfull");
         }else {
        	 RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
             dispatcher.include(req, resp);
             resp.getWriter().print("Updated failed try again");         }
	}
}
