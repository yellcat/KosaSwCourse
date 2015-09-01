package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet4 extends HttpServlet {
	private String param1;
	public HelloWorldServlet4() {
		System.out.println("4");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		param1 = config.getInitParameter("greet");
		System.out.println(param1);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서비스" + param1);
	}
	@Override
	public void destroy() {
		System.out.println("꿱.");
	}

}
