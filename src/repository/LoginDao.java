package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.GoodsVo;
import vo.LoginVo;

public class LoginDao {

	private LoginDao() {}
	private static LoginDao instance = new LoginDao();
	public static LoginDao getInstance() {
		return instance;}
	
	private Connection con;
	
	public void startConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		if(con==null){
			String url = "jdbc:mysql://localhost:3306/resale_shop";
			con = DriverManager.getConnection(url,"root","hanbit");
		}
	}
	
	public int isMember(String id, String pwd) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
		String sql = "select * from user where user_id=? and user_pw=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			if(rs.next()){
				return 1;}
			else{return 0;}
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return -1;
		}finally {
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();con=null;}
			}catch(SQLException se){}
		}
	}
	
	public List<GoodsVo> itemStatus(String sid) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GoodsVo> result = new ArrayList<>();
		
		try{
		String sql = "select article_no,title,price,posting_date,soldout from article where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();

			while(rs.next()){
				GoodsVo goods = new GoodsVo();
				goods.setArticleNo(rs.getInt(1));
				goods.setTitle(rs.getString(2));
				goods.setPrice(rs.getInt(3));
				goods.setPostingDate(rs.getTimestamp(4));
				goods.setSoldout(rs.getInt(5));
				
				result.add(goods);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();con=null;}
			}catch (SQLException se){}
		}
		return result;
	}
	
	public int soldout(int anum) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try{
		String sql = "update article set soldout=1 where article_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, anum);
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally {
			try{
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();con=null;}
			}catch(SQLException se){}
		}return result;
	}
	
	public int delete(int anum) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try{
		String sql = "delete from article where article_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, anum);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			try{
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();con=null;}
			}catch (SQLException se){}
		}return result;
	}
}
