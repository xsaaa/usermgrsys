package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.billDAO;
import cn.edu.lingnan.dto.billDTO;

public class InsertBillServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String usersID = null;
        String price = null;
        String flag = null;
        String waID = null;
        usersID = req.getParameter("usersID");
        price = req.getParameter("price");
        flag = req.getParameter("flag");
        waID = req.getParameter("waID");
		billDAO bi = new billDAO();
		billDTO bito = new billDTO();
		
		bito.setUsersID(usersID);
		bito.setPrice(price);
		bito.setFlag(flag);
		bito.setWaID(waID);
		boolean fl = bi.InsertbillInfo(bito);
		if(fl)
			resp.sendRedirect(req.getContextPath()+"/admin/showAllWaterticket2.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");

	}

}
