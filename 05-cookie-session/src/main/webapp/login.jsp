<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/loginServlet?action=login" method="post">
        用户名：<input type="text" name="username" value="${cookie.username.value}"> <br>
        密  码：<input type="text" name="password"> <br>
                <input type="submit" value="提交">
    </form>
</body>
</html>
