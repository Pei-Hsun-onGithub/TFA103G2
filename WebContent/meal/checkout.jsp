<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.memberinfo.model.*"%>

<%
 MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Login-long</title>
<!--fivicon icon-->
<link rel="icon"
 href="<%=request.getContextPath()%>/assets/img/Image4.png">

<!-- Stylesheet -->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/animate.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/magnific.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/jquery-ui.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/nice-select.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/owl.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/slick-slide.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/fontawesome.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/remixicon/remixicon.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/responsive.css">


<!--Google Fonts-->
<link rel="stylesheet"
 href=https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap>

<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp" %>

</head>

<body class='sc5'>
    <!-- preloader area start -->
    <div class="preloader" id="preloader">
        <div class="preloader-inner">
            <div id="wave1">
            </div>
            <div class="spinner">
                <div class="dot1"></div>
                <div class="dot2"></div>
            </div>
        </div>
    </div>
    <!-- preloader area end -->

 <!-- navbar start -->
<%@ include file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp" %>
 <!-- navbar end -->

  <!-- cart area start -->
    <div class="cart-area pd-top-120 pd-bottom-120">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-12">
                    <div class="table-responsive mb-4">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th class="blank"></th>
                                    <th class="blank"></th>
                                    <th class="blank"></th>
                                    <th class="title-name">Product</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th>Total Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="table-close-btn"><a href="#"><i class="ri-close-line"></i></a></td>
                                    <th scope="row"><img src="assets/img/widget/01.png" alt="img"></th>
                                    <td colspan="2" class="item-name">
                                        <div class="details">
                                            <h5>All Season Gulliver Pizza</h5>
                                        </div>
                                    </td>
                                    <td>$50.00</td>
                                    <td class="table-quantity">
                                        <form>
                                            <div class="quantity buttons_added">
                                                <input type="button" value="-" class="minus">
                                                <input type="number" class="input-text qty text" step="1" min="1" max="10000" name="quantity" value="1">
                                                <input type="button" value="+" class="plus">
                                            </div>
                                        </form>
                                    </td>
                                    <td>$40.00</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>                    
                </div>
                <div class="col-lg-8">
                    <div class="promotional-area">
                        <form class="default-form-wrap">
                            <div class="row">
                                <div class="col-md-4 col-sm-6">
                                    <div class="single-input-wrap">
                                        <input type="text" class="form-control" placeholder="Coupon Code">
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <button type="submit" class="btn btn-secondary">APPLY COUPON</button>
                                </div>
                                <div class="col-md-4 col-sm-6 text-md-end">
                                    <button type="submit" class="btn btn-base">UPDATE CART</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="order-cart-area">
                        <div class="order-cart">
                            <h5>Cart totals</h5>
                            <ul>
                                <li>Subtotal<span>$50.00</span></li>
                                <li class="total">Total<span>$50.00</span></li>
                            </ul>
                        </div>
                        <a class="btn btn-secondary w-100" href="#"> PROCEED TO CHECKOUT</a>
                    </div>                
                </div>
            </div>
        </div>
    </div>
    <!-- cart area end -->


 
<!-- footer area start -->
	<%@ include file="/assets/webPageSnippet/footerSnippet_home.jsp" %>
<!-- footer area end -->
 
<!-- all plugins here -->
 <script src="<%=request.getContextPath()%>/assets/js/jquery.3.6.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/imageloded.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/counterup.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/waypoint.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/magnific.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/isotope.pkgd.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/nice-select.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/fontawesome.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/owl.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/slick-slider.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/tweenmax.min.js"></script>
 
 <!-- main js  -->
 <script src="<%=request.getContextPath()%>/assets/js/main.js"></script>
 
 <%@ include file="/assets/webPageSnippet/jsSnippet_navbar_home_3.jsp" %>
</body>
</html>