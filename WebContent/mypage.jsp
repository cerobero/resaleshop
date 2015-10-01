<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>중고(딩)나라</title>

    <!-- Bootstrap Core CSS -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resource/css/3-col-portfolio.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="resource/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resource/js/bootstrap.min.js"></script>
    
    <style>
    	h3
    	{margin-top: 0px;}
    	
    	.nopadding
    	{padding-left: 0px;}
    </style>	
</head>

<body>
	<%@ include file="nav.jsp" %><br>
    
	<c:if test="${empty sessionScope.id }">
	<script type="text/javascript">
 		alert("로그인 된 사용자만 볼 수 있습니다");
 		location.href="login?cmd=loginForm";
 	</script>
	</c:if>
	<br><br>
	
    <!-- Page Content -->
    <div class="container">

        <!-- Page Header -->
        <div class="row">
			<h1 class="page-header text-muted">
				<mark>${sessionScope.id }</mark>님의 마이페이지
            </h1>
        </div>
        <!-- /.row -->

        <!-- Projects Row -->
        <div class="row">
        <div class="col-md-12 portfolio-item">
            
	<table class="table table-striped table-hover">
		<tr class="info">
    		<th class="text-center">글번호</th>
    		<th class="text-center">제 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 목</th>
    		<th class="text-center ">댓 글</th>
    		<th class="text-center">판 매 가</th>
    		<th class="text-center">등 록 일</th>
    		<th class="text-center">현재상태</th>
    		<th class="text-center">변 &nbsp; &nbsp; 경</th>
 		</tr>
		<c:forEach var="article" items="${requestScope.articleList}">
 		<tr>
    		<td class="text-center">${article.articleNo}</td>
			<td class="text-center"><a href="itemInfo?type=read&articleNo=${article.articleNo}">${article.title}</a></td>
<%-- 		<td class="text-center"><a href="read.jsp&articleNo=${article.articleNo}">${article.title}</a></td> --%>
			<td class="text-center text-success"><span class="glyphicon glyphicon-comment"></span> (${article.commentNo})</td>
    		<td class="text-center"><fmt:formatNumber value="${article.price}" pattern="￦ #,###.##"/> </td>
    		<td class="text-center text-warning"><fmt:formatDate value="${article.postingDate}" pattern="yyyy년 M월 d일 H:mm"/></td>
    <c:choose>
    	<c:when test="${article.soldout==1}">
			<td class="text-center"><code>판매완료</code></td>
    	</c:when>
    	<c:when test="${article.soldout==0}">
			<td class="text-center"><kbd>판매중</kbd></td>
    	</c:when>
    </c:choose>
			<td align="center">
			<div class="btn-group-vertical">
				<button type="button" class="btn btn-default" onClick="location.href='login?cmd=soldout&articleNo=${article.articleNo}'"><span class="glyphicon glyphicon-ok"></span> 완료</button>
				<button type="button" class="btn btn-default" onClick="location.href='board?type=updateForm&articleNo=${article.articleNo}'"><span class="glyphicon glyphicon-pencil"></span> 수정</button>
				<button type="button" class="btn btn-default" onClick="location.href='login?cmd=del&articleNo=${article.articleNo}'"><span class="glyphicon glyphicon-trash"></span> 삭제</button>
			</div>
			</td>
  		</tr>
  		</c:forEach>
	</table>
	  </div>
        <!-- /.row -->
        <br><br><br><br><br><br>
        <!-- Pagination -->
        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
        </div>
        <!-- /.row -->
        <hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; 왼쪽팀 2차프로젝트 2015</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>
    </div>
    </div>
    <!-- /.container -->
</body>
</html>
