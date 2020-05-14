<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%-- 静态包含，base标签、css样式、jQuery --%>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("button.addToCart").click(function () {
                let bookId = $(this).attr("bookId");
                location.href="cartServlet?action=addItem&id=" + bookId;
            });
        });
    </script>
</head>
<body>

    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.gif" >
        <span class="wel_word">网上书城</span>
        <div>
            <%-- 用户未登录 --%>
            <c:if test="${empty sessionScope.user}">
                <a href="pages/user/login.jsp">登录</a> |
                <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
            </c:if>
            <%-- 用户已登录 --%>
            <c:if test="${not empty sessionScope.user}">
                <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
                <a href="pages/order/order.jsp">我的订单</a>
                <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
            </c:if>
            <a href="pages/cart/cart.jsp">购物车</a>
            <a href="pages/manager/manager.jsp">后台管理</a>
        </div>
    </div>

    <div id="main">
        <div id="book">
            <%-- 价格搜索框 --%>
            <div class="book_cond">
                <form action="clientServlet?action=queryByPrice" method="post">
                    价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                    <input id="max" type="text" name="max" value="${param.max}"> 元
                    <input type="submit" value="查询" />
                </form>
            </div>
            <%-- 购物车信息 --%>
            <div style="text-align: center">
                <c:if test="${empty sessionScope.cart.items}">
                    <div>
                        <span style="color: red">当前购物车为空</span>
                    </div>
                </c:if>
                <c:if test="${not empty sessionScope.cart.items}">
                    <span>您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
                    <div>
                        您刚刚将<span style="color: red"> ${sessionScope.lastName} </span>加入到了购物车中
                    </div>
                </c:if>
            </div>
            <%-- 图书 --%>
            <c:forEach items="${requestScope.page.data}" var="book">
                <div class="b_list">
                    <div class="img_div">
                        <img class="book_img" alt="" src="${book.imgPath}" />
                    </div>
                    <div class="book_info">
                        <div class="book_name">
                            <span class="sp1">书名:</span>
                            <span class="sp2">${book.name}</span>
                        </div>
                        <div class="book_author">
                            <span class="sp1">作者:</span>
                            <span class="sp2">${book.author}</span>
                        </div>
                        <div class="book_price">
                            <span class="sp1">价格:</span>
                            <span class="sp2">￥${book.price}</span>
                        </div>
                        <div class="book_sales">
                            <span class="sp1">销量:</span>
                            <span class="sp2">${book.sales}</span>
                        </div>
                        <div class="book_amount">
                            <span class="sp1">库存:</span>
                            <span class="sp2">${book.stock}</span>
                        </div>
                        <div class="book_add">
                            <button bookId="${book.id}" class="addToCart">加入购物车</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div id="page_nav">
            <%-- 首页、上一页 --%>
            <c:if test="${requestScope.page.pageNo != 1}">
                <a href="clientServlet?action=index&pageNo=1">首页</a>
                <a href="clientServlet?action=index&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
            </c:if>
            <%-- 计算页码输出范围 --%>
            <c:choose>
                <%-- 总页数 <= 5 --%>
                <c:when test="${requestScope.page.pageCount <= 5}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${requestScope.page.pageCount}"/>
                </c:when>
                <%-- 总页数 > 5 --%>
                <c:when test="${requestScope.page.pageCount > 5}">
                    <%-- 当前页码为前三个 --%>
                    <c:choose>
                        <c:when test="${requestScope.page.pageNo <= 3}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="5"/>
                        </c:when>
                        <%-- 当前页码为后三个 --%>
                        <c:when test="${requestScope.page.pageNo > requestScope.page.pageCount - 3}">
                            <c:set var="begin" value="${requestScope.page.pageCount - 4}"/>
                            <c:set var="end" value="${requestScope.page.pageCount}"/>
                        </c:when>
                        <%-- 当前页码不是前三个，也不是后三个 --%>
                        <c:otherwise>
                            <c:set var="begin" value="${requestScope.page.pageNo - 2}"/>
                            <c:set var="end" value="${requestScope.page.pageNo + 2}"/>
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>
            <%-- 输出页码 --%>
            <c:forEach begin="${begin}" end="${end}" var="i">
                <c:if test="${requestScope.page.pageNo == i}">
                    【${i}】
                </c:if>
                <c:if test="${requestScope.page.pageNo != i}">
                    <a href="clientServlet?action=index&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
            <%-- 下一页、末页 --%>
            <c:if test="${requestScope.page.pageNo != requestScope.page.pageCount}">
                <a href="clientServlet?action=index&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
                <a href="clientServlet?action=index&pageNo=${requestScope.page.pageCount}">末页</a>
            </c:if>
            <%-- 总页数，总记录数 --%>
            &nbsp;
            共${requestScope.page.pageCount}页，${requestScope.page.dataCount}条记录&nbsp;&nbsp;
            <%-- 到第几页 --%>
            到第&nbsp;<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>&nbsp;页&nbsp;
            <input id="searchPageBtn" type="button" value="确定">
            <script type="text/javascript">
                $(function () {
                    //跳到指定页码
                    $("#searchPageBtn").click(function () {
                        const pageNo = $("#pn_input").val();
                        location.href = "${pageScope.basePath}clientServlet?action=index&pageNo=" + pageNo;
                    });
                })
            </script>
        </div>

    </div>

    <%-- 静态包含，页脚内容 --%>
    <%@ include file="/pages/common/footer.jsp" %>

</body>
</html>