<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/GrowthSystemInclude.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>选修列表</title>
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
		<link rel="stylesheet" type="text/css" href="${root}/GS/css/lobby.css"/>
		<script src="${root}/GS/js/jquery1.11.1.min.js"></script>
		<script src="${root}/GS/js/swiper.min.js"></script>
		<script src="${root}/GS/js/common.js"></script>
		<script src="${root}/GS/js/leftTime.min.js"></script>
		
		
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
				<div class="sh fr"><img src="${root}/GS/img/sh.png" /></div>
			</div>
		</div>
		<script>
			$(document).ready(function(){
				$(".header .head .sh").click(function(){
					/* $(".sh_click").fadeIn(400); */
					layer.msg("敬请期待")
				})
				$(".main").click(function(){
					$(".sh_click").fadeOut(400);
				})
			})
		</script>
		
		<div class="main">
			<div class="sh_click">
				<div class="shclick_tt flex">
					<input class="int1" type="text" placeholder="请输入内容" />
					 <div class="sh_img"><img src="${root}/GS/img/sh.png" ></div>
					
				</div>
			</div>
			<div class="banner_bg">
				<div class="banner swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide"><img src="${root}/GS/img/banner.jpeg" /></div>
						<div class="swiper-slide"><img src="${root}/GS/img/banner.jpeg" /></div>
						<div class="swiper-slide"><img src="${root}/GS/img/banner.jpeg" /></div>
					</div>
					<div class="banner_pag swiper-pagination">
						<span class="swiper-pagination-bullet"></span>
						<span class="swiper-pagination-bullet"></span>
						<span class="swiper-pagination-bullet"></span>
					</div>
				</div>
			</div>
			<div class="ma_nav">
				<ul>
					<li><a class="lobby_xuanxiu" href="${root}/personGrowth/mainWeb">必修</a></li>
					<li><a class="lobby" href="${root}/personGrowth/electiveWeb">选修</a></li>
				</ul>
			</div>
			
			
			
			
			<div class="main_a">
				<div class="ma_list ma_list1">
					<ul class="flex" id="electiveListBox">
						<li>
							<div class="malist_inbox malist_inbox1 flex">
								<div class="inbox_img inbox_img1 inbox_img3">
									<img src="${root}/GS/img/banner.jpeg" />
								</div>
								<div class="inbox_tt inbox_tt1 flex">
									<div class="inboxtt_l inboxtt_l1">
										<p class="fs-27">参加一次夜跑</p>
										<div class="fs-17 pdt-1 flex tt1 tt2">
											<div class="time c-42 bold">剩余<span class="d"></span>天</div>
											<div class="c-42 bold">成长值:<span class="c-239 normal">+250</span></div>
										</div>
									</div>
									<div class="inbox_button inbox_button1">
										<button class="button">领取</button>
										<button class="button_already">已领取</button>
									</div>
								</div>
								<div class="inboxtt_click fs-17 c-42 bold">在夜跑过程中拍摄一张自拍照，上传至后台系统。</div>
							</div>
						</li>
						
						
					</ul>
				</div>
			</div>
		</div>
		<script>
			
			// 倒计时
			$(function(){
				//日期倒计时
				$.leftTime("2019-09-30 11:36:10",function(d){
						if(d.status){
							var $dateShow=$(".time");
							$dateShow.find(".d").html(d.d);
						}else{
							$("#dateShow .dateShowcm").html("<span class='span'>活动已结束</span>");
						}
					});
				});
		</script>
		
		
		
		<div class="footer">
			<ul class="flex">
				<li><a href="${root}/personGrowth/newMainWeb">
					<div class="foot foot_1">
						<div class="ft_tt center">
							<p class="fs-14">首页</p>
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
					<div class="foot">
						<div class="ft_tt ft_tt3 center">
							<p class="fs-14">我的</p>
						</div>
					</div>
				</a></li>
			</ul>
		</div>
		<script>
			$(document).ready(function(){
				var swiper = new Swiper('.banner', {
				    slidesPerView: 1,
					spaceBetween: 20,
					loop: true,
					pagination: {
						el: '.banner_pag',
						clickable: true,
					},
				});
			})
		</script>
				<script>
		var openid=getCookie("openid");
		var map=new Map();
		var getImage=function(){
			$.ajax({
				 url:'${root}/personGrowth/showPlanListEvent',
				 type:"get",
				 dataType : "json",
				 async: false,
				 success:function(res){
					for(var i=0;i<res.length;i++){
						map.set(res[i].taskTypeId,res[i].reservedFields);
					} 
					console.log(map);
				 }
			});
		}
		window.onload = function(){
				getImage();
				showTask();
				GetSige("不遗憾清单","选修列表");
			}
			function showTask(){
				$.ajax({
					 url:'${root}/personGrowth/showTaskListEvent?taskTypeId=1&openid='+openid,
					 type:"get",
					 dataType : "json",
					 success:function(res){
						 console.log(res);
						 var str=""
						 for(var i=0;i<res.length;i++){

								str+="<li>"+
											"<div class='malist_inbox malist_inbox1 flex'>"+
											"<div class='inbox_img inbox_img1 inbox_img3'>"+
												"<img src='${root}/upload/"+map.get(res[i].taskTypeId)+"' />"+
											"</div>"+
											"<div class='inbox_tt inbox_tt1 flex'>"+
												"<div class='inboxtt_l inboxtt_l1'>"+
													"<p class='fs-27'>"+res[i].taskName+"</p>"+
													"<div class='fs-17 pdt-1 flex tt1 tt2'>"+
														"<div class='time c-42 bold'>剩余<span class='d'>"+res[i].duration+"</span>天</div>"+
														"<div class='c-42 bold'>成长值:<span class='c-239 normal'>"+res[i].score+"</span></div>"+
													"</div>"+
												"</div>"+
												"<div class='inbox_button inbox_button1'>";
												if(res[i].state==-1){
													str+="<button class='button' onclick='addPerformClick("+res[i].taskId+")'>领取</button>"+
													"<button class='button_already'>已领取</button>";
												}else if(res[i].state==6){
													str+="<button class='button' onclick='addPerformClick("+res[i].taskId+")'>领取</button>"+
													"<button class='button_already on'>未解锁</button>";
												}else if(res[i].state==5){
													str+="<button class='button' onclick='addPerformClick("+res[i].taskId+")'>领取</button>"+
													"<button class='button_already on'>已完成</button>";
												}else{
													str+="<button class='button' onclick='addPerformClick("+res[i].taskId+")'>领取</button>"+
													"<button class='button_already on'>已领取</button>";
												}
												str+="</div>"+
											"</div>"+
											"<div class='inboxtt_click fs-17 c-42 bold'>"+res[i].taskText+"</div>"+
										"</div>"+
									"</li>"								
						 }
						 $('#electiveListBox').empty();
						 $('#electiveListBox').append(str);
						 $(document).ready(function(){
								$(".main_a .ma_list1 ul li").click(function(){
									$(this).addClass("on").siblings().removeClass("on");
									$(this).find(".inboxtt_click").eq($(this).parents("li").index()).slideToggle(300);
								})
								$(".inbox_button1 .button").click(function(){
									$(this).next().addClass("on").eq("li").removeClass("on");
								})
							})
						 
					 }
				 });
			}
			function addPerformClick(taskId){
				$.ajax({
					 url:'${root}/personGrowth/addPerformListEvent?taskId='+taskId+'&openid='+openid,
					 type:"get",
					 dataType : "json",
					 success:function(res){
						 console.log(res);
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
			
		</script>

<script>
layui.use(['element','jquery','layer','slider','table','form'], function(){
	var $ = layui.$ 
	  ,layer = layui.layer
	  ,table = layui.table
	  ,form =layui.form;
});
</script>
	</body>
</html>
