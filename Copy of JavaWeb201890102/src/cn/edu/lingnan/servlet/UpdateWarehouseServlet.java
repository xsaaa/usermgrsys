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

public class UpdateWarehouseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String type = req.getParameter("type");
		String amount = req.getParameter("amount");
		String price = req.getParameter("price");
		String flag = req.getParameter("flag");

		
       System.out.println("1. "+type+"  "+amount+" "+price+" "+flag);
		
		warehouseDTO wato = new warehouseDTO();
		warehouseDAO waao = new warehouseDAO();
		wato.setType(type);
		wato.setAmount(amount);
		wato.setPrice(price);
		wato.setFlag(flag);
		
		boolean fl = waao.UpdateWarehouseInfo(wato);
		Vector<warehouseDTO> v = new Vector<warehouseDTO>();
		v = waao.FindAllwarehouseInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allwarehouse", v);	
		resp.sendRedirect("showAllWarehouse.jsp");
    
	}

}
