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
                <button data-method="setTop" class="layui-btn">添加1</button>
                <button class="layui-btn" onclick="addnews()"><i
                        class="layui-icon">&#xe61f;</i>添加
                </button>
            </div>
            <!-- 操作日志 -->
            <div class="layui-form news_list">
                <%--这个是动态的表格--%>
                <table class="layui-hide" id="articleList"></table>
                <script type="text/html" id="operateTpl">
                    <a class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i>编辑</a>
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
     {field: 'title',edit: 'text', title: '标题'},
     {field: 'content',edit: 'text', title: '内容'},
        //{field: 'time', title: '时间'},
        {field: 'time', edit: 'text',title: '时间',templet:'<div>{{ Format(d.time,"yyyy-MM-dd")}}</div>'},
      {field: 'image',edit: 'text', title: '图片'},
     // {field: 'status', title: '状态'},
     {fixed: 'right', width: 100, align: 'center', toolbar: '#operateTpl'}
 ]],
 done:function (res,curr,count) {
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
        table.on('edit(articleList)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
            $.ajax({
                url:"../../news/update",
                method:"put",
                data:data,
                //data:{"id":data.id,field:value},
                success:function(data) {
                    if(data.update_code == "0");
                    $('.layui-laypage-btn').click();
                    layer.msg("恭喜您,修改成功", {icon: 1});
                },
                dateType:"json"
            })


        });

//111111


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
    setTop: function(){
        var that = this;
        //多窗口模式，层叠置顶
        layer.open({
            type: 2 //此处以iframe举例
            ,title: '当你选择该窗体时，即会在最顶端'
            ,area: ['390px', '260px']
            ,shade: 0
            ,maxmin: true
            ,offset: [ //为了演示，随机坐标
                Math.random()*($(window).height()-300)
                ,Math.random()*($(window).width()-390)
            ]
            ,content: 'http://layer.layui.com/test/settop.html'
            ,btn: ['继续弹出', '全部关闭'] //只是为了演示
            ,yes: function(){
                $(that).click();
            }
            ,btn2: function(){
                layer.closeAll();
            }

            ,zIndex: layer.zIndex //重点1
            ,success: function(layero){
                layer.setTop(layero); //重点2
            }
        });
    },

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
function addnews(){
    layer.open({
        //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
        type:1,
        title:"添加新闻",
        area: ['70%','70%'],
        content:'',
    });
}

</script>
</body>
</html>