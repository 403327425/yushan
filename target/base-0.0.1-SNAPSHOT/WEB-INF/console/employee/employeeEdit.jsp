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
		<form  class="layui-form"  action="${root}/employee/insertOrupdate"  method="post" >
			<input type="hidden" id="ekId" name="ekId" value="${data.ekId}">	
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;职位</label>
				<div class="layui-input-block">
					<select id="post" name="post" class="layui-input" lay-search="">
						<option value="" id="">选择职位</option>
			            <c:forEach items="${postList}" var="postList">
							<option value="${postList.dkId }" <c:if test="${postList.dkId eq data.post }">selected</c:if>>${postList.dictionaryValue }</option>
						</c:forEach>
		            </select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;姓名</label>
				<div class="layui-input-block">
					<input type="text" id="employeeName" name="employeeName" value="${data.employeeName}" autocomplete="off" class="layui-input" placeholder="输入姓名">
				</div>
			</div>	
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;性别</label>
				<div class="layui-input-block">
					<c:forEach items="${sexList}" var="sexList">
						<input type="radio" id="sex" name="sex" value="${sexList.dkId }" title="${sexList.dictionaryValue }" <c:if test="${sexList.dkId eq data.sex }">checked="checked"</c:if>>
					</c:forEach>
				</div>
			</div>
	        <div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;联系方式</label>
				<div class="layui-input-block">
					<input type="text" id="eContactWay" name="eContactWay" value="${data.eContactWay}" autocomplete="off" class="layui-input" placeholder="输入联系方式">
				</div>
			</div>	
		</form>
	
	</div>
	<script type="text/javascript">
		layui.config({
		    base: '${root}/layuiadmin/' //静态资源所在路径
		}).extend({
		    index: 'lib/index' //主入口模块
		}).use(['form', 'layedit', 'laydate'], function(){
			  var form = layui.form;
			  layer = layui.layer;
			  layedit = layui.layedit;
			  laydate = layui.laydate;
			  
		});
	  
		function dataSave(){
		   	var post = $("#post").val();
			var employeeName = $("#employeeName").val();
			var sex = $('input:radio:checked').val();
			var eContactWay = $("#eContactWay").val();
		   
			post = $.trim(post);
			employeeName = $.trim(employeeName);
			sex = $.trim(sex);
			eContactWay = $.trim(eContactWay);
		
		   if(!post){
				layer.msg("请选择职位");
				return false;
			}
			if(!employeeName){
				layer.msg("姓名不能为空");
				return false;
			}
			if(!sex){
				layer.msg("请选择性别");
				return false;
			}	
			if(!eContactWay){
				layer.msg("联系方式不能为空");
				return false;
			}else{
				var myreg = /^1[34578]\d{9}$/;
				if (!myreg.exec(eContactWay)){
					layer.msg("手机号码有误，请重填");
					return false;
				}
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