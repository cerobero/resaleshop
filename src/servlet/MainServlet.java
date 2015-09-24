package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MainMenuService;
import vo.ArticlePage;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

	@SuppressWarnings("null")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		MainMenuService service=MainMenuService.getInstance();
		String viewPath=null;
		
		try {
			if(type!=null||type.equals("index")){
			ArticlePage newProductPage=service.getNewArticlePage(request);
			ArticlePage hotProductPage=service.getHotArticlePage(request);
			ArticlePage premiumProductPage=service.getPremiumArticlePage(request);
			request.setAttribute("newProductPage", newProductPage);
			request.setAttribute("hotProductPage", hotProductPage);
			request.setAttribute("premiumProductPage", premiumProductPage);
			viewPath="index.jsp";
			}
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("exception", e);
			viewPath = "err.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}

}
