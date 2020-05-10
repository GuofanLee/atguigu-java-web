<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>4-el表达式的11个隐含对象.jsp</title>
</head>
<body>

    <h2>EL 表达式隐含的 4 个表示域数据的对象</h2>
    <%
        pageContext.setAttribute("key", "pageContextValue");
        request.setAttribute("key", "requestValue");
        session.setAttribute("key", "sessionValue");
        application.setAttribute("key", "applicationValue");
    %>
    ${pageScope.key} <br>
    ${requestScope.key} <br>
    ${sessionScope.key} <br>
    ${applicationScope.key} <br>
    <hr>

    <h2>EL 表达式隐含的 pageContext 对象</h2>
    <h3>通过 pageContext 对象获取 jsp 九大内置对象中的其它八大对象</h3>
    request对象：${pageContext.request} <br>
    response对象：${pageContext.response} <br>
    session对象：${pageContext.session} <br>
    servletContext对象：${pageContext.servletConfig} <br>
    servletConfig对象：${pageContext.servletContext} <br>
    out对象：${pageContext.out} <br>
    page（当前jsp）对象：${pageContext.page} <br>
    exception对象（page 指令中设置 isErrorPage="true" 的时候才有）：${pageContext.exception} <br>

    <h3>通过 pageContext 对象获取 request 对象，再获取 request 对象中的一些信息</h3>
    获取请求协议：<%=request.getScheme()%> 或 ${pageContext.request.scheme} <br>
    获取服务器 IP 或域名：<%=request.getServerName()%> 或 ${pageContext.request.serverName} <br>
    获取服务器端口号：<%=request.getServerPort()%> 或 ${pageContext.request.serverPort} <br>
    获取当前工程路径：<%=request.getContextPath()%> 或 ${pageContext.request.contextPath} <br>
    获取请求方式：<%=request.getMethod()%> 或 ${pageContext.request.method} <br>
    获取客户端 IP 地址：<%=request.getRemoteAddr()%> 或 ${pageContext.request.remoteAddr} <br>
    <hr>

    <h2>EL 表达式隐含的 param 和 paramValues 对象</h2>
    <!--http://localhost:8080/03-jsp-el-jstl/el/4-el表达式的11个隐含对象.jsp?userName=tom&hobby=haha&hobby=hehe-->
    使用 param 对象获取请求参数 usrName 的值：${param.userName} <br>
    使用 paramValues 对象获取请求参数 hobby 的值（paramValues 用于获取多个同名参数的值，如多选框）：${paramValues.hobby[0]} ${paramValues.hobby[1]} <br>
    <hr>

    <h2>EL 表达式隐含的 header 和 headerValues 对象</h2>
    使用 header 对象获取请求头中 User-Agent 的值（header 返回的是一个 map，而 User-Agent 含有特殊字符的 key）：${header['User-Agent']} <br><br>
    使用 header 对象获取请求头中 Accept 的值：${header.Accept} <br><br>
    使用 headerValues 对象获取请求头中 Connection 的值：${headerValues.Connection[0]} <br>
    <hr>

    <h2>EL 表达式隐含的 cookie 对象</h2>
    使用 cookie 对象获取 cookie 的 name：${cookie.JSESSIONID.name} <br>
    使用 cookie 对象获取 cookie 的 value：${cookie.JSESSIONID.value} <br>
    <hr>

    <h2>EL 表达式隐含的 initParam 对象</h2>
    使用 initParam 对象获取 web.xml 中的所有 context-param：${initParam} <br>
    使用 initParam 对象获取 web.xml 中 param-name 为 userName 的 context-param 的 param-value：${initParam.userName} <br>
    使用 initParam 对象获取 web.xml 中 param-name 为 password 的 context-param 的 param-value：${initParam.password} <br>
    <hr>

</body>
</html>
