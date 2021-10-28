<%@page import="com.meal.model.MealVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>AddFakeInfoPage</title>
<!--fivicon icon-->
<link rel="icon"
	href="<%=request.getContextPath()%>/assets/img/fevicon.png">

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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.css" />

<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">


<style>
* {
	list-style: none;
}

header.my-navbar-area {

	background: #a30481;
	border-bottom: none;
}

div.my-content {
	margin-top: 110px;
}

div.my-aside-left-container img{
	width: 42px;
	height: 42px;
}


.timepicker div.title {
	display: none;
}

div.my-btn-wrapper {
	margin-top: 50px;
}

.default-form-wrap.style-2 select.myclass-select-lauchdays {
	width: 150px;
}

div.my-img-zone {
	border: dashed 2px #d7d9d2;
	width: 310px;
	height: 300px;
	margin: 0 auto;
	margin-top: 80px;
	position: relative;
}

div.my-preview-img-container div.my-img-zone span {
	color: #d7d9d2;
	position: absolute;
	display: inline-block;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}

div.my-preview-img-container div.my-img-zone img.preview_img {
	max-height: 100%;
	max-width: 100%;
}

form .my-btn {
	padding: 0px 10px;
	width: 56px;
	height: 36px;
	line-height: 10px;
	border-radius: 10px;
}

div.my-time-setting-block label {
	margin-bottom: 0px;
}

div.my-time-setting-block label:after {
	content: "";
}

div.my-time-setting-block-weekly-picker label.form-check-label:after {
	content: "";
}

div.my-chooseType>ul {
	
}
div.my-chooseType>ul>li {
	display: inline-block;
}

div.my-chooseType ul li button{
	width: 100px; 
	height: 50px;
	border-radius:5px;
	background:white;
	text-align: center;
	vertical-align:middle;
	border: 1px solid #198754;
	color:#198754;
	line-height:56px;
	text-align: center;
	margin-left: 3px;
	font-weight: 600px;
}

</style>

</head>
<body class='sc5'>


	<header class="navbar-area my-navbar-area">
		<nav class="navbar navbar-expand-lg">
			<div class="container nav-container">
				<div class="responsive-mobile-menu">
					<button class="menu toggle-btn d-block d-lg-none"
						data-target="#themefie_main_menu" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-left"></span> <span class="icon-right"></span>
					</button>
				</div>
				<div class="logo">
					<a class="main-logo" href="#"><img
						src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>
				</div>
				<div class="collapse navbar-collapse" id="themefie_main_menu">
					<ul class="navbar-nav menu-open" style="visibility: hidden;">
						<li class="current-menu-item menu-item-has-children"><a
							href="home-1.html">訂餐</a>
							<ul class="sub-menu ps-0">
								<li><a href="<%=request.getContextPath()%>/shop.html">Shop</a></li>
								<li><a href="<%=request.getContextPath()%>/menu.html">Menu</a></li>
								<li><a href="<%=request.getContextPath()%>/cart.html">Cart</a></li>
								<li><a href="<%=request.getContextPath()%>/checkout.html">Checkout</a></li>
							</ul></li>
						<li><a href="blog.html">食記</a></li>
						<li><a href="about.html">ABOUT US</a></li>
						<li><a href="contact.html">CONTACTS</a></li>
					</ul>
				</div>
				<div class="nav-right-part nav-right-part-mobile">
					<ul>
						<li><a class="search" href="#"><i class="ri-search-line"></i></a>
						</li>
						<li class="phone-contact d-md-block d-none"><i
							class="ri-phone-fill float-start"></i> +997 509 153 849</li>
						<li class="menu-cart"><a href="cart.html">CART <span>1</span></a></li>
						<li>49.50 $</li>
					</ul>
				</div>
				<div class="nav-right-part nav-right-part-desktop">
					<ul>
						<li style="visibility: hidden;"><a class="search" href="#"><i class="ri-search-line"></i></a>
						</li>
						<li class="menu-cart"><a href="#" style="visibility: hidden;">小鈴鐺 <span>4</span></a></li>
						<li class="menu-cart"><a href="cart.html" style="visibility: hidden;">CART <span>1</span></a></li>
						
						
						
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<!-- bredcrumb Area Start-->
	<section class="breadcrumb-area">
		<div class="container">
			<div class="row justify-content-center"></div>
		</div>
	</section>
	<!-- bredcrumb Area End -->



	<!-- Content Area Start -->
	<section class="work-area">
		<div class="container my-content">
			<div class="row justify-content-center">
				<!-- add content here  -->

				<div class="card text-center">
					<div class="card-header">
						<ul class="nav nav-tabs card-header-tabs">
							<!-- using active | disabled  -->
							<li class="nav-item"><a class="nav-link model1 active"
								aria-current="true" href="#">Achieve</a></li>
						</ul>
					</div>
					<div class="card-body model1-body active">
						<h5 class="card-title">任務成就</h5>

						<div style="overflow: hidden;">
							<h4 class="my-query-title" style="float: left;">新增成就</h4>
						</div>
						<br>

						<a href="<%=request.getContextPath()%>/SimulateOrder.do?action=makeOrderSuccess" class="btn btn-primary">送出一筆訂單模擬</a>
					</div>

					
				</div>
			</div>
		</div>
	</section>
	<!-- Content Area End -->


	<!-- all plugins here -->
	<script src="<%=request.getContextPath()%>/assets/js/jquery.3.6.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/imageloded.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/counterup.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/waypoint.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/magnific.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/isotope.pkgd.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/nice-select.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/fontawesome.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/owl.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/slick-slider.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/tweenmax.min.js"></script>
	<!-- main js  -->
	<script src="<%=request.getContextPath()%>/assets/js/main.js"></script>
	<!-- new js   -->
	<script src="<%=request.getContextPath()%>/assets/js/main.js"></script>




</body>
</html>
