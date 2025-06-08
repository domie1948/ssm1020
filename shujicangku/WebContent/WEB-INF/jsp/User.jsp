<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	 /*
    @Author:Jaylan Zhou
    @Date:
    @projectName:
    @TEL:13166803607
    @QQ:764540631
    */

	/*
	    全路径,形式如下:
	    request.getScheme():获取http协议
	    request.getServerName():获取本地服务器名
	    request.getServerPort():获取服务器端口号
	    path:访问路径
	*/
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
<title>请输入标题</title>
<link rel="stylesheet" type="text/css" href="css/css/background/skin.css" />
<script type=text/javascript src="js/js/foreground/jquery.min.js"></script>
</head>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!-- 头部开始 -->
            <tr>
                <td width="17" valign="top" background="image/image/background/mail_left_bg.gif">
                    <img src="image/image/background/left_top_right.gif" width="17" height="29" />
                </td>
                <td valign="top" background="image/image/background/content_bg.gif">
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="image/image/background/content_bg.gif">
                        <tr><td height="31"><div class="title">用户信息</div></td></tr>
                    </table>
                </td>
                <td width="16" valign="top" background="image/image/background/mail_right_bg.gif"><img src="image/image/background/nav_right_bg.gif" width="16" height="29" /></td>
            </tr>
            <!-- 中间部分开始 -->
            <tr>
                <!--第一行左边框-->
                <td valign="middle" background="image/image/background/mail_left_bg.gif">&nbsp;</td>
                <!--第一行中间内容-->
                <td valign="top" bgcolor="#F7F8F9">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <tr>
                            <td colspan="4">
                                <table>
                                    <tr>
                                        <td width="100" align="center"><img src="image/image/background/mime.gif" /></td>
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">用户信息修改</h3></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 添加产品开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="user/userUpdate" method="post" onsubmit="return check();">
                                            <input type="hidden" value="${user['id'] }" name="id">
                                            <input type="hidden" name="oldPassword" value="${user['loginPassword'] }" >
                                                <table width="100%"class="cont">
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="15%">登录名：</td>
                                                        <td width="25%"><input type="text" name="loginName" id="loginName" value="${user['loginName'] }"></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="15%">修改密码：</td>
                                                        <td width="25%"><input type="text" name="loginPassword" id="loginPassword" value="${user['loginPassword'] }"></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="15%">姓名：</td>
                                                        <td width="25%"><input type="text" name="userName" id="userName" value="${user['userName'] }"></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="15%">电话：</td>
                                                        <td width="25%"><input type="text" name="phoneNo" id="phoneNo" value="${user['phoneNo'] }"></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <c:if test="${sessionScope['User']['roleInfo']['id'] eq 1}">
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="15%">角色：</td>
                                                        <td width="25%">
                                                        	<c:if test="${message!=null }">
                                                        		<c:out value="${message }"></c:out>
                                                        	</c:if>
                                                        	<select name="roleId" id="roleId">
                                                        		<c:forEach items="${role }" var="role">
	                                                        		<c:if test="${role['id'] eq user['roleId']}" var="s1">
		                                                        		<option value="${role['id'] }" selected="selected">${role['title'] }</option>
	                                                        		</c:if>
	                                                        		<c:if test="${!s1}">
		                                                        		<option value="${role['id'] }">${role['title'] }</option>
	                                                        		</c:if>
                                                        		</c:forEach>
                                                        	</select>
                                                        </td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    </c:if>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="15%">备注：</td>
                                                        <td width="25%"><textarea name="remark" id="remark">${user['remark'] }</textarea></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                     <tr>
                                                        <td colspan="4"><input type="submit" value="修改信息"></td>
                                                    </tr>
                                                    
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 添加产品结束 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="51%" class="left_txt">
                            </td>
                            <td>&nbsp;</td><td>&nbsp;</td>
                        </tr>
                    </table>
                </td>
                <td background="image/image/background/mail_right_bg.gif">&nbsp;</td>
            </tr>
            <!-- 底部部分 -->
            <tr>
                <td valign="bottom" background="image/image/background/mail_left_bg.gif">
                    <img src="image/image/background/buttom_left.gif" width="17" height="17" />
                </td>
                <td background="image/image/background/buttom_bgs.gif">
                    <img src="image/image/background/buttom_bgs.gif" width="17" height="17">
                </td>
                <td valign="bottom" background="image/image/background/mail_right_bg.gif">
                    <img src="image/image/background/buttom_right.gif" width="16" height="17" />
                </td>           
            </tr>
        </table>
    </body>
    <script type="text/javascript">
function check(){
	var loginName = $("#loginName").val();
	var loginPassword = $("#loginPassword").val();
	var userName = $("#userName").val();
	var phoneNo = $("#phoneNo").val();
	var roleId = $("#roleId").val();
	var remark = $("#remark").val();
	if(loginName==null||loginName==''){
		alert("请输入登录名!");
		return false;
	}
	if(loginPassword==null||loginPassword==''){
		alert("请输入密码!");
		return false;
	}
	if(userName==null||userName==''){
		alert("请输入姓名!");
		return false;
	}
	if(phoneNo==null||phoneNo==''){
		alert("请输入电话!");
		return false;
	}
	if(roleId==null||roleId==''){
		alert("请选择角色!");
		return false;
	}
	if(remark==null||remark==''){
		alert("请输入备注!");
		return false;
	}
	return true;
}
</script>
</html>