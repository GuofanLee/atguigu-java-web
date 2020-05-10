<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>5-四大域对象演示-2.jsp</title>
</head>
<body>
    <h1>四大域对象页面2</h1>
    pageContext 域是否有值：<%= pageContext.getAttribute("key") %> <br>
    request 域是否有值：<%= request.getAttribute("key") %> <br>
    session 域是否有值：<%= session.getAttribute("key") %> <br>
    application 域是否有值：<%= application.getAttribute("key") %> <br>
</body>
</html>
