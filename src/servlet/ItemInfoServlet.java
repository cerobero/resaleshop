package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ItemInfoService;
import vo.ItemArticle;
import vo.ItemArticlePage;

@WebServlet(urlPatterns="/itemInfo")
public class ItemInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get2 ����");
		process(request, response);
//		ItemInfoService itemInfoService = ItemInfoService.getInstance();
//		String type = request.getParameter("type");
//		String path = "";
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post2 ����");
		process(request, response);
//		ItemInfoService itemInfoService = ItemInfoService.getInstance();
//		String type = request.getParameter("type");
//		String path = "";
	}

	private void process(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		ItemInfoService itemInfoService = ItemInfoService.getInstance();
		String path = "";
		System.out.println("���μ��� ���� type:"+type);
			try {
				request.setCharacterEncoding("euc-kr");

				if(type==null || type.equals("category")){
					ItemArticlePage itemArticlePage = itemInfoService.getItemArticlePage(request);
					request.setAttribute("itemArticlePage", itemArticlePage);
					//path = "itemList.jsp";
					path = "category.jsp";
				} else if(type.equals("read")){
					ItemArticle itemArticle = itemInfoService.readItemArticle(request);
					request.setAttribute("itemArticle", itemArticle);
					path = "read.jsp";
				} else if (type.equals("deleteForm")) {
					ItemArticle itemArticle = itemInfoService.upDelReadItemArticle(request);
					request.setAttribute("itemArticle", itemArticle);
					path = "delete_form.jsp";
				} else if (type.equals("delete")) {
					System.out.println("������ delete");
					int result = itemInfoService.delArticle(request);
					request.setAttribute("result", result);
					path = "delete.jsp";
				}

				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
