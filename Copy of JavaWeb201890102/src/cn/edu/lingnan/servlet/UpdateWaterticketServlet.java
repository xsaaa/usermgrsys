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

public class UpdateWaterticketServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String waID = req.getParameter("waID");
		String type = req.getParameter("type");
		String price = req.getParameter("price");
		String flag = req.getParameter("flag");

		
       System.out.println("1. "+waID+"  "+type+"  "+price+" "+flag);
		
		waterticketDTO wtto = new waterticketDTO();
		waterticketDAO wtao = new waterticketDAO();
		wtto.setWaID(waID);
		wtto.setType(type);
		wtto.setPrice(price);
		wtto.setFlag(flag);
		boolean fl = wtao.UpdateWaterticketInfo(wtto);
		Vector<waterticketDTO> v = new Vector<waterticketDTO>();
		v = wtao.FindAllwaterticketInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allwaterticket", v);	
		resp.sendRedirect("showAllWaterticket.jsp");
    
	}

}
