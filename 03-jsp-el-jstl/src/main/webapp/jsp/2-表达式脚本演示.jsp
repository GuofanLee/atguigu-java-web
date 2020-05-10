<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>2-表达式脚本演示.jsp</title>
</head>
<body>
    <%-- jsp 被翻译为 Servlet 时，所有表达式脚本都会被翻译到 service() 方法中，并以 out.print() 方法打印输出到页面 --%>
    <%-- 输出整形 --%>
    <%= 12 %> <br>
    <%-- 输出浮点型 --%>
    <%= 12.12 %> <br>
    <%-- 输出字符串 --%>
    <%= " 我是字符串" %> <br>
    <%-- 表达式脚本访问域对象 --%>
    <%= request.getParameter("username") %>
</body>
</html>
