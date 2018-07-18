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

public class DeleteCheckWarehouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		warehouseDAO waao = new warehouseDAO();
		for(String a : arr)
		{
			String[] b = a.split(",");
			for(String c : b )
				//System.out.println("-----:  "+c );
				waao.deletewarehouseByuserstype(c);
		}
		
		Vector<warehouseDTO> v = new Vector<warehouseDTO>();
		v = waao.FindAllwarehouseInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allwarehouse", v);
		resp.sendRedirect("showAllWarehouse.jsp");
	}

}
