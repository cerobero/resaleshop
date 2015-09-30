<%@page import="vo.ArticlePage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<%@ include file="nav.jspf" %>

    <br>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Header -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                	<c:choose>
                		<c:when test="${param.categoryId == 1 }">
                			IT - 최신 등록상품
                		</c:when>
                		<c:when test="${param.categoryId == 2 }">
                			APPLIANCES - 최신 등록상품
                		</c:when>
                		<c:when test="${param.categoryId == 3 }">
                			CAR - 최신 등록상품
                		</c:when>
                		<c:when test="${param.categoryId == 4 }">
                			HOBBY - 최신 등록상품
                		</c:when>
                		<c:when test="${param.categoryId == 5 }">
                			CLOTHES - 최신 등록상품
                		</c:when>
                		<c:otherwise>
		                	전체 - 최신 등록상품
                		</c:otherwise>
                	</c:choose>
                </h1>
            </div>
        </div>
        <!-- /.row -->

		<c:if test="${requestScope.articlePage.pageArticleCount > 0 }">
			<div class="row">
				<c:forEach var="article" items="${requestScope.articlePage.articleList }" begin="0" end="${requestScope.articlePage.pageArticleCount > 4 ? 4 - 1 : requestScope.articlePage.pageArticleCount }">
					<div class="col-md-3 portfolio-item">
						<a href="#">
	                    	<img class="img-responsive" src="http://placehold.it/700x400" alt="">
		                </a>
		                <h3>
		                    <a href="#">${article.title }</a>
		                </h3>
		                <p class="text-overflow">${article.content }</p>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${requestScope.articlePage.pageArticleCount > 4 }">
			<div class="row">
				<c:forEach var="article" items="${requestScope.articlePage.articleList }" begin="4" end="${requestScope.articlePage.pageArticleCount - 1 }">
					<div class="col-md-3 portfolio-item">
						<a href="#">
	                    	<img class="img-responsive" src="http://placehold.it/700x400" alt="">
		                </a>
		                <h3>
		                    <a href="#">${article.title }</a>
		                </h3>
		                <p class="text-overflow">${article.content }</p>
					</div>
				</c:forEach>
			</div>
		</c:if>
        
        <!-- Pagination -->
        <c:if test="${requestScope.articlePage.articleCount > 0 }">
        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
               		<c:if test="${requestScope.articlePage.currentPage != requestScope.articlePage.startPage }">
	                    <li>
	               			<a href="list?categoryId=${param.categoryId }&page=${requestScope.articlePage.currentPage - 1 }">&laquo;</a>
	                    </li>
               		</c:if>
                    <c:forEach var="num" begin="${requestScope.articlePage.startPage }" end="${requestScope.articlePage.endPage }" varStatus="status">
                    	<c:choose>
                    		<c:when test="${requestScope.articlePage.currentPage == num }">
                    			<li>
									<a class="active" href="list?categoryId=${param.categoryId }&page=${num }">${num }</a>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="list?categoryId=${param.categoryId }&page=${num }">${num }</a>
								</li>
							</c:otherwise>
                    	</c:choose>
                    </c:forEach>
                    <c:if test="${requestScope.articlePage.currentPage != requestScope.articlePage.endPage }">
	                    <li>
	                        <a href="list?categoryId=${param.categoryId }&page=${requestScope.articlePage.currentPage + 1 }">&raquo;</a>
	                    </li>
                    </c:if>
                </ul>
            </div>
        </div>
        
        <div class="row">
	        <form class="input-form" role="search">
	        	<div class="col-lg-4 col-lg-offset-4">
					<div class="input-group">
						<input type="text" class="form-control" style="margin-right: 35px, border: 1px solid black;" placeholder="검색">
						<span class="input-group-btn">
							<button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-search">
									<span class="sr-only">검색</span>
								</span>
							</button>
						</span>
					</div>
				</div>
			</form>
		</div>
        <!-- /.row -->

        <hr>
        </c:if>

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
