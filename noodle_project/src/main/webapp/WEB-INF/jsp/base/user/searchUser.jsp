<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户信息</title>
</head>
<body>
	<jsp:include page="../Layout/left.jsp"/>
	<div class="container">
		<div class="row">
			<table>
				<tr>
					<th>编号</th>
					<th>姓名</th>
				</tr>
					<c:forEach items="${users}" var="item" varStatus="sta">
				<tr>
						<td><c:out value="${sta.index+1}"></c:out> </td>
						<td>${item.username}</td>
				</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>