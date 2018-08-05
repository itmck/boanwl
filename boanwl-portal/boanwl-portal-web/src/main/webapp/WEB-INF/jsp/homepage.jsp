<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>伯安快递  </title>
    <meta name="keywords" content="伯安,快递, 伯安快递,速递">
    <meta name="description" content="伯安快递是伯安集团旗下专业快递品牌，以“精彩生活，快递欢乐”为理念，为用户提供“年轻、快乐”的快递服务">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <link rel="shortcut icon" type="image/x-icon" href="/static/images/800bestexicon.ico" />
    <link href="static/css/4d1d91a0f011495495fa6b5014e07cfc.css" rel="stylesheet"/>

    <link href="static/css/ae348c73226940d9ba72fd0bba6d5dbc.css" rel="stylesheet"/>

    <link href="static/css/603b43e0f06144a4926748f5ad59248e.css" rel="stylesheet"/>

    
        <link href="static/css/387e55ede6214235afd03ad369647b83.css" rel="stylesheet"/>

        <style>
            .onlineSever{position:fixed;top:300px;left:50%;margin-left:-680px;}
            .seviceSize{display:block;width:220px; height:180px;z-index:10;}
            .seviceSizeSub{
                display: block;
                width: 160px;
                height: 60px;
                margin-left:25px;
                z-index: 10;
            }
        </style>
    
    <script src="static/js/47a12ec1dabd46ff8c6830b636086b59.js"></script>

    <script>
        var urlConfig = {
            web: "",
            api: "/htwebapi",
            q9api : "/q9api",
            wx: "/wxapi",
            wxplatform: "http://psapi.appl.800best.com/",
            weixinappid: "wx61af89c230ee8c23",
            wxVerificationCodePath: "/security/sendsms"
        };
        var appConfig = {
            appId: "HTWeb",
            userId: "",
            userName: ""
        }
        var app = {}
        $(function () {
            $(':text, textarea').placeholder();
        });
    </script>

</head>
<body>

    <div class="topnav">
    <div class="container clearfix">
        <img onclick="window.open('http://boan.html', 'webcs', 'width=750,height=600,toolbar=no, menubar=no, scrollbars=no, resizable=yes,location=no, status=no,center=yes');" src="" style="position:absolute;right:0;top:0;cursor:pointer" />
        <span class="pull-left">
            <a href="" target="_blank">伯安欢迎您浏览</a> |
           
        </span>
    </div>
</div>
    <div class="nav main-nav" id="main-nav">
    <div class="container">
        <div class="border-line hide"></div>
        <div class="logo pull-left">
            <a href="/" title="伯安快递">
                <img src="static/picture/logo.png"  alt="伯安快递">




            </a>
        </div>
        <ul id="main-nav-wrap" class="unstyled inline clearfix pull-right">
            <li><a href="/boanwl/lib/homepage.html">首 页</a></li>
            <!--<li><a href="/Bill/Track">查 件</a></li>-->
            <li><a href="/boanwl/lib/query/queryExpress.html">查 件</a></li>
            <!--<li><a href="/Order/Create">寄 件</a></li>-->
            <li><a href="/boanwl/lib/send/sendExpress.html">寄 件</a></li>
            <!--<li><a href="javascript:void(0);">网 点</a>
                <ul class="unstyled hide" style="position: absolute;left : -20px;width : 85px;">
                    <li><a href="/Site/Query">伯安快递站点</a> </li>
                    <li><a href="/Site/ServiceQuery">伯安快递服务点</a> </li>
                </ul>
            </li>-->

            <!--<li>
                <a href="javascript:void(0);">产品服务</a>
               
                <ul class="unstyled hide">
                    <li><a href="/Best/Products">快递</a></li>
                    <li><a href="http://www.800best.com/freight/" target="_blank">快运</a></li>
                    <li><a href="http://www.800best.com/supply-chain/" target="_blank">云仓</a></li>
                </ul>
            </li>-->
            <li><a href="/boanwl/lib/news/news.html">新闻中心</a></li>
            <!--<li><a href="javascript:void(0);">企业服务</a>
                <ul class="unstyled hide">
                    <li><a href="http://www.800best.com/express/partner/" target="_blank">加盟合作</a></li>
                    <li><a href="/static/Index/70EBB44ADC5E52ED" target="_blank">采购招标</a> </li>
                </ul>
            </li>-->
            <li><a href="/boanwl/lib/help/help.html" style="padding-right:0;">帮助中心</a></li>
        </ul>
        
    </div>
</div>
    
    <div class="container">
        <div class="query" id="query">
