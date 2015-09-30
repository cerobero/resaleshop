package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import repository.ConnectionDao;
import repository.mainMenuDao;
import vo.Article;
import vo.ArticlePage;

public class MainMenuService {
	private MainMenuService(){}
	private static MainMenuService instance = new MainMenuService();
	public static MainMenuService getInstance(){
		return instance;
	}
	
	public static final int COUNT_PER_PAGE = 8;
	//  �Ż�ǰ �������� �� ��������,����,��,�����û ������
	public ArticlePage getNewArticlePage(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String pageStr = request.getParameter("new_page");
		int requestPage = 1;
		if (pageStr != null && pageStr.length() > 0) {
			requestPage = Integer.parseInt(pageStr);
		}
		mainMenuDao dao =mainMenuDao.getInstance();
		Connection con = ConnectionDao.startConnection();
		dao.setConnection(con);

		int totalArticleCount = dao.MainSelectArticleCount();

		if (totalArticleCount == 0) {
			return new ArticlePage();
		}

		int totalPageCount = totalArticleCount / COUNT_PER_PAGE;
		if (totalPageCount % COUNT_PER_PAGE != 0) {
			totalPageCount++;
		}

		int startRow = (requestPage - 1) * COUNT_PER_PAGE;

		List<Article> articleList = dao.MainNewArticleList(startRow, COUNT_PER_PAGE);

		int startPage = requestPage - 4;
		if (startPage < 1) {
			startPage = 1;
		}

		int endPage = requestPage + 4;
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}

		ConnectionDao.closeConnection(con);
		return new ArticlePage(articleList, requestPage, totalPageCount, startPage, endPage);
	}
	
	//  ��ȸ���� ���� ��ǰ �������� �� ��������,����,��,�����û ������
	public ArticlePage getHotArticlePage(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String pageStr = request.getParameter("hot_page");
		int requestPage = 1;
		if (pageStr != null && pageStr.length() > 0) {
			requestPage = Integer.parseInt(pageStr);
		}
		mainMenuDao dao =mainMenuDao.getInstance();
		Connection con = ConnectionDao.startConnection();
		dao.setConnection(con);

		int totalArticleCount = dao.MainSelectArticleCount();

		if (totalArticleCount == 0) {
			return new ArticlePage();
		}

		int totalPageCount = totalArticleCount / COUNT_PER_PAGE;
		if (totalPageCount % COUNT_PER_PAGE != 0) {
			totalPageCount++;
		}

		int startRow = (requestPage - 1) * COUNT_PER_PAGE;

		List<Article> articleList = dao.MainHotArticleList(startRow, COUNT_PER_PAGE);

		int startPage = requestPage - 4;
		if (startPage < 1) {
			startPage = 1;
		}

		int endPage = requestPage + 4;
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}

		ConnectionDao.closeConnection(con);
		return new ArticlePage(articleList, requestPage, totalPageCount, startPage, endPage);
	}
	
	//  �����̾� ��ǰ �������� �� ��������,����,��,�����û ������
	public ArticlePage getPremiumArticlePage(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String pageStr = request.getParameter("premium_page");
		int requestPage = 1;
		if (pageStr != null && pageStr.length() > 0) {
			requestPage = Integer.parseInt(pageStr);
		}
		mainMenuDao dao =mainMenuDao.getInstance();
		Connection con = ConnectionDao.startConnection();
		dao.setConnection(con);

		int totalArticleCount = dao.MainSelectArticleCount();

		if (totalArticleCount == 0) {
			return new ArticlePage();
		}

		int totalPageCount = totalArticleCount / COUNT_PER_PAGE;
		if (totalPageCount % COUNT_PER_PAGE != 0) {
			totalPageCount++;
		}

		int startRow = (requestPage - 1) * COUNT_PER_PAGE;

		List<Article> articleList = dao.MainPremiumArticleList(startRow, COUNT_PER_PAGE);

		int startPage = requestPage - 4;
		if (startPage < 1) {
			startPage = 1;
		}

		int endPage = requestPage + 4;
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}

		ConnectionDao.closeConnection(con);
		return new ArticlePage(articleList, requestPage, totalPageCount, startPage, endPage);
	}
	
	//��ǰ���� ���� �� ��ȸ���� ���������ִ� �޼ҵ�
		public Article MainReadArticle(HttpServletRequest request) throws ClassNotFoundException, SQLException{
			String articleNoStr=request.getParameter("articleNo");
			int articleNo=Integer.parseInt(articleNoStr);
			
			mainMenuDao dao = mainMenuDao.getInstance();
			Connection con = ConnectionDao.startConnection();
			dao.setConnection(con);
			
			Article result=null;
			if(dao.MainUpdatedReadCount(articleNo)>0){
				result=dao.MainSelectArticle(articleNo);
			}
			
			dao.setConnection(con);
			return result;	
		}
	
}
