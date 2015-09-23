package service;

import javax.servlet.http.HttpServletRequest;

import repository.UserDao;
import vo.User;

public class RegisterService
{
	private static RegisterService instance = new RegisterService();
	
	private RegisterService()
	{
		// Singleton
	}
	
	public static RegisterService getInstance()
	{
		return instance;
	}
	
	public int registUser(HttpServletRequest request)
	{
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		
		if (userId == null || userPw == null || userName == null || userPhone == null || userEmail == null || userId.equals("") || userPw.equals("") ||
				userName.equals("") || userPhone.equals("") || userEmail.equals(""))
		{
			request.setAttribute("errMsg", "파라미터가 올바르지 않습니다.");
			return -1;
		}
		
		UserDao userDao = UserDao.getInstance();
		userDao.startConnection();
		
		if (userDao.insertUser(new User(userId, userPw, userName, userPhone, userEmail)) == 0)
		{
			request.setAttribute("errMsg", "아이디가 이미 존재합니다.");
			return -1;
		}
		
		userDao.closeConnection();
		return 1;
	}
}
