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
<form id="UserForm" class="form-signin" action="javascript:0" method="post" novalidate="novalidate">
	<div class="layui-form" lay-filter="layuiadmin-form-admin"
		id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
		<div class="layui-form-item ">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-inline">
				<input type="text" name="userId" lay-verify="required"
					placeholder="请输入账号或选择自动生成" autocomplete="off" class="layui-input">
			</div>
					<button type="button" class="layui-btn layui-btn-danger" id = "Account" url="${ctx}/system/user/caeateAccount">自动生成账号</button>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户名称</label>
			<div class="layui-input-inline">
				<input type="text" name="userName" lay-verify="required"
					placeholder="请输入用户名" id="LAY-user-login-password"  autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" name="password" lay-verify="required" 
					placeholder="请输入密码"  id="LAY-user-login-password" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-inline">
				<input type="password" name="userPassword" lay-verify="pass"
					placeholder="请确认密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-inline">
				<input type="text" name="userMail" lay-verify="email"
					placeholder="请输入邮箱" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">账号类别</label>
		    <div class="layui-input-inline">
		      <select name="userType" lay-filter="aihao">
		        <option value="0">内部账户</option>
		        <option value="1">外部账户</option>
		      </select>
		    </div>
 		</div>
		 <div class="layui-form-item">
		    <label class="layui-form-label">账号类别</label>
		    <div class="layui-input-inline">
		      <select name="userType" lay-filter="aihao"><!-- 不能这么写,后期 优化  -->
		        <option value="0" selected="selected">内部账户</option>
		        <option value="1" >外部账户</option> 
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
			<a class="layui-layer-btn0" url = "${ctx}/system/user/addUser">确定</a><a class="layui-layer-btn1">取消</a>
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
<script type="text/javascript" src="${ctx}/static/js/system/user/user.js" ></script>
<script>
$(function(){
	UserAddCls.init();
})
</script>