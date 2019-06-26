package hu.ipass;

import java.io.*;

import javax.servlet.ServletException;

import javax.servlet.http.*;

import hu.persistence.PersoonsGegevensPostgresDaoImpl;

public class DynamicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {

		String name = req.getParameter("username");


		PersoonsGegevensPostgresDaoImpl myDao = new PersoonsGegevensPostgresDaoImpl();
		System.out.println(myDao.selectGegevens());
		
		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");

		out.println("<!DOCTYPE html>");

		out.println("<html>");

		out.println(" <title>Dynamic Example</title>");

		out.println(" <body>");

		out.println(" <h2>Dynamic webapplication example</h2>");

		out.println(" <h2>Hello " + name + "!</h2>");

		out.println(" </body>");

		out.println("</html>");

	}
}

