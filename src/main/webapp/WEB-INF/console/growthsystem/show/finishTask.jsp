<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="/WEB-INF/console/common/GrowthSystemInclude.jsp" %>
    <!DOCTYPE html>
    <html>
      
      <head>
        <meta charset="utf-8">
        <title>打卡审核</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
        <link rel="stylesheet" type="text/css" href="${root}/GS/css/common.css" />
        <link rel="stylesheet" type="text/css" href="${root}/GS/css/fontsize.css" />
        <link rel="stylesheet" type="text/css" href="${root}/GS/css/reset.css" />
        <link rel="stylesheet" type="text/css" href="${root}/GS/css/swiper.min.css" />
        <link rel="stylesheet" type="text/css" href="${root}/GS/css/sub.css" />
        <script src="${root}/GS/js/jquery1.11.1.min.js"></script>
        <script src="${root}/GS/js/swiper.min.js"></script>
        <script src="${root}/GS/js/common.js"></script>
        <script src=https://res2.wx.qq.com/open/js/jweixin-1.4.0.js></script>
        <script src="${root}/GS/js/wxSign.js"></script>
        <title></title>
      </head>
      
      <body>
        <div class="header">
          <div class="head">
            <img src="${root}/GS/img/logo.png" /></div>
        </div>
        <div class="sub_main">
          <div class="sub_banner sub_banner1">
            <img src="${root}/GS/img/sub4_logo.png" /></div>
          <div class="sub_input">
            <div class="sub4_role">${param.taskName}</div>
            <ul>
              <li>
                <span class="fs-25">${param.taskText}</span></li>
              <li>
                <textarea name="examineText" id="examineText" placeholder="请输入内容" class="layui-textarea"></textarea>
              </li>
            </ul>
          </div>

          <div class="upload fs-25">上传图片　(1-3张)
            <ul class="upload-ul">
              <li class="upload-pick">
                <div class="webuploader-container" id="goodsUpload"></div></li>
            </ul>
            <div class="sub5_submit">
              <button type="button" id="ctlBtn"></button>
              <button type="button" onclick="ExamineClick()">
                <img src="${root}/GS/img/sub4_button_bg.png" /></button>
            </div>
          </div>
          <textarea id="demo" style="display: none;"></textarea>
          <script type="text/javascript" src="${root}/GS/js/layer/layer.js"></script>
          <script src="${root}/GS/js/webuploader.min.js?v=0.0.0.3"></script>
          <script src="${root}/GS/js/diyUpload.js?v=0.0.0.3"></script>
          <script>var openid = getCookie("openid");
            var count = 0;
            var count2 = 0;
            var str = "";
            $(function() {

              /* var pictureUrl="{\"url\":\""+str+"\"}"; */
              GetSige("不遗憾清单", "个人任务审核页");
              //上传图片
              var $tgaUpload = $('#goodsUpload').diyUpload({
                url: '${root}/personGrowth/savePictureEvent',
                success: function(data) {
                  console.log(data);
                  str += "\"" + data + "\",";
                  console.log(str);
                  count++;
                  var examineText = $("#examineText").val();
                  if (count2 == count) {

                    console.log("开始上传");
                    $.ajax({
                      url: '${root}/personGrowth/saveExamineList',
                      type: "post",
                      data: {
                        examineText: examineText,
                        examineUrl: str,
                        taskId: "${param.taskId}",
                        openid: openid
                      },
                      dataType: "json",
                      success: function(res) {
                        console.log(res);
                        if (res.result_code) {
                          window.location.href = '${root}/personGrowth/myTaskWeb';
                          layer.msg("已成功提交审核,请等待审核通过");

                        } else {
                          layer.msg("提交失败。");
                        }
                      }
                    });
                  }
                },
                error: function(err) {},
                buttonText: '',
                accept: {
                  title: "Images",
                  extensions: 'gif,jpg,jpeg,bmp,png'
                },
                thumb: {
                  width: 120,
                  height: 120,
                  quality: 100,
                  allowMagnify: true,
                  crop: true,
                  type: "image/jpeg"
                },
                fileNumLimit: 3
              });
            });
            var ExamineClick = function() {
              count2 = $(".diyUploadHover").length;
              $('#ctlBtn').trigger("click");
            }
            function getCookie(c_name) {
              if (document.cookie.length > 0) {
                c_start = document.cookie.indexOf(c_name + '=');
                if (c_start != 1) {
                  c_start = c_start + c_name.length + 1;
                  c_end = document.cookie.indexOf(";", c_start);
                  if (c_end == -1) {
                    c_end = document.cookie.length;
                  }
                  return unescape(document.cookie.substring(c_start, c_end));
                }
              }
              return "";
            }</script>
        </div>
        

        <div class="footer">
          <ul class="flex">
            <li>
              <a href="${root}/personGrowth/newMainWeb">
                <div class="foot foot_1">
                  <div class="ft_tt center">
                    <p class="fs-14">首页</p></div>
                </div>
              </a>
            </li>
            <li>
              <a href="${root}/personGrowth/myTaskWeb">
                <div class="foot">
                  <div class="ft_tt ft_tt2 center">
                    <p class="fs-14">清单</p></div>
                </div>
              </a>
            </li>
            <li>
              <a href="${root}/personGrowth/personWeb">
                <div class="foot">
                  <div class="ft_tt ft_tt3 center">
                    <p class="fs-14">我的</p></div>
                </div>
              </a>
            </li>
          </ul>
        </div>
      </body>
      <script type="text/javascript" src="${root}/layuiadmin/layui/layui.js"></script>
      <script type="text/javascript" src="${root}/js/layer.js"></script>
      <script>layui.use(['element', 'jquery', 'layer', 'slider', 'table', 'form'],
        function() {
          var $ = layui.$,
          layer = layui.layer,
          table = layui.table,
          form = layui.form;
        });</script>
    </html>