package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.usersDAO;

public class NameCheckServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String usersName = req.getParameter("usersName");
		System.out.println("usersName:   "+usersName);
		usersDAO us = new usersDAO();
		boolean flag = us.findusersByUsersName(usersName);
		if(flag)
			resp.getWriter().print("true");
	}

}
