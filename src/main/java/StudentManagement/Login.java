package StudentManagement;

import java.io.IOException;
import java.net.CookieStore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static String url = "jdbc:postgresql://localhost:5432/Login";
    private static String dbUser = "postgres";      
    private static String dbPassword = "123";

    static Connection con;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, dbUser, dbPassword);
            System.out.println("connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("user");
        String password = req.getParameter("password");

        try {
        	String sql = "SELECT * FROM public.\"Login\" WHERE \"User\" = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, username);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                String name = rs.getString("user");
                String pass = rs.getString("password");

                if (username.equals(name) && password.equals(pass)) {
                
                    RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                    dispatcher.forward(req, resp);

                } else {
                    resp.getWriter().write("Invalid Password");
                }
            } else {
                resp.getWriter().write("User not found");
            }
            
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

