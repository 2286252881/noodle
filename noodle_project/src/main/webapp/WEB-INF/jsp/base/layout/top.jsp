<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../tag.jsp"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse"
				data-target="#myCollapsible">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myCollapsible">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${baseurl}/first.action">我的主页</a></li>
				<li><a href="#">技术分享</a></li>
				<li><a href="#">精彩生活</a></li>
				<li><a href="#">给我留言</a></li>
			</ul>
			<form action="" class="nav navbar-form navbar-left">
				<input type="text" placeholder="搜索" class="from-control">
				<button type="submit">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</form>
			<div class="nav navbar-nav navbar-right">
				<p class="navbar-text">
					<c:if test="${empty adminUser.username}">
						<a href="${baseurl}/login.action">匿名用户</a>
					</c:if>
					<c:if test="${not empty adminUser.username}">
				您好,<a href="#" class="navbar-link">${adminUser.username} </a>
					</c:if>
				</p>
				<a href="#" class="btn btn-primary btn-sm navbar-btn hidden-xs">赞</a>
			</div>
		</div>
	</div>
</div>
<!-- 右侧图标返回顶部 -->
<span id="gotop1"> 
<span class="glyphicon glyphicon-plane" style="font-size: 60px;color: #B0E2FF"></span>
</span>
