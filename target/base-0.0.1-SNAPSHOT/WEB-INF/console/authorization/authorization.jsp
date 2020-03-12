<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>微信授权</title>
</head>
<body>
 <button type="button" class="layui-btn layui-btn-fluid " id="ok" style="margin-top:25px;">确认授权</button>
 
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
    upload=layui.upload;
    upload.render({
    	  elem: '.test1'
    	  ,done: function(res, index, upload){
    	    var item = this.item;
    	    if(res.code>0){    
                return layer.msg('图片加载失败');
              }else{       //上传成功    
            	  $("#showbox").attr("style","display:block;");
            	  $("#showbox").empty();
            	  $("#showbox").append("<input type='hidden' value="+res.data.src+" id='qrCode' name='qrCode'/><img src='${root}/upload/"+res.data.src+"' />");
                  layer.msg("图片加载完成");           
              }    
    	  }
    	  ,url:'${root}/vote/saveQRImage'
    	})
  })
  
$("#insert").click(function(){
	var schoolName = $("#schoolName").val();
	var groupName = $("#groupName").val();
	var qrCode = $("#qrCode").val();
	
	
	if(btnclick()){
		$.ajax({
		    url :"${root}/vote/saveQRMsg", 
		    type : "post", 
		    data :   { "schoolName":schoolName,"groupName" : groupName ,"qrCode":qrCode},
		    dataType : "json", 
		    success : function(data)
		    {
				if(data.msg>0){
					layer.msg('保存成功');
					$("#showbox").empty();
					
					$("#groupName").val("");
				}else{
					layer.msg('保存失败');
				}
				
		    }, 
		    error: function (XMLHttpRequest, textStatus, errorThrown)
		    {
		        console.log(XMLHttpRequest);
		        console.log(textStatus);
		        console.log(errorThrown);
		    }
		});
	}
	 
});
function btnclick(){
	var schoolName = $("#schoolName").val();
	var groupName = $("#groupName").val();
	var qrCode = $("#qrCode").val();
	if(schoolName=="-1"){
		layer.msg("选择学校名");
		return false;
	}
	if(!groupName){
		layer.msg("请输入聊天群名称");
		return false;
	}
	if(!qrCode){
		layer.msg("请上传二维码");
		return false;
		
	}
	return true;
}
</script>
</body>
</html>