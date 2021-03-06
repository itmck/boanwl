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
                        <input id="searchName" value="" placeholder="请输入关键字" class="layui-input search_input"
                               type="text">
                    </div>
                    <a class="layui-btn search_btn" id="search" data-type="search">查询</a>
                </div>
                <div class="layui-inline">
                </div>
                <div class="layui-inline">
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>
            </blockquote>
            <div class="weadmin-block demoTable">
                <button class="layui-btn layui-btn-danger" id="delbatch" data-type="getCheckData"><i class="layui-icon">&#xe640;</i>批量删除
                </button>
                <button class="layui-btn" id="addadmin"><i
                        class="layui-icon">&#xe61f;</i>添加
                </button>
            </div>
            <!-- 操作日志 -->
            <div class="layui-form news_list">
                <%--这个是动态的表格--%>
                <table class="layui-hide" id="articleList" lay-filter="demo"></table>
                <script type="text/html" id="operateTpl">
                    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">回复</a>
                    <%--<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>11--%>
                </script>
            </div>
        </div>
    </div>
</section>


<script type="text/javascript">


    layui.use(['table', 'layer'], function () {
        var table = layui.table;
        layer = layui.layer;

        //第一个实例
        table.render({
            elem: '#articleList'
            , url: '../../admin/listPage' //数据接口
            , page: true //开启分页
            , cols: [[
                //field title 列属性
                {type: 'checkbox'},
                {field: 'id', title: '工号', sort: true},//
                {field: 'image',title: '图片',templet:'<div><img src="{{ d.image}}" height="30px" width="35px"></div>'},
                {field: 'adminname', title: '花名'},
                {field: 'realname', title: '用户姓名'},//
                {
                    field: 'sex', title: '性别',
                },
                {field: 'remark', title: '座右铭'},
                {field: 'role', title: '角色'},
                {field: 'tel', title: '电话'},
                {field: 'birthday', title: '生日'},
                {field: 'idcard', title: '身份证号码'}
                // {field: 'statusName', title: '代办状态'},
                /*{fixed: 'right', title: '操作', width: 100, toolbar: '#operateTpl'}*/
            ]],
            //这是前台修改商品状态的方式,由于在后台已经写了 ,在此注释掉即可
            done: function (res, curr, count) {
                hoverOpenImg();
                $("[data-field='sex']").children().each(function () {
                    if ($(this).text() == '0') {
                        $(this).text('女');
                    }
                    if ($(this).text() == '1') {
                        $(this).text('男');
                    }
                });
                $("[data-field='role']").children().each(function () {
                    if ($(this).text() == '0') {
                        $(this).text('超级管理员');
                    }
                    if ($(this).text() == '1') {
                        $(this).text('普通管理员');
                    }
                });
            }
        });
        $("#addadmin").on("click", function () {
            layer.open({
                type: 2,
                title: '添加管理员:',
                shadeClose: true,
                shade: 0.5,
                area: ['900px', '90%'],
                content: './addadmin' //iframe的url

            });
        });

        //监听工具条事件
        /*table.on('tool(demo)', function (obj) {

            var data = obj.data;
            if (obj.event === 'detail') {

                var id = data.id;
                // //发送一个ajax请求
                $.get(
                    './../../getList2',//url
                    {'id': id},
                    function (data) {


                        layer.open({
                            type: 2,
                            title: '留言详情:',
                            shadeClose: true,
                            shade: 0.5,
                            area: ['500px', '90%'],
                            content: 'edit' //iframe的url

                        });

                    }
                )


                layer.msg("您选择的id:" + id);
                layer.msg('ID：' + data.id + ' 的查看操作');
            }

        });*/


        // window.WeAdminShow = function() {
        //
        //     //页面层
        //
        //     layer.open({
        //         type: 2,
        //         title: '留言详情:',
        //         shadeClose: true,
        //         shade: 0.5,
        //         area: ['500px', '90%'],
        //         content: 'edit/' //iframe的url
        //     });
        //
        // }
        //
        //
        // //搜索操作 先获取搜索按钮事件
        $('#search').on('click', function () {

            var type = $(this).data('type');
            //console.log(type);
        //console.log( active[type] );
            active[type] ? active[type].call(this) : '';

        });

        //批量删除的点击事件
        $(".demoTable .layui-btn-danger").click(function () {

            //获取按钮的data-type属性
            var type = $(this).data('type');
            console.log(type);

            active[type] ? active[type].call(this) : '';
        });

        var active = {

            search: function () {

                // alert(5);
                //通过id选择器获取搜索框中的内容
                //val() 单选按钮 复选按钮 文本框
                //text() 文本
                //html() 标签
                var title = $('#searchName').val();
                //判断内容是否为空
                if ($.trim(title).length > 0) {
                    //文本框输入了内容,表格需要重新加载.另外发送一个item请求
                    table.reload('articleList', {

                        page: {curr: 1},
                        //第一个title作为表单数据传出去的key
                        //第二个参数就是js定义的变量(就是我们获取的文本框值)
                        where: {"searchName": title}

                    });

                } else {
                    layer.tips('请一定要输入点什么,阿里嘎多', '#search', {
                        tips: [2, '#ff050a'],
                        time: 4000
                    });
                }


            },

            getCheckData: function () {

                //判断是否有选中行
                //获取选中的行
                var data = table.checkStatus('articleList').data;
                //判断长度
                if (data.length > 0) {

                    console.log(data);
                    // 确认框,至少选中一行数据
                    // 创建一个数组存放选中行的id
                    var ids = [];
                    for (var i = 0; i < data.length; i++) {
                        //遍历选中行,将其id存入数组中
                        ids.push(data[i].id);
                    }
                    //将数组中的id异步提交给后台
                    $.post(
                        '../../admin/batch', //兄弟们在此写上你们的接口地址
                        {'ids[]': ids},
                        function (data) {

                            //至少删除一条记录
                            if (data) {
                                //停留在原来界面并刷新
                                $('.layui-laypage-btn').click();

                                layer.msg("恭喜您,删除成功", {icon: 1});
                            }
                        }
                    )


                } else {
                    layer.tips('请先选中要删除的项', '#delbatch', {
                        tips: [2, '#ff050a'],
                        time: 4000
                    });
                    /*layer.msg('请至少选中一行数据!!!!', {icon: 2});*/

                }
            }

        }
    });
    function hoverOpenImg(){
        var img_show = null; // tips提示
        $('td img').hover(function(){
            //alert($(this).attr('src'));
            var img = "<img class='img_msg' src='"+$(this).attr('src')+"' style='width:130px;' />";
            img_show = layer.tips(img, this,{
                tips:[2, 'rgba(41,41,41,.5)']
                ,area: ['160px']
            });
        },function(){
            layer.close(img_show);
        });
        $('td img').attr('style','max-width:70px');
    }

</script>
</body>
</html>