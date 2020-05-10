<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>02-if标签.jsp</title>
</head>
<body>
    <c:if test="true">
        haha
    </c:if>
    <br>
    <c:if test="${12 == 12}">
        hehe
    </c:if>
</body>
</html>
