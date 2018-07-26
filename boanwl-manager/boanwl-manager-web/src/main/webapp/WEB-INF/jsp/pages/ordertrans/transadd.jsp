<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<h1 align="center">添加流转信息</h1><br/><br/>
<form class="layui-form" >
    <div class="layui-form-item">
        <label class="layui-form-label">运单号</label>
        <div class="layui-input-block">
            <input type="text" value="${orderNum}" name="orderNum" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"  >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">快递员</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入快递员名字" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">到达物流站点</label>
        <div class="layui-input-block">
            <input type="text" name="city" lay-verify="title" autocomplete="off" placeholder="请输入到达站点" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">运单流转备注信息</label>
        <div class="layui-input-block">
            <input type="text" name="msg" lay-verify="title" autocomplete="off" placeholder="请输入到达地" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">物流状态</label>
        <div class="layui-input-block">
            <select name="status" lay-verify="required">
                <option value="">请选择当前状态</option>
                <option value="1">运输中</option>
                <option value="2">派件中</option>
                <option value="3">已签收</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    //Demo
  /*  layui.use(['form','jquery','layer'], function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });*/


    layui.use(['form','jquery','layer'], function(){
        var form = layui.form,
            $=layui.jquery,
            layer=layui.layer;
        form.on('submit(formDemo)', function(data) {
            console.log(data.field);
            $.ajax({
                url:"${pageContext.request.contextPath}/saveTrans",
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
</body>
</html>
