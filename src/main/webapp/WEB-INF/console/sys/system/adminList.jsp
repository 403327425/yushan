<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<title>管理员列表</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body class="layui-content-wrapper">
	<input type="hidden" id="adminId"
		value="<shiro:principal property="id"/>" />
	<blockquote class="layui-elem-quote list_search">
		<shiro:hasPermission name="sys:admin:save">
			<div class="layui-inline">
				<a class="layui-btn layui-btn-normal adminAdd_btn"><i
					class="layui-icon">&#xe608;</i>添加管理员</a>
			</div>
		</shiro:hasPermission>
	</blockquote>
	<!-- 数据表格 -->
	<table id="adminList" lay-filter="adminList"></table>
	
	<script type="text/html" id="barEdit">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/html" id="addressTpl">
 		 {{#  if(!d.address){ }}
   		 <span>无</span>
  		{{#  } else{ }}
   		 <span>{{d.address}}</span>
		{{#  } }}
	</script>
	<script type="text/html" id="roleTpl">
 		 {{#  if(d.lwRoles==null){ }}
   		 <span style="color: #FF0000;">未分配角色</span>
  		{{#  } else{ }}
   		 <span>{{d.lwRoles.roleName}}</span>
		{{#  } }}
	</script>
	<script type="text/html" id="sexTpl">
 		 {{#  if(d.sex == 0){ }}
   		 <span style="color: #FF00FF;">女</span>
  		{{#  } else if(d.sex == 1){ }}
   		 	<span style="color: #0000FF;">男</span>
		{{#  } else{ }}
   		 	<span style="color: #800080;">保密</span>
  		{{#  } }}
	</script>
	<script>
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
				id:'adminList',
			    elem: '#adminList'
			    ,url: '${root}/sys/adminList' //数据接口
			    ,limit:10//每页默认数
			    ,limits:[10,20,30,40]
			    ,cols: [[ //表头
	              {field:'username', title: '登陆名',minWidth:100}
	              ,{field:'fullname', title: '昵称',minWidth:100}
	              ,{field:'sex', title: '性别',minWidth:100,templet:'#sexTpl'}
	              ,{field:'address', title: '通讯地址',minWidth:100,templet:'#addressTpl'}
	              ,{field:'phone', title: '联系方式',minWidth:120}
	              ,{field:'roleName', title: '角色',minWidth:100,templet:'#roleTpl'}
	              ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:120}
			    ]]
					,page: true //开启分页
					,where: {timestamp: (new Date()).valueOf()}
			  });
			//监听工具条
			  table.on('tool(adminList)', function(obj){
			    var data = obj.data,adminId=$("#adminId").val();
			    if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			    	  $.ajax({
			    		  url:'${root}/sys/delAdmin?adminId='+data.id,
			    		  type : "get",
			    		  success : function(res){
			    			  if(res.result_code && res.return_code){
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
			    } else if(obj.event === 'edit'){
			    	layer.open({
				          type: 2,
				          title : "修改管理员",
				          content: "${root }/sys/editAdminView?adminId="+data.id,
				          maxmin: true,
					      area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],
					      btn: ['确定', '取消'],
				          btnAlign: 'c',
					      yes: function(index, layero){
					        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
					            var inputForm = body.find('#layuiadmin-form-admin');//这是你弹出层 表单对象
					            if(checkedAdd(inputForm[0])){
					            	$.ajax({
										url : '${root}/sys/editAdmin',
										data : fromData,
										type : 'POST',
										dataType : 'json',
										success : function(res) {
											if (res.result_code && res.return_code) {
												toast('操作成功');
												table.reload('adminList', {});
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
			  

		//添加管理员
		$(".adminAdd_btn").click(function(){
			layer.open({
				type: 2,
		        title: '新增管理员',
		        content: '${root}/sys/editAdminView',
		        maxmin: true,
		        area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],
		        btn: ['确定', '取消'],
		        btnAlign: 'c',
		        yes: function(index, layero){
		        	var body = top.layer.getChildFrame('body', index);//找页面下所有套的子类
		            var inputForm = body.find('#layuiadmin-form-admin');//这是你弹出层 表单对象
		            if(checkedAdd(inputForm[0])){
		            	$.ajax({
							url : '${root}/sys/editAdmin',
							data : fromData,
							type : 'POST',
							dataType : 'json',
							success : function(res) {
								if (res.result_code && res.return_code) {
									//toastANDRedirect('添加成功','${root}/sys/adminListView');
									toast('添加成功');
									table.reload('adminList', {});
									layer.close(index);
								} else {
									toast('添加失败');
								}
							}
						});
		            }
		            //以下代码layer = layui.layer 有效的,可以视为另一种实现
		        	/* var iframeWindow = window['layui-layer-iframe'+ index]
		            ,submitID = 'LAY-user-front-submit'
		            ,submit = layero.find('iframe').contents().find('#'+ submitID);

		            //监听提交
		            iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
		              var field = data.field;
		              console.log(field);
		              //$.ajax({});
		              layer.close(index);
		            });
		            submit.trigger('click'); */
		        }
			});
		});
		
	});
	
	//校验添加管理员数据
	function checkedAdd(div) {
		fromData={};
		let username = $(div).find("input[name='username']").val();
		let fullname = $(div).find("input[name='fullname']").val();
		let address = $(div).find("input[name='address']").val();
		let sex = $(div).find("input[name='sex']:checked").val();
		let phone = $(div).find("input[name='phone']").val();
		let eMail = $(div).find("input[name='eMail']").val();
		let roleId = $(div).find("input[name='lwRoles']:checked").val();
		if ($.trim(username) == '') {
			parent.layer.msg('用户名不能空');
			return false;
		}
		if (!checkPhone(phone)) {
			parent.layer.msg('请输入正确的手机号');
			return false;
		}
		if (!checkEmail(eMail)) {
			parent.layer.msg('邮箱格式不正确');
			return false;
		}
		if (!roleId) {
			parent.layer.msg('请分配角色');
			return false;
		}
		if ($.trim(address) != '') {
			fromData.address = address;
		}
		if ($.trim(fullname) != '') {
			fromData.fullname = fullname;
		}
		let adminId=$(div).find("input[name='id']").val();
		  if($.trim(adminId)!=''){
			  fromData.id = adminId;
		  }
		fromData.username = username;
		fromData.password = hex_md5('123456');
		fromData.phone = phone;
		fromData.eMail = eMail;
		fromData.sex = sex;
		fromData.roleId = roleId;
		return true;
	}
</script>
</body>
</html>