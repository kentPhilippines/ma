<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
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
						<label class="layui-form-label">登录名</label>
						<div class="layui-input-block">
							<input type="text" name="userId" placeholder="请输入"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<!-- <div class="layui-inline">
						<label class="layui-form-label">手机</label>
						<div class="layui-input-block">
							<input type="text" name="telphone" placeholder="请输入"
								autocomplete="off" class="layui-input">
						</div>
					</div> -->
					<div class="layui-inline">
						<label class="layui-form-label">邮箱</label>
						<div class="layui-input-block">
							<input type="text" name="email" placeholder="请输入"
								autocomplete="off" class="layui-input">
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
					<button class="layui-btn layuiadmin-btn-admin" data-type="add" addUrl = "${ctx}/system/user/userAdd">添加</button>
				</div>
				<table id="LAY-user-back-manage" url = "${ctx}/system/user/userList" lay-filter="LAY-user-back-manage"></table>
			</div>
		</div>
	</div>
	<script type="text/html" id="operation">
 	 <a class="layui-btn layui-btn-xs" lay-event="edit" url = "${ctx}/system/user/userEditShow">编辑</a>
 	 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" url = "${ctx}/system/user/userDel">删除</a>
	</script>
	<script type="text/html" id="roleAndRShow">
 	 <a class="layui-btn layui-btn-xs" lay-event="roleAndR" url = "${ctx}/system/user/roleAndRShow">角色资源详情</a>
	</script>
</body>
</html>
<script type="text/javascript" src="${ctx}/static/js/system/user/user.js" ></script>
<script>
$(function(){
	UserClas.init();
})
</script>