package stu.school.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement stmt;
	 Connection con;
	 ResultSet rs;
		
     
 	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		stmt=con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("user");
		
		Cookie ck=new Cookie("user",type);
			response.addCookie(ck);
			ck=new Cookie("username",username);
			response.addCookie(ck);
			//Cookie ck1[]=request.getCookies();
			String query=" ";
		if(type.equals("Admin")&&type!=null){
			query="select * from adminusers where  username='"+username+"' and password ='"+password+"'";
			
			try {
				rs= stmt.executeQuery(query);
			
				if(rs.next()){
					request.getRequestDispatcher("AdminLinks.html").include(request, response);
					  }
				else{
					request.getRequestDispatcher("Index.html").include(request, response);
					out.println("<h1>Invalid entry</h1>");
				}
			} catch (SQLException e) {
				
				out.print("Invalid entry");
			}
			}
			else if(type.equals("Student")&&type!=null){
				query="select * from users where  username='"+username+"' and password ='"+password+"'";
			
			try {
				rs= stmt.executeQuery(query);
			
				if(rs.next()){
					request.getRequestDispatcher("StudentLinks.html").include(request, response);
					  }
				else{
					request.getRequestDispatcher("Index.html").include(request, response);
					out.println("<h1>Invalid entry</h1>");
				}
				}catch (SQLException e) {
				
					out.print("Invalid entry");
			}
			  
		   }else
			{
				out.println("<h1>Invalid entry</h1>");
			}
	}

}
