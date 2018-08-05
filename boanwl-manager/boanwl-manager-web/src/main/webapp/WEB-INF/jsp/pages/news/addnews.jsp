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
    <title>添加新闻</title>
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

    <form class="layui-form" >
        <div class="layui-form-item" >
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block"  >
                <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                       class="layui-input title"  style="border-left-color: white">
            </div>
            <label class="layui-form-label">内容</label>
            <div class="layui-input-block"  >
                <textarea name="content" placeholder="请输入内容" class="layui-textarea content" rows="12" ></textarea>
                <%--<input type="text" name="content" lay-verify="title" autocomplete="off"--%>
                <%--class="layui-input content"  style="border-left-color: white">--%>
            </div>
            <label class="layui-form-label" >时间</label>
            <div class="layui-input-block" >
                <input type="text" name="time" lay-verify="title" autocomplete="off" placeholder="yyyy-MM-dd"
                       class="layui-input time" style="border-left-color: white">
            </div>
            <%--<label class="layui-form-label">时间</label>--%>
            <%--<div class="layui-input-block"  >--%>
            <%--<input type="text" name="time" lay-verify="title" autocomplete="off"--%>
            <%--class="layui-input time" style="border-left-color: white">--%>
            <%--</div>--%>
            <label class="layui-form-label">配图-小于60KB</label>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test1">上传图片</button>
                <%--<div class="layui-upload-list">--%>
                <div>
                    <img class="layui-upload-img" id="demo1"  name="file" height="300px" max-width="300px">
                    <p id="demoText"></p>
                </div>
            </div>
            <div class="layui-input-block"  >
                <input type="hidden" name="image" lay-verify="title" autocomplete="off"
                       class="layui-input image"  style="border-left-color: white" id="image_address">
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
<script>
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '${pageContext.request.contextPath}/uploadImage'
            ,size:60
            ,accept:'image'
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
</html>
