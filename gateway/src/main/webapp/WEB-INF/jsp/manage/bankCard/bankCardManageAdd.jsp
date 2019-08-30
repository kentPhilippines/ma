<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>添加用户</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<%@include file="../../common/common.jsp"%>
<body layadmin-themealias="default">
<form id="BankCardForm" class="form-signin" action="javascript:0" method="post" novalidate="novalidate">
	<div class="layui-form" lay-filter="layuiadmin-form-admin"
		id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
		<div class="layui-form-item ">
			<label class="layui-form-label">银行卡编号(本地)</label>
			<div class="layui-input-inline">
				<input type="text" readonly = "unselectable='on'" name="bankId" lay-verify="required"
					placeholder="请输入本地编号或选择自动生成" autocomplete="off" class="layui-input">
			</div>
					<button type="button" class="layui-btn layui-btn-danger" id = "Account" url="${ctx}/manage/bankCard/caeateBankId">自动生成账号</button>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">银行卡号</label>
			<div class="layui-input-inline">
				<input type="text" name="bankCard" lay-verify="required"
					placeholder="请输入银行卡号" id="LAY-user-login-password"  autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">银行名称</label>
			<div class="layui-input-inline">
				<input type="text" name="bankName" lay-verify="required" 
					placeholder="请输入银行名称"  id="LAY-user-login-password" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">持卡人</label>
			<div class="layui-input-inline">
				<input type="text" name="cardholder" lay-verify="required"
					placeholder="请输入持卡人姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">财务主管</label>
			<div class="layui-input-inline">
				<input type="text" name="treasurer" lay-verify="required" placeholder="绑定负责财务主管" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">银行卡负责人</label>
			<div class="layui-input-inline">
				<input type="text" name="liabilities" lay-verify="required" placeholder="请输入银行卡负责人" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">银行绑定手机</label>
			<div class="layui-input-inline">
				<input type="text" name="bankPhone" lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">持卡人身份证</label>
			<div class="layui-input-inline">
				<input type="text" name="cardholderId" lay-verify="required" placeholder="请输入身份证编号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-inline">
				<input type="text" name="bankNote" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">银行卡类别</label>
		    <div class="layui-input-inline">
		      <select name="bankType" lay-filter="aihao">
		        <option value="0">收款卡</option>
		        <option value="1">中转卡</option>
		        <option value="2">出款卡</option>
		        <option value="3">冻结卡</option>
		        <option value="4">测试卡</option>
		      </select>
		    </div>
 		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">状态</label>
		    <div class="layui-input-inline">
		      <select name="status" lay-filter="aihao">
		        <option value="1">有效</option>
		        <option value="0">无效</option>
		      </select>
		    </div>
 		</div>
		<div class="layui-layer-btn layui-layer-btn-">
			<a class="layui-layer-btn0" url = "${ctx}/manage/bankCard/bankCardInsert">确定</a><a class="layui-layer-btn1">取消</a>
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
<script type="text/javascript" src="${ctx}/static/js/manage/bankCard/bankCard.js" ></script>
<script>
$(function(){
	BankCardAddCls.init();
})
</script>