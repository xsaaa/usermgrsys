package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.usersDAO;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.从页面获取我们想要的数据
		String _usersID = req.getParameter("usersID");
		String _password = req.getParameter("password");
		System.out.println("1. "+_usersID+"   "+_password);
		
		//2.调用后台的业务逻辑去判断这个用户名和密码是否存在且对应
		usersDAO us = new usersDAO(); 
		int superValue = us.findusersByUsersIDandPassword(_usersID, _password);
		System.out.println("----2 ----"+superValue);
		HttpSession s = req.getSession();
		s.setAttribute("superValue", superValue);
		s.setAttribute("usersID", _usersID);
		//3.根据结果到相应的页面
		System.out.println("3."+req.getContextPath());
		if(superValue!=0)
		{
			if(superValue==1){
			    resp.sendRedirect(req.getContextPath()+"/admin/admin.html");}
			if(superValue==2){
				resp.sendRedirect(req.getContextPath()+"/admin/admin2.html");}
		}
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}
}
