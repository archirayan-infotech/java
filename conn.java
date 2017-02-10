import java.sql.*;
import java.util.*;

public class conn {

	public static void main(String[] args) {
        // update connection string
		
 
		String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/opensou2_open_source_customization";
        String user = "admin";// add your db user id here
        String password = "admin";// add your db password here
 
        System.out.println("hello dude");
        Connection conn;
        try {
 
        	Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connected");

         
             CallableStatement cs = conn.prepareCall("select * from questions");
       //     cs.setInt(1, 2);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                System.out.println("Question Id : " + rs.getInt("id") + ", Title : "
                        + rs.getString("title") + ", Description : " + rs.getString("description"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }
 
}
