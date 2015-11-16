<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<style type="text/css">
body {
	font-size: 30px;
}
</style>
<script>
function checkuser(username){
	if(username.value==""){
		alert("请输入用户名");
		return false;
	}
}
</script>
</head>
<body>
	用户登入
	<br />
	<form action="login.do">
		用户名: <input type="text" name="userName" value="" /> <br /> 密码： <input
			type="password" name="passWd" value="" /> <br /> <input
			type="submit" value="确定" /> <input type="reset" value="重置" /> <br />
		<a href="register.jsp">注册</a>

	</form>
</body>
</html>




<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>regist.jsp</title>
    <style>
    	.s1{
    		color:red;
    		font-size:24px;
    		font-style:italic;
    		}
    </style>
	
		<script type="text/javascript"
			src="js/prototype-1.6.0.3js"></script>
		<script type="text/javascript">
		
		function getXmlHttpRequest(){
			var xhr = null;
			if((typeof XMLHttpRequest)!='undefined'){
				xhr = new XMLHttpRequest();
				}else{
					xhr = new ActiveXObject('Microsoft.XMLHttp');
				}
				return xhr;
		}
		
		
		function check_username(){
				
				//step1 获得XmlHttpRequest对象
				var xhr = getXmlHttpRequest();
				//step2 发送请求
				alert(document.getElementById(username));
				xhr.open('get','check_username.do?username='+document.getElementById(username),true);
				alert(111);
				xhr.onreadystatechange=function(){
				//step4 获取服务器返回的数据，更新页面
					if(xhr.readyState == 4){
					if(xhr.status == 200){
						var txt = xhr.responseText;
						$('username_msg').innerHTML = txt;			
					}else{
						$('username_msg').innerHTML = '系统错误，稍后重试'; 
						}
					}else{
						$('username_msg').innerHTML = '正在验证。。。';
					}
				};
		xhr.send(null);	
		}

		function check_username2(){
			//step1 获得XmlHttpRequest对象
			var xhr = getXmlHttpRequest();
			//step2 发送请求
			xhr.open('post','check_username.do',true);
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xhr.onreadystatechange = function(){
			//step4 获取服务器返回的数据，更新页面
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					var txt = xhr.responseText;
					$('username_msg').innerHTML = txt;
				}else{
					$('usernmae_msg').innerHTML = '系统错误，稍后重试';
					}
				}else{
					$('username_msg').innerHTML = '正在验证';	
				}		
			};
			xhr.send('username =' +$F('username'));				
		}	
		</script>
</head>

<body style= 'font-size:30px;'>
	<form action="rigist.do" method="post">
		用户名：<input name="username" id="username" onblur="check_username();"/>
		<span class = "s1" id="username_msg"></span>
		<br/>
		密码：<input type="password" name="pwd" id="pwd"/><br/>
		<input type="submit" value="确认"/>
	</form>
</body>
</html>










