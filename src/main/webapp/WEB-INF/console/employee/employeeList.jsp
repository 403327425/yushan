<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>${titleName}</title>
	<%@ include file="/WEB-INF/console/common/includ.jsp" %>
	<style type="text/css">
	    html,body,.search-wrap{
	      height: 100%;
	    }   
		.body_list .layui-table-view{
			height:calc(100% - 48px);
			margin-bottom: 0;
		}
		.body_list .layui-table-view .layui-table-box{
			height: calc(100% - 42px);
		}
		.layui-table-box,.layui-table-view.layui-border-box,.container{
			height:100%;
		}	
		.container {
		   height: calc(100% - 48px);
		}
		.body_list .layui-table-body{
		   max-height: calc(100% - 42px);
		}
	</style>
</head>
<body class="body_list">
	<div class="search-wrap layui-form" >	
		<div class="layui-input-inline">
			<select id="post" name="post" class="layui-input" lay-search="">
				<option value="" id="">请选择职位</option>
				<c:forEach items="${postList}" var="postList">
					<option value="${postList.dkId }" >${postList.dictionaryValue }</option>
				</c:forEach>
	        </select>
		</div>
		<div class="layui-input-inline">
		  	<input class="layui-input" name="employeeName" id="employeeName" placeholder="姓名" autocomplete="off">
		</div>
		<div class="layui-inline">
             <input type="text" readonly="readonly" id="beginDate" name="beginDate" class="layui-input userName" placeholder="创建时间(开始)" value="">
         </div>
         <div class="layui-inline">
             <input type="text" readonly="readonly" id="endDate" name="endDate" class="layui-input userName" placeholder="创建时间(结束)" value="">
         </div>
		<button class="layui-btn" id="reloadBtn" data-type="reload"><i class="layui-icon">&#xe615;</i></button>   
		<button class="layui-btn"  onclick="clearParam()"><i class="layui-icon">清除</i></button>   
		<button class="btn layui-btn" id="add"><i class="layui-icon">&#xe608;</i>添加</button>  
		<div class="container"><table id="employee" lay-filter="employee" class="layui-hide"></table></div>
	</div>
	
	<script type="text/html" id="operate">
           <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        {{# if(d.eStatus == 1 ){ }} 
	       <a class="layui-btn  layui-btn-danger layui-btn-xs" key="0" lay-event="status">禁用</a>
        {{# }else if(d.eStatus == 0){ }}
	       <a class="layui-btn layui-btn-primary layui-btn-xs" key="1" lay-event="status">启用</a>
        {{#  } }}
		<!-- <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a> 待定功能 -->
	</script>
	
	<script type="text/html" id="eStatus">
        {{# if(d.eStatus == 1 ){ }} 
			<span style="color: #01AAED;">启用</a>
        {{# }else if(d.eStatus == 0){ }}
			<span style="color: #F581B1;"> 禁用</a>
        {{#  } }}
	</script>
	
	<script type="text/javascript">
		//时间控件设置 yyyy-MM-dd
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			laydate.render({
				elem : '#beginDate'
			});
			laydate.render({
				elem : '#endDate'
			});
		});
	
	    layui.config({
	        base: '${root}/layuiadmin/' //静态资源所在路径
	    }).extend({
	        index: 'lib/index' //主入口模块
	    }).use(['form', 'table','laydate','index'], function(){
			var table = layui.table;
				form = layui.form;
				layer = layui.layer;
				layedit = layui.layedit;
			 	laydate = layui.laydate;
			 	admin = layui.admin;
			 
			//第一个实例
			table.render({
				elem: '#employee',
				cellMinWidth: 40, 
				url: '${root}/employee/getData', //数据接口
				page: true, //开启分页
				limit:20, //初始显示20条数据	
				id:'employee',
				cols: [[ //表头
					{field: 'againPost',minWidth :'200',align:'center', title: '职位'},
					{field: 'employeeName',minWidth :'200',align:'center', title: '姓名'},
					{field: 'againSex',minWidth :'200',align:'center', title: '性别'},	
					{field: 'eContactWay',minWidth :'200',align:'center', title: '联系方式'},   
					{field: 'eStatus',minWidth :'200',align:'center', title: '状态',templet:'#eStatus'},
					{field : 'eCreationTime',minWidth :'200',align:'center', title : '创建时间',templet : '<div>{{ formatTime(d.eCreationTime,"yyyy-MM-dd hh:mm:ss")}}</div>'},			
					{field: 'againOperator',minWidth :'200',align:'center', title: '创建人'},			
					{fixed: 'right', minWidth :'120',title:"操作",align:'left', toolbar: '#operate'},
					]],
				 done:function(){			
				  }
			});
			
			var  active = {
				reload: function(){
				  	table.reload('employee', {
						where: {						
							post:$('#post').val(),
							employeeName:$('#employeeName').val(),
							beginDate:$('#beginDate').val(),
							endDate:$('#endDate').val()
						}
				  	});
				}
			};
			 
			$('#reloadBtn').on('click', function(){
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
			  
			window.tableReload = function tableReload(){
				table.reload('employee',{
					where: {						
					  	post:$('#post').val(),
					  	employeeName:$('#employeeName').val(),
					    beginDate:$('#beginDate').val(),
					    endDate:$('#endDate').val()
					}
			  });
			};
				
			//监听工具条
			table.on('tool(employee)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				var data = obj.data; //获得当前行数据
				var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				//var tr = obj.tr; 获得当前行 tr 的DOM对象
				if (layEvent === 'edit') { //编辑
					edit("编辑员工",addOrEditUrl+"?ekId="+ data.ekId + "&method=EDIT");
				}else if (layEvent === 'status') {//修改状态
					var key = $(this).attr("key");
					update(data.ekId, key);
				}else if(layEvent === 'del'){ //删除
					layer.confirm('真的要删除行么', function(index){
						$.ajax({
							url: '${root}/employee/delete',
							type:'post',
							dataType:'json',
							data:"ekId="+data.ekId,
							success:function (res) {
								if(res.STATE == 'SUCCESS'){
									layer.msg(res.MSG);
									table.reload('employee');
								}else{
									 layer.msg(res.MSG);
								}
							},
							'error':function () {
								layer.msg('系统错误');
							 }
						});
					});
				}
			});
		
		});
	
	    var addOrEditUrl = '${root}/employee/toInsertOrupdate';
	    
		$("#add").on('click', function() {
			edit("添加员工",addOrEditUrl+"?method=ADD");
		});
		
		function edit(title,url){
			layer.open({
		        type: 2,
		        title: title,
		        content: url,
		        maxmin: true,
		        area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],
		        btn: ['确定', '取消'],
		        yes: function(index, layero){
		        	var layiframe = $("#layui-layer-iframe"+index)[0];
					if(layiframe.contentWindow && layiframe.contentWindow.dataSave){
						var val=layiframe.contentWindow.dataSave();
						if(val== 'SUCCESS'){
							layer.msg('保存成功');	
							setTimeout(function(){layer.close(index);tableReload();},1000);
						}else if(val== '0'){
							
						}else{
							layer.msg('保存失败');		
						}
					}
		        }
		  	});
		}
	
		function update(ekId, key) {
			var title = "";
			var icon = "";
			if (key == 1) {
				title = "启用";
				icon = 1;
			} else if (key == 0) {
				title = "禁用";
				icon = 3;
			}
			layer.confirm('确定' + title + '?', { icon : icon, title : '提示' }, function(index) {
				layer.close(index);
				$.ajax({
					timeout : 3000,
					data : { "ekId" : ekId, "eStatus" : key },
					type : "POST",
					url : "${root}/employee/alterStatus",
					dateType : "json",
					success : function(res) {
						layer.msg(res.MSG);
						if (res.STATE == "SUCCESS") {
							 setTimeout(function(){tableReload();},1000);
						}
					}
				});
			});
		}
	
		//搜索重置
		function clearParam() {
			$(".search-wrap  input").each(function(idx, obj) {
				$(this).val("");
			});
			$(".search-wrap  select").each(function(idx, obj) {
				$(this).val("");
			});
			tableReload();
		}
	
		function flashlaod() {
			layer.confirm('登陆已过期，点击确认重新登陆', {
				icon : 3,
				title : '温馨提示'
			}, function(index) {
				parent.location.reload();
			});
		}
	</script>		
</body>
</html>