/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-05 01:18:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.console.sys.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class candidateList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/console/common/includ.jsp", Long.valueOf(1565056797000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.release();
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

      out.write('\r');
      out.write('\n');
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
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-3.1.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layuiadmin/layui/layui.js\"></script>\r\n");
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
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<title>参赛者列表</title>\r\n");
      out.write("\t<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("  \t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("  \t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n");
      out.write("  \t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/md5.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-content-wrapper\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"search-wrap layui-form\" >\r\n");
      out.write("\t    <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t  \t<input class=\"layui-input\" name=\"activitySelectName\" id=\"activitySelectName\" placeholder=\"活动名称\" autocomplete=\"off\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t  \t<input class=\"layui-input\" name=\"candidateSelectName\" id=\"candidateSelectName\" placeholder=\"姓名\" autocomplete=\"off\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button class=\"layui-btn\" id=\"reloadBtn\" data-type=\"reload\"><i class=\"layui-icon\">&#xe615;</i></button>   \r\n");
      out.write("\t\t<button class=\"layui-btn\"  onclick=\"clearParam()\"><i class=\"layui-icon\">清除</i></button>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"candidateList\" lay-filter=\"candidateList\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<blockquote class=\"layui-elem-quote list_search\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</blockquote>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/html\" id=\"barEdit\">\r\n");
      out.write("  \t\t<a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("  \t\t<a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>\r\n");
      out.write("\t</script>\r\n");
      out.write("<script type=\"text/html\" id=\"pictureTpl\">\r\n");
      out.write("\t{{# if(getFileBaseName3(d.picture)==null){if(getFileBaseName2(d.picture)==null){var A=getFileBaseName(d.picture);}}\r\n");
      out.write("\t\t\t<img src=\"/upload/{{A}}\">\r\n");
      out.write("\t{{#\t}else{var A=getFileBaseName(d.picture);var B=getFileBaseName2(d.picture);}}\r\n");
      out.write("\t\t\t<img src=\"/upload/{{A}}\"><img src=\"/upload/{{B}}\">\r\n");
      out.write("\t{{# }}}\r\n");
      out.write("\t{{#\t}else{var A=getFileBaseName(d.picture);var B=getFileBaseName2(d.picture);var C=getFileBaseName3(d.picture);}}\r\n");
      out.write("\t\t<img src=\"/upload/{{A}}\"><img src=\"/upload/{{B}}\"><img src=\"/upload/{{C}}\">\r\n");
      out.write("\t{{# }}}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/html\" id=\"ActivityNameTpl\">\r\n");
      out.write("\t{{# var name=getActivityName(d.activityId)}}\r\n");
      out.write("\t{{#if(name==\"活动已删除!\"){}}\r\n");
      out.write("\t\t<span style=\"color: #FF0000;\">{{ name }}</span>\r\n");
      out.write("\t{{# }else{}}\r\n");
      out.write("\t\t<span >{{ name }}</span>\r\n");
      out.write("\t{{# }}}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction getActivityName(ID){\r\n");
      out.write("\t\tvar name=\"活动已删除!\";\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/getAllActivityById',\r\n");
      out.write("\t\t\tdata :  \"activityId=\"+ID,\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tasync:false,\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tname=data.activityName;\r\n");
      out.write("\t\t\t\tconsole.log(data.activityName);\r\n");
      out.write("\t\t\t\tconsole.log(name);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\treturn name;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction getFileBaseName(s){\r\n");
      out.write("\t\tvar p=s.split(',');\r\n");
      out.write("\t\treturn p[0];\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction getFileBaseName2(s){\r\n");
      out.write("\t\tvar p=s.split(',');\r\n");
      out.write("\t\tif(p.length>1){\r\n");
      out.write("\t\t\treturn p[1];\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\treturn null;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction getFileBaseName3(s){\r\n");
      out.write("\t\tvar p=s.split(',');\r\n");
      out.write("\t\tif(p.length>2){\r\n");
      out.write("\t\t\treturn p[2];\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\treturn null;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\tfunction clearParam() {\r\n");
      out.write("\t\t$(\".search-wrap  input\").each(function(idx, obj) {\r\n");
      out.write("\t\t\t$(this).val(\"\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\ttableReload();\r\n");
      out.write("\t}\r\n");
      out.write("\tvar fromData={};\r\n");
      out.write("\t  layui.config({\r\n");
      out.write("\t    base: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layuiadmin/' //静态资源所在路径\r\n");
      out.write("\t  }).extend({\r\n");
      out.write("\t    index: 'lib/index' //主入口模块\r\n");
      out.write("\t  }).use(['index','useradmin', 'set','form','layer','jquery','laypage','table','laytpl'],function(){\r\n");
      out.write("\t\t\tvar form = layui.form,table = layui.table,\r\n");
      out.write("\t\t\tlayer = parent.layer == 'undefined' ? layui.layer : parent.layer,\r\n");
      out.write("\t\t\tlaypage = layui.laypage,admin = layui.admin,\r\n");
      out.write("\t\t\t$ = layui.jquery;\r\n");
      out.write("\t\t\t//数据表格\r\n");
      out.write("\t\t\ttable.render({\r\n");
      out.write("\t\t\t\tid:'candidateList',\r\n");
      out.write("\t\t\t    elem: '#candidateList'\r\n");
      out.write("\t\t\t    ,url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/sysGetAllCandidate' //数据接口\r\n");
      out.write("\t\t\t    ,limit:10//每页默认数\r\n");
      out.write("\t\t\t    ,limits:[10,20,30,40]\r\n");
      out.write("\t\t\t    ,cols: [[ //表头\r\n");
      out.write("\t              {field:'candidateName', title: '姓名',minWidth:100}\r\n");
      out.write("\t              ,{field:'activityId', title: '活动名称',minWidth:100,templet:'#ActivityNameTpl'}\r\n");
      out.write("\t              ,{field:'iphone', title: '联系方式',minWidth:100}\r\n");
      out.write("\t              ,{field:'address', title: '地址',minWidth:100}\r\n");
      out.write("\t              ,{field:'candidateDescribe', title: '描述',minWidth:100}\r\n");
      out.write("\t              ,{field:'picture', title: '作品',minWidth:100,templet:'#pictureTpl'}\r\n");
      out.write("\t              ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:120}\r\n");
      out.write("\t\t\t    ]]\r\n");
      out.write("\t\t\t\t\t,page: true //开启分页\r\n");
      out.write("\t\t\t\t\t,where: {timestamp: (new Date()).valueOf()}\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar active = {\r\n");
      out.write("\t\t\t\t\treload : function() {\r\n");
      out.write("\t\t\t\t\t\ttable.reload('candidateList', {\r\n");
      out.write("\t\t\t\t\t\t\twhere : {\r\n");
      out.write("\t\t\t\t\t\t\t\tactivitySelectName : $('#activitySelectName').val(),\r\n");
      out.write("\t\t\t\t\t\t\t\tcandidateSelectName : $('#candidateSelectName').val(),\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$('#reloadBtn').on('click', function() {\r\n");
      out.write("\t\t\t\t\tvar type = $(this).data('type');\r\n");
      out.write("\t\t\t\t\tactive[type] ? active[type].call(this) : '';\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\twindow.tableReload = function tableReload() {\r\n");
      out.write("\t\t\t\t\ttable.reload('candidateList', {\r\n");
      out.write("\t\t\t\t\t\twhere : {\r\n");
      out.write("\t\t\t\t\t\t\tactivitySelectName : $('#activitySelectName').val(),\r\n");
      out.write("\t\t\t\t\t\t\tcandidateSelectName : $('#candidateSelectName').val(),\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//监听工具条\r\n");
      out.write("\t\t\t  table.on('tool(candidateList)', function(obj){\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t    var data = obj.data;\r\n");
      out.write("\t\t\t    console.log(data);\r\n");
      out.write("\t\t\t    if(obj.event === 'del'){\r\n");
      out.write("\t\t\t      layer.confirm('真的删除行么', function(index){\r\n");
      out.write("\t\t\t    \t  $.ajax({\r\n");
      out.write("\t\t\t    \t\t  url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/sysCandidateDel?candidateId='+data.candidateId,\r\n");
      out.write("\t\t\t    \t\t  type : \"get\",\r\n");
      out.write("\t\t\t    \t\t  success : function(res){\r\n");
      out.write("\t\t\t    \t\t\t  if(res.result_code){\r\n");
      out.write("\t\t\t    \t\t\t\t  obj.del();\r\n");
      out.write("\t\t\t    \t\t\t\t  toast('操作成功');\r\n");
      out.write("\t\t\t    \t\t\t\t  table.reload('candidateList', {});\r\n");
      out.write("\t\t\t    \t\t\t  }else{\r\n");
      out.write("\t\t\t    \t\t\t\t  layer.msg(\"权限不足，联系超管！\",{icon: 5});\r\n");
      out.write("\t\t\t    \t\t\t  }\r\n");
      out.write("\t\t\t    \t\t  }\r\n");
      out.write("\t\t\t    \t  });\r\n");
      out.write("\t\t\t        layer.close(index);\r\n");
      out.write("\t\t\t      });\r\n");
      out.write("\t\t\t    } else if(obj.event === 'edit'){\r\n");
      out.write("\t\t\t    \tlayer.open({\r\n");
      out.write("\t\t\t\t          type: 2,\r\n");
      out.write("\t\t\t\t          title : \"修改参赛者信息\",\r\n");
      out.write("\t\t\t\t          content: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/sysCandidateEditWeb?candidateId=\"+data.candidateId,\r\n");
      out.write("\t\t\t\t          maxmin: true,\r\n");
      out.write("\t\t\t\t\t      area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],\r\n");
      out.write("\t\t\t\t\t      btn: ['确定', '取消'],\r\n");
      out.write("\t\t\t\t          btnAlign: 'c',\r\n");
      out.write("\t\t\t\t\t      yes: function(index, layero){\r\n");
      out.write("\t\t\t\t\t        \tvar body = top.layer.getChildFrame('body', index);//找页面下所有套的子类\r\n");
      out.write("\t\t\t\t\t            var inputForm = body.find('#layuiadmin-form-admin');//这是你弹出层 表单对象\r\n");
      out.write("\t\t\t\t\t            if(checkedAdd(inputForm[0])){\r\n");
      out.write("\t\t\t\t\t            \t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/sysCandidateUpdate',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdata : fromData,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsuccess : function(res) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tif (res.result_code) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttoast('操作成功');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttable.reload('candidateList', {});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttoast('修改失败');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},complete:function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t            }\r\n");
      out.write("\t\t\t\t\t        }\r\n");
      out.write("\t\t\t        });\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\r\n");
      out.write("\t\t//添加参赛者\r\n");
      out.write("\t\t$(\".candidateAdd_btn\").click(function(){\r\n");
      out.write("\t\t\tlayer.open({\r\n");
      out.write("\t\t\t\ttype: 2,\r\n");
      out.write("\t\t        title: '新增参赛者',\r\n");
      out.write("\t\t        content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/sysCandidateEditWeb',\r\n");
      out.write("\t\t        maxmin: true,\r\n");
      out.write("\t\t        area: admin.screen() < 2 ? ['90%', '70%'] : ['60%', '60%'],\r\n");
      out.write("\t\t        btn: ['确定', '取消'],\r\n");
      out.write("\t\t        btnAlign: 'c',\r\n");
      out.write("\t\t        yes: function(index, layero){\r\n");
      out.write("\t\t        \tvar body = top.layer.getChildFrame('body', index);//找页面下所有套的子类\r\n");
      out.write("\t\t            var inputForm = body.find('#layuiadmin-form-admin');//这是你弹出层 表单对象\r\n");
      out.write("\t\t            if(checkedAdd(inputForm[0])){\r\n");
      out.write("\t\t            \t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vote/sysCandidateInsert',\r\n");
      out.write("\t\t\t\t\t\t\tdata : fromData,\r\n");
      out.write("\t\t\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(res) {\r\n");
      out.write("\t\t\t\t\t\t\t\tif (res.result_code ) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//toastANDRedirect('添加成功','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sys/adminListView');\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttoast('添加成功');\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttable.reload('candidateList', {});\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttoast('添加失败');\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkedAdd(div) {\r\n");
      out.write("\t\tfromData={};\r\n");
      out.write("\t\t  let candidateId = $(div).find(\"input[name='candidateId']\").val();\r\n");
      out.write("\t\t  let candidateName = $(div).find(\"input[name='candidateName']\").val();\r\n");
      out.write("\t\t  let iphone = $(div).find(\"input[name='iphone']\").val();\r\n");
      out.write("\t\t  let address = $(div).find(\"input[name='address']\").val();\r\n");
      out.write("\t\t  let candidateDescribe = $(div).find(\"textarea[name='candidateDescribe']\").val();\r\n");
      out.write("\t\t  let picture =\"\";\r\n");
      out.write("\t\t  $(div).find(\"input[name='picture']\").each(function(j,item){\r\n");
      out.write("\t\t\t  picture=picture+item.value+\",\";\r\n");
      out.write("\t\t\t  console.log(picture+\"shuju\"); \r\n");
      out.write("\t\t  });\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  if(picture.charAt(picture.length-1)==\",\"){\r\n");
      out.write("\t\t\t  picture=picture.substr(0,picture.length-1);\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  let activityId = $(div).find(\"select[name='activityId']\").val();\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  if ($.trim(candidateName) == '') {\r\n");
      out.write("\t\t\t\tparent.layer.msg('名字不能空');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t  if (!checkPhone(iphone)) {\r\n");
      out.write("\t\t\t\tparent.layer.msg('请输入正确的手机号');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t  if ($.trim(address) == '') {\r\n");
      out.write("\t\t\t\tparent.layer.msg('请输入地址');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t  if ($.trim(candidateDescribe) == '') {\r\n");
      out.write("\t\t\t\tparent.layer.msg('请输入作品描述');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t  if ($.trim(picture) == '') {\r\n");
      out.write("\t\t\t\tparent.layer.msg('请上传作品');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t  if ($.trim(activityId) == '-1') {\r\n");
      out.write("\t\t\t\tparent.layer.msg('请选择活动');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  fromData.candidateId=candidateId;\r\n");
      out.write("\t\t  fromData.candidateName=candidateName;\r\n");
      out.write("\t\t  fromData.iphone=iphone;\r\n");
      out.write("\t\t  fromData.address=address;\r\n");
      out.write("\t\t  fromData.candidateDescribe=candidateDescribe;\r\n");
      out.write("\t\t  fromData.picture=picture;\r\n");
      out.write("\t\t  fromData.activityId=activityId;\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
    // /WEB-INF/console/common/includ.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("root");
    // /WEB-INF/console/common/includ.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/console/common/includ.jsp(8,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/console/common/includ.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("productImgUrl");
    // /WEB-INF/console/common/includ.jsp(9,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/console/common/includ.jsp(9,0) 'http://192.168.1.27/hdlw/picture_image/'",_el_expressionfactory.createValueExpression("http://192.168.1.27/hdlw/picture_image/",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f0 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f0.setParent(null);
    // /WEB-INF/console/sys/system/candidateList.jsp(29,2) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f0.setName("sys:admin:save");
    int _jspx_eval_shiro_005fhasPermission_005f0 = _jspx_th_shiro_005fhasPermission_005f0.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<div class=\"layui-inline\">\r\n");
        out.write("\t\t\t\t<a class=\"layui-btn layui-btn-normal candidateAdd_btn\"><i\r\n");
        out.write("\t\t\t\t\tclass=\"layui-icon\">&#xe608;</i>添加参赛者</a>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f0);
    return false;
  }
}
