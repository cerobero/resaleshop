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

	// 테이블에서 요청받은 대로 새로운 순대로 상품들 읽어오는 메소드
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
			System.out.println(" Main New Article List dao 에러");
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
	
	// 테이블에서 요청받은 대로 프리미엄 상품들 읽어오는 메소드
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
				System.out.println(" Main Premium Article Article List dao 에러");
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

		// 테이블에서 요청받은 대로 조회수가 많은 상품들 읽어오는 메소드
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
				System.out.println(" Main Hot Article Article List dao 에러");
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


	// 테이블에 저장된 총 상품 숫자
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
			System.out.println("글의 총수"+result);
		} catch (SQLException e) {
			System.out.println("Main Select ArticleCount dao에러");
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

	// 상품정보 읽기 관련 select method
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
			System.out.println("board Select Article 에러");
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

	// 상품정보 읽으면 조회수 증가시켜주는 메소드
	public int MainUpdatedReadCount(int number) throws ClassNotFoundException {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "update article set read_count=read_count+1 where num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, number);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Main Updated Read Count dao 에러");
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
