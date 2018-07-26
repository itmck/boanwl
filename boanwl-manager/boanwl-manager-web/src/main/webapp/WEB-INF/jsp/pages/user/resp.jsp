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
    <title>运单流转记录</title>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/layui/css/layui.css"
          media="all">
</head>
<body>
<div style="border-color: white">
    <div class="layui-form-item" >
        <label class="layui-form-label">留言类型</label>
        <div class="layui-input-block"  >
            <input type="text" name="theme" lay-verify="title" autocomplete="off"
                   class="layui-input theme" readonly="true" style="border-left-color: white">
        </div>
        <label class="layui-form-label">客户姓名</label>
        <div class="layui-input-block"  >
            <input type="text" name="uname" lay-verify="title" autocomplete="off"
                   class="layui-input uname" readonly="true" style="border-left-color: white">
        </div>
        <label class="layui-form-label" >客户手机</label>
        <div class="layui-input-block" >
            <input type="text" name="utel" lay-verify="title" autocomplete="off" placeholder="请输入收件人手机"
                   class="layui-input utel" readonly="true" style="border-left-color: white">
        </div>
    </div>

    <div class="layui-card">
        <div class="layui-form-label">留言内容</div>
        <div class="layui-input-block">
            <textarea name="desc" placeholder="请输入内容" class="layui-textarea requestMsg" readonly="true" ></textarea>
        </div>
    </div>
</div>
<hr class="layui-bg-green">

<div>
<form class="layui-form">
    <div class="layui-card">
        <input type="hidden" name="orderNo" class="orderNo" value=""/>
        <label class="layui-form-label">回复内容</label>
        <div class="layui-input-block">
            <textarea name="respMsg" placeholder="请输入内容" class="layui-textarea responseDetail"  ></textarea>

        </div>
    </div>
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
                url: "${pageContext.request.contextPath}/mck/resp",
                method: "put",
                data: data.field,
                success: function (d) {

                },
                dateType: "json"
            });
            var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
            setTimeout(function () {
                top.layer.close(index);
                top.layer.msg("修改成功！");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            }, 200);
            return false;

        });
    });

</script>

</html>
