<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人信息</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/personal.css" media="all">
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>个人信息</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="" method="get">
				<div class="layui-form-item">
					<label class="layui-form-label">头像应小于600KB</label>
					<div class="layui-upload">
						<button type="button" class="layui-btn" id="test1">修改头像</button>
						<div class="layui-upload-list">
							<img class="layui-upload file" id="demo1"  name="file" height="150px" width="150px">
							<p id="demoText"></p>
						</div>
					</div>
					<div class="layui-input-block">
						<input id="image_address" type="hidden" name="image" lay-verify="title" autocomplete="off" placeholder="请上传图片" class="layui-input image" >
						<%--<img class="layui-upload file" id="demo1"  name="file" max-height="100px" max-width="100px">--%>
					</div>
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-block">  
						<input type="text" name="title"  autocomplete="off"  class="layui-input layui-disabled" id="adminname" value="" disabled="disabled" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">所属角色</label>
					<div class="layui-input-block">
						<input type="text" name="username"  autocomplete="off" class="layui-input layui-disabled" id="role" value="" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">真实姓名</label>
					<div class="layui-input-block">
						<input type="text" name="username" id="realname"  autocomplete="off" class="layui-input" value="">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号码</label>
					<div class="layui-input-block">
						<input type="text" name="username" id="tel"  autocomplete="off" class="layui-input" placeholder="输入手机号码">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">生日</label>
					<div class="layui-input-block">
						<input type="text" name="username" id="birthday"  autocomplete="off" class="layui-input" placeholder="输入生日">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-block">
						<input type="text" name="username" id="idcard"  autocomplete="off" class="layui-input" placeholder="输入身份证号">
					</div>
				</div>
					<div class="layui-form-item">
						<label class="layui-form-label">性别</label>
						<div class="layui-input-block">
							<input type="radio" name="sex" value="男" title="男">
							<input type="radio" name="sex" value="女" title="女" checked="">
						</div>
					</div>
				<%--<div class="layui-form-item">
					<label class="layui-form-label">修改头像</label>
					<div class="layui-input-block">
						<input type="file" name="file" class="layui-upload-file">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">界面语言</label>
					<div class="layui-input-block">
						<select name="interest" lay-filter="aihao">
							<option value=""></option>
							<option value="0" selected="selected">中文</option>
							<option value="1">英文</option>
						</select>
					</div>
				</div>--%>

				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">简介</label>
					<div class="layui-input-block">
						<textarea id="remark" placeholder="凌波微步,罗袜生尘;体迅微凫,飘忽若神" value="" class="layui-textarea"></textarea>
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button id="editbtn" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['upload','jquery'],function(){
         /*var form = layui.form()*/
		 var $=layui.jquery;

        $(function(){
             $.get(
                 '../../admin/getAdmin' ,//请求个人信息接口
				 {"id":"000001"},
                  function(data){
                 //上传成功后的回调
					  backData=data.data[0];
                 $("#adminname").val(data.data[0].adminname);
                 var rol=data.data[0].role == 0? "超级管理员":"管理员";
                 $("#role").val(rol);
                 $("#realname").val(data.data[0].realname);
                 $("#tel").val(data.data[0].tel);
                 $("#birthday").val(data.data[0].birthday);
                 $("#idcard").val(data.data[0].idcard);
                 $("#demo1").attr('src',data.data[0].image);
                 $("#image_address").val(data.data[0].image)
                 $("#remark").text(data.data[0].remark);

                 if(data.data[0].sex!='0'){

                     /*$("#mail").attr("checked","checked");
                     layui.form.render();*/
                 }else{
                     //alert(data.data[0].sex);
                     //$("#femail").attr("checked",true);
                     //layui.form.render();
                 }


             },
				 'json'
			 );
		 });
        $("#editbtn").on("click",function(){$.get(
            '${pageContext.request.contextPath}/admin/updateAdmin' ,//上传接口
            {"id":backData.id,"realname":$("#realname").val(),"sex":backData.sex,"remark":$("#remark").val(),"tel":$("#tel").val(),"birthday":$("#birthday").val(),"image":$("#image_address").val(),"idcard":$("#idcard").val()},
             function(data){

            } ,
            'json'
        )});
         /*layui.upload({
             url: '../../admin/updateAdmin' ,//上传接口
			 data:{"id":backData.id,"realname":$("#realname").val(),"sex":backData.sex,"remark":$("#remark").val(),"tel":$("#tel").val(),"birthday":$("#birthday").val(),"idcard":$("#idcard").val()},
             success: function(data){

            } ,
			 dataType:'json'
         });*/

	});
</script>
<script>
    layui.use(['upload','jquery'], function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '${pageContext.request.contextPath}/uploadImage'
            ,size:600
            ,accept:'images'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                // $('#image_address').attr('value', dataMap.get("src"));
                $('#image_address').val(res.data.src);//上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    });
</script>
</body>
</html>