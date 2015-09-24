<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<title>main.jsp</title>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<style type="text/css">
.gray {
	background-color: eaeaf6;
}

.border {
	border-style: solid;
	border-width:2px;
	border-color:eaeaf6;
}

</style>

<script type="text/javascript">

	$(function() {

		$('.list').addClass('border');
		$('.more').addClass('gray');
		
		$('.more').on('mousedown', function() {
		$(this).children('a').children('img').attr('src', 'img/moreclick.gif');
		})
		$('.more').on('mouseup', function() {
			$(this).children('a').children('img').attr('src', 'img/more.gif');
		})
		
	})
</script>

</head>
<body>
	<table style="margin: 21px;">
		<tr>
			<!-- �Ӹ��� : �޴� ���԰��� -->
			<td width=1500 height=156><%@ include file="nav.jspf" %></td>
		</tr>

		<tr>
			<!-- �ֽż���� -->
			<td><img src="img/newBar.gif"></td>
		</tr>
		<tr>
			<td class="list" width=1461 height=725>�ֽŻ�ǰ!</td>
		</tr>
		<tr>
			<td class="more" width=1500><a href=""><img src="img/more.gif"></a></td>
		</tr>
		<tr>

			<!-- �α��ǰ -->
			<td><img src="img/hotBar.gif"></td>
		</tr>
		<tr>
			<td class="list"  width=1461 height=725>�α��ǰ!</td>
		</tr>
		<tr>
			<td class="more" width=1500><a href=""><img src="img/more.gif"></a></td>
		</tr>
		<tr>

			<!-- �����̾� ��ǰ -->
			<td><img src="img/premiumBar.gif"></td>
		</tr>
		<tr>
			<td class="list"  width=1461 height=725>�����̾� ��ǰ!</td>
		</tr>
		<tr>
			<td class="more" width=1500><a href=""><img src="img/more.gif"></a></td>
		</tr>

		<tr>
			<!-- ���̼��� -->
			<td><img src="img/copyright.gif"></td>
		</tr>
	</table>


</body>
</html>