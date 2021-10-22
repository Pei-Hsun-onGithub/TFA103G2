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
 
<!-- new css -->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/Meal-lest.css">

<!--Google Fonts-->
<link rel="stylesheet"
 href=https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap>

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
    <!-- search popup area start -->
    <div class="body-overlay" id="body-overlay"></div>
    <div class="td-search-popup" id="td-search-popup">
        <form action="index.html" class="search-form">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search.....">
            </div>
            <button type="submit" class="submit-btn"><i class="fa fa-search"></i></button>
        </form>
    </div>
    <!-- //. search Popup -->

 <!-- navbar start -->
    <header class="navbar-area" >
        <nav class="navbar navbar-expand-lg">
            <div class="container nav-container">
                <div class="responsive-mobile-menu">
                    <button class="menu toggle-btn d-block d-lg-none" data-target="#themefie_main_menu" 
                    aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-left"></span>
                        <span class="icon-right"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="themefie_main_menu">
                    <ul class="navbar-nav menu-open">
                        <li class="current-menu-item menu-item-has-children">
                            <a href="home-1.html">HOME</a>
                            <!-- <ul class="sub-menu ps-0">
                                <li><a href="home-1.html">Home 01</a></li>
                                <li><a href="home-2.html">Home 02</a></li>
                                <li><a href="home-3.html">Home 03</a></li>
                            </ul> -->
                        </li>
                        <li class="current-menu-item menu-item-has-children">
                            <a href="#">PAGES</a>
                            <ul class="sub-menu ps-0">
                                <li><a href="about.html">About</a></li>
                                <li><a href="blog.html">Blog</a></li>
                                <li><a href="blog-details.html">Blog Details</a></li>
                                <li><a href="menu.html">Menu</a></li>
                                <li><a href="menu-list.html">Menu List</a></li>
                                <li><a href="shop.html">Shop</a></li>
                                <li><a href="single-product.html">Shop Details</a></li>
                                <li><a href="cart.html">Cart</a></li>
                                <li><a href="checkout.html">Checkout</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="about.html">ABOUT US</a>
                        </li>
                        <li>
                            <a href="contact.html">CONTACTS</a>
                        </li>
                    </ul>
                </div>
                <div class="logo">
                    <a class="main-logo" href="home-1.html"><img src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>
                </div>
                <div class="nav-right-part nav-right-part-mobile">
                    <ul>
                        <li><a class="search" href="#"><i class="ri-search-line"></i></a>
                        </li>
                        <li class="phone-contact d-md-block d-none"><i class="ri-phone-fill float-start"></i>
                            +997 509 153 849
                        </li>
                        <li class="menu-cart"><a href="cart.html">CART <span>1</span></a></li>
                        <li>49.50 $</li>
                    </ul>
                </div>
                <div class="nav-right-part nav-right-part-desktop">                    
                    <ul>
                        <li><a class="search" href="#"><i class="ri-search-line"></i></a>
                        </li>
                        <li class="phone-contact"><i class="ri-phone-fill float-start"></i>
                            +997 509 153 849
                        </li>
                        <li class="menu-cart"><a href="cart.html">CART <span>1</span></a></li>
                        <li>49.50 $</li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <!-- navbar end -->
 
     <!-- category Area Start-->
    <section class="category-area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-12 align-self-center">
                    <input id="he" type="checkbox" hidden >
                    <ul class="category-menu">
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/1.png" alt="category">燒烤</a></li>
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/2.png" alt="category">日式</a></li>
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/3.png" alt="category">中式</a></li>
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/4.png" alt="category">泰式</a></li>
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/5.png" alt="category">西式</a></li>
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/6.png" alt="category">速食</a></li>
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/1.png" alt="category">火鍋</a></li>
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/2.png" alt="category">小吃</a></li>
                        <li class="category-wrap"><a href="shop.html"><img src="<%=request.getContextPath()%>/assets/img/category/3.png" alt="category">炸物</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <!-- category Area End --> 

    <!-- populer Area Start-->
    <section class="populer-area pd-top-50 pd-bottom-120">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/pizza/1.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">Margherita Pizza</a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (200)
                                </div>
                                <h6 class="price">$17.00</h6>
                            </div>                            
                        </div>
                        <div class="btn-area">
                            <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                        </div> 
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/pizza/2.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">Maxican Pizza Test Better</a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (928)
                                </div>
                                <h6 class="price">$29.00</h6>
                            </div>
                            <div class="btn-area">
                                <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                            </div>                                               
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/pizza/3.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">Roasted Garlic Chicken Pizza </a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (462)
                                </div>
                                <h6 class="price">$27.00</h6>
                            </div>                            
                        </div>
                        <div class="btn-area">
                            <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                        </div> 
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/pizza/4.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">All Season Gulliver Pizza</a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (462)
                                </div>
                                <h6 class="price">$29.00</h6>
                            </div>                            
                        </div>
                        <div class="btn-area">
                            <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                        </div> 
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/pizza/5.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">Chicken Fajita Pizza Large</a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (200)
                                </div>
                                <h6 class="price">$29.00</h6>
                            </div>
                            <div class="btn-area">
                                <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                            </div>                                               
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/pizza/6.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">BBQ Chicken Classic Pizza Large</a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (602)
                                </div>
                                <h6 class="price">$27.00</h6>
                            </div>                            
                        </div>
                        <div class="btn-area">
                            <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                        </div> 
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/burger/1.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">Patty Buns Burgers</a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (462)
                                </div>
                                <h6 class="price">$27.00</h6>
                            </div>                            
                        </div>
                        <div class="btn-area">
                            <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                        </div> 
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/burger/2.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">Double Burger</a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (928)
                                </div>
                                <h6 class="price">$29.00</h6>
                            </div>
                            <div class="btn-area">
                                <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                            </div>                                               
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-item-wrap">
                        <div class="thumb">
                            <img src="<%=request.getContextPath()%>/assets/img/product/burger/1.png" alt="img">
                            <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                        </div>
                        <div class="wrap-details">
                            <h5><a href="single-product.html">Patty Buns Burgers</a></h5>
                            <div class="wrap-footer">
                                <div class="rating">
                                    4.9
                                    <span class="rating-inner">
                                        <i class="ri-star-fill ps-0"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-half-line pe-0"></i>
                                    </span>
                                    (462)
                                </div>
                                <h6 class="price">$27.00</h6>
                            </div>                            
                        </div>
                        <div class="btn-area">
                            <a class="btn btn-secondary" href="single-product.html">CHOOSE OPTIONS </a>         
                        </div> 
                    </div>
                </div>
                <div class="col-12">
                    <nav>
                        <ul class="pagination">
                            <li class="page-item">
                            <a class="page-link" href="#">
                                <i class="ri-arrow-left-s-line"></i>
                            </a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                            <a class="page-link" href="#">
                                <i class="ri-arrow-right-s-line"></i>
                            </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- populer Area End -->
 
 
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
 
</body>
</html>