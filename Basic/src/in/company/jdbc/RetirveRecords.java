package in.company.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class RetirveRecords {

	private static Scanner sc;

	public static void main(String[] args) throws SQLException,ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		//FileOutputStream fos=new FileOutputStream("F:\\data.doc");
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		sc = new Scanner(System.in);
		//System.out.println("Enter Student Name:");
		//String name=sc.nextLine();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from student");
				//if(rs.next()){
			while(rs.next()){
			//System.out.println("Name"+"  "+"Sid"+ "  "+"Marks");
			System.out.println(rs.getString(1)+"   "+rs.getInt(2)+"   "+rs.getInt(3));}
			//int i;
			//i=rs.getInt(2);
			//fos.write(i);
					//}
				}
		/*else{
			System.out.println("Student Record Does not exists");
		}*/
	}


