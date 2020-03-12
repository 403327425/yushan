<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<title>选票管理</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body class="layui-content-wrapper" >

	<div class="search-wrap layui-form" >

		<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;活动</label>
				<div class="layui-input-block">
					<select id="activitySelectId" name="activitySelectId" class="layui-input" lay-search="" lay-filter="test">
					<option value="-1" >请选择</option>
						<c:forEach items="${activityList}" var="activity">
							 <option value="${activity.activityId }">${activity.activityName }</option>
						</c:forEach>
		            </select>
				</div>
		</div>

		 
		<table id="voterList" lay-filter="voterList"></table>
	</div>

<script type="text/html" id="barEdit">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="ActivityNameTpl">
	{{# var name=getActivityName(d.activityId)}}
	{{#if(name=="活动已删除!"){}}
		<span style="color: #FF0000;">{{ name }}</span>
	{{# }else{}}
		<span >{{ name }}</span>
	{{# }}}
</script>


<script type="text/html" id="CandidateNameTpl">
	{{# var name=getCandidateName(d.candidateId)}}
	{{#if(name=="参赛者退出!"){}}
		<span style="color: #FF0000;">{{ name }}</span>
	{{# }else{}}
		<span >{{ name }}</span>
	{{# }}}
</script>

<script>
	function getActivityName(ID){
		var name="活动已删除!";
		$.ajax({
			url : '${root}/vote/getAllActivityById',
			data :  "activityId="+ID,
			type : 'POST',
			async:false,
			dataType : 'json',
			success : function(data) {
				console.log(data);
				name=data.activityName;
			}
		});
		return name;
	}
</script>
<script>
	function getCandidateName(ID){
		var name="参赛者退出!";
		$.ajax({
			url : '${root}/vote/sysGetCandidateById',
			data :  "candidateId="+ID,
			type : 'POST',
			async:false,
			dataType : 'json',
			success : function(data) {
				console.log(data);
				name=data.candidateName;
			}
		});
		return name;
	}
</script>

<script>
	var fromData={};
	  layui.config({
	    base: '${root }/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index','useradmin', 'set','form','layer','jquery','laypage','table','laytpl'],function(){
			var form = layui.form,
				table = layui.table,
				layer = parent.layer == 'undefined' ? layui.layer : parent.layer,
				laypage = layui.laypage,admin = layui.admin,
				$ = layui.jquery;
			//数据表格
			table.render({

				
				id:'voterList',
			    elem: '#voterList'
			    ,url: '${root}/vote/sysGetAllVoter' //数据接口
			    ,limit:10//每页默认数
			    ,limits:[10,20,30,40]
			    ,cols: [[ //表头
			       {field:'activityId', title: '投票活动',minWidth:100,templet:'#ActivityNameTpl'}
			      ,{field:'candidateId', title: '候选人编号',minWidth:100,templet:'#CandidateNameTpl'}
	              
	              ,{field:'ip', title: 'IP地址',minWidth:100}
	              ,{field:'voteTime', title: '投票时间',minWidth:100,sort: true,templet : "<div>{{layui.util.toDateString(d.voteTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
	              ,{field:'userId', title: '用户ID',minWidth:120}
	              ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:120}
	              
	             
			    ]]
					,page: true //开启分页
					,where: {timestamp: (new Date()).valueOf()}
			  });
			
			
			
			layui.use('form', function() {
				$.ajax({
					url : '${root}/vote/getAllActivity',
					data : fromData,
					type : 'POST',
					dataType : 'json',
					success : function(res) {
						console.log(res);
						 $("#activitySelectId").empty();
						 var option="<option value='-2' >请选择</option>";
						 for(var i=0;i<res.length;i++){
							 option+=" <option value='"+res[i].activityId+"'>"+res[i].activityName+"</option>"
						 }
						 $("#activitySelectId").append(option);
						 layui.form.render("select");
					}
				});
				var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
				  form.render();
				 });
			
			form.on('select(test)', function(data){
				
				
				var type = data.value;
				
				table.reload('voterList', {
					where : {
						activityId : type
						
					}
				});
				
				
/* 				  console.log(data);
				  var dtParentId = data.value;//得到被选中的值
				  if(dtParentId == '-2'){
					
				  }else{
					  $.ajax({
		         			type: "post",  
		       				data: {"activityId":dtParentId},  
		       				url: '${root}/vote/sysGetAllVoter',
		        			dataType:"json",
		        			success:function(res){


		        			}
					 	});
				  } */
			  });

			
			
 			//监听工具条
			  table.on('tool(voterList)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			    	  $.ajax({
			    		  url:'${root}/vote/sysVoterDel?id='+data.id,
			    		  type : "get",
			    		  success : function(res){
			    			  console.log(res);
			    			  if(res.result_code){
			    				  obj.del();
			    				  toast('操作成功');
			    				  table.reload('voterList', {});
			    			  }else{
			    				  layer.msg("权限不足，联系超管！",{icon: 5});
			    			  }
			    		  }
			    	  });
			        layer.close(index);
			      });
			    } else if(obj.event === 'edit'){
			    	layer.open({
				          type: 2,
				          title : "修改",
				          content: "${root }/vote/sysVoterEditWeb?id="+data.id,
				          maxmin: true,
					      area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],
					      btn: ['确定', '取消'],
				          btnAlign: 'c',
					      yes: function(index, layero){
					        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
					            var inputForm = body.find('#layuiadmin-form-activity');//这是你弹出层 表单对象
					            if(checkedAdd(inputForm[0])){
					            	$.ajax({
										url : '${root}/vote/sysVoterUpdate',
										data : fromData,
										type : 'POST',
										dataType : 'json',
										success : function(res) {
											if (res.result_code) {
												toast('操作成功');
												table.reload('voterList', {});
											} else {
												toast('修改失败');
											}
										},complete:function(){
											layer.close(index);
										}
									});
					            }
					        }
			        });
			    }
			  });

 			
 			
				/* 				//添加活动
				$(".activityadd_btn").click(function(){
					layer.open({
						type: 2,
				        title: '新增活动',
				        content: '${root }/vote/sysActivityEditWeb',
				        maxmin: true,
				        area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],
				        btn: ['确定', '取消'],
				        btnAlign: 'c',
				        yes: function(index, layero){
				        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
				            var inputForm = body.find('#layuiadmin-form-activity');//这是你弹出层 表单对象
				            if(checkedAdd(inputForm[0])){
				            	$.ajax({
									url : '${root}/vote/sysActivityInsert',
									data : fromData,
									type : 'POST',
									dataType : 'json',
									success : function(res) {
										if (res.result_code) {
											//toastANDRedirect('添加成功','${root}/sys/adminListView');
											toast('添加成功');
											table.reload('activityList', {});
											layer.close(index);
										} else {
											toast('添加失败');
										}
									}
								});
				            }
				        }
					});
				}); */
		});
	
	  function checkedAdd(div) {
		  fromData={};
		  let id = $(div).find("input[name='id']").val();
		  let candidateId = $(div).find("select[name='candidateId']").val();
		  let activityId = $(div).find("select[name='activityId']").val();
		  let ip = $(div).find("input[name='ip']").val();
		  let voteTime = $(div).find("input[name='voteTime']").val();
		  let userId = $(div).find("input[name='userId']").val();
		  
		  if ($.trim(candidateId) == '') {
				parent.layer.msg('候选者编号不能空');
				return false;
			}
		  if ($.trim(activityId) == '') {
				parent.layer.msg('隶属活动编号不能空');
				return false;
			}
		  if ($.trim(ip) == '') {
				parent.layer.msg('IP地址不能空');
				return false;
			}
		  if ($.trim(voteTime) == '') {
				parent.layer.msg('投票时间不能空');
				return false;
			}
		  
		  fromData.id=id;
		  fromData.candidateId=candidateId;
		  fromData.activityId=activityId;
		  fromData.ip=ip;
		  fromData.voteTime=voteTime;
		  fromData.userId=userId;
		  return true;
	  }
	 

</script>
</body>
</html>