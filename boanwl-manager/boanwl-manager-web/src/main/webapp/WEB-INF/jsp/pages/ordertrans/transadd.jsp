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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css"
          media="all">
</head>
<body>
<form class="layui-form" action="" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">运单号</label>
        <div class="layui-input-block">
            <input type="text" name="orderNum" lay-verify="title" autocomplete="off" placeholder="请输入运单号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">到达地点</label>
        <div class="layui-input-block">
            <input type="text" name="city" lay-verify="title" autocomplete="off" placeholder="请输入到达地" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">运单状态</label>
        <div class="layui-input-block">
            <select name="status" lay-filter="title">
                <option value="">请选择当前状态</option>
                <option value="1">运输中</option>
                <option value="2">派件中</option>
                <option value="3">已签收</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">运单流转备注信息</label>
        <div class="layui-input-block">
            <input type="text" name="msg" lay-verify="title" autocomplete="off" placeholder="请输入到达地" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>
