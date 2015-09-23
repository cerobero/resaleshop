package vo;

import java.util.Date;

public class Article {
	
	private int articleNo=0;
	private String userId="";
	private String title = "";
	private int price = 0;
	private Date postingDate = null;
	private int readCount = 0;
	private int premiume = 0;
	private String photo = "";
	private int categoryId =0;
	private String content  = "";
	private int soldout = 0;
	
	public Article (){
		
	}
	public Article (String userId,String title,int price,Date postingDate,int readCount,
			int premiume,String photo, int categoryId, String content,int soldout){
		this.userId= userId;
		this.title = title;
		this.postingDate = postingDate;
		this.readCount = readCount;
		this.premiume = premiume;
		this.photo = photo;
		this.categoryId = categoryId;
		this.content = content;
		this.soldout = soldout;
		
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getPremiume() {
		return premiume;
	}
	public void setPremiume(int premiume) {
		this.premiume = premiume;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSoldout() {
		return soldout;
	}
	public void setSoldout(int soldout) {
		this.soldout = soldout;
	}
	
}
