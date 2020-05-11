<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload.jsp</title>
</head>
<body>
    <form action="http://localhost:8080/04-upload-download/uploadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="userName"><br>
        头  像：<input type="file" name="img"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
