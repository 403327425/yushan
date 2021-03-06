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
			<select id="dkId" name="dkId" class="layui-input" lay-filter="test" lay-search="">
				<option value="" id="">请选择一级目录</option>
		           <c:forEach items="${dictionaryTypeList}" var="typeList">
					<option value="${typeList.dtkId }" >${typeList.dictionaryTypeName }</option>
				</c:forEach>
	        </select>
		</div>
		<div class="layui-input-inline">
			<select id="dictionaryColum" name="dictionaryColum" class="layui-input" lay-search="">
	        </select>
		</div>
		<button class="layui-btn" id="reloadBtn" data-type="reload"><i class="layui-icon">&#xe615;</i></button>   
		<button class="layui-btn"  onclick="clearParam()"><i class="layui-icon">清除</i></button>   
		<button class="btn layui-btn" id="add"><i class="layui-icon">&#xe608;</i>添加</button>  
		<div class="container"><table id="dictionary" lay-filter="dictionary" class="layui-hide"></table></div>
	</div>
	
	<script type="text/html" id="operate">
           <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        {{# if(d.dictionaryStatus == 1 ){ }} 
	       <a class="layui-btn  layui-btn-danger layui-btn-xs" key="0" lay-event="status">禁用</a>
        {{# }else if(d.dictionaryStatus == 0){ }}
	       <a class="layui-btn  layui-btn-primary layui-btn-xs" key="1" lay-event="status">启用</a>
        {{#  } }}
	</script>
	
	<script type="text/html" id="dictionaryStatus">
        {{# if(d.dictionaryStatus == 1 ){ }} 
			<span style="color: #01AAED;">启用</a>
        {{# }else if(d.dictionaryStatus == 0){ }}
			<span style="color: #F581B1;"> 禁用</a>
        {{#  } }}
	</script>
	
	<script type="text/javascript">
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
			 
			//如果第一个下拉列表的值改变则调用此方法
			form.on('select(test)', function(data){
				var dtParentId = data.value;//得到被选中的值
				        
				if(dtParentId != null && "" != dtParentId){
				    $.ajax({
				      	type: "post",  
				      	data: {"dtParentId":dtParentId},  
				      	url: '${root}/dictionary/selectByValue',
				      	dataType:"json",
				      	success:function(res){
					        $("#dictionaryColum").html("");
					        form.render();
					        var option = "";   
					        if(res.data != null && res.data != ""){
								for(var key in res.data){
									option += "<option value='"+res.data[key].dictionaryTypeValue+"'>"+res.data[key].dictionaryTypeName+"</option>"; 
								}
								$("#dictionaryColum").html(option);//将循环拼接的字符串插入第二个下拉列表  
								form.render();
							}
						}
					});
				}else{
					$("#dictionaryColum").html("");
				    form.render();
				}
			});  
			 
			//第一个实例
			table.render({
				elem: '#dictionary',
				cellMinWidth: 40 ,
				url: '${root}/dictionary/getData', //数据接口
				page: true, //开启分页
				limit:20, //初始显示20条数据	
				id:'dictionary',
				cols: [[ //表头
					{field: 'dictionaryTableName',minWidth :'120',align:'center', title: '表名'},
					{field: 'dictionaryColum',minWidth :'120',align:'center', title: '列名'},
					{field: 'dictionaryValue',minWidth :'100',align:'center', title: '值'},	
					{field: 'dictionarySerialNumber',minWidth :'100',align:'center', title: '序号'},   
					{field: 'dictionaryStatus',minWidth :'100',align:'center', title: '状态',templet:'#dictionaryStatus'},
					{field: 'dictionaryRemarks',minWidth :'200',align:'center', title: '备注'},			
					{fixed: 'right', title:"操作",minWidth :'150',width:150, align:'center', toolbar: '#operate'},
				]],
				done:function(){			
				}
			});
			
			var active = {
				reload: function(){
					table.reload('dictionary', {
						where: {						
							dkId:$('#dkId').val(),
							dictionaryColum:$('#dictionaryColum').val()
						}
				  	});
				}
			};
			 
			$('#reloadBtn').on('click', function(){
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
			  
			window.tableReload = function tableReload(){
			  	table.reload('dictionary',{
				  	where: {						
						dkId:$('#dkId').val(),
					  	dictionaryColum:$('#dictionaryColum').val()
					}
			  	});
			};
			  
			//监听工具条
			table.on('tool(dictionary)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				var data = obj.data; //获得当前行数据
				var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				//var tr = obj.tr; 获得当前行 tr 的DOM对象
				if (layEvent === 'edit') { //编辑
					edit("编辑字典",addOrEditUrl+"?dkId="+ data.dkId + "&method=EDIT");
				} else if (layEvent === 'status') {//修改状态
					var key = $(this).attr("key");
					update(data.dkId, key);
				}
			});
		});
	
	    var addOrEditUrl = '${root}/dictionary/toInsertOrupdate';
	    
		$("#add").on('click', function() {
			edit("添加字典",addOrEditUrl+"?method=ADD");
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
		
		function update(id,key){
			var title = "";
			if(key == 1){
			 title = "启用";
			}else if(key == 2){
			 title = "删除";
			}
			layer.confirm('确定'+title+'?', {icon: 3, title:'提示'}, function(index){
				layer.close(index);
				$.ajax({
					timeout : 3000,
					data : {ckId:id,cState:key},
					type : "POST",
					url : updateUrl,
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
	
		function update(dkId, key) {
			var title = "";
			if (key == 1) {
				title = "启用";
			} else if (key == 0) {
				title = "禁用";
			}
			layer.confirm('确定' + title + '?', { icon : 3, title : '提示' }, function(index) {
				layer.close(index);
				$.ajax({
					timeout : 3000,
					data : { "dkId" : dkId, "dictionaryStatus" : key },
					type : "POST",
					url : "${root}/dictionary/alterStatus",
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