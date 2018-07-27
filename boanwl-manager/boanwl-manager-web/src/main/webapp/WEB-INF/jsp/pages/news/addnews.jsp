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
    <title>添加管理员</title>
    <meta charset="utf-8">
    <title>伯安物流后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/layui/css/layui.css"
          media="all">
</head>
<body>
<div style="border-color: white">

    <form class="layui-form">
    <div class="layui-form-item" >
        <label class="layui-form-label">标题</label>
        <div class="layui-input-block"  >
            <input type="text" name="title" lay-verify="title" autocomplete="off"
                   class="layui-input title"  style="border-left-color: white">
        </div>
        <label class="layui-form-label">内容</label>
        <div class="layui-input-block"  >
            <input type="text" name="content" lay-verify="title" autocomplete="off"
                   class="layui-input content"  style="border-left-color: white">
        </div>
        <%--<label class="layui-form-label">时间</label>--%>
        <%--<div class="layui-input-block"  >--%>
            <%--<input type="text" name="time" lay-verify="title" autocomplete="off"--%>
                   <%--class="layui-input time" style="border-left-color: white">--%>
        <%--</div>--%>
        <label class="layui-form-label">图片</label>
        <div class="layui-input-block"  >
            <input type="text" name="image" lay-verify="title" autocomplete="off"
                   class="layui-input image"  style="border-left-color: white">
        </div>

    </div>
    <hr class="layui-bg-green">


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="demo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.all.js" charset="utf-8">
</script>
<script>

    layui.use(['form', 'jquery', 'layer'], function () {
        var form = layui.form,
            $ = layui.jquery,
            layer = layui.layer;
        form.on('submit(demo)', function (data) {


            $.ajax({
                url: "${pageContext.request.contextPath}/news/save",
                method: "post",
                data: data.field,
                success: function (d) {
                },
                dateType: "json"
            });
            var index = top.layer.msg('正在处理了呢，请一定要耐心等候!', {icon: 16, time: false, shade: 0.8});
            setTimeout(function () {
                top.layer.close(index);
                top.layer.msg("添加成功！");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            }, 200);
            return false;

        });
    });

</script>

</html>
