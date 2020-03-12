<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>投票活动</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>

<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="http://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css">
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>


<script type="text/javascript" charset="utf-8" src="${root}/js/Ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${root}/js/Ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${root}/js/Ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body  onload="load();">
	<div class="warp">
		<div class="main smain">
<form action="${root}/vote/publish" name="voteForm"> 
			<div class="ind_gz">
				<div class="tt_com bg-cm c-fff">
					<svg class="icon icon2" viewBox="0 0 1024 1024" width="100%" height="100%">
						<path d="M51.2 310.857143L625.371429 21.942857 987.428571 676.571429l-599.771428 314.514285z" fill="#FFFFFF">
						</path>
						<path d="M548.022857 178.468571c-16.274286 8.265143-39.204571 3.547429-47.542857-12.763428l-46.445714-91.245714c-8.338286-16.274286-1.938286-35.949714 17.627428-45.933715 16.274286-8.301714 39.204571-3.547429 47.542857 12.726857l46.445715 91.245715c5.083429 17.956571-1.316571 37.668571-17.627429 45.933714zM231.936 339.456c-16.274286 8.301714-39.204571 3.547429-47.542857-12.726857L137.984 235.52c-8.301714-16.274286-1.938286-35.949714 17.627429-45.933714 16.310857-8.301714 39.241143-3.547429 47.542857 12.726857l46.445714 91.245714c5.083429 17.92-1.316571 37.632-17.627429 45.933714z m504.685714 337.993143a17.664 17.664 0 0 1-22.784 11.629714l-98.377143-31.963428a17.664 17.664 0 0 1-11.629714-22.820572 17.664 17.664 0 0 1 22.820572-11.629714l98.377142 31.963428c11.483429 6.473143 16.457143 16.237714 11.593143 22.820572z" fill="#F39826"></path><path d="M713.837714 689.115429a17.664 17.664 0 0 0 22.784-11.629715l52.772572-162.304a17.664 17.664 0 0 0-11.629715-22.820571 17.664 17.664 0 0 0-22.820571 11.629714l-52.736 162.304c-1.536 13.092571 3.437714 22.893714 11.629714 22.820572zM650.349714 298.678857L265.837714 494.592c-9.764571 5.010286-19.602286 1.828571-24.576-7.972571-5.010286-9.764571-1.828571-19.602286 7.972572-24.612572L633.782857 266.093714c9.764571-4.973714 19.602286-1.755429 24.576 8.009143 5.010286 9.764571 1.828571 19.602286-7.972571 24.576z m74.715429 146.651429L340.553143 641.243429c-9.764571 4.973714-19.602286 1.792-24.576-8.009143-5.010286-9.764571-1.828571-19.602286 7.972571-24.576l384.512-195.913143c9.764571-4.973714 19.602286-1.792 24.576 7.972571 5.010286 9.801143 1.828571 19.638857-7.972571 24.612572z m-169.691429 271.140571l-140.105143 71.387429c-9.764571 5.010286-19.602286 1.828571-24.612571-7.972572-4.973714-9.764571-1.755429-19.602286 8.009143-24.612571l140.105143-71.387429c9.801143-4.973714 19.638857-1.755429 24.612571 8.009143s-1.462857 21.284571-8.009143 24.576zM290.304 268.726857l162.925714-83.017143-31.561143-61.915428-162.925714 83.017143z" fill="#F39826"></path><path d="M626.980571 19.2l-48.896 24.868571 31.561143 61.952 19.529143-9.984c16.310857-8.301714 39.241143-3.547429 47.542857 12.726858l258.998857 508.342857c8.301714 16.274286 1.901714 35.949714-17.627428 45.933714l-511.634286 260.644571c-16.274286 8.301714-39.204571 3.584-47.506286-12.726857l-258.998857-508.342857c-8.301714-16.274286-1.901714-35.949714 17.627429-45.897143l19.565714-9.984-31.561143-61.915428-48.859428 24.905143C20.845714 328.045714 4.827429 369.005714 23.04 404.845714l290.56 570.258286c16.603429 32.585143 60.891429 46.957714 93.476571 30.354286l573.513143-292.205715c32.548571-16.603429 46.957714-60.854857 30.354286-93.44L720.420571 49.554286c-18.285714-35.84-57.6-48.64-93.44-30.354286z" fill="#F39826">
						</path>
					</svg>发表投票活动</div>
				<div class="bg-fff baoming" id="voteFormDiv">
				
					<table>
						<tbody>
							<tr>
								<td>标题</td>
								<td><input type="text" name="activityName" id="activityName"></td>
							</tr>
							<tr>
								<td>描述</td>
								<td></td>
								<!-- <td><textarea name="activityDescribe" id="activityDescribe" cols="30" rows="10"></textarea></td> -->
								
							</tr>
							<tr>
								
								<td colspan="2" id="activityDescribeChooseBox"><script id="editor" type="text/plain" style="width:100%;height:auto;"></script><input type="hidden" name="activityDescribe" id="activityDescribe"></td>
								<!-- <td><textarea name="activityDescribe" id="activityDescribe" cols="30" rows="10"></textarea></td> -->
								
							</tr>
							
							<tr>
								<td>开始时间</td>
								<td><input  type="date" name="startTime" id="startTime" ></td>
							</tr>
							<tr>
								<td>结束时间</td>
								<td><input  type="date" name="endTime" id="endTime" ></td>
							</tr>
							<tr>
								<td>排序方式</td>
								<td>									
									<select  id="sortMode" name="sortMode">
									    <option value="1" >参与时间倒序</option>
									    <option value="2" >按票数从高到低 </option>
									    <option value="3" >编号从低到高</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>投票方式</td>
								<td>									
									<select  id="voteMode" name="voteMode">
									    <option value="1" >固定次数(每个微信号可投票次数)</option>
									    <option value="2" >周期次数(每个微信号每天可投票次数)</option>
									</select>
								</td>
								
							</tr>
							<tr>
								<td>投票次数</td><td><input type="text" name="limitNumber" id="limitNumber" Placeholder="请输入1~100的整数" value="1"></td>
							</tr>
							<tr>
								<td>限定投票</td>
								<td>									
									<select  id="limitMode" name="limitMode">
									    <option value="1" >开启</option>
									    <option value="2" >关闭 </option>
									</select>
								</td>
							</tr>
							<tr>
								<td>投票结果</td>
								<td>									
									<select  id="resultMode" name="resultMode">
									    <option value="1" >显示</option>
									    <option value="2" >关闭 </option>
									</select>
								</td>
							</tr>
							<tr>
								<td>显示方式</td>
								<td>									
									<select  id="showMode" name="showMode">
									    <option value="1" >双排显示</option>
									    <option value="2" >单排显示 </option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="c-999">上传图片（1-3张）</div>
					<ul class="upload-ul clearfix">
					<li class="upload-pick">
					<div class="webuploader-container clearfix" id="goodsUpload"></div>
					</li>
					</ul>

					<div class="btnMore t-c"><input id="ctlBtn" type="button" value="上传图片" class="tt_com bg-cm c-fff"></div>
					<div class="btnMore t-c" ><input type="submit" value="立刻发布" class="tt_com bg-cm c-fff" onclick="return btnclick()"></div>
					
				</div>
			</div>
			</form>
			<script type="text/javascript" src="${root}/js/layer/layer.js"></script>
			<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
			<script src="${root}/js/webuploader.min.js"></script>
			<script src="${root}/js/diyUpload.js"></script>
			<script>
			$(function(){
				//上传图片
				var $tgaUpload = $('#goodsUpload').diyUpload({
					url:'${root}/vote/saveImage',
					success:function(data) {
						console.log(data);
						var str="<input type='hidden' name='picture' id='picture02' value="+data+">";
						$('#voteFormDiv').append(str);
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
		
		<script>    $(document).ready(function () {
			var time = new Date();
			var day = ("0" + time.getDate()).slice(-2);
			var day2 = ("0" + (time.getDate()+1)).slice(-2);
			var month = ("0" + (time.getMonth() + 1)).slice(-2);
			var today = time.getFullYear() + "-" + (month) + "-" + (day);
			var nextDay =time.getFullYear() + "-" + (month) + "-" + (day2);
			$('#startTime').val(today);
			$('#endTime').val(nextDay);    })
		</script>
		<script>
		function btnclick(){
			var activityName = $("#activityName").val();
			var limitNumber = $("#limitNumber").val();
			var editorBox=document.getElementById(editor);
			if(editorBox!=null){
				if(UE.getEditor('editor').hasContents()){
					$("#activityDescribe").val(UE.getEditor('editor').getContent()); 
				}
			}
			
			
			
			if(!activityName){
				layer.msg('请输入活动标题');
				return false;
			}
			if(editorBox!=null){
				if(!UE.getEditor('editor').hasContents()){
					layer.msg('请输入活动概述和规则');
					return false;
				}
			}
			
			if(!limitNumber){
				layer.msg('请输入投票次数');
				return false;
			}
			if(!(/^([1-9]|[1-9]\\d|100)$/.test(limitNumber))){
				layer.msg('投票次数请输入1~100');
				return false;
			}
			if(!document.getElementById("picture02")){
				layer.msg('请点击确定上传图片');
				return false;
				if($(".diyUploadHover").length==0){
					layer.msg('请上传图片');
					return false;
				}
			}
			/* $("#uppic")[0].reset(); */
			$(".diyUploadHover").remove();
			layer.msg('成功提示');
			return true;
			// 
		}
		</script>
		<script>
		 var select = document.getElementById("voteMode");
		 var number = document.getElementById("limitNumber");
		 select.onchange=function(){
             if(select.value==1){
            	 if(number.value!=""){
            		 layer.msg('每个微信号可投票'+number.value+'次');
            	 }
             }else{
            	 if(number.value!=""){
            		 layer.msg('每个微信号每天可投票'+number.value+'次');
            	 }
             }
         }; 
		</script>

		 
		 <script>
		 	
		 	

		 </script>
		 <script>
			function load(){
				var u = navigator.userAgent;
				if (is_weixin() && u.indexOf('Android') > -1) {//安卓手机
					
					var ue = UE.getEditor('editor',{initialFrameWidth:320,initialFrameHeight:400});
				} else if(is_weixin() && u.indexOf('Linux') > -1){//安卓手机
					
					var ue = UE.getEditor('editor',{initialFrameWidth:320,initialFrameHeight:400});
				}else if(is_weixin() && u.indexOf('iPhone') > -1){//苹果手机
					
					$("#activityDescribeChooseBox").empty();
					$("#activityDescribeChooseBox").append("<textarea name='activityDescribe' id='msg' cols='30' rows='10'>");
				}else if (u.indexOf('Windows Phone') > -1) {//winphone手机
					
					var ue = UE.getEditor('editor',{initialFrameWidth:"100%",initialFrameHeight:400});
				}else{
					var ue = UE.getEditor('editor',{initialFrameWidth:"100%",initialFrameHeight:400});
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
			
			
		 </script>
		 </div>
		</div>
</body>
</html>