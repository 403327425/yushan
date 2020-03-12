<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>添加参赛者 </title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <%@ include file="/WEB-INF/console/common/includ.jsp"%>
</head>
<body class="layui-layout-body">

<div class="layui-form" lay-filter="layuiadmin-form-admin" id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
	<input type="hidden" name="candidateId" value="${candidate.candidateId}">
	
	<div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;姓名</label>
      <div class="layui-input-inline">
        <input type="text" name="candidateName" value="${candidate.candidateName }" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;联系号码</label>
      <div class="layui-input-inline">
        <input type="text" name="iphone" value="${candidate.iphone }" lay-verify="required" placeholder="请输入联系号码" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;地址</label>
      <div class="layui-input-inline">
        <input type="text" name="address" value="${candidate.address }" lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input">
      </div>
    </div>
    
<%--     <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;活动隶属编号</label>
      <div class="layui-input-inline">
        <input type="text" name="activityId" value="${candidate.activityId }" lay-verify="required" placeholder="请输入活动隶属编号" autocomplete="off" class="layui-input">
      </div>
    </div> --%>
    
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;活动</label>
				<div class="layui-input-block">
					<select id="activityId" name="activityId" class="layui-input" lay-search="">
					<option value="-1" >请选择</option>
						<c:forEach items="${activityList}" var="activity">
							 <option value="${activity.activityId }" <c:if test="${activity.activityId eq candidate.activityId}">selected</c:if>>${activity.activityName }</option>
						</c:forEach>
		            </select>
				</div>
			</div>
    
    
    
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;描述</label>
      <div class="layui-input-inline">
        <textarea name="candidateDescribe" id="candidateDescribe" placeholder="请输入作品描述" autocomplete="off" class="layui-textarea" >${candidate.candidateDescribe}</textarea>
      </div>
    </div>
    
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;作品</label>
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
	  }).use(['index','laydate', 'upload','form' ,'jquery'], function(){
	    var $ = layui.$,
	    form = layui.form ;
	    
	    upload=layui.upload;
	    
	    
	    
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
	        	$('#layuiadmin-form-admin').append("<input type='hidden' name='picture' id='picture02' value="+res.msg+">");
	        }
	      });
	  })
  </script>
</body>
</html>