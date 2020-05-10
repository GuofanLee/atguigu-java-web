<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>03-choose-when-otherwise标签.jsp</title>
</head>
<body>

    <%
        request.setAttribute("age", 80);
    %>

    <c:choose>
        <c:when test="${requestScope.age < 3}">
            <p>婴幼儿</p>
        </c:when>
        <c:when test="${requestScope.age < 10}">
            <p>儿童</p>
        </c:when>
        <c:when test="${requestScope.age < 18}">
            <p>青少年</p>
        </c:when>
        <c:when test="${requestScope.age < 35}">
            <p>青年</p>
        </c:when>
        <c:when test="${requestScope.age < 60}">
            <p>中年</p>
        </c:when>
        <c:otherwise>
            <p>老年</p>
        </c:otherwise>
    </c:choose>

</body>
</html>
