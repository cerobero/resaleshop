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
	    <form class="form-horizontal" action='' method="POST">
		  <fieldset>
		    <div id="legend">
		      <h1 class="page-header">회원가입</h1>
		    </div>
		    <div class="control-group">
		      <!-- userid -->
		      <label class="control-label"  for="userid">아이디</label>
		      <div class="controls">
		        <input type="text" id="userid" name="userid" placeholder="" class="input-xlarge">
		        <p class="help-block">띄어쓰기 없이 영문과 숫자를 혼합하여 4~12자를 사용할 수 있습니다.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Password-->
		      <label class="control-label" for="password">비밀번호</label>
		      <div class="controls">
		        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
		        <p class="help-block">최소한 4자 이상을 사용해 주세요.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Password_confirm -->
		      <label class="control-label"  for="password_confirm">비밀번호 확인</label>
		      <div class="controls">
		        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
		        <p class="help-block">비밀번호를 다시 입력해주세요.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Username -->
		      <label class="control-label" for="username">이름</label>
		      <div class="controls">
		        <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
		        <p class="help-block">이름을 입력해주세요.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Userphone -->
		      <label class="control-label" for="userphone">휴대폰 번호</label>
		      <div class="controls">
		        <input type="text" id="userphone" name="userphone" placeholder="" class="input-xlarge">
		        <p class="help-block">휴대폰 번호를 입력해주세요.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Username -->
		      <label class="control-label" for="useremail">이메일</label>
		      <div class="controls">
		        <input type="text" id="useremail" name="useremail" placeholder="" class="input-xlarge">
		        <p class="help-block">이메일을 입력해주세요.</p>
		      </div>
		    </div>
		    
		    <br>
		 
		    <div class="control-group">
		      <!-- Button -->
		      <div class="controls">
		        <button class="btn btn-success">회원가입</button>
		      </div>
		    </div>
		  </fieldset>
		</form>

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
