package vo;

import java.util.List;

public class ItemArticlePage {
	private List<ItemArticle>  itemArticle;
	private int startPage;
	private int endPage;
	private int requestedPage;
	private int totalPage;


	public ItemArticlePage(){}

	public ItemArticlePage(List<ItemArticle> itemArticle, int startPage,
			int endPage, int requestedPage, int totalPage) {
		this.itemArticle = itemArticle;
		this.startPage = startPage;
		this.endPage = endPage;
		this.requestedPage = requestedPage;
		this.totalPage = totalPage;
	}

	public List<ItemArticle> getItemArticle() {
		return itemArticle;
	}

	public void setItemArticle(List<ItemArticle> itemArticle) {
		this.itemArticle = itemArticle;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


}
