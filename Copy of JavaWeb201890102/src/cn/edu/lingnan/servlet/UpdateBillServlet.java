package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.billDAO;
import cn.edu.lingnan.dao.usersDAO;
import cn.edu.lingnan.dto.billDTO;
import cn.edu.lingnan.dto.usersDTO;

public class UpdateBillServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
		String usersID = req.getParameter("usersID");
		String price = req.getParameter("price");
		String flag = req.getParameter("flag");
		String waID = req.getParameter("waID");
		
       System.out.println("1. "+usersID+" "+price+" "+flag+" "+waID);
		
		billDTO bito = new billDTO();
		billDAO biao = new billDAO();
		bito.setUsersID(usersID);
		bito.setPrice(price);
		bito.setFlag(flag);
		bito.setWaID(waID);
		
		boolean fl = biao.UpdateBillInfo(bito);
		Vector<billDTO> v = new Vector<billDTO>();
		v = biao.FindAllbillInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allbill", v);	
		resp.sendRedirect("showAllBill.jsp");
    }

}
