<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
	<title>审核</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="${root}/layuiadmin/layui/css/layui.css"
		media="all">
	<link rel="stylesheet" href="${root}/layuiadmin/style/admin.css"
		media="all">
	<link rel="stylesheet" href="${root}/layuiadmin/style/login.css"
		media="all">
</head>
<body>
<div style="padding:20px 0">
<fieldset class="layui-elem-field layui-field-title" style="margin:0px;">
  <legend>审核任务</legend>
</fieldset>
</div>
	<div class="layui-form-item">
	    <div class="layui-input-block">
	    	<p id="taskName" style="font-size:24px">任务名称：</p>
	    </div>
  	</div>
  	
  	<div class="layui-form-item">
	    <div class="layui-input-block">
	    	<p id="taskText"></p>
	    </div>
  	</div>
  	
  	<div class="layui-form-item">
	    <div class="layui-input-block" id="imgBox">
	    </div>
  	</div>
  	
  	<div class="layui-form-item">
	    <div class="layui-input-block" id="textBox">
	    </div>
  	</div>
  	
  	<div class="layui-form-item">
	    <div class="layui-input-block">
	    <button type="button" style="display:none" id="noPassButton" class="layui-btn layui-btn-danger" onclick="noPassFunction()">审核不通过</button>
	    <button type="button" style="display:none" id="passButton" class="layui-btn" onclick="passFunction()">审核通过</button>
	    </div>
  	</div>


<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
<script type="text/javascript" src="${root}/js/layer.js"></script>
<script>
layui.use(['element','jquery','layer','slider','table','form'], function(){
	var $ = layui.$ 
	  ,layer = layui.layer
	  ,table = layui.table
	  ,form =layui.form;

	var examineId;
	var performId;
	window.getPerfromFunction=function(){
		$.ajax({
  		  url:'${root}/growthSystem/getExamineDetailEvent',
  		  type : "post",
  		  dataType : 'json',
  		  success : function(res){
  			$('#noPassButton').show();
  			$('#passButton').show();
  			  console.log(res);
  			  
  			  $('#taskName').empty();
  			  $('#taskText').empty();
  			  $('#imgBox').empty();
  			  $('#textBox').empty();
  			  if(res.msg!="已经全部审核完"){
  				$('#taskName').append(res.taskList.taskName);
    			  $('#taskText').append(res.taskList.taskText);
    			  str=res.examineList.examineUrl;
    			  strs=str.split("\",");
    			  
    			  console.log(strs);
    			  var strss="";
    			  for(var i=0;i<strs.length-1;i++){
    				  strss+="<img src='${root}/upload/"+strs[i].substr(1,strs[i].length-1)+"' style='max-height:300px'>"
    			  }
    			  $('#imgBox').append(strss);
    			  $('#textBox').append(res.examineList.examineText);
    			  
    			  examineId=res.examineList.examineId;
    			  performId=res.perform.performId;
    			  console.log(examineId+" hhhh "+performId);
  			  }else{
  				  $('#noPassButton').hide();
  				  $('#passButton').hide();
  				  layer.msg(res.msg);
  				  
  			  }
  			  
  		  }
  	  });
	}
	getPerfromFunction();
	window.noPassFunction=function(){
		$.ajax({
	  		  url:'${root}/growthSystem/updAllEvent?msg=noPass&performId='+performId+'&examineId='+examineId,
	  		  type : "post",
	  		  dataType : 'text',
	  		  success : function(res){
	  			  console.log(res);
	  			  layer.msg(res);
	  			getPerfromFunction();
	  		  }
	  	  });
	}
	window.passFunction=function(){
		$.ajax({
	  		  url:'${root}/growthSystem/updAllEvent?msg=pass&performId='+performId+'&examineId='+examineId,
	  		  type : "post",
	  		  dataType : 'text',
	  		  success : function(res){
	  			  console.log(res);
	  			  layer.msg(res);
	  			getPerfromFunction();

	  		  }
	  	  });
	}
});
</script>
</body>
</html>