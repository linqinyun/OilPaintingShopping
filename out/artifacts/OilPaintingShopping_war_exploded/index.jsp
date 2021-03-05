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
            <li>
                <img src="${pageContext.request.contextPath}/image/wumingnvlang.jpg" class="img-li">
                <div class="info">
                    <h3>无名女郎</h3>
                    <p>
                        图片描述可以分为多种，一种是单一说明，就比如直接的告诉看图者这篇文 章是要介绍什么样子的内容，一些配图可以分为含蓄类型的，这样的配图一般会 图片描述可以分为多种.
                    </p>
                    <div class="img-btn">
                        <div class="price">￥5800</div>
                        <a href="#" class="cart">
                            <div class="btn">
                                <img src="${pageContext.request.contextPath}/image/cart.svg">
                            </div>
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/image/wumingnvlang.jpg" class="img-li">
                <div class="info">
                    <h3>无名女郎</h3>
                    <p>
                        图片描述可以分为多种，一种是单一说明，就比如直接的告诉看图者这篇文 章是要介绍什么样子的内容，一些配图可以分为含蓄类型的，这样的配图一般会 图片描述可以分为多种.
                    </p>
                    <div class="img-btn">
                        <div class="price">￥5800</div>
                        <div class="btn">
                            <a href="#" class="cart">
                                <img src="${pageContext.request.contextPath}/image/cart.svg">
                            </a>
                        </div>
                    </div>
                </div>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/image/wumingnvlang.jpg" class="img-li">
                <div class="info">
                    <h3>无名女郎</h3>
                    <p>
                        图片描述可以分为多种，一种是单一说明，就比如直接的告诉看图者这篇文 章是要介绍什么样子的内容，一些配图可以分为含蓄类型的，这样的配图一般会 图片描述可以分为多种.
                    </p>
                    <div class="img-btn">
                        <div class="price">￥5800</div>
                        <div class="btn">
                            <a href="#" class="cart">
                                <img src="${pageContext.request.contextPath}/image/cart.svg">
                            </a>
                        </div>
                    </div>
                </div>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/image/wumingnvlang.jpg" class="img-li">
                <div class="info">
                    <h3>无名女郎</h3>
                    <p>
                        图片描述可以分为多种，一种是单一说明，就比如直接的告诉看图者这篇文 章是要介绍什么样子的内容，一些配图可以分为含蓄类型的，这样的配图一般会 图片描述可以分为多种.
                    </p>
                    <div class="img-btn">
                        <div class="price">￥5800</div>
                        <div class="btn">
                            <a href="#" class="cart">
                                <img src="${pageContext.request.contextPath}/image/cart.svg">
                            </a>
                        </div>
                    </div>
                </div>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/image/wumingnvlang.jpg" class="img-li">
                <div class="info">
                    <h3>无名女郎</h3>
                    <p>
                        图片描述可以分为多种，一种是单一说明，就比如直接的告诉看图者这篇文 章是要介绍什么样子的内容，一些配图可以分为含蓄类型的，这样的配图一般会 图片描述可以分为多种.
                    </p>
                    <div class="img-btn">
                        <div class="price">￥5800</div>
                        <div class="btn">
                            <a href="#" class="cart">
                                <img src="${pageContext.request.contextPath}/image/cart.svg">
                            </a>
                        </div>
                    </div>
                </div>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/image/wumingnvlang.jpg" class="img-li">
                <div class="info">
                    <h3>无名女郎</h3>
                    <p>
                        图片描述可以分为多种，一种是单一说明，就比如直接的告诉看图者这篇文 章是要介绍什么样子的内容，一些配图可以分为含蓄类型的，这样的配图一般会 图片描述可以分为多种.
                    </p>
                    <div class="img-btn">
                        <div class="price">￥5800</div>
                        <div class="btn">
                            <a href="#" class="cart">
                                <img src="${pageContext.request.contextPath}/image/cart.svg">
                            </a>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div class="page-nav">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">上一页</a></li>
            <li><span class="first-page">1</span></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">…</a></li>
            <li><a href="#">98</a></li>
            <li><a href="#">99</a></li>
            <li><a href="#">下一页</a></li>
            <li><a href="#">尾页</a></li>
        </ul>
    </div>
</div>
<div class="footer"></div>
</body>
</html>
