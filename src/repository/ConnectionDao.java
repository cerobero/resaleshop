package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

	
	public static Connection startConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/resale_shop";
		Connection con = DriverManager.getConnection(url,"root","hanbit");
		return con;
	}

	
	public static void closeConnection(Connection con) throws SQLException{
		if(con!=null){
			con.close();
			con=null;
		}
	}
}
