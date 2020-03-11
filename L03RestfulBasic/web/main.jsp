<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
  String Title = "登录标题";

  String userid = request.getParameter("userid");
  String password = request.getParameter("password");
  String msg = "";
    if("admin".equals(userid) && "123456".equals(password)){
        msg = "Login OK";
    } else {
        msg = "Login Fail";
    }
%>
<html>
  <head>
    <title><%=Title%></title>
  </head>
  <body>
  <div style="color: red;"><%=msg%></div>
  <P>
      这里是好多好多的页面功能
  </P>
  </body>
</html>
