<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<title>调查问卷列表</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>问卷列表</legend>
</fieldset>


<button type="button" class="layui-btn addDcwjButton" style="width:280px">创建新问卷</button>
<table class="layui-hide" id="DcwjList" lay-filter="DcwjList"></table>


<script type="text/html" id="barEdit">
  	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="addWt">添加题目</a>
	<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="addEven">设计评分标准</a>
	<a class="layui-btn layui-btn-xs" lay-event="pub">发布</a>
  	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	
</script>

<script type="text/html" id="stateBox">
  	{{#if(d.state==1){}}
  		<span style="color:#1e9fff">未添加题目</span>
	{{#}else}}
  	{{#if(d.state==2){}}
  		<span style="color:#ffb800">未设计评分标准</span>
	{{#}else}}
  	{{#if(d.state==3){}}
  		<span style="">未发布</span>
	{{#}else}}
  	{{#if(d.state==4){}}
  		<span style="color:#009688">已发布</span>
	{{#}}}
</script>
<script>
var fromData={};
layui.use(['table','jquery','layer'], function(){
  var table = layui.table,
  layer = parent.layer == 'undefined' ? layui.layer : parent.layer;
  
  table.render({
    elem: '#DcwjList'
    ,url:'${root}/questionnaire/showDcwjListEvent'
    ,toolbar: true
    ,title: '用户数据表'
    ,totalRow: true
    ,cols: [[
      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}
      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}
      ,{field:'startTime', title:'更改时间', width:'20%',templet : "<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
    ]]
    ,page: true
  });
  table.on('tool(DcwjList)',function(obj){
	 var data=obj.data
	 if(obj.event==='del'){
		 layer.confirm('真的删除么',function(index){
			 $.ajax({
				 url:'${root}/questionnaire/updateDcwjEvent?dcwjId='+data.dcwjId+'&state='+data.state+'&msg=del',
				 type:"get",
				 success:function(res){
					 if(res.result_code){
						 obj.del();
						 toast('操作成功');
						 table.reload('adminList', {});
					 }else{
						 layer.msg("权限不足，联系超管！",{icon: 5});
					 }
				 }
			 });
			 layer.close(index);
		 });
	 }else if(obj.event=='pub'){
		 if(data.state=="4"){
			 layer.confirm('确认后取消发布',function(index){
				 $.ajax({
					 url:'${root}/questionnaire/updateDcwjEvent?dcwjId='+data.dcwjId+'&state='+data.state+'&msg=pub',
					 type:"get",
					 success:function(res){
						 if(res.result_code){
							 
							 toast('操作成功');
							 table.render({
								    elem: '#DcwjList'
								    ,url:'${root}/questionnaire/showDcwjListEvent'
								    ,toolbar: true
								    ,title: '用户数据表'
								    ,totalRow: true
								    ,cols: [[
								      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}
								      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}
								      ,{field:'startTime', title:'更改时间', width:'20%',templet : "<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
								      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
								    ]]
								    ,page: true
								  });
						 }else{
							 layer.msg("操作失败",{icon: 5});
						 }
					 }
				 });
				 layer.close(index);
			 });
		 }else{
			 var msgtitle01="";
			 if(data.state==3){
				 msgtitle01="确认后发布";
			 }else{
				 msgtitle01="题目或评价尚未设置,您确定要发布么";
			 }
			 layer.confirm(msgtitle01,function(index){
				 $.ajax({
					 url:'${root}/questionnaire/updateDcwjEvent?dcwjId='+data.dcwjId+'&state='+data.state+'&msg=pub',
					 type:"get",
					 success:function(res){
						 if(res.result_code){
							 
							 toast('操作成功');
							 table.render({
								    elem: '#DcwjList'
								    ,url:'${root}/questionnaire/showDcwjListEvent'
								    ,toolbar: true
								    ,title: '用户数据表'
								    ,totalRow: true
								    ,cols: [[
								      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}
								      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}
								      ,{field:'startTime', title:'更改时间', width:'20%',templet : "<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
								      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
								    ]]
								    ,page: true
								  });
						 }else{
							 layer.msg("操作失败",{icon: 5});
						 }
					 }
				 });
				 layer.close(index);
			 });
		 }
		 
		 
	 }else if(obj.event==='edit'){
		 layer.open({
				type: 2,
		        title: '修改问卷',
		        content: '${root}/questionnaire/addDcwjWeb?dcwjName='+data.dcwjName,
		        maxmin: true,
		        area:['800px', '300px'],
		        btn: ['确定', '取消'],
		        btnAlign: 'c',
		        yes: function(index, layero){
	 	        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
		            var inputForm = body.find('#layui_open_box');//这是你弹出层 表单对象
		            if(checkedAdd(inputForm[0])){
		            	fromData.dcwjId=data.dcwjId;
		            	$.ajax({
							url : '${root}/questionnaire/updateDcwjEvent?msg=upd',
							data : fromData,
							type : 'POST',
							dataType : 'json',
							success : function(res) {
								console.log(res);
								if (res.result_code) {
									//toastANDRedirect('添加成功','${root}/sys/adminListView');
									toast('修改成功');
									table.reload('activityList', {});
									layer.close(index);
									table.render({
									    elem: '#DcwjList'
									    ,url:'${root}/questionnaire/showDcwjListEvent'
									    ,toolbar: true
									    ,title: '用户数据表'
									    ,totalRow: true
									    ,cols: [[
									      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}
									      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}
									      ,{field:'startTime', title:'更改时间', width:'20%',templet : "<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
									      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
									    ]]
									    ,page: true
									  });

								} else {
									toast('修改失败');
								}
							}
						});
		            } 
		        }
			});
	 }else if(obj.event==='addWt'){
		 layer.open({
				type: 2,
		        title: '添加问题',
		        content: '${root}/questionnaire/addWtWeb?dcwjId='+data.dcwjId,
		        maxmin: true,
		        area:['1200px', '600px'],
		        btn: ['关闭'],
		        closeBtn: 0,
		        btnAlign: 'c',
		        yes: function(index, layero){
		        	layer.close(index);
					table.render({
					    elem: '#DcwjList'
					    ,url:'${root}/questionnaire/showDcwjListEvent'
					    ,toolbar: true
					    ,title: '用户数据表'
					    ,totalRow: true
					    ,cols: [[
					      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}
					      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}
					      ,{field:'startTime', title:'更改时间', width:'20%',templet : "<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
					      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
					    ]]
					    ,page: true
					  });
		        }
			});
	 }else if(obj.event==='addEven'){
		 layer.open({
				type: 2,
		        title: '添加评分标准',
		        content: '${root}/questionnaire/addEvalWeb?dcwjId='+data.dcwjId,
		        maxmin: true,
		        area:['1200px', '700px'],
		        btn: ['关闭'],
		        closeBtn: 0,
		        btnAlign: 'c',
		        yes: function(index, layero){
		        	layer.close(index);
		        	
		        	table.render({
					    elem: '#DcwjList'
					    ,url:'${root}/questionnaire/showDcwjListEvent'
					    ,toolbar: true
					    ,title: '用户数据表'
					    ,totalRow: true
					    ,cols: [[
					      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}
					      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}
					      ,{field:'startTime', title:'更改时间', width:'20%',templet : "<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
					      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
					    ]]
					    ,page: true
					  });

		        }
			});
	 }
  });
  $(".addDcwjButton").click(function(){
		layer.open({
			type: 2,
	        title: '新增问卷',
	        content: '${root}/questionnaire/addDcwjWeb',
	        maxmin: true,
	        area:['800px', '300px'],
	        btn: ['确定', '取消'],
	        btnAlign: 'c',
	        yes: function(index, layero){
 	        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
	            var inputForm = body.find('#layui_open_box');//这是你弹出层 表单对象
	            if(checkedAdd(inputForm[0])){
	            	$.ajax({
						url : '${root}/questionnaire/addDcwjEvent',
						data : fromData,
						type : 'POST',
						dataType : 'json',
						success : function(res) {
							console.log(res);
							if (res.result_code) {
								//toastANDRedirect('添加成功','${root}/sys/adminListView');
								toast('添加成功');
								table.reload('activityList', {});
								layer.close(index);
								table.render({
								    elem: '#DcwjList'
								    ,url:'${root}/questionnaire/showDcwjListEvent'
								    ,toolbar: true
								    ,title: '用户数据表'
								    ,totalRow: true
								    ,cols: [[
								      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}
								      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}
								      ,{field:'startTime', title:'更改时间', width:'20%',templet : "<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
								      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}
								    ]]
								    ,page: true
								  });

							} else {
								toast('添加失败');
							}
						}
					});
	            } 
	        }
		});
  });
});
function checkedAdd(div){
	fromData={};
	let dcwjName = $(div).find("input[name='dcwjName']").val();
	if ($.trim(dcwjName) == '') {
		parent.layer.msg('名称不能空');
		return false;
	}else{
		fromData.dcwjName=dcwjName;
		return true;
	}
}
</script>

</body>
</html>