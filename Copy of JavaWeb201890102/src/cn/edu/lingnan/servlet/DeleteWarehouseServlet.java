package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.warehouseDAO;
import cn.edu.lingnan.dto.warehouseDTO;

public class DeleteWarehouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String type = req.getParameter("type");
		warehouseDAO wa = new warehouseDAO();
		boolean flag = wa.deletebillBytype(type);
		
		Vector<warehouseDTO> v = new Vector<warehouseDTO>();
		v = wa.FindAllwarehouseInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allwarehouse", v);
		
		resp.sendRedirect("showAllWarehouse.jsp");
	}

}
