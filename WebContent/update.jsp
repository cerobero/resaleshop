<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<c:choose>
	<c:when test="${requestScope.result > 0 }">
		<div>수정 성공</div>
	</c:when>
	<c:otherwise>
		<div>수정 실패</div>
	</c:otherwise>
</c:choose>
</body>
</html>