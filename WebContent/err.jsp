<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>경고 메세지</title>
	</head>
	<body>
		<script type="text/javascript">
 			alert("${errMsg}");
 			location.href="login?cmd=loginForm";
 		</script>
	</body>
</html>