<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>04-forEach标签.jsp</title>
</head>
<body>

    <h3>使用 forEach 标签遍历输出 1 到 10</h3>
    <table>
        <c:forEach begin="1" end="10" var="i">
            <tr>
                <td>第${i}行</td>
            </tr>
        </c:forEach>
    </table>
    <hr>

    <h3>使用 forEach 标签遍历数组</h3>
    <%
        request.setAttribute("arr", new String[]{"唱", "跳", "Rap", "篮球"});
    %>
    <c:forEach items="${requestScope.arr}" var="item">
            ${item}<br>
    </c:forEach>
    <hr>

    <h3>使用 forEach 标签遍历 Map 集合</h3>
    <%
        Map<String, String> map = new HashMap<>();
        map.put("userName", "root");
        map.put("password", "123456");
        request.setAttribute("map", map);
    %>
    <c:forEach items="${requestScope.map}" var="entry">
        ${entry.key} = ${entry.value} <br>
    </c:forEach>
    <hr>

    <h3>使用 forEach 标签遍历 List 集合</h3>
    <%
        request.setAttribute("list", Arrays.asList("北京", "上海", "南京"));
    %>
    <c:forEach items="${requestScope.list}" var="item">
        ${item} <br>
    </c:forEach>
    <hr>


    <h3>forEach 标签的其它属性</h3>
    <%
        request.setAttribute("list", Arrays.asList("北京", "上海", "南京", "广州", "深圳"));
    %>
    <table>
        <c:forEach begin="1" end="3" step="2" varStatus="status" items="${requestScope.list}" var="item">
            <tr>
                <td>数据：${item}</td>
                <td>当前索引：${status.index}</td>
                <td>当前是第几条数据：${status.count}</td>
                <td>当前数据是否是第一条数据：${status.first}</td>
                <td>当前数据是否是最后一条数据：${status.last}</td>
                <td>获取 begin 属性的值：${status.begin}</td>
                <td>获取 end 属性的值：${status.end}</td>
                <td>获取 step 属性的值：${status.step}</td>
            </tr>
        </c:forEach>
    </table>
    <hr>

</body>
</html>
