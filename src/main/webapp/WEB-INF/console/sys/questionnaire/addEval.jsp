<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<title>添加评分标准</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>选择分数区间</legend>
</fieldset>
<div id="showEvalBox" name=showEvalBox class="layui-collapse">

</div>
<div style='width:70%;margin-left:5%;margin-top:30px'>
	<div id="slideTest9" class="demo-slider"></div>
	<div id="test-slider-tips2" style="position:relative; left: 30px; margin-top: 5px;">
	<div id="showSelectBox" style="margin-top:15px">开始值：0&nbsp;&nbsp;&nbsp;&nbsp;结束值：40</div>
	
	<input type="hidden" name="startNumber" id="startNumber" lay-verify="title" autocomplete="off"  class="layui-input" value="0">
	<input type="hidden" name="endNumber" id="endNumber" lay-verify="title" autocomplete="off"  class="layui-input" value="40">
	
	<textarea placeholder="请输入评价信息" name="evalText" id="evalText" class="layui-textarea" style="margin-top:15px;height:60%"></textarea>
	<input type="text" name="evalGrade" id="evalGrade" lay-verify="title" autocomplete="off" placeholder="请输入评分等级" class="layui-input" style="width:150px;float:left;margin-top:10px" >
	<button type="button" class="layui-btn layui-btn-normal addEvalButton" id="addEvalButton" style="margin-top:10px;float:right" onclick="addEvalClick()">添加评价</button>
	</div>
</div>
<div id="updateEvalBox" name='updateEvalBox' style="display:none;padding:0 15px">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>修改评分标准</legend>
</fieldset>
	<div id="slideTest10" class="demo-slider"></div>
	<div id="showSelectBox2" style="margin-top:15px"></div>
	<input type="hidden" name="startNumber2" id="startNumber2" lay-verify="title" autocomplete="off"  class="layui-input" value="0">
	<input type="hidden" name="endNumber2" id="endNumber2" lay-verify="title" autocomplete="off"  class="layui-input" value="40">
	<textarea placeholder="请输入评价信息" name="evalText2" id="evalText2" class="layui-textarea" style="margin-top:15px;height:60%"></textarea>
	<input type="text" name="evalGrade2" id="evalGrade2" lay-verify="title" autocomplete="off" placeholder="请输入评分等级" class="layui-input" style="width:150px;float:right;margin-top:10px" >

</div>
</body>
<script>

