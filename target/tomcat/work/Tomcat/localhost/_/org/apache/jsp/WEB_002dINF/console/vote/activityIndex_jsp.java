/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-20 01:20:47 UTC
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

public final class activityIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/console/common/includs.jsp", Long.valueOf(1568787866456L));
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
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no\">\r\n");
      out.write("<title>投票活动</title>\r\n");
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
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/reset.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://at.alicdn.com/t/font_1288672_bvci6t2kd4v.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/swiper.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/swiper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/Ueditor/ueditor.config.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/Ueditor/ueditor.all.min.js\"> </script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/Ueditor/lang/zh-cn/zh-cn.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body  onload=\"load();\">\r\n");
      out.write("\t<div class=\"warp\">\r\n");
      out.write("\t\t<div class=\"main smain\">\r\n");
      out.write("<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/publish\" name=\"voteForm\"> \r\n");
      out.write("\t\t\t<div class=\"ind_gz\">\r\n");
      out.write("\t\t\t\t<div class=\"tt_com bg-cm c-fff\">\r\n");
      out.write("\t\t\t\t\t<svg class=\"icon icon2\" viewBox=\"0 0 1024 1024\" width=\"100%\" height=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<path d=\"M51.2 310.857143L625.371429 21.942857 987.428571 676.571429l-599.771428 314.514285z\" fill=\"#FFFFFF\">\r\n");
      out.write("\t\t\t\t\t\t</path>\r\n");
      out.write("\t\t\t\t\t\t<path d=\"M548.022857 178.468571c-16.274286 8.265143-39.204571 3.547429-47.542857-12.763428l-46.445714-91.245714c-8.338286-16.274286-1.938286-35.949714 17.627428-45.933715 16.274286-8.301714 39.204571-3.547429 47.542857 12.726857l46.445715 91.245715c5.083429 17.956571-1.316571 37.668571-17.627429 45.933714zM231.936 339.456c-16.274286 8.301714-39.204571 3.547429-47.542857-12.726857L137.984 235.52c-8.301714-16.274286-1.938286-35.949714 17.627429-45.933714 16.310857-8.301714 39.241143-3.547429 47.542857 12.726857l46.445714 91.245714c5.083429 17.92-1.316571 37.632-17.627429 45.933714z m504.685714 337.993143a17.664 17.664 0 0 1-22.784 11.629714l-98.377143-31.963428a17.664 17.664 0 0 1-11.629714-22.820572 17.664 17.664 0 0 1 22.820572-11.629714l98.377142 31.963428c11.483429 6.473143 16.457143 16.237714 11.593143 22.820572z\" fill=\"#F39826\"></path><path d=\"M713.837714 689.115429a17.664 17.664 0 0 0 22.784-11.629715l52.772572-162.304a17.664 17.664 0 0 0-11.629715-22.820571 17.664 17.664 0 0 0-22.820571 11.629714l-52.736 162.304c-1.536 13.092571 3.437714 22.893714 11.629714 22.820572zM650.349714 298.678857L265.837714 494.592c-9.764571 5.010286-19.602286 1.828571-24.576-7.972571-5.010286-9.764571-1.828571-19.602286 7.972572-24.612572L633.782857 266.093714c9.764571-4.973714 19.602286-1.755429 24.576 8.009143 5.010286 9.764571 1.828571 19.602286-7.972571 24.576z m74.715429 146.651429L340.553143 641.243429c-9.764571 4.973714-19.602286 1.792-24.576-8.009143-5.010286-9.764571-1.828571-19.602286 7.972571-24.576l384.512-195.913143c9.764571-4.973714 19.602286-1.792 24.576 7.972571 5.010286 9.801143 1.828571 19.638857-7.972571 24.612572z m-169.691429 271.140571l-140.105143 71.387429c-9.764571 5.010286-19.602286 1.828571-24.612571-7.972572-4.973714-9.764571-1.755429-19.602286 8.009143-24.612571l140.105143-71.387429c9.801143-4.973714 19.638857-1.755429 24.612571 8.009143s-1.462857 21.284571-8.009143 24.576zM290.304 268.726857l162.925714-83.017143-31.561143-61.915428-162.925714 83.017143z\" fill=\"#F39826\"></path><path d=\"M626.980571 19.2l-48.896 24.868571 31.561143 61.952 19.529143-9.984c16.310857-8.301714 39.241143-3.547429 47.542857 12.726858l258.998857 508.342857c8.301714 16.274286 1.901714 35.949714-17.627428 45.933714l-511.634286 260.644571c-16.274286 8.301714-39.204571 3.584-47.506286-12.726857l-258.998857-508.342857c-8.301714-16.274286-1.901714-35.949714 17.627429-45.897143l19.565714-9.984-31.561143-61.915428-48.859428 24.905143C20.845714 328.045714 4.827429 369.005714 23.04 404.845714l290.56 570.258286c16.603429 32.585143 60.891429 46.957714 93.476571 30.354286l573.513143-292.205715c32.548571-16.603429 46.957714-60.854857 30.354286-93.44L720.420571 49.554286c-18.285714-35.84-57.6-48.64-93.44-30.354286z\" fill=\"#F39826\">\r\n");
      out.write("\t\t\t\t\t\t</path>\r\n");
      out.write("\t\t\t\t\t</svg>发表投票活动</div>\r\n");
      out.write("\t\t\t\t<div class=\"bg-fff baoming\" id=\"voteFormDiv\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>标题</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"activityName\" id=\"activityName\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>描述</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <td><textarea name=\"activityDescribe\" id=\"activityDescribe\" cols=\"30\" rows=\"10\"></textarea></td> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\" id=\"activityDescribeChooseBox\"><script id=\"editor\" type=\"text/plain\" style=\"width:100%;height:auto;\"></script><input type=\"hidden\" name=\"activityDescribe\" id=\"activityDescribe\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <td><textarea name=\"activityDescribe\" id=\"activityDescribe\" cols=\"30\" rows=\"10\"></textarea></td> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>开始时间</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input  type=\"date\" name=\"startTime\" id=\"startTime\" ></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>结束时间</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input  type=\"date\" name=\"endTime\" id=\"endTime\" ></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>排序方式</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select  id=\"sortMode\" name=\"sortMode\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"1\" >参与时间倒序</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"2\" >按票数从高到低 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"3\" >编号从低到高</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>投票方式</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select  id=\"voteMode\" name=\"voteMode\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"1\" >固定次数(每个微信号可投票次数)</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"2\" >周期次数(每个微信号每天可投票次数)</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>投票次数</td><td><input type=\"text\" name=\"limitNumber\" id=\"limitNumber\" Placeholder=\"请输入1~100的整数\" value=\"1\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>限定投票</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select  id=\"limitMode\" name=\"limitMode\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"1\" >开启</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"2\" >关闭 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>投票结果</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select  id=\"resultMode\" name=\"resultMode\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"1\" >显示</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"2\" >关闭 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>显示方式</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select  id=\"showMode\" name=\"showMode\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"1\" >双排显示</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <option value=\"2\" >单排显示 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<div class=\"c-999\">上传图片（1-3张）</div>\r\n");
      out.write("\t\t\t\t\t<ul class=\"upload-ul clearfix\">\r\n");
      out.write("\t\t\t\t\t<li class=\"upload-pick\">\r\n");
      out.write("\t\t\t\t\t<div class=\"webuploader-container clearfix\" id=\"goodsUpload\"></div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"btnMore t-c\"><input id=\"ctlBtn\" type=\"button\" value=\"上传图片\" class=\"tt_com bg-cm c-fff\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"btnMore t-c\" ><input type=\"submit\" value=\"立刻发布\" class=\"tt_com bg-cm c-fff\" onclick=\"return btnclick()\"></div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/layer/layer.js\"></script>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layuiadmin/layui/layui.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/webuploader.min.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/diyUpload.js\"></script>\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t$(function(){\r\n");
      out.write("\t\t\t\t//上传图片\r\n");
      out.write("\t\t\t\tvar $tgaUpload = $('#goodsUpload').diyUpload({\r\n");
      out.write("\t\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/saveImage',\r\n");
      out.write("\t\t\t\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\t\tvar str=\"<input type='hidden' name='picture' id='picture02' value=\"+data+\">\";\r\n");
      out.write("\t\t\t\t\t\t$('#voteFormDiv').append(str);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror:function( err ) { },\r\n");
      out.write("\t\t\t\t\tbuttonText : '',\r\n");
      out.write("\t\t\t\t\taccept: {\r\n");
      out.write("\t\t\t\t\t\ttitle: \"Images\",\r\n");
      out.write("\t\t\t\t\t\textensions: 'gif,jpg,jpeg,bmp,png'\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tthumb:{\r\n");
      out.write("\t\t\t\t\t\twidth:120,\r\n");
      out.write("\t\t\t\t\t\theight:120,\r\n");
      out.write("\t\t\t\t\t\tquality:100,\r\n");
      out.write("\t\t\t\t\t\tallowMagnify:true,\r\n");
      out.write("\t\t\t\t\t\tcrop:true,\r\n");
      out.write("\t\t\t\t\t\ttype:\"image/jpeg\"\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tfileNumLimit:3\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script>    $(document).ready(function () {\r\n");
      out.write("\t\t\tvar time = new Date();\r\n");
      out.write("\t\t\tvar day = (\"0\" + time.getDate()).slice(-2);\r\n");
      out.write("\t\t\tvar day2 = (\"0\" + (time.getDate()+1)).slice(-2);\r\n");
      out.write("\t\t\tvar month = (\"0\" + (time.getMonth() + 1)).slice(-2);\r\n");
      out.write("\t\t\tvar today = time.getFullYear() + \"-\" + (month) + \"-\" + (day);\r\n");
      out.write("\t\t\tvar nextDay =time.getFullYear() + \"-\" + (month) + \"-\" + (day2);\r\n");
      out.write("\t\t\t$('#startTime').val(today);\r\n");
      out.write("\t\t\t$('#endTime').val(nextDay);    })\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\tfunction btnclick(){\r\n");
      out.write("\t\t\tvar activityName = $(\"#activityName\").val();\r\n");
      out.write("\t\t\tvar limitNumber = $(\"#limitNumber\").val();\r\n");
      out.write("\t\t\tvar editorBox=document.getElementById(editor);\r\n");
      out.write("\t\t\tif(editorBox!=null){\r\n");
      out.write("\t\t\t\tif(UE.getEditor('editor').hasContents()){\r\n");
      out.write("\t\t\t\t\t$(\"#activityDescribe\").val(UE.getEditor('editor').getContent()); \r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(!activityName){\r\n");
      out.write("\t\t\t\tlayer.msg('请输入活动标题');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(editorBox!=null){\r\n");
      out.write("\t\t\t\tif(!UE.getEditor('editor').hasContents()){\r\n");
      out.write("\t\t\t\t\tlayer.msg('请输入活动概述和规则');\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(!limitNumber){\r\n");
      out.write("\t\t\t\tlayer.msg('请输入投票次数');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(!(/^([1-9]|[1-9]\\\\d|100)$/.test(limitNumber))){\r\n");
      out.write("\t\t\t\tlayer.msg('投票次数请输入1~100');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(!document.getElementById(\"picture02\")){\r\n");
      out.write("\t\t\t\tlayer.msg('请点击确定上传图片');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\tif($(\".diyUploadHover\").length==0){\r\n");
      out.write("\t\t\t\t\tlayer.msg('请上传图片');\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t/* $(\"#uppic\")[0].reset(); */\r\n");
      out.write("\t\t\t$(\".diyUploadHover\").remove();\r\n");
      out.write("\t\t\tlayer.msg('成功提示');\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t\t// \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t var select = document.getElementById(\"voteMode\");\r\n");
      out.write("\t\t var number = document.getElementById(\"limitNumber\");\r\n");
      out.write("\t\t select.onchange=function(){\r\n");
      out.write("             if(select.value==1){\r\n");
      out.write("            \t if(number.value!=\"\"){\r\n");
      out.write("            \t\t layer.msg('每个微信号可投票'+number.value+'次');\r\n");
      out.write("            \t }\r\n");
      out.write("             }else{\r\n");
      out.write("            \t if(number.value!=\"\"){\r\n");
      out.write("            \t\t layer.msg('每个微信号每天可投票'+number.value+'次');\r\n");
      out.write("            \t }\r\n");
      out.write("             }\r\n");
      out.write("         }; \r\n");
      out.write("\t\t</script>\r\n");
      out.write("\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t <script>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t\r\n");
      out.write("\r\n");
      out.write("\t\t </script>\r\n");
      out.write("\t\t <script>\r\n");
      out.write("\t\t\tfunction load(){\r\n");
      out.write("\t\t\t\tvar u = navigator.userAgent;\r\n");
      out.write("\t\t\t\tif (is_weixin() && u.indexOf('Android') > -1) {//安卓手机\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar ue = UE.getEditor('editor',{initialFrameWidth:320,initialFrameHeight:400});\r\n");
      out.write("\t\t\t\t} else if(is_weixin() && u.indexOf('Linux') > -1){//安卓手机\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar ue = UE.getEditor('editor',{initialFrameWidth:320,initialFrameHeight:400});\r\n");
      out.write("\t\t\t\t}else if(is_weixin() && u.indexOf('iPhone') > -1){//苹果手机\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#activityDescribeChooseBox\").empty();\r\n");
      out.write("\t\t\t\t\t$(\"#activityDescribeChooseBox\").append(\"<textarea name='activityDescribe' id='msg' cols='30' rows='10'>\");\r\n");
      out.write("\t\t\t\t}else if (u.indexOf('Windows Phone') > -1) {//winphone手机\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar ue = UE.getEditor('editor',{initialFrameWidth:\"100%\",initialFrameHeight:400});\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tvar ue = UE.getEditor('editor',{initialFrameWidth:\"100%\",initialFrameHeight:400});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction is_weixin() {\r\n");
      out.write("\t\t\t\t   var ua = navigator.userAgent.toLowerCase();\r\n");
      out.write("\t\t\t\t   if (ua.match(/MicroMessenger/i) == \"micromessenger\") {\r\n");
      out.write("\t\t\t\t      return true;\r\n");
      out.write("\t\t\t\t   } else {\r\n");
      out.write("\t\t\t\t      return false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t </script>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
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
