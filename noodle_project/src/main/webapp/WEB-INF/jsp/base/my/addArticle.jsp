<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<!--UEditor-->
<script type="text/javascript"
	src="${baseurl}/jslib/UEditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="${baseurl}/jslib/UEditor/ueditor.all.js"></script>
<link rel="stylesheet"
	href="${baseurl}/jslib/UEditor/themes/default/dialogbase.css">
<title>添加文章</title>
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="../layout/top.jsp" />
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#addArticle" data-toggle="tab">添加新文章</a></li>
			<li><a href="#articleTypes" data-toggle="tab">文章分类管理</a></li>
			<li><a href="#articleManager" data-toggle="tab">文章管理</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="addArticle">
				<hr />
				<form action="${baseurl}/article/addArticle.action" method="post"
					id="articleForm">
					<div style="margin-bottom: 5px;">
						<select id="select_id" style="float: left;">
							<c:forEach items="${articleTypes}" var="item" varStatus="sta">
								<option value="${item.typeId}">${item.typeName}</option>
							</c:forEach>
						</select>
						<div style="float: left">
							文章标题：<input type="text" id="articleName" name="articleName"
								size="30%">
						</div>
						<dir style="clear: both;"></dir>
					</div>
					<input type="hidden" id="articleTypeId" name="articleTypeId">
					<textarea id="myEditor" name="articleContent"
						style="height: 500px;"></textarea>
					<div style="text-align: center; margin: 50px;">
						<input class="btn btn-primary" style="margin-right: 50px;"
							type="button" id="sub_button" value="文章发布"><input
							class="btn btn-primary" style="margin-left: 50px;" type="button"
							id="back_first" value="回到首页">
					</div>
				</form>
			</div>
			<div class="tab-pane" id="articleTypes">
				<table class="table">
					<tr>
						<td>类别</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${articleTypes}" var="item" varStatus="sta">
						<tr>
							<c:if test="${sta.index%2==1}">
								<td class="active">${item.typeName}</td>
								<td class="active"><span><a href="#">修改</a>|<a href="#">删除</a></span></td>
							</c:if>
							<c:if test="${sta.index%2==0}">
								<td class="info">${item.typeName}</td>
								<td class="info"><span><a href="#">修改</a>|<a href="#">删除</a></span></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="tab-pane" id="articleManager">
				<table class="table">
					<tr>
						<th>文章标题</th>
					</tr>
					<c:forEach items="${articles}" var="item" varStatus="sta">
						<tr>
							<c:if test="${sta.index%2==1}">
								<td class="active">${item.articleName}</td>
							</c:if>
							<c:if test="${sta.index%2==0}">
								<td class="info">${item.articleName}</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	/* ueditorstart */
	var item = {
		toolbars : [
				[ 'fullscreen', 'undo', 'redo', 'bold', 'italic', 'underline',
						'fontborder', 'strikethrough', 'superscript',
						'subscript', 'removeformat                     ',
						'simpleupload', 'lineheight', 'inserttable', '|',
						'justifyleft', 'justifycenter', 'justifyright',
						'justifyjustify' ],
				[ 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain',
						'|', 'forecolor', 'backcolor', 'insertorderedlist',
						'insertunorderedlist', 'selectall', 'cleardoc',
						'fontfamily', 'fontsize' ] ],
		autoHeightEnabled : true, //是否自动长高，默认true  
		autoFloatEnabled : false, //是否保持toolbar的位置不动，默认true  
		wordCount : true, //是否开启字数统计 默认true  
		maximumWords : 100000, //允许的最大字符数 默认值：10000  
		wordOverFlowMsg : "<span style='color:red'>超出范围了！！！！！！！！</span>", //超出字数限制提示  
		elementPathEnabled : false, //是否启用元素路径  
		padding : 0,
		saveInterval : 5000000, // 将其设置大点，模拟去掉自动保存功能  
		allowDivTransToP : false
	};
	//传参生成实例  
	ue = UE.getEditor('myEditor', item);
	/* ueditor  end */
	/* tab切换 start */
	$('#myTab a').click(function(e) {
		e.preventDefault()
		$(this).tab('show')
	})
	$('#myTab a[href="#profile"]').tab('show') // Select tab by name
	$('#myTab a:first').tab('show') // Select first tab
	$('#myTab a:last').tab('show') // Select last tab
	var checkValue = $("#select_id").val();
	$("#articleTypeId").val(checkValue);
	$("#select_id").change(function() {
		var checkValue = $("#select_id").val();
		$("#articleTypeId").val(checkValue);
	});
	/* tab切换 end */
	/* 表单验证start */
	$('#sub_button').on('click', function() {
		if ($("#articleName").val() == "") {
			layer.alert('文章标题未填写!', {
				title : false,
				skin : 'layui-layer-lan',
				closeBtn : 5,
				shift : 3
			});
			return false;
		}
		if (ue.getContent() == "") {
			layer.alert('文章内容未填写!', {
				title : false,
				skin : 'layui-layer-lan',
				closeBtn : 5,
				shift : 3
			});
			return false;
		}
		$("#articleForm").submit();
	});
	/* 表单验证end */
	/* 回到首页 */
	$('#back_first').on('click', function() {
		layer.confirm('确定回到首页吗？', {
			btn : [ '是', '否' ]
		}, function() {
			window.location.href = "${baseurl}/first.action";
		}, function() {
			layer.msg('关闭,停在当前页', {
				icon : 1
			});
		});
	});
</script>
</html>