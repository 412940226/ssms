<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登录页面</title>
	<link rel="shortcut icon" type="image/x-icon" href="${ctx}/static/image/favicon.ico" mce_href="${ctx}/static/image/favicon.ico"/>
	<link rel="icon" type="image/x-icon" href="${ctx}/static/image/favicon.ico" mce_href="${ctx}/static/image/favicon.ico"/>
	<link rel="stylesheet" href="${ctx}/static/css/reset.css" />
	<link rel="stylesheet" href="${ctx}/static/css/login.css" />
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/login.js"></script>
</head>
<body>
<div class="page">
	<div class="loginwarrp">
		<div class="logo">管理员登陆</div>
        <div class="login_form">
			<form id="Login" name="Login" method="post" onsubmit="" action="login.shtml">
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" id="username" placeholder="请输入用户名" name="username" class="login_input" value="admin">
                                        <span id="count-msg" class="error"></span>
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" id="password" placeholder="请输入密码" name="password" class="login_input" value="admin" >
                                        <span id="password-msg" class="error"></span>
				</li>
				<li class="login-sub">
					<input type="submit" name="Submit" value="登录" />
                    <input type="reset" name="Reset" value="重置" />
				</li>                      
           </form>
		</div>
	</div>
</div>
<script type="text/javascript">
		window.onload = function() {
			var config = {
				vx : 4,
				vy : 4,
				height : 2,
				width : 2,
				count : 100,
				color : "121, 162, 185",
				stroke : "100, 200, 180",
				dist : 6000,
				e_dist : 20000,
				max_conn : 10
			}
			CanvasParticle(config);
		}
	</script>
	<script type="text/javascript" src="${ctx}/static/js/canvas-particle.js"></script>
</body>
</html>
