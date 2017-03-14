package in.company.jdbc;
import java.sql.*;

public class PreparedStatementDemo {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub

				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				//class.forName("oracle.jdbc.driver.OracleDriver()");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?)");
				pst.setString(1,"1060");
				pst.setString(2, "Charan");
				pst.setString(3, "80000");
				pst.executeQuery();
				System.out.println("Query Executed");
				con.close();
			}
}