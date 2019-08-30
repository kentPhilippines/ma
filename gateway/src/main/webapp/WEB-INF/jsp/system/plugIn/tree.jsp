<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>树形角色资源关系图</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<%@include file="../../common/common.jsp"%>
</head>
<body>
    <form class="layui-form">
        <!--xtree容器 begin-->
        <div id="layui-xtree-demo1" style="width:400px;height:400px; border:1px solid black; margin:20px;overflow:auto;float:left;"></div>
        <input type="button" class="layui-btn" style="margin:20px" value="确认" id="btnEnter" />
        <input type="button" class="layui-btn" style="margin:20px" value="取消" id="btnEsc" />
	</form>
</body>
<script type="text/javascript" src="${ctx}/static/js/layui/layui-xtree.js"></script>
<script type="text/javascript">
	var roleId =${roleId}
</script>
<script type="text/javascript" src="${ctx}/static/js/system/plugIn/tree.js" ></script>