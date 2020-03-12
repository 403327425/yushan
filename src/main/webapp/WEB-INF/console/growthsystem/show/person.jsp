<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/GrowthSystemInclude.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>个人页</title>
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  		<script type="text/javascript" src="${root}/js/md5.js"></script>
  		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<link rel="stylesheet" type="text/css" href="${root}/GS/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/GS/css/fontsize.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/GS/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/GS/css/swiper.min.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/GS/css/sub.css"/>
		<script src="${root}/GS/js/jquery1.11.1.min.js"></script>
		<script src="${root}/GS/js/swiper.min.js"></script>
		<script src="${root}/GS/js/leftTime.min.js"></script>
		<script src="${root}/GS/js/common.js"></script>
		
		<script src=https://res2.wx.qq.com/open/js/jweixin-1.4.0.js></script>
		<script src="${root}/GS/js/wxSign.js"></script>
		
		<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
		<script type="text/javascript" src="${root}/js/layer.js"></script>
		<script type="text/javascript" src="${root}/js/globe.js"></script>
		<title></title>
	</head>
	<body>
		<div class="header">
			<div class="head clearfloat">
				<img src="${root}/GS/img/logo.png" />
			</div>
		</div>
		
		
		<div class="main">
			
			<div class="user" id="userBox">
				<img src="" />
				<p class="center fs-30 bold"></p>
			</div>
			<div class="sub6_main">
				<div class="sub6_bg">
					<div class="sub6_tt">
						<ul class="flex">
							<li>
								<div class="sub6_inbox">
									<p class="fs-30 bold" id="scoreBox">0</p>
									<p class="c33 fs-17">成长值</p>
								</div>
							</li>
							<li>
								<div class="sub6_inbox">
									<p class="fs-30 bold" id="state5Box">0</p>
									<p class="c33 fs-17">已完成任务</p>
								</div>
							</li>
							<li>
								<div class="sub6_inbox">
									<p class="fs-30 bold" id="state2Box">0</p>
									<p class="c33 fs-17">审核中任务</p>
								</div>
							</li>
							<li>
								<div class="sub6_inbox">
									<p class="fs-30 bold" id="state1Box">0</p>
									<p class="c33 fs-17">未打卡任务</p>
								</div>
							</li>

						</ul>
						<div class="sub4_list sub6_list">
							<ul>
								<li>成长值兑换商城</li>
								<li>联系客服</li>
								<div class="list_drop3">
									<img class="block" src="${root}/GS/img/list_drop3.png" />
								</div>
							</ul>
						</div>
					</div>
<!-- 					<div class="sub6_like">
						<button type="button">退出登录</button>
					</div> -->
				</div>
			</div>
		</div>
		<script>
			$(document).ready(function(){
				$(".sub6_list ul li").click(function(){
					$(this).toggleClass("on").siblings().removeClass("on");
					$(this).next(".list_drop3").slideToggle(300);
				})
				$(".sub6_list ul li").eq(0).click(function(){
					layer.msg("尚未开放，敬请期待");
				})
			})
		</script>
		
		
		<div class="footer">
			<ul class="flex">
				<li><a href="${root}/personGrowth/newMainWeb">
					<div class="foot">
						<div class="ft_tt center">
							<p class="fs-14">大厅</p>
						</div>
					</div>
				</a></li>
				<li><a href="${root}/personGrowth/myTaskWeb">
					<div class="foot">
						<div class="ft_tt ft_tt2 center">
							<p class="fs-14">清单</p>
						</div>
					</div>
				</a></li>
				<li><a href="${root}/personGrowth/personWeb">
					<div class="foot foot_3">
						<div class="ft_tt ft_tt3 center">
							<p class="fs-14">我的</p>
						</div>
					</div>
				</a></li>
			</ul>
		</div>
	</body>
		<script>
		var openid=getCookie("openid");
		window.onload = function(){
				getMyInfo();
				GetSige("不遗憾清单","个人中心");
			}
			function getMyInfo(){
				$.ajax({
					 url:'${root}/wxInterface/getMeWxData?openid='+openid,
					 type:"get",
					 dataType : "json",
					 success:function(res){
						 console.log(res);
						 str="<img src="+res.reservedFields+" /><p class='center fs-30 bold'>"+res.userName+"</p>"
						 $('#userBox').empty();
						 $('#userBox').append(str);
					 }
				 });
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
			
			
			var getAllFunction=function(){
				$.ajax({
					 url:'${root}/personGrowth/showAllEvent?openid='+openid,
					 type:"get",
					 dataType : "json",
					 success:function(res){
						 console.log(res);
						 $('#scoreBox').empty();
						 $('#scoreBox').append(res.score);
						 $('#state1Box').empty();
						 $('#state2Box').empty();
						 $('#state5Box').empty();
						 $('#state1Box').append(res.Msg.state1);
						 $('#state2Box').append(res.Msg.state2);
						 $('#state5Box').append(res.Msg.state5);
					 }
				});
			}
			getAllFunction();
		</script>
		<script>
layui.use(['element','jquery','layer','slider','table','form'], function(){
	var $ = layui.$ 
	  ,layer = layui.layer
	  ,table = layui.table
	  ,form =layui.form;
});
</script>

</html>
