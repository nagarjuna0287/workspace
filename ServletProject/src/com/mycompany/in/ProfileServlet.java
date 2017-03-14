package com.mycompany.in;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie ck[]=request.getCookies();
		if(ck!=null){
		String name=ck[0].getValue();
		if(!name.equals("")||name!=null){
			request.getRequestDispatcher("Link.html").include(request, response);
			out.print("<br>Hello"+name);
			out.print("<br>Welcome to Profile");
			
		}	
		}
		else{
			out.print("<br>Login First");
			request.getRequestDispatcher("Index.html").include(request, response);
		}
	}
}
