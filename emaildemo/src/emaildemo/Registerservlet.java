
package emaildemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student;
@WebServlet("/reg")
public class Registerservlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		student s=new student();
		
		s.setName(req.getParameter("name"));
		s.setEmail(req.getParameter("email"));
		s.setUname(req.getParameter("uname"));
		s.setPass(req.getParameter("pass"));
	
			
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
		Statement smt=con.createStatement();
		String sql="insert into student(name,email,uname,pass) values('"+s.getName()+"','"+s.getEmail()+"','"+s.getUname()+"','"+s.getPass()+"')";
		smt.execute(sql);
		
		
		System.out.println("Saved data");
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, res);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
