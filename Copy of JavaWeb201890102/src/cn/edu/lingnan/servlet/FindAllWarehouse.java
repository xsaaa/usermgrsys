package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.billDAO;
import cn.edu.lingnan.dao.warehouseDAO;
import cn.edu.lingnan.dto.billDTO;
import cn.edu.lingnan.dto.warehouseDTO;

public class FindAllWarehouse extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		warehouseDAO wa  = new warehouseDAO();
		Vector<warehouseDTO> v = new Vector<warehouseDTO>();
		v = wa.FindAllwarehouseInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allwarehouse", v);
		resp.sendRedirect("showAllWarehouse.jsp");
	}

}
