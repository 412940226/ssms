$(function () {
    // 得到焦点
    
    // 失去焦点
   
    // 验证码
	$("#ipt-refresh").on("click",function(){
		showDialog("点击刷新验证码");
		$("#captcha-img").attr("src",basePath + "/captcha?"+new Date().getTime()+"");
	});
    // 登录
//	$("#ipt_submit").click(function() {
//		if (!check()) {
//			return;
//		}
//		$.post(basePath + '/login', $('#form_login').serialize(), function(data) {
//			if (data.code == 1) {
//				//登录成功
//				location.href = basePath + '/index';
//
//			} else if (data.code == 0) {
//				//登录失败
//				showDialog(data.msg);
//			}
//		});
//	});
	$("#ipt_submit").on("click",function(){
		console.log("2222")
		$.ajax({
			url:basePath + '/login',
			type:'post',
			dataType:'json',
			data:$('#form_login').serialize(),
			success:function(data){ 
				 if(data.code == 1){
					 console.log("front ==== in")
					 location.href = basePath + '/index';
				 }else if(data.code == 0){
					 showDialog(data.msg);
				 }
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){ 
				showDialog("网络异常，请稍后重试"); 	
				return false;
			}
		});
	});
	//回车登录
	$("#form_login input").keypress(function(event) {
		if (event.keyCode == 13) {
			$("#ipt_submit").click();
		}
	});
	//检查参数
	function check() {
		if (!checkUsername()) {
			return false;
		}
		if (!checkPassword()) {
			return false;
		}
		return true;
	}
	//检测用户名
	function checkUsername() {
		var username = $("#ipt_username").val();
		if (username.trim().length == 0) {
			//用户名为空
			showDialog("用户名为空");
			return false;
		}
		return true;
	}
	//检查密码
	function checkPassword() {
		var password = $("#ipt_password").val();
		if (password.trim().length == 0) {
			//密码为空
			showDialog("密码为空");
			return false;
		}
	}
	//弹出框
	function showDialog(msg, title) {
		
		$("#common_dialog div").html(msg);
		title = title || '提示';
		$("#common_dialog").dialog({
			closeText : "关闭",
			resizable : false,
			modal : true,
			title : title,
			buttons : [ {
				text : "确定",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});
	}
	
	
	
});