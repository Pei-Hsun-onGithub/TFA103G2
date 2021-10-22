<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.foodarticle.model.*"%>
<%@ page import="com.picturebase.model.*"%>


<% 
	FoodArticleService faSvc = new FoodArticleService();
	FoodArticleVO faVO1 = faSvc.getOneArticle(1);
	FoodArticleVO faVO2 = faSvc.getOneArticle(2);
	FoodArticleVO faVO3 = faSvc.getOneArticle(3);
	FoodArticleVO faVO4 = faSvc.getOneArticle(4);
	FoodArticleVO faVO5= faSvc.getOneArticle(5);
	pageContext.setAttribute("faVO1",faVO1); 
	pageContext.setAttribute("faVO2",faVO2); 
	pageContext.setAttribute("faVO3",faVO3); 
	pageContext.setAttribute("faVO4",faVO4); 
	pageContext.setAttribute("faVO5",faVO5); 
	
%>



<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>All FoodArticle</title>
    <!--fivicon icon-->
    <link rel="icon" href="<%=request.getContextPath()%>/assets/img/fevicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/animate.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/magnific.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/nice-select.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/jquery-ui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/owl.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/slick-slide.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontawesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/remixicon/remixicon.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/responsive.css">

    <!--Google Fonts-->
    <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap" rel="stylesheet">
	
	<style>
        
    
    form.search-form {
    position: relative;
    background: #fff;
    border-radius: 6px;
    width: 80%;
    margin: auto;
    }   

    </style>
	

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
    <header class="navbar-area">
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
                            <ul class="sub-menu ps-0">
                                <li><a href="<%=request.getContextPath()%>/home-1.html">Home 01</a></li>
                                <li><a href="<%=request.getContextPath()%>/home-2.html">Home 02</a></li>
                                <li><a href="<%=request.getContextPath()%>/home-3.html">Home 03</a></li>
                            </ul>
                        </li>
                        <li class="current-menu-item menu-item-has-children">
                            <a href="#">PAGES</a>
                            <ul class="sub-menu ps-0">
                                <li><a href="<%=request.getContextPath()%>/about.html">About</a></li>
                                <li><a href="<%=request.getContextPath()%>/blog.html">Blog</a></li>
                                <li><a href="<%=request.getContextPath()%>/blog-details.html">Blog Details</a></li>
                                <li><a href="<%=request.getContextPath()%>/menu.html">Menu</a></li>
                                <li><a href="<%=request.getContextPath()%>/menu-list.html">Menu List</a></li>
                                <li><a href="<%=request.getContextPath()%>/shop.html">Shop</a></li>
                                <li><a href="<%=request.getContextPath()%>/single-product.html">Shop Details</a></li>
                                <li><a href="<%=request.getContextPath()%>/cart.html">Cart</a></li>
                                <li><a href="<%=request.getContextPath()%>/checkout.html">Checkout</a></li>
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
                        <li class="menu-cart"><a href="<%=request.getContextPath()%>/cart.html">CART <span>1</span></a></li>
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
                        <li class="menu-cart"><a href="<%=request.getContextPath()%>/cart.html">CART <span>1</span></a></li>
                        <li>49.50 $</li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <!-- navbar end -->

    <!-- bredcrumb Area Start-->
    <section class="breadcrumb-area">
        <div class="banner-bg-img"></div>
        <div class="banner-shape-1"><img src="<%=request.getContextPath()%>/assets/img/banner/shape-1.png" alt="img"></div>
        <div class="banner-shape-2"><img src="<%=request.getContextPath()%>/assets/img/banner/shape-2.png" alt="img"></div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 align-self-center">
                    <div class="banner-inner text-center">
                        <h3>Blog
                        </h3>
                        <h1>Food Blog</h1>
                        <nav aria-label="breadcrumb">
                            <ul class="breadcrumb">
                              <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/home-1.html">Home</a></li>
                              <li class="breadcrumb-item active" aria-current="page">Blog</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- bredcrumb Area End --> 

    <!-- blog Area Start-->
    
    <section class="blog-area pd-top-120 pd-bottom-120">
        
        <div class="widget widget_search">
            <form class="search-form">
                <div class="form-group">
                    <input type="text" placeholder="食記搜尋">
                    <button class="submit-btn" type="submit"><i class="ri-search-line"></i></button>
                </div>
            </form>
        </div>
        
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="row justify-content-center">
                        
