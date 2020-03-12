<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <title>添加活动 </title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <%@ include file="/WEB-INF/console/common/includ.jsp"%>
</head>
<body class="layui-layout-body">
	<div class="layui-form" lay-filter="layuiadmin-form-activity" id="layuiadmin-form-activity" style="padding: 20px 30px 0 0;">
  	<input type="hidden" name="activityId" value="${activity.activityId }">
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;活动名</label>
      <div class="layui-input-inline">
        <input type="text" name="activityName" value="${activity.activityName }" lay-verify="required" placeholder="请输入活动名" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;规则</label>
      <div class="layui-input-inline">
        <textarea name="activityDescribe" id="activityDescribe" placeholder="请输入规则" autocomplete="off" class="layui-textarea" >${activity.activityDescribe}</textarea>
      </div>
    </div>
    <div class="layui-form-item">
		<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;截止日期</label>
		 
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" id="endTime"  name="endTime" value="<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${activity.endTime}"/>" placeholder="选择时间">
		      </div>
    	
	</div>
    
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;海报</label>
      <div class="layui-upload">
		  <button type="button" class="layui-btn" id="test2">图片上传</button> 
		  <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
		    预览图：
		    <div class="layui-upload-list" id="demo2"></div>
		  </blockquote>
	  </div>
    </div>

	<div class="layui-form-item layui-hide">
      <input type="button" lay-submit lay-filter="LAY-user-front-submit" id="LAY-user-front-submit" value="确认">
    </div>
  </div>
    <script>
	  layui.config({
	    base: '${root}/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index','laydate', 'upload','form' ,'jquery','layer'], function(){
	    var $ = layui.$,
	    form = layui.form ;
	    laydate = layui.laydate;
	    upload=layui.upload;
	    laydate.render({
	  	  elem: '#endTime' ,type: 'datetime'
	  	});
	    
	    
	    upload.render({
	        elem: '#test2'
	        ,url: '/vote/sysSaveImage'
	        ,multiple: true
	        ,before: function(obj){
	        	
	          //预读本地文件示例，不支持ie8
	          obj.preview(function(index, file, result){
	            $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
	          });
	        }
	        ,done: function(res){
	          //上传完毕
	        	console.log(res);
	        	$('#layuiadmin-form-activity').append("<input type='hidden' name='picture' id='picture02' value="+res.msg+">");
	        }
	      });
	  })
	  
	  

  </script>
  
</body>
</html>