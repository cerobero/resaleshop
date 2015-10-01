package service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import repository.ItemInfoDao;
import vo.ItemArticle;
import vo.ItemArticlePage;

public class ItemInfoService {
	private ItemInfoService(){}
	private static ItemInfoService instance = new ItemInfoService();
	public static ItemInfoService getInstance(){
		return instance;
	}

	//상품목록페이지
	public final int ARTICLE_PER_PAGE=12;
	public ItemArticlePage getItemArticlePage( HttpServletRequest request ) throws ClassNotFoundException, SQLException{
		int requestedPage = 1;
		if(request.getParameter("page")!=null&&request.getParameter("page").length()!=0){
			requestedPage = Integer.parseInt(request.getParameter("page"));
		}
		ItemArticlePage itemArticlePage = null;
		List<ItemArticle> itemArticleList = null;

		ItemInfoDao itemInfoDao = ItemInfoDao.getInstance();
		itemInfoDao.startConnection();

		int totalArticleNum =  itemInfoDao.getTotalArticleNum();
		System.out.println("totalArticleNum : "+totalArticleNum);
		int totalPageNum = totalArticleNum/ARTICLE_PER_PAGE;
		if(totalArticleNum%ARTICLE_PER_PAGE!=0){
			totalPageNum++;
		}
		int startRow = (requestedPage-1)*ARTICLE_PER_PAGE;

		int startPage = requestedPage - 5;
		if(startPage < 1){
			startPage = 1;
		}
		int endPage = requestedPage + 5;
		if(endPage > totalPageNum){
			endPage = totalPageNum;
		}

		itemArticleList = itemInfoDao.getItemArticleList( startRow, ARTICLE_PER_PAGE);

		itemArticlePage = new ItemArticlePage(itemArticleList, startPage, endPage, requestedPage, totalPageNum);
		itemInfoDao.closeConnection();
		return itemArticlePage;
	}

	//상품정보읽기
	public ItemArticle readItemArticle( HttpServletRequest request ) throws ClassNotFoundException, SQLException{
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		ItemArticle itemArticle = null;

		ItemInfoDao itemInfoDao = ItemInfoDao.getInstance();
		itemInfoDao.startConnection();
		if(itemInfoDao.updateReadCount( articleNo ) > 0){
			itemArticle = itemInfoDao.selectItemArticle(articleNo);
		}
		itemInfoDao.closeConnection();
		return itemArticle;
	}
	
	//수정삭제용 상품정보읽기 (조회수 증가 없음)
	public ItemArticle upDelReadItemArticle( HttpServletRequest request) throws ClassNotFoundException, SQLException{
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		ItemArticle itemArticle = null;

		ItemInfoDao itemInfoDao = ItemInfoDao.getInstance();
		itemInfoDao.startConnection();
		itemArticle = itemInfoDao.selectItemArticle(articleNo);
		itemInfoDao.closeConnection();
		return itemArticle;
	}
	
	//삭제하기
	public int delArticle(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		ItemInfoDao dao = ItemInfoDao.getInstance();
		dao.startConnection();
		int result = 0;
		
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		String userPw = request.getParameter("userPw");
		System.out.println("userPw"+userPw);
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");
		String originalPw = (String) session.getAttribute("pwd");
		System.out.println("userId: "+userId);
//		User user = dao.selectUserInfo(userId); //사용자비번 체크용
//		String originalPw = user.getUserPw();

		if(request.getParameter("articleNo")!=null && originalPw.equals(userPw)){
			result = dao.deleteArticle(articleNo);
		}

		dao.closeConnection();
		return result;
	}
	

}
