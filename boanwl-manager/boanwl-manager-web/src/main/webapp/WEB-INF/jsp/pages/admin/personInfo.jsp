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
			<form class="layui-form col-lg-5" action="" method="post">
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
					<div  class="layui-input-block">
						<input type="radio" checked="checked" id="mail" name="sex" value="男" title="男" ><div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><span>男</span></div>
						<input type="radio" id="femail" name="sex" value="女" title="女"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>女</span></div>
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
					<label class="layui-form-label">座右铭</label>
					<div class="layui-input-block">
						<textarea id="remark" placeholder="既然选择了远方，便只顾风雨兼程；路漫漫其修远兮，吾将上下而求索" value="" class="layui-textarea"></textarea>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','upload','jquery'],function(){
         var form = layui.form()
		 $=layui.jquery;

        $(document).ready(function(){
             $.get(
                 '../../admin/getAdmin' ,//请求个人信息接口
				 {"id":"000001"},
                  function(data){
                 //上传成功后的回调
					  backData=data.data[0];
                 $("#adminname").val(data.data[0].adminname);
                 var role=data.data[0].role == 0? "超级管理员":"管理员";
                 $("#role").val(role);
                 $("#realname").val(data.data[0].realname);
                 $("#tel").val(data.data[0].tel);
                 $("#birthday").val(data.data[0].birthday);
                 $("#idcard").val(data.data[0].idcard);

                 $("#remark").text(data.data[0].remark);
                 if(data.data[0].sex){
                    $(".layui-input-block div")[1].className("layui-unselect layui-form-radio");
                     $(".layui-input-block i")[1].className("layui-anim layui-icon")
                    $(".layui-input-block div")[0].className("layui-unselect layui-form-radio layui-form-radioed");
                     $(".layui-input-block i")[0].className("layui-anim layui-icon layui-anim-scaleSpring")
                 }else{
                     $(".layui-input-block div")[0].className("layui-unselect layui-form-radio");
                     $(".layui-input-block i")[0].className("layui-anim layui-icon");
                     $(".layui-input-block div")[1].className("layui-unselect layui-form-radio layui-form-radioed");
                     $(".layui-input-block i")[1].className("layui-anim layui-icon layui-anim-scaleSpring");


                 }


             },
				 'json'
			 );
		 });
        $("#editbtn").click(function(){$.get(
            '../../admin/updateAdmin' ,//上传接口
            {"id":backData.id,"realname":$("#realname").val(),"sex":backData.sex,"remark":$("#remark").val(),"tel":$("#tel").val(),"birthday":$("#birthday").val(),"idcard":$("#idcard").val()},
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
</body>
</html>