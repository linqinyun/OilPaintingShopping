<%--
  Created by IntelliJ IDEA.
  User: ZHR
  Date: 2021/3/5
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/js1.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/assets/img/favicon.ico">
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/image/logo.png">
    </div>
    <div class="menu"   onclick="show_menu()" onmouseleave="show_menu1()">
        <div class="menu_title" ><a href="###">内容分类</a></div>
        <ul id="title">
            <c:forEach var="c" items="${categoryList}">
                <li>${c.cname}</li>
            </c:forEach>
        </ul>
    </div>
    <div class="auth">
        <ul>
            <li><a href="#">登录</a></li>
            <li><a href="#">注册</a></li>
        </ul>
    </div>
</div>
<div class="content">
    <div class="banner">
        <img src="${pageContext.request.contextPath}/image/welcome.png" class="banner-img">
    </div>
    <div class="img-content">
        <ul>
            <c:forEach var="p" items="${pageBean.list}">
                <li>
                    <img src="${pageContext.request.contextPath}${p.path}" class="img-li">
                    <div class="info">
                        <h3>${p.pname}</h3>
                        <p>
                            ${p.description}
                        </p>
                        <div class="img-btn">
                            <div class="price">￥${p.price}</div>
                            <a href="#" class="cart">
                                <div class="btn">
                                    <img src="${pageContext.request.contextPath}/image/cart.svg">
                                </div>
                            </a>
                        </div>
                    </div>
                </li>
            </c:forEach>


        </ul>
    </div>
    <div class="page-nav">
        <ul>
            <c:if test="${pageBean.page != 1}">
                <li><a href="${pageContext.request.contextPath}/IndexServlet?page=1">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/IndexServlet?page=${pageBean.page-1}">上一页</a></li>
            </c:if>

            <c:forEach var="i" begin="1" end="${pageBean.totalPage}">
                <c:if test="${pageBean.page == i}">
                    <li><span class="first-page">${i}</span></li>
                </c:if>
                <c:if test="${pageBean.page != i}">
                    <li><a href="${pageContext.request.contextPath}/IndexServlet?page=${i}">${i}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${pageBean.page != pageBean.totalPage}">
                <li><a href="${pageContext.request.contextPath}/IndexServlet?page=${pageBean.page+1}">下一页</a></li>
                <li><a href="${pageContext.request.contextPath}/IndexServlet?page=${pageBean.totalPage}">尾页</a></li>
            </c:if>

        </ul>
    </div>
</div>
<div class="footer"></div>
</body>
</html>