layui.use(['element','jquery','layer','slider'], function(){
	var $ = layui.$
	  ,slider = layui.slider,element=layui.element;
	
	  slider.render({
		    elem: '#slideTest9'
		    ,value: 40 //初始值
		    ,range: true //范围选择
		    ,change: function(vals){
		      $('#showSelectBox').html('开始值：'+ vals[0] + '&nbsp;&nbsp;&nbsp;&nbsp;结束值：'+ vals[1]); 
		      $('#startNumber').val(vals[0]);
		      $('#endNumber').val(vals[1]);
		    }
		  });
	  window.showDcwjEvalList=function (){
		  $.ajax({
				url : '${root}/questionnaire/showDcwjEvalEvent',
				data : {dcwjId:"${param.dcwjId}"},
				type : 'POST',
				dataType : 'json',
				success : function(res) {
					console.log(res);
					var str="";
					for (var i=0;i<res.length;i++){
						/* str+=res[i].startNumber+"---------"+res[i].endNumber+"&nbsp;&nbsp;评价等级"+res[i].evalGrade+"<br/>评价"+res[i].evalText; */
						str+="<div class='layui-colla-item'><h2 class='layui-colla-title'><i class='layui-icon'>"+res[i].startNumber+"&nbsp;</i><i class='layui-icon layui-icon-next'>&nbsp;"+res[i].endNumber+"</i> <i class='layui-icon'>&nbsp;&nbsp;&nbsp;&nbsp;"+res[i].evalGrade+"</i><button type='button' class='layui-btn layui-btn-danger layui-btn-xs delEvalButton' id='delEvalButton' style='float:right;margin:0 15px;margin-top:10px' onclick='delEvalClick("+res[i].evalId+")'>删除</button><button type='button' class='layui-btn layui-btn-normal layui-btn-xs updateEvalButton' id='updateEvalButton' style='float:right;margin-top:10px' onclick='updateEvalClick("+res[i].startNumber+","+res[i].endNumber+",\""+res[i].evalGrade+"\",\""+res[i].evalText+"\","+res[i].evalId+")'>编辑</button></h2><div class='layui-colla-content layui-close' id='daListBox1' style='background:#FFF'>"+res[i].evalText+"</div></div>"
					}
					$('#showEvalBox').empty();
					$('#showEvalBox').append(str);
					element.render('collapse');
				}
			});
	  }
	  showDcwjEvalList(); 
	  window.addEvalClick=function (){
		  
		  var startNumber=$('#startNumber').val();
		  var endNumber=$('#endNumber').val();
		  var evalGrade=$('#evalGrade').val();
		  var evalText=$('#evalText').val();
		  
		  
		  $.ajax({
				url : '${root}/questionnaire/addEvalEvent',
				data : {startNumber:startNumber,endNumber:endNumber,evalGrade:evalGrade,evalText:evalText,dcwjId:"${param.dcwjId}"},
				type : 'POST',
				dataType : 'json',
				success : function(res) {
					console.log(res);
					if(res.result_code){
						layer.msg("添加成功");
						showDcwjEvalList(); 
						
					}else{
						layer.msg("添加失败");
					}
				}
			});
		  
	  }
	  
	window.delEvalClick=function (evalId){
		  $.ajax({
				url : '${root}/questionnaire/updateDcwjEvalEvent',
				data : {evalId:evalId,msg:"del"},
				type : 'POST',
				dataType : 'json',
				success : function(res) {
					console.log(res);
					if(res.result_code){
						layer.msg("删除成功");
						showDcwjEvalList(); 
						
						
					}else{
						layer.msg("删除失败");
					}
				}
			});
		  
	  }
	
	
	window.updateEvalClick=function (startNumber,endNumber,evalGrade,evalText,evalId){
		
		
		layer.open({
            type: 1 //此处以iframe举例
            ,title: '修改评价信息'
            ,area: ['1000px', '500px']
            ,shade: 0
            ,maxmin: true 
            ,content: $("#updateEvalBox")
            ,btn: ['修改', '取消'] //只是为了演示
            ,yes: function(){
            	startNumber=$('#startNumber2').val();
      		  	endNumber=$('#endNumber2').val();
      		 	evalGrade=$('#evalGrade2').val();
      		  	evalText=$('#evalText2').val();
            	
            	$.ajax({
    				url : '${root}/questionnaire/updateDcwjEvalEvent',
    				data : {evalId:evalId,startNumber:startNumber,endNumber:endNumber,evalGrade:evalGrade,evalText:evalText,msg:"upd"},
    				type : 'POST',
    				dataType : 'json',
    				success : function(res) {
    					console.log(res);
    					if(res.result_code){
    						layer.closeAll();
    						layer.msg("修改成功");
    						showDcwjEvalList(); 
    						
    						
    					}else{
    						layer.msg("修改失败");
    					}
    				}
    			});
            }
            ,btn2: function(){
              layer.close();
            }
          });
        
        $('#showSelectBox2').html('开始值：'+ startNumber+ '&nbsp;&nbsp;&nbsp;&nbsp;结束值：'+ endNumber); 
        $('#evalGrade2').val(evalGrade);
		$('#evalText2').val(evalText);
        slider.render({
		    elem: '#slideTest10'
		    ,value: [startNumber,endNumber] //初始值
		    ,range: true //范围选择
		    ,change: function(vals){
		      $('#showSelectBox2').html('开始值：'+ vals[0] + '&nbsp;&nbsp;&nbsp;&nbsp;结束值：'+ vals[1]); 
		      $('#startNumber2').val(vals[0]);
		      $('#endNumber2').val(vals[1]);
		      
		    }
		  });
		
		
		
		
		
		
		
		  
		  
	  }
	  
	  
});

</script>
</html>