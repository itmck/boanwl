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
            <label class="layui-form-label">角色</label>
            <div class="layui-input-block">
                <select name="role" lay-verify="required">
                    <option value="0">超级管理员</option>
                    <option value="1">管理员</option>
                </select>
            </div>
            <label class="layui-form-label">性别</label>
            <div  class="layui-input-block">
                <input type="radio" checked="checked"  name="sex" value="1" title="男" ><div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><span>男</span></div>
                <input type="radio" name="sex" value="0" title="女"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>女</span></div>
            </div>
        </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block"  >
            <input type="text" name="adminname" lay-verify="title" autocomplete="off"
                   class="layui-input adminname"  style="border-left-color: white">
        </div>
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block"  >
            <input type="password" name="pwd" lay-verify="title" autocomplete="off"
                   class="layui-input pwd"  style="border-left-color: white">
        </div>
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block"  >
            <input type="password" name="repwd" lay-verify="title" autocomplete="off"
                   class="layui-input repwd" style="border-left-color: white">
        </div>
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-block"  >
            <input type="text" name="realname" lay-verify="title" autocomplete="off"
                   class="layui-input realname"  style="border-left-color: white">
        </div>


        <label class="layui-form-label" >电话</label>
        <div class="layui-input-block" >
            <input type="text" name="tel" lay-verify="title" autocomplete="off" placeholder="请输入收件人手机"
                   class="layui-input tel"  style="border-left-color: white">
        </div>

        <label class="layui-form-label" >生日</label>
        <div class="layui-input-block" >
            <input type="text" name="birthday" lay-verify="title" autocomplete="off" placeholder="yyyy/MM/dd"
                   class="layui-input birthday" style="border-left-color: white">
        </div>

        <label class="layui-form-label" >身份证</label>
        <div class="layui-input-block" >
            <input type="text" name="idcard" lay-verify="title" autocomplete="off" placeholder="请一定要输入身份证号呦"
                   class="layui-input idcard"  style="border-left-color: white">
        </div>



        <lable class="layui-form-label">简介</lable>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="髣髴兮若轻云之蔽月,飘飖兮若流风之回雪" class="layui-textarea requestMsg"  ></textarea>
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
                url: "${pageContext.request.contextPath}/admin/add",
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
