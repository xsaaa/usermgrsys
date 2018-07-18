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

public class UpdateUsersServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String usersID = req.getParameter("usersID");
		String usersName = req.getParameter("usersName");
		String flag = req.getParameter("flag");
		String password = req.getParameter("password");
		String superUsers = req.getParameter("superUsers");
		System.out.println("1. "+usersID+"  "+usersName+" "+password+" "+superUsers+" "+flag);
		
		usersDTO usto = new usersDTO();
		usersDAO usao = new usersDAO();
		usto.setUsersID(usersID);
		usto.setUsersName(usersName);
		usto.setPassword(password);
		usto.setSuperUsers(superUsers);
	    usto.setFlag(flag);
		
		boolean fl = usao.UpdateusersInfo(usto);
		Vector<usersDTO> v = new Vector<usersDTO>();
		v = usao.FindAllusersInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);	
		resp.sendRedirect("showAllUser.jsp");
	}
}