<form action="/boanwl/lib/query/queryExpress.html" class="ajax" id="BillQueryForm" method="post">                <fieldset>
                    <div class="control-group clearfix query-title" id="query-title">
                        <strong class="font-blue pull-left">
                            <i class="icon  icon-query"></i>查件
                        </strong>
                        <span class="pull-right hide">
                            最后查询：<span id="last-query" class="font-blue"></span>
                        </span>
                    </div>
                    <div class="control-group query-input" id="query-input-wrap">                
                        <div class="textarea clearfix">
                            <div id="code-wrap" class="code-wrap hide">
                                <textarea id="code" class="code"></textarea>
                                <input type="hidden" name="code" id="hcode">
                            </div>
                            <div class="placeholder">请输入运单号，多单号用空格分隔，最多10单</div>
                        </div>
						
                    </div>
                    <div class="font-error font12 ml10 mr10 mb10" id="alert"></div>

                    <div class="control-group query-btn-wrap" id="query-btn-wrap" style="height: 0;">
                        
                        <input type="text" style="display: none;">
                        <button class="btn blue disabled high pull-right" name="billquery" id="billquery" disabled="true">查　询</button>
                    </div>
                </fieldset>
</form>        </div>        
    </div>
    <script type="text/javascript">
        
    </script>


    <div class="flexslider slide   homeslide" id="slide">
        
<!--      <ol class="carousel-indicators">
		<li data-target="#slide" data-slide-to="0" class="active"></li>
		<li data-target="#slide" data-slide-to="1"></li>
		<li data-target="#slide" data-slide-to="2"></li>
	</ol> 
	<div class="carousel-inner">
		<div class="active item"><img src="static/picture/1.jpg"></div>
		<div class="item"><img src="static/picture/2.jpg"></div>
		<div class="item"><img src="static/picture/3.jpg"></div>
	</div> -->
    <ul class="slides">
        <%--<li style="background:url(static/images/bex20180103.jpg)  center top no-repeat"><a href="javascript:void(0)" , target=&#39;_blank&#39;></a>
</li>
        <li style="background:url(static/images/md.jpg)  center top no-repeat"><a href="javascript:void(0)" , target=&#39;_blank&#39;></a>
</li>
        <li style="background:url(static/images/zs.jpg)  center top no-repeat"><a href="javascript:void(0)" , target=&#39;_blank&#39;></a>
</li>--%>
            <c:forEach items="${imgList}" var="con">
                <li style="background:url(${con.href})  center top no-repeat"><a href="javascript:void(0)" , target=&#39;_blank&#39;></a>
                </li>

            </c:forEach>

        
    </ul>	


    </div>

    <div class="main">
        <div class="container">

            

<div class="service-box mb20" id="service-box">
	<!-- <div class="divider"><h2>产品与服务</h2></div> -->
	<div class="row">
		<div class="span">
			
				<div class="bg bg1"></div>
				<a href="/boanwl/lib/send/sendExpress.html"><img src="static/picture/i1.png" alt=""></a>
			<strong>寄件下单</strong>
		</div>
		<div class="span">
			<div class="bg bg2">
			</div>
				<a href="/boanwl/lib/news/news.html"><img src="static/picture/i2.png" alt=""></a>
	   
			<strong>动态查看</strong>
		</div>
		<div class="span">
			<div class="bg bg3">
				
			</div>
			<a href="/boanwl/lib/help/wordResult.html"><img src="static/picture/i3.png" alt=""></a>
	 
			<strong>我的留言</strong>
		</div>

		<div class="span">
			<div class="bg bg4">
				
			</div>
			<a href="/Help/help.html"><img src="static/picture/i4.png" alt=""></a>
   
			<strong>客服咨询</strong>      
		</div>
	</div>
</div>

<!--在线客服-->
<div class="onlineSever seviceSize">
    <a class="seviceSize" href="javascript:void(0);" onclick="window.open('http://webcs.800best.com/smWeb.html', 'webcs', 'width=750,height=600,toolbar=no, menubar=no, scrollbars=no, resizable=yes,location=no, status=no,center=yes');">
        <img src="static/picture/onlinesevice.png" alt="" />
    </a>
   
</div>


<div class="lab-box mb20">
	<div class="divider"><h2>伯安实验室</h2></div>
	<div class="row">
		<div class="span info">
			<img src="static/picture/lab_info.jpg" alt="">
		</div>
		<div class="span video">
            <a href="http://www.800best.com/express/v/lab.flv" style="display:block;width:100%;height:100%" id="player"> </a>
		</div>
	</div>
