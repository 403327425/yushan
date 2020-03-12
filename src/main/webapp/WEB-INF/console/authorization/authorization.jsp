<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>微信授权</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/style.css">
</head>
<body>
 <div class="warp">
 	<div align="center" style="margin-top:200px;">
 	<img src="${root}/upload/logo2.png" style="width:80%"><br/><br/>
 	 	
 	 	网页由该公众号开发，请确认授权以下信息<br/>
 	 	· 获得你的公开信息（昵称、头像等）
 	</div>
 	 <div align="center">
	 	<button type="button" class="layui-btn layui-btn-fluid " id="ok" style="margin-top:100px;background:green;width:80%">确认授权</button>
	 </div>
 </div>
 			<script type="text/javascript" src="${root}/js/layer/layer.js"></script>
			<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
			<script src="${root}/js/webuploader.min.js"></script>
			<script src="${root}/js/diyUpload.js"></script>
<script>
layui.config({
    base: '${root}/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index','laydate','upload','form' ,'jquery','element', 'layer','table'], function(){
 
});
$("#ok").click(function(){
	
	
});
</script>
</body>
</html>