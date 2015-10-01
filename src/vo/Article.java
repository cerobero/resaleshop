package vo;

import java.util.Date;

public class Article
{
	private int articleNo;
	private String userId;
	private String title;
	private int price;
	private int readCount;
	private Date postingDate;
	private int premiume;
	private String photo;
	private int categoryId;
	private String content;
	private int soldout;
	private Date comment_Date;

	public Article()
	{
		super();
	}

	public Article(int articleNo, String userId, String title, int price, int readCount, Date postingDate,
	        int premiume, String photo, int categoryId, String content, int soldout)
	{
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.title = title;
		this.price = price;
		this.readCount = readCount;
		this.postingDate = postingDate;
		this.premiume = premiume;
		this.photo = photo;
		this.categoryId = categoryId;
		this.content = content;
		this.soldout = soldout;
	}

	public Date getComment_Date() {
		return comment_Date;
	}

	public void setComment_Date(Date comment_Date) {
		this.comment_Date = comment_Date;
	}

	public int getArticleNo()
	{
		return articleNo;
	}

	public void setArticleNo(int articleNo)
	{
		this.articleNo = articleNo;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public int getReadCount()
	{
		return readCount;
	}

	public void setReadCount(int readCount)
	{
		this.readCount = readCount;
	}

	public Date getPostingDate()
	{
		return postingDate;
	}

	public void setPostingDate(Date postingDate)
	{
		this.postingDate = postingDate;
	}

	public int getPremiume()
	{
		return premiume;
	}

	public void setPremiume(int premiume)
	{
		this.premiume = premiume;
	}

	public String getPhoto()
	{
		return photo;
	}

	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	public int getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getSoldout()
	{
		return soldout;
	}

	public void setSoldout(int soldout)
	{
		this.soldout = soldout;
	}
}
