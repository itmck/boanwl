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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" media="all">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>

</head>
<body>
<section class="layui-larry-box">
    <div class="larry-personal">
        <div class="layui-tab">
            <blockquote class="layui-elem-quote news_search">

                <div class="layui-inline">
                    <div class="layui-input-inline">
                        <input value="" placeholder="请输入关键字" class="layui-input search_input" type="text">
                    </div>
                    <a class="layui-btn search_btn">查询</a>
                </div>
                <div class="layui-inline">
                </div>
                <div class="layui-inline">
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>
            </blockquote>
            <%--<div class="weadmin-block demoTable">
                <button class="layui-btn layui-btn-danger" data-type="getCheckData"><i class="layui-icon">&#xe640;</i>批量删除
                </button>
                <button class="layui-btn" onclick="WeAdminShow('添加商品','./add2',600,500)"><i class="layui-icon">&#xe61f;</i>添加
                </button>
            </div>--%>
            <!-- 操作日志 -->
            <div class="layui-form news_list">
                <%--这个是动态的表格--%>
                <table class="layui-hide" id="articleList"></table>
                <script type="text/html" id="operateTpl">
                    <a title="回复" onclick="WeAdminEdit('回复','./edit', 2, 600, 400)" href="javascript:;">
                        <i class="layui-icon" style="font-size: 20px">&#xe609;</i>
                    </a>
                    <%--<a class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i>回复</a>--%>
                    <a title="删除" href="javascript:;">
                        <i class="layui-icon" style="font-size: 20px">&#xe640;</i>
                    </a>
                </script>
            </div>

        </div>
    </div>


</section>


<script type="text/javascript">

    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#articleList'
            , url: '../../items' //数据接口
            , page: false //开启分页
            , cols: [[
                //field title 列属性
                {type: 'checkbox'},
                {field: 'seId', title: '用户Id', sort: true},
                {field: 'receiverPhone', title: '电话'},//
                 {field: 'receiverAddress', title: '收货地址'},
                // {field: 'address', title: '收件地址'},
                // {field: 'requestMsg', title: '留言信息'},
                // {field: 'status', title: '代办状态'},
                {fixed: 'right', width:150, align:'center', toolbar: '#operateTpl'}
            ]],
        });

    });



</script>
</body>
</html>