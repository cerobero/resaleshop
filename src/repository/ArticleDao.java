package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Article;

public class ArticleDao
{
	private static ArticleDao instance = new ArticleDao();
	private Connection con;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/resale_shop";
	private static final String DB_ID = "root";
	private static final String DB_PW = "hanbit";
	
	private ArticleDao()
	{
		// Singleton
	}
	
	public static ArticleDao getInstance()
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
	
	public Article selectArticle(int articleNo)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Article article = null;
		
		String sql = "SELECT * FROM ARTICLE WHERE ARTICLE_NO = ?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNo);
			rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				article = new Article();
				
				article.setArticleNo(rs.getInt(1));
				article.setUserId(rs.getString(2));
				article.setTitle(rs.getString(3));
				article.setPrice(rs.getInt(4));
				article.setReadCount(rs.getInt(5));
				article.setPostingDate(rs.getDate(6));
				article.setPremiume(rs.getInt(7));
				article.setPhoto(rs.getString(8));
				article.setCategoryId(rs.getInt(9));
				article.setContent(rs.getString(10));
				article.setSoldout(rs.getInt(11));
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
		
		return article;
	}
	
	public List<Article> selectArticleListAll(String search, int startIndex, int numOfIndex)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Article> articleList = null;
		startIndex = startIndex > 0 ? startIndex : 0;
		numOfIndex = numOfIndex > 0 ? numOfIndex : 0;
		System.out.println(String.format("selectArticleListAll %d, %d", startIndex, numOfIndex));
		
		String sql = "SELECT * FROM ARTICLE WHERE TITLE LIKE ? ORDER BY ARTICLE_NO DESC LIMIT ?, ?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, String.format("%%%s%%", search));
			pstmt.setInt(2, startIndex);
			pstmt.setInt(3, numOfIndex);
			
			rs = pstmt.executeQuery();
			
			articleList = new ArrayList<>();
			
			while (rs.next())
			{
				Article article = new Article();
				
				article.setArticleNo(rs.getInt(1));
				article.setUserId(rs.getString(2));
				article.setTitle(rs.getString(3));
				article.setPrice(rs.getInt(4));
				article.setReadCount(rs.getInt(5));
				article.setPostingDate(rs.getDate(6));
				article.setPremiume(rs.getInt(7));
				article.setPhoto(rs.getString(8));
				article.setCategoryId(rs.getInt(9));
				article.setContent(rs.getString(10));
				article.setSoldout(rs.getInt(11));
				
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
		
		return articleList;
	}

	public List<Article> selectArticleListCategory(String search, int categoryId, int startIndex, int numOfIndex)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Article> articleList = null;
		startIndex = startIndex > 0 ? startIndex : 0;
		numOfIndex = numOfIndex > 0 ? numOfIndex : 0;
		System.out.println(String.format("selectArticleListCategory %d, %d", startIndex, numOfIndex));
		
		String sql = "SELECT * FROM ARTICLE WHERE CATEGORY_ID = ? AND TITLE LIKE ? ORDER BY ARTICLE_NO DESC LIMIT ?, ?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, categoryId);
			pstmt.setString(2, String.format("%%%s%%", search));
			pstmt.setInt(3, startIndex);
			pstmt.setInt(4, numOfIndex);
			
			rs = pstmt.executeQuery();
			
			articleList = new ArrayList<>();
			
			while (rs.next())
			{
				Article article = new Article();
				
				article.setArticleNo(rs.getInt(1));
				article.setUserId(rs.getString(2));
				article.setTitle(rs.getString(3));
				article.setPrice(rs.getInt(4));
				article.setReadCount(rs.getInt(5));
				article.setPostingDate(rs.getDate(6));
				article.setPremiume(rs.getInt(7));
				article.setPhoto(rs.getString(8));
				article.setCategoryId(rs.getInt(9));
				article.setContent(rs.getString(10));
				article.setSoldout(rs.getInt(11));
				
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
		
		return articleList;
	}

	public int selectArticleCountAll(String search)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int articleCount = 0;
		
		String sql = "SELECT COUNT(*) FROM ARTICLE WHERE TITLE LIKE ?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, String.format("%%%s%%", search));
			
			rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				articleCount = rs.getInt(1);
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
		
		return articleCount;
	}

	public int selectArticleCountCategory(String search, int categoryId)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int articleCount = 0;
		
		String sql = "SELECT COUNT(*) FROM ARTICLE WHERE CATEGORY_ID = ? AND TITLE LIKE ?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, categoryId);
			pstmt.setString(2, String.format("%%%s%%", search));
			
			rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				articleCount = rs.getInt(1);
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
		
		return articleCount;
	}
}
