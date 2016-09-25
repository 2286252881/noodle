<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>www.woaichinoodle.com</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<div class="page-header">
					<h2>www.woaichinoodle.com</h2>
				</div>
				<form id="index_loginForm" method='post'
					action="${baseurl}/login.action" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label">用户名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="username"
								placeholder="用户名" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">密码</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="password"
								placeholder="密码" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">验证码</label>
						<div class="col-sm-4">
							<input id="randomcode" name="randomcode" size="8" /> <img
								id="randomcode_img" src="${baseurl}/validatecode.jsp" alt=""
								width="56" height="20"> <a
								href=javascript:randomcode_refresh()>刷新</a>
						</div>
						<span>记住我</span><input type="checkbox" name="rememberMe" />
					</div>
					<div class="form-group">
						<div class="col-lg-9 col-lg-offset-3">
							<button type="submit" class="btn btn-primary">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	
	//刷新验证码
	//实现思路，重新给图片的src赋值，后边加时间，防止缓存 
	function randomcode_refresh() {
		$("#randomcode_img").attr('src',
				'${baseurl}/validatecode.jsp?time' + new Date().getTime());
	}
</script>
</html>