package stu.school.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewStudents")
public class ViewStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
	
     
    	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
		} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
		}
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Cookie ck[]=request.getCookies();
		if(ck!=null){
			String name=ck[0].getValue();
				if(!name.equals("") && name.equals("Student")){
				request.getRequestDispatcher("StudentLinks.html").include(request, response);
				}
			else if(!name.equals("")&& name.equals("Admin")){
				request.getRequestDispatcher("AdminLinks.html").include(request, response);
			}
			}
		try {
			out.print("</br>");
			out.print("</br>");
			Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery("select * from student");
					while(rs.next()){
						out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
						out.print("</br>");
						
					}
					
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

}
