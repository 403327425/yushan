<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>发起投票</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" type="text/css" href="${root}/newcss/common.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/newcss/fontsize.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/newcss/reset.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/newcss/swiper.min.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/newcss/sub.css"/>
		<script src="${root}/newjs/jquery1.11.1.min.js"></script>
		<script src="${root}/newjs/swiper.min.js"></script>
		<script src="${root}/newjs/common.js"></script>
			
		<script type="text/javascript" charset="utf-8" src="${root}/js/Ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${root}/js/Ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${root}/js/Ueditor/lang/zh-cn/zh-cn.js"></script>
<style>
    .layui-form-select dl { max-height:200px;}
</style>
</head>
<body onload="load();">
		<div class="header">
			<div class="head">
				<img src="${root}/newimg/logo.png" />
			</div>
		</div>
		<form action="${root}/vote/publish" name="voteForm" id="frm" class="layui-form"> 
		<div class="sub_main">
			<div class="sub_banner">
				<img src="${root}/newimg/sub_logo.png" />
			</div>
			<div class="sub_input">
			<input type="text" name="activityName" id="activityName" placeholder="请输入标题" style="margin-top:30px;border: 1px solid #ddd;width:100%;height:40px;padding-left:15px;box-sizing:border-box;">
			<textarea name="activityDescribe" id="msg" cols="30" rows="10" placeholder="请输入活动规则" style="margin-top:5px;border: 1px solid #ddd;width:100%;padding-top:5px;padding-left:15px;box-sizing:border-box;"></textarea>
			<div style="width:100%;height:50px;"><select  id="schoolName" name="schoolName" >
									    <option value="全部校区" >全部校区</option>
									    <option value="东莞理工学院(松山湖)" >东莞理工学院(松山湖)</option>
									    <option value="东莞理工学院(莞城)" >东莞理工学院(莞城)</option>
									    <option value="广东医科大学(东莞)" >广东医科大学(东莞)</option>
									    <option value="广东创新科技职业学院" >广东创新科技职业学院</option>
									    <option value="东莞职业技术学院" >东莞职业技术学院</option>
									    <option value="广东科技学院" >广东科技学院</option>
									    <option value="中山大学新华学院" >中山大学新华学院</option>
									    <option value="广东酒店管理职业技术学院" >广东酒店管理职业技术学院</option>
									    
									</select></div>
			<div style="width:100%;"><select  id="candidateCount" name="candidateCount" >
									    <option value="9999999" >请选择参赛人数(默认不限制)</option>
				
			</select></div>									
			<span style="font-size:12px;color:#ddd;padding-left:10px">报名开始</span>
			<input type="text" class="layui-input" name="startTime" id="startTime" placeholder="选择时间">
			<span style="font-size:12px;color:#ddd;padding-left:10px">报名结束</span>
			<input type="text" class="layui-input" id="endTime"  name="endTime"  placeholder="选择时间">
			<span style="font-size:12px;color:#ddd;padding-left:10px">点赞开始</span>
			<input type="text" class="layui-input" name="startTime2" id="startTime2" placeholder="选择时间">
			<span style="font-size:12px;color:#ddd;padding-left:10px">点赞结束</span>
			<input type="text" class="layui-input" id="endTime2"  name="endTime2"  placeholder="选择时间">
			<span style="font-size:12px;color:#ddd;padding-left:10px">排序方式</span>
			<div style="width:100%;">
				<select  id="sortMode" name="sortMode">
					<option value="1" >参与时间倒序</option>
					<option value="2" >按票数从高到低 </option>
					<option value="3" >编号从低到高</option>
				</select>
			</div>
			<span style="font-size:12px;color:#ddd;padding-left:10px">点赞方式</span>
			<div style="width:100%;">
				<select  id="voteMode" name="voteMode" lay-filter="test02">
					<option value="1" >固定次数(每个微信号可投票次数)</option>
					<option value="2" >周期次数(每个微信号每天可投票次数)</option>
				</select>
			</div>
			<span style="font-size:12px;color:#ddd;padding-left:10px">点赞次数</span>
			<input type="text" name="limitNumber" id="limitNumber" Placeholder="请输入1~99999的整数" value="1" style="border: 1px solid #ddd;width:100%;height:40px;padding-left:15px;box-sizing:border-box;">
			<span style="font-size:12px;color:#ddd;padding-left:10px">开启限定点赞后将不能给同一选手重复投票</span>
			<div style="width:100%;">
				<select  id="limitMode" name="limitMode">
					<option value="1" >限定点赞开启</option>
					<option value="2" selected>限定点赞关闭 </option>
				</select>
			</div>
			<span style="font-size:12px;color:#ddd;padding-left:10px">开启平台</span>
			<div style="width:100%;">
				<select  id="voteMode2" name="voteMode2">
					<option value="1" selected>公众号回复</option>
					<option value="2" >网站点赞</option>
				</select>
			</div>
			<span style="font-size:12px;color:#ddd;padding-left:10px">上传海报：（1-3张）</span>
				<ul class="upload-ul clearfix">
					<li class="upload-pick">
					<div class="webuploader-container clearfix" id="goodsUpload"></div>
					</li>
					</ul>
					
					

					<div class="btnMore t-c"   id="ctlBtn" style="display:none;">上传图片</div>
					<div class="layui-btn layui-btn-radius layui-btn-warm"  id="clickme" style="margin-top:25px;margin-left:20%;width:60%">立刻发布</div>
			</div>
			<div id="voteFormDiv" name="voteFormDiv"></div>
		</div>
		</form>
		
		<div class="footer">
			<ul class="flex">
				<li><a href="lobby.html">
					<div class="foot">
						<div class="ft_tt center">
							<p class="fs-22">点赞大厅</p>
						</div>
					</div>
				</a></li>
				<li><a href="lobby_2.html">
					<div class="foot">
						<div class="ft_tt ft_tt2 center">
							<p class="fs-22">发起点赞</p>
						</div>
					</div>
				</a></li>
				<li><a href="lobby_4.html">
					<div class="foot">
						<div class="ft_tt ft_tt3 center">
							<p class="fs-22">我的主页</p>
						</div>
					</div>
				</a></li>
			</ul>
		</div>

		<script type="text/javascript" src="${root}/js/layer/layer.js"></script>
		<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
		<script src="${root}/js/webuploader.min.js"></script>
		<script src="${root}/js/diyUpload.js"></script>
		<script>
			$(function(){
				var count=0;
				var count2=0;
			    $("#clickme").click(function(){
			    	count2=$(".diyUploadHover").length;
			    	if(btnclick()){	
			    		
			    		$('#ctlBtn').trigger("click");  
			    		
			    	}
			    });
				//上传图片
				var $tgaUpload = $('#goodsUpload').diyUpload({
					url:'${root}/vote/saveImage',
					success:function(data) {
						console.log(data);
						var str="<input type='hidden' name='picture' id='picture02' value="+data+">";
						$('#voteFormDiv').append(str);
						count++;
						if(count2==count){
										    		
								$("#frm").submit();
						}
						console.log(count2);
						console.log(count);
					},
					error:function( err ) { },
					buttonText : '',
					accept: {
						title: "Images",
						extensions: 'gif,jpg,jpeg,bmp,png'
					},
					thumb:{
						width:120,
						height:120,
						quality:100,
						allowMagnify:true,
						crop:true,
						type:"image/jpeg"
					},
					fileNumLimit:3
				});
			});
		</script>
		<script>
		function btnclick(){
			var activityName = $("#activityName").val();
			var limitNumber = $("#limitNumber").val();
			var candidateCount=$("#candidateCount").val();
			if(flag10){
				var editorBox=document.getElementById(editor);
	 			
					if(UE.getEditor('editor').hasContents()){
						$("#activityDescribe").val(UE.getEditor('editor').getContent()); 
					}
				
			}
	
			if(!activityName){
				layer.msg('请输入活动标题');
				return false;
			}
/* 			if(editorBox!=null){
				if(!UE.getEditor('editor').hasContents()){
					layer.msg('请输入活动概述和规则');
					return false;
				}
			} */

			if(!limitNumber){
				layer.msg('请输入投票次数');
				return false;
			}
			if(!(/^[1-9]\d{0,4}$/.test(limitNumber))){
				layer.msg('投票次数请输入1~99999的整数');
				return false;
			}
			
				if($(".diyUploadHover").length==0){
					layer.msg('请上传图片');
					return false;
				}
			
			
			/* $("#uppic")[0].reset(); */
			$(".diyUploadHover").remove(); 
			layer.msg('成功提示');
			return true;
			// 
		}
		</script>
		
		<script>    $(document).ready(function () {
			var time = new Date();
			var second=("0"+time.getSeconds()).slice(-2);
			var minute=("0"+time.getMinutes()).slice(-2);
			var hour=("0"+time.getHours()).slice(-2);
			var day = ("0" + time.getDate()).slice(-2);
			var day2 = ("0" + (time.getDate()+1)).slice(-2);
			var month = ("0" + (time.getMonth() + 1)).slice(-2);
			var today = time.getFullYear() + "-" + (month) + "-" + (day)+" "+(hour)+":"+(minute)+":"+(second);
			var nextDay =time.getFullYear() + "-" + (month) + "-" + (day2)+" "+(hour)+":"+(minute)+":"+(second);
			$('#startTime').val(today);
			$('#endTime').val(nextDay);
			$('#startTime2').val(today);
			$('#endTime2').val(nextDay);})
		</script>
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
		  	  elem: '#endTime' ,type: 'datetime'
		  	});
		    laydate.render({
			  	  elem: '#startTime' ,type: 'datetime'
			});
		    laydate.render({
			  	  elem: '#endTime2' ,type: 'datetime'
			});
			laydate.render({
				  elem: '#startTime2' ,type: 'datetime'
		    });
			var str2=""
			for(var i=1;i<5000;i++){
				str2+="<option value='"+i+"' >参赛人数："+i+"人</option>"
			}
			$("#candidateCount").append(str2);
			form.render();
			
			form.on('select(test02)', function(data){								
				var select = data.value;//得到被选中的值
				var number = document.getElementById("limitNumber");				
		             if(select.value==1){
		            	 if(number.value!=""){
		            		 layer.msg('每个微信号可投票'+number.value+'次');
		            	 }
		             }else{
		            	 if(number.value!=""){
		            		 layer.msg('每个微信号每天可投票'+number.value+'次');
		            	 }
		             }
			});
		  })  
	
	  </script>

	  <script>
		 var flag10= true;
			function load(){
				var u = navigator.userAgent;
				if (is_weixin() && u.indexOf('Android') > -1) {//安卓手机
					$("#activityDescribeChooseBox").empty();
					$("#activityDescribeChooseBox").append("<textarea name='activityDescribe' id='msg' cols='30' rows='10' placeholder='请输入活动规则'>");
					flag10=false;
				} else if(is_weixin() && u.indexOf('Linux') > -1){//安卓手机
					$("#activityDescribeChooseBox").empty();
					$("#activityDescribeChooseBox").append("<textarea name='activityDescribe' id='msg' cols='30' rows='10' placeholder='请输入活动规则'>");
					flag10=false;
				}else if(is_weixin() && u.indexOf('iPhone') > -1){//苹果手机
					$("#activityDescribeChooseBox").empty();
					$("#activityDescribeChooseBox").append("<textarea name='activityDescribe' id='msg' cols='30' rows='10' placeholder='请输入活动规则'>");
					flag10=false;
				}else if (u.indexOf('Windows Phone') > -1) {//winphone手机
					var ue = UE.getEditor('editor',{initialFrameWidth:"100%"});
				}else{
					var ue = UE.getEditor('editor',{initialFrameWidth:"100%"});
				}			
			}
			function is_weixin() {
				   var ua = navigator.userAgent.toLowerCase();
				   if (ua.match(/MicroMessenger/i) == "micromessenger") {
				      return true;
				   } else {
				      return false;
				   }
			}
			function getCookie(c_name){
				if(document.cookie.length>0){
					c_start = document.cookie.indexOf(c_name+'=');
					if(c_start != 1){
						c_start = c_start + c_name.length+1;
						c_end = document.cookie.indexOf(";", c_start);
						if(c_end == -1){
							c_end = document.cookie.length;
						}
						return unescape(document.cookie.substring(c_start, c_end));
					}
				}
				return "";
			}
		 </script>
</body>
</html>