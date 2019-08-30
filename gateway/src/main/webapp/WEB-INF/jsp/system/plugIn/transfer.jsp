<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="utf-8">
  <title>用户角色关系表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<%@include file="../../common/common.jsp"%>
</head>
<body>
<div id="transfer" class="demo-transfer" style="margin:20px;"></div>
 <button type="button" style="margin:20px;" class="layui-btn" lay-demotransferactive="getData">确定</button>
 <button type="button" style="margin:20px;" class="layui-btn" lay-demotransferactive="closeD">关闭</button>
<script>
var userId = ${userId};
layui.use(['transfer', 'layer', 'util'], function(){
  var $ = layui.$
  ,transfer = layui.transfer
  ,layer = layui.layer
  ,util = layui.util;
  //模拟数据
  var data1 = ${roleList};
  //穿梭时的回调
  transfer.render({
	id: 'myTransfer' //定义唯一索引
    ,elem: '#transfer'
    ,data: data1
    ,title: ['未绑定角色权限资源', '以绑定角色权限资源']  //自定义标题
    ,value: ${roleNotList}
    ,onchange: function(obj, index){
      var arr = ['添加', '减少'];
      layer.alert('<strong>'+ arr[index] + '</strong> ：'+ JSON.stringify(obj[0].title)+'角色'); //获得被穿梭时的数据
    }
  });
//批量办法定事件
  util.event('lay-demoTransferActive', {
    getData: function(othis){
      var getData = transfer.getData('myTransfer'); //获取右侧数据
      var newArr = new Array();
      for (let j = 0; j < getData.length; j++) {
    	  newArr.push(getData[j].value);
        };
       var roles = '';
       debugger;
        for (var i = 0; i < newArr.length; i++) {
      	  roles += newArr[i]+','
       }
        var data = {
        		roles : roles,
        		userId:userId
        }
        var url  = "${ctx}/system/user/bindingRole"
        $.ajax({
            url: url,
            data: data,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            type: 'post',
            dataType:"json",
            async:  true,
            success: function (data) {
            	if(data && data.success){
    				layer.msg(data.message)
    				parent.layer.closeAll();
    				return;
    			}else if(data && !data.success){
    				layer.msg(data.message)
    				return;
    			}
            },
            error: function (err) {
        			layer.msg("当前无权限或系统错误,请联系管理员")
            }
        })
    },
    closeD:function(){
    	parent.layer.closeAll();
      }
  })
});

</script>
</body>
</html>