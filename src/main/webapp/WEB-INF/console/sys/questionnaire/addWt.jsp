<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/console/common/includ.jsp"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<title>添加题目</title>
	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  	<script type="text/javascript" src="${root }/js/md5.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>问题列表</legend>
</fieldset>
<div>
	<div class="layui-collapse" id="wtListBox" name="wtListBox">
<!-- 	  <div class="layui-colla-item">
	    <h2 class="layui-colla-title">杜甫</h2>
	    <div class="layui-colla-content layui-close" id="daListBox1">
	    	<ul>
	    		<li>123</li>
	    		<li>456</li>
	    	</ul>
	    	<textarea placeholder="请输入选项内容" class="layui-textarea" name="wtName" id="wtName"></textarea>    	
	    	<input type="text" name="daText" id="daText" required  lay-verify="required" placeholder="请设置分值" autocomplete="off" class="layui-input" value="" style="width:120px;float:left;margin-left:70%;margin-top:10px">
	    	<button type="button" class="layui-btn layui-btn-warm addWtButton" id="adddaButton" style="margin-left:5px;margin-top:10px">添加选项</button>
	    </div>
	  </div> -->

	</div>
	<div class="layui-input-block" style="width:90%;float:left;margin-left:5%;margin-top:15px">
      <textarea placeholder="请输入问题" class="layui-textarea" name="wtName" id="wtName"></textarea>
    </div>
	<!-- <input type="text" name="wtName" id="wtName" required  lay-verify="required" placeholder="请输入问题" autocomplete="off" class="layui-input" value="" style="width:50%;float:left;margin-left:5%"> -->
	<button type="button" class="layui-btn layui-btn-normal addWtButton" id="addWtButton" style="margin-left:80%;margin-top:10px">添加题目</button>
	
	
</div>
<div id="updateWtBox" name='updateWtBox' style="display:none;">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>修改问题</legend>
  
</fieldset>
<textarea placeholder="请输入问题" class="layui-textarea" name="updwtName" id="updwtName"></textarea>
</div>
</body>
<script>

