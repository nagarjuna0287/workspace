import java.sql.*;
        public class FindRecords{
        public static void main(String[] args)throws SQLException{
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
        CallableStatement cstmt = con.prepareCall("{? = call addition(?,?)}");
        cstmt.registerOutParameter(1,Types.INTEGER);
        cstmt.setInt(2,20);
        cstmt.setInt(3,30);
        cstmt.execute();
        int sum = cstmt.getInt(1);
        System.out.println(sum);
                  }
        }
