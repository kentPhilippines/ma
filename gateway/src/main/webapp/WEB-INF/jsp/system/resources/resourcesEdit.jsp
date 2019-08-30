<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>添加用户</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<%@include file="../../common/common.jsp"%>
<body layadmin-themealias="default">
<form id="ResourcesForm" class="form-signin" action="javascript:0" method="post" novalidate="novalidate">
	<div class="layui-form" lay-filter="layuiadmin-form-admin"
		id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
		<input type="hidden" name="resourcesId" lay-verify="required"
					autocomplete="off" class="layui-input" value="${resources.resourcesId}" >
		<div class="layui-form-item ">
			<label class="layui-form-label">资源名称</label>
			<div class="layui-input-inline">
				<input type="text" name="resourcesName" lay-verify="required"
					placeholder="请输入角色昵称" autocomplete="off" class="layui-input" value="${resources.resourcesName}"> 
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">资源描述</label>
			<div class="layui-input-inline">
				<input type="text" name="description" lay-verify="required"
					placeholder="请输入资源描述（这个资源是干什么的）"    autocomplete="off" class="layui-input" value="${resources.description}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">资源Key</label>
			<div class="layui-input-inline">
				<input type="text" name="resourcesKey" lay-verify="required"
					placeholder="请输入资源Key（用作资源分类）"    autocomplete="off" class="layui-input" value="${resources.resourcesKey}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">资源URL</label>
			<div class="layui-input-inline">
				<input type="text" name="resourcesUrl" lay-verify="required"
					placeholder="请输入资源URL（资源路径）"    autocomplete="off" class="layui-input" value="${resources.resourcesUrl}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">资源排名</label>
			<div class="layui-input-inline">
				<input type="text" name="rank" lay-verify="required"
					placeholder="请输入角色备注"    autocomplete="off" class="layui-input" value="${resources.rank}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">资源等级</label>
			<div class="layui-input-inline">
				<input type="text" name="level" lay-verify="required"
					placeholder="请输入资源等级（2，3级资源路径必填）"    autocomplete="off" class="layui-input" value="${resources.level}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">上级菜单名称</label>
			<div class="layui-input-inline">
				<select name="parentId" lay-filter="aihao" >
				<c:forEach items="${menu}" var="menus">
				 <option  value="${menus.resourcesId}" <c:if test="${menus.resourcesId == resources.parentId}">selected='selected'</c:if>      >${menus.resourcesName}</option>
				</c:forEach>
			     </select>
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">状态</label>
		    <div class="layui-input-inline">
		      <select name="status" lay-filter="aihao">
		        <option value="1" selected="selected">有效</option>
		        <option value="0">无效</option>
		      </select>
		    </div>
 		</div>
		<div class="layui-layer-btn layui-layer-btn-">
			<a class="layui-layer-btn0" url = "${ctx}/system/resources/resourcesEdit">确定</a><a class="layui-layer-btn1">取消</a>
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
<script type="text/javascript" src="${ctx}/static/js/system/resources/resources.js" ></script>
<script>
$(function(){
	ResourcesEditCls.init();
})
</script>