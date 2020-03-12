<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>投票大厅</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="https://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css"> 
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>
<script type="text/javascript" src="${root}/js/jquery-1.11.3.min.js"></script>
<script src=https://res2.wx.qq.com/open/js/jweixin-1.4.0.js></script>
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
	var nowurl="http://xx.light-umbrella.com${root}/vote/voteIndex2Web";
	if($.getUrlParam('from')!=null){
		nowurl=nowurl+"?from="+$.getUrlParam('from');
	}
	
	if($.getUrlParam('isappinstalled')!=null){
		nowurl=nowurl+"&isappinstalled=0";
	}
	$.ajax({
	    url :"${root}/wxInterface/buildSign", 
	    type : "post", 
	    data :  "url="+nowurl,
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
	 		        link: 'http://xx.light-umbrella.com${root}/vote/voteIndex2Web', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
	 		        imgUrl: 'http://xx.light-umbrella.com${root}/upload/logo1.png', // 分享图标
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
	 	   var str="<ul>";
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
		 		  
		 		  
	 		  	  str+="<li><div class='padd'><a href='${root}/vote/voteIndex?activityId="+data[i].activityId+"' class='img'><img src='${root}/upload/"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].activityName+"</div>"+state+"<div class='btn c-fff' onclick='activityIn("+data[i].activityId+")'>进入</div></div></div></li>";
	 		  
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
	<div class="warp">
		<div class="swiper-container">
			<div class="swiper-wrapper" id="autopicture"></div>
			<div class="swiper-pagination"></div>
		</div>
		<div class="main">
			<div class="ind_list" id="ActivityList">
			</div>
		</div>
		<div class="foot">
			<ul class="clearfloat">
				<li><a href="${root }/vote/voteIndex2Web" class="on"><i class="layui-icon layui-icon-home" style="font-size: 20px"></i><p>投票大厅</p></a></li>
				<li><a href="${root }/vote/activityIndex2Web"><i class="layui-icon layui-icon-file" style="font-size: 20px"></i><p>发起投票</p></a></li>
				<li><a href="${root }/vote/personalCenterWeb"><i class="layui-icon layui-icon-user" style="font-size: 20px"></i><p>个人中心</p></a></li>
			</ul>
		</div>
	</div>
</body>
</html>