<%--                        <c:forEach var="faVO" items="${list}"> </c:forEach> --%>
                        <div class="col-sm-6">                                                                                                                 
                            <div class="single-blog-wrap">
                                <div class="thumb">                                    
                                    <img src="<%=request.getContextPath()%>/ImageSingleServlet?Id=<%= faVO1.getArticleNo() %>" alt="img">                                	
                                </div>
                                <div class="wrap-details">
                                    <span class="cat">
                                        <span class="date">
                                            <i class="ri-calendar-todo-fill"></i><%=faVO1.getArticleDate() %>
                                        </span>
                                        <a href="#" class="tag me-0">
                                            <i class="ri-price-tag-3-fill"></i>Burgar
                                        </a>
                                    </span>
                                    <h5><a href="<%=request.getContextPath()%>/article/oneFA_allMsg.jsp"><%=faVO1.getArticleTitle() %> </a></h5> 
                                    <div class="wrap-hover-area">
                                        <p><%=faVO1.getArticleContent() %></p>
                                         
                                        <a class="link-btn" href="<%=request.getContextPath()%>/article/oneFA_allMsg.jsp">Read More</a> 
                                    </div>                       
                                </div> 
                            </div>                                                                                  
                                                       
                        </div>
                      
                       
                        
                        <div class="col-sm-6">
                            <div class="single-blog-wrap">
                                <div class="thumb">
                                    
                                    <img src="<%=request.getContextPath()%>/ImageSingleServlet?Id=<%= faVO2.getArticleNo() %>" alt="img">
                                	
                                </div>
                                <div class="wrap-details">
                                    <span class="cat">
                                        <span class="date">
                                            <i class="ri-calendar-todo-fill"></i><%=faVO2.getArticleDate()%>
                                        </span>
                                        <a href="#" class="tag me-0">
                                            <i class="ri-price-tag-3-fill"></i>Pizza
                                        </a>
                                    </span>
                                    <h5><a href="<%=request.getContextPath()%>/blog-details.html"><%=faVO2.getArticleTitle()%>
                                    </a></h5> 
                                    <div class="wrap-hover-area">
                                        <p> <%=faVO2.getArticleContent()%>
                                        </p> 
                                        <a class="link-btn" href="blog-details.html">Read More</a> 
                                    </div>                       
                                </div> 
                            </div>
                        </div>
                        
                        <div class="col-sm-6">
                            <div class="single-blog-wrap">
                                <div class="thumb">
                                    <img src="<%=request.getContextPath()%>/ImageSingleServlet?Id=<%= faVO3.getArticleNo() %>" alt="img">
                                </div>
                                <div class="wrap-details">
                                    <span class="cat">
                                        <span class="date">
                                            <i class="ri-calendar-todo-fill"></i><%=faVO3.getArticleDate()%>
                                        </span>
                                        <a href="#" class="tag me-0">
                                            <i class="ri-price-tag-3-fill"></i>Pizza
                                        </a>
                                    </span>
                                    <h5><a href="<%=request.getContextPath()%>/blog-details.html"><%=faVO3.getArticleTitle()%>
                                    </a></h5> 
                                    <div class="wrap-hover-area">
                                        <p> <%=faVO3.getArticleContent()%>
                                        </p> 
                                        <a class="link-btn" href="<%=request.getContextPath()%>/blog-details.html">Read More</a> 
                                    </div>                       
                                </div> 
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="single-blog-wrap">
                                <div class="thumb">
                                    <img src="<%=request.getContextPath()%>/ImageSingleServlet?Id=<%= faVO4.getArticleNo() %>" alt="img">
                                </div>
                                <div class="wrap-details">
                                    <span class="cat">
                                        <span class="date">
                                            <i class="ri-calendar-todo-fill"></i><%=faVO4.getArticleDate()%>
                                        </span>
                                        <a href="#" class="tag me-0">
                                            <i class="ri-price-tag-3-fill"></i>Fresh food
                                        </a>
                                    </span>
                                    <h5><a href="<%=request.getContextPath()%>/blog-details.html"><%=faVO4.getArticleTitle()%>
                                    </a></h5> 
                                    <div class="wrap-hover-area">
                                        <p> <%=faVO4.getArticleContent()%>
                                        </p> 
                                        <a class="link-btn" href="<%=request.getContextPath()%>/blog-details.html">Read More</a> 
                                    </div>                       
                                </div> 
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="single-blog-wrap">
                                <div class="thumb">
                                    <img src="<%=request.getContextPath()%>/ImageSingleServlet?Id=<%= faVO5.getArticleNo() %>" alt="img">
                                </div>
                                <div class="wrap-details">
                                    <span class="cat">
                                        <span class="date">
                                            <i class="ri-calendar-todo-fill"></i><%=faVO5.getArticleDate()%>
                                        </span>
                                        <a href="#" class="tag me-0">
                                            <i class="ri-price-tag-3-fill"></i>Fresh food
                                        </a>
                                    </span>
                                    <h5><a href="<%=request.getContextPath()%>/blog-details.html"><%=faVO5.getArticleTitle()%>

                                    </a></h5> 
                                    <div class="wrap-hover-area">
                                        <p> <%=faVO5.getArticleContent()%>
                                        </p> 
                                        <a class="link-btn" href="<%=request.getContextPath()%>/blog-details.html">Read More</a> 
                                    </div>                       
                                </div> 
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="single-blog-wrap">
                                <div class="thumb">
                                    <img src="<%=request.getContextPath()%>/assets/img/blog/6.png" alt="img">
                                </div>
                                <div class="wrap-details">
                                    <span class="cat">
                                        <span class="date">
                                            <i class="ri-calendar-todo-fill"></i>September 10, 2021
                                        </span>
                                        <a href="#" class="tag me-0">
                                            <i class="ri-price-tag-3-fill"></i>Spicy
                                        </a>
                                    </span>
                                    <h5><a href="blog-details.html">Celebrating the awesomeness of food.
                                    </a></h5> 
                                    <div class="wrap-hover-area">
                                        <p> It with just a touch of sauce. saucy riff, more in the style of takeout American Chinese kung pao. The sauce makes it perfect for eating with rice.
                                        </p> 
                                        <a class="link-btn" href="<%=request.getContextPath()%>/blog-details.html">Read More</a> 
                                    </div>                       
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="sidebar-area">
                        
                        <div class="widget widget-recent-post">
                            <h4 class="widget-title">熱門食記</h4>
                            <ul>
                                <li>
                                    <div class="media">
                                        <div class="media-left">
                                            <img src="<%=request.getContextPath()%>/assets/img/widget/1.png" alt="widget">
                                        </div>
                                        <div class="media-body">
                                            <h6 class="title"><a href="#"><%=faVO1.getArticleTitle() %></a></h6>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="media">
                                        <div class="media-left">
                                            <img src="<%=request.getContextPath()%>/assets/img/widget/2.png" alt="widget">
                                        </div>
                                        <div class="media-body">
                                            <h6 class="title"><a href="#"><%=faVO2.getArticleTitle() %>
                                            </a></h6>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="media">
                                        <div class="media-left">
                                            <img src="<%=request.getContextPath()%>/assets/img/widget/3.png" alt="widget">
                                        </div>
                                        <div class="media-body">
                                            <h6 class="title"><a href="#"><%=faVO3.getArticleTitle() %>
                                            </a></h6>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="media">
                                        <div class="media-left">
                                            <img src="<%=request.getContextPath()%>/assets/img/widget/4.png" alt="widget">
                                        </div>
                                        <div class="media-body">
                                            <h6 class="title"><a href="#"><%=faVO4.getArticleTitle() %>/a></h6>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="widget widget-newsletter">
                            <h4 class="widget-title">Newsletter</h4>
                            <p>Subscribe to get the latest news, update and offer information. Don't worry, we won't send spam!</p>
                            <form class="newsletter-form">
                                <div class="form-group">
                                    <input type="email" placeholder="Enter e-mail">
                                </div>
                                <button class="submit-btn" type="submit"><i class="ri-arrow-right-line"></i></button>
                            </form>
                        </div>
                        <div class="widget widget_categories">
                            <h4 class="widget-title">Categories</h4>
                            <ul>
                                <li><a href="#">Inspiration <span>(5)</span></a></li>
                                <li><a href="#">Recipes <span>(9)</span> </a></li>
                                <li><a href="#">Others <span>(18)</span></a></li>
                            </ul>
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
    <!-- blog Area End -->

    <!-- footer area start -->
    <footer class="footer-area pd-top-100">
        <div class="footer-inner padding-top-100 padding-bottom-65">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="footer-widget widget">
                            <div class="logo">
                                <img src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img">
                            </div>
                            <ul class="contact_info_list">
                                <li class="single-info-item">
                                    <img src="<%=request.getContextPath()%>/assets/img/icon/location.png" alt="icon">
                                    <div class="details">
                                        4920 Trails End Road Ft  United States, FL 33311
                                    </div>
                                </li>
                                <li class="single-info-item">
                                    <img src="<%=request.getContextPath()%>/assets/img/icon/envelope.png" alt="icon">
                                    <div class="details">
                                        ordernow@foodka.com
                                    </div>
                                </li>
                                <li class="single-info-item">
                                    <img src="<%=request.getContextPath()%>/assets/img/icon/phone.png" alt="icon">
                                    <div class="details">
                                        +997 509 153 849
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="footer-widget widget widget_link">
                            <h4 class="widget-title">Hot Menu</h4>
                            <ul>
                                <li><a href="<%=request.getContextPath()%>/menu-list.html">Burger King Whopper</a></li>
                                <li><a href="<%=request.getContextPath()%>/menu-list.html">Five Guys Cheeseburger</a></li>
                                <li><a href="<%=request.getContextPath()%>/menu-list.html">KFC Original Recipe Chicken</a></li>
                                <li><a href="<%=request.getContextPath()%>/menu-list.html">Wendy's Frosty</a></li>
                                <li><a href="<%=request.getContextPath()%>/menu-list.html">McDonald's Happy Meal</a></li>
                                <li><a href="<%=request.getContextPath()%>/menu-list.html">Domino's Pepperoni Pizza</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="footer-widget widget widget_link">
                            <h4 class="widget-title">Opening Hours</h4>
                            <ul>
                                <li>Monday : 09.00am-10.00pm</li>
                                <li>Tuesday : 09.00am-10.00pm</li>
                                <li>Wednesday : 09.00am-10.00pm</li>
                                <li>Thursday : 09.00am-10.00pm</li>
                                <li>Friday  : 09.00am-10.00pm</li>
                                <li>Saturday & Sunday : <span>Closed</span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="footer-widget widget widget_instagram_feeds">
                            <h4 class="widget-title">Instagram Feeds</h4>
                            <ul>
                                <li><a href="#"><img src="<%=request.getContextPath()%>/assets/img/instagram/1.png" alt="instagram" /></a></li>
                                <li><a href="#"><img src="<%=request.getContextPath()%>/assets/img/instagram/2.png" alt="instagram" /></a></li>
                                <li><a href="#"><img src="<%=request.getContextPath()%>/assets/img/instagram/3.png" alt="instagram" /></a></li>
                                <li><a href="#"><img src="<%=request.getContextPath()%>/assets/img/instagram/4.png" alt="instagram" /></a></li>
                                <li><a href="#"><img src="<%=request.getContextPath()%>/assets/img/instagram/5.png" alt="instagram" /></a></li>
                                <li><a href="#"><img src="<%=request.getContextPath()%>/assets/img/instagram/6.png" alt="instagram" /></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-6 text-md-start text-center">
                        <div class="copyright-area">
                            <p>© 2021 Foodka. All Rights Reserved by Themefie</p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <ul class="social-area text-md-end text-center mt-md-0 mt-2">
                            <li><a href="#"><i class="fab fa-facebook-f"></i></a></li> 
                            <li><a href="#"><i class="fab fa-twitter"></i></a></li> 
                            <li><a href="#"><i class="fab fa-behance"></i></a></li> 
                            <li><a href="#"><i class="fab fa-google-plus-g"></i></a></li> 
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- footer area end -->    

    <!-- back-to-top end -->
    <div class="back-to-top">
        <span class="back-top"><i class="fas fa-angle-double-up"></i></span>
    </div>

    

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