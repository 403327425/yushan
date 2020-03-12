<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<title>活动管理</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body class="layui-content-wrapper">
	<div class="search-wrap layui-form" >
	    <div class="layui-input-inline">
		  	<input class="layui-input" name="activitySelectName" id="activitySelectName" placeholder="活动名" autocomplete="off">
		</div>
        <div class="layui-inline">
             <input type="text" readonly="readonly" id="beginDate" name="beginDate" class="layui-input userName" placeholder="截止时间(开始)" value="">
         </div>
         <div class="layui-inline">
             <input type="text" readonly="readonly" id="endDate" name="endDate" class="layui-input userName" placeholder="截止时间(结束)" value="">
         </div>
		<button class="layui-btn" id="reloadBtn" data-type="reload"><i class="layui-icon">&#xe615;</i></button>   
		<button class="layui-btn"  onclick="clearParam()"><i class="layui-icon">清除</i></button>   
		
		<table id="activityList" lay-filter="activityList"></table>
	</div>




	<blockquote class="layui-elem-quote list_search">
		<shiro:hasPermission name="sys:admin:save">
			<div class="layui-inline">
				<a class="layui-btn layui-btn-normal activityadd_btn"><i
					class="layui-icon">&#xe608;</i>添加活动</a>
			</div>
		</shiro:hasPermission>
	</blockquote>
	
	
	<script type="text/html" id="barEdit">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/html" id="pictureTpl">
		<img src="/upload/{{d.picture}}">
	</script>
<script>
layui.use('laydate', function() {
	var laydate = layui.laydate;
	laydate.render({
		elem : '#beginDate'
	});
	laydate.render({
		elem : '#endDate'
	});
});
function clearParam() {
	$(".search-wrap  input").each(function(idx, obj) {
		$(this).val("");
	});

	tableReload();
}	
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
				id:'activityList',
			    elem: '#activityList'
			    ,url: '${root}/vote/sysGetAllActivity' //数据接口
			    ,limit:10//每页默认数
			    ,limits:[10,20,30,40]
			    ,cols: [[ //表头
			       {field:'activityName', title: '活动名',minWidth:100}
	              ,{field:'activityDescribe', title: '规则',minWidth:100}
	              ,{field:'endTime', title: '截止时间',minWidth:100,sort: true,templet : "<div>{{layui.util.toDateString(d.endTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
	              ,{field:'visitCount', title: '访问量',minWidth:100,sort: true}
	              ,{field:'picture', title: '海报',minWidth:120,templet:'#pictureTpl'}
	              ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:120}
	              
	             
			    ]]
					,page: true //开启分页
					,where: {timestamp: (new Date()).valueOf()}
			  });
			
			
			var active = {
					reload : function() {
						table.reload('activityList', {
							where : {
								activityName : $('#activitySelectName').val(),
								beginDate : $('#beginDate').val(),
								endDate : $('#endDate').val(),
							}
						});
					}
				};

				$('#reloadBtn').on('click', function() {
					var type = $(this).data('type');
					active[type] ? active[type].call(this) : '';
				});

				window.tableReload = function tableReload() {
					table.reload('activityList', {
						where : {
							activityName : $('#activitySelectName').val(),
							beginDate : $('#beginDate').val(),
							endDate : $('#endDate').val(),
						}
					});
				};
			
			
 			//监听工具条
			  table.on('tool(activityList)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			    	  $.ajax({
			    		  url:'${root}/vote/sysActivityDel?activityId='+data.activityId,
			    		  type : "get",
			    		  success : function(res){
			    			  console.log(res);
			    			  if(res.result_code){
			    				  obj.del();
			    				  toast('操作成功');
			    				  table.reload('activityList', {});
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
				          title : "修改活动",
				          content: "${root }/vote/sysActivityEditWeb?activityId="+data.activityId,
				          maxmin: true,
					      area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],
					      btn: ['确定', '取消'],
				          btnAlign: 'c',
					      yes: function(index, layero){
					        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
					            var inputForm = body.find('#layuiadmin-form-activity');//这是你弹出层 表单对象
					            if(checkedAdd(inputForm[0])){
					            	$.ajax({
										url : '${root}/vote/sysActivityUpdate',
										data : fromData,
										type : 'POST',
										dataType : 'json',
										success : function(res) {
											if (res.result_code) {
												toast('操作成功');
												table.reload('activityList', {});
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

 			
 			
				//添加活动
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
				});
		});
	
	  function checkedAdd(div) {
		  fromData={};
		  let activityId = $(div).find("input[name='activityId']").val();
		  let activityName = $(div).find("input[name='activityName']").val();
		  let activityDescribe = $(div).find("textarea[name='activityDescribe']").val();
		  let endTime = $(div).find("input[name='endTime']").val();
		  let picture = $(div).find("input[name='picture']").val();
		  
		  if ($.trim(activityName) == '') {
				parent.layer.msg('活动名不能空');
				return false;
			}
		  if ($.trim(activityDescribe) == '') {
				parent.layer.msg('活动规则不能空');
				return false;
			}
		  if ($.trim(endTime) == '') {
				parent.layer.msg('请重新选择结束时间');
				return false;
			}
		  if ($.trim(picture) == '') {
				parent.layer.msg('请上传作品');
				return false;
			}
		  
		  
		  fromData.activityId=activityId;
		  fromData.activityName=activityName;
		  fromData.activityDescribe=activityDescribe;
		  fromData.endTime=endTime;
		  fromData.picture=picture;
		  return true;
	  }
	  
	  
	  

</script>

</body>
</html>