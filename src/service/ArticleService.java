package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import repository.ArticleDao;
import vo.Article;
import vo.ArticlePage;

public class ArticleService
{
	private static ArticleService instance = new ArticleService();
	private static final int ARTICLE_PER_PAGE = 8;
	private static final int VIEW_PAGES = 10;
	
	private ArticleService()
	{
		super();
	}
	
	public static ArticleService getInstance()
	{
		return instance;
	}
	
	public ArticlePage getArticlePage(HttpServletRequest request)
	{
		ArticleDao articleDao = ArticleDao.getInstance();
		articleDao.startConnection();
		
		String selectPageStr = request.getParameter("page");
		int selectPage = selectPageStr != null && selectPageStr.length() > 0 ? Integer.parseInt(selectPageStr) : 1;
		String categoryIdStr = request.getParameter("categoryId");
		int categoryId = categoryIdStr != null && categoryIdStr.length() > 0 ? Integer.parseInt(categoryIdStr) : 0;
		List<Article> articleList = null;
		int articleCount = 0;
		int pageArticleCount = 0;
		int currentPage = 1;
		int startPage = 1;
		int endPage = 1;
		int totalPage = 1;
		String search = request.getParameter("search");
		search = search == null ? "" : search;
		
		articleCount = categoryId == 0 ? articleDao.selectArticleCountAll(search) : articleDao.selectArticleCountCategory(search, categoryId);
		currentPage = selectPage > 0 ? selectPage : 1;
		totalPage = articleCount % ARTICLE_PER_PAGE != 0 ? articleCount / ARTICLE_PER_PAGE + 1 : articleCount / ARTICLE_PER_PAGE;
		startPage = currentPage > VIEW_PAGES / 2 ? currentPage - VIEW_PAGES / 2 + 1 : 1;
		endPage = totalPage > startPage + VIEW_PAGES - 1 ? startPage + VIEW_PAGES - 1 : totalPage;
		startPage = totalPage == endPage && endPage > ARTICLE_PER_PAGE && startPage > ARTICLE_PER_PAGE ? endPage - ARTICLE_PER_PAGE + 1 : startPage;
		articleList = categoryId == 0 ? articleDao.selectArticleListAll(search, (currentPage - 1) * ARTICLE_PER_PAGE, ARTICLE_PER_PAGE) : articleDao.selectArticleListCategory(search, categoryId, (currentPage - 1) * ARTICLE_PER_PAGE, ARTICLE_PER_PAGE);
		pageArticleCount = articleList.size();
		System.out.println("pageArticleCount = " + pageArticleCount);
		System.out.println(String.format("startPage = %d, endPage = %d, currentPage = %d, selectPage = %d, totalPage = %d", startPage, endPage, currentPage, selectPage, totalPage));
		
		articleDao.closeConnection();
		return new ArticlePage(articleList, articleCount, pageArticleCount, currentPage, startPage, endPage);
	}
}
