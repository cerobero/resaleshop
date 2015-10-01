package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.ItemArticle;
import vo.User;

public class ItemInfoDao {
	private ItemInfoDao(){}
	private static ItemInfoDao instance = new ItemInfoDao();
	public static ItemInfoDao getInstance(){
		return instance;
	}
	///////////////////////////////////////////////////////
	//DB 관련 문자열 상수
	private final String DB_DRIVER="com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/resale_shop";
	private final String DB_ID = "root";
	private final String DB_PW = "hanbit";

	///////////////////////////////////////////////////////
	private Connection con;
	public void startConnection() throws ClassNotFoundException, SQLException{
		if(con==null){
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
		}
	}
	public void closeConnection() throws SQLException{
		if(con!=null){
			con.close();
			con = null;
		}
	}

	//총 아티클 수
	public int getTotalArticleNum( ){
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql="select count(*) from user, category , article  "
					+" where user.user_id= article.user_id"
					+" and  article.category_id= category.category_id";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getTotalArticleNum 에러");
		} finally{
			if(rs!=null){try{rs.close();}catch(SQLException e){}}
			if(stmt!=null){try{stmt.close();}catch(SQLException e){}}
		}
		return result;
	}

	//상품리스트
	public List<ItemArticle> getItemArticleList(int startRow, int endRow){
		Statement stmt = null;
		ResultSet rs = null;
		List<ItemArticle> itemArticleList = new ArrayList<ItemArticle>();
		String sql="select * from user, category , article  "
					+" where user.user_id= article.user_id"
					+" and  article.category_id= category.category_id"
					+" order by article_no desc limit "+startRow+","+endRow+" ;";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				ItemArticle itemArticle = new ItemArticle();
				itemArticle.setUserId(rs.getString("user_id"));
				itemArticle.setUserPw(rs.getString("user_pw"));
				itemArticle.setUserName(rs.getString("user_name"));
				itemArticle.setUserPhone(rs.getString("user_phone"));
				itemArticle.setUserEmail(rs.getString("user_email"));
				itemArticle.setCategoryId(rs.getInt("category_id"));
				itemArticle.setCategoryName(rs.getString("category_name"));
				itemArticle.setArticleNo(rs.getInt("article_no"));
				itemArticle.setTitle(rs.getString("title"));
				itemArticle.setPrice(rs.getInt("price"));
				itemArticle.setReadCount(rs.getInt("read_count"));
				itemArticle.setPostingDate(rs.getDate("posting_date"));
				itemArticle.setPremiume(rs.getInt("premiume"));
				itemArticle.setPhoto(rs.getString("photo"));
				itemArticle.setContent(rs.getString("content"));
				itemArticle.setSoldout(rs.getInt("soldout"));
				itemArticleList.add(itemArticle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getItemArticleList 에러");
		} finally{
			if(rs!=null){try{rs.close();}catch(SQLException e){}}
			if(stmt!=null){try{stmt.close();}catch(SQLException e){}}
		}
		return itemArticleList;
	}

	//조회수 증가
	public int updateReadCount(int articleNo){
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "update article set read_count=read_count+1 where article_no= "+articleNo;
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updateReadCount 에러");
		} finally{
			if(rs!=null){try{rs.close();}catch(SQLException e){}}
			if(stmt!=null){try{stmt.close();}catch(SQLException e){}}
		}
		return result;
	}

	//상품정보 페이지
	public ItemArticle selectItemArticle(int articleNo){
		Statement stmt = null;
		ResultSet rs = null;
		ItemArticle itemArticle = new ItemArticle();
		String sql="select * from user, category , article  "
				+" where user.user_id= article.user_id"
				+" and  article.category_id= category.category_id and article_no =" + articleNo;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				itemArticle.setUserId(rs.getString("user_id"));
				itemArticle.setUserPw(rs.getString("user_pw"));
				itemArticle.setUserName(rs.getString("user_name"));
				itemArticle.setUserPhone(rs.getString("user_phone"));
				itemArticle.setUserEmail(rs.getString("user_email"));
				itemArticle.setCategoryId(rs.getInt("category_id"));
				itemArticle.setCategoryName(rs.getString("category_name"));
				itemArticle.setArticleNo(rs.getInt("article_no"));
				itemArticle.setTitle(rs.getString("title"));
				itemArticle.setPrice(rs.getInt("price"));
				itemArticle.setReadCount(rs.getInt("read_count"));
				itemArticle.setPostingDate(rs.getDate("posting_date"));
				itemArticle.setPremiume(rs.getInt("premiume"));
				itemArticle.setPhoto(rs.getString("photo"));
				itemArticle.setContent(rs.getString("content"));
				itemArticle.setSoldout(rs.getInt("soldout"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectItemArticle 에러");
		} finally{
			if(rs!=null){try{rs.close();}catch(SQLException e){}}
			if(stmt!=null){try{stmt.close();}catch(SQLException e){}}
		}
		return itemArticle;
	}
	
	//회원정보
	public User selectUserInfo(String userId ){
		Statement stmt = null;
		ResultSet rs = null;
		User user = new User();
		String sql="select * from user where user_id = '" + userId+"'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
			user.setUserId(rs.getString(1));
			user.setUserPw(rs.getString(2));
			user.setUserName(rs.getString(3));
			user.setUserPhone(rs.getString(4));
			user.setUserEmail(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectUserInfo 에러");
		} finally{
			if(rs!=null){try{rs.close();}catch(SQLException e){}}
			if(stmt!=null){try{stmt.close();}catch(SQLException e){}}
		}
		return user;
	}
	
	//수정
	public int updateArticle(ItemArticle article){
			PreparedStatement pstmt = null;
			int result = 0;
			String sql = "update article set title=?, price=?, premiume=?, "
						+"category_id=?, content=?, soldout=? where article_no=? ";
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, article.getTitle());
				pstmt.setInt(2, article.getPrice());
				pstmt.setInt(3, article.getPremiume());
				pstmt.setInt(4, article.getCategoryId());
				pstmt.setString(5, article.getContent());
				pstmt.setInt(6, article.getSoldout());
				pstmt.setInt(7, article.getArticleNo());
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("updateArticle 에러");
				e.printStackTrace();
			}finally{
				if(pstmt!=null){
					try {pstmt.close();} catch (SQLException e) {}
				}
			}
			return result;
		}
	
	//삭제
	public int deleteArticle(int articleNo){
		Statement stmt = null;
		int result = 0;
		String sql="delete from article where article_no =" + articleNo;
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("deleteArticle 에러");
		} finally{
			if(stmt!=null){try{stmt.close();}catch(SQLException e){}}
		}
		return result;
	}

}
