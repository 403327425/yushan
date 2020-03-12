<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>活动列表</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="https://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css"> 
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>
<script type="text/javascript" src="${root}/js/jquery-1.11.3.min.js"></script>
<script>
function load(){
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
	 		  
	 		  if(time2<data[i].endTime){
	 			  
	 		  
	 		  var unixTimestamp = new Date(data[i].endTime) ;
	 		  commonTime = unixTimestamp.toLocaleString();
	 		  
	 		 var unixTimestamp2 = new Date(data[i].startTime) ;
	 		 commonTime2 = unixTimestamp2.toLocaleString();
	 		  //$('#ActivityList').append("活动：<a href='${root}/vote/voteIndex?activityId="+data[i].activityId+"'>"+data[i].activityName+"</a>\t\t截至日期："+commonTime+"</br>");
	 		  var A=getFileBaseName(data[i].picture);
	 		  str+="<li><div class='padd'><a href='${root}/vote/voteIndex?activityId="+data[i].activityId+"' class='img'><div class='bh bg-cm'>"+data[i].activityId+"</div><img src='${root}/upload/"+A+"' /></a><div class='tp_dd bg-cm'><div class='name c-fff'>"+data[i].activityName+"</div><div class='num c-fff' id=''>开始日:"+commonTime2+"</div><div class='num c-fff' id=''>截止日:"+commonTime+"</div><div class='btn c-cm' onclick='activityIn("+data[i].activityId+")'>进入</div></div></div></li>";
	 		  }
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
/* Date.prototype.toLocaleString = function() {
    return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日 " + this.getHours() + "点" + this.getMinutes() + "分" + this.getSeconds() + "秒";
}; */

function getFileBaseName(s) {
/* 	  var p = s.split('\\');
	  return p[p.length - 1].split(',', 1)[0]; */
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
	<div class="main">
		<div class="ind_list" id="ActivityList">
		</div>
	</div>
</div>


</body>
</html>