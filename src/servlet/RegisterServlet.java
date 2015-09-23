package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.RegisterService;

@WebServlet(urlPatterns="/register")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String forwardPath = "";
		String type = request.getParameter("type");
		
		if (type == null || type.equals("form"))
		{
			forwardPath = "register.jsp";
		}
		else if (type.equals("done"))
		{
			forwardPath = "regist_done.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		RegisterService service = RegisterService.getInstance();
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("loginId");
		String requestId = request.getParameter("userId");
		String forwardPath = "";

		if (sessionId != null && sessionId.length() > 0)
		{
			forwardPath = "redirect.jsp";
			request.setAttribute("errMsg", "�̹� �α������Դϴ�. �α��� �Ŀ� �ٽ� �õ����ּ���.");
			request.setAttribute("location", "index.jsp");
		}
		else if (requestId != null && requestId.length() > 0)
		{
			int result = service.registUser(request);

			if (result == -1)
			{
				forwardPath = "redirect.jsp";
				request.setAttribute("location", "register");
			}
			else if (result == 1)
			{
				forwardPath = "redirect.jsp";
				request.setAttribute("location", "register?type=done");
			}
		}
		else
		{
			forwardPath = "register.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
}
