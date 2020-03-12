<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>添加</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="https://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css"> 
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>
<script type="text/javascript" src="${root}/js/jquery-1.11.3.min.js"></script>
</head>
<body >
<div class="warp">
<form class="layui-form" action="">
	              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>添加群聊二维码</legend>
</fieldset>
  <!-- <div class="layui-form-item">
    <label class="layui-form-label">学校名称</label>
    <div class="layui-input-block">
      <input type="text" name="schoolName"  id="schoolName" required  lay-verify="required" placeholder="请输入学校名称" autocomplete="off" class="layui-input">
    </div>
  </div> -->
  
  <div class="layui-form-item">
				<label class="layui-form-label">校&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</label>
				<div class="layui-input-block">
					<select id="schoolName" name="schoolName" class="layui-input" lay-filter="test" lay-search="">
					<option value="-1" >请选择</option>
					<option value="-100">全部</option>
					
					<option value="东莞理工学院(松山湖)" >东莞理工学院(松山湖)</option>
					<option value="东莞理工学院(莞城)" >东莞理工学院(莞城)</option>
					<option value="广东医科大学(东莞)" >广东医科大学(东莞)</option>
					<option value="广东创新科技职业学院" >广东创新科技职业学院</option>
					<option value="东莞职业技术学院" >东莞职业技术学院</option>
					<option value="广东科技学院" >广东科技学院</option>
					<option value="中山大学新华学院" >中山大学新华学院</option>
					<option value="广东酒店管理职业技术学院" >广东酒店管理职业技术学院</option>
					
		            </select>
				</div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">群聊名称</label>
    <div class="layui-input-block">
      <input type="text" name="groupName"  id="groupName" required  lay-verify="required" placeholder="请输入群聊名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  

  				<div class="layui-form-item">                     
                  <div class="layui-upload-list">
                    <img class="layui-upload-img" id="upimg">
                  </div>
                   <button type="button" class="layui-btn layui-btn-fluid test1" id="upbtn">上传图片</button><br/>
                   <button type="button" class="layui-btn layui-btn-fluid " id="insert" style="margin-top:25px;">提交表单</button>
                </div>
                
                <div class="layui-form-item" id="showbox" style="display: none;" align="center">
                	
                </div>

  
</form>
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