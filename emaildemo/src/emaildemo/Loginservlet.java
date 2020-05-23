package emaildemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student;
@WebServlet("/Log")
public class Loginservlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List<student> l=new ArrayList<>();
	student s1=new student();
		s1.setUname(req.getParameter("uname"));
		s1.setPass(req.getParameter("pass"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
		Statement smt=con.createStatement();
		
		if(s1.getUname().equals("admin") && s1.getPass().equals("admin"))
		{
		String sql="select * from student";
		ResultSet rs=smt.executeQuery(sql);
		while(rs.next())
		{
			student s=new student();
			s.setRno(rs.getInt("rno"));
			s.setName(rs.getString("name"));
			s.setEmail(rs.getString("email"));
			s.setUname(rs.getString("name"));
			s.setPass(rs.getString("pass"));
	     	l.add(s);
			
		}
		
		
		System.out.println("saved data");
				req.setAttribute("data", l);
				RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
				rd.forward(req,res);
		}
		else
		{
           System.out.println("not present");
           
        
   		
		}

		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}

			
		
	
		
		
	


