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
				<shiro:hasPermission name="article:add">
					<li><a href="${baseurl}/article/getArticleType.action">撰写文章</a></li>
				</shiro:hasPermission>
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
						<a href="${baseurl}/login.action">登录</a>
					</c:if>
					<c:if test="${not empty adminUser.username}">
				您好,<a href="#" class="navbar-link">${adminUser.username} </a>
					</c:if>
				</p>
				<c:if test="${not empty adminUser.username}">
					<a href="${baseurl}/logout.action"
						class="btn btn-primary btn-sm navbar-btn">退出</a>
				</c:if>
			</div>
		</div>
	</div>
</div>
<!-- 右侧图标返回顶部 -->
<span id="gotop1"> <span class="glyphicon glyphicon-arrow-up"
	style="font-size: 60px; color: #B0E2FF"></span>
</span>
<script type="text/javascript">
//滚动条事件
	$(function(){$("#gotop1").hide()});
window.onscroll = function(){ 
		if(document.body.scrollTop>100){
			$("#gotop1").show();
		}else{
			$("#gotop1").hide();
		};
	}
	// 默认速度
	$("#gotop1").click(function() {
		$("body").animate({scrollTop:0},1000);
	 });
	//菜单隐藏显示时间
	$('button').on('click', function() {
		$("#myCollapsible").toggle("normal");
	});
	
</script>