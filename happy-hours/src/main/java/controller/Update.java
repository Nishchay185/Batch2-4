package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.hub_dao;
import dto.Sign_in_dto;
@WebServlet("/UpdateData")

public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = (String) req.getSession().getAttribute("Email");
		System.out.println("email id: " + email);
		String Fname = req.getParameter("Fname");
		System.out.println("Name " + Fname);
		
		
		hub_dao hd=new hub_dao();
		hd.upDate(email,Fname);
	  
		 List<Sign_in_dto> list= hd.fetchall();

	     req.setAttribute("data", list);
	     RequestDispatcher dispatcher=req.getRequestDispatcher("fetchall.jsp");
	     dispatcher.forward(req,res);
	}

}
