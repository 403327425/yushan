<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>聊天群列表</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="https://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css"> 
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>
<script type="text/javascript" src="${root}/js/jquery-1.11.3.min.js"></script>
</head>
<body ">
<div class="warp">

	              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>聊天群列表</legend>
</fieldset>
  
  
    <div class="layui-form" lay-filter="layuiadmin-form-activity" id="layuiadmin-form-activity" style="padding: 20px 30px 0 0;">


			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;校区</label>
				<div class="layui-input-block">
					<select id="activityId" name="activityId" class="layui-input" lay-filter="test" lay-search="">
					<option value="-1" >请选择</option>
						
		            </select>
				</div>
			</div>
			<input type="hidden" name="select" value="">
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;聊天群</label>
				<div class="layui-input-block">
					<select id="candidateId" name="candidateId" class="layui-input" lay-filter="test02" lay-search="">
					<option value="-1" >请选择</option>
					
						
		            </select>
				</div>
			</div>
			<div class="layui-form-item" style="display: none;" id="showbox2" align="center">
				<button type="button" class="layui-btn layui-btn-fluid test1" id="upbtn">更新二维码</button><br/>
			</div>
			<div class="layui-form-item" id="showbox" style="display: none;" align="center">
                	
            </div>


</div>
</div>
			<script type="text/javascript" src="${root}/js/layer/layer.js"></script>
			<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
			<script src="${root}/js/webuploader.min.js"></script>
			<script src="${root}/js/diyUpload.js"></script>
<script>

layui.config({
    base: '${root}/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index','laydate','upload','form' ,'jquery','element', 'layer','table'], function(){
	  var $ = layui.$,
	  form = layui.form ;
	  var dtParentId = $("#activityId").val();
	  $.ajax({
		    url :"${root}/vote/getQRList", 
		    type : "post", 
		    dataType : "json", 
		    success : function(data)
		    {	
		    	$("#activityId")
		    	var str="<option value='-1'>请选择</option>";
				for(var i=0;i<data.length;i++){
					
					var flag=true;
					for(var j=0;j<i;j++){
						
						if(data[j].schoolName==data[i].schoolName){
							
							flag=false;
						}
					}
					
					if(flag){
						
						str +="<option value="+data[i].schoolName+">"+data[i].schoolName+"</option>";
						
					}
					
				}
				
				
				$("#activityId").html(str);
				form.render();
				
		    }, 
		    error: function (XMLHttpRequest, textStatus, errorThrown)
		    {
		        console.log(XMLHttpRequest);
		        console.log(textStatus);
		        console.log(errorThrown);
		    }
		});
	 
 	  form.on('select(test)', function(data){
		  console.log(data);
		  var dtParentId = data.value;//得到被选中的值
		  if(dtParentId == '-1'){
			  $("#showbox2").attr("style","display:none;");
		  }else{
			  
			  
			  $.ajax({
				    url :"${root}/vote/getQRList", 
				    type : "post", 
				    dataType : "json", 
				    success : function(data)
				    {	
				    	$("#showbox2").attr("style","display:none;");
				    	 var str="<option value='-1'>请选择</option>"
							  for(var i=0;i<data.length;i++){
								  if(dtParentId==data[i].schoolName){
									  str+="<option value="+data[i].id+">"+data[i].groupName+"</option>"
								  }
							  }
							  $("#candidateId").html(str);
							  form.render();
				    }, 
				    error: function (XMLHttpRequest, textStatus, errorThrown)
				    { 
				        console.log(XMLHttpRequest);
				        console.log(textStatus);
				        console.log(errorThrown);
				    }
				});
		  }
	  }); 
 	  
 	  
 	 form.on('select(test02)', function(data){
		  console.log(data);
		  var dtParentId = data.value;//得到被选中的值
		  if(dtParentId == '-1'){
			  $("#showbox2").attr("style","display:none;");
		  }else{
			  $.ajax({
				    url :"${root}/vote/getQRList", 
				    type : "post", 
				    dataType : "json", 
				    success : function(data)
				    {	
				    	for(var i=0;i<data.length;i++){
							  if(dtParentId==data[i].id){
								  $("#showbox").attr("style","display:block;");
								  $("#showbox").empty();
				            	  $("#showbox").append("<img src='${root}/upload/"+data[i].qrCode+"' />");
				            	  $("#showbox2").attr("style","display:block;");
							  }
						  }
				    }, 
				    error: function (XMLHttpRequest, textStatus, errorThrown)
				    { 
				        console.log(XMLHttpRequest);
				        console.log(textStatus);
				        console.log(errorThrown);
				    }
				});
		  }
	  });

  })
  
  

	
	



</script>
</body>
</html>