<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>redirect page</title>
<script>
	var errMsg = "${requestScope.errMsg }";
	
	if (errMsg.length > 0) {
		alert(errMsg);
	}

	location.href = "${requestScope.location }";
</script>
</head>
</html>