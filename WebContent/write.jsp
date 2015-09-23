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
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

<script type="text/javascript">
function test(){
	$('#content').val(document.getElementById("editor").innerHTML);
	}
$('#target').submit(function() {
// 	$('#content').val($('#editor').text());
	
	alert(document.getElementById("editor").innerHTML);
});
</script>
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

    <!--  WYSIWYG-Text-Editor -->
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	
    <link rel="apple-touch-icon" href="//mindmup.s3.amazonaws.com/lib/img/apple-touch-icon.png" />
    <link rel="shortcut icon" href="http://mindmup.s3.amazonaws.com/lib/img/favicon.ico" >
    <link href="resource/bootstrap-wysiwyg-master/external/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
		<script src="resource/bootstrap-wysiwyg-master/external/jquery.hotkeys.js"></script>
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    <script src="resource/bootstrap-wysiwyg-master/external/google-code-prettify/prettify.js"></script>
		<link href="resource/bootstrap-wysiwyg-master/index.css" rel="stylesheet">
    <script src="resource/bootstrap-wysiwyg-master/bootstrap-wysiwyg.js"></script>
    
	<script>
	  $(function(){
	    function initToolbarBootstrapBindings() {
	      var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier', 
	            'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
	            'Times New Roman', 'Verdana'],
	            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
	      $.each(fonts, function (idx, fontName) {
	          fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
	      });
	      $('a[title]').tooltip({container:'body'});
	    	$('.dropdown-menu input').click(function() {return false;})
			    .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
	        .keydown('esc', function () {this.value='';$(this).change();});
	
	      $('[data-role=magic-overlay]').each(function () { 
	        var overlay = $(this), target = $(overlay.data('target')); 
	        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
	      });
	      if ("onwebkitspeechchange"  in document.createElement("input")) {
	        var editorOffset = $('#editor').offset();
	        $('#voiceBtn').css('position','absolute').offset({top: editorOffset.top, left: editorOffset.left+$('#editor').innerWidth()-35});
	      } else {
	        $('#voiceBtn').hide();
	      }
		};
		function showErrorAlert (reason, detail) {
			var msg='';
			if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
			else {
				console.log("error uploading file", reason, detail);
			}
			$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
			 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
		};
	    initToolbarBootstrapBindings();  
		$('#editor').wysiwyg({ fileUploadError: showErrorAlert} );
	    window.prettyPrint && prettyPrint();
	  });
	</script>
	
	<style>
		.controls
		{
			width: 100%;
			margin-top: 10px;			
		}
		
		.control-label
		{
			width: 80px;
		}
		
		.input-xlarge
		{
			width: 80%;
		}
		
		.input-large
		{
			margin-right: 30px;
		}
		
		input[type=file] {
			display: inline;
		}
	</style>

</head>

<body>

	<%@ include file="nav.jspf" %>

    <br>
    <c:if test="${empty sessionScope.id }">
	<script type="text/javascript">
 		alert("로그인 된 사용자만 볼 수 있습니다");
 		location.href="login?cmd=loginForm";
 	</script>
	</c:if>
	<div class="container">
	<form class="form-group" action="write" method="POST" enctype="multipart/form-data">
	  <div class="hero-unit">
		<div id="legend">
		  <h1 class="page-header">글쓰기</h1>
		</div>

		<!---
		Please read this before copying the toolbar:
	
		* One of the best things about this widget is that it does not impose any styling on you, and that it allows you 
		* to create a custom toolbar with the options and functions that are good for your particular use. This toolbar
		* is just an example - don't just copy it and force yourself to use the demo styling. Create your own. Read 
		* this page to understand how to customise it:
	    * https://github.com/mindmup/bootstrap-wysiwyg/blob/master/README.md#customising-
		--->
		<div class="control-group">
			<div class="controls">
				<label class="control-label" for="title">제목</label>
				<input type="text" id="title" class="input-xlarge" name ="title">
			</div>
		</div>
		
		<div class="control-group">
			<div class="controls">
<!-- 				<label class="control-label" for="item">상품명</label> -->
<!-- 				<input type="text" id="item" class="input-large"> -->
				
				<label class="control-label" for="price" style="width: 60px;">가격</label>
				<input type="text" id="price" class="input-large" name="price">
				
				<label class="control-label" for="photo">사진등록</label>
				<input type="file" id="item" class="btn btn-default btn-file" name="photo">
			</div>
		</div>
		
		<div class="control-group">
			<div class="controls">
				<label class="control-label">카테고리</label>
					<input type="radio" value="1" name="categoryId" checked>&nbsp;It기기&nbsp;
					<input type="radio" value="2" name="categoryId">&nbsp;가전제품&nbsp;
					<input type="radio" value="3" name="categoryId">&nbsp;중고차&nbsp;
					<input type="radio" value="4" name="categoryId">&nbsp;취미&nbsp;
					<input type="radio" value="5" name="categoryId">&nbsp;의복&nbsp;
			</div>
			
			<div class="controls">
				<label class="control-label">프리미엄</label>
					<input type="radio" value="1" name="premiume">&nbsp;사용&nbsp;
					<input type="radio" value="0" name="premiume" checked>&nbsp;사용안함&nbsp;
			</div>
		</div>
		
		<br>
		
	    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
	      <div class="btn-group">
	        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="icon-font"></i><b class="caret"></b></a>
	          <ul class="dropdown-menu">
	          </ul>
	        </div>
	      <div class="btn-group">
	        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
	          <ul class="dropdown-menu">
	          <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
	          <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
	          <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
	          </ul>
	      </div>
	      <div class="btn-group">
	        <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
	        <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
	        <a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="icon-strikethrough"></i></a>
	        <a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
	      </div>
	      <div class="btn-group">
	        <a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="icon-list-ul"></i></a>
	        <a class="btn" data-edit="insertorderedlist" title="Number list"><i class="icon-list-ol"></i></a>
	        <a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
	        <a class="btn" data-edit="indent" title="Indent (Tab)"><i class="icon-indent-right"></i></a>
	      </div>
	      <div class="btn-group">
	        <a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
	        <a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
	        <a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
	        <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
	      </div>
	      
	      <div class="btn-group">
	        <a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="icon-picture"></i></a>
	        <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
	      </div>
	      <div class="btn-group">
	        <a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
	        <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
	      </div>
	      <input type="text" data-edit="inserttext" id="voiceBtn" x-webkit-speech="">
	    </div>
	
	    <div id="editor">
	    </div>
	    
	    <br>
	    
	    <div class="control-group text-center">
	      <!-- Button -->
	      <div class="controls">
	      <input type="hidden" id="content" name="content">
	      <input type="hidden" name="type" value="write">
	        <button class="btn btn-success" type="submit" id="target" onclick="test()">쓰기</button>
	        <button class="btn btn-success">취소</button>
	      </div>
	    </div>
		</div>    
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
    
</body>

</html>
