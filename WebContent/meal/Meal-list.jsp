<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.meal.model.*"%>

<%
	MealService MealSvc = new MealService();
	List<MealVO> list = MealSvc.getAll(); 
	pageContext.setAttribute("list",list); 
	
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


<!--Google Fonts-->
<link rel="stylesheet"
	href=https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap>

<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/Meal-lest.css">
</head>
<body class='sc5'>
	<!-- preloader area start -->
	<div class="preloader" id="preloader">
		<div class="preloader-inner">
			<div id="wave1"></div>
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
			<button type="submit" class="submit-btn">
				<i class="fa fa-search"></i>
			</button>
		</form>
	</div>
	<!-- //. search Popup -->

 <!-- navbar start -->
    <%@ include file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp" %>
 <!-- navbar end -->

	<!-- category Area Start-->
	<section class="category-area">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-12 align-self-center">
					<input id="he" type="checkbox" hidden>
					<ul class="category-menu">
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/1.png"
								alt="category">燒烤</a></li>
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/2.png"
								alt="category">日式</a></li>
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/3.png"
								alt="category">中式</a></li>
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/4.png"
								alt="category">泰式</a></li>
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/5.png"
								alt="category">西式</a></li>
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/6.png"
								alt="category">速食</a></li>
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/1.png"
								alt="category">火鍋</a></li>
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/2.png"
								alt="category">小吃</a></li>
						<li class="category-wrap"><a href="shop.html"><img
								src="<%=request.getContextPath()%>/assets/img/category/3.png"
								alt="category">炸物</a></li>
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
			
				<%@ include file="page\page1.file" %> 
			
				<c:forEach var="mealVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
				<div class="col-lg-4 col-md-6">
					<div class="single-item-wrap">
						<div class="thumb">
							<img src="<%=request.getContextPath()%>/meal/photoServlet?id=${mealVO.mealId}">
							<a class="fav-btn" href="#">
							<i class="ri-heart-line"></i>
							</a>
						</div>
						<div class="wrap-details">
							<h5>
								<a href="single-product.html">${mealVO.mealName}</a>
							</h5>
							<div class="wrap-footer">
								<div class="rating">
									4.9 <span class="rating-inner"> 
									<i class="ri-star-fill ps-0"></i> 
									<i class="ri-star-fill"></i> 
									<i class="ri-star-fill"></i>
								    <i class="ri-star-fill"></i> 
								    <i class="ri-star-half-line pe-0"></i>
									</span> (200)
								</div>
								<h6 class="price">$${mealVO.unitPrice}</h6>
							</div>
						</div>
						<div class="btn-area">
							<a class="btn btn-secondary" href="<%=request.getContextPath()%>/Mealsingle?mealId=${mealVO.mealId}">CHOOSE OPTIONS </a>
						</div>
					</div>
				</div>
				</c:forEach>
				
				<%@ include file="page\page2.file" %>
				
			</div>
		</div>
	</section>
	<!-- populer Area End -->

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
	<script	src="<%=request.getContextPath()%>/assets/js/isotope.pkgd.min.js"></script>
	<script	src="<%=request.getContextPath()%>/assets/js/nice-select.min.js"></script>
	<script	src="<%=request.getContextPath()%>/assets/js/fontawesome.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/owl.min.js"></script>
	<script	src="<%=request.getContextPath()%>/assets/js/slick-slider.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/tweenmax.min.js"></script>

	<!-- main js  -->
	<script src="<%=request.getContextPath()%>/assets/js/main.js"></script>
<%@ include file="/assets/webPageSnippet/jsSnippet_navbar_home_3.jsp" %>
</body>
</html>