/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-24 02:01:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.console.sys.questionnaire;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class dcwjList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/console/common/includ.jsp", Long.valueOf(1568787866419L));
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
      out.write("\t<title>调查问卷列表</title>\r\n");
      out.write("\t<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("  \t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("  \t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n");
      out.write("  \t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/md5.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px;\">\r\n");
      out.write("  <legend>问卷列表</legend>\r\n");
      out.write("</fieldset>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<button type=\"button\" class=\"layui-btn addDcwjButton\" style=\"width:280px\">创建新问卷</button>\r\n");
      out.write("<table class=\"layui-hide\" id=\"DcwjList\" lay-filter=\"DcwjList\"></table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/html\" id=\"barEdit\">\r\n");
      out.write("  \t<a class=\"layui-btn layui-btn-primary layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("\t<a class=\"layui-btn layui-btn-normal layui-btn-xs\" lay-event=\"addWt\">添加题目</a>\r\n");
      out.write("\t<a class=\"layui-btn layui-btn-warm layui-btn-xs\" lay-event=\"addEven\">设计评分标准</a>\r\n");
      out.write("\t<a class=\"layui-btn layui-btn-xs\" lay-event=\"pub\">发布</a>\r\n");
      out.write("  \t<a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/html\" id=\"stateBox\">\r\n");
      out.write("  \t{{#if(d.state==1){}}\r\n");
      out.write("  \t\t<span style=\"color:#1e9fff\">未添加题目</span>\r\n");
      out.write("\t{{#}else}}\r\n");
      out.write("  \t{{#if(d.state==2){}}\r\n");
      out.write("  \t\t<span style=\"color:#ffb800\">未设计评分标准</span>\r\n");
      out.write("\t{{#}else}}\r\n");
      out.write("  \t{{#if(d.state==3){}}\r\n");
      out.write("  \t\t<span style=\"\">未发布</span>\r\n");
      out.write("\t{{#}else}}\r\n");
      out.write("  \t{{#if(d.state==4){}}\r\n");
      out.write("  \t\t<span style=\"color:#009688\">已发布</span>\r\n");
      out.write("\t{{#}}}\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("var fromData={};\r\n");
      out.write("layui.use(['table','jquery','layer'], function(){\r\n");
      out.write("  var table = layui.table,\r\n");
      out.write("  layer = parent.layer == 'undefined' ? layui.layer : parent.layer;\r\n");
      out.write("  \r\n");
      out.write("  table.render({\r\n");
      out.write("    elem: '#DcwjList'\r\n");
      out.write("    ,url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/showDcwjListEvent'\r\n");
      out.write("    ,toolbar: true\r\n");
      out.write("    ,title: '用户数据表'\r\n");
      out.write("    ,totalRow: true\r\n");
      out.write("    ,cols: [[\r\n");
      out.write("      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}\r\n");
      out.write("      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}\r\n");
      out.write("      ,{field:'startTime', title:'更改时间', width:'20%',templet : \"<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>\"}\r\n");
      out.write("      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}\r\n");
      out.write("    ]]\r\n");
      out.write("    ,page: true\r\n");
      out.write("  });\r\n");
      out.write("  table.on('tool(DcwjList)',function(obj){\r\n");
      out.write("\t var data=obj.data\r\n");
      out.write("\t if(obj.event==='del'){\r\n");
      out.write("\t\t layer.confirm('真的删除么',function(index){\r\n");
      out.write("\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/updateDcwjEvent?dcwjId='+data.dcwjId+'&state='+data.state+'&msg=del',\r\n");
      out.write("\t\t\t\t type:\"get\",\r\n");
      out.write("\t\t\t\t success:function(res){\r\n");
      out.write("\t\t\t\t\t if(res.result_code){\r\n");
      out.write("\t\t\t\t\t\t obj.del();\r\n");
      out.write("\t\t\t\t\t\t toast('操作成功');\r\n");
      out.write("\t\t\t\t\t\t table.reload('adminList', {});\r\n");
      out.write("\t\t\t\t\t }else{\r\n");
      out.write("\t\t\t\t\t\t layer.msg(\"权限不足，联系超管！\",{icon: 5});\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t\t layer.close(index);\r\n");
      out.write("\t\t });\r\n");
      out.write("\t }else if(obj.event=='pub'){\r\n");
      out.write("\t\t if(data.state==\"4\"){\r\n");
      out.write("\t\t\t layer.confirm('确认后取消发布',function(index){\r\n");
      out.write("\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/updateDcwjEvent?dcwjId='+data.dcwjId+'&state='+data.state+'&msg=pub',\r\n");
      out.write("\t\t\t\t\t type:\"get\",\r\n");
      out.write("\t\t\t\t\t success:function(res){\r\n");
      out.write("\t\t\t\t\t\t if(res.result_code){\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t toast('操作成功');\r\n");
      out.write("\t\t\t\t\t\t\t table.render({\r\n");
      out.write("\t\t\t\t\t\t\t\t    elem: '#DcwjList'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/showDcwjListEvent'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,toolbar: true\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,title: '用户数据表'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,totalRow: true\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,cols: [[\r\n");
      out.write("\t\t\t\t\t\t\t\t      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{field:'startTime', title:'更改时间', width:'20%',templet : \"<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>\"}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}\r\n");
      out.write("\t\t\t\t\t\t\t\t    ]]\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,page: true\r\n");
      out.write("\t\t\t\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t\t }else{\r\n");
      out.write("\t\t\t\t\t\t\t layer.msg(\"操作失败\",{icon: 5});\r\n");
      out.write("\t\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t });\r\n");
      out.write("\t\t\t\t layer.close(index);\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t }else{\r\n");
      out.write("\t\t\t var msgtitle01=\"\";\r\n");
      out.write("\t\t\t if(data.state==3){\r\n");
      out.write("\t\t\t\t msgtitle01=\"确认后发布\";\r\n");
      out.write("\t\t\t }else{\r\n");
      out.write("\t\t\t\t msgtitle01=\"题目或评价尚未设置,您确定要发布么\";\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t layer.confirm(msgtitle01,function(index){\r\n");
      out.write("\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/updateDcwjEvent?dcwjId='+data.dcwjId+'&state='+data.state+'&msg=pub',\r\n");
      out.write("\t\t\t\t\t type:\"get\",\r\n");
      out.write("\t\t\t\t\t success:function(res){\r\n");
      out.write("\t\t\t\t\t\t if(res.result_code){\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t toast('操作成功');\r\n");
      out.write("\t\t\t\t\t\t\t table.render({\r\n");
      out.write("\t\t\t\t\t\t\t\t    elem: '#DcwjList'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/showDcwjListEvent'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,toolbar: true\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,title: '用户数据表'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,totalRow: true\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,cols: [[\r\n");
      out.write("\t\t\t\t\t\t\t\t      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{field:'startTime', title:'更改时间', width:'20%',templet : \"<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>\"}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}\r\n");
      out.write("\t\t\t\t\t\t\t\t    ]]\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,page: true\r\n");
      out.write("\t\t\t\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t\t }else{\r\n");
      out.write("\t\t\t\t\t\t\t layer.msg(\"操作失败\",{icon: 5});\r\n");
      out.write("\t\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t });\r\n");
      out.write("\t\t\t\t layer.close(index);\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \r\n");
      out.write("\t }else if(obj.event==='edit'){\r\n");
      out.write("\t\t layer.open({\r\n");
      out.write("\t\t\t\ttype: 2,\r\n");
      out.write("\t\t        title: '修改问卷',\r\n");
      out.write("\t\t        content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/addDcwjWeb?dcwjName='+data.dcwjName,\r\n");
      out.write("\t\t        maxmin: true,\r\n");
      out.write("\t\t        area:['800px', '300px'],\r\n");
      out.write("\t\t        btn: ['确定', '取消'],\r\n");
      out.write("\t\t        btnAlign: 'c',\r\n");
      out.write("\t\t        yes: function(index, layero){\r\n");
      out.write("\t \t        \tvar body = top.layer.getChildFrame('body', index);//找页面下所有套的子类\r\n");
      out.write("\t\t            var inputForm = body.find('#layui_open_box');//这是你弹出层 表单对象\r\n");
      out.write("\t\t            if(checkedAdd(inputForm[0])){\r\n");
      out.write("\t\t            \tfromData.dcwjId=data.dcwjId;\r\n");
      out.write("\t\t            \t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/updateDcwjEvent?msg=upd',\r\n");
      out.write("\t\t\t\t\t\t\tdata : fromData,\r\n");
      out.write("\t\t\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(res) {\r\n");
      out.write("\t\t\t\t\t\t\t\tconsole.log(res);\r\n");
      out.write("\t\t\t\t\t\t\t\tif (res.result_code) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//toastANDRedirect('添加成功','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sys/adminListView');\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttoast('修改成功');\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttable.reload('activityList', {});\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttable.render({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    elem: '#DcwjList'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    ,url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/showDcwjListEvent'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    ,toolbar: true\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    ,title: '用户数据表'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    ,totalRow: true\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    ,cols: [[\r\n");
      out.write("\t\t\t\t\t\t\t\t\t      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t      ,{field:'startTime', title:'更改时间', width:'20%',templet : \"<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>\"}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    ]]\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    ,page: true\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  });\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttoast('修改失败');\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t            } \r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t }else if(obj.event==='addWt'){\r\n");
      out.write("\t\t layer.open({\r\n");
      out.write("\t\t\t\ttype: 2,\r\n");
      out.write("\t\t        title: '添加问题',\r\n");
      out.write("\t\t        content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/addWtWeb?dcwjId='+data.dcwjId,\r\n");
      out.write("\t\t        maxmin: true,\r\n");
      out.write("\t\t        area:['1200px', '600px'],\r\n");
      out.write("\t\t        btn: ['关闭'],\r\n");
      out.write("\t\t        closeBtn: 0,\r\n");
      out.write("\t\t        btnAlign: 'c',\r\n");
      out.write("\t\t        yes: function(index, layero){\r\n");
      out.write("\t\t        \tlayer.close(index);\r\n");
      out.write("\t\t\t\t\ttable.render({\r\n");
      out.write("\t\t\t\t\t    elem: '#DcwjList'\r\n");
      out.write("\t\t\t\t\t    ,url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/showDcwjListEvent'\r\n");
      out.write("\t\t\t\t\t    ,toolbar: true\r\n");
      out.write("\t\t\t\t\t    ,title: '用户数据表'\r\n");
      out.write("\t\t\t\t\t    ,totalRow: true\r\n");
      out.write("\t\t\t\t\t    ,cols: [[\r\n");
      out.write("\t\t\t\t\t      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}\r\n");
      out.write("\t\t\t\t\t      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}\r\n");
      out.write("\t\t\t\t\t      ,{field:'startTime', title:'更改时间', width:'20%',templet : \"<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>\"}\r\n");
      out.write("\t\t\t\t\t      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}\r\n");
      out.write("\t\t\t\t\t    ]]\r\n");
      out.write("\t\t\t\t\t    ,page: true\r\n");
      out.write("\t\t\t\t\t  });\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t }else if(obj.event==='addEven'){\r\n");
      out.write("\t\t layer.open({\r\n");
      out.write("\t\t\t\ttype: 2,\r\n");
      out.write("\t\t        title: '添加评分标准',\r\n");
      out.write("\t\t        content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/addEvalWeb?dcwjId='+data.dcwjId,\r\n");
      out.write("\t\t        maxmin: true,\r\n");
      out.write("\t\t        area:['1200px', '700px'],\r\n");
      out.write("\t\t        btn: ['关闭'],\r\n");
      out.write("\t\t        closeBtn: 0,\r\n");
      out.write("\t\t        btnAlign: 'c',\r\n");
      out.write("\t\t        yes: function(index, layero){\r\n");
      out.write("\t\t        \tlayer.close(index);\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \ttable.render({\r\n");
      out.write("\t\t\t\t\t    elem: '#DcwjList'\r\n");
      out.write("\t\t\t\t\t    ,url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/showDcwjListEvent'\r\n");
      out.write("\t\t\t\t\t    ,toolbar: true\r\n");
      out.write("\t\t\t\t\t    ,title: '用户数据表'\r\n");
      out.write("\t\t\t\t\t    ,totalRow: true\r\n");
      out.write("\t\t\t\t\t    ,cols: [[\r\n");
      out.write("\t\t\t\t\t      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}\r\n");
      out.write("\t\t\t\t\t      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}\r\n");
      out.write("\t\t\t\t\t      ,{field:'startTime', title:'更改时间', width:'20%',templet : \"<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>\"}\r\n");
      out.write("\t\t\t\t\t      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}\r\n");
      out.write("\t\t\t\t\t    ]]\r\n");
      out.write("\t\t\t\t\t    ,page: true\r\n");
      out.write("\t\t\t\t\t  });\r\n");
      out.write("\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t }\r\n");
      out.write("  });\r\n");
      out.write("  $(\".addDcwjButton\").click(function(){\r\n");
      out.write("\t\tlayer.open({\r\n");
      out.write("\t\t\ttype: 2,\r\n");
      out.write("\t        title: '新增问卷',\r\n");
      out.write("\t        content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/addDcwjWeb',\r\n");
      out.write("\t        maxmin: true,\r\n");
      out.write("\t        area:['800px', '300px'],\r\n");
      out.write("\t        btn: ['确定', '取消'],\r\n");
      out.write("\t        btnAlign: 'c',\r\n");
      out.write("\t        yes: function(index, layero){\r\n");
      out.write(" \t        \tvar body = top.layer.getChildFrame('body', index);//找页面下所有套的子类\r\n");
      out.write("\t            var inputForm = body.find('#layui_open_box');//这是你弹出层 表单对象\r\n");
      out.write("\t            if(checkedAdd(inputForm[0])){\r\n");
      out.write("\t            \t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/addDcwjEvent',\r\n");
      out.write("\t\t\t\t\t\tdata : fromData,\r\n");
      out.write("\t\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(res) {\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(res);\r\n");
      out.write("\t\t\t\t\t\t\tif (res.result_code) {\r\n");
      out.write("\t\t\t\t\t\t\t\t//toastANDRedirect('添加成功','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sys/adminListView');\r\n");
      out.write("\t\t\t\t\t\t\t\ttoast('添加成功');\r\n");
      out.write("\t\t\t\t\t\t\t\ttable.reload('activityList', {});\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t\t\t\ttable.render({\r\n");
      out.write("\t\t\t\t\t\t\t\t    elem: '#DcwjList'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionnaire/showDcwjListEvent'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,toolbar: true\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,title: '用户数据表'\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,totalRow: true\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,cols: [[\r\n");
      out.write("\t\t\t\t\t\t\t\t      {field:'dcwjName', title:'问卷名称', width:'40%', edit: 'text'}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{field:'state', title:'状态', width:'20%',templet :'#stateBox'}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{field:'startTime', title:'更改时间', width:'20%',templet : \"<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd HH:mm:ss')}}</div>\"}\r\n");
      out.write("\t\t\t\t\t\t\t\t      ,{title: '操作',toolbar: '#barEdit',fixed:'right',width:'20%'}\r\n");
      out.write("\t\t\t\t\t\t\t\t    ]]\r\n");
      out.write("\t\t\t\t\t\t\t\t    ,page: true\r\n");
      out.write("\t\t\t\t\t\t\t\t  });\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\ttoast('添加失败');\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t            } \r\n");
      out.write("\t        }\r\n");
      out.write("\t\t});\r\n");
      out.write("  });\r\n");
      out.write("});\r\n");
      out.write("function checkedAdd(div){\r\n");
      out.write("\tfromData={};\r\n");
      out.write("\tlet dcwjName = $(div).find(\"input[name='dcwjName']\").val();\r\n");
      out.write("\tif ($.trim(dcwjName) == '') {\r\n");
      out.write("\t\tparent.layer.msg('名称不能空');\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tfromData.dcwjName=dcwjName;\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
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
}
