<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    
    <style>
    	h3
    	{
    		margin-top: 0px;
    	}
    	
    	.nopadding
    	{
    		padding-left: 0px;
    	}
    </style>

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
                	마이페이지
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- Projects Row -->
        <div class="row">
            <div class="col-md-12 portfolio-item">
                <a class="col-md-2" href="#">
                    <img class="img-responsive" src="http://placehold.it/700x400" alt="">
                </a>
                <h3>
                    <a class="col-md-2 nopadding" href="#">글제목</a>
		        	<button class="btn btn-default col-md-1 col-md-offset-6">글 수정</button>
		        	<button class="btn btn-default col-md-1">글 삭제</button>
                </h3>
                <p class="col-md-4 nopadding">간략한 글설명</p>
	        	<button class="btn btn-default col-md-2 col-md-offset-4">판매완료</button>
                
            </div>

            <div class="col-md-12 portfolio-item">
                <a class="col-md-2" href="#">
                    <img class="img-responsive" src="http://placehold.it/700x400" alt="">
                </a>
                <h3>
                    <a class="col-md-2 nopadding" href="#">글제목</a>
		        	<button class="btn btn-default col-md-1 col-md-offset-6">글 수정</button>
		        	<button class="btn btn-default col-md-1">글 삭제</button>
                </h3>
                <p class="col-md-4 nopadding">간략한 글설명</p>
	        	<button class="btn btn-default col-md-2 col-md-offset-4">판매완료</button>
                
            </div>

            <div class="col-md-12 portfolio-item">
                <a class="col-md-2" href="#">
                    <img class="img-responsive" src="http://placehold.it/700x400" alt="">
                </a>
                <h3>
                    <a class="col-md-2 nopadding" href="#">글제목</a>
		        	<button class="btn btn-default col-md-1 col-md-offset-6">글 수정</button>
		        	<button class="btn btn-default col-md-1">글 삭제</button>
                </h3>
                <p class="col-md-4 nopadding">간략한 글설명</p>
	        	<button class="btn btn-default col-md-2 col-md-offset-4">판매완료</button>
                
            </div>

            <div class="col-md-12 portfolio-item">
                <a class="col-md-2" href="#">
                    <img class="img-responsive" src="http://placehold.it/700x400" alt="">
                </a>
                <h3>
                    <a class="col-md-2 nopadding" href="#">글제목</a>
		        	<button class="btn btn-default col-md-1 col-md-offset-6">글 수정</button>
		        	<button class="btn btn-default col-md-1">글 삭제</button>
                </h3>
                <p class="col-md-4 nopadding">간략한 글설명</p>
	        	<button class="btn btn-default col-md-2 col-md-offset-4">판매완료</button>
                
            </div>

        </div>
        <!-- /.row -->
        
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
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

</body>

</html>
