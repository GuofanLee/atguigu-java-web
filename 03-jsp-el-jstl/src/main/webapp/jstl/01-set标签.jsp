<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>01-set标签.jsp</title>
</head>
<body>
    set 标签在 request 域中保存数据之前：${requestScope.userName}<br>
    <c:set scope="request" var="userName" value="root" />
    set 标签在 request 域中保存数据之后：${requestScope.userName}
</body>
</html>
