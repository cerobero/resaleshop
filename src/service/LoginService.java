package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.LoginDao;
import vo.GoodsVo;
import vo.LoginVo;

public class LoginService {
	private LoginService(){}
	private static LoginService instance = new LoginService();
	public static LoginService getInstance(){
		return instance;
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");

		LoginDao dao=LoginDao.getInstance();
		dao.startConnection();

		int n=dao.isMember(id, pwd);
		
		if(n==1){
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
			response.sendRedirect("index.jsp");

		}else if(n==0){
			String msg="아이디 또는 비밀번호가 틀립니다";
			request.setAttribute("errMsg", msg);
			request.getRequestDispatcher("err.jsp").forward(request, response);

		}else{
			String msg="내부 오류발생!";
			request.setAttribute("errMsg", msg);
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}		
	}

	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	public void myPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		HttpSession session=request.getSession();
		String sid = (String)session.getAttribute("id");
		
		LoginDao dao=LoginDao.getInstance();
		dao.startConnection();

		List<GoodsVo> articleList=dao.itemStatus(sid);
		request.setAttribute("articleList", articleList);
		
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}
	
	public void soldout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String snum=request.getParameter("articleNo");
		int anum=Integer.parseInt(snum);
		
		LoginDao dao=LoginDao.getInstance();
		dao.startConnection();

		dao.soldout(anum);
		LoginService.instance.myPage(request, response);
	}
	
	public void delArticle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String snum=request.getParameter("articleNo");
		int anum=Integer.parseInt(snum);
		
		LoginDao dao=LoginDao.getInstance();
		dao.startConnection();

		dao.delete(anum);
		LoginService.instance.myPage(request, response);
	}
	
}