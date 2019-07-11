<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@ include file="/commons/basejs.jsp" %>
        <title>用户登录</title>
       
    </head>
    <body>
        <form id="form_login" action="${path}/login" method="post">
        <div class="mycenter">
            <div class="mysign">
                <div class="col-lg-11 text-center text-info">
                    <h2>请登录后台管理系统</h2>
                </div>
                <div class="col-lg-10">
                    <input id="ipt_username" type="text" class="form-control" name="username" value="admin" placeholder="请输入账户名" required autofocus/>
                </div>
                <div class="col-lg-10"></div>
                <div class="col-lg-10">
                    <input id="ipt_password" type="password" class="form-control" name="password" value="admin" placeholder="请输入密码" required autofocus/>
                </div>
                 <div class="col-lg-10"></div>
                <div class="col-lg-10">
                    <input id="ipt_captcha" type="text" class="form-control" name="captcha" placeholder="请输入验证码" required autofocus/>
                </div>
                <div class="form-group">
                	<img id="captcha-img" src="${path}/captcha"   />
                    <a href="javascript:;" title="点击刷新" id="ipt-refresh">点击刷新</a>
                </div>
                <div class="col-lg-10"></div>
                <div class="col-lg-10 mycheckbox checkbox">
                    <input type="checkbox" class="col-lg-1" name="rememberMe" value="true" >&nbsp;&nbsp;记住密码</input>
                </div>
                <div class="col-lg-10"></div>
                <div class="col-lg-10">
                    <button id="ipt_submit" type="button" class="btn btn-success col-lg-12">立即登录</button>
                </div>
            </div>
        </div>
        </form>
        <div id="common_dialog" style="display: none; text-align: center">
			<div></div>
		</div>
    </body>
</html>