package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.warehouseDAO;
import cn.edu.lingnan.dto.warehouseDTO;

public class InsertWarehouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String type = null;
        String amount = null;
        String price = null;
        String flag = null;
     
        type= req.getParameter("type");
        amount = req.getParameter("amount");
        price = req.getParameter("price");
        flag = req.getParameter("flag");
		warehouseDAO wa = new warehouseDAO();
		warehouseDTO wato = new warehouseDTO();
		
		wato.setType(type);
		wato.setAmount(amount);
		wato.setPrice(price);
		wato.setFlag(flag);
		boolean fl = wa.InsertwarehouseInfo(wato);
		if(fl)
			resp.sendRedirect(req.getContextPath()+"/admin/showAllWarehouse.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}

}
