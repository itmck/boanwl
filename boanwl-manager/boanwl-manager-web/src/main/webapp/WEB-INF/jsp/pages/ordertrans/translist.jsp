<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运单列表</title>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css"
          media="all">
</head>
<body>

<div class="layui-inline">
    <div class="layui-input-inline">
        <input value="" placeholder="请输入关键字" class="layui-input search_input" type="text">
    </div>
    <a class="layui-btn search_btn" id="search" data-type="search">查询</a>
</div>
<table class="layui-hide" id="test"></table>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'../../showOrder'   //路径
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1
            ,page:true
            ,cols: [[

                {field:'orderNum', width:80, title: '运单号'}
                ,{field:'city', width:80, title: '城市'}
                ,{field:'statusName', width:80, title: '状态'}
                ,{field:'name', width:80, title: '快递员'}
                ,{field:'dateCreated', width:137, title: '时间', sort: true}
                ,{field:'msg', width:80, title: '快件操作记录'}
                ,{title:'<b>操作选项</b>',fixed:'right',width: 180,align : 'center',toolbar : '#trans-toolbar'}
            ]]
        });

    });
</script>

<script type="text/html" id="trans-toolbar">
    <button class="layui-btn layui-btn-xs" lay-event="add">添加</button>
    <button class="layui-btn layui-btn-xs" lay-event="edit">编辑</button>
    <%--<button class="layui-btn layui-btn-xs" lay-event="add">添加</button>--%>
</script>
</body>
</html>
