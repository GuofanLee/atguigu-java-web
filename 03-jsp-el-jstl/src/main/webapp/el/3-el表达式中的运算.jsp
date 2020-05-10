<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>3-el表达式中的运算.jsp</title>
</head>
<body>

    <p>el 表达式中的关系运算</p>
    ${ 5 == 5 }  或  ${ 5 eq 5 } <br>
    ${ 5 != 5 } 或 ${ 5 ne 5 } <br>
    ${ 3 < 5 }  或  ${ 3 lt 5 } <br>
    ${ 3 > 5 }  或  ${ 3 gt 5 } <br>
    ${ 5 <= 10 }  或  ${ 5 le 10 } <br>
    ${ 5 >= 10 }  或  ${ 5 ge 10 } <br>
    <hr>

    <p>el 表达式中的逻辑运算</p>
    ${ 12 == 12 && 12 < 11 }  或  ${ 12 == 12 and 12 < 11} <br>
    ${ 12 == 12 || 12 < 11 }  或  ${ 12 == 12 or 12 < 11} <br>
    ${ !true }  或  ${ not true } <br>
    <hr>

    <p>el 表达式中的算数运算</p>
    ${ 12 + 12 } <br>
    ${ 12 - 12 } <br>
    ${ 12 * 12 } <br>
    ${ 12 / 12 }  或  ${ 12 div 12 } <br>
    ${ 12 % 12 }  或  ${ 12 mod 12 } <br>
    <hr>

    <p>el 表达式中的 empty 运算</p>
    <%
        //值为 null 的情况
        request.setAttribute("emptyNull", null);
        //值为空串的情况
        request.setAttribute("emptyStr", "");
        //值是 Ojbect 类型的数组，但长度为0的情况
        request.setAttribute("emptyArr", new Object[]{});
        //值是 List 集合，但元素个数为0的情况
        request.setAttribute("emptyList", new ArrayList<>());
        //值是 Map 集合，但元素个数为0的情况
        request.setAttribute("emptyMap", new HashMap<>());
    %>
    ${ empty emptyNull } <br>
    ${ empty emptyStr } <br>
    ${ empty emptyArr } <br>
    ${ empty emptyList } <br>
    ${ empty emptyMap } <br>
    <hr>

    <p>el 表达式中的三元运算</p>
    ${ 12 == 12 ? "哈哈" : "呵呵" } <br>
    <hr>

    <p>用中括号运算符输出 Map 集合的 key 中含有特殊字符的 key 的值</p>
    <%
        Map<String, String> map = new HashMap<>();
        map.put("a.a.a", "a.a.aValue");
        map.put("b+b+b", "b+b+bValue");
        map.put("c-c-c", "c-c-cValue");
        request.setAttribute("map", map);
    %>
    ${ map['a.a.a'] } <br>
    ${ map["b+b+b"] } <br>
    ${ map['c-c-c'] } <br>

</body>
</html>
