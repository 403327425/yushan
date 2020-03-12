<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>活动主页</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="https://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css">
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>


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
var openid=getCookie("openid");
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
var flag=false;	
var flag2=false;
function load(){
	
	
	var nowurl="http://xx.light-umbrella.com${root}/vote/voteIndex?activityId="+$.getUrlParam('activityId');
	var webtype="1";
	
		if($.getUrlParam('from')=="timeline"){
			console.log($.getUrlParam('from'));
			webtype="5";
		}
		if($.getUrlParam('from')=="groupmessage"){
			console.log($.getUrlParam('from'));
			webtype="6";
		}
		if($.getUrlParam('from')=="singlemessage"){
			console.log($.getUrlParam('from'));
			webtype="7";	
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
	
	
	
	
	
	
	
	
	if("${param.activityId}"==""){
		window.location.href="${root}/vote/activityListWeb";
	}else{
		$.ajax({
		    url :"${root}/vote/getAllActivityById", 
		    type : "post", 
		    data :  "activityId="+"${param.activityId}",
		    dataType : "json", 
		    success : function(data){
		    	if(data.voteMode2=="2"){
		    		flge2=true;
		    	}
		    	if(data.voteMode=="1"){
		    		$('#activityLimitCountBox').append("限定助力总次数："+data.limitNumber);
		    	}else if(data.voteMode=='2'){
		    		$('#activityLimitCountBox').append("今日限定助力总次数："+data.limitNumber);
		    	}
		    	
		 	   console.log(data.picture);
		 	   $('#activitypicture').empty();
		 	   if(getFileBaseName3(data.picture)==null){
		 		  if(getFileBaseName2(data.picture)==null){
		 			 var A=getFileBaseName(data.picture);
		 			 console.log(A);
		 			$("#autopicture").append("<div class='swiper-slide' ><img src='${root}/upload/"+A+"' /></div>");
		 		  }
		 		  else{
		 			 var B=getFileBaseName2(data.picture);
		 			 var A=getFileBaseName(data.picture);
		 			console.log(A);
		 			console.log(B);
		 			$("#autopicture").append("<div class='swiper-slide' ><img src='${root}/upload/"+A+"' /></div><div class='swiper-slide' ><img src='${root}/upload/"+B+"' /></div>");
		 		  }
		 	  }
		 	  else{
		 		 var C=getFileBaseName3(data.picture);
		 		 var B=getFileBaseName2(data.picture);
		 		var A=getFileBaseName(data.picture);
		 		console.log(A);
	 			console.log(B);
	 			console.log(C);
		 		$("#autopicture").append("<div class='swiper-slide' ><img src='${root}/upload/"+A+"' /></div><div class='swiper-slide' ><img src='${root}/upload/"+B+"' /></div></div><div class='swiper-slide' ><img src='${root}/upload/"+C+"' /></div>");
		 	  }
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
		 	 var unixTimestamp2 = new Date(data.startTime);
		 	 var unixTimestamp3 = new Date().getTime();	 	 
		 	 
		 	 if(Date.parse(unixTimestamp2)-unixTimestamp3>0){
		 		
		 		$("#signUpDiv").attr("style","display:none;");
		 		var unixTimestamp = new Date(data.startTime);
		 		commonTime = unixTimestamp.toLocaleString();
		 		console.log(commonTime);
		 		$("#endOrStart").empty();
		 		$("#endOrStart").append("报名开始");			 	   
		 		$(function(){					
					$.leftTime(commonTime,function(d){							
							if(d.status){
								var $dateShow=$("#dateShow");
								$dateShow.find(".d").html(d.d);
								$dateShow.find(".h").html(d.h);
								$dateShow.find(".m").html(d.m);
								$dateShow.find(".s").html(d.s);
							}else{																
								
							}
						});
				});		 		
		 	 }else{
		 		var unixTimestamp = new Date(data.endTime);
		 		 commonTime = unixTimestamp.toLocaleString();
		 		 console.log(commonTime);
		 		$("#endOrStart").empty();
		 		$("#endOrStart").append("报名结束");
		 		$(function(){					
					$.leftTime(commonTime,function(d){							
							if(d.status){
								var $dateShow=$("#dateShow");
								$dateShow.find(".d").html(d.d);
								$dateShow.find(".h").html(d.h);
								$dateShow.find(".m").html(d.m);
								$dateShow.find(".s").html(d.s);
							}else{
								
								$("#dateShow .dateShowcm").html("<span class='span'>报名已结束</span>");
								$("#signUpDiv").attr("style","display:none;");
								
							}
						});
				});
		 	 }
		 	 
		 	 var unixTimestamp4 = new Date(data.startTime2);
				if(Date.parse(unixTimestamp4)-unixTimestamp3>0){
		 		
		 		
		 		var unixTimestamp = new Date(data.startTime2);
		 		commonTime2 = unixTimestamp.toLocaleString();
		 		console.log(commonTime2);
		 		$("#endOrStart2").empty();
		 		$("#endOrStart2").append("助力开始");			 	   
		 		$(function(){					
					$.leftTime(commonTime2,function(d){							
							if(d.status){
								var $dateShow2=$("#dateShow2");
								$dateShow2.find(".d").html(d.d);
								$dateShow2.find(".h").html(d.h);
								$dateShow2.find(".m").html(d.m);
								$dateShow2.find(".s").html(d.s);
							}else{																
								
							}
						});
				});
		 		flag=true;
		 	 }else{
		 		var unixTimestamp = new Date(data.endTime2);
		 		 commonTime2 = unixTimestamp.toLocaleString();
		 		 console.log(commonTime2);
		 		$("#endOrStart2").empty();
		 		$("#endOrStart2").append("助力结束");
		 		$(function(){					
					$.leftTime(commonTime2,function(d){							
							if(d.status){
								var $dateShow2=$("#dateShow2");
								$dateShow2.find(".d").html(d.d);
								$dateShow2.find(".h").html(d.h);
								$dateShow2.find(".m").html(d.m);
								$dateShow2.find(".s").html(d.s);
							}else{
								
								$("#dateShow2 .dateShowcm").html("<span class='span'>活动已结束</span>");
								
								flag=true;
								
							}
						});
				});
		 	 }
	 		$("#visitCount").append(data.visitCount); 
	 		$("#activityDescribe").empty();
	 		$("#activityDescribe").append(data.activityDescribe);		 	   
		    }, 
		    error: function (XMLHttpRequest, textStatus, errorThrown)
		    {
		        console.log(XMLHttpRequest);
		        console.log(textStatus);
		        console.log(errorThrown);
		    }
		});		
		$.ajax({
		    url :"${root}/vote/getAllCandidateByActivityId", 
		    type : "post", 
		    data :  "activityId="+"${param.activityId}",
		    dataType : "json", 
		    success : function(data)
		    {
		    	if(!flag2){
		    		console.log(data);
				 	   $("#candidateList").empty();
				 	   var str="<ul>";
				 	   for(var i=0;i<data.length;i++){
				 		  var A=getFileBaseName(data[i].picture);
				 		   str+="<li><div class='padd'><a href='${root}/vote/voteContentWeb?candidateId="+data[i].candidateId+"&activityId="+data[i].activityId+"' class='img'><div class='bh bg-gray'>"+data[i].selectId+"</div><img src='${root}/upload/"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].candidateName+"</div><div class='num c-black' id='count"+data[i].candidateId+"'>人气值："+data[i].iphone+"</div></div></div></li>";
				 	   }
				 	   str +="</ul>";
				 	   $("#candidateList").append(str);
				 	   $("#candidateCount").append(data.length);
		    	}else{
		    		if(!flag){
				    	   console.log(data);
					 	   $("#candidateList").empty();
					 	   var str="<ul>";
					 	   for(var i=0;i<data.length;i++){
					 		  var A=getFileBaseName(data[i].picture);
					 		   str+="<li><div class='padd'><a href='${root}/vote/voteContentWeb?candidateId="+data[i].candidateId+"&activityId="+data[i].activityId+"' class='img'><div class='bh bg-gray'>"+data[i].selectId+"</div><img src='${root}/upload/"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].candidateName+"</div><div class='num c-black' id='count"+data[i].candidateId+"'>人气值："+data[i].iphone+"</div><div class='btn c-fff' onclick='toupiao("+data[i].candidateId+")'>助力</div></div></div></li>";
					 	   }
					 	   str +="</ul>";
					 	   $("#candidateList").append(str);
					 	   $("#candidateCount").append(data.length);
				       }else{
				    	   console.log(data);
					 	   $("#candidateList").empty();
					 	   var str="<ul>";
					 	   for(var i=0;i<data.length;i++){
					 		  var A=getFileBaseName(data[i].picture);
					 		   str+="<li><div class='padd'><a href='${root}/vote/voteContentWeb?candidateId="+data[i].candidateId+"&activityId="+data[i].activityId+"' class='img'><div class='bh bg-gray'>"+data[i].selectId+"</div><img src='${root}/upload/"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].candidateName+"</div><div class='num c-black' id='count"+data[i].candidateId+"'>人气值："+data[i].iphone+"</div><div class='btn c-fff' onclick='msgOver()'>助力</div></div></div></li>";
					 	   }
					 	   str +="</ul>";
					 	   $("#candidateList").append(str);
					 	   $("#candidateCount").append(data.length);
				       }
		    	}
		       		 	  
		    }, 
		    error: function (XMLHttpRequest, textStatus, errorThrown)
		    {
		        console.log(XMLHttpRequest);
		        console.log(textStatus);
		        console.log(errorThrown);
		    }
		});		
		$.ajax({
		    url :"${root}/vote/getAllVoteCount", 
		    type : "post", 
		    data :  "activityId="+"${param.activityId}",
		    dataType : "json", 
		    success : function(data)
		    {
		 	   console.log(data+"数据");
		 	   $("#voteAllCount").append(data);	   					 	  
		    }, 
		    error: function (XMLHttpRequest, textStatus, errorThrown)
		    {
		        console.log(XMLHttpRequest);
		        console.log(textStatus);
		        console.log(errorThrown);
		    }
		});
	}
	
	/* if("${openid}"==null||"${openid}"==""){
		console.log("988886");
		
	}else{
		console.log("${openid}");
		console.log("9777777");
		$("#signUpDiv").empty();
		$("#signUpDiv").append("<a href='${root}/vote/signUpWeb2?activityId=${param.activityId}&openid=${openid}' class='btn bg-cm blink' >我要报名</a>");
	} */
	
	
}

