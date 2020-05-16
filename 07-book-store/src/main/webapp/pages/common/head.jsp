<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
                      + "://"
                      + request.getServerName()
                      + ":"
                      + request.getServerPort()
                      + request.getContextPath()
                      + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<!-- base 标签用来定义相对路径的定位基准 -->
<base href="${pageScope.basePath}">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>