<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>添加渠道费率</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<%@include file="../../common/common.jsp"%>
<body layadmin-themealias="default">
<form id="ChanenlFeeForm" class="form-signin" action="javascript:0" method="post" novalidate="novalidate">
	<div class="layui-form" lay-filter="layuiadmin-form-admin"
		id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width: 100px;">渠道名称</label>
		    <div class="layui-input-inline">
		      <select name="channelNo" lay-filter="aihao">
			      <option value=""></option>
			      <c:forEach items="${channelList}" var="channel">
			        <option value="${channel.channelNo}">${channel.channelName}</option>
			      </c:forEach>
		      </select>
		    </div>
 		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width: 100px;">产品名称</label>
		    <div class="layui-input-inline">
		      <select name="payType" lay-filter="aihao">
		        <option value=""></option>
		     	<c:forEach items="${payList}" var="payType">
			        <option value="${payType.payTypeNo}">${payType.payTypeName}</option>
			    </c:forEach>
		      </select>
		    </div>
 		</div>
 		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 100px;">费率（成本）</label>
			<div class="layui-input-inline">
				<input type="text" name="fee" lay-verify="required"
					placeholder="请输入成本费率如：0.005" id="LAY-user-login-password" autocomplete="off"     class="layui-input">
			</div>
		</div>
 		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 100px;">日结百分比</label>
			<div class="layui-input-inline">
				<input type="text" name="settle" lay-verify="required"
					placeholder="请输入日结百分比如：90" id="LAY-user-login-password" autocomplete="off"     class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width: 100px;">状态</label>
		    <div class="layui-input-inline">
		      <select name="status" lay-filter="aihao">
		        <option value="1">启用</option>
		        <option value="2">停用</option>
		      </select>
		    </div>
 		</div>
		<div class="layui-layer-btn layui-layer-btn-">
			<a class="layui-layer-btn0" url = "${ctx}/manage/channel/addChannelFee">确定</a><a class="layui-layer-btn1">取消</a>
		</div>
	</div>
</form>
</body>
</html>
<script>
layui.use('form', function(){
  var form = layui.form;
});
</script>
<script type="text/javascript" src="${ctx}/static/js/manage/channel/channel.js" ></script>
<script>
$(function(){
	ChannelFeeAddCls.init();
})
</script>