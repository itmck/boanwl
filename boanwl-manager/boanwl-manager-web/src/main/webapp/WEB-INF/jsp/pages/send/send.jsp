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
    <meta name="renderer" content="webkit">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" media="all">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>

    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>


</head>
<body>
<section class="layui-larry-box">
    <div class="larry-personal">
        <div class="layui-tab">
            <blockquote class="layui-elem-quote news_search">

                <div class="layui-inline">
                    <div class="layui-input-inline">
                        <input id="searchName" placeholder="请输入关键字" class="layui-input search_input" type="text">
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


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/javascript">




    layui.use(['table', 'layer'], function () {
        var table = layui.table;
        form = layui.form,
        $ = layui.jquery,
        layer = layui.layer;

            //第一个实例
            table.render({
                elem: '#articleList'
                , url: '../../send/list' //数据接口
                , page: true //开启分页
                , cols: [[
                    //field title 列属性
                    {type: 'checkbox'},
                    {field: 'seId', title: '运单号', sort: true},//
                    {field: 'senderName', title: '寄件人姓名'},
                    {field: 'senderIdNumber', title: '寄件人身份证号'},//
                    {field: 'senderAddress', title: '地址'},
                    {field: 'senderAdderssDetail', title: '详细地址'},
                    {field: 'receiverName', title: '收件人姓名'},
                    {field: 'receiverPhone', title: '收件人号码'},
                    {field: 'receiverAddress', title: '收件地址'},
                    {field: 'totalPrice', title: '价钱'},
                    {fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}

                ]],
            });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
           if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        url:"../../send//update/" + data.seId,
                        method:"put",
                        dateType:"json",
                        success:function(data) {
                            if (data.update_code =="0") {
                                $('.layui-laypage-btn').click();
                                layer.msg("恭喜您,删除成功", {icon: 1});

                            }
                        }

                    })
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
               var item = obj.data;
              var index =  layer.open({
                        type: 2,
                        title: "订单号:" + "  " + item.seId,
                        maxmin: true,
                        area: ['500px', '400px'],
                        content: 'sendmodify',

                        success: function(layero, index){
                            var body = layui.layer.getChildFrame('body', index);

                                body.find(".receiverName").val(item.receiverName);     //登录名
                                body.find(".receiverPhone").val(item.receiverPhone);
                                body.find(".receiverAddress").val(item.receiverAddress);
                                body.find(".receiverAdderssDetail").val(item.receiverAdderssDetail);
                                body.find(".seId").val(item.seId);
                                form.render();


                      },

                        end: function () {

                            layer.tips('啊,我要走了', '#about', {tips: 1})

                        }
                    })
            }
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
                    //text() 文本
                    //html() 标签
                    var title = $('#searchName').val();

                        table.reload('articleList', {

                            page: {curr: 1},
                            //第一个title作为表单数据传出去的key
                            //第二个参数就是js定义的变量(就是我们获取的文本框值)
                            where: {sid: title}

                        });
                },

                getCheckData: function () {

                    //判断是否有选中行
                    //获取选中的行
                    var data = table.checkStatus('articleList').data;
                    //判断长度
                    if (data.length > 0) {

                        console.log(data);
                        var ids = [];
                        for (var i = 0; i < data.length; i++) {

                            ids.push(data[i].seId);
                        }

                        $.ajax({
                            url: "../../send/updateIds",
                            method: "put",
                            data: {"sids[]": ids},
                            success: function (data) {
                                if (data.update_code == "0") {
                                    $('.layui-laypage-btn').click();
                                    layer.msg("恭喜您,删除成功", {icon: 1});
                                }

                            },
                            dateType: "json"
                        })
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