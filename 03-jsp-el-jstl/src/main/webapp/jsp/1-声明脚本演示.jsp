<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>1-声明脚本演示.jsp</title>
</head>
<body>

    <%-- jsp 被翻译为 Servlet 时，声明脚本会被翻译为类的成员 --%>

    <%-- 1、声明属性 --%>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;
    %>

    <%-- 2、声明静态代码块 --%>
    <%!
        static {
            map = new HashMap<>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
        }
    %>

    <%-- 3、声明方法 --%>
    <%!
        public int abc(){
            return 12;
        }
    %>

    <%-- 4、声明内部类 --%>
    <%!
        public static class A {
            private Integer id = 12;
            private String abc = "abc";
        }
    %>

</body>
</html>
