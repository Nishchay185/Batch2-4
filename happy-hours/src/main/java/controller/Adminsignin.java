package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.hub_dao;
import dto.Admindto;

@WebServlet("/Admin")
public class Adminsignin extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 String First_name=req.getParameter("First_name");
			 String Last_name=req.getParameter("Last_name");
			 String Email=req.getParameter("Email");
			 String s1=req.getParameter("Contact_no");
		      long Contact_no=Long.parseLong(s1);
		      String password1=req.getParameter("password1");
		      String conform_password=req.getParameter("conform_password");
		      String Above_18=req.getParameter("Above_18");
		      
		      Admindto ad=new Admindto();
		      ad.setFirst_name(First_name);
		      ad.setLast_name(Last_name);
		      ad.setEmail(Email);
		      ad.setContact_no(Contact_no);
		      ad.setPassword1(password1);
		      ad.setConform_password(conform_password);
		      ad.setAbove_18(Above_18);
		      
		      hub_dao hd=new hub_dao();
		      hd.Admininsert(ad);
		      
		      resp.setContentType("text/html");
		      resp.getWriter().print("<h1>Registered successfully</h1>");
		      
		      RequestDispatcher dispatcher=req.getRequestDispatcher("Admin_login.html");
		      dispatcher.forward(req, resp);
		      
		      resp.getWriter().print("<h1>Registered successfully</h1>");
		      
			}
		}

