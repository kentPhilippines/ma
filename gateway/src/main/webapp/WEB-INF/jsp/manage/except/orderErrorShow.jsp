<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>异常订单管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<%@include file="../../common/common.jsp"%>
<body layadmin-themealias="default" style=" background-color: #c4c0c7;">
	<div class="layui-fluid" style="padding: 15px;">
		<div class="layui-card"  style="padding: 15px;">
			<div class="layui-form layui-card-header layuiadmin-card-header-auto" style="height:120px">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">订单单号</label>
						<div class="layui-input-block">
							<input type="text" name="orderExceptId" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">关联订单</label>
						<div class="layui-input-block">
							<input type="text" name="orderId" placeholder="请输入交易或代付订单号" autocomplete="off" class="layui-input">
						</div>
					</div> 
					<div class="layui-inline">
						<label class="layui-form-label">关联商户号</label>
						<div class="layui-input-block">
							<input type="text" name="orderAccount" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div> 
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
					    <label class="layui-form-label">异常状态</label>
					    <div class="layui-input-block">
					      <select name="exceptStatus" lay-filter="aihao"><!-- 不能这么写,后期 优化  -->
					        <option value="" >全部</option>
					        <option value="1" >程序异常</option>
					        <option value="2" >人工异常</option> 
					      </select>
					      </div>
					</div>
					<div class="layui-inline">
					    <label class="layui-form-label">异常类型</label>
					    <div class="layui-input-block">
					      <select name="exceptType" lay-filter="aihao"><!-- 不能这么写,后期 优化  -->
					        <option value="" >全部</option>
					        <option value="1" >交易异常</option>
					        <option value="2" >系统加款异常</option> 
					        <option value="3" >交易手续费异常</option> 
					        <option value="4" >系统扣款</option> 
					        <option value="5" >代付</option> 
					        <option value="6" >代付手续费</option> 
					      </select>
					      </div>
					</div>
					<div class="layui-inline">
				      <label class="layui-form-label">日期范围</label>
				      <div class="layui-input-inline">
				        <input type="text" class="layui-input" id="createTime"  name = "createTime"  placeholder=" - ">
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
				<table id="LAY-user-back-manage" url = "${ctx}/manage/order/dealOrderList" lay-filter="LAY-user-back-manage"></table>
			</div>  
		</div>
	</div>
	<%--	<script type="text/html" id="operation">
 	 <a class="layui-btn layui-btn-xs" lay-event="edit" url = "${ctx}/manage/dealOrder/bankCardEditShow">编辑</a>
 	 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" url = "${ctx}/manage/bankCard/bankCardDel">删除</a>
	</script>--%>
</body>
</html>
<script type="text/javascript" src="${ctx}/static/js/manage/exceptOrder/except.js" ></script>
<script>
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  laydate.render({
		    elem: '#createTime'
		    ,range: true
		  });
})
$(function(){
	ExceptClas.init();
})
</script>