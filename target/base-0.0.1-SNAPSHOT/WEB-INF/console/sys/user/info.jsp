<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>设置我的资料</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header">设置我的资料</div>
					<div class="layui-card-body" pad15>
						<input id="adminId" type="hidden" name="id" value="${admin.id }" />
						<div class="layui-form" lay-filter="">
							<div class="layui-form-item">
								<label class="layui-form-label">我的角色</label>
								<div class="layui-input-inline">
									<select name="role" lay-verify="">
										<option value="1" selected>${admin.lwRoles.roleName}</option>
										<!-- <option value="2" disabled>普通管理员</option>
                    <option value="3" disabled>审核员</option>
                    <option value="4" disabled>编辑人员</option> -->
									</select>
								</div>
								<div class="layui-form-mid layui-word-aux">当前角色不可更改为其它角色</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">用户名</label>
								<div class="layui-input-inline">
									<input type="text" name="username" value="${admin.username}"
										readonly class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">昵称</label>
								<div class="layui-input-inline">
									<input type="text" id="fullname" name="fullname"
										value="${admin.fullname}" lay-verify="nickname"
										autocomplete="off" placeholder="请输入昵称" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">性别</label>
								<div class="layui-input-block">
									<input type="radio" name="sex" value="0" title="女"
										<c:if test="${admin.sex=='0' }">checked="checked"</c:if> /> <input
										type="radio" name="sex" value="1" title="男"
										<c:if test="${admin.sex=='1' }">checked="checked"</c:if> /> <input
										type="radio" name="sex" value="2" title="保密"
										<c:if test="${admin.sex=='2' }">checked="checked"</c:if> />
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">手机</label>
								<div class="layui-input-inline">
									<input type="text" id="phone" name="phone"
										value="${admin.phone }" lay-verify="phone" autocomplete="off"
										class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">邮箱</label>
								<div class="layui-input-inline">
									<input type="text" id="eMail" name="eMail"
										value="${admin.eMail }" lay-verify="email" autocomplete="off"
										class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn" id="setmyinfo">确认修改</button>
									<button type="reset" class="layui-btn layui-btn-primary">重新填写</button>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var data = {};
		layui.config({
			base : '${root}/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use([ 'index', 'set' ], function() {
			$('#setmyinfo').click(function() {
				if (checkedSubmit()) {
					$.ajax({
						url : '${root}/user/personalData',
						data : data,
						type : 'POST',
						dataType : 'json',
						success : function(res) {
							if (res.result_code && res.return_code) {
								toast('修改成功，重新登录生效');
							} else {
								toast('修改失败');
							}
						}
					});
				}
			});
		});

		function checkedSubmit() {
			let phone = $.trim($('#phone').val());
			let eMail = $.trim($('#eMail').val());
			let fullname = $.trim($('#fullname').val());
			let sex = $("input[name='sex']:checked").val();
			if (fullname == '') {
				toast('昵称不能为空');
				return false;
			}
			if (!checkPhone(phone)) {
				toast('请输入正确的手机号');
				return false;
			}
			if (!checkEmail(eMail)) {
				toast('邮箱格式不正确');
				return false;
			}
			data.id = $('#adminId').val();
			data.fullname = fullname;
			data.phone = phone;
			data.eMail = eMail;
			data.sex = sex;
			return true;
		}
	</script>
</body>
</html>