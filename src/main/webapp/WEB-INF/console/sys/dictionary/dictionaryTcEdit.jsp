<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>${titleName}</title>
	<%@ include file="/WEB-INF/console/common/includ.jsp" %>
</head>
<body>
	<div class="w_300">	
		<form  class="layui-form"  action="${root}/dictionaryType/insertOrupdate"  method="post" >
			<input type="hidden"  id='dtkId' name="dtkId"  value="${data.dtkId}" />	
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;字典名</label>
				<div class="layui-input-block">
					<input type="text" id="dictionaryTypeName" name="dictionaryTypeName" value="${data.dictionaryTypeName}" autocomplete="off" class="layui-input" placeholder="输入名称">
				</div>
			</div>	
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;字典值</label>
				<div class="layui-input-block">
					<input type="text" id="dictionaryTypeValue" name="dictionaryTypeValue" value="${data.dictionaryTypeValue}" autocomplete="off" class="layui-input" placeholder="输入名称">
				</div>
			</div>	
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;字典类型</label>
				<div class="layui-input-block">
					<select id="dictionaryTypeType" name="dictionaryTypeType" class="layui-input" lay-filter="test">
			              <option value="2" <c:if test="${data.dictionaryTypeType=='2'}">selected</c:if>>字段</option>
			              <option value="1" <c:if test="${data.dictionaryTypeType=='1'}">selected</c:if>>表</option>
		            </select>
				</div>
			</div>	
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;父表</label>
				<div class="layui-input-block">
					<select id="dtParentId" name="dtParentId" class="layui-input" lay-search="">
						<c:forEach items="${dictionaryTypeList}" var="typeList">
							 <option value="${typeList.dtkId }" <c:if test="${typeList.dtkId eq data.dtParentId}">selected</c:if>>${typeList.dictionaryTypeName }</option>
						</c:forEach>
		            </select>
				</div>
			</div>
		</form>
	</div>
	
<script type="text/javascript">
	
	$(document).ready(function() {
		if($('#dictionaryTypeType option:selected').val() == 1){
			$('#dtParentId').attr('disabled', 'disabled');
			form.render('select'); 
		}
	});

	layui.config({
        base : '${root}/layuiadmin/' //静态资源所在路径
    }).extend({
        index : 'lib/index' //主入口模块
    }).use(['form', 'layedit', 'laydate'], function(){
		  var form = layui.form;
		  layer = layui.layer;
		  layedit = layui.layedit;
		  laydate = layui.laydate;
		  
		  //如果第一个下拉列表的值改变则调用此方法
		  form.on('select(test)', function(data){
			  var dtParentId = data.value;//得到被选中的值
			  if(dtParentId == '1'){
				  $("#dtParentId").attr("disabled", true);
				  form.render('select'); 
			  } else{
				  $("#dtParentId").attr("disabled", false);
				  form.render('select'); 
			  }
		  }); 
	});
	
	//新增 or 修改
    function dataSave(){
        var dictionaryTypeName = $("#dictionaryTypeName").val();
        var dictionaryTypeValue = $("#dictionaryTypeValue").val();
        var dictionaryTypeType = $("#dictionaryTypeType").val();
        
        dictionaryTypeName = $.trim(dictionaryTypeName);
        dictionaryTypeValue = $.trim(dictionaryTypeValue);
        dictionaryTypeType = $.trim(dictionaryTypeType);

        if(!dictionaryTypeName){
            layer.msg("字典名不能为空");
            return false;
        }
        if(!dictionaryTypeValue){
            layer.msg("字典值不能为空");
            return false;
        }
        if(!dictionaryTypeType){
            layer.msg("字典类型不能为空");
            return false;
        }   
        var result = "";
		$.ajax({
				url: $("form").attr("action"),
				type:'post',				 
				data:$("form").serialize(),
				dataType:'json',
				async:false,
				success:function (res) {
					result = res.STATE;
				},
				error:function () {
					layer.msg('系统错误');
				 }
			});
		return result;
    }
</script>	      


</body>
</html>