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
section.my-monster-state-bar {
	margin-top: 80px;
	background-color: #faf7f2;
}

section ul.my-monsteritem-menu {
	margin-left: 450px;
}

section li.category-wrap {
	width: 60px;
	
}

section li.my-li {
	text-align: center;
	vertical-align: text-bottom;
}

section li.my-monsteritem-wrap img.my-monster-now {
	width: 60px;
	height: 50px;
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

	<!-- navbar start -->
	<header class="navbar-area ">
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
						<li class="current-menu-item menu-item-has-children"><a
							href="home-1.html">訂餐</a>
							<ul class="sub-menu ps-0">
								<li><a href="shop.html">Shop</a></li>
								<li><a href="menu.html">Menu</a></li>
								<li><a href="cart.html">Cart</a></li>
								<li><a href="checkout.html">Checkout</a></li>
							</ul></li>

						<li class="current-menu-item menu-item-has-children"><a
							href="blog.html">食記</a>
							<ul class="sub-menu ps-0">
								<li><a href="shop.html">查詢食記</a></li>
								<li><a href="menu.html">食記</a></li>
								<li><a href="cart.html">Cart</a></li>

							</ul></li>


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
						<!--                         <li><a class="search" href="#"><i class="ri-search-line"></i></a> -->
						<!--                         </li> -->
						<li class="phone-contact"><a
							href="/TFA103G2/login/memberinfo.do?action=getOne"><i
								class="far fa-user"></i></a></li>
						<li class="menu-cart"><a href="#"><i class="far fa-bell"></i>
								<span>4</span></a></li>
						<li class="menu-cart"><a href="cart.html"><i
								class="fas fa-shopping-cart"></i> <span>1</span></a></li>
						<li>49.50 $</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- navbar end -->

	<!-- category Area Start-->

 <section class="category-area my-monster-state-bar">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-12 align-self-center">
                    <ul class="category-menu my-monsteritem-menu">
                        
                        <li class="category-wrap my-monsteritem-wrap"><a href="#"><img src="images/243.jpg"  class="my-monster-now" alt="category"></a>
                            <div class="category-sub-menu">
                                <div class="row">
                                    <div class="col-md-3 col-6">
                                        <div class="single-item-wrap text-center">
                                            <div class="thumb">
                                                <img src="assets/img/product/pizza/1.png" alt="img">
                                            </div>
                                            <div class="wrap-details">
                                                <h6><a href="shop.html">Margherita Pizza</a></h6>                          
                                            </div> 
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-6">
                                        <div class="single-item-wrap text-center">
                                            <div class="thumb">
                                                <img src="assets/img/product/pizza/2.png" alt="img">
                                            </div>
                                            <div class="wrap-details">
                                                <h6><a href="shop.html">Maxican Pizza Test Better</a></h6>                          
                                            </div> 
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-6">
                                        <div class="single-item-wrap text-center">
                                            <div class="thumb">
                                                <img src="assets/img/product/pizza/3.png" alt="img">
                                            </div>
                                            <div class="wrap-details">
                                                <h6><a href="shop.html">Margherita Pizza</a></h6>                          
                                            </div> 
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-6">
                                        <a href="#"><img src="assets/img/ad.png" alt="img"></a>
                                    </div>
                                </div>
                            </div>
                        </li>
                       
                       	<li class="category-wrap my-li"><span>菲力</span></li>
                       	<li class="category-wrap my-li"><span>LV 3</span></li>
                       	<li class="category-wrap my-li"><span>愛吃麵</span></li>
                       
                    </ul>
                </div>
            </div>
        </div>
    </section>
	<!-- category Area End -->





	<!-- Banner Area Start-->
	<section class="banner-area banner-area-2">
		<div class="banner-thumb">
			<!-- <img src="assets/img//home-3/banner-bg.png" alt="img"> -->
		</div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8 align-self-center">
					<div class="banner-inner text-center my-main-search-block">
						<h1>在您附近的熱門外送美食</h1>
						<form>
							<div class="single-input-wrap mb-0 with-btn">
								<input type="email" placeholder="想吃點什麼">
								<button class="btn btn-base">Search your location</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Banner Area End -->

	<!-- category Area Start-->

	<section class="offer-area pd-bottom-90">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-12 align-self-center d-contents">
					<div class="single-offer-wrap single-offer-wrap-2"
						style="background-color: var(- -secondary-color);">
						<img class="bg-img" src="assets/img/home-2/offer/1.png" alt="img">
						<div class="wrap-details">
							<h4>Double Cheese</h4>
							<h1>BURGER</h1>
							<p>With Free Cocacola. Stay home , we deliver</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 align-self-center">
					<div class="single-offer-wrap single-offer-wrap-3"
						style="background-color: #000;">
						<img class="bg-img" src="assets/img/home-2/offer/2.png" alt="img">
						<div class="wrap-details">
							<h3>Enjoy 30% CashBack</h3>
							<span>Up to $70 on all Bikash</span>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 align-self-center">
					<div class="single-offer-wrap single-offer-wrap-4"
						style="background-color: #F8F7F2;">
						<img class="bg-img" src="assets/img/home-2/offer/3.png" alt="img">
						<div class="wrap-details text-center">
							<h3>
								<span>25 EXTRA</span> FREE ON KFC
							</h3>
							<p>Stay home , we deliver</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 align-self-center">
					<div class="single-offer-wrap single-offer-wrap-5"
						style="background: #39251D">
						<img class="bg-img" src="assets/img/home-2/offer/4.png" alt="img">
						<div class="wrap-details">
							<h5>Test with</h5>
							<h3>
								<span>JAPANESE</span>FOOD AT HOME
							</h3>
						</div>
					</div>
				</div>







			</div>
		</div>
	</section>




	<!-- category Area End -->

	<!-- offer Area Start-->
	<section class="offer-area pd-top-120 pd-bottom-90">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 align-self-center d-contents">
					<div class="single-offer-wrap"
						style="background-color: var(- -main-color);">
						<img class="bg-img" src="assets/img/offer/1.png" alt="img">
						<div class="wrap-details">
							<h2>Special Deliciaus</h2>
							<h5>Maxican Pizza Testes Better</h5>
							<a class="btn btn-white" href="shop.html">ORDER NOW</a>
						</div>
						<div class="offer-sticker">
							<img src="assets/img/offer/offer.png" alt="img">
						</div>
					</div>
				</div>
				<div class="col-md-6 align-self-center">
					<div class="single-offer-wrap"
						style="background-color: var(- -heading-color);">
						<img class="bg-img" src="assets/img/offer/2.png" alt="img">
						<div class="wrap-details">
							<h3>Enjoy Our Delicious Item</h3>
							<a class="btn btn-white" href="shop.html">ORDER NOW</a>
						</div>
					</div>
					<div class="single-offer-wrap" style="background-color: #FFEECC">
						<div class="animated-img">
							<img src="assets/img/offer/03.png" alt="img">
						</div>
						<div class="animated-img animated-img-2">
							<img src="assets/img/offer/03.png" alt="img">
						</div>
						<div class="overlay-gradient"></div>
						<div class="wrap-details">
							<h3 class="text-heading">
								The Fastest In Delivery <span>Food</span>
							</h3>
							<a class="btn btn-white" href="shop.html">ORDER NOW</a>
						</div>
						<img class="bg-img-2" src="assets/img/offer/3.png" alt="img">
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- offer Area End -->

	<!-- populer Area Start-->
	<section class="populer-area pd-bottom-90">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12">
					<div class="section-title text-center">
						<h3 class="sub-title">Our signature</h3>
						<h2 class="title">Popular Dishes</h2>
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-lg-4 col-md-6">
					<div class="single-item-wrap">
						<div class="thumb">
							<img src="assets/img/product/pizza/1.png" alt="img"> <a
								class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
						</div>
						<div class="wrap-details">
							<h5>
								<a href="single-product.html">Margherita Pizza</a>
							</h5>
							<div class="wrap-footer">
								<div class="rating">
									4.9 <span class="rating-inner"> <i
										class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i> <i
										class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
										class="ri-star-half-line pe-0"></i>
									</span> (200)
								</div>
								<h6 class="price">$17.00</h6>
							</div>
						</div>
						<div class="btn-area">
							<a class="btn btn-secondary" href="single-product.html">CHOOSE
								OPTIONS </a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-item-wrap">
						<div class="thumb">
							<img src="assets/img/product/pizza/2.png" alt="img"> <a
								class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
						</div>
						<div class="wrap-details">
							<h5>
								<a href="single-product.html">Maxican Pizza Test Better</a>
							</h5>
							<div class="wrap-footer">
								<div class="rating">
									4.9 <span class="rating-inner"> <i
										class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i> <i
										class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
										class="ri-star-half-line pe-0"></i>
									</span> (928)
								</div>
								<h6 class="price">$29.00</h6>
							</div>
							<div class="btn-area">
								<a class="btn btn-secondary" href="single-product.html">CHOOSE
									OPTIONS </a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-item-wrap">
						<div class="thumb">
							<img src="assets/img/product/burger/1.png" alt="img"> <a
								class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
						</div>
						<div class="wrap-details">
							<h5>
								<a href="single-product.html">Patty Buns Burgers</a>
							</h5>
							<div class="wrap-footer">
								<div class="rating">
									4.9 <span class="rating-inner"> <i
										class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i> <i
										class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
										class="ri-star-half-line pe-0"></i>
									</span> (462)
								</div>
								<h6 class="price">$27.00</h6>
							</div>
						</div>
						<div class="btn-area">
							<a class="btn btn-secondary" href="single-product.html">CHOOSE
								OPTIONS </a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- populer Area End -->

	<!-- featured Area Start-->
	<section class="featured-area pd-bottom-150"
		style="background-image: url(assets/img/other/featured.png);">
		<div class="overlay"></div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6">
					<div class="section-title text-center">
						<h3 class="sub-title text-secondary">Tasty how The new</h3>
						<h2 class="title text-white">Meet Your New Lunchtime Faves</h2>
						<a class="btn btn-base" href="menu.html">SEE ALL MENU</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- featured Area End -->

	<!-- about Area Start-->
	<section class="about-area pd-top-120 pd-bottom-90">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6">
					<div class="thumb mb-lg-0 mb-4">
						<img src="assets/img/other/about.png" alt="img">
					</div>
				</div>
				<div class="col-lg-6">
					<div class="section-title text-lg-start text-center">
						<h3 class="sub-title">Why choose us</h3>
						<h2 class="title">Why we are the best</h2>
						<p>A, blandit euismod ullamcorper vestibulum enim habitasse.
							Ultrices tincidunt scelerisque elit enim. A neque malesuada in
							tortor eget justo mauris nec dolor. Consequat risus vitae, ac ac
							et preparation. He wanted to serve burgers, fries and beverages
							that tasted .</p>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<div class="single-about-wrap">
								<img src="assets/img/icon/1.png" alt="img"> Fresh food
							</div>
						</div>
						<div class="col-sm-6">
							<div class="single-about-wrap">
								<img src="assets/img/icon/2.png" alt="img"> Fast Delivery
							</div>
						</div>
						<div class="col-sm-6">
							<div class="single-about-wrap">
								<img src="assets/img/icon/3.png" alt="img"> Quality
								Maintain
							</div>
						</div>
						<div class="col-sm-6">
							<div class="single-about-wrap">
								<img src="assets/img/icon/4.png" alt="img"> 24/7 Service
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- about Area End -->

	<!-- product Area Start-->
	<section class="product-area pd-bottom-90">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12">
					<div class="section-title text-center">
						<h3 class="sub-title">Our signature</h3>
						<h2 class="title">Delicious Deals for Delicious Meals</h2>
					</div>
					<ul class="product-nav nav nav-pills" id="pills-tab" role="tablist">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="pills-ramen-tab"
								data-bs-toggle="pill" data-bs-target="#pills-ramen"
								type="button" role="tab" aria-controls="pills-ramen"
								aria-selected="true">
								<img src="assets/img/category/1.png" alt="img">Ramen
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-pizza-tab"
								data-bs-toggle="pill" data-bs-target="#pills-pizza"
								type="button" role="tab" aria-controls="pills-pizza"
								aria-selected="false">
								<img src="assets/img/category/2.png" alt="img">Pizza
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-burger-tab"
								data-bs-toggle="pill" data-bs-target="#pills-burger"
								type="button" role="tab" aria-controls="pills-burger"
								aria-selected="false">
								<img src="assets/img/category/3.png" alt="img">Burger
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-french-fry-tab"
								data-bs-toggle="pill" data-bs-target="#pills-french-fry"
								type="button" role="tab" aria-controls="pills-french-fry"
								aria-selected="false">
								<img src="assets/img/category/4.png" alt="img">French
								fries
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-fast-food-tab"
								data-bs-toggle="pill" data-bs-target="#pills-fast-food"
								type="button" role="tab" aria-controls="pills-fast-food"
								aria-selected="false">
								<img src="assets/img/category/5.png" alt="img">Fast food
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-drinks-tab"
								data-bs-toggle="pill" data-bs-target="#pills-drinks"
								type="button" role="tab" aria-controls="pills-drinks"
								aria-selected="false">
								<img src="assets/img/category/6.png" alt="img">Soft drinks
							</button>
						</li>
					</ul>
				</div>
			</div>
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-ramen"
					role="tabpanel" aria-labelledby="pills-ramen-tab">
					<div class="row justify-content-center">
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Margherita Pizza</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (200)
										</div>
										<h6 class="price">$17.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/2.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Maxican Pizza Test Better</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (928)
										</div>
										<h6 class="price">$29.00</h6>
									</div>
									<div class="btn-area">
										<a class="btn btn-secondary" href="single-product.html">CHOOSE
											OPTIONS </a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/burger/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Patty Buns Burgers</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (462)
										</div>
										<h6 class="price">$27.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-pizza" role="tabpanel"
					aria-labelledby="pills-pizza-tab">
					<div class="row justify-content-center">
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Margherita Pizza</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (200)
										</div>
										<h6 class="price">$17.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/2.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Maxican Pizza Test Better</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (928)
										</div>
										<h6 class="price">$29.00</h6>
									</div>
									<div class="btn-area">
										<a class="btn btn-secondary" href="single-product.html">CHOOSE
											OPTIONS </a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/3.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Roasted Garlic Chicken Pizza
										</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (462)
										</div>
										<h6 class="price">$27.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/4.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">All Season Gulliver Pizza </a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (462)
										</div>
										<h6 class="price">$27.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/5.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Chicken Fajita Pizza Large </a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (200)
										</div>
										<h6 class="price">$37.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/6.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">BBQ Chicken Classic Pizza
											Large </a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (928)
										</div>
										<h6 class="price">$35.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-burger" role="tabpanel"
					aria-labelledby="pills-burger-tab">
					<div class="row justify-content-center">
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Margherita Pizza</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (200)
										</div>
										<h6 class="price">$17.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/2.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Maxican Pizza Test Better</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (928)
										</div>
										<h6 class="price">$29.00</h6>
									</div>
									<div class="btn-area">
										<a class="btn btn-secondary" href="single-product.html">CHOOSE
											OPTIONS </a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/burger/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Patty Buns Burgers</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (462)
										</div>
										<h6 class="price">$27.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-french-fry" role="tabpanel"
					aria-labelledby="pills-french-fry-tab">
					<div class="row justify-content-center">
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Margherita Pizza</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (200)
										</div>
										<h6 class="price">$17.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/2.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Maxican Pizza Test Better</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (928)
										</div>
										<h6 class="price">$29.00</h6>
									</div>
									<div class="btn-area">
										<a class="btn btn-secondary" href="single-product.html">CHOOSE
											OPTIONS </a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/burger/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Patty Buns Burgers</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (462)
										</div>
										<h6 class="price">$27.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-fast-food" role="tabpanel"
					aria-labelledby="pills-fast-food-tab">
					<div class="row justify-content-center">
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Margherita Pizza</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (200)
										</div>
										<h6 class="price">$17.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/2.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Maxican Pizza Test Better</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (928)
										</div>
										<h6 class="price">$29.00</h6>
									</div>
									<div class="btn-area">
										<a class="btn btn-secondary" href="single-product.html">CHOOSE
											OPTIONS </a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/burger/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Patty Buns Burgers</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (462)
										</div>
										<h6 class="price">$27.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-drinks" role="tabpanel"
					aria-labelledby="pills-drinks-tab">
					<div class="row justify-content-center">
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Margherita Pizza</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (200)
										</div>
										<h6 class="price">$17.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/pizza/2.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Maxican Pizza Test Better</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (928)
										</div>
										<h6 class="price">$29.00</h6>
									</div>
									<div class="btn-area">
										<a class="btn btn-secondary" href="single-product.html">CHOOSE
											OPTIONS </a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="single-item-wrap">
								<div class="thumb">
									<img src="assets/img/product/burger/1.png" alt="img"> <a
										class="fav-btn" href="#"><i class="ri-heart-line"></i></a>
								</div>
								<div class="wrap-details">
									<h5>
										<a href="single-product.html">Patty Buns Burgers</a>
									</h5>
									<div class="wrap-footer">
										<div class="rating">
											4.9 <span class="rating-inner"> <i
												class="ri-star-fill ps-0"></i> <i class="ri-star-fill"></i>
												<i class="ri-star-fill"></i> <i class="ri-star-fill"></i> <i
												class="ri-star-half-line pe-0"></i>
											</span> (462)
										</div>
										<h6 class="price">$27.00</h6>
									</div>
								</div>
								<div class="btn-area">
									<a class="btn btn-secondary" href="single-product.html">CHOOSE
										OPTIONS </a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- product Area End -->



	<!-- testimonial Area Start-->
	<section class="testimonial-area text-center">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-7 col-md-10">
					<div class="testimonial-slider owl-carousel">
						<div class="item">
							<div class="testimonial-wrap">
								<p>“We have no regrets! I don't know what else to say. It
									really saves me time and effort. Food is exactly what our
									business has been lacking”</p>
								<h3>Julia R. Davis</h3>
								<h6>Food Bloger</h6>
							</div>
						</div>
						<div class="item">
							<div class="testimonial-wrap">
								<p>“We have no regrets! I don't know what else to say. It
									really saves me time and effort. Food is exactly what our
									business has been lacking”</p>
								<h3>Davis J. Rulia</h3>
								<h6>Food Bloger</h6>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- testimonial Area End -->

	<!-- blog Area Start-->
	<section class="blog-area pd-bottom-90">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-xl-5 col-lg-7">
					<div class="section-title text-center">
						<h3 class="sub-title">News & Blog</h3>
						<h2 class="title">Celebrating the awesomeness of food.</h2>
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
	<footer class="footer-area pd-top-100">
		<div class="footer-inner padding-top-100 padding-bottom-65">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-sm-6">
						<div class="footer-widget widget">
							<div class="logo">
								<img src="assets/img/logo.png" alt="img">
							</div>
							<ul class="contact_info_list">
								<li class="single-info-item"><img
									src="assets/img/icon/location.png" alt="icon">
									<div class="details">4920 Trails End Road Ft United
										States, FL 33311</div></li>
								<li class="single-info-item"><img
									src="assets/img/icon/envelope.png" alt="icon">
									<div class="details">ordernow@foodka.com</div></li>
								<li class="single-info-item"><img
									src="assets/img/icon/phone.png" alt="icon">
									<div class="details">+997 509 153 849</div></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="footer-widget widget widget_link">
							<h4 class="widget-title">Hot Menu</h4>
							<ul>
								<li><a href="menu-list.html">Burger King Whopper</a></li>
								<li><a href="menu-list.html">Five Guys Cheeseburger</a></li>
								<li><a href="menu-list.html">KFC Original Recipe
										Chicken</a></li>
								<li><a href="menu-list.html">Wendy's Frosty</a></li>
								<li><a href="menu-list.html">McDonald's Happy Meal</a></li>
								<li><a href="menu-list.html">Domino's Pepperoni Pizza</a></li>
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
								<li>Friday : 09.00am-10.00pm</li>
								<li>Saturday & Sunday : <span>Closed</span></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="footer-widget widget widget_instagram_feeds">
							<h4 class="widget-title">Instagram Feeds</h4>
							<ul>
								<li><a href="#"><img src="assets/img/instagram/1.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img src="assets/img/instagram/2.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img src="assets/img/instagram/3.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img src="assets/img/instagram/4.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img src="assets/img/instagram/5.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img src="assets/img/instagram/6.png"
										alt="instagram" /></a></li>
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
</body>
</html>