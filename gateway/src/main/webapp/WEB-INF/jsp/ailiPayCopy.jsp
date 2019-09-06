<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><head>
<!--宝到卡H5收银台-->
<meta charset="utf-8">
<title>收银台</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" href="${ctx}/static/css/reset.css">
<link rel="stylesheet" href="${ctx}/static/css/card2card.css">
<link rel="stylesheet" href="${ctx}/static/css/dialog.css">
</head>
<body>
<div class="header">
<p>订单确认</p>
</div>

<div class="mod-ct">
<div class="content">
<div class="order-content">
<span class="content-title">收款人:</span>
<span id="getPayee" class="amount" payee="李伟东">複製</span>
<a class="copayBtn payBtn andBtn" data-clipboard-target="#getPayee" style="display: block;">复制</a>
<button class="copayBtn payBtn iosBtn" data-clipboard-target="#getPayee" style="display: none;">复制</button>
</div>
<hr>
<div class="order-content">
<span class="content-title">银行卡号:</span>
<span id="CashCard" class="amount" cardnum="6217713101801243">6217713101801243</span>
<a class="copayBtn cardBtn andBtn" data-clipboard-target="#CashCard" style="display: block;">复制</a>
<button class="copayBtn cardBtn iosBtn" data-clipboard-target="#CashCard" style="display: none;">复制</button>
</div>
<hr>
<div class="order-content">
<span class="content-title">银行名称:</span>
<span id="bankName" class="amount" bankname="中信银行">中信银行</span>
<a class="copayBtn nameBtn andBtn" data-clipboard-target="#bankName" style="display: block;">复制</a>
<button class="copayBtn nameBtn iosBtn" data-clipboard-target="#bankName" style="display: none;">复制</button>
</div>
<hr>
<div class="order-content">
<!--<span class="content-title">金额</span>-->
<span style="line-height: 34px;">金额:</span>
<span id="orderAmount" class="amount" cash="100.06">100.06</span>
<a class="copayBtn cashBtn andBtn" data-clipboard-target="#orderAmount" style="display: block;">复制</a>
<button class="copayBtn cashBtn iosBtn" data-clipboard-target="#orderAmount" style="display: none;">复制</button>
<!--<p class="tips">*请按上方金额转账(-->
<!---->
<!--)-->
<!--</p>-->
</div>
<hr>
<div class="import-info">
<!--<span class="import-title">特别说明：请按以下方式转账，否则无法到账</span>-->
<span class="import-title">特别说明：</span>
<p class="import-detail">
<!--<span><b>1、支付宝 | 网银 | 银行APP | </b>-->
<!--&lt;!&ndash;<font style="text-decoration:line-through" color="#93989c">支付宝(受限)</font>&ndash;&gt;-->
<!--</span>-->
<!--<br/>-->
<b>务必填写金额：<span class="detail-cash" style="color: red">100.06</span>元,否则不会到账</b></p>
</div>
<!--<div class="order-content">-->
<!--<a class="openAlipay" href="alipays://platformapi/startapp">打开支付宝</a>-->
<!--</div>-->
<br>
<div>
<!--&lt;!&ndash;<h1 style="text-align: center; font-size: 25px">授你一招盖世绝招，学会了充值无忧</h1>&ndash;&gt;-->
<!--<h1 style="text-align: center; font-size: 25px">30秒学会微信转账</h1>-->
<!--<br />-->
<!--<div>-->
<!--<p>第一步 点击"个人主页-支付"</p>-->
<!--<br />-->
<!--<img src="/static/alipay2card_h5_assets/img/w01.jpg" width="100%">-->
<!--</div>-->
<!--<br />-->
<!--<div>-->
<!--<p>第二步 点击"收付款"</p>-->
<!--<br />-->
<!--<img src="/static/alipay2card_h5_assets/img/w02.jpg" width="100%">-->
<!--</div>-->
<!--<br>-->
<!--<div>-->
<!--<p>第三步 "下拉，选择转到银行卡"</p>-->
<!--<br />-->
<!--<img src="/static/alipay2card_h5_assets/img/w03.jpg" width="100%">-->
<!--</div>-->
<!--<br>-->
<!--<div>-->
<!--<p>第四步 复制信息，长按输入框，粘贴对应信息</p>-->
<!--<br />-->
<!--<img src="/static/alipay2card_h5_assets/img/w04.jpg" width="100%">-->
<!--</div>-->
<!--<br>-->
<!--<div>-->
<!--<p>第五步 点击下一步，输入对应金额</p>-->
<!--<br />-->
<!--<img src="/static/alipay2card_h5_assets/img/w05.jpg" width="100%">-->
<!--</div>-->
<!--</div>-->
<div>
<h1 style="text-align: center; font-size: 25px">10秒学会支付宝转账</h1>
<div>
<p>第一步 点击"转账"</p>
<img src="/static/alipay2card_h5_assets/img/01.jpg" width="100%">
</div>
<br>
<div>
<p>第二步 点击"转到银行卡"</p>
<img src="/static/alipay2card_h5_assets/img/02.jpg" width="100%">
</div>
<br>
<div>
<p>第三步 请在此页粘贴相关信息</p>
<img src="/static/alipay2card_h5_assets/img/03.jpg" width="100%">
</div>
</div>
</div>
</div>

<script src="${ctx}/static/js/zepto.min.js"></script>
<script src="${ctx}/static/js/dialog.min.js"></script>
<script src="${ctx}/static/js/clipboard.min.js"></script>
<script src="${ctx}/static/js/card2card.js"></script>

</div></body></html>