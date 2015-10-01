<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="vo.ArticlePage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script src="resource/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resource/js/bootstrap.min.js"></script>

</head>

<body>

	<%@ include file="nav.jsp"%>

	<br>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					최신 등록상품! <small><a href="list">더보기</a></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<c:choose>
				<c:when test="${empty requestScope.newProductPage.articleList }">
					<h3>게시물 없음</h3>
				</c:when>
				<c:otherwise>
					<c:forEach var="article"
						items="${requestScope.newProductPage.articleList }">
						<div class="col-md-3 portfolio-item">
							<a href="itemInfo?type=read&articleNo=${article.articleNo}">
								<img class="img-responsive" src="${article.photo}" alt="">
							</a>
							<h4>
								<a href="itemInfo?type=read&articleNo=${article.articleNo}">${article.title}</a>
							</h4>
							<p>${article.content}</p>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<%-- 	<div class="row text-center">
			<c:forEach var="i"
				begin="${requestScope.getNewArticlePage.startPage}"
				end="${requestScope.getNewArticlePage.endPage }">
				<a href="index?type=index&new_page=${i }">[${i }]</a>
			</c:forEach>
		</div> --%>
		<!-- /.row -->

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					HOT! 등록상품 <small><a href="list?view=hot">더보기</a></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<c:choose>
				<c:when test="${empty requestScope.hotProductPage.articleList }">
					<h3>게시물 없음</h3>
				</c:when>
				<c:otherwise>
					<c:forEach var="article"
						items="${requestScope.hotProductPage.articleList }">
						<div class="col-md-3 portfolio-item">
							<a href="itemInfo?type=read&articleNo=${article.articleNo}">
								<img class="img-responsive" src="${article.photo}" alt="">
							</a>
							<h4>
								<a href="itemInfo?type=read&articleNo=${article.articleNo}">${article.title}</a>
							</h4>
							<p>${article.content}</p>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<%-- 		<div class="row text-center">
			<c:forEach var="i"
				begin="${requestScope.getHotProductPage.startPage}"
				end="${requestScope.getHotProductPage.endPage }">
				<a href="index?type=index&hot_page=${i }">[${i }]</a>
			</c:forEach>
		</div> --%>
		<!-- /.row -->

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					프리미엄 등록상품 <small><a href="list?view=premium">더 보기</a></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<c:choose>
				<c:when test="${empty requestScope.premiumProductPage.articleList }">
					<h3>게시물 없음</h3>
				</c:when>
				<c:otherwise>
					<c:forEach var="article"
						items="${requestScope.premiumProductPage.articleList }">
						<div class="col-md-3 portfolio-item">
							<a href="itemInfo?type=read&articleNo=${article.articleNo}">
								<img class="img-responsive" src="${article.photo}" alt="">
							</a>
							<h4>
								<a href="itemInfo?type=read&articleNo=${article.articleNo}">${article.title}</a>
							</h4>
							<p>${article.content}</p>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<%-- 		<div class="row text-center">
			<c:forEach var="i"
				begin="${requestScope.getPremiumProductPage.startPage}"
				end="${requestScope.getPremiumProductPage.endPage }">
				<a href="index?type=list&premium_page=${i }">[${i }]</a>
			</c:forEach>
		</div> --%>
		<!-- /.row -->

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

</body>

</html>
