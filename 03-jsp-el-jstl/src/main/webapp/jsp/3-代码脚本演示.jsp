<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>3-代码脚本演示.jsp</title>
</head>
<body>
    <%-- 1、代码脚本 - if 语句 --%>
    <%
        int i = 13 ;
        if (i == 12) {
    %>
            <h1>国哥好帅</h1>
    <%
        } else {
    %>
            <h1>国哥又骗人了！</h1>
    <%
        }
    %>
    <br>

    <%-- 2、代码脚本 - for 循环语句 --%>
    <table border = "1" cellspacing = "0">
        <%
            for (int j = 0; j < 10; j++) {
        %>
        <tr>
            <td>第 <%= j + 1 %> 行</td>
        </tr>
        <%
            }
        %>
    </table>

    <%-- 3、代码脚本 - 访问域对象 --%>
    <%
        String username = request.getParameter("userName");
        System.out.println("请求参数 userName 的值是：" + username);
    %>
</body>
</html>
