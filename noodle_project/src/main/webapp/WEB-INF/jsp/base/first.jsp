<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>首页</title>
</head>
<body>
	<jsp:include page="layout/top.jsp" />
	<div class="container">
		<p class="navbar-text navbar-left navbar-link">
			文章推荐
		</p>
	</div>
</body>
<script type="text/javascript">
	$('button').on('click', function() {
		$("#myCollapsible").toggle("normal");
	});
</script>
</html>