<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	 <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>用户登录</title>
       
    </head>
<body>
<div class="page-login-main animation-fade">
        	
            <div class="vertical-align">
                <div class="vertical-align-middle">
                    <div class="brand visible-xs text-center">
                        <img class="brand-img" src="http://cdn.admui.com/demo/basic/1.1.0/images/logo.svg" height="50" alt="Admui">
                    </div>
                    <h3 class="hidden-xs">
                        登录 Admui
                        <div class="btn-group version-toggle">
                            <a href="http://demo.admui.com/" class="btn btn-default btn-outline btn-sm">pjax版</a>
                            <a href="http://iframe.demo.admui.com/" class="btn btn-default btn-outline btn-sm">iframe版</a>
                            <a href="javascript:;" class="btn btn-default btn-outline btn-sm active">basic版</a>
                        </div>
                    </h3>
                    <p class="hidden-xs">Admui 在线演示系统</p>
                    <form action="/system/loginValidate" class="login-form fv-form fv-form-bootstrap" method="post" id="loginForm" novalidate="novalidate"><button type="submit" class="fv-hidden-submit" style="display: none; width: 0px; height: 0px;"></button>
                        <div class="form-group">
                            <label class="sr-only" for="identity">选择身份</label>
                            <div class="btn-group bootstrap-select form-control dropup"><button type="button" class="btn dropdown-toggle bs-placeholder btn-select" data-toggle="dropdown" data-id="identity" title="我自己" aria-expanded="false"><span class="filter-option pull-left">我自己</span>&nbsp;<span class="bs-caret"><span class="caret"></span></span></button><div class="dropdown-menu open" style="max-height: 154.6px; overflow: hidden; min-height: 109px;"><ul class="dropdown-menu inner" role="menu" style="max-height: 150.6px; overflow-y: auto; min-height: 105px;"><li data-original-index="0" class="selected"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">我自己</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li class="divider" data-original-index="1"></li><li data-original-index="2"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">夏瑄</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="3"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">张致远</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="4"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">王诗琪</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="5"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">李欣</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="6"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">秦守仁</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="7"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">刘一鸣</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="8"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">王佳琪</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li></ul></div><select class="form-control" id="identity" tabindex="-98">
                                <option value="">我自己</option>
                                <option data-divider="true"></option>
                                <option value="xiaxuan@admui_demo" data-password="123456">夏瑄</option>
                                <option value="zhangzhiyuan@admui_demo" data-password="123456">张致远</option>
                                <option value="wangshiqi@admui_demo" data-password="123456">王诗琪</option>
                                <option value="lixin@admui_demo" data-password="123456">李欣</option>
                                <option value="qinshouren@admui_demo" data-password="123456">秦守仁</option>
                                <option value="liuyiming@admui_demo" data-password="123456">刘一鸣</option>
                                <option value="wangjiaqi@admui_demo" data-password="123456">王佳琪</option>
                            </select></div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="sr-only" for="username">用户名</label>
                            <input type="text" class="form-control" id="username" name="loginName" placeholder="请输入用户名" data-fv-field="loginName"><i class="form-control-feedback" data-fv-icon-for="loginName" style="display: none;"></i>
                        <small class="help-block" data-fv-validator="notEmpty" data-fv-for="loginName" data-fv-result="NOT_VALIDATED" style="display: none;">用户名不能为空</small></div>
                        <div class="form-group has-feedback">
                            <label class="sr-only" for="password">密码</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" data-fv-field="password"><i class="form-control-feedback" data-fv-icon-for="password" style="display: none;"></i>
                        <small class="help-block" data-fv-validator="notEmpty" data-fv-for="password" data-fv-result="NOT_VALIDATED" style="display: none;">密码不能为空</small><small class="help-block" data-fv-validator="stringLength" data-fv-for="password" data-fv-result="NOT_VALIDATED" style="display: none;">密码必须大于6且小于30个字符</small></div>
                        <div class="form-group has-feedback">
                            <label class="sr-only" for="password">验证码</label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="validCode" placeholder="请输入验证码" data-fv-field="validCode">
                                <a class="input-group-addon padding-0 reload-vify" href="javascript:;">
                                    <img src="/system/captcha" height="40">
                                </a>
                            </div><i class="form-control-feedback fv-bootstrap-icon-input-group" data-fv-icon-for="validCode" style="display: none;"></i>
                        <small class="help-block" data-fv-validator="notEmpty" data-fv-for="validCode" data-fv-result="NOT_VALIDATED" style="display: none;">验证码不能为空</small></div>
                        <div class="form-group clearfix">
                            <div class="checkbox-custom checkbox-inline checkbox-primary pull-left">
                                <input type="checkbox" id="remember" name="remember">
                                <label for="remember">自动登录</label>
                            </div>
                            <a class="pull-right collapsed" data-toggle="collapse" href="#forgetPassword" aria-expanded="false" aria-controls="forgetPassword">
                                忘记密码了？
                            </a>
                        </div>
                        <div class="collapse" id="forgetPassword" aria-expanded="true">
                            <div class="alert alert-warning alert-dismissible" role="alert">
                                请联系管理员重置密码。
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block margin-top-30">立即登录</button>
                    </form>
                </div>
            </div>
            <footer class="page-copyright">
                <p>上海畅控 ©
                    <a href="http://www.admui.com" target="_blank">admui.com</a>
                </p>
            </footer>
        </div>
</body>
</html>