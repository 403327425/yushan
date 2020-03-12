/**
 * 
 */

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
function GetSige(titleStr,descStr){
	var url=GetUrl();
	var paras=GetUrlParas();
	$.ajax({
	    url :"https://xx.light-umbrella.com/GrowthSystem/wxInterface/newBuildSign", 
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
	 		        title: titleStr, // 分享标题
	 		        desc: descStr, // 分享描述
	 		        link:linkStr,
	 		        //link: 'http://xx.light-umbrella.com${root}/vote/voteIndex2Web', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
	 		        imgUrl: 'https://xx.light-umbrella.com/votePro/upload/logo3.png', // 分享图标
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
