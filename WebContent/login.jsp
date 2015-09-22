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

</head>

<body>
	
	<%@ include file="nav.jspf" %>

    <br>
    
    <!--  Register form -->
    <div class="container">
		  <fieldset>
		    <div id="legend">
		      <h1 class="page-header">로그인</h1>
		    </div>
		    
		    <div class="row">
				<div class="col-md-4">
		    		<div class="panel panel-default">
					  	<div class="panel-heading">
					    	<h3 class="panel-title">회원 로그인</h3>
					 	</div>
					  	<div class="panel-body">
					    	<form method="post" action="login?cmd=login" accept-charset="UTF-8" role="form">
		                    <fieldset>
					    	  	<div class="form-group">
					    		    <input class="form-control" placeholder="아이디" name="id" type="text">
					    		</div>
					    		<div class="form-group">
					    			<input class="form-control" placeholder="비밀번호" name="pwd" type="password">
					    		</div>
					    		<div class="checkbox">
					    	    	<label>
					    	    		<input name="remember" type="checkbox" value="Remember Me"> 로그인 상태 유지
					    	    	</label>
					    	    </div>
					    		<input class="btn btn-lg btn-success btn-block" type="submit" value="로그인">
					    	</fieldset>
					      	</form>
					    </div>
					</div>
				</div>
			</div>
		  </fieldset>

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
