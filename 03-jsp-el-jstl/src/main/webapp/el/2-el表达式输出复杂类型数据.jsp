<%@ page import="com.atguigu.bean.Person" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>2-el表达式输出复杂类型数据.jsp</title>
</head>
<body>
    <%
        //创建 person 对象，填充数据
        Person person = new Person();
        person.setAge(18);
        person.setHobby(new String[]{"唱", "跳", "Rap", "篮球"});
        person.setAddress(Arrays.asList("北京市", "朝阳区"));
        Map<String, String> params = new HashMap<>();
        params.put("name", "菜虚空");
        params.put("email", "cxk@sb.com");
        person.setParams(params);
        //将 person 对象放到 pageContext 域中
        pageContext.setAttribute("person", person);
    %>
    输出 person 对象：${person} <br>
    输出 person 中的普通属性：${person.age} <br>
    输出 person 中的数组（地址值）：${person.hobby} <br>
    输出 person 中的数组的某个值（通过指定数组下标）：${person.hobby[0]} <br>
    输出 person 中的 List 属性：${person.address} <br>
    输出 person 中的 List 属性的某个值（通过指定下标）：${person.address[0]} <br>
    输出 person 中的 Map 属性：${person.params} <br>
    输出 person 中的 Map 属性的某个 key 的值（通过指定key）：${person.params.name} <br>
</body>
</html>
