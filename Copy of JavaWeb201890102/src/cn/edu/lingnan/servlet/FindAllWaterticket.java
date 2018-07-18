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

public class FindAllWaterticket extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		waterticketDAO wt  = new waterticketDAO();
		Vector<waterticketDTO> v = new Vector<waterticketDTO>();
		v = wt.FindAllwaterticketInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allwaterticket", v);
		resp.sendRedirect("showAllWaterticket.jsp");
		
	}

}
