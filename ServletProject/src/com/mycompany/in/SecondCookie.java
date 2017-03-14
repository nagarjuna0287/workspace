package com.mycompany.in;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondCookie")
public class SecondCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
		Cookie []ck=request.getCookies();
			for(Cookie i:ck){
		out.println("Details are: "+i.getValue());
		out.print("</br>");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
