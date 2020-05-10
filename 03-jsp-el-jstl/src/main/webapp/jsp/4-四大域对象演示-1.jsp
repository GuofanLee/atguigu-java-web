<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>4-四大域对象演示-1.jsp</title>
</head>
<body>
    <h1>四大域对象演示页面1</h1>
    <%
        // 往四个域中分别保存数据
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
    pageContext 域是否有值：<%= pageContext.getAttribute("key") %> <br>
    request 域是否有值：<%= request.getAttribute("key") %> <br>
    session 域是否有值：<%= session.getAttribute("key") %> <br>
    application 域是否有值：<%= application.getAttribute("key") %> <br>
    <%
        //请求转发到下一个页面
        //request.getRequestDispatcher("/jsp/5-四大域对象演示-2.jsp").forward(request,response);
    %>
</body>
</html>
