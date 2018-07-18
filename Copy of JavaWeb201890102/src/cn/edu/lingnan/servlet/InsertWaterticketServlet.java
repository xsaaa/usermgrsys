package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.waterticketDAO;
import cn.edu.lingnan.dto.waterticketDTO;

public class InsertWaterticketServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        String waID = null;
        String type = null;
        String price = null;
        String flag = null;
        waID = req.getParameter("waID");
        type = req.getParameter("type");
        price = req.getParameter("price");
        flag = req.getParameter("flag");
		waterticketDAO wt = new waterticketDAO();
		waterticketDTO wtto = new waterticketDTO();
		wtto.setWaID(waID);
		wtto.setType(type);
		wtto.setPrice(price);
		wtto.setFlag(flag);
		boolean fl = wt.InsertwaterticketInfo(wtto);
		if(fl)
			resp.sendRedirect(req.getContextPath()+"/admin/showAllWaterticket.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
		
	}

}
