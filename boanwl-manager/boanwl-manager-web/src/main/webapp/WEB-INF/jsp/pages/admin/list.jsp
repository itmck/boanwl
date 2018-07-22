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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/personal.css" media="all">
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
		</div><div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn">添加管理员</a>
		</div>
		<%--<div class="layui-inline">
			<a class="layui-btn recommend" style="background-color:#5FB878">推荐文章</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn audit_btn">审核文章</a>
		</div>--%>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger"
            data-type="getCheckData" id="batchdel">批量删除</a>
		</div>
		<div class="layui-inline">
			<div class="layui-form-mid layui-word-aux">***</div>
		</div>
	</blockquote>
            
		         <!-- 操作日志 -->
               <div class="layui-form news_list">
                <table class="layui-hide" id="articleList">
                    <tr>
                        <td>qqqqqqqqqqqqqqqqqqqqqqqq</td>
                    </tr>
                </table>

              </div>
			     <!-- 登录日志 -->
			    <%--<div class="layui-tab-item layui-field-box">
			          <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                           <thead>
                              <tr>
                                  <th><input type="checkbox" id="selected-all"></th>
                                  <th>ID</th>
                                  <th>管理员账号</th>
                                  <th>状态</th>
                                  <th>最后登录时间</th>
                                  <th>上次登录IP</th>
                                  <th>登录IP</th>
                                  <th>IP所在位置</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td><input type="checkbox"></td>
                                <td>110</td>
                                <td>admin</td>
                                <td>后台登录成功</td>
                                <td>2016-12-19 14:26:03</td>
                                <td>127.0.0.1</td>
                                <td>127.0.0.1</td>
                                <td>Unknown</td>
                              </tr>
                            </tbody>
			          </table>

			          <div class="larry-table-page clearfix">
                          <a href="javascript:;" class="layui-btn layui-btn-small"><i class="iconfont icon-shanchu1"></i>删除</a>
				          <div id="page2" class="page"></div>
			         </div>
			    </div>--%>
		    </div>
		</div>
	
</section>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/layui/layui.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/newslist.js"></script>
<script type="text/javascript">
	layui.extend({
		table:'/boanwl/static/js/'
	});
	layui.use(['jquery','layer','element','laypage','table'],function(){
	      $ = layui.jquery;
	      layer = layui.layer;
	      var table = layui.table;
        table.render({
            //表格属性
            //要渲染的容器
            page: true,
            elem: '#articleList',
            //异步请求
            url: '../../items',
            //列
            cols: [[
                //field title 列属性
                {type:'checkbox'},
                {field: 'id', title: 'ID'},
                {field: 'title', title: '管理员账号'},
                {field: 'sellPoint', title: '状态'},
                {field: 'price', title: '最后登录时间'},
                {field: 'catName', title: '上次登录时间'}
            ]]
        });
        //附加点击事件
        $('.news_list .layui-btn-danger').click(function(){
            //获得按钮的data类型
            layer.msg("哈喽");
            var type =  $(this).data('type');
            //判断active是否为真,为真则调用它
            active[type] ? active[type].call(this):'';
        });
        var active={
            getCheckData:function () {
                //获得table中被选中的行
                var data = table.checkStatus('articleList').data;
                var ids = [];
                if(data.length){
                    for (var i=0;i<data.length;i++){
                        var id = data[i].id;
                        ids.push(id);
                    }
                    $.get(
                        '../../item/batch',
                        {'ids[]':ids},
                        function(data){
                            console.log(data);
                        },
                        'json'
                    );

                }else{
                    layer.msg("前至少选择一条数据",{icon:2})
                }
            }
        };
    });
</script>
</body>
</html>