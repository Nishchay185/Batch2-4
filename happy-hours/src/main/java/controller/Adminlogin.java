package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.hub_dao;
import dto.Admindto;
@WebServlet("/Adminlogin")
	public class Adminlogin  extends GenericServlet{

		@Override
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	      String Email =req.getParameter("Email");
	      String password1=req.getParameter("password1");
	      PrintWriter writer=res.getWriter();
	      
	      hub_dao hd=new hub_dao();
	      Admindto dto=hd.Adminfindvalue(Email);
	     
	      if(dto!=null) { 
	    	  if(dto.getPassword1().equals(password1) && dto.getEmail().equals(Email)) {
	    		  RequestDispatcher dispatcher=req.getRequestDispatcher("fetchdetail.html");
	    		 dispatcher.forward(req, res);
	    		 res.setContentType("text/html");
	    	      writer.println("<h1>login sucessfull </h1><br><h1>welcome to homepage</h1>");
	    	  }else {
	    	
//				writer.println("please enter correct Email and password");
//				 RequestDispatcher dispatcher=req.getRequestDispatcher("Admin_logln.html");
//	    		 dispatcher.forward(req, res);
	    		 res.getWriter().println("please enter correct Email and password");
//	    		  req.setAttribute("errorMessage", "Invalid Email or password");
//	              RequestDispatcher rd= req.getRequestDispatcher("login.html");
//	              rd.forward(req, res); 
	    	  }
	      }else {
	    	  writer.println("no data found");
	      }
	      
			
		}

	}

