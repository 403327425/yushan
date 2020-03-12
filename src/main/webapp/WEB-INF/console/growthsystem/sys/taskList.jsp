<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>

<head>
	<meta charset="utf-8">
	<title>任务列表</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body class="layui-layout-body">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>任务列表</legend>
</fieldset>
<button type="button" class="layui-btn addTaskButton">添加任务</button>
<form class="layui-form" action="">
	<div class="layui-form-item">
	<label class="layui-form-label">任务类型</label>
	    <div class="layui-input-block">
	      <select name="taskTypeList2" id="taskTypeList2" lay-filter="required3">
	      </select>
	    </div>
    </div>
</form>
<table class="layui-hide" id="TaskList" lay-filter="TaskList"></table>


<div id="addTaskBox" name="addTaskBox" style="display:none;padding:0 15px" >
<form class="layui-form" action="">
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>添加任务</legend>
	</fieldset>
	<div class="layui-form-item">
	<label class="layui-form-label">任务类型</label>
	    <div class="layui-input-block">
	      <select name="taskTypeList" id="taskTypeList" lay-filter="required">
	      </select>
	    </div>
    </div>
    <input type="text" id="taskTypeId" name="taskTypeId" style="display:none">
    <div class="layui-form-item">
	    <label class="layui-form-label">父级任务</label>
	    <div class="layui-input-block">
	      <select name="fatherList" id="fatherList" lay-filter="required2">
	      </select>
	    </div>
    </div>
    <input type="text" id="fatherId" name="fatherId" style="display:none">
    <div class="layui-form-item">
    <label class="layui-form-label">任务名称</label>
	    <div class="layui-input-block">
	      <input type="text" id="taskName" name="taskName" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
	    </div>
    </div>
    <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">任务详情</label>
	    <div class="layui-input-block">
	      <textarea id="taskText" name="taskText" placeholder="请输入内容" class="layui-textarea"></textarea>
	    </div>
    </div>
    <div class="layui-form-item">
    <label class="layui-form-label">持续时间</label>
	    <div class="layui-input-block">
	      <input type="text" id="Duration" name="Duration" lay-verify="required" autocomplete="off" placeholder="请输入天数" class="layui-input">
	    </div>
    </div>    
    <div class="layui-form-item">
    <label class="layui-form-label">任务分值</label>
	    <div class="layui-input-block">
	      <input type="text" id="score" name="score" lay-verify="required" autocomplete="off" placeholder="请输入分值" class="layui-input">
	    </div>
    </div>  
  	<div class="layui-form-item">
    <label class="layui-form-label">执行次数</label>
	    <div class="layui-input-block">
	      <input type="text" id="finishNumber" name="finishNumber" lay-verify="required" autocomplete="off" placeholder="请输入次数" class="layui-input" value="1">
	    </div>
    </div> 	
