<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.meal.model.*"%>


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
<body style="background: #fff;" class='sc5'>
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
    <%@ include file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp" %>
 <!-- navbar end -->

    <!-- shop-details Area Start-->
    <div class="shop-details-area pd-top-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="sticy-product">
                        <div class="product-thumbnail-wrapper">
                            <div class="single-thumbnail-slider">
                                <div class="slider-item">
                                    <img src="<%=request.getContextPath()%>/meal/photoServlet?id=${MealVO.mealId}" alt="item">
                                   
                                </div>
                
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="shop-item-details">                     
                        <h2 class="entry-title">${MealVO.mealName}</h2>
                        <div class="row">
                            <div class="col-lg-6 order-lg-last align-self-center">
                                <div class="rating text-lg-end">
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
                            </div>
                            <div class="col-lg-6 align-self-center">
                                <h4 class="price">$${MealVO.unitPrice}</h4>
                            </div>                            
                        </div>   
                        <p class="mt-4">${mealVO.mealdescription}</p>  
                        <form name="shoppingForm" action="<%=request.getContextPath()%>/ShoppingServlet" method="POST">
                            <div class="quantity buttons_added">
                                <input type="button" value="-" class="minus">
                                <input type="number" class="input-text qty text" step="1" min="1" max="10000" name="quantity" value="1">
                                <input type="button" value="+" class="plus">
                                <input type="hidden" name="mealId" value="${MealVO.mealId}">
      							<input type="hidden" name="mealName" value="${MealVO.mealName}">
      							<input type="hidden" name="unitPrice" value="${MealVO.unitPrice}">
                                <input type="hidden" name="action" value="ADD">
                            </div>
                            <button type="submit" class="btn btn-secondary">ADD TO CART</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- shop-details Area End -->





    <!-- related-product Area Start-->
    <section class="related-product-area pd-top-120">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-12">
                    <div class="section-title mb-0">
                        <h2 class="title">Related Products</h2>
                    </div>
                    <div class="related-product-slider owl-carousel style-2">
                        
                        
                        <c:if test="${not empty mealList}">
                        <c:forEach var="mealVO1" items="${mealList}">
                        <div class="item">
                            <div class="single-item-wrap">
                                <div class="thumb">
                                    <img src="<%=request.getContextPath()%>/meal/photoServlet?id=${mealVO1.mealId}" alt="img">
                                    <a class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
                                </div>
                                <div class="wrap-details">
                                    <h5><a href="single-product.html">${mealVO1.mealName}</a></h5>
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
                                        <h6 class="price">$${mealVO1.unitPrice}</h6>
                                    </div>                            
                                </div>
                                <div class="btn-area">
                                    <a class="btn btn-secondary" href="<%=request.getContextPath()%>/Mealsingle?mealId=${mealVO1.mealId}">CHOOSE OPTIONS </a>        
                                </div>          
                            </div>
                        </div>
                        </c:forEach>
                       </c:if>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- related-product Area End -->

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