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
<meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
<base href="<%=basepath%>">
<script src="js/js/background/prototype.lite.js" type="text/javascript"></script>
    <script src="js/js/background/moo.fx.js" type="text/javascript"></script>
    <script src="js/js/background/moo.fx.pack.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/css/background/skin.css" />
    <script type="text/javascript">
        window.onload = function () {
            var contents = document.getElementsByClassName('content');
            var toggles = document.getElementsByClassName('type');

            var myAccordion = new fx.Accordion(
            toggles, contents, {opacity: true, duration: 400}
            );
            myAccordion.showThisHideOpen(contents[0]);
            for(var i=0; i<document .getElementsByTagName("a").length; i++){
                var dl_a = document.getElementsByTagName("a")[i];
                    dl_a.onfocus=function(){
                        this.blur();
                    }
            }
        }
    </script>
</head>

    <table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
        <tr>
            <td width="182" valign="top">
                <div id="container">
                    <!-- *********** -->
                    <h1 class="type"><a href="javascript:void(0)">功能</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        	
                            <tr>
                                <td><img src="image/image/background/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                       
                        </table>
	                        <ul class="RM">
	                        <c:forEach items="${sessionScope['User']['functionRoleRel'] }" var="functionRoleRel">
							<li><a
								href="${functionRoleRel['functionInfo']['url'] }" target="main">${functionRoleRel['functionInfo']['title'] }</a></li>
						</c:forEach>
							<li><a
								href="request/passUpdate" target="main">修改密码</a></li>
							<li><a
								href="user/queryOne?id=${sessionScope['User']['id'] }" target="main">个人信息</a></li>
	                            <c:set var="exitId" value="0"></c:set>
	                        </ul>
                    </div>
                    <!-- *********** -->
                </div>
            </td>
        </tr>
    </table>
</body>
</html>