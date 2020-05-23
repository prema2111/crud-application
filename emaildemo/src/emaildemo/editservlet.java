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
@WebServlet("/edit")
public class editservlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int rno=Integer.parseInt(req.getParameter("rno"));
		student s=new student();
	

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
		Statement smt=con.createStatement();
		String sql="select * from student where rno="+rno;
		ResultSet rs=smt.executeQuery(sql);
		if(rs.next())
		{
			
			s.setRno(rs.getInt("rno"));
			s.setName(rs.getString("name"));
			s.setEmail(rs.getString("email"));
			s.setUname(rs.getString("name"));
			s.setPass(rs.getString("pass"));
	     
		
		}
		
		
		
				req.setAttribute("student", s);
				RequestDispatcher rd=req.getRequestDispatcher("edit.jsp");
				rd.forward(req,res);
	
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
}