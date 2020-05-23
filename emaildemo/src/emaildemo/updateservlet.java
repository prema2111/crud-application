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
@WebServlet("/update")
public class updateservlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	student s=new student();
	List<student> l=new ArrayList();

	s.setRno(Integer.parseInt(req.getParameter("rno")));
	
	s.setName(req.getParameter("name"));
	s.setEmail(req.getParameter("email"));
	s.setUname(req.getParameter("uname"));
	s.setPass(req.getParameter("pass"));

	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
	Statement smt=con.createStatement();
	String sql="update student set name='"+s.getName()+"',email='"+s.getEmail()+"',uname='"+s.getUname()+"',pass='"+s.getPass()+"' where rno="+s.getRno();
	smt.executeUpdate(sql);
	
	
	Statement smt1=con.createStatement();
	
	String sql1="select * from student";
	ResultSet rs=smt1.executeQuery(sql1);
	while(rs.next())
	{
		student s1=new student();
		s1.setRno(rs.getInt("rno"));
		s1.setName(rs.getString("name"));
		s1.setEmail(rs.getString("email"));
		s1.setUname(rs.getString("uname"));
		s1.setPass(rs.getString("pass"));
     	l.add(s1);
		
	}
	req.setAttribute("data",l);
	
	RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
	rd.forward(req, res);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}

}
