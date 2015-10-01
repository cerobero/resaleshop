package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ItemInfoService;
import service.writeService;
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
		writeService writeservice = new writeService();
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
				}else if(type.equals("comment")){
					 HttpSession session = request.getSession();
					 int result = writeservice.comment(request, session);
					 request.setAttribute("result", result);
//					 path = "read.jsp?itemInfo=read";
					 path = String.format("itemInfo?type=read&articleNo=%s&categoryId=%s&page=%s&search=%s", request.getParameterValues("articleNo") , request.getParameter("categoryId"), request.getParameter("page"), request.getParameter("page"), request.getParameter("search"));
					 response.sendRedirect(path);
					 return;
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
