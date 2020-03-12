<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"> -->
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<title>规则</title>
<%@ include file="/WEB-INF/console/common/includs.jsp" %>
<link rel="stylesheet" href="${root}/css/reset.css">
<link rel="stylesheet" href="http://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css">
<link rel="stylesheet" href="${root}/css/swiper.min.css">
<link rel="stylesheet" href="${root}/css/style.css">
<script type="text/javascript" src="${root}/js/swiper.min.js"></script>
<script>
function load(){
	if("${param.activityId}"==""){
		window.location.href="${root}/vote/activityListWeb";
	}else{
		$.ajax({
		    url :"${root}/vote/getAllActivityById", 
		    type : "post", 
		    data :  "activityId="+"${param.activityId}",
		    dataType : "json", 
		    success : function(data)
		    {
		 	    console.log(data.picture);
				$("#activityDescribe").append(data.activityDescribe);
		 	   
		    }, 
		    error: function (XMLHttpRequest, textStatus, errorThrown)
		    {
		        console.log(XMLHttpRequest);
		        console.log(textStatus);
		        console.log(errorThrown);
		    }
		});
	}
}
</script>

</head>
<body onload="load();">
	<div class="warp">
		<div class="main smain">
			<div class="ind_gz">
				<div class="tt_com bg-cm c-fff"><svg t="1562903401012" class="icon icon2" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5085" width="48" height="48"><path d="M250.1632 701.8496V276.6848l432.5376-167.5008v773.0176L272.8704 730.624l-22.7072-28.7744z" fill="#F7D11E" p-id="5086"></path><path d="M269.2608 740.5056L250.1632 914.432H160l-25.472-231.9104 134.7328 57.984z" fill="#FFFFFF" p-id="5087"></path><path d="M160 304.256v382.6944c-7.7568-3.0208-15.3344-6.4512-22.5024-10.4704-61.696-33.2032-103.7056-101.8624-103.7056-180.7872 0-88.3456 52.736-163.6352 126.208-191.4368z" fill="#F7D11E" p-id="5088"></path><path d="M817.6896 414.8224l-115.0976-57.2672V109.184c0-6.5792-3.1744-12.7488-8.4992-16.512-5.3504-3.7632-12.0832-4.6848-18.2528-2.4064 0 0-527.36 195.712-529.2288 197.6832C66.944 321.28 13.8752 403.84 13.8752 495.7184c0 79.2064 38.4512 151.0144 101.0432 190.7968l25.2672 230.144c1.1264 10.1888 9.6512 17.92 19.7888 17.92h90.1888c10.1376 0 18.6624-7.7312 19.7888-17.92l17.4848-159.1296L675.84 901.12c2.2272 0.8192 13.0816 0.9984 18.2528-2.4064 5.3248-3.7632 8.4992-9.9328 8.4992-16.512V633.856l115.0976-57.2672c6.8096-3.3792 11.1104-10.3936 11.1104-18.0736V432.896c0-7.68-4.3008-14.6688-11.1104-18.0736zM179.8912 316.544l50.3552-18.6112v395.6224l-50.3552-18.6112v-358.4z m-126.208 179.1744c0-66.816 33.7664-127.488 86.3744-159.4368V654.848c-53.4528-32.0768-86.3744-92.3136-86.3744-159.1296z m178.6624 398.592h-54.528l-20.3008-184.8064 91.4176 33.792-16.5888 151.0144z m37.7088-188.2368V283.1872L662.784 137.984v715.4432s-392.7296-145.2288-392.7296-147.3536zM788.992 545.9968l-86.4 43.008V402.432l86.4 43.008v100.5568z m191.4368 118.7584l-108.0832-57.984c-9.728-5.1968-21.76-1.4848-26.9312 8.3456-5.1456 9.8304-1.4336 22.016 8.2688 27.2128l108.0832 57.984c2.8672 1.536 6.0672 2.3552 9.3184 2.3552 7.3984 0 14.1824-4.1216 17.6128-10.7008 5.1456-9.8304 1.4336-22.016-8.2688-27.2128z m-117.376-309.9648c3.2512 0 6.4512-0.8192 9.3184-2.3552l108.0832-57.984c9.7024-5.2224 13.4144-17.3824 8.2688-27.2128-5.1456-9.8304-17.2288-13.568-26.9312-8.3456l-108.0832 57.984c-9.7024 5.2224-13.4144 17.3824-8.2688 27.2128 3.4304 6.5792 10.2144 10.7008 17.6128 10.7008z m126.1824 95.0272h-126.208c-11.008 0-19.8912 9.0112-19.8912 20.1216s8.9088 20.1216 19.8912 20.1216h126.208c11.008 0 19.8912-9.0112 19.8912-20.1216 0-11.1104-8.9088-20.1216-19.8912-20.1216z" fill="#845E43" p-id="5089"></path><path d="M230.2464 693.5296l-50.3552-18.6112V316.544l50.3552-18.6368zM788.992 545.9968l-86.4 43.008V402.432l86.4 43.008z" fill="#FFFFFF" p-id="5090"></path></svg>活动规则</div>
				<div class="bg-fff gz_com" id="activityDescribe">
<!-- 					XXX投票大赛隆重开启！丰厚奖品等你来拿！<br />
						上传你的作品到【我要报名】即可参与！
						<br />
						上传规则：
						<br />
						 （1）投稿作品需原创，图片大小1-3M，图片张数至多3张。
							<br />
						 （2）所提供的照片不得侵犯他人名誉权、肖像权等法律权利。如果发生侵权纠纷，由提供者自行解决并承担相应的后果。
						<br />
						   （3）图片上传成功后，邀请好友进行投票，奖项名次按照最终投票数得。
						<br />
						   （4）活动期间每个微信账号每天可投1张票，为创建每支参赛队伍营造公平、公正的投票环境，本次投票反对一切形式的刷票活动，一经发现取消比赛资格！
						<br />
						征集时间：
						<br />
						2019年2月4日0点0分0秒—2019年2月10日22点59分59秒 -->
				</div>
			</div>
		</div>	
		<div class="foot">
			<ul class="clearfloat">
				<li><a href="${root}/vote/voteIndex?activityId=${param.activityId}" ><i class="iconfont icon-home-active"></i><p>首页</p></a></li>
				<li><a href="${root}/vote/voteRankingWeb?activityId=${param.activityId}"><i class="iconfont icon-paimingiconx"></i><p>排名</p></a></li>
				<li><a href="${root}/vote/voteRuleWeb?activityId=${param.activityId}" class="on"><i class="iconfont icon-guize2"></i><p>规则</p></a></li>
			</ul>
		</div>
		
	</div>
	
</body>
</html>