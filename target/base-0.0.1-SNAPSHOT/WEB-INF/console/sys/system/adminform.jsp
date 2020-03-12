<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>添加管理员 </title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <%@ include file="/WEB-INF/console/common/includ.jsp"%>
</head>
<body class="layui-layout-body">

  <div class="layui-form" lay-filter="layuiadmin-form-admin" id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
  	<input type="hidden" name="id" value="${admin.id }">
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;登录名</label>
      <div class="layui-input-inline">
        <input type="text" name="username" value="${admin.username }" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
      </div>
    </div>
    <c:if test="${admin!=null }">
    <div class="layui-form-item">
      <label class="layui-form-label">昵称</label>
      <div class="layui-input-inline">
        <input type="text" name="fullname" value="${admin.fullname }" lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
      </div>
    </div>
    </c:if>
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;通讯地址</label>
      <div class="layui-input-inline">
        <input type="text" name="address" value="${admin.address }" placeholder="请输入通讯地址" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
		<label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;性别</label>
		<div class="layui-input-block">
			<input type="radio" name="sex" value="0" title="女" <c:if test="${admin.sex=='0' }">checked="checked"</c:if>>
			<input type="radio" name="sex" value="1" title="男" <c:if test="${admin.sex=='1' }">checked="checked"</c:if>>
			<input type="radio" name="sex" value="2" title="保密" <c:if test="${admin.sex=='2' }">checked="checked"</c:if>>
		</div>
	</div>
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;手机</label>
      <div class="layui-input-inline">
        <input type="text" name="phone" value="${admin.phone }" lay-verify="phone" placeholder="请输入号码" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;邮箱</label>
      <div class="layui-input-inline">
        <input type="text" name="eMail" value="${admin.eMail }" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label"><span class="layui-badge-dot"></span>&nbsp;角色</label>
      <div class="layui-input-block">
      <c:forEach var="role" items="${roles}">
        <input type="radio" name="lwRoles" value="${role.roleId }" lay-skin="primary" title="${role.roleName }" <c:if test="${admin.lwRoles.roleId==role.roleId }">checked='checked'</c:if>>
      </c:forEach>
      </div>
    </div>
	<div class="layui-form-item layui-hide">
      <input type="button" lay-submit lay-filter="LAY-user-front-submit" id="LAY-user-front-submit" value="确认">
    </div>
  </div>
  <script>
  layui.config({
    base: '${root}/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'form'], function(){
    var $ = layui.$,
    form = layui.form ;
    
  })
  </script>
</body>
</html>