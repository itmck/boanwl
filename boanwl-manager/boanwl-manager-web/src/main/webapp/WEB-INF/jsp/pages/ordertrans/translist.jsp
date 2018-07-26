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
   <%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css"
          media="all">--%>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" media="all">
   <%-- <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
   <%-- <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>--%>
   <%-- <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>--%>

</head>
<body>

<div class="layui-inline">
    <div class="layui-input-inline">
        <input name="orderNum" id="orderNum" placeholder="请输入运单号" class="layui-input search_input" type="text">
    </div>
    <div class="layui-input-inline " style="width: 90px">
        <button class="layui-btn" id="search" data-type="getData">
            <i class="layui-icon" style="font-size: 20px; "></i> 搜索
        </button>
    </div>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>--%>

<script>
    layui.use(['table', 'jquery'],function(){
        var table = layui.table,$=layui.jquery;
        table.render({
            elem: '#test'
            ,url:'../../showOrder'   //路径
           /* ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1*/
            ,page:true
            ,cols: [[
                {field:'id', title: '编号'},
                {field:'orderNum', title: '运单号'}
                ,{field:'city', title: '城市',edit: 'text'}
                ,{field:'statusName', title: '状态'}
                ,{field:'name',  title: '快递员'}
                ,{field:'dateCreated',  title: '时间', sort: true}
                ,{field:'msg', title: '快件操作记录',edit: 'text'}
                ,{title:'<b>操作选项</b>',fixed:'right',align : 'center',toolbar : '#trans-toolbar'}
            ]]

        });

       /* //搜索加载--数据表格重载
        var $ = layui.$, active = {
            reload: function () {
                //执行重载
                table.reload('test', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        orderNum: $("input[name=orderNum]").val()
                    }
                });
            }
        };*/

        $('#search').on('click', function () {

            var type = $(this).data('type');

            active[type] ? active[type].call(this) : '';
        });
       // element.init();
        var active = {
            getData: function () {


                //通过id选择器获取搜索框中的内容
                //val() 单选按钮 复选按钮 文本框
                //text() 文本
                //html() 标签
                var title = $('#orderNum').val();
                //判断内容是否为空
               // alert(title);
               // if ($.trim(title).length > 0) {
                    //文本框输入了内容,表格需要重新加载.另外发送一个item请求
                    table.reload('test', {


                        page: {curr: 1},
                        //第一个title作为表单数据传出去的key
                        //第二个参数就是js定义的变量(就是我们获取的文本框值)
                        where: {orderNum: title}


                    });

               // } else {

                   /* layer.msg('亲,您未输入任何东西', {icom: 1});
                     //表刷新方法
                    var reloadTable = function (item) {
                  table.reload("test", { //此处是上文提到的 初始化标识id
                     where: {
                    //key: { //该写法上文已经提到
                        type: item.type, id: item.id
                    //}
                }
            });
        };

                }*/






            }
        };
        //列表操作修改
       /* table.on('edit(test)', function(obj){
            var value = obj.value,
//                value1 = obj.value,//得到修改后的值
                data = obj.data, //得到所在行所有键值
                field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
           /!* $.get("/modifyTrans",{
                id : data.id,	//将需要修改的Id作为参数传入
                msg:value,
//                city : value //得到修改后的值
            },function(data){
                //tableIns.reload();
            })*!/
        });*/

        //监听工具条修改
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'update'){
                layer.msg('ID：'+ data.id + ' 城市'+data.city+"操作信息"+data.msg);

                $.get("${pageContext.request.contextPath}/modifyTrans" ,
                    {
                    id:data.id,
                    city:data.city,
                    msg:data.msg
                },
                    "json")
            }else if(obj.event === 'add'){
                layer.msg('订单号'+data.orderNum);
                $.get("${pageContext.request.contextPath}/getOrderNum" ,
                    {
                        orderNum:data.orderNum
                    },
                    function(data){
                        window.location.href="${pageContext.request.contextPath}/pages/ordertrans/transadd";
                        alert("Data Loaded: " + data);
                    },
                    "json")

            }/* else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }*/


          /* table.on('tool(test)', function(obj){
                var data = obj.data;
                if(obj.event === 'add'){
                    layer.msg(' 订单号'+data.orderNum);

                    $.get(/getOrderNum" ,
                        {
                            orderNum:data.orderNum

                        },
                        "json")
                }*/
            });

    });

</script>

<script type="text/html" id="trans-toolbar">
    <button class="layui-btn layui-btn-xs" lay-event="update">保存修改</button>
    <button class="layui-btn layui-btn-xs" lay-event="add">添加</button>
  <%--  <button class="layui-btn layui-btn-xs" lay-event="edit">编辑</button>--%>

</script>
</body>
</html>
