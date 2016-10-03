<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>拒绝访问提示</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
	<table>
		<tr>
			<td>
				<div id="tabBtnContainer" width="100%">
					<ul>
						<li><a href="#"></a>提示信息</li>
					</ul>
				</div>
			</td>
		</tr>
		<tr>
			<td style="font-size: 14px; color: #ff0000; padding-top: 2px;"
				align='center' valign="middle"><span
				style="vertical-align: middle">${exceptionResultInfo}</span></td>
		</tr>
	</table>
</body>
</html>