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

public class DeleteCheckWaterticketServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		waterticketDAO wtao = new waterticketDAO();
		for(String a : arr)
		{
			String[] b = a.split(",");
			for(String c : b )
				//System.out.println("-----:  "+c );
				wtao.deleteticketBywaID(c);
		}
		
		Vector<waterticketDTO> v = new Vector<waterticketDTO>();
		v = wtao.FindAllwaterticketInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allwaterticket", v);
		resp.sendRedirect("showAllWaterticket.jsp");
	}

}
