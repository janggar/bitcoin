<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String path =request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户资产页</title>
<link  type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet"></script>
<link  type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-table.min.css" rel="stylesheet"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-table.js"></script>
</head>
<body>
<div class="container">
   <div class="row" >
      <div class="col-xs-12 col-md-12">
       <table id="table"></table>
      </div>
   </div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	//初始化资产列表
	initCapitalTable();
	
});

function initCapitalTable(){
	
	$('#table').bootstrapTable({
		url : "get/Capital/list.do",
	    columns: [
	    {field : "platform",title : "资产所属平台",width : "0%",visible:false}, 
	    {field : "userId",title : "用户id",width : "0%",visible:false}, 
	    {field : "capitalId",title : "资产标识",width : "0%",visible:false}, 
	    {field : "isEmpty",title : "资产是否为空",width : "0%",visible:false}, 
		{field : "capitalName",title:"资产英文别名",width : "5%",align : 'center',valign : 'middle'},
		{field: 'chineseName',title: '资产中文名',width : "5%",align : 'center',valign : 'middle'},
		{field : "available",title : "可用资产",width : "15%",align : 'center',valign : 'middle'}, 
		{field : "entryOrder",title : "挂单资产",width : "15%",align : 'center',valign : 'middle'}, 
		{field : "confirming",title : "确认中资产",width : "15%",align : 'center',valign : 'middle'}, 
		{field : "sum",title : "总资产",width : "15%"},
		{field : "operate",title : "操作",width : "20%",align : 'center',valign : 'middle',
			formatter : function(value, row, index) {
//				return "&nbsp;<a href='javascript:void(0);' class='trans-info' data-mtitle='关联押品' data-height='600' data-okevent='ok()' data-remote='update_user_uole.shtml'>编辑</a>";
			}
		}]
	});
}

</script>
</html>