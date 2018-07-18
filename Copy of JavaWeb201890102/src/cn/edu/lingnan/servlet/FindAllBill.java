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

public class FindAllBill extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	       // System.out.println("222222");
	        billDAO bi = new billDAO();
			Vector<billDTO> v = new Vector<billDTO>();
			v = bi.FindAllbillInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allbill", v);
			resp.sendRedirect("showAllBill.jsp");
	}

}