function getFileBaseName(s) {
		  var p=s.split(',');		  
		  return p[0];
}
function getFileBaseName2(s) {  
		  var p=s.split(',');
		  if(p.length>1){			 
			  return p[1];
		  }else{
			  return null;
		  }
	}
function getFileBaseName3(s) {
		  var p=s.split(',');
		  if(p.length>2){				  
			  return p[2];
		  }else{
			  return null;
		  }		  
	}
Date.prototype.toLocaleString = function() {
    return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate() + " " + this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds() + "";
};
function msgOver(){
	layer.msg('不在助力时间');
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
			<div class="ind_a">
				<ul class="clearfloat bg-gray">
					<li>
						<span class="span" id="candidateCount"></span>
						<p class="p"><i class="icon-renshu iconfont"></i>参赛数</p>
					</li>
					<li>
						<span class="span" id="voteAllCount"></span>
						<p class="p"><i class="icon-toupiaoshu iconfont"></i>人气值</p>
					</li>
					<li>
						<span class="span" id="visitCount"></span>
						<p class="p"><i class="icon-fangwenliang1 iconfont"></i>访问量</p>
					</li>
				</ul>
			</div>
			
			<div class="ind_b">
				<div class="time" >
					<div id="dateShow">
						<i class="iconfont icon-shijian1 c-cm"></i> <span class="span" id="endOrStart">结束</span>倒计时：
						<span class="dateShowcm"> 
							<font class="span d">0</font>天
							<font class="span h">0</font>时
							<font class="span m">0</font>分
							<font class="span s">0</font>秒
						</span>
					</div>
					
					<div id="dateShow2">
						<i class="iconfont icon-shijian1 c-cm"></i> <span class="span" id="endOrStart2">结束</span>倒计时：
						<span class="dateShowcm"> 
							<font class="span d">0</font>天
							<font class="span h">0</font>时
							<font class="span m">0</font>分
							<font class="span s">0</font>秒
						</span>
					</div>
					<div id="activityLimitCountBox"></div>
				</div>
				
			</div>
			
			<div class="ind_c" id="signUpDiv"><a href="${root}/vote/signUpWeb?activityId=${param.activityId}" class="btn bg-gray blink" onclick="getOpenId()">我要报名</a></div>
			<div class="ind_d" >
				<div class="ss_com bor-gray">
					<input type="text" id="likeText" placeholder="请输入编号或名称"  class="ss_txt"/>
					<div class="btn bg-gray" onclick="selectLikeBy2()"><i class="iconfont icon-suosou c-fff" ></i><span class="c-fff">搜索</span></div>
				</div>
			</div>
			<div class="ind_list" id="candidateList">	
			</div>
			<div class="ind_gz">
				<div class="tt_com bg-gray c-fff">活动规则</div>
				<div class="bg-fff gz_com" id="activityDescribe">

				</div>
			</div>
		</div>
		<div class="foot">
			<ul class="clearfloat">
				<li><a href="${root }/vote/voteIndex2Web" ><i class="layui-icon layui-icon-return" style="font-size: 20px"></i><p>返回大厅</p></a></li>
				<li><a href="${root }/vote/voteRankingWeb?activityId=${param.activityId}"><i class="iconfont icon-paimingiconx"></i><p>排名</p></a></li>
				<li><a href="${root }/vote/personalCenterWeb"><i class="layui-icon layui-icon-user" style="font-size: 20px"></i><p>个人中心</p></a></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript" src="${root}/js/leftTime.min.js"></script>
	<script type="text/javascript" src="${root}/js/layer/layer.js"></script>
	 <script>
		//  投票
		 function toupiao(candidateId){
			layer.confirm('确认助力?', {
				icon: 3,
				btn: ['确认','取消'], //按钮
				yes: function (index) {
					console.log(index)
					layer.close(index);
					/* console.log("969696969696");
					if("${openid}"==null||"${openid}"==""){
						console.log("988886");
						getOpenId();
					}else{
						console.log("${openid}");
						console.log("9777777");
						$.ajax({
						    url :"${root}/vote/voteMark", 
						    type : "get", 
						    data :  { "activityId":"${param.activityId}","candidateId" : candidateId ,"ip":"${openid}"},
						    dataType : "json", 
						    success : function(data)
						    {
						 	  console.log(data);
						 	  layer.msg(data[0]);
						 	  $("#count"+candidateId+"").empty();
						 	  $("#count"+candidateId+"").append(data[1]+"票");
						    }, 
						    error: function (XMLHttpRequest, textStatus, errorThrown)
						    {
						        console.log(XMLHttpRequest);
						        console.log(textStatus);
						        console.log(errorThrown);
						    }
						});
					} */
					
					$.ajax({
					    url :"${root}/vote/voteMark", 
					    type : "get", 
					    data :  { "activityId":"${param.activityId}","candidateId" : candidateId ,"ip":openid},
					    dataType : "json", 
					    success : function(data)
					    {
					 	  
					 	  layer.msg(data[0]);
					 	  $("#count"+candidateId+"").empty();
					 	  $("#count"+candidateId+"").append("人气值"+data[1]);
					    }, 
					    error: function (XMLHttpRequest, textStatus, errorThrown)
					    {
					    	
					        console.log(XMLHttpRequest);
					        console.log(textStatus);
					        console.log(errorThrown);
					    }
					});
				}
			})
		 }
		 // banner
		var swiper = new Swiper('.swiper-container', {
		  pagination: {
			el: '.swiper-pagination',
		  },
		});
		function selectLikeBy2(){
			var name=$("#likeText").val();			 
			$.ajax({
			    url :"${root}/vote/getLikeCandidateByActivityId2", 
			    type : "post", 
			    data :  { "activityId":"${param.activityId}","candidateName" : name},
			    dataType : "json", 
			    success : function(data)
			    {
			 	  console.log(data);
			 	  
			 	   $("#candidateList").empty();
			 	   var str="<ul>";
			 	   for(var i=0;i<data.length;i++){
			 		  var A=getFileBaseName(data[i].picture);
			 		  if(!flag2){
			 			  
			 		  }else{
			 			 str+="<li><div class='padd'><a href='${root}/vote/voteContentWeb?candidateId="+data[i].candidateId+"&activityId="+data[i].activityId+"' class='img'><div class='bh bg-gray'>"+data[i].selectId+"</div><img src='${root}/upload/"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].candidateName+"</div><div class='num c-black' id='count"+data[i].candidateId+"'>人气值："+data[i].iphone+"</div></div></div></li>"
			 		  
				 		  if(!flag){
				 			 str+="<li><div class='padd'><a href='${root}/vote/voteContentWeb?candidateId="+data[i].candidateId+"&activityId="+data[i].activityId+"' class='img'><div class='bh bg-gray'>"+data[i].selectId+"</div><img src='${root}/upload/"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].candidateName+"</div><div class='num c-black' id='count"+data[i].candidateId+"'>人气值："+data[i].iphone+"</div><div class='btn c-fff' onclick='toupiao("+data[i].candidateId+")'>助力</div></div></div></li>"
				 		  }else{
				 			 str+="<li><div class='padd'><a href='${root}/vote/voteContentWeb?candidateId="+data[i].candidateId+"&activityId="+data[i].activityId+"' class='img'><div class='bh bg-gray'>"+data[i].selectId+"</div><img src='${root}/upload/"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].candidateName+"</div><div class='num c-black' id='count"+data[i].candidateId+"'>人气值："+data[i].iphone+"</div><div class='btn c-fff' onclick='msgOver()'>助力</div></div></div></li>"
				 		  }
			 		  }
			 		   
			 	   }
			 	   str +="</ul>"
			 	   $("#candidateList").append(str);			 	   			 	   
			    }, 
			    error: function (XMLHttpRequest, textStatus, errorThrown)
			    {
			        console.log(XMLHttpRequest);
			        console.log(textStatus);
			        console.log(errorThrown);
			    }
			});
		}
		function selectLikeBy(){ 
			 var name=$("#likeText").val();
			 var Id=9999999;
			 var val=$("#likeText").val();
			 if(isNumber(val)){
				 var Id=$("#likeText").val();
			 }
			$.ajax({
			    url :"${root}/vote/getLikeCandidateByActivityId2", 
			    type : "post", 
			    data :  { "activityId":"${param.activityId}","candidateName" : name ,"candidateId":Id},
			    dataType : "json", 
			    success : function(data)
			    {
			 	  console.log(data);
			 	  
			 	   $("#candidateList").empty();
			 	   var str="<ul>";
			 	   for(var i=0;i<data.length;i++){
			 		  var A=getFileBaseName(data[i].picture);
			 		   str+="<li><div class='padd'><a href='${root}/vote/voteContentWeb?candidateId="+data[i].candidateId+"&activityId="+data[i].activityId+"' class='img'><div class='bh bg-gray'>"+data[i].selectId+"</div><img src='${root}/upload/"+A+"' /></a><div class='tp_dd c-fff'><div class='name c-black'>"+data[i].candidateName+"</div><div class='num c-black' id='count"+data[i].candidateId+"'>人气值："+data[i].iphone+"</div><div class='btn c-cm' onclick='msgOver()'>助力</div></div></div></li>"
			 	   }
			 	   str +="</ul>"
			 	   $("#candidateList").append(str);			 	   			 	   
			    }, 
			    error: function (XMLHttpRequest, textStatus, errorThrown)
			    {
			        console.log(XMLHttpRequest);
			        console.log(textStatus);
			        console.log(errorThrown);
			    }
			});
		}
		function isNumber(val) {
		    var regPos = /^\d+(\.\d+)?$/; //非负浮点数
		    var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
		    if(regPos.test(val) || regNeg.test(val)) {
		        return true;
		    } else {
		        return false;
		    }
		}
		function getOpenId(){
			//location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdfb0cebac2cd3ba7&redirect_uri=http%3A%2F%2Fwww.403327425.com%2FwxInterface%2FgetOpenId2&response_type=code&scope=snsapi_userinfo&state=${param.activityId}#wechat_redirect";
		}
		
	  </script> 
</body>
</html>