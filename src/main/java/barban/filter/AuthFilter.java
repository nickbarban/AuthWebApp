package barban.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter {
	
	private final static String LOGIN_REQUIRED = "user";
	private final static String PASSWORD_REQUIRED = "pwd";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request.getParameter("x-login").equals(LOGIN_REQUIRED)) {
			if (request.getParameter("x-pass").equals(PASSWORD_REQUIRED)) {
				request.setAttribute("x=login", "OK");
				request.setAttribute("x=pass", "OK");
			}
		}
		else {
			request.setAttribute("x=login", "NOT OK");
			request.setAttribute("x=pass", "NOT OK");
		}
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
