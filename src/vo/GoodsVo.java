package vo;

import java.util.Date;

public class GoodsVo {
	private int articleNo;
	private String title;
	private int commentNoNo;
	private int price;
	private Date postingDate;
	private int soldout;
	
	public GoodsVo() {
	}

	public GoodsVo(int articleNo, String title, int commentNoNo, int price, Date postingDate, int soldout) {
		super();
		this.articleNo = articleNo;
		this.title = title;
		this.commentNoNo = commentNoNo;
		this.price = price;
		this.postingDate = postingDate;
		this.soldout = soldout;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCommentNoNo() {
		return commentNoNo;
	}

	public void setCommentNoNo(int commentNoNo) {
		this.commentNoNo = commentNoNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public int getSoldout() {
		return soldout;
	}

	public void setSoldout(int soldout) {
		this.soldout = soldout;
	}
}
	