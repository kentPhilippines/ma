<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="layui-form-item">
			<label class="layui-form-label">商户号</label>
			<div class="layui-input-inline">
				<input type="text" name="accountId" lay-verify="required"
					placeholder="请输入商户号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">渠道编号</label>
			<div class="layui-input-inline">
				<input type="text" name="accountChannel" lay-verify="required"
					placeholder="请输入渠道编号" id="LAY-user-login-password"  autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">产品编号</label>
			<div class="layui-input-inline">
				<input type="text" name="channelProduct" lay-verify="required" 
					placeholder="请输入产品编号"  id="LAY-user-login-password" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">费率</label>
			<div class="layui-input-inline">
				<input type="text" name="accountFee" lay-verify="required"
					placeholder="请输入费率如：0.008" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">渠道成本</label>
			<div class="layui-input-inline">
				<input type="text" name="accountCost" lay-verify="required"
					placeholder="请输入渠道成本如：0.002" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">取款手续费</label>
			<div class="layui-input-inline">
				<input type="text" name="withdrawal" lay-verify="required"
					placeholder="请输入渠道成本如：2" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">取款手续费成本</label>
			<div class="layui-input-inline">
				<input type="text" name="withdrawalCost" lay-verify="required"
					placeholder="请输入渠道成本如：2" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">费率状态</label>
		    <div class="layui-input-inline">
		      <select name="feeStautus" lay-filter="aihao">
		        <option value="1">启用</option>
		        <option value="2">停用</option>
		        <option value="3">自动切换</option>
		      </select>
		    </div>
 		</div>
		<div class="layui-layer-btn layui-layer-btn-">
			<a class="layui-layer-btn0" url = "${ctx}/manage/account/addaccountFee">确定</a>
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
layui.config({
    base: '/static/layAutoComplete/' //假设这是test.js所在的目录
}).extend({ //设定模块别名
    autocomplete: 'layAutoComplete'
});
layui.use(['autocomplete'], function () {
    var departmentList = ${accountList};
    layui.autocomplete({
        element: '[name="accountId"]',
        array: departmentList,
        num: 1,
        count: 5,
        done: function (item) {//选中
        	$("[name='accountId']").val(item.pinyin)
        }
    });
    var departmentList1 = ${channelList};
    layui.autocomplete({
        element: '[name="accountChannel"]',
        array: departmentList1,
        num: 1,
        count: 5,
        done: function (item) {//选中
        	$("[name='accountChannel']").val(item.pinyin)
        }
    })
    var departmentList2 = ${payList};
    layui.autocomplete({
        element: '[name="channelProduct"]',
        array: departmentList2,
        num: 1,
        count: 5,
        done: function (item) {//选中
        	$("[name='channelProduct']").val(item.pinyin)
        }
    })
})
</script>
<script type="text/javascript" src="${ctx}/static/js/manage/account/account.js" ></script>
<script>
$(function(){
	AccountFeeAddCls.init();
})
</script>