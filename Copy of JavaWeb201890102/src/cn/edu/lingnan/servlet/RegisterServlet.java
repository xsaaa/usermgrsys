package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.usersDAO;
import cn.edu.lingnan.dto.usersDTO;

public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.从页面获取我们想要的数据,5个
        String usersID = req.getParameter("usersID");
		String usersName = req.getParameter("usersName");
		String password = req.getParameter("password");
		String superUsers = req.getParameter("superUsers");
		String flag = req.getParameter("flag");
		System.out.println("1. "+usersID+"  "+usersName+" "+superUsers+" "+password+" "+flag);
		
		//2.调用后台的业务逻辑去判断这个用户名和密码是否存在且对应
		usersDAO us = new usersDAO(); 
		usersDTO usto = new usersDTO();
		usto.setUsersID(usersID);
		usto.setUsersName(usersName);
		usto.setPassword(password);
		usto.setSuperUsers(superUsers);
	    usto.setFlag(flag);
		boolean flag1 = us.InsertusersInfo(usto);
		//3.根据结果到相应的页面
		if(flag1)
			resp.sendRedirect(req.getContextPath()+"/index.html");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
}

}
