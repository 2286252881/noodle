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
<style type="text/css">
#article_title:HOVER {
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="layout/top.jsp" />
	<div class="container" id="container_">
		<div class="row" id="row_">
			<c:forEach items="${articles}" var="item" varStatus="sta">
				<div id="sort${sta.index}" class="alert alert-info">
					<div>
						<div style="float: left;">
							文章类别：
							<c:if test="${item.articleTypeId==1}">
							技术分享
						</c:if>
							<c:if test="${item.articleTypeId==2}">
							精彩生活
						</c:if>
						</div>
						<div style="float: right;">阅读量：${item.articleClick}</div>
						<div style="clear: both;"></div>
					</div>
					<div style="line-height: 30px;">
						<div style="float: left;">
							发布时间：
							<fmt:formatDate value="${item.articleTime}" pattern="yyyy-mm-dd" />
						</div>
						<div style="float: left; margin-left: 15%">
							<c:set var="staCount" value="${staCount+sta.index}"></c:set>
							文章标题：<span id="article_title"
								onclick="article_title(${sta.index})"><strong>${item.articleName}</strong></span>
						</div>
						<div style="clear: both;"></div>
					</div>
					<div style="color: black; line-height: 30px;">${item.articleSubstr}......</div>
					<div class="articleContent" id="articleContent${sta.index}"
						style="color: black; line-height: 30px;">${item.articleContent}</div>
				</div>
			</c:forEach>
		</div>
		<input id="staCount" type="hidden" value="${staCount}">
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$(".articleContent").hide();
	});
	function article_title(index){
		var count=$("#staCount").val()-1;
		$("#articleContent"+index).slideToggle("slow");
		for(var i=0;i<=count;i++){
			if(i!=index){
				$("#articleContent"+i).hide();
			}
		}
		var height=$("#sort"+index).offset().top;
		$("body").animate({scrollTop:height-40},1000);
	}
</script>
</html>