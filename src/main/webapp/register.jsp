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
</head>
<body>
	新用户注册
	<br />
	<form action="register.do">
		用户名: <input type="text" name="userName" value="" /> <br /> 密码： <input
			type="password" name="passWd" value="" /> <br /> 确认密码： <input
			type="password" name="passWd" value="" /> <br /> 电话号码： <input
			type="text" name="phone" value="" /> <br /> 邮箱: <input type="text"
			name="mail" value="" /> <br /> 性别: <input type="radio" name="sex"
			value="0" checked="checked" />男 <input type="radio" name="sex"
			value="1" checked="checked" />女 <br /> 地址: <select
			name="address" style="width: 120px;">
			<option value="bj">北京</option>
			<option value="ln">辽宁</option>
			<option value="hn">湖南</option>
		</select> <br /> 简介:
		<textarea name="summary" rows="6" cols="20"></textarea>
		<br /> <input type="submit" value="确定" /> <input type="reset"
			value="重置" />
	</form>
</body>
</html>