<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: 10px auto; width: 500px">
		<span>欢迎当前用户${adminUser.username}</span> <a
			href="${baseurl}/logout.action">退出登录</a>
	</div>
	<c:forEach items="${adminUser.menus}" var="menu">
		<div style="margin: 10px auto; width: 500px">
			<div>
				<a style="text-decoration: none">${menu.menuname}</a>
			</div>
			<c:forEach items="${menu.menus}" var="m2">
				<div style="padding-top: 8px; padding-left: 25px;">
					<a style="text-decoration: none; font-size: 14px" href="${baseurl}${m2.url}">${m2.menuname}</a>
				</div>
			</c:forEach>
		</div>
	</c:forEach>
</body>
</html>