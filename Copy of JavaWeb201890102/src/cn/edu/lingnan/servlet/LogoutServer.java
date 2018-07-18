package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.usersDAO;
import cn.edu.lingnan.dto.usersDTO;

public class LogoutServer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   System.out.println("�Ѿ�ע���ˡ�������");
			HttpSession s = req.getSession();
			s.invalidate();
			resp.sendRedirect(req.getContextPath()+"/index.html");
	
	}
}