layui.use(['element','jquery','layer'], function(){
  var element = layui.element;

  $(".addWtButton").click(function(){
	  var wtName=$("#wtName").val();
	  $.ajax({
			url : '${root}/questionnaire/addWtEvent',
			data : {dcwjId:'${param.dcwjId}',wtName:wtName},
			type : 'POST',
			dataType : 'json',
			success : function(res) {
				console.log(res);
				if (res.result_code) {
					toast('添加成功');
				    /* $.ajax({
						url : '${root}/questionnaire/showWtListEvent',
						data : {dcwjId:'${param.dcwjId}'},
						type : 'POST',
						dataType : 'json',
						success : function(res) {
							console.log(res);
							var str="";
							for(var i=0;i<res.length;i++){
								str+="<div class='layui-colla-item'><h2 class='layui-colla-title'>问题"+(i+1)+":"+res[i].wtName+"</h2><div class='layui-colla-content layui-show' id='daListBox"+res[i].wtId+"'><ul id='daListUl"+res[i].wtId+"'></ul><textarea placeholder='请输入选项内容' class='layui-textarea' name='daText"+res[i].wtId+"' id='daText"+res[i].wtId+"'></textarea><input type='text' name='daScore"+res[i].wtId+"' id='daScore"+res[i].wtId+"' required  lay-verify='required' placeholder='请设置分值' autocomplete='off' class='layui-input' value='' style='width:120px;float:left;margin-left:70%;margin-top:10px'><button type='button' class='layui-btn layui-btn-warm adddaButton' id='adddaButton' style='margin-left:5px;margin-top:10px' onclick='addDaClick("+res[i].wtId+")'>添加选项</button></div> </div>";
							}
							$("#wtListBox").html(str);
							$.ajax({
								url : '${root}/questionnaire/showDaListEvent',
								data : {dcwjId:'${param.dcwjId}'},
								type : 'POST',
								dataType : 'json',
								success : function(res) {
									console.log(res);
									for(var i=0;i<res.length;i++){
										var data=res[i];
										var str="";
										var character = new Array("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z");
										for(var j=0;j<data.length;j++){
											str+="<li style=''><span style='text-align:left;display:block;width:70%;float:left'>"+character[j]+":"+data[j].daText+"</span><span style='text-align:left;display:block;width:20%;float:left'>分值："+data[j].daScore+"</span><button type='button' class='layui-btn layui-btn-danger layui-btn-xs delDaButton' id='delDaButton' style='margin-left:15px;float:left' onclick='deldaClick("+data[j].daId+")'>删除</button><br/>&nbsp;</li>";
										}
										if(data.length>0){
											$("#daListUl"+data[0].wtId).empty();
											$("#daListUl"+data[0].wtId).append(str);
										}
									}
								}
							});
							element.render('collapse');
							
							
						}
					}); */
					loadShowWtList();
					
				} else {
					toast('添加失败');
				}
			}
		});
  });
  	window.loadShowWtList=function(){
    $.ajax({
		url : '${root}/questionnaire/showWtListEvent',
		data : {dcwjId:'${param.dcwjId}'},
		type : 'POST',
		dataType : 'json',
		success : function(res) {
			console.log(res);
			var str="";
			for(var i=0;i<res.length;i++){
				var txt=res[i].wtName;
				str+="<div class='layui-colla-item'><h2 class='layui-colla-title'>问题"+(i+1)+":"+res[i].wtName+"<button type='button' class='layui-btn layui-btn-danger layui-btn-xs delWtButton' id='delWtButton' style='float:right;margin:0 15px;margin-top:10px' onclick='delWtClick("+res[i].wtId+")'>删除问题</button><button type='button' class='layui-btn layui-btn-normal layui-btn-xs updateWtButton' id='updateWtButton' style='float:right;margin-top:10px' onclick='updateWtClick(\""+res[i].wtName+"\","+res[i].wtId+")'>编辑问题</button></h2><div class='layui-colla-content layui-show' id='daListBox"+res[i].wtId+"'><ul id='daListUl"+res[i].wtId+"'></ul><textarea placeholder='请输入选项内容' class='layui-textarea' name='daText"+res[i].wtId+"' id='daText"+res[i].wtId+"'></textarea><input type='text' name='daScore"+res[i].wtId+"' id='daScore"+res[i].wtId+"' required  lay-verify='required' placeholder='请设置分值' autocomplete='off' class='layui-input' value='' style='width:120px;float:left;margin-left:70%;margin-top:10px'><button type='button' class='layui-btn layui-btn-warm adddaButton' id='adddaButton' style='margin-left:5px;margin-top:10px' onclick='addDaClick("+res[i].wtId+")'>添加选项</button></div> </div>";
			}
			$("#wtListBox").html(str);
			$.ajax({
				url : '${root}/questionnaire/showDaListEvent',
				data : {dcwjId:'${param.dcwjId}'},
				type : 'POST',
				dataType : 'json',
				success : function(res) {
					console.log(res);
					for(var i=0;i<res.length;i++){
						var data=res[i];
						var str="";
						var character = new Array("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z");
						for(var j=0;j<data.length;j++){
							str+="<li style=''><span style='text-align:left;display:block;width:70%;float:left'>"+character[j]+":"+data[j].daText+"</span><span style='text-align:left;display:block;width:20%;float:left'>分值："+data[j].daScore+"</span><button type='button' class='layui-btn layui-btn-danger layui-btn-xs delDaButton' id='delDaButton' style='margin-left:15px;float:left' onclick='deldaClick("+data[j].daId+")'>删除</button><br/>&nbsp;</li>";
						}
						if(data.length>0){
							$("#daListUl"+data[0].wtId).empty();
							$("#daListUl"+data[0].wtId).append(str);
						}
					}
				}
			});
			element.render('collapse');
		}
	}); 
  	}
  	loadShowWtList();
    window.deldaClick =function (daId){
    	$.ajax({
    		url : '${root}/questionnaire/updateDaListEvent',
    		data : {daId:daId},
    		type : 'POST',
    		dataType : 'json',
    		success : function(res) {
    			console.log(res);
    			if(res.result_code){
    				layer.msg("删除成功");
    			}else{
    				layer.msg("删除失败");
    			}
    			
    			
    			$.ajax({
    				url : '${root}/questionnaire/showWtListEvent',
    				data : {dcwjId:'${param.dcwjId}'},
    				type : 'POST',
    				dataType : 'json',
    				success : function(res) {
    					console.log(res);
    					var str="";
    					for(var i=0;i<res.length;i++){
    						str+="<div class='layui-colla-item'><h2 class='layui-colla-title'>问题"+(i+1)+":"+res[i].wtName+"</h2><div class='layui-colla-content layui-show' id='daListBox"+res[i].wtId+"'><ul id='daListUl"+res[i].wtId+"'></ul><textarea placeholder='请输入选项内容' class='layui-textarea' name='daText"+res[i].wtId+"' id='daText"+res[i].wtId+"'></textarea><input type='text' name='daScore"+res[i].wtId+"' id='daScore"+res[i].wtId+"' required  lay-verify='required' placeholder='请设置分值' autocomplete='off' class='layui-input' value='' style='width:120px;float:left;margin-left:70%;margin-top:10px'><button type='button' class='layui-btn layui-btn-warm adddaButton' id='adddaButton' style='margin-left:5px;margin-top:10px' onclick='addDaClick("+res[i].wtId+")'>添加选项</button></div> </div>";
    					}
    					$("#wtListBox").html(str);
    					$.ajax({
    						url : '${root}/questionnaire/showDaListEvent',
    						data : {dcwjId:'${param.dcwjId}'},
    						type : 'POST',
    						dataType : 'json',
    						success : function(res) {
    							console.log(res);
    							for(var i=0;i<res.length;i++){
    								var data=res[i];
    								var str="";
    								var character = new Array("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z");
    								for(var j=0;j<data.length;j++){
    									str+="<li style=''><span style='text-align:left;display:block;width:70%;float:left'>"+character[j]+":"+data[j].daText+"</span><span style='text-align:left;display:block;width:20%;float:left'>分值："+data[j].daScore+"</span><button type='button' class='layui-btn layui-btn-danger layui-btn-xs delDaButton' id='delDaButton' style='margin-left:15px;float:left' onclick='deldaClick("+data[j].daId+")'>删除</button><br/>&nbsp;</li>";
    								}
    								if(data.length>0){
    									$("#daListUl"+data[0].wtId).empty();
    									$("#daListUl"+data[0].wtId).append(str);
    								}
    							}
    						}
    					});
    					element.render('collapse');
    				}
    			});
    			
    		}
    	});
    }
    
    
    window.addDaClick =function(wtId){
    	var daText=$("#daText"+wtId).val();
    	var daScore=$("#daScore"+wtId).val();
    	if(daText!=""){
    		
    	}else{
    		layer.msg("请输入选项内容");
    	}
    	if(daScore!=""){
    		if(/^\d{1,}$/.test(daScore)){
    			$.ajax({
    				url : '${root}/questionnaire/addDaEvent',
    				data : {wtId:wtId,daText:daText,daScore:daScore},
    				type : 'POST',
    				dataType : 'json',
    				success : function(res) {
    					layer.msg("添加成功");
    					$("#daText"+wtId).val("");
    					$("#daScore"+wtId).val("");
    					$.ajax({
    						url : '${root}/questionnaire/showDaListEvent',
    						data : {dcwjId:'${param.dcwjId}'},
    						type : 'POST',
    						dataType : 'json',
    						success : function(res) {
    							console.log(res);
    							for(var i=0;i<res.length;i++){
    								var data=res[i];
    								var str="";
    								var character = new Array("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z");
    								for(var j=0;j<data.length;j++){
    									str+="<li style=''><span style='text-align:left;display:block;width:70%;float:left'>"+character[j]+":"+data[j].daText+"</span><span style='text-align:left;display:block;width:20%;float:left'>分值："+data[j].daScore+"</span><button type='button' class='layui-btn layui-btn-danger layui-btn-xs delDaButton' id='delDaButton' style='margin-left:15px;float:left' onclick='deldaClick("+data[j].daId+")'>删除</button><br/>&nbsp;</li>";
    								}
    								if(data.length>0){
    									$("#daListUl"+data[0].wtId).empty();
    									$("#daListUl"+data[0].wtId).append(str);
    								}
    							}
    						}
    					});
    					element.render('collapse');
    				}
    			});
    		}else{
    			layer.msg("分值输入格式错误，请输入整数");
    		}
    	}else{
    		layer.msg("请设置分值");
    	}
    }
    
    
    window.delWtClick=function (wtId){
    	layer.confirm('确定要删除该问题', {
    		  btn: ['确定', '取消'] 
    		}, function(index, layero){
    			$.ajax({
					url : '${root}/questionnaire/updateWtListEvent',
					data : {wtId:wtId,msg:"del"},
					type : 'POST',
					dataType : 'json',
					success : function(res) {
						console.log(res);
						if(res.result_code){
							layer.msg("删除成功");
							loadShowWtList();
						}
					}
				});
    			
    		}, function(index){
    		  
    		});
    }
    
    window.updateWtClick=function(wtName,wtId){

        layer.open({
            type: 1 //此处以iframe举例
            ,title: '修改题目信息'
            ,area: ['800px', '400px']
            ,shade: 0
            ,maxmin: true 
            ,content: $("#updateWtBox")
            ,btn: ['修改', '取消'] //只是为了演示
            ,yes: function(){
            	
             	wtName=$('#updwtName').val();
            	$.ajax({
					url : '${root}/questionnaire/updateWtListEvent',
					data : {wtId:wtId,wtName:wtName,msg:"upd"},
					type : 'POST',
					dataType : 'json',
					success : function(res) {
						console.log(res);
						if(res.result_code){
							
							layer.closeAll();
							layer.msg("修改成功");
							loadShowWtList();
								
							
						}
					}
				}); 
            }
            ,btn2: function(){
              layer.close();
            }
          });
        $('#updwtName').val(wtName); 
        
    }
    
}); 
</script>
</html>