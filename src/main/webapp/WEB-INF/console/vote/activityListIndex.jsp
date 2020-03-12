<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>


<head>
<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<title>投票大厅</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>

		<link rel="stylesheet" type="text/css" href="${root}/newcss/common.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/newcss/fontsize.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/newcss/reset.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/newcss/swiper.min.css"/>
		<link rel="stylesheet" type="text/css" href="${root}/newcss/lobby.css"/>
		
		
		
		<script src="${root}/newjs/jquery1.11.1.min.js"></script>
		<script src="${root}/newjs/swiper.min.js"></script>
		<script src="${root}/newjs/common.js"></script>
<script>
	(function($){
		$.getUrlParam = function(name)
		{
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r!=null) return unescape(r[2]); return null;
		}
	})(jQuery);

</script>
<script>
function load(){
	$("#autopicture").append("<div class='swiper-slide' ><img src='${root}/upload/AAA.jpg' /></div><div class='swiper-slide' ><img src='${root}/upload/BBB.jpg' /></div></div><div class='swiper-slide' ><img src='${root}/upload/CCC.jpg' /></div>");
	var swiper = new Swiper('.swiper-container', {		 	     
	     loop:true,
	     autoplay: {
	         disableOnInteraction: false, //手动滑动之后不打断播放
	         delay: 2000
	       },
	       pagination: {
	      el: '.swiper-pagination',
	       },
	     });
	var nowurl="http://xx.light-umbrella.com${root}/vote/activityListIndexWeb";
	var webtype="1";
	
		if($.getUrlParam('from')=="timeline"){
			console.log($.getUrlParam('from'));
			webtype="2";
		}
		if($.getUrlParam('from')=="groupmessage"){
			console.log($.getUrlParam('from'));
			webtype="3";
		}
		if($.getUrlParam('from')=="singlemessage"){
			console.log($.getUrlParam('from'));
			webtype="4";
			
		}
		console.log(webtype);
	
	
	console.log("++++++++++++++"+nowurl);
	var str02=window.location.href;
	$.ajax({
	    url :"${root}/wxInterface/buildSign", 
	    type : "post", 
	    data :  {"url":nowurl,"webtype":webtype},
	    dataType : "json", 
	    success : function(data)
	    {
	 	   console.log(data);
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
	 		        title: '活动大厅', // 分享标题
	 		        desc: '快来给你喜欢的打call', // 分享描述
	 		        link:nowurl,
	 		        //link: 'http://xx.light-umbrella.com${root}/vote/voteIndex2Web', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
	 		        imgUrl: 'http://xx.light-umbrella.com${root}/upload/logo3.png', // 分享图标
	 		        success: function () {
	 		          // 设置成功
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
	$.ajax({
	    url :"${root}/vote/getAllActivity", 
	    type : "post", 
	     
	    dataType : "json", 
	    success : function(data)
	    {
	 	   console.log(data);
	 	   $('#ActivityList').empty();
	 	   var str="<ul class='flex'>";
	 	   for(i=data.length-1;i>=0;i--){	 		  
	 		  var time2 = new Date().valueOf();	 		  
	 		  
		 		  var unixTimestamp = new Date(data[i].endTime2) ;
		 		  commonTime = unixTimestamp.toLocaleString(); 		  
		 		  var unixTimestamp2 = new Date(data[i].startTime) ;
		 		  commonTime2 = unixTimestamp2.toLocaleString();
		 		  //$('#ActivityList').append("活动：<a href='${root}/vote/voteIndex?activityId="+data[i].activityId+"'>"+data[i].activityName+"</a>\t\t截至日期："+commonTime+"</br>");
		 		  var A=getFileBaseName(data[i].picture);
		 		  var state="";
		 		  if(time2<data[i].startTime){
		 			 state="<div class='num c-color05' id=''>待开放</div>"
		 		  }
		 		  if(time2<data[i].endTime2&&time2>data[i].startTime){
		 			 state="<div class='num c-color03' id=''>进行中</div>"
		 		  }
				  if(time2>data[i].endTime2){
		 			 state="<div class='num c-color04' id=''>已结束</div>"
		 		  }
				  
					str+="<li><div class='li_tt'><p class='fs-20 c-239'>"+state+"</p></div><div class='malist_inbox'><div class='inbox_img'><img src='${root}/upload/slt"+A+"' /></div><div class='inbox_tt'><p class='fs-25'>"+data[i].activityName+"</p></div><div class='inbox_button'><button class='button' onclick='activityIn("+data[i].activityId+")'>进入</button></div></div></li>"
		 		  
	 		  	  /* str+="<li><div class='padd'><a href='${root}/vote/voteIndex?activityId="+data[i].activityId+"' class='img'><img src='${root}/upload/slt"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].activityName+"</div>"+state+"<div class='btn c-fff' onclick='activityIn("+data[i].activityId+")'>进入</div></div></div></li>"; */
	 		  
	 	   }
	 	   str +="</ul>";
	 	   $("#ActivityList").append(str);
	 	   
	    }, 
	    error: function (XMLHttpRequest, textStatus, errorThrown)
	    {
	        console.log(XMLHttpRequest);
	        console.log(textStatus);
	        console.log(errorThrown);
	    }
	});
}
function getFileBaseName(s) {
	  var p=s.split(',');
	  return p[0];
}
Date.prototype.toLocaleString = function() {
    return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate() + "" ;
};
function activityIn(activityId){
	window.location.href="${root}/vote/voteIndex?activityId="+activityId+"";
}

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "H+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds() //毫秒 
    }; //季度 
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
</script>
</head>
<body onload="load();">
		<div class="header">
			<div class="head clearfloat">
				<img src="${root}/newimg/logo.png" />
				<div class="sh fr"><img src="${root}/newimg/sh.png" /></div>
			</div>
		</div>
		
		
		<div class="main">
			<div class="banner_bg">
				<div class="banner swiper-container" >
					<div class="swiper-wrapper" id="autopicture">
						
					</div>
					<div class="banner_pag swiper-pagination">
						<span class="swiper-pagination-bullet"></span>
						<span class="swiper-pagination-bullet"></span>
						<span class="swiper-pagination-bullet"></span>
					</div>
				</div>
			</div>
			
			<form class="layui-form" action="">
						<div align="center" style="width:80%;margin-left:10%;padding-bottom:15px;">
						<select  id="schoolName" name="schoolName" >
									    <option value="全部校区" >全部校区</option>
									    <option value="东莞理工学院(松山湖)" >东莞理工学院(松山湖)</option>
									    <option value="东莞理工学院(莞城)" >东莞理工学院(莞城)</option>
									    <option value="广东医科大学(东莞)" >广东医科大学(东莞)</option>
									    <option value="广东创新科技职业学院" >广东创新科技职业学院</option>
									    <option value="东莞职业技术学院" >东莞职业技术学院</option>
									    <option value="广东科技学院" >广东科技学院</option>
									    <option value="中山大学新华学院" >中山大学新华学院</option>
									    <option value="广东酒店管理职业技术学院" >广东酒店管理职业技术学院</option>										    
						</select>
						</div>
					</form>
			
			<div class="main_a">
				<div class="ma_hd flex cur-def">
					<%-- <div class="mahd_l" style="background-image: url(${root}/img/mahd_l.png);">
						<p class="fs-25">东莞理工学院</p>
					</div>
					<div class="mahd_r" style="background-image: url(${root}/img/mahd_r.png);">
						<p class="fs-25">选择校区</p>
					</div> --%>
					
					

				</div>
					
				<!-- <div class="ma_nav">
					<ul>
						<li><a href="">最新</a></li>
						<li><a href="">热度</a></li>
					</ul>
				</div> -->
				<div class="ma_list" id="ActivityList">
				</div>
			</div>
		
		</div>
		<div class="footer">
			<ul class="flex">
				<li><a href="${root}/vote/activityListIndexWeb">
					<div class="foot">
						<div class="ft_tt center">
							<p class="fs-22">点赞大厅</p>
						</div>
					</div>
				</a></li>
				<li><a href="${root}/vote/addActivityWeb">
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
		<script type="text/javascript" src="${root}/js/layer/layer.js"></script>
		<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
			<script>
	  layui.config({
	    base: '${root}/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index','laydate', 'upload','form' ,'jquery'], function(){
	  })
	  

  </script>
	</body>
</html>