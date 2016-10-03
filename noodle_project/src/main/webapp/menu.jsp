<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<ul class="_2 nav navbar-nav">
		<li class="active"><a href="#">我的主页</a></li>
		<li><a href="#">技术博客</a></li>
		<li><a href="#">精彩生活</a></li>
		<li><a href="#">关于我</a></li>
		<li><a href="#">给我留言</a></li>
	</ul>
	<form action="" class="nav navbar-form navbar-left">
		<input type="text" placeholder="搜索" class="from-control">
		<button type="submit">
			<span class="glyphicon glyphicon-search"></span>
		</button>
	</form>
	<div class="_1 navbar-right">
		<ul class="nav navbar-nav">
			<li><a href="" data-toggle="modal" data-target="#login-modal">登录</a></li>
			<li><a href="#">注册</a></li>
		</ul>
		<p class="navbar-text">
			<c:if test="${empty adminUser}">
					匿名用户
				</c:if>
			<c:if test="${not empty adminUser}">
					您好,<a href="${baseurl}/getUserById?id=${adminUser.id}"
					class="navbar-link"> ${adminUser.username} </a>
			</c:if>
		</p>
		<a href="#" class="btn btn-primary btn-sm navbar-btn navbar-right">赞一个</a>
	</div>
	<div class="modal fade" id="login-modal" tabindex="-1">
		<div class="modal-dialog modal-lg modal-md modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4>用户登录</h4>
				</div>
				<div class="modal-body">
					<form id="index_loginForm" method='post' action="/login.action">
						<div class="form-group">
							<label class="control-label">用户名</label> <input type="text"
								class="form-control" name="username" placeholder="用户名" />
						</div>
						<div class="form-group">
							<label class="control-label">密码</label> <input type="password"
								class="form-control" name="password" placeholder="密码" />
						</div>
						<div class="form-group">
							<label class="control-label">验证码</label> <input id="randomcode"
								name="randomcode" size="8" /> <img id="randomcode_img"
								src="/noodle/validatecode.jsp" width="56" height="20"> <a
								href=javascript:randomcode_refresh()>刷新</a>
						</div>
						<div class="form-group">
							<label class="control-label"></label>
							<div>
								<button type="submit" class="btn btn-primary">登录</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button input="id_submit" class="btn btn-primary">登录</button>
				</div>
			</div>
		</div>
	</div>
</div>
