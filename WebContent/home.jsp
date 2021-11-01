<%@page import="com.memberinfo.model.MemberInfoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>FoodMonster</title>
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


<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">

<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp"%>

<style>
div.carouselExampleInterval div.carousel-item img {
	width: 800px;
	height: 400px;
}

div.single-blog-wrap img {
	width: 420px;
	height: 420px;
}
</style>

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

	<%
		Integer userId = (Integer) session.getAttribute("userId");

		MemberInfoService memInfoSvc = new MemberInfoService();
	%>

	<%@ include
		file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp"%>


	<!-- category Area Start-->

	<section class="my-recommend-restaurant-title">
		<div class="container">
			<div class="row justify-content-center">

				<div class="col-lg-3"></div>
				<div class="col-lg-6">
					<div class="section-title text-center my-recommand-title-wrap">
						<h3 class="sub-title">Our signature</h3>
						<h2 class="title">精選美食</h2>
					</div>
				</div>
				<div class="col-lg-3"></div>
			</div>
		</div>
	</section>
	<!-- category Area End -->


	<!-- 幻燈片 Area Start-->
	<div id="carouselExampleInterval" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="1500">
				<div style="margin: 0 auto; width: 800px; height: 400px;">
					<img class="bg-img my-carousel-img"
						src="<%=request.getContextPath()%>/images/testFA3.JPG" alt="img">
				</div>
			</div>
			<div class="carousel-item my-carousel-img" data-bs-interval="1500">
				<div style="margin: 0 auto; width: 800px; height: 400px;">
					<img class="bg-img"
						src="<%=request.getContextPath()%>/images/testFA4.JPG" alt="img">
				</div>

			</div>
			<div class="carousel-item my-carousel-img" data-bs-interval="1500">
				<div style="margin: 0 auto; width: 800px; height: 400px;">
					<img class="bg-img"
						src="<%=request.getContextPath()%>/images/testFA5.JPG" alt="img">
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleInterval" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<!-- 幻燈片 Area End -->



	<!-- blog Area Start-->
	<section class="blog-area pd-bottom-90" style="margin-top: 60px;">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-xl-5 col-lg-7">
					<div class="section-title text-center">
						<h3 class="sub-title">News & Blog</h3>
						<h2 class="title">精選食記</h2>
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-lg-4 col-md-6">
					<div class="single-blog-wrap">
						<div class="thumb">
							<img src="<%=request.getContextPath()%>/images/testFA4.JPG"
								alt="img">
						</div>
						<div class="wrap-details">
							<span class="cat"> <span class="date"> <i
									class="ri-calendar-todo-fill"></i>July 14, 2021
							</span> <a href="#" class="tag me-0"> <i class="ri-price-tag-3-fill"></i>Burgar
							</a>
							</span>
							<h5>
								<a href="#">迷克夏好喝到爆</a>
							</h5>
							<div class="wrap-hover-area">
								<p>位在縣民大道跟民權路交叉口的齊味，離板南線的板橋站2號出口很近，交通上算是方便。齊味是愛吃麻辣鍋的好友夫妻檔大力推薦，住新莊的他們都會特地來板橋包齊味回去吃，我自己以前倒是常吃新莊的詹記，
									齊味離我這麼近，怎麼可以錯過，今天就約</p>
								<a class="link-btn" href="#">Read More</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-blog-wrap">
						<div class="thumb">
							<img src="<%=request.getContextPath()%>/images/testFA5.JPG"
								alt="img">
						</div>
						<div class="wrap-details">
							<span class="cat"> <span class="date"> <i
									class="ri-calendar-todo-fill"></i>July 05, 2021
							</span> <a href="#" class="tag me-0"> <i class="ri-price-tag-3-fill"></i>Pizza
							</a>
							</span>
							<h5>
								<a href="#">Ashidori好好吃</a>
							</h5>
							<div class="wrap-hover-area">
								<p>位在縣民大道跟民權路交叉口的齊味，離板南線的板橋站2號出口很近，交通上算是方便。齊味是愛吃麻辣鍋的好友夫妻檔大力推薦，住新莊的他們都會特地來板橋包齊味回去吃，我自己以前倒是常吃新莊的詹記，
									齊味離我這麼近，怎麼可以錯過，今天就約</p>
								<a class="link-btn" href="#">Read More</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-blog-wrap">
						<div class="thumb">
							<img src="<%=request.getContextPath()%>/images/testFA3.JPG"
								alt="img">
						</div>
						<div class="wrap-details">
							<span class="cat"> <span class="date"> <i
									class="ri-calendar-todo-fill"></i>August 14, 2021
							</span> <a href="#" class="tag me-0"> <i class="ri-price-tag-3-fill"></i>Pizza
							</a>
							</span>
							<h5>
								<a href="#">齊味火鍋</a>
							</h5>
							<div class="wrap-hover-area">
								<p>位在縣民大道跟民權路交叉口的齊味，離板南線的板橋站2號出口很近，交通上算是方便。齊味是愛吃麻辣鍋的好友夫妻檔大力推薦，住新莊的他們都會特地來板橋包齊味回去吃，我自己以前倒是常吃新莊的詹記，
									齊味離我這麼近，怎麼可以錯過，今天就約</p>
								<a class="link-btn" href="#">Read More</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- blog Area End -->

	<!-- footer area start -->
	<%@ include file="/assets/webPageSnippet/footerSnippet_home.jsp"%>
	<!-- footer area end -->

	<!-- back-to-top end -->
	<div class="back-to-top">
		<span class="back-top"><i class="fas fa-angle-double-up"></i></span>
	</div>



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

	<%@ include file="/assets/webPageSnippet/jsSnippet_navbar_home_3.jsp"%>


</body>
</html>