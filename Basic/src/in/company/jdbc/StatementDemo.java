package in.company.jdbc;

import java.sql.*;


public class StatementDemo {

	public static void main(String[] args)throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		Statement st=con.createStatement();
		//st.executeUpdate("create table employee(empid number(10),ename varchar2(20),esal number(10))");
		st.executeUpdate("insert into employee values(1050,'Nagarjuna',90000)");
		con.close();
	}
}
