<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>渠道费率管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<%@include file="../../common/common.jsp"%>
<body layadmin-themealias="default" style=" background-color: #c4c0c7;">
	<div class="layui-fluid" style="padding: 15px;">
		<div class="layui-card"  style="padding: 15px;">
			<div class="layui-form layui-card-header layuiadmin-card-header-auto">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">渠道编号</label>
						<div class="layui-input-block">
							<input type="text" name="channelNo" placeholder="渠道本地编号" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">渠道名称</label>
						<div class="layui-input-block">
							<input type="text" name="channelName" placeholder="渠道名称" autocomplete="off" class="layui-input">
						</div>
					</div> 
					<div class="layui-inline">
					    <label class="layui-form-label">支付类型</label>
					    <div class="layui-input-block">
					      <select name="payType" lay-filter="aihao">
					        <option value=""></option>
					     	<c:forEach items="${payList}" var="payType">
						        <option value="${payType.payTypeNo}">${payType.payTypeName}</option>
						    </c:forEach>
					      </select>
					      </div>
				</div>
					<div class="layui-inline">
						<button class="layui-btn != " lay-submit=""
							lay-filter="LAY-user-back-search">
							<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
						</button>
					</div>
				</div>
			</div>
			<div class="layui-card-body">
				<div style="padding-bottom: 10px;">
					<button class="layui-btn layuiadmin-btn-admin" data-type="add" addUrl = "${ctx}/manage/channel/channeFeeAdd">添加渠道费率</button>
				</div>
				<table id="LAY-user-back-manage" url = "${ctx}/manage/channel/channelFeeList" lay-filter="LAY-user-back-manage"></table>
			</div>
		</div>
	</div>
	<script type="text/html" id="operation">
 	 <a class="layui-btn layui-btn-xs" lay-event="edit" url = "${ctx}/manage/channel/channelFeeEditShow">编辑</a>
 	 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" url = "${ctx}/manage/channel/channeFeelDel">删除</a>
	</script>
</body>
</html>
<script type="text/javascript" src="${ctx}/static/js/manage/channel/channel.js" ></script>
<script>
$(function(){
	ChannelFeeClas.init();
})
</script>