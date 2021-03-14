<%-- 
    Document   : cart
    Created on : Dec 7, 2020, 7:18:07 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cart | E-Shopper</title>
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

        <%@include file="header.jsp"%>

        <section id="cart_items">
            <div class="container">
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image" style="width: 20%">Item</td>
                                <td class="description" style="width: 30%;">Description</td>
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.listCart}" var="c">
                                <tr>
                                    <td class="cart_product">
                                        <a href="product?productId=${c.product.productId}"><img src="images/home/${c.product.image}" alt="" style="width: 40%;"/></a>
                                    </td>
                                    <td class="cart_description">
                            <h9><a href="product?productId=${c.product.productId}">${c.product.productDescription}</h9>
                            <p>ProductId: ${c.product.productId}</p>
                            </td>
                            <td class="cart_price">
                                <p>$${c.product.price}0</p>
                            </td>
                            <td class="cart_quantity">
                                <div class="cart_quantity_button">
                                    <a class="cart_quantity_down" href="updateQuantityCartItem?cartId=${c.cartId}&status=down&quantity=${c.quantity}"> - </a>
                                    <input class="cart_quantity_input" type="text" name="quantity" value="${c.quantity}" autocomplete="off" size="2">
                                    <a class="cart_quantity_up" href="updateQuantityCartItem?cartId=${c.cartId}&status=up&quantity=${c.quantity}"> + </a>

                                </div>
                            </td>
                            <td class="cart_total">
                                <p class="cart_total_price">$${c.product.price * c.quantity}0</p>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_quantity_delete" href="deleteCartItem?cartId=${c.cartId}"><i class="fa fa-times"></i></a>
                            </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div style="text-align: center;"><h3>${requestScope.cartEmpty}</h3></div>
                </div>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <form action="edit" method="post">
                            <div class="total_area">
                                <ul>
                                    <p style="font-size: 18px;"><b>Review Your Information And Address</b></p>
                                    <li>Name:
                                        <input type="text" value="${sessionScope.user.fullName}" name="fullName"
                                               style="text-align-last: end; border: none; background-color: #E6E4DF; outline: none; right: 50px; position: absolute;"/>
                                    </li>
                                    <li>Phone number:
                                        <input type="text" value="${sessionScope.user.phone}" name="phone"
                                               style="text-align-last: end; border: none; background-color: #E6E4DF; outline: none; right: 50px; position: absolute;"/>
                                    </li>
                                    <li>Address:
                                        <input type="text" value="${sessionScope.user.address}" name="address"
                                               style="width: 300px; text-align-last: end; border: none; background-color: #E6E4DF; outline: none; right: 50px; position: absolute;"/>
                                    </li>

                                </ul>
                                <button type="submit" class="btn btn-default update" href="">Edit Information</button>
                            </div>
                        </form>
                    </div>

                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                                <p style="font-size: 18px;"><b>Process to check out</b></p>
                                <li>Sub Total<span>$${sessionScope.totalAmount}0</span></li>
                                <li>Shipping Cost<span>$2</span></li>
                                <li>Total <span style="color: tomato; font-weight: bold;">$${sessionScope.totalAmount + 2}0</span></li>
                            </ul>
                            <a class="btn btn-default update" href="checkout">Check out</a>
                            <a class="btn btn-default update" href="home">Continue Shopping</a>
                        </div>
                    </div>
                </div>
            </div>
        </section><!--/#do_action-->

        <%@include file="footer.jsp"%>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>