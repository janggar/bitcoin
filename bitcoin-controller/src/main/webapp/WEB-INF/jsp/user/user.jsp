<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String path =request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>测试接口专用页面</title>
<style>
.btn {
	cursor: hand;
	color: red;
	font-size: 20px;
	height: 45px;
	/* text-decoration: none; */
}

.span {
	color: green;
	font-size: 16px;
}

.css1{
margin-bottom: 10px;
margin-top: 10px;
}

.css2{
margin-bottom: 5px;

}
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/plugins/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var name=$("#getName").attr("value");
	console.log(name);
})
function getUserData(){
	$.ajax({
		url : "<%=path%>" + "/user/getUser.do",
		data : {
			userId : 1
		},
		dataType : 'JSON',
		type : 'POST',
		cache : false,
		success : function(data) {
			console.log(data);
			console.log(data[0].id);
			console.log(data.responseText);
		}
	});
}

function springRmiTest(){
	$.ajax({
		url : "<%=path%>" + "/user/springRmi.do",
		dataType : 'JSON',
		type : 'POST',
		cache : false,
		success : function(data) {
			if(data.success){
				alert("spring rmi 测试成功！");
				alert(data.rmiStr);
				console.log(data.rmiStr);
			}else{
				alert("spring rmi 测试失败！");
			}
		}
	});
}
</script>
</head>
<body>
	<!--测试-->
	<ul>
		<li style="list-style-type:none;">测试列表如下：</li>
		<li style="list-style-type:none;"><ul>
				<li style="list-style-type:none;" class="css1">体验金相关：</li>
				<li style="list-style-type:none;"><ol class="">
						<li class="css2" id="getData" ><font color="green">getUser (获取用户信息):</font><a href="javascript:void(0)" class="btn" onclick="getUserData();">戳我开始测试</a></li>
						<li class="css2"><a href="javascript:void(0)" class="btn">戳我开始测试</a></li>
						<li class="css2"><a href="javascript:void(0)" class="btn">戳我开始测试</a></li>
						<li class="css2"><a href="javascript:void(0)" class="btn" onclick="springRmiTest()">spring rmi 戳我开始测试</a></li>
						<li class="css2"><a href="javascript:void(0)" class="btn" id="getName" value="${name}">${name }</a></li>
						<li class="css2"><a href="javascript:void(0)" class="btn">${sex}</a></li>
					</ol></li>
			</ul></li>
	</ul>

</body>

</html>