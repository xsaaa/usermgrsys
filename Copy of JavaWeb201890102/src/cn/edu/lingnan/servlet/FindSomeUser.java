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

public class FindSomeUser extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		String id = (String)s.getAttribute("usersID");
		usersDAO usao = new usersDAO();
		Vector<usersDTO> v = new Vector<usersDTO>();
		v = usao.findusersByUsersID(id);
		s.setAttribute("alluser", v);
		resp.sendRedirect("showAllUser2.jsp");
	}

}
