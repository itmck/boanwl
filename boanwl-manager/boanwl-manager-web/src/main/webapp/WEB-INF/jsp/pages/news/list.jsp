<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新闻列表</title>
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
                        <input id="title" name="title"  placeholder="请输入标题" class="layui-input search_input" type="text">
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
                <div class="layui-inline">
                    <a class="layui-btn layui-btn-normal addNews_btn">添加</a>
                </div>
                <%--<button data-method="setTop" class="layui-btn" lay-event="add">添加1</button>--%>
                <%--<button class="layui-btn" onclick="addnews()"><i--%>
                <%--class="layui-icon">&#xe61f;</i>添加--%>
                <%--</button>--%>
            </div>
            <!-- 操作日志 -->
            <div class="layui-form news_list">
                <%--这个是动态的表格--%>
                <table class="layui-hide" id="articleList" lay-filter="demo"></table>
                <script type="text/html" id="operateTpl">
                    <%--<a class="layui-btn layui-btn-xs" lay-event="add">添加</a>--%>
                    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                    <%--<a class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i>编辑</a>--%>
                </script>
            </div>

        </div>
    </div>


</section>


<script type="text/javascript">

    layui.use(['table', 'layer'],  function () {
            var table = layui.table;
            layer = layui.layer;
//第一个实例
            table.render({
                elem: '#articleList'
                , url: '../../news/list' //数据接口
                , page: true//开启分页
                , cols: [[
                    //field title 列属性
                    {type: 'checkbox'},
                    {field: 'id', title: '编号'},
                    {field: 'title', title: '标题'},
                    {field: 'content', title: '内容'},
                    {field: 'time', title: '时间'},
//        {field: 'time',title: '时间',templet:'<div>{{ Format(d.time,"yyyy-MM-dd")}}</div>'},
                    {field: 'image',title: '图片',templet:'<div><img src="{{ d.image}}" height="30px" width="35px"></div>'},
                    // {field: 'status', title: '状态',templet:'<div><img src="{{ d.image}}"></div>'},
                    {fixed: 'right',title: '操作', width: 100, align: 'center', toolbar: '#operateTpl'}
                ]],
                done:function (res,curr,count) {
                    hoverOpenImg();
                    console.log($("[data-field='status']").children());
                    $("[data-field='status']").children().each(function(){
                        if($(this).text()=='0'){
                            $(this).text("显示")
                        }else if($(this).text()=='1'){
                            $(this).text("删除")
                        }
                    })
                }
            });

            table.on('tool(demo)', function(obj){

                if(obj.event === 'edit'){
                    var item = obj.data;
                    var index =  layer.open({
                        type: 2,
                        title: "新闻编号:" + "  " + item.id,
                        maxmin: true,
                        area: ['800px', '450px'],
                        content: 'newsmodify',

                        success: function(layero, index){
                            var body = layui.layer.getChildFrame('body', index);

                            body.find(".title").val(item.title);     //登录名
                            body.find(".content").val(item.content);
                            body.find(".file").attr('src',item.image);
                            body.find(".image").val(item.image);
                            body.find(".time").val(item.time);
                            body.find(".id").val(item.id);
                            form.render();
                        },

                        end: function () {

                            layer.tips('新闻真好看', '#about', {tips: 1})
                        }
                    })
                }
                else if(obj.event === 'add'){
                    var index =  layer.open({
                        type: 2,
                        title: "新闻添加" ,
                        maxmin: true,
                        area: ['800px', '550px'],
                        content: 'newsadd',
                    })
                }
            });
//        table.on('edit(articleList)', function(obj){
//            var value = obj.value //得到修改后的值
//                ,data = obj.data //得到所在行所有键值
//                ,field = obj.field; //得到字段
//            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
//            $.ajax({
//                url:"../../news/update",
//                method:"put",
//                data:data,
//                //data:{"id":data.id,field:value},
//                success:function(data) {
//                    if(data.update_code == "0");
//                    $('.layui-laypage-btn').click();
//                    layer.msg("恭喜您,修改成功", {icon: 1});
//                },
//                dateType:"json"
//            })
//
//
//        });

//111111
            $('.addNews_btn').on('click', function () {
                layer.open({
                    type: 2,
                    title: '添加新闻',
                    maxmin: true,
                    area: ['1200px', '700px'],
                    content: 'addnews',
                    end: function () {
                        layer.tips('Hi', '#about', {tips: 1})
                    }

                });

            });

            ///

//搜索操作 先获取搜索按钮事件
            $('#search').on('click', function () {

                var type= $(this).data('type');
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
                        layer.msg('找新闻，输点啥吧', {icom: 1});
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
                        $.ajax({
                            url:"../../news/updateNids",
                            method:"put",
                            data:{"nids[]":ids},
                            success:function(data) {
                                if(data.update_code == "0");
                                $('.layui-laypage-btn').click();
                                layer.msg("恭喜您,删除成功", {icon: 1});
                            },
                            dateType:"json"
                        })
                    } else {
                        layer.msg('请至少选中一行数据!!!!', {icon: 2});
                    }

                }
            }
        }
    );
    function Format(datetime,fmt) {
        if (parseInt(datetime)==datetime) {
            if (datetime.length==10) {
                datetime=parseInt(datetime)*1000;
            } else if(datetime.length==13) {
                datetime=parseInt(datetime);
            }
        }
        datetime=new Date(datetime);
        var o = {
            "M+" : datetime.getMonth()+1,                 //月份
            "d+" : datetime.getDate(),                    //日
            "h+" : datetime.getHours(),                   //小时
            "m+" : datetime.getMinutes(),                 //分
            "s+" : datetime.getSeconds(),                 //秒
            "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
            "S"  : datetime.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }


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