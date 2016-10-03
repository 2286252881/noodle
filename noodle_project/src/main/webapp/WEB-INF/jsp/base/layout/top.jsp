<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../tag.jsp"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<ul class="_2 nav navbar-nav">
		<li class="active"><a href="#">我的主页</a></li>
		<li><a href="">技术分享</a></li>
		<li><a href="">精彩生活</a></li>
		<li><a href="">关于我</a></li>
		<li><a href="">给我留言</a></li>
	</ul>
	<form action="" class="nav navbar-form navbar-left">
		<input type="text" placeholder="搜索" class="from-control">
		<button type="submit">
			<span class="glyphicon glyphicon-search"></span>
		</button>
	</form>
	<div class="_1 navbar-right">
		<p class="navbar-text">
			<c:if test="${empty adminUser.username}">
				匿名用户
			</c:if>
			<c:if test="${not empty adminUser.username}">
				您好,<a href="#" class="navbar-link">${adminUser.username} </a>
			</c:if>
		</p>
		<a href="#" class="btn btn-primary btn-sm navbar-btn navbar-right">赞一个</a>
	</div>
</div>