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
			height:95%;
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
		  	<input class="layui-input" name="dictionaryTypeName" id="dictionaryTypeName" placeholder="字典表名" autocomplete="off">
		</div>
		<div class="layui-input-inline">
            <input class="layui-input" name="dictionaryTypeValue" id="dictionaryTypeValue" placeholder="字典字段" autocomplete="off">
        </div>
        <div class="layui-input-inline">
          <select name="dictionaryTypeType" id="dictionaryTypeType">
            <option value="">字典类型</option>  
            <option value="1">表</option>   
            <option value="2">字段</option>                             
          </select>
        </div>
        <div class="layui-inline">
             <input type="text" readonly="readonly" id="beginDate" name="beginDate" class="layui-input userName" placeholder="创建时间(开始)" value="">
         </div>
         <div class="layui-inline">
             <input type="text" readonly="readonly" id="endDate" name="endDate" class="layui-input userName" placeholder="创建时间(结束)" value="">
         </div>
		<button class="layui-btn" id="reloadBtn" data-type="reload"><i class="layui-icon">&#xe615;</i></button>   
		<button class="layui-btn"  onclick="clearParam()"><i class="layui-icon">清除</i></button>   
		<button class="btn layui-btn" id="add"><i class="layui-icon">&#xe608;</i> 添加</button>  
		<table id="dictionaryType" lay-filter="dictionaryType" class="layui-hide"></table>
	</div>
	
	<script type="text/html" id="operate">
        <a class="layui-btn  layui-btn-xs layui-btn-xs" lay-event="edit">编辑</a>
	</script>
	
	<script type="text/html" id="type">
        {{# if(d.dictionaryTypeType == 1 ){ }} 
                    表
        {{# }else if(d.dictionaryTypeType == 2){ }}
                    字段
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
			base : '${root}/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use([ 'table', 'laydate','index' ],function() {
			var table = layui.table;
			laydate = layui.laydate;
			admin = layui.admin;

			//第一个实例
			table.render({
				elem : '#dictionaryType',
				cellMinWidth : 40,
				url : '${root}/dictionaryType/getData', //数据接口 
				page : true, //开启分页 
				limit : 20, //初始显示20条数据
				id : 'dictionaryType',
				cols : [ [ //表头
					{field : 'dictionaryTypeName',minWidth :'120',align : 'center',title : '字典名'}, 
					{field : 'dictionaryTypeValue',minWidth :'120',align : 'center',title : '字典值'}, 
					{field : 'dictionaryTypeType',minWidth :'100',align : 'center',title : '字典类型',templet : '#type'}, 
					{field : 'fatherName',minWidth :'120',align : 'center',title : '父表'}, 
					{fixed : 'right',title : "操作",minWidth :'100',width : 100,align : 'center',toolbar : '#operate'} 
				] ],
				done : function() {
					
				}
			});

			var active = {
				reload : function() {
					table.reload('dictionaryType', {
						where : {
							dictionaryTypeName : $('#dictionaryTypeName').val(),
							dictionaryTypeValue : $('#dictionaryTypeValue').val(),
							dictionaryTypeType : $('#dictionaryTypeType').val(),
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
				table.reload('dictionaryType', {
					where : {
						dictionaryTypeName : $('#dictionaryTypeName').val(),
						dictionaryTypeValue : $('#dictionaryTypeValue').val(),
						dictionaryTypeType : $('#dictionaryTypeType').val(),
						beginDate : $('#beginDate').val(),
						endDate : $('#endDate').val(),
					}
				});
			};

			//监听工具条
			table.on('tool(dictionaryType)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				var data = obj.data; //获得当前行数据
				var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				//var tr = obj.tr; 获得当前行 tr 的DOM对象
				if (layEvent === 'edit') { //编辑
					edit("编辑字典类型",addOrEditUrl+"?dtkId="+ data.dtkId + "&method=EDIT");
				}
			});

		});

		var addOrEditUrl = '${root}/dictionaryType/toInsertOrupdate';
		
		$("#add").on('click', function() {
			edit("添加字典类型",addOrEditUrl+"?method=ADD");
		});
		
		function edit(title,url){
			layer.open({
				type: 2,
		        title: title,
		        content: url,
		        maxmin: true,
		        area: admin.screen() < 2 ? ['90%', '60%'] : ['60%', '60%'],
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