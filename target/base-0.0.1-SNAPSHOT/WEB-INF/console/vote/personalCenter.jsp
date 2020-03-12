<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>个人中心</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="https://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css"> 
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>
<script type="text/javascript" src="${root}/js/jquery-1.11.3.min.js"></script>
<script>
var openid=getCookie("openid");
function load(){
	
	$('#openidBox').empty();
	$('#openidBox').append(openid);
	
	
	$.ajax({
	    url :"${root}/vote/findPersonJoin", 
	    type : "post", 
	    data :  "openid="+openid,
	    dataType : "json", 
	    success : function(data)
	    {
	    	 console.log(data);
	      var str="<table class='layui-table'>  <colgroup><col width='75%'><col width='25%'></colgroup><thead><tr><th>活动</th><th>得票数</th></tr></thead><tbody>";
	      if(data.length>0){
	      }else{
	    	  str+="<li>你还没参加任何一个活动</li>"
	      }
	 	  for(var i=0;i<data[0].length;i++){
	 		  str+=" <tr><td>"+data[2][i].activityName+"(参赛编号："+data[0][i].selectId+")</td><td>"+data[1][i]+"</td></tr>";
	 	  }
	 	  str+="</tbody></table>"
	 	  $('#box1').append(str);
	    }, 
	    error: function (XMLHttpRequest, textStatus, errorThrown)
	    {
	        console.log(XMLHttpRequest);
	        console.log(textStatus);
	        console.log(errorThrown);
	    }
	});
	$.ajax({
	    url :"${root}/vote/findPersonVote", 
	    type : "post", 
	    data :  "openid="+openid,
	    dataType : "json", 
	    success : function(data)
	    {
	     
	      var str="<table class='layui-table'><colgroup><col width='50%'><col width='50%'></colgroup><thead><tr><th>参赛者</th><th>活动</th></tr></thead><tbody>";
	      if(data.length>0){
	    	  
	      }else{
	    	  str+="<p>你还没投票过喔！</p>"
	      }
	      
	      for(var i=0;i<data[0].length;i++){
	    	  var unixTimestamp = new Date(data[0][i].voteTime);
	    	  commonTime = unixTimestamp.toLocaleString();
	 		  str+=" <tr><td>"+data[2][i].candidateName+"("+data[2][i].selectId+")</td><td>"+data[1][i].activityName+"</td></tr>";
	 	  }
	 	  str+="</tbody></table>"
	 	  $('#box2').append(str);
	    }, 
	    error: function (XMLHttpRequest, textStatus, errorThrown)
	    {
	        console.log(XMLHttpRequest);
	        console.log(textStatus);
	        console.log(errorThrown);
	    }
	});
/* 	$.ajax({
	    url :"${root}/vote/findPersonPublish", 
	    type : "post", 
	    data :  "openid="+openid,
	    dataType : "json", 
	    success : function(data)
	    {
	    	var str="<table class='layui-table' id='test' lay-filter='test'>  <colgroup><col width='75%'><col width='25%'></colgroup><thead><tr><th>活动</th><th>浏览量</th></tr></thead><tbody>";
	      if(data.length>0){
	      }else{
	    	  str+="<li>赶紧发起投票吧</li>"
	      }
	      for(var i=0;i<data.length;i++){
	 		  str+=" <tr><td>"+data[i].activityName+"</td><td>"+data[i].visitCount+"</td></tr>";
	 	  }
	 	  str+="</tbody></table>"
	 	  $('#box3').append(str);
	    }, 
	    error: function (XMLHttpRequest, textStatus, errorThrown)
	    {
	        console.log(XMLHttpRequest);
	        console.log(textStatus);
	        console.log(errorThrown);
	    }
	}); */
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
Date.prototype.toLocaleString = function() {
    return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate() + " " +this.getHours()+"."+this.getMinutes()+"."+this.getSeconds()+"";
};

</script>
</head>
<body onload="load();">
	<div class="warp">
		<div style="height:40px;padding:20px" id="openidBox">
			
		</div>
		<div class="layui-collapse" lay-filter="test" lay-accordion>
		  
		  <div class="layui-colla-item">
		    <h2 class="layui-colla-title">我参与的投票</h2>
		    <div class="layui-colla-content" id="box1">
		      
		    </div>
		  </div>
		  <div class="layui-colla-item">
		    <h2 class="layui-colla-title">我投票的活动</h2>
		    <div class="layui-colla-content" id="box2">
		      
		    </div>
		  </div>
		  <div class="layui-colla-item">
		    <h2 class="layui-colla-title">我发起的投票</h2>
		    <div class="layui-colla-content" id="box3">
		      <table class="layui-hide" id="test" lay-filter="test"></table>
		    </div>
		  </div>
		  <div class="layui-colla-item">
		    <h2 class="layui-colla-title">联系客服</h2>
		    <div class="layui-colla-content" id="box4">
		      	
		      <img src="${root }/upload/wxkf.jpg">
		    </div>
		  </div>
		</div>
		<div class="main">
			<button type="button" class="layui-btn layui-btn-fluid" id="outUser">退出登录</button>
		</div>
		<div class="foot">
			<ul class="clearfloat">
				<li><a href="${root }/vote/voteIndex2Web" ><i class="layui-icon layui-icon-home" style="font-size: 20px"></i><p>投票大厅</p></a></li>
				<li><a href="${root }/vote/activityIndex2Web" ><i class="layui-icon layui-icon-file" style="font-size: 20px"></i><p>发起投票</p></a></li>
				<li><a href="${root }/vote/personalCenterWeb" class="on"><i class="layui-icon layui-icon-user" style="font-size: 20px"></i><p>个人中心</p></a></li>
			</ul>
		</div>
	</div>
			<script type="text/javascript" src="${root}/js/layer/layer.js"></script>
			<script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
			<script src="${root}/js/webuploader.min.js"></script>
			<script src="${root}/js/diyUpload.js"></script>
		<script>
		var openid=getCookie("openid");
	  layui.config({
	    base: '${root}/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index','laydate','upload','form' ,'jquery','element', 'layer','table'], function(){
		  var element = layui.element;
		  var layer = layui.layer;
		  var table=layui.table;
		  element.on('collapse(test)', function(data){
			    
			  });
		  table.render({
			    elem: '#test'
			    ,url:'${root}/vote/findPersonPublish2?openid='+openid
			    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			    ,cols: [[
			      {field:'activityName', width:'75%', title: '活动'}
			      ,{field:'visitCount', width:'25%', title: '浏览量',sort: true}
			      
			    ]]
			    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
			        layout: ['count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
			        //,curr: 5 //设定初始在第 5 页
			        ,groups: 1 //只显示 1 个连续页码
			        ,first: false //不显示首页
			        ,last: false //不显示尾页
			        
			      }
		   });
		  table.on('row(test)', function(obj){
			  var data = obj.data;
			  layer.open({
			        type: 1
			        ,title: false //不显示标题栏
			        ,closeBtn: false
			        ,area: '300px;'
			        ,shade: 0.8
			        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
			        ,btn: ['关闭']
			        ,btnAlign: 'c'
			        ,moveType: 1 //拖拽模式，0或者1
			        ,content: $('#openBox')
			        ,success:function(data1){
			        	console.log(data1);
			        	table.render({
						    elem: '#test2'
						    ,url:'${root}/vote/getPersonActivityCandidateList?activityId='+data.activityId
						    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
						    ,cols: [[
						      {field:'candidateName', width:'40%', title: '参赛者名称'}
						      ,{field:'selectId', width:'30%', title: '编号',sort: true}
						      ,{field:'iphone', width:'30%', title: '票数',sort: true}
						    ]]
						    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
						        layout: ['count', 'prev', 'page', 'next'] //自定义分页布局
						        //,curr: 5 //设定初始在第 5 页
						        ,groups: 1 //只显示 1 个连续页码
						        ,first: false //不显示首页
						        ,last: false //不显示尾页
						        
						      }
					   });
			        }
			      });
		  });

	  })
	  
	  
  
	  $("#outUser").click(function(){
		  console.log(openid);
		  DelCookie("openid");
		  openid=getCookie("openid");
		  console.log(openid);
	  });
	  
	  function DelCookie(name)
		{
		  window.location.href="${root}/vote/outUser"
		}
	  


  </script>
  <div id="openBox"   style="display: none; line-height: 22px; background-color: #ffffff; color: #000; font-weight: 300;">
		<table id="test2" lay-filter="test2"></table>
  </div>

</body>
</html>