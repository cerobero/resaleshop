package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ArticleService;
import vo.ArticlePage;

@WebServlet(urlPatterns="/list")
public class ArticleServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ArticleService articleService = ArticleService.getInstance();
		String forwardPath = "category.jsp";
		
		ArticlePage articlePage = articleService.getArticlePage(request);
		request.setAttribute("articlePage", articlePage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
}