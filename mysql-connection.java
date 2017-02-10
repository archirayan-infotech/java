import java.sql.*;
import java.util.*;

public class conn {

	public static void main(String[] args) {
 		
 
		String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sql";
        String user = "root";// add your db user id here
        String password = "root";// add your db password here
 
         Connection conn;
        try {
 
        	Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connected");

         
             CallableStatement cs = conn.prepareCall("select * from employee");
 
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                System.out.println("  Id : " + rs.getInt("id") + ", name : "
                        + rs.getString("name") + ", address : " + rs.getString("address"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }
 
}
