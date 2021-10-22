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
<link rel="icon" href="assets/img/fevicon.png">

<!-- Stylesheet -->
<link rel="stylesheet" href="assets/css/animate.min.css">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/magnific.min.css">
<link rel="stylesheet" href="assets/css/jquery-ui.min.css">
<link rel="stylesheet" href="assets/css/nice-select.min.css">
<link rel="stylesheet" href="assets/css/owl.min.css">
<link rel="stylesheet" href="assets/css/slick-slide.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/remixicon/remixicon.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/responsive.css">


<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">

<style>

section.my-recommend-restaurant-title{
	margin-top: 60px;
}
section div.my-recommand-title-wrap {
	margin-top: 40px;
	margin-bottom: 20px;
}

header.navbar-area div.nav-right-part li.category-wrap {
	width: 60px;
}

img.my-monster-now {
	width: 60px;
	height: 50px;
}

/*********  tooltip的CSS 開始  ********/
#tooltip {
	display: none;
	background: #ffffff;
	color: #643045;
	font-weight: bold;
	padding: 5px 10px;
	font-size: 13px;
	border-radius: 4px;
}

#arrow, #arrow::before {
	position: absolute;
	width: 8px;
	height: 8px;
	background: inherit;
}

#arrow {
	visibility: hidden;
}

#arrow::before {
	visibility: visible;
	content: '';
	transform: rotate(45deg);
}

#tooltip[data-popper-placement^='bottom']>#arrow {
	top: -4px;
}

