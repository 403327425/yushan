<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>报名</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="http://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css">
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>

<script>
function load(){
/* 	if("${param.activityId}"==""){
		
		window.location.href="${root}/vote/activityListWeb";
	}else{
		layer.msg("${param.activityId}");
		var str="<input type='hidden' id='activityId' name='activityId'  value="+${param.activityId}+">";
		
		$('#voteFormDiv').append(str); 
		
		$.ajax( {			
			url : '${root}/wxInterface/wxCode',
			type : 'POST',
			datatype : 'TEXT',
			data : {				
				temp :"${param.activityId}"			
			},
			cache : false,
			timeout : 1000,
			async : false,			
			error: function(){ //失败 			
			},			
			success : function(data) {
				console.log(data);
				
				$('#wxBox').append("<input type='button' name='btn1' id='btn1' value='微信登录'  onclick='location.href="+data+"' />"); 

			}		
		});
		
	}
	if("${param.openid}"==""){
		
		$('#btn1').click();
	}else{
		
		var openid="${param.openid}";
		
		var str="<input type='hidden' id='openid' name='openid'  value="+openid+">";
		$('#voteFormDiv').append(str); 
		layer.msg(openid);
		$("#wxBox").hide();
	} */
	if("${param.activityId}"==""){
		
		window.location.href="${root}/vote/activityListWeb";
	}else{
/* 		if("${openid}"==null||"${openid}"==""){
			console.log("988886");
			getOpenId();
		}else{
			console.log("${openid}");
			console.log("9777777");
			
			var openid="${openid}";
			
			var str="<input type='hidden' id='openid' name='openid'  value="+openid+">";
			$('#voteFormDiv').append(str); 
		} */
		var openid=getCookie("openid");
		var str="<input type='hidden' id='openid' name='openid'  value="+openid+">";
		str+="<input type='hidden' id='activityId' name='activityId'  value="+${param.activityId}+">";
		
		$('#voteFormDiv').append(str);
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
</head>
<body onload="load();">
	<div class="warp">
		<div class="main smain">
		<form action="${root}/vote/signUp" name="voteForm" id="frm"> 
			<div class="ind_gz">
				<div class="tt_com bg-gray c-fff"><svg class="icon icon2" viewBox="0 0 1024 1024" width="100%" height="100%"><path d="M51.2 310.857143L625.371429 21.942857 987.428571 676.571429l-599.771428 314.514285z" fill="#FFFFFF"></path><path d="M548.022857 178.468571c-16.274286 8.265143-39.204571 3.547429-47.542857-12.763428l-46.445714-91.245714c-8.338286-16.274286-1.938286-35.949714 17.627428-45.933715 16.274286-8.301714 39.204571-3.547429 47.542857 12.726857l46.445715 91.245715c5.083429 17.956571-1.316571 37.668571-17.627429 45.933714zM231.936 339.456c-16.274286 8.301714-39.204571 3.547429-47.542857-12.726857L137.984 235.52c-8.301714-16.274286-1.938286-35.949714 17.627429-45.933714 16.310857-8.301714 39.241143-3.547429 47.542857 12.726857l46.445714 91.245714c5.083429 17.92-1.316571 37.632-17.627429 45.933714z m504.685714 337.993143a17.664 17.664 0 0 1-22.784 11.629714l-98.377143-31.963428a17.664 17.664 0 0 1-11.629714-22.820572 17.664 17.664 0 0 1 22.820572-11.629714l98.377142 31.963428c11.483429 6.473143 16.457143 16.237714 11.593143 22.820572z" fill="#F39826"></path><path d="M713.837714 689.115429a17.664 17.664 0 0 0 22.784-11.629715l52.772572-162.304a17.664 17.664 0 0 0-11.629715-22.820571 17.664 17.664 0 0 0-22.820571 11.629714l-52.736 162.304c-1.536 13.092571 3.437714 22.893714 11.629714 22.820572zM650.349714 298.678857L265.837714 494.592c-9.764571 5.010286-19.602286 1.828571-24.576-7.972571-5.010286-9.764571-1.828571-19.602286 7.972572-24.612572L633.782857 266.093714c9.764571-4.973714 19.602286-1.755429 24.576 8.009143 5.010286 9.764571 1.828571 19.602286-7.972571 24.576z m74.715429 146.651429L340.553143 641.243429c-9.764571 4.973714-19.602286 1.792-24.576-8.009143-5.010286-9.764571-1.828571-19.602286 7.972571-24.576l384.512-195.913143c9.764571-4.973714 19.602286-1.792 24.576 7.972571 5.010286 9.801143 1.828571 19.638857-7.972571 24.612572z m-169.691429 271.140571l-140.105143 71.387429c-9.764571 5.010286-19.602286 1.828571-24.612571-7.972572-4.973714-9.764571-1.755429-19.602286 8.009143-24.612571l140.105143-71.387429c9.801143-4.973714 19.638857-1.755429 24.612571 8.009143s-1.462857 21.284571-8.009143 24.576zM290.304 268.726857l162.925714-83.017143-31.561143-61.915428-162.925714 83.017143z" fill="#F39826"></path><path d="M626.980571 19.2l-48.896 24.868571 31.561143 61.952 19.529143-9.984c16.310857-8.301714 39.241143-3.547429 47.542857 12.726858l258.998857 508.342857c8.301714 16.274286 1.901714 35.949714-17.627428 45.933714l-511.634286 260.644571c-16.274286 8.301714-39.204571 3.584-47.506286-12.726857l-258.998857-508.342857c-8.301714-16.274286-1.901714-35.949714 17.627429-45.897143l19.565714-9.984-31.561143-61.915428-48.859428 24.905143C20.845714 328.045714 4.827429 369.005714 23.04 404.845714l290.56 570.258286c16.603429 32.585143 60.891429 46.957714 93.476571 30.354286l573.513143-292.205715c32.548571-16.603429 46.957714-60.854857 30.354286-93.44L720.420571 49.554286c-18.285714-35.84-57.6-48.64-93.44-30.354286z" fill="#F39826"></path></svg>我要报名</div>
				<div class="bg-fff baoming" id="voteFormDiv">
				
					<table>
						<tbody>
							<tr>
								<td>昵称</td>
								<td><input type="text" name="candidateName" id="name"></td>
							</tr>
							<tr>
								<td>描述</td>
								<td><textarea name="candidateDescribe" id="msg" cols="30" rows="10"></textarea></td>
							</tr>
							<tr>
								<td>手机</td>
								<td><input type="text" name="iphone" id="iphone" ></td>
							</tr>
							<!-- <tr>
								<td>活动</td>
								<td><input type="text" name="activityId"></td>
							</tr> -->
							<tr>
								<td>学校</td>
								<td><input type="text" name="address" id="addr"></td>
							</tr>
						</tbody>
					</table>
					<div class="c-999">上传图片（1-3张）</div>
					<ul class="upload-ul clearfix">
					<li class="upload-pick">
					<div class="webuploader-container clearfix" id="goodsUpload"></div>
					</li>
					</ul>
					<div class="btnMore t-c" id="ctlBtn" style="display:none;">上传图片</div>
					<div class="btnMore t-c" id="clickme">提交报名></div>
					<div class="btnMore t-c" id="wxBox"></div>
					
				</div>
			</div>
			</form> 
		</div>
		<script type="text/javascript" src="${root}/js/layer/layer.js"></script>
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
			
			
			var name = $("#name").val();
			var msg = $("#msg").val();
			var tel = $("#iphone").val();
			var addr = $("#addr").val();
			var activityId=$("#activityId").val();
			/* var openid=$("#openid").val();
			if(!openid){
				layer.msg('请使用微信登录后报名');
				return false;
			}else{
				if(ajaxopenid()){
					return false;
				}
			} */
			if(!name){
				layer.msg('请输入您的姓名');
				return false;
			}
			if(!msg){
				layer.msg('请输入您的描述');
				return false;
			}
			if(!tel){
				layer.msg('请输入您的手机号码');
				return false;
			}else{
				if(!(/^1[3456789]\d{9}$/.test(tel))){ 
					layer.msg("请输入正确的手机号码");  
					return false; 
				}else{
					if(ajaxiphone()){
						return false; 
					};
				} 
			}
			if(!addr){
				layer.msg('请输入您的地址');
				return false;
			}
			
			
				if($(".diyUploadHover").length==0){
					layer.msg('请上传图片');
					return false;
				}
			

			// 
/* 			$("#uppic")[0].reset(); */
			$(".diyUploadHover").remove();
			layer.msg('成功提示');
			return true;
			// 
		}
			function ajaxopenid(){
				var activityId=$("#activityId").val();
				var openid=$("#openid").val();
				var flag;
				$.ajax( {			
					url : '${root}/vote/testOnly2',
							type : 'POST',
							datatype : 'TEXT',
							cache : false,
							timeout : 1000,
							async : false,		
							data : {				
								openid : openid,
								activityId:activityId
							},			
							error: function(){ //失败 			
							},			
							success : function(data) {
/* 								if(data.equal(FAIL)){
									alert("该手机已经被注册！");
								} */
								console.log(data);
								var str=data;
								console.log(str);
								var str2="\"该微信账号已经在本活动报名\"";
								if(str==str2){
									layer.msg('该微信账号已经在本活动报名');
									flag=true;
								}else{
									flag=false;
								}
							}		
				});
				return flag;
			}
			
		
			function ajaxiphone(){
				var iphone = $("#iphone").val();
				var activityId=$("#activityId").val();
				var flag;
				$.ajax( {			
					url : '${root}/vote/testOnly',
							type : 'POST',
							datatype : 'TEXT',
							cache : false,
							timeout : 1000,		
							async : false,		
							data : {				
								iphone : iphone,
								activityId:activityId			
							},			
							error: function(){ //失败 			
							},			
							success : function(data) {
/* 								if(data.equal(FAIL)){
									alert("该手机已经被注册！");
								} */
								console.log(data);
								var str=data;
								console.log(str);
								var str2="\"该手机已经被注册\"";
								if(str==str2){
									layer.msg('该手机已经被注册');
									
									flag=true;
								}else{
									
									flag=false;
								}
							}		
				});
				return flag;
			}
			
			function getOpenId(){
			var STATE= "redirect:/vote/signUpWeb2?activityId=${param.activityId}";
				//location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdfb0cebac2cd3ba7&redirect_uri=http%3A%2F%2Fwww.403327425.com%2FwxInterface%2FgetOpenidAndUrl&response_type=code&scope=snsapi_userinfo&state="+STATE+"#wechat_redirect";
				
			}
		</script>
		
		<div class="foot">
			<ul class="clearfloat">
				<li><a href="${root}/vote/voteIndex?activityId=${param.activityId}" class="on"><i class="iconfont icon-home-active"></i><p>首页</p></a></li>
				<li><a href="${root}/vote/voteRankingWeb?activityId=${param.activityId}"><i class="iconfont icon-paimingiconx"></i><p>排名</p></a></li>
				<li><a href="${root}/vote/voteRuleWeb?activityId=${param.activityId}"><i class="iconfont icon-guize2"></i><p>规则</p></a></li>
				
			</ul>
		</div>
		
	</div>
</body>
</html>