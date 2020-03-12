<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>

<head>
	<meta charset="utf-8">
	<title>调查问卷</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body class="layui-layout-body">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>基本信息</legend>
</fieldset>
<form class="layui-form" action="">
  <div class="layui-form-item" lay-filter="layui_open_box" id="layui_open_box">
    <label class="layui-form-label">问卷名称</label>
    
    <div class="layui-input-block">
    
      <input type="text" name="dcwjName" id="dcwjName" required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input" value="${param.dcwjName}">
    </div>
  </div>
</form>
 
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
  
});
</script>

</body>
</html>