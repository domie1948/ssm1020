<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
操作成功!
</body>
<script type="text/javascript">
    function request(){
        var index = parent.layer.getFrameIndex(Window.name);
        parent.layer.iframeAuto(index);
        window.parent.location.reload();
    }
</script>
</html>