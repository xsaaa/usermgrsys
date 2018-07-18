package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.billDAO;
import cn.edu.lingnan.dto.billDTO;

public class DeleteCheckbillServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		billDAO biao = new billDAO();
		for(String a : arr)
		{
			String[] b = a.split(",");
			for(int i = 0;i < b.length;i=i+2)
			{
				String usersID = b[i];
				String waID = b[i+1];
				biao.deletebillByusersIDandWaID(usersID, waID);
    			System.out.println("  "+usersID+"  "+waID);
    		}
//			for(String c : b )
//				//System.out.println("-----:  "+c );
//				biao.deletebillByusersID(c);
		}
		
		Vector<billDTO> v = new Vector<billDTO>();
		v = biao.FindAllbillInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allbill", v);
		resp.sendRedirect("showAllBill.jsp");
	}

}
