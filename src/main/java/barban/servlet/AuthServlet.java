package barban.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<String> headers = Collections.list(req.getHeaderNames());
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html>\n"
				+ "<html><head><title>A servlet for passing authentication</title></head>\n"
				+ "<body bgcolor=\"#fdf5e5\">\n"
				+ "<h1>Message:</h1>\n");
		
		for (String header : headers) {
			out.write("<p>" + header + " :: " + req.getHeader(header) + "</p>\n");
		}
		out.write("<p>headers END</p>\n");
		
		String login = req.getParameter("x-login");
		String pass = req.getParameter("x-pass");
		out.write("<p>Login:" + login + "</p>");
		out.write("<p>Password:" + pass + "</p>");
		out.write("<p>" + req.getAttribute("x-login") + "</p>");
		out.write("<p>" + req.getAttribute("x-pass") + "</p>");
		out.write("</body></html>");
		//out.close();
	}

}
