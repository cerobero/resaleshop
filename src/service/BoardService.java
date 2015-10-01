package service;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import repository.ItemInfoDao;
import vo.ItemArticle;

public class BoardService {

	public int modifyArticle(MultipartRequest m_request, HttpSession session) throws ClassNotFoundException, SQLException {
		ItemInfoDao dao = ItemInfoDao.getInstance();
		dao.startConnection();
		int result = 0;
		
		int articleNo = Integer.parseInt(m_request.getParameter("articleNo"));
		String userPw = m_request.getParameter("userPw");
		System.out.println(userPw);
		
		String userId = (String) session.getAttribute("id");
		System.out.println("보드 서비스 userId: "+userId);
//		User user = dao.selectUserInfo(userId); //사용자비번 체크용
//		String originalPw = user.getUserPw();

		if(m_request.getParameter("articleNo")!=null){
			String title = m_request.getParameter("title");
			int price = Integer.parseInt(m_request.getParameter("price"));
//			File file = m_request.getFile("photo"); // upload
			int categoryId = Integer.parseInt(m_request.getParameter("categoryId"));
			int premiume = Integer.parseInt(m_request.getParameter("premiume"));
			String content = m_request.getParameter("content");
			System.out.println("보드 서비스 content :"+content);
			int soldout = Integer.parseInt(m_request.getParameter("soldout"));
			//int readCount = Integer.parseInt(m_request.getParameter("readCount")); 조회수 증가 없어
			//비번은 그대로~

			ItemArticle article = new ItemArticle();
			article.setArticleNo(articleNo);
//			article.setUserId(userId);
			article.setTitle(title);
			article.setPrice(price);
//			article.setPhoto(file.getAbsolutePath());
			article.setCategoryId(categoryId);
			article.setPremiume(premiume);
			article.setContent(content);
			//article.setReadCount(readCount);
			//article.setPostingDate(new Date()); //포스팅 일 그냥 쓸거~ 안 바꿈
			article.setSoldout(soldout);
		
			result = dao.updateArticle(article);
		}
		dao.closeConnection();
		return result;
	}
}
