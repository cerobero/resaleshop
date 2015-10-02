package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import vo.Article;

public class writeDao {

	private writeDao(){}
	private static writeDao instance  = new writeDao();
	public static writeDao getInstance(){
		return instance;
}
private Connection con;

	public void startConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");

		if(con==null){
			String url = "jdbc:mysql://localhost:3306/resale_shop";
			con = DriverManager.getConnection(url,"root","hanbit");
		}
	}
	public void closeConnection() throws SQLException{
		if(con!=null){
			con.close();
			con = null;
		}
	}
	public int insertArticle(Article article){
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into article(user_id,title,price,read_count,posting_date,premiume,photo,category_id,content,soldout) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, article.getUserId());
			pstmt.setString(2, article.getTitle());
			pstmt.setInt(3, article.getPrice());
			pstmt.setInt(4, article.getReadCount());
			pstmt.setTimestamp(5, new Timestamp(article.getPostingDate().getTime()));
			pstmt.setInt(6, article.getPremiume());
			pstmt.setString(7, article.getPhoto());
			pstmt.setInt(8, article.getCategoryId());
			pstmt.setString(9, article.getContent());
			pstmt.setInt(10, article.getSoldout());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {pstmt.close();} catch (SQLException e) {}
			}
		}
		return result;
	}
	public int insertComment(Article article){
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into comment(article_no,user_id,comment_date,comment_content) values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, article.getArticleNo());
			pstmt.setString(2, article.getUserId());
			pstmt.setTimestamp(3, new Timestamp(article.getComment_Date().getTime()));
			pstmt.setString(4, article.getContent());


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {pstmt.close();} catch (SQLException e) {}
			}
		}
		return result;
	}
	
	public List<Article> selectCommentList(int articleNo)
	{
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Article> articleList = new ArrayList<>();

		String sql = "SELECT * FROM COMMENT WHERE ARTICLE_NO = ?";
		try
		{
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, articleNo);

			result = pstmt.executeQuery();

			while (result.next())
			{
				Article article = new Article();
				article.setArticleNo(result.getInt(2));
				article.setUserId(result.getString(3));
				article.setComment_Date(result.getDate(4));
				article.setContent(result.getString(5));
				
				articleList.add(article);
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

			if (result != null)
			{
				try
				{
					result.close();
					result = null;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return articleList;
	}
}