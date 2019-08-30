<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>添加支付类型</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<%@include file="../../common/common.jsp"%>
<body layadmin-themealias="default">
<form id="ChanenlPayTypeForm" class="form-signin" action="javascript:0" method="post" novalidate="novalidate">
	<div class="layui-form" lay-filter="layuiadmin-form-admin"
		id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
		<div class="layui-form-item ">
			<label class="layui-form-label" style="width: 100px;">支付类别编号</label>
			<div class="layui-input-inline">
				<input type="text" readonly = "unselectable='on'" name="payTypeNo" lay-verify="required"
					placeholder="请输入账号或选择自动生成" autocomplete="off" class="layui-input" value="${payTypeNo}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 100px;">产品类别</label>
			<div class="layui-input-inline">
				<input type="text" name="payTypeName" lay-verify="required"
					placeholder="请输入类别如：宝转卡" id="LAY-user-login-password" autocomplete="off"     class="layui-input">
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
			<a class="layui-layer-btn0" url = "${ctx}/manage/channel/addChannelPayType">确定</a><a class="layui-layer-btn1">取消</a>
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
	ChannelPayTypeAddCls.init();
})
</script>