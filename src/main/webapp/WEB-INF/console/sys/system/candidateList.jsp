<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<title>参赛者列表</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body class="layui-content-wrapper">

	<div class="search-wrap layui-form" >
	    <div class="layui-input-inline">
		  	<input class="layui-input" name="activitySelectName" id="activitySelectName" placeholder="活动名称" autocomplete="off">
		</div>
		<div class="layui-input-inline">
		  	<input class="layui-input" name="candidateSelectName" id="candidateSelectName" placeholder="姓名" autocomplete="off">
		</div>
		<button class="layui-btn" id="reloadBtn" data-type="reload"><i class="layui-icon">&#xe615;</i></button>   
		<button class="layui-btn"  onclick="clearParam()"><i class="layui-icon">清除</i></button>
		
		<table id="candidateList" lay-filter="candidateList"></table>
	</div>
	
	<blockquote class="layui-elem-quote list_search">
		<shiro:hasPermission name="sys:admin:save">
			<div class="layui-inline">
				<a class="layui-btn layui-btn-normal candidateAdd_btn"><i
					class="layui-icon">&#xe608;</i>添加参赛者</a>
			</div>
		</shiro:hasPermission>
	</blockquote>
	
	<script type="text/html" id="barEdit">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
<script type="text/html" id="pictureTpl">
	{{# if(getFileBaseName3(d.picture)==null){if(getFileBaseName2(d.picture)==null){var A=getFileBaseName(d.picture);}}
			<img src="/upload/{{A}}">
	{{#	}else{var A=getFileBaseName(d.picture);var B=getFileBaseName2(d.picture);}}
			<img src="/upload/{{A}}"><img src="/upload/{{B}}">
	{{# }}}
	{{#	}else{var A=getFileBaseName(d.picture);var B=getFileBaseName2(d.picture);var C=getFileBaseName3(d.picture);}}
		<img src="/upload/{{A}}"><img src="/upload/{{B}}"><img src="/upload/{{C}}">
	{{# }}}
</script>

<script type="text/html" id="ActivityNameTpl">
	{{# var name=getActivityName(d.activityId)}}
	{{#if(name=="活动已删除!"){}}
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
				name=data.activityName;
				console.log(data.activityName);
				console.log(name);
				
			}
		});
		return name;
	}
</script>

<script>
	function getFileBaseName(s){
		var p=s.split(',');
		return p[0];
	}
	function getFileBaseName2(s){
		var p=s.split(',');
		if(p.length>1){
			return p[1];
		}else{
			return null;
		}
	}
	function getFileBaseName3(s){
		var p=s.split(',');
		if(p.length>2){
			return p[2];
		}else{
			return null;
		}
	}
</script>
	<script>
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
			var form = layui.form,table = layui.table,
			layer = parent.layer == 'undefined' ? layui.layer : parent.layer,
			laypage = layui.laypage,admin = layui.admin,
			$ = layui.jquery;
			//数据表格
			table.render({
				id:'candidateList',
			    elem: '#candidateList'
			    ,url: '${root}/vote/sysGetAllCandidate' //数据接口
			    ,limit:10//每页默认数
			    ,limits:[10,20,30,40]
			    ,cols: [[ //表头
	              {field:'candidateName', title: '姓名',minWidth:100}
	              ,{field:'activityId', title: '活动名称',minWidth:100,templet:'#ActivityNameTpl'}
	              ,{field:'iphone', title: '联系方式',minWidth:100}
	              ,{field:'address', title: '地址',minWidth:100}
	              ,{field:'candidateDescribe', title: '描述',minWidth:100}
	              ,{field:'picture', title: '作品',minWidth:100,templet:'#pictureTpl'}
	              ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:120}
			    ]]
					,page: true //开启分页
					,where: {timestamp: (new Date()).valueOf()}
			  });
			
			var active = {
					reload : function() {
						table.reload('candidateList', {
							where : {
								activitySelectName : $('#activitySelectName').val(),
								candidateSelectName : $('#candidateSelectName').val(),
								
							}
						});
					}
				};

				$('#reloadBtn').on('click', function() {
					var type = $(this).data('type');
					active[type] ? active[type].call(this) : '';
				});

				window.tableReload = function tableReload() {
					table.reload('candidateList', {
						where : {
							activitySelectName : $('#activitySelectName').val(),
							candidateSelectName : $('#candidateSelectName').val(),
							
						}
					});
				};
			
			//监听工具条
			  table.on('tool(candidateList)', function(obj){
				 
			    var data = obj.data;
			    console.log(data);
			    if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			    	  $.ajax({
			    		  url:'${root}/vote/sysCandidateDel?candidateId='+data.candidateId,
			    		  type : "get",
			    		  success : function(res){
			    			  if(res.result_code){
			    				  obj.del();
			    				  toast('操作成功');
			    				  table.reload('candidateList', {});
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
				          title : "修改参赛者信息",
				          content: "${root }/vote/sysCandidateEditWeb?candidateId="+data.candidateId,
				          maxmin: true,
					      area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],
					      btn: ['确定', '取消'],
				          btnAlign: 'c',
					      yes: function(index, layero){
					        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
					            var inputForm = body.find('#layuiadmin-form-admin');//这是你弹出层 表单对象
					            if(checkedAdd(inputForm[0])){
					            	$.ajax({
										url : '${root}/vote/sysCandidateUpdate',
										data : fromData,
										type : 'POST',
										dataType : 'json',
										success : function(res) {
											if (res.result_code) {
												toast('操作成功');
												table.reload('candidateList', {});
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
			  

		//添加参赛者
		$(".candidateAdd_btn").click(function(){
			layer.open({
				type: 2,
		        title: '新增参赛者',
		        content: '${root}/vote/sysCandidateEditWeb',
		        maxmin: true,
		        area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],
		        btn: ['确定', '取消'],
		        btnAlign: 'c',
		        yes: function(index, layero){
		        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
		            var inputForm = body.find('#layuiadmin-form-admin');//这是你弹出层 表单对象
		            if(checkedAdd(inputForm[0])){
		            	$.ajax({
							url : '${root}/vote/sysCandidateInsert',
							data : fromData,
							type : 'POST',
							dataType : 'json',
							success : function(res) {
								if (res.result_code ) {
									//toastANDRedirect('添加成功','${root}/sys/adminListView');
									toast('添加成功');
									table.reload('candidateList', {});
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
		  let candidateId = $(div).find("input[name='candidateId']").val();
		  let candidateName = $(div).find("input[name='candidateName']").val();
		  let iphone = $(div).find("input[name='iphone']").val();
		  let address = $(div).find("input[name='address']").val();
		  let candidateDescribe = $(div).find("textarea[name='candidateDescribe']").val();
		  let picture ="";
		  $(div).find("input[name='picture']").each(function(j,item){
			  picture=picture+item.value+",";
			  console.log(picture+"shuju"); 
		  });
		  
		  if(picture.charAt(picture.length-1)==","){
			  picture=picture.substr(0,picture.length-1);
		  }
		  let activityId = $(div).find("select[name='activityId']").val();
		  
		  
		  if ($.trim(candidateName) == '') {
				parent.layer.msg('名字不能空');
				return false;
			}
		  if (!checkPhone(iphone)) {
				parent.layer.msg('请输入正确的手机号');
				return false;
			}
		  if ($.trim(address) == '') {
				parent.layer.msg('请输入地址');
				return false;
			}
		  if ($.trim(candidateDescribe) == '') {
				parent.layer.msg('请输入作品描述');
				return false;
			}
		  if ($.trim(picture) == '') {
				parent.layer.msg('请上传作品');
				return false;
			}
		  if ($.trim(activityId) == '-1') {
				parent.layer.msg('请选择活动');
				return false;
			}
		  
		  fromData.candidateId=candidateId;
		  fromData.candidateName=candidateName;
		  fromData.iphone=iphone;
		  fromData.address=address;
		  fromData.candidateDescribe=candidateDescribe;
		  fromData.picture=picture;
		  fromData.activityId=activityId;
		return true;
	}
</script>

</body>
</html>