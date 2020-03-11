<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<form name="login" id="login" action="main.jsp" method="post">
    <div>
        使用JSP登录
    </div>
    <div>
        用户名:<input placeholder="请输入登录号" type="text" name="userid" value="">
    </div>
    <div>
        密码:<input placeholder="请输入密码" type="password" name="password" value="">
    </div>
    <div>
        <input type="submit" value="登录">
    </div>
</form>
</body>
</html>