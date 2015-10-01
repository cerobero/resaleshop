package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.BoardService;
import service.ItemInfoService;
import vo.ItemArticle;

@WebServlet(urlPatterns = "/board")
public class Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get º¸µå¼­ºí¸´ ");
		request.setCharacterEncoding("euc-kr");
		ItemInfoService itemInfoService = ItemInfoService.getInstance();
		String type=request.getParameter("type");
		String viewPath = "";
		try {
			if (type.equals("updateForm")) {
				ItemArticle itemArticle = itemInfoService.upDelReadItemArticle(request);
				request.setAttribute("itemArticle", itemArticle);
				System.out.println("updateForm ¼­ºí¸´:"+type);
				viewPath = "update_form.jsp";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("exception", ex);
			//viewPath = "board_error.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post ¼­ºí¸´");
		request.setCharacterEncoding("euc-kr");
		String folderPath=request.getServletContext().getRealPath("/upload");
		MultipartRequest mr = new MultipartRequest(request, folderPath, 1024 * 1024 * 5, "euc-kr",
				new DefaultFileRenamePolicy());
		String type = mr.getParameter("type");
		BoardService boardservice = new BoardService();
		String viewPath = "";
		try {
			if (type.equals("update")) {
				HttpSession session= request.getSession();
				int result = boardservice.modifyArticle(mr, session);
				System.out.println("update ¼­ºí¸´ result"+result);
				request.setAttribute("result", result);
				viewPath = "update.jsp";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("exception", ex);
			//viewPath = "board_error.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
