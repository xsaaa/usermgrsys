package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
	// �жϵ�¼�û���Ȩ����ʲô������ǳ����û���1������ô����ȥ��adminĿ¼�µ�ҳ�棬����ȥȨ�޴���ҳ��
		
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
		HttpSession s = req.getSession();
		Integer superValue = (Integer)s.getAttribute("superValue");
		System.out.println("---3---"+superValue);
		if(superValue!=null){
		if(superValue==0 )
		{
			System.out.println("---4---");
			resp.sendRedirect(req.getContextPath()+"/index.html");
		}
		else
			if(superValue==1)
				arg2.doFilter(arg0, arg1);
			if(superValue==2)
				//resp.sendRedirect(req.getContextPath()+"/admin/admin2.html");
		        arg2.doFilter(arg0, arg1);
	    }else
		resp.sendRedirect(req.getContextPath()+"/index.html");
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
