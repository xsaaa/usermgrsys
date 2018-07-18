package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.billDAO;
import cn.edu.lingnan.dto.billDTO;

public class FindSomeBill extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		String id = (String)s.getAttribute("usersID");
		billDAO bi = new billDAO();
		Vector<billDTO> v = new Vector<billDTO>();
		v = bi.findBillByUsersID(id);
		s.setAttribute("allbill", v);
		resp.sendRedirect("showAllBill2.jsp");
		
	}

}
