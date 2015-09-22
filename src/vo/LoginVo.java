package vo;

public class LoginVo {

	private String userId;
	private String passward;
	
	public LoginVo(){}

	public LoginVo(String userId, String passward){
		this.userId=userId;
		this.passward=passward;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}
}

