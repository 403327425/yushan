/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-11 23:13:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.console.vote;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.Cookie;
import java.net.URLDecoder;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class activityListIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/console/common/includs.jsp", Long.valueOf(1568165861196L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\r\n");
      out.write("\t\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\r\n");
      out.write("\t\t<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />\r\n");
      out.write("<title>投票大厅</title>\r\n");
      out.write("<!-- JSTL-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--  layui css -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layuiadmin/layui/css/layui.css\"\r\n");
      out.write("\tmedia=\"all\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layuiadmin/style/admin.css\"\r\n");
      out.write("\tmedia=\"all\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layuiadmin/style/login.css\"\r\n");
      out.write("\tmedia=\"all\">\r\n");
      out.write("<!-- JS -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://www.jq22.com/jquery/jquery-3.3.1.js\"></script>\r\n");
      out.write("<script src=\"https://www.jq22.com/jquery/jquery-migrate-1.2.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/globe.js\"></script>\r\n");
      out.write("<!-- ico -->\r\n");
      out.write("<link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/favicon.ico\"\r\n");
      out.write("\ttype=\"image/x-icon\" />\r\n");
      out.write("<link rel=\"bookmark\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/favicon.ico\"\r\n");
      out.write("\ttype=\"image/x-icon\" />");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newcss/common.css\"/>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newcss/fontsize.css\"/>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newcss/reset.css\"/>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newcss/swiper.min.css\"/>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newcss/lobby.css\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newjs/jquery1.11.1.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newjs/swiper.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newjs/common.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\t(function($){\r\n");
      out.write("\t\t$.getUrlParam = function(name)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar reg = new RegExp(\"(^|&)\"+ name +\"=([^&]*)(&|$)\");\r\n");
      out.write("\t\t\tvar r = window.location.search.substr(1).match(reg);\r\n");
      out.write("\t\t\tif (r!=null) return unescape(r[2]); return null;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})(jQuery);\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("function load(){\r\n");
      out.write("\t$(\"#autopicture\").append(\"<div class='swiper-slide' ><img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/AAA.jpg' /></div><div class='swiper-slide' ><img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/BBB.jpg' /></div></div><div class='swiper-slide' ><img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/CCC.jpg' /></div>\");\r\n");
      out.write("\tvar swiper = new Swiper('.swiper-container', {\t\t \t     \r\n");
      out.write("\t     loop:true,\r\n");
      out.write("\t     autoplay: {\r\n");
      out.write("\t         disableOnInteraction: false, //手动滑动之后不打断播放\r\n");
      out.write("\t         delay: 2000\r\n");
      out.write("\t       },\r\n");
      out.write("\t       pagination: {\r\n");
      out.write("\t      el: '.swiper-pagination',\r\n");
      out.write("\t       },\r\n");
      out.write("\t     });\r\n");
      out.write("\tvar nowurl=\"http://xx.light-umbrella.com");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/activityListIndexWeb\";\r\n");
      out.write("\tvar webtype=\"1\";\r\n");
      out.write("\t\r\n");
      out.write("\t\tif($.getUrlParam('from')==\"timeline\"){\r\n");
      out.write("\t\t\tconsole.log($.getUrlParam('from'));\r\n");
      out.write("\t\t\twebtype=\"2\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($.getUrlParam('from')==\"groupmessage\"){\r\n");
      out.write("\t\t\tconsole.log($.getUrlParam('from'));\r\n");
      out.write("\t\t\twebtype=\"3\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($.getUrlParam('from')==\"singlemessage\"){\r\n");
      out.write("\t\t\tconsole.log($.getUrlParam('from'));\r\n");
      out.write("\t\t\twebtype=\"4\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tconsole.log(webtype);\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tconsole.log(\"++++++++++++++\"+nowurl);\r\n");
      out.write("\tvar str02=window.location.href;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t    url :\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/wxInterface/buildSign\", \r\n");
      out.write("\t    type : \"post\", \r\n");
      out.write("\t    data :  {\"url\":nowurl,\"webtype\":webtype},\r\n");
      out.write("\t    dataType : \"json\", \r\n");
      out.write("\t    success : function(data)\r\n");
      out.write("\t    {\r\n");
      out.write("\t \t   console.log(data);\r\n");
      out.write("\t \t  wx.config({\r\n");
      out.write("\t \t\t    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。\r\n");
      out.write("\t \t\t    appId: 'wx5317ce8cdd436edd', // 必填，公众号的唯一标识\r\n");
      out.write("\t \t\t    timestamp:data.timestamp , // 必填，生成签名的时间戳\r\n");
      out.write("\t \t\t    nonceStr:data.nonceStr, // 必填，生成签名的随机串\r\n");
      out.write("\t \t\t    signature: data.signature,// 必填，签名，见附录1\r\n");
      out.write("\t \t\t    jsApiList: ['updateAppMessageShareData'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2\r\n");
      out.write("\t \t\t});\r\n");
      out.write("\t \t\twx.ready(function () {   //需在用户可能点击分享按钮前就先调用\r\n");
      out.write("\t \t\t    wx.updateAppMessageShareData({ \r\n");
      out.write("\t \t\t        title: '活动大厅', // 分享标题\r\n");
      out.write("\t \t\t        desc: '快来给你喜欢的打call', // 分享描述\r\n");
      out.write("\t \t\t        link:nowurl,\r\n");
      out.write("\t \t\t        //link: 'http://xx.light-umbrella.com");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/voteIndex2Web', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致\r\n");
      out.write("\t \t\t        imgUrl: 'http://xx.light-umbrella.com");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/logo3.png', // 分享图标\r\n");
      out.write("\t \t\t        success: function () {\r\n");
      out.write("\t \t\t          // 设置成功\r\n");
      out.write("\t \t\t        }\r\n");
      out.write("\t \t\t    })\r\n");
      out.write("\t \t\t});\r\n");
      out.write("\r\n");
      out.write("\t \t\twx.error(function(res){\r\n");
      out.write("\t \t\t\tconsole.log(res);\r\n");
      out.write("\t \t\t    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。\r\n");
      out.write("\t \t\t});\r\n");
      out.write("\t \t   \r\n");
      out.write("\t    }, \r\n");
      out.write("\t    error: function (XMLHttpRequest, textStatus, errorThrown)\r\n");
      out.write("\t    {\r\n");
      out.write("\t        console.log(XMLHttpRequest);\r\n");
      out.write("\t        console.log(textStatus);\r\n");
      out.write("\t        console.log(errorThrown);\r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t    url :\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/getAllActivity\", \r\n");
      out.write("\t    type : \"post\", \r\n");
      out.write("\t     \r\n");
      out.write("\t    dataType : \"json\", \r\n");
      out.write("\t    success : function(data)\r\n");
      out.write("\t    {\r\n");
      out.write("\t \t   console.log(data);\r\n");
      out.write("\t \t   $('#ActivityList').empty();\r\n");
      out.write("\t \t   var str=\"<ul class='flex'>\";\r\n");
      out.write("\t \t   for(i=data.length-1;i>=0;i--){\t \t\t  \r\n");
      out.write("\t \t\t  var time2 = new Date().valueOf();\t \t\t  \r\n");
      out.write("\t \t\t  \r\n");
      out.write("\t\t \t\t  var unixTimestamp = new Date(data[i].endTime2) ;\r\n");
      out.write("\t\t \t\t  commonTime = unixTimestamp.toLocaleString(); \t\t  \r\n");
      out.write("\t\t \t\t  var unixTimestamp2 = new Date(data[i].startTime) ;\r\n");
      out.write("\t\t \t\t  commonTime2 = unixTimestamp2.toLocaleString();\r\n");
      out.write("\t\t \t\t  //$('#ActivityList').append(\"活动：<a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/voteIndex?activityId=\"+data[i].activityId+\"'>\"+data[i].activityName+\"</a>\\t\\t截至日期：\"+commonTime+\"</br>\");\r\n");
      out.write("\t\t \t\t  var A=getFileBaseName(data[i].picture);\r\n");
      out.write("\t\t \t\t  var state=\"\";\r\n");
      out.write("\t\t \t\t  if(time2<data[i].startTime){\r\n");
      out.write("\t\t \t\t\t state=\"<div class='num c-color05' id=''>待开放</div>\"\r\n");
      out.write("\t\t \t\t  }\r\n");
      out.write("\t\t \t\t  if(time2<data[i].endTime2&&time2>data[i].startTime){\r\n");
      out.write("\t\t \t\t\t state=\"<div class='num c-color03' id=''>进行中</div>\"\r\n");
      out.write("\t\t \t\t  }\r\n");
      out.write("\t\t\t\t  if(time2>data[i].endTime2){\r\n");
      out.write("\t\t \t\t\t state=\"<div class='num c-color04' id=''>已结束</div>\"\r\n");
      out.write("\t\t \t\t  }\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t\tstr+=\"<li><div class='li_tt'><p class='fs-20 c-239'>\"+state+\"</p></div><div class='malist_inbox'><div class='inbox_img'><img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/slt\"+A+\"' /></div><div class='inbox_tt'><p class='fs-25'>\"+data[i].activityName+\"</p></div><div class='inbox_button'><button class='button' onclick='activityIn(\"+data[i].activityId+\")'>进入</button></div></div></li>\"\r\n");
      out.write("\t\t \t\t  \r\n");
      out.write("\t \t\t  \t  /* str+=\"<li><div class='padd'><a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/voteIndex?activityId=\"+data[i].activityId+\"' class='img'><img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/slt\"+A+\"' /></a><div class='tp_dd c-fff'><div class='name c-black'>\"+data[i].activityName+\"</div>\"+state+\"<div class='btn c-fff' onclick='activityIn(\"+data[i].activityId+\")'>进入</div></div></div></li>\"; */\r\n");
      out.write("\t \t\t  \r\n");
      out.write("\t \t   }\r\n");
      out.write("\t \t   str +=\"</ul>\";\r\n");
      out.write("\t \t   $(\"#ActivityList\").append(str);\r\n");
      out.write("\t \t   \r\n");
      out.write("\t    }, \r\n");
      out.write("\t    error: function (XMLHttpRequest, textStatus, errorThrown)\r\n");
      out.write("\t    {\r\n");
      out.write("\t        console.log(XMLHttpRequest);\r\n");
      out.write("\t        console.log(textStatus);\r\n");
      out.write("\t        console.log(errorThrown);\r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("function getFileBaseName(s) {\r\n");
      out.write("\t  var p=s.split(',');\r\n");
      out.write("\t  return p[0];\r\n");
      out.write("}\r\n");
      out.write("Date.prototype.toLocaleString = function() {\r\n");
      out.write("    return this.getFullYear() + \"-\" + (this.getMonth() + 1) + \"-\" + this.getDate() + \"\" ;\r\n");
      out.write("};\r\n");
      out.write("function activityIn(activityId){\r\n");
      out.write("\twindow.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/voteIndex?activityId=\"+activityId+\"\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Date.prototype.Format = function (fmt) {\r\n");
      out.write("    var o = {\r\n");
      out.write("        \"M+\": this.getMonth() + 1, //月份 \r\n");
      out.write("        \"d+\": this.getDate(), //日 \r\n");
      out.write("        \"H+\": this.getHours(), //小时 \r\n");
      out.write("        \"m+\": this.getMinutes(), //分 \r\n");
      out.write("        \"s+\": this.getSeconds(), //秒 \r\n");
      out.write("        \"q+\": Math.floor((this.getMonth() + 3) / 3),\r\n");
      out.write("        \"S\": this.getMilliseconds() //毫秒 \r\n");
      out.write("    }; //季度 \r\n");
      out.write("    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + \"\").substr(4 - RegExp.$1.length));\r\n");
      out.write("    for (var k in o)\r\n");
      out.write("    if (new RegExp(\"(\" + k + \")\").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : ((\"00\" + o[k]).substr((\"\" + o[k]).length)));\r\n");
      out.write("    return fmt;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"load();\">\r\n");
      out.write("\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t<div class=\"head clearfloat\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newimg/logo.png\" />\r\n");
      out.write("\t\t\t\t<div class=\"sh fr\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/newimg/sh.png\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"main\">\r\n");
      out.write("\t\t\t<div class=\"banner_bg\">\r\n");
      out.write("\t\t\t\t<div class=\"banner swiper-container\" >\r\n");
      out.write("\t\t\t\t\t<div class=\"swiper-wrapper\" id=\"autopicture\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"banner_pag swiper-pagination\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"swiper-pagination-bullet\"></span>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"swiper-pagination-bullet\"></span>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"swiper-pagination-bullet\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<form class=\"layui-form\" action=\"\">\r\n");
      out.write("\t\t\t\t\t\t<div align=\"center\" style=\"width:80%;margin-left:10%;padding-bottom:15px;\">\r\n");
      out.write("\t\t\t\t\t\t<select  id=\"schoolName\" name=\"schoolName\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"全部校区\" >全部校区</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"东莞理工学院(松山湖)\" >东莞理工学院(松山湖)</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"东莞理工学院(莞城)\" >东莞理工学院(莞城)</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"广东医科大学(东莞)\" >广东医科大学(东莞)</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"广东创新科技职业学院\" >广东创新科技职业学院</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"东莞职业技术学院\" >东莞职业技术学院</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"广东科技学院\" >广东科技学院</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"中山大学新华学院\" >中山大学新华学院</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"广东酒店管理职业技术学院\" >广东酒店管理职业技术学院</option>\t\t\t\t\t\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"main_a\">\r\n");
      out.write("\t\t\t\t<div class=\"ma_hd flex cur-def\">\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- <div class=\"ma_nav\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">最新</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">热度</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t\t<div class=\"ma_list\" id=\"ActivityList\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"footer\">\r\n");
      out.write("\t\t\t<ul class=\"flex\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/activityListIndexWeb\">\r\n");
      out.write("\t\t\t\t\t<div class=\"foot\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ft_tt center\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"fs-22\">点赞大厅</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/addActivityWeb\">\r\n");
      out.write("\t\t\t\t\t<div class=\"foot\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ft_tt ft_tt2 center\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"fs-22\">发起点赞</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"lobby_4.html\">\r\n");
      out.write("\t\t\t\t\t<div class=\"foot\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ft_tt ft_tt3 center\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"fs-22\">我的主页</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t\tvar swiper = new Swiper('.banner', {\r\n");
      out.write("\t\t\t\t    slidesPerView: 1,\r\n");
      out.write("\t\t\t\t\tspaceBetween: 20,\r\n");
      out.write("\t\t\t\t\tloop: true,\r\n");
      out.write("\t\t\t\t\tpagination: {\r\n");
      out.write("\t\t\t\t\t\tel: '.banner_pag',\r\n");
      out.write("\t\t\t\t\t\tclickable: true,\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/layer/layer.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layuiadmin/layui/layui.js\"></script>\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t  layui.config({\r\n");
      out.write("\t    base: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layuiadmin/' //静态资源所在路径\r\n");
      out.write("\t  }).extend({\r\n");
      out.write("\t    index: 'lib/index' //主入口模块\r\n");
      out.write("\t  }).use(['index','laydate', 'upload','form' ,'jquery'], function(){\r\n");
      out.write("\t  })\r\n");
      out.write("\t  \r\n");
      out.write("\r\n");
      out.write("  </script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/console/common/includs.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("root");
    // /WEB-INF/console/common/includs.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/console/common/includs.jsp(8,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /WEB-INF/console/common/includs.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("productImgUrl");
    // /WEB-INF/console/common/includs.jsp(9,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/console/common/includs.jsp(9,0) 'http://192.168.1.27/hdlw/picture_image/'",_el_expressionfactory.createValueExpression("http://192.168.1.27/hdlw/picture_image/",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }
}
