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
                        <input value="" placeholder="请输入关键字" class="layui-input search_input" type="text">
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
                <button class="layui-btn layui-btn-danger" data-type="getCheckData"><i class="layui-icon">&#xe640;</i>批量删除
                </button>
                <button class="layui-btn" onclick="WeAdminShow('添加商品','./add2',600,500)"><i
                        class="layui-icon">&#xe61f;</i>添加
                </button>
            </div>
            <!-- 操作日志 -->
            <div class="layui-form news_list">
                <%--这个是动态的表格--%>
                <table class="layui-hide" id="articleList"></table>
                <script type="text/html" id="operateTpl">
                    <a title="回复" onclick="WeAdminEdit('回复','./edit', 2, 600, 400)" href="javascript:;"
                       data-url="${pageContext.request.contextPath}/pages/admin/list">
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
                , url: '../../getList' //数据接口
                , page: false //开启分页
                , cols: [[
                    //field title 列属性
                    {type: 'checkbox'},
                    {field: 'id', title: 'ID', sort: true},//
                    {field: 'adminname', title: '名字'},
                    {field: 'realname', title: '真实姓名'},//
                    {field: 'tel', title: '电话'},
                    // {field: 'address', title: '收件地址'},
                    // {field: 'requestMsg', title: '留言信息'},
                    // {field: 'status', title: '代办状态'},
                    {fixed: 'right', width: 100, align: 'center', toolbar: '#operateTpl'}
                ]],
            });


            //搜索操作 先获取搜索按钮事件
            $('#search').on('click', function () {

                var type = $(this).data('type');
                //console.log(type);
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
                    var title = $('#title').val();
                    //判断内容是否为空
                    if ($.trim(title).length > 0) {
                        //文本框输入了内容,表格需要重新加载.另外发送一个item请求
                        table.reload('articleList', {

                            page: {curr: 1},
                            //第一个title作为表单数据传出去的key
                            //第二个参数就是js定义的变量(就是我们获取的文本框值)
                            where: {title: title}

                        });

                    } else {

                        layer.msg('亲,您未输入任何东西', {icom: 1});
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
                            '../../item/batch', //兄弟们在此写上你们的接口地址
                            {'ids[]': ids},
                            function (data) {

                                //至少删除一条记录
                                if (data > 0) {
                                    //停留在原来界面并刷新
                                    $('.layui-laypage-btn').click();
                                    layer.msg("恭喜您,删除成功", {icon: 1});
                                }
                            }
                        )


                    } else {

                        layer.msg('请至少选中一行数据!!!!', {icon: 2});

                    }


                }


            }
        }
    );


</script>
</body>
</html>