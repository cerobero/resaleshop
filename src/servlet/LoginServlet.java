package servlet;

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
import service.LoginService;
import vo.GoodsVo;
import vo.LoginVo;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			
		String cmd=request.getParameter("cmd");
		LoginService service = LoginService.getInstance();
		
		if(cmd.equals("loginForm")){
			response.sendRedirect("login.jsp");
		}else if(cmd.equals("login")){
			service.login(request, response);
		}else if(cmd.equals("logout")){
			service.logout(request,response);
		}else if(cmd.equals("soldout")){
			service.soldout(request,response);
		}else if(cmd.equals("del")){
			service.delArticle(request,response);
		}else if(cmd.equals("count")){
			service.countComments(request, response);
		}else if(cmd.equals("mypage")){
			service.myPage(request,response);}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();}
	}
}