</form>
</div>
<script type="text/html" id="barEdit">
  	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="pub">启用</a>
  	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="stateBox">
  	{{#if(d.state==1){}}
  		<span style="color:#1e9fff">启用中</span>
	{{#}else if(d.state==2){}}
		<span style="">未启用</span>
	{{#}}}
</script>
<script>
layui.use(['element','jquery','layer','slider','table','form'], function(){
	var $ = layui.$ 
	  ,layer = layui.layer
	  ,table = layui.table
	  ,form =layui.form;
	  form.render();
	  window.showTaskListFunction=function(data){
			table.render({
			    elem: '#TaskList'
			    ,url:'${root}/growthSystem/showTaskListEvent?taskTypeId='+data
			    ,toolbar: true
			    ,title: '任务类型列表'
			    ,totalRow: true
			    ,cols: [[
			      {field:'taskId', title:'ID', width:'5%', edit: 'text'}
			      ,{field:'taskName', title:'任务名称', width:'10%', edit: 'text'}
			      ,{field:'taskText', title:'任务介绍', width:'12%', edit: 'text'}
			      ,{field:'duration', title:'持续时间', width:'6%', edit: 'text'}
			      ,{field:'score', title:'分值', width:'3%', edit: 'text'}
			      ,{field:'peopleNumber', title:'参与人数', width:'6%', edit: 'text'}
			      ,{field:'taskTypeId', title:'类型', width:'3%', edit: 'text'}
			      ,{field:'fatherId', title:'父级ID', width:'5%', edit: 'text'}
			      ,{field:'state', title:'状态', width:'5%',templet :'#stateBox'}
			      ,{field:'createTime', title:'更改时间', width:'15%',templet : "<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
			      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
			    ]]
			    ,page: true
			  });
		}
	  table.on('tool(TaskList)',function(obj){
		  var data=obj.data;
		  if(obj.event==='del'){
			  layer.confirm('真的删除么',function(index){
				  $.ajax({
						 url:'${root}/growthSystem/updateTaskListEvent?taskId='+data.taskId+'&msg=del',
						 type:"get",
						 success:function(res){
							 if(res.result_code){
								 obj.del();
								 toast('操作成功');
								 table.reload('TaskList', {});
							 }else{
								 layer.msg("权限不足，联系超管！",{icon: 5});
							 }
						 }
					 });
					 layer.close(index);
			  });
		  }else if(obj.event==='pub'){
			  layer.confirm('启用或暂停使用都请慎重',function(index){
				  $.ajax({
						 url:'${root}/growthSystem/updateTaskListEvent?taskId='+data.taskId+'&msg=pub',
						 type:"get",
						 success:function(res){
							 if(res.result_code){
								 
								 toast('操作成功');
								 table.reload('TaskList', {});
							 }else{
								 layer.msg("权限不足，联系超管！",{icon: 5});
							 }
						 }
					 });
					 layer.close(index);
			  });
		  }else if(obj.event==='edit'){
			  $('#taskName').val(data.taskName);
			  $('#taskText').val(data.taskText);
			  $('#Duration').val(data.duration);
			  $('#score').val(data.score);
			  $('#finishNumber').val(data.finishNumber);
			  $('#fatherId').val(data.fatherId);
			  $('#taskTypeId').val(data.taskTypeId);
			  getTaskTypeList();
			  layer.open({
					type: 1,
			        title: '添加任务',
			        content:$("#addTaskBox"),
			        maxmin: true,
			        area:['100%', '100%'],
			        btn: ['修改'],
			        btnAlign: 'c',
			        yes: function(){
			        	var taskName=$('#taskName').val();
			        	var taskText=$('#taskText').val();
			        	var Duration=$('#Duration').val();
			        	var score=$('#score').val();
			        	var finishNumber=$('#finishNumber').val();
			        	var taskTypeId=$('#taskTypeId').val();
			        	var fatherId=$('#fatherId').val();
			        	$.ajax({
							url:"${root}/growthSystem/updateTaskListEvent?msg=upd",
							type:"post",
							data:{taskId:data.taskId,taskName:taskName,taskText:taskText,Duration:Duration,score:score,finishNumber:finishNumber,taskTypeId:taskTypeId,fatherId:fatherId},
							dataType : "json",
							success:function(data){
								console.log(data);
								if(data.result_code){
									layer.closeAll();
									layer.msg("修改成功");
								}else{
									layer.msg("修改失败");
								}
							}
						});
			        }
				});
		  }
	  });
	  
	  window.getTaskTypeList=function(){
			$.ajax({
				url:"${root}/growthSystem/getTaskTypeListEvent",
				type:"get",
				dataType : "json",
				success:function(data){
					console.log(data);
					var str="<option value='0'>请选择类型</option>";
					for(var i=0;i<data.length;i++){
						console.log(data[i]);
						str +="<option value="+data[i].taskTypeId+" >"+data[i].taskTypeName+"</option>"
					}
					$('#taskTypeList').empty();
					$('#taskTypeList').append(str);
					form.render();
				}
			});
		}
	  window.getTaskTypeList2=function(){
			$.ajax({
				url:"${root}/growthSystem/getTaskTypeListEvent",
				type:"get",
				dataType : "json",
				success:function(data){
					console.log(data);
					var str="<option value='0'>请选择类型</option>";
					for(var i=0;i<data.length;i++){
						console.log(data[i]);
						str +="<option value="+data[i].taskTypeId+" >"+data[i].taskTypeName+"</option>"
					}
					$('#taskTypeList2').empty();
					$('#taskTypeList2').append(str);
					form.render();
				}
			});
		}
	  getTaskTypeList2();
	form.on('select(required3)',function(data){
		showTaskListFunction(data.value);
	});
	form.on('select(required)',function(data){
		$('#taskTypeId').val(data.value);
		$('#fatherId').val("0");
		if(data.value!=0){
			$.ajax({
				url:"${root}/growthSystem/getTypeTaskEvent?taskTypeId="+data.value,
				type:"get",
				dataType : "json",
				success:function(data){
					console.log(data);
					var str="<option value='0'>主线</option>";
					for(var i=0;i<data.length;i++){
						console.log(data[i]);
						str +="<option value="+data[i].taskId+" >"+data[i].taskName+"</option>"
					}
					$('#fatherList').empty();
					$('#fatherList').append(str);
					form.render();
				}
			});
		}else{
			$('#fatherList').empty();
			form.render();
		}
	});
	
	form.on('select(required2)',function(data){
		$('#fatherId').val(data.value);
	});
	  
	
	$(".addTaskButton").click(function(){
		getTaskTypeList();
		  layer.open({
				type: 1,
		        title: '添加任务',
		        content:$("#addTaskBox"),
		        maxmin: true,
		        area:['100%', '100%'],
		        btn: ['添加'],
		        btnAlign: 'c',
		        yes: function(){
		        	var taskName=$('#taskName').val();
		        	var taskText=$('#taskText').val();
		        	var Duration=$('#Duration').val();
		        	var score=$('#score').val();
		        	var finishNumber=$('#finishNumber').val();
		        	var taskTypeId=$('#taskTypeId').val();
		        	var fatherId=$('#fatherId').val();
		        	$.ajax({
						url:"${root}/growthSystem/addTaskListEvent",
						type:"post",
						data:{taskName:taskName,taskText:taskText,Duration:Duration,score:score,finishNumber:finishNumber,taskTypeId:taskTypeId,fatherId:fatherId},
						dataType : "json",
						success:function(data){
							console.log(data);
							if(data.result_code){
								layer.msg("添加成功");
								$('#taskName').val("");
								$('#taskText').val("");
								$('#Duration').val("");
								$('#score').val("");
							}else{
								layer.msg("添加失败");
							}
						}
					});
		        }
			});
		  
		  
	  });
	
	

});
</script>

</body>
</html>