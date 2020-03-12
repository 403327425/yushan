<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/GrowthSystemInclude.jsp"%>
<!DOCTYPE html >
<html>
	<head>
	
		<meta charset="utf-8">
		<title>主页</title>
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  		<script type="text/javascript" src="${root}/js/md5.js"></script>

		<meta charset="utf-8">
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
		
  		<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
		<script type="text/javascript" src="${root}/js/layer.js"></script>
		<script type="text/javascript" src="${root}/js/globe.js"></script>
		
		<script src=https://res2.wx.qq.com/open/js/jweixin-1.4.0.js></script>
		<title></title>
	</head>
	<body >
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
		<div class="sh_click">
			<div class="shclick_tt flex">
				<input class="int1" type="text" placeholder="请输入内容" />
				<div class="sh_img"><img src="${root}/GS/img/sh.png" ></div>
			</div>
		</div>
		<div class="main">
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
					<li><a class="lobby" href="${root}/personGrowth/mainWeb">必修</a></li>
					<li><a class="lobby_xuanxiu" href="${root}/personGrowth/electiveWeb" onclick="changehistory()">选修</a></li>
				</ul>
			</div>
			
			
			
			
			<div class="main_a">
				<div class="ma_list">
					<ul class="flex" id="taskPlanListBox">
						
					</ul>
				</div>
			</div>
		</div>
		
		
		
		<div class="footer">
			<ul class="flex">
				<li><a href="${root}/personGrowth/mainWeb" onclick="changehistory()">
					<div class="foot foot_1">
						<div class="ft_tt center">
							<p class="fs-14">大厅</p>
						</div>
					</div>
				</a></li>
				<li><a href="${root}/personGrowth/myTaskWeb" onclick="changehistory()">
					<div class="foot">
						<div class="ft_tt ft_tt2 center">
							<p class="fs-14">清单</p>
						</div>
					</div>
				</a></li>
				<li><a href="${root}/personGrowth/personWeb" onclick="changehistory()">
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
		window.onload = function(){
				showTaskType();
				console.log(GetUrl());
				console.log(GetUrlParas());
				GetSige(GetUrl(),GetUrlParas());
			}
			function showTaskType(){
				$.ajax({
					 url:'${root}/personGrowth/showPlanListEvent',
					 type:"get",
					 dataType : "json",
					 success:function(res){
						 console.log(res);
						 var str=""
						 for(var i=0;i<res.length;i++){
							 if(res[i].taskTypeId!=1){
								 str+="<li>"+
									"<div class='malist_inbox malist_inbox1 flex'>"+
										"<div class='inbox_img inbox_img2'>"+
											"<img src='${root}/upload/"+res[i].reservedFields+"' />"+
										"</div>"+
										"<div class='inbox_tt'>"+
											"<p class='fs-25'>"+res[i].taskTypeName+"</p>"+
											"<div class='fs-17 pdt-1 flex tt1'>"+
												"<div class='c-42'>周期: <span class='c-239 bold'>180</span>天</div>"+
												"<div class='c-42'>成长值:<span class='c-239 bold'>+250</span></div>"+
											"</div>"+
											"<div class='inbox_button flex'>"+
												"<div class='fs-17 c-239 bold'>185<span class='c-42 normal'>人参与</span></div>"+
												"<div class='button_r'>"+
													"<a href='${root}/personGrowth/taskListWeb?taskTypeId="+res[i].taskTypeId+"&taskTypeName="+res[i].taskTypeName+"'><button class='button button_m' onclick='changehistory()'>进入</button></a>"+
												"</div>"+
											"</div>"+
										"</div>"+
									"</div>"+
								"</li>";
							 }
							 
						 }
						 $('#taskPlanListBox').empty();
						 $('#taskPlanListBox').append(str);
						 
					 }
				 });
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
<script>
function GetUrlParas(){
	var url = document.location.toString();
	var arrUrl = url.split("?");
	if(arrUrl.length>1){
	var para = arrUrl[1];
		var paras=para.split("&");
		var paraStr="";
		for(var i=0;i<paras.length;i++){
			paraStr+=paras[i]+",";
		}
		paraStr=paraStr.substr(0,paraStr.length-1)
		return paraStr;
	}else{
		return "null";
	}
}
function GetUrl(){
	var url = document.location.toString();
	var arrUrl = url.split("?");
	return arrUrl[0];
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
var openid=getCookie("openid");
function getMyInfo(){
	$.ajax({
		 url:'${root}/wxInterface/getMeWxData?openid='+openid,
		 type:"get",
		 dataType : "json",
		 success:function(res){
			 console.log(res);
		 }
	 });
}
getMyInfo();
function GetSige(url,paras){
	
	$.ajax({
	    url :"${root}/wxInterface/newBuildSign", 
	    type : "post", 
	    data :  {"url":url,"paras":paras},
	    dataType : "json", 
	    success : function(data)
	    {
	 	   console.log(data);
	 	   var linkStr=document.location.toString();
	 	  wx.config({
	 		    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	 		    appId: 'wx5317ce8cdd436edd', // 必填，公众号的唯一标识
	 		    timestamp:data.timestamp , // 必填，生成签名的时间戳
	 		    nonceStr:data.nonceStr, // 必填，生成签名的随机串
	 		    signature: data.signature,// 必填，签名，见附录1
	 		    jsApiList: ['updateAppMessageShareData'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	 		});
	 		wx.ready(function () {   //需在用户可能点击分享按钮前就先调用
	 		    wx.updateAppMessageShareData({ 
	 		        title: '不遗憾中心', // 分享标题
	 		        desc: '开始打卡成长之旅', // 分享描述
	 		        link:linkStr,
	 		        //link: 'http://xx.light-umbrella.com${root}/vote/voteIndex2Web', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
	 		        imgUrl: 'http://xx.light-umbrella.com/votePro/upload/logo3.png', // 分享图标
	 		        success: function () {
	 		          // 设置成功
	 		          console.log("设置成功");
	 		        }
	 		    })
	 		});

	 		wx.error(function(res){
	 			console.log(res);
	 		    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
	 		});
	 	   
	    }, 
	    error: function (XMLHttpRequest, textStatus, errorThrown)
	    {
	        console.log(XMLHttpRequest);
	        console.log(textStatus);
	        console.log(errorThrown);
	    }
	});
}
</script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.4.0.js"></script>
<script>
$(function(){ 
	pushHistory(); 
	window.addEventListener("popstate", function(e) { 
		console.log(e);
		
		if(e.state==null){	
	wx.miniProgram.navigateBack({
		url:'/pages/NRU/index',
		success: function(){
		console.log('success')
		},
		fail: function(){
		console.log('fail');
		},
		complete:function(){
		console.log('complete');
		}
		});
		}else{
			changehistory2();
		}
		
	}, false);
		function pushHistory() {
			var state = {
				title : "title",
				url : "#",
				msg:'toApp'
			};
			window.history.pushState(state, "title", "#");
			console.log(window.history.length);
		}
	});
var changehistory=function(){
	var state = {
			title : "title",
			url : "#",
			msg:'tomian'
		};
	window.history.replaceState(state, "title", "#");
	console.log("修改历史纪录");
}
var changehistory2=function(){
	var state = {
			title : "title",
			url : "#",
			msg:'toApp'
		};
	window.history.replaceState(state, "title", "#");
	console.log("修改历史纪录");
}


</script>
	</body>
</html>