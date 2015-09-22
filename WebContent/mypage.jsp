<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
<!--     <script src="resource/js/jquery.js"></script> -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resource/js/bootstrap.min.js"></script>
    
    <style>
    	h3
    	{
    		margin-top: 0px;
    	}
    	
    	.nopadding
    	{
    		padding-left: 0px;
    	}
    	
    	<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;border-color:#aaa;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#aaa;color:#333;background-color:#fff;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#aaa;color:#fff;background-color:#f38630;}
.tg .tg-cxkv{background-color:#ffffff}
.tg .tg-3xho{font-weight:bold;background-color:#ffc702;color:#000000;text-align:center}
.tg .tg-q64d{background-color:#ffffff;color:#333333}
    </style>

</head>

<body>

	<%@ include file="nav.jspf" %>
    <br>
    
<c:if test="${empty sessionScope.id }">
	<script type="text/javascript">
 	alert("로그인 된 사용자만 볼 수 있어요");
 	location.href="login?cmd=loginForm";
 	</script>
</c:if>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Header -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                	[${sessionScope.id }]님의 마이페이지
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- Projects Row -->
        <div class="row">
            <div class="col-md-12 portfolio-item">
<!--                 <a class="col-md-2" href="#"> -->
<!--                     <img class="img-responsive" src="http://placehold.it/700x400" alt=""> -->
<!--                 </a> -->
            
            <table class="tg" style="undefined;table-layout: fixed; width: 700px">
<colgroup>
<col style="width: 70px">
<col style="width: 280px">
<col style="width: 80px">
<col style="width: 180px">
<col style="width: 100px">
<col style="width: 100px">
</colgroup>
  <tr>
    <th class="tg-3xho">글번호</th>
    <th class="tg-3xho">제목</th>
    <th class="tg-3xho">판매가</th>
    <th class="tg-3xho">등록일</th>
    <th class="tg-3xho">현재상태</th>
    <th class="tg-3xho">변경</th>
 </tr>
  <c:forEach var="article" items="${requestScope.articleList}">
  <tr>
    <td class="tg-q64d" align="center">${article.articleNo}</td>
    <td class="tg-q64d" align="center">${article.title}</td>
<%--     <td class="tg-q64d" align="center"><a href="login?cmd=read&articleNum=${article.articleNo}">${article.title}</a></td> --%>
<%--     <td class="tg-q64d" align="center"><a href="read.jsp&articleNum=${article.articleNo}">${article.title}</a></td> --%>
    <td class="tg-cxkv" align="center">${article.price}</td>
    <td class="tg-cxkv" align="center"><fmt:formatDate value="${article.postingDate}" pattern="yyyy년 MM월 dd일 h:mm"/></td>
    <c:choose>
    <c:when test="${article.soldout==1}">
	<td align="center">판매완료</td>
    </c:when>
    <c:when test="${article.soldout==0}">
	<td align="center">판매중</td>
    </c:when>
    </c:choose>
	<td>
	<button type="button" onClick="location.href='login?cmd=soldout&articleNum=${article.articleNo}'">완료처리</button>
	<button type="button" onClick="location.href='login?cmd=del&articleNum=${article.articleNo}'">삭제</button>
<%--  <button type="button" onClick="location.href='login?cmd=mod&articleNum=${article.articleNo}'">수정</button> --%>

<!-- 	</form> -->

	</td>
  </tr>
  </c:forEach>
</table>
	       </div>
        <!-- /.row -->
        <br><br><br><br><br><br><br>
        <!-- Pagination -->
        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
                    <li>
                        <a href="#">&laquo;</a>
                    </li>
                    <li class="active">
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                    <li>
                        <a href="#">&raquo;</a>
                    </li>
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
