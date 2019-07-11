






		



<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <base href="http://www.wodechengshi.top:80/">
        <meta charset="utf-8" />
        <title>Quick4j</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <meta name="MobileOptimized" content="320">

        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/select2/select2_metro.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/select2/select2.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN THEME STYLES -->
        <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/plugins.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="assets/css/components.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
        <!-- END THEME STYLES -->

        <link rel="shortcut icon" href="app/img/favicon.ico" />
    </head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class="page-header-fixed">
        <!-- BEGIN HEADER -->
        <div class="header navbar navbar-inverse navbar-fixed-top">
            <!-- BEGIN TOP NAVIGATION BAR -->
            <div class="header-inner">
                <!-- BEGIN LOGO -->
                <a class="navbar-brand" href="javascript:;">
                    <img src="assets/img/logo.png" alt="logo" class="img-responsive" />
                </a>
                <!-- END LOGO -->
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <img
                    src="assets/img/menu-toggler.png" alt="" />
                </a>
                <!-- END RESPONSIVE MENU TOGGLER -->
                <!-- BEGIN TOP NAVIGATION MENU -->
                <ul class="nav navbar-nav pull-right">
                    <li class="dropdown user">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                            <img alt="" src="assets/img/avatar1_small.jpg"/>
                            <span class="username"> starzou </span>
                            <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="javascript:;" id="trigger_fullscreen">
                                    <i class="fa fa-move"></i> 全屏
                                </a>
                            </li>
                            <li>
                                <a href="extra_lock.html">
                                    <i class="fa fa-lock"></i> 锁屏
                                </a>
                            </li>
                            <li>
                                <a href="rest/user/logout">
                                    <i class="fa fa-key"></i> 退出
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!-- END USER LOGIN DROPDOWN -->
                </ul>
                <!-- END TOP NAVIGATION MENU -->
            </div>
            <!-- END TOP NAVIGATION BAR -->
        </div>
        <!-- END HEADER -->
        <div class="clearfix"></div>
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <!-- BEGIN SIDEBAR -->
            



