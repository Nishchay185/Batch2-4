package dto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/login.in")
public class login extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
	        String Email=req.getParameter("Email");
	        String password1=req.getParameter("password1");
	        PrintWriter out=resp.getWriter();
	       try {
	    	   Class.forName("com.mysql.jdbc.Driver");
	    	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_hours_hub","root","ROOT");
	    	   PreparedStatement preparedStatement=con.prepareStatement("select* from happy_hours_hub.sign_in_dto where email=? and password1=?");
	    	   preparedStatement.setString(1,Email);
	    	   preparedStatement.setString(2, password1);
	    	   ResultSet rs=preparedStatement.executeQuery();
	    	   if(rs.next()) {
	    		 out.print("<html><body bgcolor='red'><center><h1>congrats login is Sucessesfull. Mr/Ms" +".!!"+rs.getString(1)+"</h1></center></body></html>");  
	    	   }else {
	    		   out.print("<html><body bgcolor='red'><center><h1> Invalid User Check Yout Email and pssword"+""+"</h1></center></body></html>");
	    		   
	    	   }
	    	   
	       }catch(ClassNotFoundException | SQLException e){
	    	   e.printStackTrace();
	    	   
	       }
}
}