/*********  tooltip的CSS 結束 ********/
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

	<!-- navbar start -->
	
	<header class="navbar-area">
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
					<a class="main-logo" href="#"><img src="assets/img/logo.png"
						alt="img"></a>


				</div>

				<div class="collapse navbar-collapse" id="themefie_main_menu">
					<ul class="navbar-nav menu-open">
						<li><a href="menu.html">訂餐去</a></li>
						<li><a href="shop.html">訂餐去2</a></li>
						<li><a href="checkout.html">直接結帳</a></li>
						<li><a href="about.html">查詢食記</a></li>
						<li><a href="contact.html">食記撰寫</a></li>
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
						<li>
							<ul class="category-menu">
								<li class="category-wrap"><a href="#"><img
										src="images/243.jpg" class="my-monster-now" alt="category"></a>
									<div class="category-sub-menu"
										style="width: 500px; margin-left: -250px;">
										<div class="row">
											<div class="col-md-4 col-6">
												<div class="single-item-wrap text-center">
													<div class="thumb">
														<img src="images/243.jpg" alt="img">
													</div>
													<div class="wrap-details">
														<h4>舔舔獸</h4>
														<h5>LV 5</h5>
														<p>愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果</p>
													</div>
												</div>
											</div>
											<div class="col-md-4 col-6">
												<div class="single-item-wrap text-center">
													<div class="thumb">
														<img src="images/shh.jpg" alt="img">
													</div>
													<div class="wrap-details">
														<h4>舔舔獸</h4>
														<h5>LV 5</h5>
														<p>愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果</p>
													</div>
												</div>
											</div>
											<div class="col-md-4 col-6">
												<div class="single-item-wrap text-center">
													<div class="thumb">
														<img src="images/wthwt.jpg" alt="img">
													</div>
													<div class="wrap-details">
														<h4>舔舔獸</h4>
														<h5>LV 5</h5>
														<p>愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果</p>
													</div>
												</div>
											</div>

										</div>
									</div></li>
							</ul>

						</li>

						<li class="phone-contact"><a
							href="/TFA103G2/login/memberinfo.do?action=getOne"><i
								class="far fa-user"></i> username</a></li>

						<li><a id="my-bell" href="#" onclick="toggleTheTooltip()"><i
								class="far fa-bell"></i> <span>4</span></a></li>
						<!--   放入想要提醒的事項!    -->
						<div id="tooltip" role="tooltip">
							<div>Popcorn</div>
							<div>sizes</div>
							<div>&amp; Price</div>
							<div>XXS: $1.99</div>
							<div>XS: $2.99</div>
							<div>S: $3.99</div>
							<div>M: $4.99</div>
							<div>L: $5.99</div>
							<div>XL: $6.99</div>
							<div>XXL: $7.99</div>
							<div id="arrow" data-popper-arrow></div>
						</div>

						<li><a href="cart.html"><i class="fas fa-shopping-cart"></i>
								<span>1</span></a></li>
						<li><i class="fas fa-crown"></i> <span>23</span></li>
					</ul>
				</div>
				
			</div>
		</nav>
	</header>
	<!-- navbar end -->


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
			<div class="carousel-item active" data-bs-interval="2000">
				<div style="margin: 0 auto; width: 800px;">
					<img class="bg-img my-carousel-img"
						src="https://via.placeholder.com/800x400" alt="img">
				</div>
			</div>
			<div class="carousel-item my-carousel-img" data-bs-interval="2000">
				<div style="margin: 0 auto; width: 800px;">
					<img class="bg-img" src="https://via.placeholder.com/800x400"
						alt="img">
				</div>

			</div>
			<div class="carousel-item my-carousel-img" data-bs-interval="2000">
				<div style="margin: 0 auto; width: 800px;">
					<img class="bg-img" src="https://via.placeholder.com/800x400"
						alt="img">
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
							<img src="assets/img/blog/1.png" alt="img">
						</div>
						<div class="wrap-details">
							<span class="cat"> <span class="date"> <i
									class="ri-calendar-todo-fill"></i>July 14, 2021
							</span> <a href="#" class="tag me-0"> <i class="ri-price-tag-3-fill"></i>Burgar
							</a>
							</span>
							<h5>
								<a href="blog-details.html">Greek yogurt breakfast bowls
									with toppings</a>
							</h5>
							<div class="wrap-hover-area">
								<p>It with just a touch of sauce. saucy riff, more in the
									style of takeout American Chinese kung pao. The sauce makes it
									perfect for eating with rice.</p>
								<a class="link-btn" href="blog-details.html">Read More</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-blog-wrap">
						<div class="thumb">
							<img src="assets/img/blog/2.png" alt="img">
						</div>
						<div class="wrap-details">
							<span class="cat"> <span class="date"> <i
									class="ri-calendar-todo-fill"></i>July 05, 2021
							</span> <a href="#" class="tag me-0"> <i class="ri-price-tag-3-fill"></i>Pizza
							</a>
							</span>
							<h5>
								<a href="blog-details.html">Broad beans, tomato, garlic &
									cheese bruschetta </a>
							</h5>
							<div class="wrap-hover-area">
								<p>It with just a touch of sauce. saucy riff, more in the
									style of takeout American Chinese kung pao. The sauce makes it
									perfect for eating with rice.</p>
								<a class="link-btn" href="blog-details.html">Read More</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-blog-wrap">
						<div class="thumb">
							<img src="assets/img/blog/3.png" alt="img">
						</div>
						<div class="wrap-details">
							<span class="cat"> <span class="date"> <i
									class="ri-calendar-todo-fill"></i>August 14, 2021
							</span> <a href="#" class="tag me-0"> <i class="ri-price-tag-3-fill"></i>Pizza
							</a>
							</span>
							<h5>
								<a href="blog-details.html">Make authentic Italian
									margherita pizza at home </a>
							</h5>
							<div class="wrap-hover-area">
								<p>It with just a touch of sauce. saucy riff, more in the
									style of takeout American Chinese kung pao. The sauce makes it
									perfect for eating with rice.</p>
								<a class="link-btn" href="blog-details.html">Read More</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- blog Area End -->

	<!-- footer area start -->
	<footer class="footer-area">

		<div class="footer-bottom">
			<div class="container">
				<div class="row align-items-center">

					<div class="col-md-3 text-md-start text-center">
						<img src="assets/img/logo.png" alt="img"
							style="width: 125px; height: 40px;">
					</div>
					<div class="col-md-4 text-md-start text-center">
						<div class="copyright-area">
							<p>© 2021 TFA103G2. All Rights Reserved</p>
						</div>
					</div>
					<div class="col-md-5">
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
	<script src="assets/js/jquery.3.6.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/imageloded.min.js"></script>
	<script src="assets/js/counterup.js"></script>
	<script src="assets/js/waypoint.js"></script>
	<script src="assets/js/magnific.min.js"></script>
	<script src="assets/js/isotope.pkgd.min.js"></script>
	<script src="assets/js/jquery-ui.min.js"></script>
	<script src="assets/js/nice-select.min.js"></script>
	<script src="assets/js/fontawesome.min.js"></script>
	<script src="assets/js/owl.min.js"></script>
	<script src="assets/js/slick-slider.min.js"></script>
	<script src="assets/js/wow.min.js"></script>
	<script src="assets/js/tweenmax.min.js"></script>
	<!-- main js  -->
	<script src="assets/js/main.js"></script>


	<!-- popper 函式庫  -->
	<script src="https://unpkg.com/@popperjs/core@^2.0.0"></script>
	<script>
		/*********************  Popover 函式庫 相關設定  ********************************************/

		const bell = document.querySelector('#my-bell');
		const tooltip = document.querySelector('#tooltip');

		// Pass the button, the tooltip, and some options, and Popper will do the
		// magic positioning for you:
		Popper.createPopper(bell, tooltip, {
			placement : 'bottom',
			modifiers : [ {
				name : 'offset',
				options : {
					offset : [ 0, 10 ],
				},
			}, ],

		});

		/*********************  設定小鈴鐺的按鈕切換handler  ********************************************/
		function toggleTheTooltip() {
			$('#tooltip').toggle();
		}
	</script>


</body>
</html>