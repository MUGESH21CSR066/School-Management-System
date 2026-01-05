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

@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("userid"));
		
		StudentService service=new StudentService();
		
		 Student st = new Student();
         st.setId(id);
       
         int res=service.delete(st);
         if(res>0) {
        	
             RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
             dispatcher.include(req, resp);
             resp.getWriter().print("Deleted Suceesfull");
         }else {
        	 RequestDispatcher dispatcher=req.getRequestDispatcher("Delete.jsp");
             dispatcher.include(req, resp);
             resp.getWriter().print("Delete failed try again");         }
	} 
}
