package vo;

import java.util.List;

public class ArticlePage
{
	private List<Article> articleList;
	private int articleCount;
	private int pageArticleCount;
	private int currentPage;
	private int requestPage;
	private int totalPageCount;
	private int startPage;
	private int endPage;
	
	public ArticlePage()
	{
		super();
	}
	
	public ArticlePage(List<Article> articleList, int requestPage, int totalPageCount, int startPage, int endPage) {
		this.articleList = articleList;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public ArticlePage(List<Article> articleList, int articleCount, int pageArticleCount, int currentPage, int startPage, int endPage)
	{
		super();
		this.articleList = articleList;
		this.articleCount = articleCount;
		this.pageArticleCount = pageArticleCount;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public List<Article> getArticleList()
	{
		return articleList;
	}

	public void setArticleList(List<Article> articleList)
	{
		this.articleList = articleList;
	}

	public int getArticleCount()
	{
		return articleCount;
	}

	public void setArticleCount(int articleCount)
	{
		this.articleCount = articleCount;
	}
	
	public int getPageArticleCount()
	{
		return pageArticleCount;
	}
	
	public void setPageArticleCount(int pageArticleCount)
	{
		this.pageArticleCount = pageArticleCount;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	
	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartPage()
	{
		return startPage;
	}

	public void setStartPage(int startPage)
	{
		this.startPage = startPage;
	}

	public int getEndPage()
	{
		return endPage;
	}

	public void setEndPage(int endPage)
	{
		this.endPage = endPage;
	}
}
