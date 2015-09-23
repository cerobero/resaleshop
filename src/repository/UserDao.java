package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import vo.User;

public class UserDao
{
	private static UserDao instance = new UserDao();
	private Connection con;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/resale_shop";
	private static final String DB_ID = "root";
	private static final String DB_PW = "hanbit";
	
	private UserDao()
	{
		// Singleton
	}
	
	public static UserDao getInstance()
	{
		return instance;
	}
	
	public void startConnection()
	{
		if (con == null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void closeConnection()
	{
		if (con != null)
		{
			try
			{
				con.close();
				con = null;
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public User selectUser(String userId)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		
		String sql = "SELECT * FROM USER WHERE USER_ID=?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				user = new User();
				user.setUserId(rs.getString(1));
				user.setUserPw(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setUserPhone(rs.getString(4));
				user.setUserEmail(rs.getString(5));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
					pstmt = null;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if (rs != null)
			{
				try
				{
					rs.close();
					rs = null;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}
	
	public int insertUser(User user)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO USER VALUES(?, ?, ?, ?, ?)";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserPhone());
			pstmt.setString(5, user.getUserEmail());
			
			result = pstmt.executeUpdate();
		}
		catch (MySQLIntegrityConstraintViolationException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
					pstmt = null;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return result;
	}
}
