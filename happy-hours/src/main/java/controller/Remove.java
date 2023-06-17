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

@WebServlet("/delete")
public class Remove extends HttpServlet {

	// @Override
	// protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// // super.doPost(req, resp);
	// String email = req.getParameter("Email");
	// System.out.println(email);
	//
	// }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("Email");
		System.out.println(email);
		hub_dao hd=new hub_dao();
		hd.DeleteClick(email);
		
		 List<Sign_in_dto> list= hd.fetchall();

	     req.setAttribute("data", list);
	     RequestDispatcher dispatcher=req.getRequestDispatcher("fetchall.jsp");
	     dispatcher.forward(req,res);
	}
}
