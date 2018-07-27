<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻修改</title>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css"
          media="all">
</head>
<body>
<form class="layui-form" >
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <div class="layui-input-block">
            <input type = "hidden" name ="id" lay-verify="title" autocomplete="off" placeholder="编号" class="layui-input id">
            <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input title">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">内容</label>
        <div class="layui-input-block">
            <input type="text"  name="content" lay-verify="title" autocomplete="off" placeholder="请输入内容" class="layui-input content">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图片地址</label>
        <div class="layui-input-block">
            <input type="text" name="image" lay-verify="title" autocomplete="off" placeholder="请输入图片" class="layui-input image">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="demo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.all.js" charset="utf-8">
</script>
<script>

    layui.use(['form','jquery','layer'], function(){
        var form = layui.form,
            $=layui.jquery,
            layer=layui.layer;
        form.on('submit(demo)', function(data) {
            console.log(data.field);
            $.ajax({
                url:"${pageContext.request.contextPath}/news/update",
                method:"put",
                data:data.field,
                success:function(d) {
                },
                dateType:"json"
            });
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            setTimeout(function(){
                top.layer.close(index);
                top.layer.msg("修改成功！");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            },200);
            return false;


        });
    });

</script>
</html>