<div class="page-sidebar-wrapper">
                <div class="page-sidebar navbar-collapse collapse">
                    <!-- BEGIN SIDEBAR MENU -->
                    <ul class="page-sidebar-menu" id="page-sidebar-menu">
                        <li class="sidebar-toggler-wrapper">
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                            <div class="sidebar-toggler hidden-phone"></div>
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                        </li>

                        <li class="start active">
                            <a href="rest/page/dashboard" id="btn-dashboard">
                                <i class="fa fa-home"></i><span class="title"> 首页 </span><span
                                class="selected"> </span>
                            </a>
                        </li>

                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-gears"></i><span class="title"> 系统管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;" url='/rest/config/config'>
                                        系统设置
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/user/users'>
                                        用户管理
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/user/roles'>
                                        角色管理
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/user/editPassword'>
                                        密码修改
                                    </a>
                                </li>
                            </ul>
                        </li>
                        
                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-tree"></i><span class="title"> 分类管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;" url='/rest/category/getCategoryList'>
                                        分类列表
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/category/addCategory'>
                                        添加分类
                                    </a>
                                </li>
                            </ul>
                        </li>
                        
                        <li >
                            <a href="javascript:;">
                                <i class="fa fa-tree"></i><span class="title"> 文章管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;" url='/rest/articles/articleList'>
                                        文章列表
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/articles/addArticles'>
                                        添加文章
                                    </a>
                                </li>
                            </ul>
                        </li>
                        
                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-tree"></i><span class="title"> 广告管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;" url='/rest/advert/advertList'>
                                        广告列表
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/advert/addAdvert'>
                                        添加广告
                                    </a>
                                </li>
                            </ul>
                        </li>
                        
                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-tree"></i><span class="title"> 提问管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;" url='/rest/quiz/quiz'>
                                        提问列表
                                    </a>
                                </li>
                            </ul>
                        </li>
                        
                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-tree"></i><span class="title"> 会员管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;" url='/rest/member/member'>
                                        会员列表
                                    </a>
                                </li>
                            </ul>
                        </li>
                        
                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-tree"></i><span class="title"> 其他管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;" url='/rest/version/statistics'>
                                        用户统计
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/version/version'>
                                        应用版本
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/comment/comment'>
                                        评论列表
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/feedback/feedback'>
                                        反馈列表
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;" url='/rest/message/message'>
                                        推送管理
                                    </a>
                                </li>
                            </ul>
                        </li>

                        

                    </ul>
                    <!-- END SIDEBAR MENU -->
                </div>
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="page-content-wrapper">
                <div class="page-content">
                    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
                    <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h4 class="modal-title">Modal title</h4>
                                </div>
                                <div class="modal-body">
                                    Widget settings form goes here
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn blue">
                                        Save changes
                                    </button>
                                    <button type="button" class="btn default" data-dismiss="modal">
                                        Close
                                    </button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal -->
                    <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
                    <!-- BEGIN STYLE CUSTOMIZER -->
                    <div class="theme-panel hidden-xs hidden-sm">
                        <div class="toggler"></div>
                        <div class="toggler-close"></div>
                        <div class="theme-options">
                            <div class="theme-option theme-colors clearfix">
                                <span> 主题颜色 </span>
                                <ul>
                                    <li class="color-black current color-default" data-style="default"></li>
                                    <li class="color-blue" data-style="blue"></li>
                                    <li class="color-brown" data-style="brown"></li>
                                    <li class="color-purple" data-style="purple"></li>
                                    <li class="color-grey" data-style="grey"></li>
                                    <li class="color-white color-light" data-style="light"></li>
                                </ul>
                            </div>
                            <div class="theme-option">
                                <span> 布局 </span>
                                <select class="layout-option form-control input-small">
                                    <option value="fluid">顺序</option>
                                    <option value="boxed">盒状</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 标题 </span>
                                <select class="header-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 工具栏 </span>
                                <select class="sidebar-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 工具栏位置 </span>
                                <select class="sidebar-pos-option form-control input-small">
                                    <option value="left">左边</option>
                                    <option value="right">右边</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 页脚 </span>
                                <select class="footer-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- END STYLE CUSTOMIZER -->

                    <!-- BEGIN PAGE HEADER-->
                    <div class="row">
                        <div class="col-md-12">
                            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                            <h3 class="page-title" id="index-page-title">用户列表</h3>
                            <ul class="page-breadcrumb breadcrumb">
                                <li>
                                    <i class="fa fa-home"></i>
                                    <a href="javascript:;">
                                        首页
                                    </a>
                                    <i class="fa fa-angle-right"></i>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        用户列表
                                    </a>
                                </li>
                            </ul>
                            <!-- END PAGE TITLE & BREADCRUMB-->
                        </div>
                    </div>
                    <!-- END PAGE HEADER-->

                    <!-- BEGIN DASHBOARD STATS -->
                    <div id="main-content">
                    	<div class="portlet-body">
							<a href='javascript:;' data-url='/rest/user/addUsers' class="btn green"> 新增用户<i class="fa fa-plus"></i></a>
							<hr>
						</div>
                    	<div class="table-scrollable">
							<table
								class="table table-striped table-bordered table-advance table-hover">
								<thead>
									<tr>
										<th>编号</th>
										<th>用户名</th>
										<th>角色</th>
										<th>状态</th>
										<th>创建时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									
										<tr>
											<td class="highlight">1</td>
											<td class="hidden-xs">starzou</td>
											<td>admin</td>
											<td>开启</td>
											<td>2014-7-17 12:59:08</td>
											<td></td>
										</tr>
									
										<tr>
											<td class="highlight">2</td>
											<td class="hidden-xs">xlj</td>
											<td>运营</td>
											<td>开启</td>
											<td>2017-3-21 14:30:14</td>
											<td><a href="javascript:;"
												class="btn btn-outline btn-circle btn-sm purple edit"
												data-id="id-2"
												data-url='/rest/user/editUsers'>
													<i class="fa fa-edit"></i> Edit
											</a> <a href="javascript:;"
												class="btn btn-outline btn-circle dark btn-sm black delete"
												data-id="id-2"
												data-url='/rest/user/deleteUsers'>
													<i class="fa fa-trash-o"></i> Delete
											</a></td>
										</tr>
									
										<tr>
											<td class="highlight">3</td>
											<td class="hidden-xs">wt</td>
											<td>wt</td>
											<td>开启</td>
											<td>2017-3-22 16:29:03</td>
											<td><a href="javascript:;"
												class="btn btn-outline btn-circle btn-sm purple edit"
												data-id="id-3"
												data-url='/rest/user/editUsers'>
													<i class="fa fa-edit"></i> Edit
											</a> <a href="javascript:;"
												class="btn btn-outline btn-circle dark btn-sm black delete"
												data-id="id-3"
												data-url='/rest/user/deleteUsers'>
													<i class="fa fa-trash-o"></i> Delete
											</a></td>
										</tr>
									
										<tr>
											<td class="highlight">4</td>
											<td class="hidden-xs">asdfasd</td>
											<td>admin</td>
											<td>开启</td>
											<td>2017-12-22 20:02:10</td>
											<td><a href="javascript:;"
												class="btn btn-outline btn-circle btn-sm purple edit"
												data-id="id-4"
												data-url='/rest/user/editUsers'>
													<i class="fa fa-edit"></i> Edit
											</a> <a href="javascript:;"
												class="btn btn-outline btn-circle dark btn-sm black delete"
												data-id="id-4"
												data-url='/rest/user/deleteUsers'>
													<i class="fa fa-trash-o"></i> Delete
											</a></td>
										</tr>
									
								</tbody>
							</table>
						</div>
                    </div>

                    <!-- END PORTLET-->
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->
        



<div class="footer">
            <div class="footer-inner">
                2014 &copy; Quick4j By Eliteams.
            </div>
            <div class="footer-tools">
                <span class="go-top"><i class="fa fa-angle-up"></i></span>
            </div>
        </div>
        <!--[if lt IE 9]>
        <script src="assets/plugins/respond.min.js"></script>
        <script src="assets/plugins/excanvas.min.js"></script>
        <![endif]-->
        <script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootstrap-toastr/toastr.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
        <script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>

        <script src="assets/plugins/jquery-validation/lib/jquery.form.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="assets/plugins/select2/select2.min.js"></script>
        
        <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    	<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.js"> </script>
    	<script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>

        <script src="assets/scripts/app.js" type="text/javascript"></script>
        <script type="text/javascript" src="app/js/index.js"></script>
        
        <script src="//cdn.hcharts.cn/highcharts/highcharts.js"></script>
        <script src="//cdn.hcharts.cn/highcharts/modules/exporting.js"></script>

        <!-- <script data-main="app/js/main" src="app/lib/requirejs/require.js"></script> -->
    </body>
</html>