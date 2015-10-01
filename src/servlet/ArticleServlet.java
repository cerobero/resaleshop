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

@WebServlet(urlPatterns = "/list")
public class ArticleServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException
	{
		ArticleService articleService = ArticleService.getInstance();
		ArticlePage articlePage = null;
		String forwardPath = "category.jsp";
		String view = request.getParameter("view");

		if (view == null || view.length() == 0 || view.equals(""))
		{
			articlePage = articleService.getArticlePage(request);
		}
		else if (view.equals("hot"))
		{
			articlePage = articleService.getArticlePageHot(request);
		}
		else if (view.equals("premium"))
		{
			articlePage = articleService.getArticlePagePremium(request);
		}

		request.setAttribute("articlePage", articlePage);

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
}