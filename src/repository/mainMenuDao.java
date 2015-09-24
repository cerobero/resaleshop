package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Article;


public class mainMenuDao {
	private mainMenuDao() {
	}

	private static mainMenuDao instance = new mainMenuDao();

	public static mainMenuDao getInstance() {
		return instance;
	}

	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}

	// ���̺��� ��û���� ��� ���ο� ����� ��ǰ�� �о���� �޼ҵ�
	public List<Article> MainNewArticleList(int startRow, int count) throws ClassNotFoundException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Article> result = new ArrayList<>();

		String sql = "select * from article order by article_no desc limit ?,?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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

				result.add(article);
			}

		} catch (SQLException e) {
			System.out.println(" Main New Article List dao ����");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// ���̺��� ��û���� ��� �����̾� ��ǰ�� �о���� �޼ҵ�
		public List<Article> MainPremiumArticleList(int startRow, int count) throws ClassNotFoundException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Article> result = new ArrayList<>();

			String sql = "select * from article where premiume=1 order by article_no desc limit ?,?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, count);
				rs = pstmt.executeQuery();

				while (rs.next()) {
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

					result.add(article);
				}
	
			} catch (SQLException e) {
				System.out.println(" Main Premium Article Article List dao ����");
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return result;
		}

		// ���̺��� ��û���� ��� ��ȸ���� ���� ��ǰ�� �о���� �޼ҵ�
		public List<Article> MainHotArticleList(int startRow, int count) throws ClassNotFoundException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Article> result = new ArrayList<>();

			String sql = "select * from article where read_count>=10 order by article_no desc limit ?,?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, count);
				rs = pstmt.executeQuery();

				while (rs.next()) {
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

					result.add(article);
				}
	
			} catch (SQLException e) {
				System.out.println(" Main Hot Article Article List dao ����");
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return result;
		}


	// ���̺� ����� �� ��ǰ ����
	public int MainSelectArticleCount() throws ClassNotFoundException {
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "select count(*) from article";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Main Select ArticleCount dao����");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	// ��ǰ���� �б� ���� select method
	public Article MainSelectArticle(int number) throws ClassNotFoundException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Article result = null;

		try {
			String sql = "select article_no,title,price,premiume,photo,content from article where article_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new Article();
				result.setArticleNo(rs.getInt(1));
				result.setTitle(rs.getString(2));
				result.setPrice(rs.getInt(3));
				result.setPremiume(rs.getInt(4));
				result.setPhoto(rs.getString(5));
				result.setContent(rs.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("board Select Article ����");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	// ��ǰ���� ������ ��ȸ�� ���������ִ� �޼ҵ�
	public int MainUpdatedReadCount(int number) throws ClassNotFoundException {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "update article set read_count=read_count+1 where num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, number);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Main Updated Read Count dao ����");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}
}
