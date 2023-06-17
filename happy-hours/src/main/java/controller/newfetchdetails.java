package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.hub_dao;
import dto.Sign_in_dto;
@WebServlet("/all")
public class newfetchdetails extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
       hub_dao hd=new hub_dao();
   	PrintWriter writer=res.getWriter();
//      hd.insert(si);
       List<Sign_in_dto> list= hd.fetchall();

     req.setAttribute("data", list);
     RequestDispatcher dispatcher=req.getRequestDispatcher("fetchall.jsp");
     dispatcher.forward(req,res);

}
}
