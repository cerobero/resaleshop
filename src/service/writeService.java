package service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import repository.writeDao;
import vo.Article;

public class writeService {

	public int write(MultipartRequest m_request, HttpSession session) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//String forderPath = "c:/test/";
		int result = 0;
		String userId = (String) session.getAttribute("id");
		System.out.println(userId);
		// m_request = new MultipartRequest(request, forderPath, 1024 * 1024,
		// "euc-kr",
		// new DefaultFileRenamePolicy());
		File file = m_request.getFile("photo"); // upload
		String title = m_request.getParameter("title");
		int price = Integer.parseInt(m_request.getParameter("price"));
		int categoryId = Integer.parseInt(m_request.getParameter("categoryId"));
		// int soldout =Integer.parseInt(m_request.getParameter("soldout"));
		int premiume = Integer.parseInt(m_request.getParameter("premiume"));
		String content = m_request.getParameter("content");
		System.out.println(content);
		Article article = new Article();
		article.setUserId(userId);
		article.setTitle(title);
		article.setPrice(price);
		article.setPhoto(file.getAbsolutePath().substring(file.getAbsolutePath().indexOf("upload")));
		article.setCategoryId(categoryId);
		article.setPremiume(premiume);
		article.setContent(content);
		article.setReadCount(0);
		article.setPostingDate(new Date());
		article.setSoldout(0);
		writeDao dao = writeDao.getInstance();
		dao.startConnection();
		result = dao.insertArticle(article);
		dao.closeConnection();
		return result;

	}
	public int comment(HttpServletRequest request,HttpSession session) throws ClassNotFoundException, SQLException{
		int result = 0;
		String userId = (String) session.getAttribute("id");
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		String content = request.getParameter("content");
		Article article = new Article();
		article.setArticleNo(articleNo);
		article.setComment_Date(new Date());
		article.setUserId(userId);
		article.setContent(content);
		writeDao dao = writeDao.getInstance();
		dao.startConnection();
		dao.insertComment(article);
		dao.closeConnection();
		return result;

	}

}
