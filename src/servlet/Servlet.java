package servlet;

import java.io.File;
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
		System.out.println("Get 보드서블릿 ");
		request.setCharacterEncoding("euc-kr");
		ItemInfoService itemInfoService = ItemInfoService.getInstance();
		String type=request.getParameter("type");
		String viewPath = "";
		try {
			if (type.equals("updateForm")) {
				ItemArticle itemArticle = itemInfoService.upDelReadItemArticle(request);
				request.setAttribute("itemArticle", itemArticle);
				System.out.println("updateForm 서블릿:"+type);
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
		System.out.println("Post 서블릿");
		request.setCharacterEncoding("euc-kr");
		String folderPath=request.getServletContext().getRealPath("/upload");
		String savePath = folderPath.replace('\\', '/');
		File dir = new File(savePath);
		//디렉토리가 없으면
		if(!dir.isDirectory())
		{
			//		          System.out.println("디렉토리 없음");
			//디렉토리 생성
			dir.mkdirs();
		}
		MultipartRequest mr = new MultipartRequest(request, folderPath, 1024 * 1024 * 5, "euc-kr",
				new DefaultFileRenamePolicy());
		String type = mr.getParameter("type");
		BoardService boardservice = new BoardService();
		String viewPath = "";
		try {
			if (type.equals("update")) {
				HttpSession session= request.getSession();
				int result = boardservice.modifyArticle(mr, session);
				System.out.println("update 서블릿 result"+result);
				request.setAttribute("result", result);
				viewPath = "update.jsp";
				response.sendRedirect("index");
				return;
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
