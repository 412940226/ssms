<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jquery qrcode</title>
<script type="text/javascript" src="${ctx}/static/front/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/front/js/jquery.qrcode.min.js"></script>
</head>
<body>
	<div id="code"></div>
	
	<script type="text/javascript">
		function toUtf8(str){
			var out="";
			var c;
			for(i=0;i<str.length;i++){
				c=str.charCodeAt(i);
				console.log(str);
				console.log(c);
				if((c>=0x0001) && (c<=0x007F)){
					out+=str.charAt(i);
				} else if(c>0x07FF){
					out+=String.fromCharCode(0xE0|((c>>12)& 0x0F));
					out+=String.fromCharCode(0x80|((c>>6) & 0x3F));
					out+=String.fromCharCode(0x80|((c>>0) & 0x3F));
				} else{
					out+=String.fromCharCode(0xC0|((c>>6) & 0x1F));
					out+=String.fromCharCode(0x80|((c>>0) & 0x3F));
				}
			}
			return out;
		}
		var str = toUtf8("我爱你");
		$('#code').qrcode(str);
		
		console.log(str);
// 		$('#code').qrcode({
// 			render:'table',
// 			width:200,
// 			hight:200,
// 			text:'str'
// 		});
	</script>
</body>
</html>