package vo;

public class User
{
	private String userId;		/*		user_id		*/
	private String userPw;		/*		user_pw		*/
	private String userName;	/*		user_name	*/
	private String userPhone;	/*		user_phone	*/
	private String userEmail;	/*		user_email	*/
	
	public User()
	{
		super();
	}

	public User(String userId, String userPw, String userName, String userPhone, String userEmail)
	{
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPhone()
	{
		return userPhone;
	}

	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
}
