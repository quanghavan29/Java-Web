<%-- 
    Document   : container
    Created on : Dec 7, 2020, 4:46:13 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 padding-right">
                        <div class="features_items">
                            <c:forEach items="${requestScope.listP}" var="p">
                                <a href="product?productId=${p.productId}">
                                    <div class="col-sm-3">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <img src="images/home/${p.image}" alt="" style="width: 80%; margin-bottom: -30px;"/>
                                                    <h3 style="color: #910000;">$${p.price}0</h3>
                                                    <p style="font-weight: bold; font-size: 16px;">${p.productName}</p>
                                                    <c:if test="${sessionScope.user == null}">
                                                        <a href="login.jsp" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                    </c:if>
                                                    <c:if test="${sessionScope.user != null}">
                                                        <a href="addToCart?productId=${p.productId}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>

                    </div>
                </div>
                <ul class="pagination">
                    <c:forEach begin="1" end="${requestScope.totalPage}" var="i">
                        <li class="
                            <c:if test="${requestScope.pageIndex == i}">
                                active
                            </c:if>
                            ">
                            <c:if test="${requestScope.page == 1}">
                            <a href="home?pageIndex=${i}">${i}</a>
                            </c:if>
                            
                            <c:if test="${requestScope.page == 2}">
                                <a href="search?pageIndex=${i}&txtSearch=${requestScope.txtSearch}">${i}</a>
                            </c:if>
                        </li>
                    </c:forEach>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
        </section>	


        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
