package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.usersDAO;
import cn.edu.lingnan.dto.usersDTO;

public class DeleteCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		usersDAO usao = new usersDAO();
		for(String a : arr)
		{
			String[] b = a.split(",");
			for(String c : b )
				//System.out.println("-----:  "+c );
				usao.deleteusersByusersID(c);
//				for(int i = 0;i < b.length;i=i+2)
//				{
//					String usersID = b[i];
//					String waID = b[i+1];
//					usao.deleteusersByusersID(usersID, waID);
//					System.out.println("  "+usersID+"  "+waID);
//				}
			
		}
		
		Vector<usersDTO> v = new Vector<usersDTO>();
		v = usao.FindAllusersInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("showAllUser.jsp");
	}

}