</div>
	<div class="news-box mb20">
		<div class="divider"><h2>最新发生的事</h2></div>
		<div class="row">
						<div class="top-announcement span">
							<a href="/news/detail/B3590B225D53BE21" target="_blank" style="background: url(static/images/yu.jpg); height: 327px; width: 240px; display: inline-block;">
							</a>
							
							<span class="top-time"></span>
							<span class="top-cate"><a href="/news/list?category=57BC9232B9BDFC75" style="font-color:#FAD91D" target="_blank">伯安快讯</a></span>
						</div>
						<div class="top-news span">
							<a href="/news/detail/520E20FCEFE60449" target="_blank" style="background: url(static/images/0613v.jpg); height: 327px; width: 240px; display: inline-block;">
							</a>
							
							<span class="top-time"></span>
							<span class="top-cate"><a href="/news/list?category=6A81A2488B6CC6C8" style="font-color:#FAD91D" target="_blank">行业动态</a></span>
						</div>

			<div class="span last"><img src="static/picture/p3.jpg" alt=""></div>
		</div>
	</div>
    <div style="position:relative;">

    </div>




        </div>
    </div>
    
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="span span2">
                    <dl>
                        <dt class="foot-blue">企业服务</dt>
                        <dd><a class="foot-blue" href="http://www.800best.com/express/partner/" target="_blank">加盟合作</a></dd>
                        <dd><a class="foot-blue" href="/static/Index/70EBB44ADC5E52ED" target="_blank">采购招标</a></dd>
                        <dd><a class="foot-blue" href="http://inner.800bestex.com:8090/" target="_blank">站点登录入口</a></dd>
                    </dl>
                </div>
                <div class="span span2">
                    <dl>
                        <dt>查询·寄件</dt>
                        <dd><a href="/bill/track">运单追踪</a></dd>
                        <dd><a href="/order/create">寄件</a></dd>
                        <dd><a href="/Site/Query">网点</a></dd>
                        <dd><a href="/Best/Products">产品服务</a></dd>
                        <dd><a class="foot-red" href="/static/Index/28B9E6753B7C2055" target="_blank">禁寄须知</a></dd>
                    </dl>
                </div>
     
                <div class="span span2">
                    <dl>
                        <dt>关于我们</dt>
                        <dd> <a href="/news/list">新闻中心</a></dd>
                        <dd><a target="_blank" href="http://www.800best.com/hr">人才招聘</a></dd>
                        <!-- <dd><a href="#">关于伯安快递</a></dd> -->
                        <dd><a href="/home/About">关于伯安快递</a></dd>
                        <dd><a target="_blank" href="http://www.800best.com ">伯安物流</a></dd>
                    </dl>
                </div>
                <div class="span span2">
                    <dl>
                        <dt>帮助中心</dt>
                  
                        <dd class="">95320</dd>
                        <dd><a  href="javascript:void(0);" onclick="window.open('http://webcs.800best.com/smWeb.html', 'webcs', 'width=750,height=600,toolbar=no, menubar=no, scrollbars=no, resizable=yes,location=no, status=no,center=yes');">在线客服</a></dd>
                        <dd><a href="/help/Feedback">投诉与建议</a></dd>
                        <dd><a href="/static/Index/BB4318709137ED52">各地客服电话</a></dd>
                    </dl>
                </div>
                <div class="span wx-span" style="float:right">
                    <div class="divider">
                        <div>微信公众号</div>
                    </div>
                    <div class="row mt30">
                        <div class="span text-center">
                            <div>
                                <img src="static/picture/htewm.png" alt="访问伯安快递官方微博">
                            </div>
                            <div class="mt10 pt5">伯安快递</div>
                        </div>
                        <div class="span text-center" style="float: right">
                            <div>
                                <img src="static/picture/rcewm.png" alt="伯安招聘">
                            </div>
                            <div class="mt10 pt5">伯安招聘</div>
                        </div>
                    </div>
           
                </div>
            </div>

            <div class="copy row">
                <div class="span span1">
                    <a href="http://www.spb.gov.cn" target="_blank" title="中华人民共和国国家邮政局">
                        <img src="static/picture/f1.png" alt="中华人民共和国国家邮政局">
                    </a>
                    <a href="http://www.cea.org.cn" target="_blank" title="中国快递协会">
                        <img src="static/picture/f2.png" alt="中国快递协会">
                    </a>

                    
                </div>
                <div class="span span8">
                    伯安网络 版权所有 Copyright 2014 800bestex.com Inc. All rights reserved.  <a href="http://www.miibeian.gov.cn" target="_blank" style="text-decoration: underline;">沪ICP备11045012号</a>
                  

                </div>
                <div class="span span3 text-right">
                   伯安快递微博：<a href="http://e.weibo.com/bestexpress" target="_blank" title="访问伯安快递官方微博"><img src="static/picture/f3.png" alt="访问伯安快递官方微博"></a>
                </div>
            </div>
            <div class="text-center">  
                    <a style="color:#939393;" target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011802001068">
                        <img src="static/picture/beian.png" />沪公网安备 31011802001068号
                    </a>
                    <a style="color:#939393;text-decoration: underline" target="_blank" href="/Images/yyzz.jpg">企业营业执照</a>
            </div>
        </div>
    </div>
</body>
</html>
<script src="static/js/81837495ffad4e089cefb5382d2d1651.js"></script>

<script src="static/js/12aca07aac2a4ff7b6b1b9ad7332e866.js"></script>

<script src="static/js/00420ebab2ef434dbaf1bcc2b0ff6d43.js"></script>
<script src="static/js/caa123ecfe45477e967188c864bc59f1.js"></script>


        <div class="hide">
            <script type="text/javascript">
                var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
                document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F8fd193f17ae8acf2be1a1cfc65323057' type='text/javascript'%3E%3C/script%3E"));
            </script>
            <script src="static/js/stat.js" language="JavaScript"></script>
        </div>

