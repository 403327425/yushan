<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <title>添加活动 </title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <%@ include file="/WEB-INF/console/common/includ.jsp"%>
</head>
<body class="layui-layout-body">
	<div class="layui-form" lay-filter="layuiadmin-form-activity" id="layuiadmin-form-activity" style="padding: 20px 30px 0 0;">
	<input type="hidden" name="id" value="${voter.id}">
	
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;活动</label>
				<div class="layui-input-block">
					<select id="activityId" name="activityId" class="layui-input" lay-filter="test" lay-search="">
					<option value="-1" >请选择</option>
						<c:forEach items="${activityList}" var="activity">
							 <option value="${activity.activityId }" <c:if test="${activity.activityId eq voter.activityId}">selected</c:if>>${activity.activityName }</option>
						</c:forEach>
		            </select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;参赛者</label>
				<div class="layui-input-block">
					<select id="candidateId" name="candidateId" class="layui-input" lay-search="">
					<option value="-1" >请选择</option>
						<c:forEach items="${candidateList}" var="candidate">
							 <option value="${candidate.candidateId }" >${candidate.candidateName }</option>
						</c:forEach>
		            </select>
				</div>
			</div>
	
	
<%-- 	<div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;候选人编号</label>
      <div class="layui-input-inline">
        <input type="text" name="candidateId" value="${voter.candidateId }" lay-verify="required" placeholder="请输入候选人编号" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;投票活动编号</label>
      <div class="layui-input-inline">
        <input type="text" name="activityId" value="${voter.activityId }" lay-verify="required" placeholder="请输入投票活动编号" autocomplete="off" class="layui-input">
      </div>
    </div> --%>
    
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;IP地址</label>
      <div class="layui-input-inline">
        <input type="text" name="ip" value="${voter.ip }" lay-verify="required" placeholder="请输入IP地址" autocomplete="off" class="layui-input">
      </div>
    </div>
	
	
	<div class="layui-form-item">
		<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;投票时间</label>
		 
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" id="voteTime"  name="voteTime" value="<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${voter.voteTime }"/>" placeholder="选择时间">
		      </div>
    	
	</div>
	
	<div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;登录后用户ID</label>
      <div class="layui-input-inline">
        <input type="text" name="userId" value="${voter.userId }" lay-verify="required" placeholder="可输入用户ID" autocomplete="off" class="layui-input">
      </div>
    </div>
    
	</div>
	<script>
	  layui.config({
	    base: '${root}/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index','laydate', 'upload','form' ,'jquery'], function(){
	    var $ = layui.$,
	    form = layui.form ;
	    laydate = layui.laydate;
	    upload=layui.upload;
	    laydate.render({
	  	  elem: '#voteTime' ,type: 'datetime'
	  	});
	    var dtParentId = $("#activityId").val();
	    $.ajax({
 			type: "post",  
				data: {"activityId":dtParentId},  
				url: '${root}/vote/getAllCandidateByActivityId',
			dataType:"json",
			success:function(res){
				$("#candidateId").html("");//清空第二个下拉框
				form.render();
				console.log(res);
				var option = "";
				for(var i=0;i<res.length;i++){
					if(res[i].candidateId=="${voter.candidateId}"){
						option +="<option value="+res[i].candidateId+" selected>"+res[i].candidateName+"</option> "
					}else{
						option +="<option value="+res[i].candidateId+">"+res[i].candidateName+"</option> "
					}
					
				}
				$("#candidateId").html(option);//将循环拼接的字符串插入第二个下拉列表  
            	form.render();
/* 	        				var option = "";   
				var val = "${data.dictionaryColum}";
            	if(res.data != null && res.data != ""){
            		for(var key in res.data){
            			if(res.data[key].dictionaryTypeValue == val){
            				option += "<option value='"+res.data[key].dictionaryTypeValue+"' selected = 'selected'>"+res.data[key].dictionaryTypeName+"</option>";
            			}else{
            				option += "<option value='"+res.data[key].dictionaryTypeValue+"'>"+res.data[key].dictionaryTypeName+"</option>";
            			}
                	}
                	$("#candidateId").html(option);//将循环拼接的字符串插入第二个下拉列表  
                	form.render();
            	} */
			}
	 	});
		  form.on('select(test)', function(data){
			  console.log(data);
			  var dtParentId = data.value;//得到被选中的值
			  if(dtParentId == '-1'){
				
			  }else{
				  $.ajax({
	         			type: "post",  
	       				data: {"activityId":dtParentId},  
	       				url: '${root}/vote/getAllCandidateByActivityId',
	        			dataType:"json",
	        			success:function(res){
	        				$("#candidateId").html("");//清空第二个下拉框
	        				form.render();
	        				console.log(res);
	        				var option = "";
	        				for(var i=0;i<res.length;i++){
	        					
	        					option +="<option value="+res[i].candidateId+">"+res[i].candidateName+"</option> "
	        				}
	        				$("#candidateId").html(option);//将循环拼接的字符串插入第二个下拉列表  
	                    	form.render();
/* 	        				var option = "";   
	        				var val = "${data.dictionaryColum}";
	                    	if(res.data != null && res.data != ""){
	                    		for(var key in res.data){
	                    			if(res.data[key].dictionaryTypeValue == val){
	                    				option += "<option value='"+res.data[key].dictionaryTypeValue+"' selected = 'selected'>"+res.data[key].dictionaryTypeName+"</option>";
	                    			}else{
	                    				option += "<option value='"+res.data[key].dictionaryTypeValue+"'>"+res.data[key].dictionaryTypeName+"</option>";
	                    			}
		                    	}
		                    	$("#candidateId").html(option);//将循环拼接的字符串插入第二个下拉列表  
		                    	form.render();
	                    	} */
	        			}
				 	});
			  }
		  });
	    
	  })
	  
	  

  </script>
</body>
</html>