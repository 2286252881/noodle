<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>菜单</title>
<style type="text/css">
	.a_:HOVER {
		cursor: pointer;
	}
}
</style>
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
			<c:forEach items="${menu.menus}" var="m2" varStatus="sta">
				<div style="padding-top: 8px; padding-left: 25px;">
					<a class="a_" onclick="fun_('${baseurl}${m2.url}')"
						style="text-decoration: none; font-size: 14px">${m2.menuname}</a>
				</div>
			</c:forEach>
		</div>
	</c:forEach>
	<script type="text/javascript">
	var fun_=function(StrUrl)
		{
			alert(StrUrl);
			$.ajax({
				 url:StrUrl,// 跳转到 action  
				 type:'post',  
				 cache:false,  
				 dataType:'json', 
				 success:function(data){
					 console.info(data);
					 if(typeof(data.resultInfo)=="undefined"){
						 alert(data.length);
					 }else{
						 alert(data.resultInfo.message);
					 };
				 }
			});
		}
	</script>
</body>
</html>