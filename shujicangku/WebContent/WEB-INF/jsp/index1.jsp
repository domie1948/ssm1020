<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	 /*
    @Author:??? Jaylan Zhou
    @Date:
    @projectName:
    @TEL:13166803607
    @QQ:764540631
    */

	/*
	    ???,????:
	    request.getScheme():??http??
	    request.getServerName():????????
	    request.getServerPort():????????
	    path:????
	*/
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<form action="contact/informationAdd"  method="post">
	<tr>
		<td>联系方式:</td>
		<td><input type="text" name="contactWay"></td>
	</tr>
	<tr>
		<td>售后服务:</td>
		<td><input type="text" name="afService"></td>
	</tr>
	<input type="submit" value="提交">
</form>
</body>
</html>