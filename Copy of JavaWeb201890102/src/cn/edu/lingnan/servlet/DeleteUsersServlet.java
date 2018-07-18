package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.usersDAO;
import cn.edu.lingnan.dto.usersDTO;


public class DeleteUsersServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String usersID = req.getParameter("usersID");
		usersDAO us = new usersDAO();
		boolean flag = us.deleteusersByusersID(usersID);
		
		Vector<usersDTO> v = new Vector<usersDTO>();
		v = us.FindAllusersInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);	
		resp.sendRedirect("showAllUser.jsp");
	}
}
