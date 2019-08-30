<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>添加商户手续费</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<%@include file="../../common/common.jsp"%>
<style type="text/css">
.layui-form-label{
	float: left;
    display: block;
    padding: 9px 15px;
    width: 107px;
    font-weight: 400;
    line-height: 20px;
    text-align: right;
}
</style>
<body layadmin-themealias="default">
<form id="AccountFeeForm" class="form-signin" action="javascript:0" method="post" novalidate="novalidate">
	<div class="layui-form" lay-filter="layuiadmin-form-admin"
		id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
		<input type="hidden" name= "id" value="${accountFee.id}">
		<div class="layui-form-item">
			<label class="layui-form-label">商户号</label>
			<div class="layui-input-inline">
				<input type="text" readonly = "unselectable='on'" name="accountId" lay-verify="required" 
					value="${accountFee.accountId}"
					placeholder="请输入商户号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">渠道编号</label>
			<div class="layui-input-inline">
				<input type="text"  readonly = "unselectable='on'" name="accountChannel" lay-verify="required"
					value="${accountFee.accountChannel}"
					placeholder="请输入渠道编号" id="LAY-user-login-password"  autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">产品编号</label>
			<div class="layui-input-inline">
				<input type="text" name="channelProduct" lay-verify="required" 
					readonly = "unselectable='on'"
					value="${accountFee.channelProduct}"
					placeholder="请输入产品编号"  id="LAY-user-login-password" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">费率</label>
			<div class="layui-input-inline">
				<input type="text" name="accountFee" lay-verify="required"
					value="${accountFee.accountFee}"
					placeholder="请输入费率如：0.008" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">渠道成本</label>
			<div class="layui-input-inline">
				<input type="text" name="accountCost" lay-verify="required"
					value="${accountFee.accountCost}"
					placeholder="请输入渠道成本如：0.002" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">取款手续费</label>
			<div class="layui-input-inline">
				<input type="text" name="withdrawal" lay-verify="required"
					value="${accountFee.withdrawal}"
					placeholder="请输入渠道成本如：2" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">取款手续费成本</label>
			<div class="layui-input-inline">
				<input type="text" name="withdrawalCost" lay-verify="required"
					value="${accountFee.withdrawalCost}"
					placeholder="请输入渠道成本如：2" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">费率状态</label>
		    <div class="layui-input-inline">
		      <select name="feeStautus" lay-filter="aihao">
		        <option value="1" <c:if test="${accountFee.feeStautus == 1}">select:'select'</c:if> >启用</option>
		        <option value="2" <c:if test="${accountFee.feeStautus == 2}">select:'select'</c:if>>停用</option>
		        <option value="3" <c:if test="${accountFee.feeStautus == 3}">select:'select'</c:if>>自动切换</option>
		      </select>
		    </div>
 		</div>
		<div class="layui-layer-btn layui-layer-btn-">
			<a class="layui-layer-btn0" url = "${ctx}/manage/account/accountFeeEdit">确定</a>
			<a class="layui-layer-btn1">取消</a>
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
<script type="text/javascript" src="${ctx}/static/js/manage/account/account.js" ></script>
<script>
$(function(){
	AccountFeeEditCls.init();
})
</script>