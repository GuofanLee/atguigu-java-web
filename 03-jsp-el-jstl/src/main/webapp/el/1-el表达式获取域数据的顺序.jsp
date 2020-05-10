<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>1-el表达式获取域数据的顺序.jsp</title>
</head>
<body>
    <%
        // 往四个域中保存了 key 相同的数据
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
    ${ key }
</body>
</html>
