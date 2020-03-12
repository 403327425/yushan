<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>设置我的密码</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">修改密码</div>
          <div class="layui-card-body" pad15>
            
            <div class="layui-form" lay-filter="">
              <div class="layui-form-item">
                <label class="layui-form-label">当前密码</label>
                <div class="layui-input-inline">
                  <input type="password" name="oldPassword" lay-verify="required" lay-verType="tips" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                  <input type="password" name="password" lay-verify="pass" lay-verType="tips" autocomplete="off" id="LAY_password" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">确认新密码</label>
                <div class="layui-input-inline">
                  <input type="password" name="repassword" lay-verify="repass" lay-verType="tips" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" lay-submit lay-filter="setmypass">确认修改</button>
                </div>
              </div>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
  layui.config({
    base: '${root}/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index','form'],function(){
	  var form=layui.form;
	//自定义验证
	  form.verify({
	    
	    //我们既支持上述函数式的方式，也支持下述数组的形式
	    //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
	    pass: [
	      /^[\S]{6,12}$/
	      ,'密码必须6到12位，且不能出现空格'
	    ]
	    
	    //确认密码
	    ,repass: function(value){
	      if(value !== $('#LAY_password').val()){
	        return '两次密码输入不一致';
	      }
	    }
	  });
	  form.on('submit(setmypass)', function(obj){
		    //提交修改
		    $.ajax({
		      url: '${root}/user/changePwd'
		      ,data: {
		    	  oldPassWord:hex_md5(obj.field.oldPassword),
		    	  newPassWord:hex_md5(obj.field.password)
		      }
		      ,dataType:'json'
		      ,success: function(res){
		    	  if (res.result_code && res.return_code) {
		    		  $.ajax({
		    			  url:'${root}/user/loginOut',
		    			  success:function(res){
		    				  if (res.result_code && res.return_code) {
		    					  toastSuccessMsgANDRelonin('修改成功，重新登录','${root}/user/login');
		    					}
		    			  }
		    		  });
					} else {
						toast('修改失败');
					}
		      }
		    });
		  });
  });
  </script>
</body>
</html>