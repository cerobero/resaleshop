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

import repository.writeDao;
import service.writeService;
import vo.Article;

@WebServlet(urlPatterns = "/write")
public class wirteServlet extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MultipartRequest mr = new MultipartRequest(request, "c:/test", 1024 * 1024 * 5, "UTF-8",
				new DefaultFileRenamePolicy());
		String type = mr.getParameter("type");
		writeService writeservice = new writeService();
		String viewPath = "";
		try {
			if (type.equals("write")) {
				HttpSession session= request.getSession();
				int result = writeservice.write(mr, session);
				request.setAttribute("result", result);
				viewPath = "category.jsp";
				// }else if(type.equals("read")){
				// Article article = service.readArticle(request);
				// request.setAttribute("article", article);
				// viewPath = "read.jsp";
				// }else if(type.equals("updateForm")){
				// Article original = service.readWithOutReadCount(request);
				// request.setAttribute("original", original);
				// viewPath = "update_form.jsp";
				// }else if(type.equals("update")){
				// service.modifyArticle(request);
				// viewPath = "update_result.jsp";
				// }
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("exception", ex);
			viewPath = "board_error.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
