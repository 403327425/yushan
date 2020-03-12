<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>

<head>
	<meta charset="utf-8">
	<title>任务类型列表</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>任务类型列表</legend>
</fieldset>
<table class="layui-hide" id="TaskTypeList" lay-filter="TaskTypeList"></table>
<button type="button" class="layui-btn addTaskTypeButton">添加任务类型</button>

<script type="text/html" id="barEdit">
  	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-xs" lay-event="Img">图片</a>
  	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	
</script>
<script type="text/html" id="stateBox">
  	{{#if(d.state==1){}}
  		<span style="color:#1e9fff">使用中</span>
	{{#}}}
</script>
<div id="addTaskTypeBox" name="addTaskTypeBox" style="display:none;padding:0 15px" >
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>添加任务类型</legend>
</fieldset>
	<input id="taskTypeName" name="taskTypeName" class="layui-input taskTypeName">
</div>
<div id="updTaskTypeBox" name="updTaskTypeBox" style="display:none;padding:0 15px" >
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>修改任务类型</legend>
</fieldset>
	<input id="updTaskTypeName" name="updTaskTypeName" class="layui-input updTaskTypeName">
</div>

<div id="updImageBox" name="updImageBox" style="display:none;padding:0 15px" >
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>修改图片</legend>
</fieldset>
<div class="layui-upload">
  <button type="button" class="layui-btn" id="test1">上传图片</button>
  <div class="layui-upload-list">
    <img class="layui-upload-img" id="demo1" style="max-width:300px;max-height:300px">
    <p id="demoText"></p>
  </div>
</div>
</div>

<script>
layui.use(['element','jquery','layer','slider','table','upload'], function(){
	var $ = layui.$ 
	  ,layer = layui.layer
	  ,table = layui.table
	  ,upload = layui.upload;
	  var photo;
	  var uploadInst = upload.render({
		    elem: '#test1'
		    ,url: '${root}/growthSystem/savePhoto'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#demo1').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(res){
		      //如果上传失败
		      photo=res.data;
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }else{
		    	return layer.msg('上传成功');
		      }
		      //上传成功
		    }
		    ,error: function(){
		      //演示失败状态，并实现重传
		      var demoText = $('#demoText');
		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
		      demoText.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
		  });
	  
	  
	  
	
	
	window.showTaskTypeListFunction=function(){
		table.render({
		    elem: '#TaskTypeList'
		    ,url:'${root}/growthSystem/showTaskTypeListEvent'
		    ,toolbar: true
		    ,title: '任务类型列表'
		    ,totalRow: true
		    ,cols: [[
		      {field:'taskTypeName', title:'类型名称', width:'40%', edit: 'text'}
		      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}
		      ,{field:'createTime', title:'更改时间', width:'20%',templet : "<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
		      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
		    ]]
		    ,page: true
		  });
	}
	showTaskTypeListFunction();
	table.on('tool(TaskTypeList)',function(obj){
		 var data=obj.data
		 if(obj.event==='del'){
			 layer.confirm('真的删除么',function(index){
				 $.ajax({
					 url:'${root}/growthSystem/updateTaskTypeListEvent?taskTypeId='+data.taskTypeId+'&msg=del',
					 type:"get",
					 success:function(res){
						 if(res.result_code){
							 obj.del();
							 toast('操作成功');
							 table.reload('TaskTypeList', {});
						 }else{
							 layer.msg("权限不足，联系超管！",{icon: 5});
						 }
					 }
				 });
				 layer.close(index);
			 });
		 }else if(obj.event==='edit'){
			 $('#updTaskTypeName').val(data.taskTypeName);
			 layer.open({
					type: 1,
			        title: '修改任务类型',
			        content:$("#updTaskTypeBox"),
			        maxmin: true,
			        area:['900px', '400px'],
			        btn: ['修改'],
			        btnAlign: 'c',
			        yes: function(){
			        	var updTaskTypeName=$('#updTaskTypeName').val();
			        	if(taskTypeName!=""){
			        		$.ajax({
			    				url : '${root}/growthSystem/updateTaskTypeListEvent?taskTypeId='+data.taskTypeId+'&taskTypeName='+updTaskTypeName+'&msg=upd',
			    				
			    				type : 'get',
			    				
			    				success : function(res) {
			    					console.log(res);
			    					if(res.result_code){
			    						$('#taskTypeName').val("");
			    						layer.closeAll();
			    						layer.msg("添加成功");
			    						showTaskTypeListFunction();
			    						
			    					}else{
			    						layer.msg("添加失败");
			    					}
			    				}
			    			});
			        	}else{
			        		layer.msg("类型名称不能为空！");
			        	}
			        }
				});
		 }else if(obj.event==='Img'){
			 taskTypeId=data.taskTypeId;
			 $('#demo1').attr('src', '${root}/upload/'+data.reservedFields);
			 layer.open({
				type:1,
				title:'修改预览图',
				content:$("#updImageBox"),
				maxmin:true,
				area:['900px', '400px'],
				btn: ['修改'],
				btnAlign: 'c',
				yes: function(){
					$.ajax({
						 url:'${root}/growthSystem/updateTypeImage',
						 data:{
							 taskTypeId:taskTypeId,src:photo
						 },
						 dataType:'Text',
						 type:"post",
						 success:function(res){
							layer.msg(res);
						 }
					 });
				}
			 });
		 }
	});

  $(".addTaskTypeButton").click(function(){
	  layer.open({
			type: 1,
	        title: '添加任务类型',
	        content:$("#addTaskTypeBox"),
	        maxmin: true,
	        area:['900px', '400px'],
	        btn: ['添加'],
	        btnAlign: 'c',
	        yes: function(){
	        	var taskTypeName=$('#taskTypeName').val();
	        	
	        	if(taskTypeName!=""){
	        		$.ajax({
	    				url : '${root}/growthSystem/addTaskTypeListEvent',
	    				data : {taskTypeName:taskTypeName},
	    				type : 'POST',
	    				dataType : 'json',
	    				success : function(res) {
	    					console.log(res);
	    					if(res.result_code){
	    						$('#taskTypeName').val("");
	    						layer.closeAll();
	    						layer.msg("添加成功");
	    						showTaskTypeListFunction();
	    						
	    					}else{
	    						layer.msg("添加失败");
	    					}
	    				}
	    			});
	        	}else{
	        		layer.msg("类型名称不能为空！");
	        	}
	        }
		});
  });
  
  
  
});
</script>
</body>
</html>