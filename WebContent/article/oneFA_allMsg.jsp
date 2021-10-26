<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.foodarticle.model.*"%>
<%@ page import="com.message.model.*"%>
<%@ page import="com.picturebase.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
  FoodArticleVO faVO = (FoodArticleVO) request.getAttribute("faVO"); //FoodArticleServlet.java(Concroller), 存入req的faVO物件
   List<MessageVO> msgList = (List<MessageVO>) request.getAttribute("msgList");
//    request.setAttribute("msgList", msgList);
%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>FoodKa - Food Ordering, Delivery & Restuarent Template</title>
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


<style>
div.authorname {
	font-weight: 600;
	font-size: 20px;
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
					<a class="main-logo"
						href="<%=request.getContextPath()%>/home-1.html"><img
						src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>
				</div>
				<div class="collapse navbar-collapse" id="themefie_main_menu">
					<ul class="navbar-nav menu-open">
						<li class="current-menu-item menu-item-has-children"><a
							href="home-1.html">訂餐</a>
							<ul class="sub-menu ps-0">
								<li><a href="<%=request.getContextPath()%>/shop.html">Shop</a></li>
								<li><a href="<%=request.getContextPath()%>/menu.html">Menu</a></li>
								<li><a href="<%=request.getContextPath()%>/cart.html">Cart</a></li>
								<li><a href="<%=request.getContextPath()%>/checkout.html">Checkout</a></li>
							</ul></li>
						<li><a href="<%=request.getContextPath()%>/blog.html">食記</a>
						</li>
						<li><a href="<%=request.getContextPath()%>/about.html">ABOUT
								US</a></li>
						<li><a href="<%=request.getContextPath()%>/contact.html">CONTACTS</a>
						</li>
					</ul>
				</div>
				<div class="nav-right-part nav-right-part-mobile">
					<ul>
						<li><a class="search" href="#"><i class="ri-search-line"></i></a>
						</li>
						<li class="phone-contact d-md-block d-none"><i
							class="ri-phone-fill float-start"></i> +997 509 153 849</li>
						<li class="menu-cart"><a
							href="<%=request.getContextPath()%>/cart.html">CART <span>1</span></a></li>
						<li>49.50 $</li>
					</ul>
				</div>
				<div class="nav-right-part nav-right-part-desktop">
					<ul>
						<li><a class="search" href="#"><i class="ri-search-line"></i></a>
						</li>
						<li class="phone-contact"><a href="#">sign in</a></li>
						<li class="menu-cart"><a href="#">小鈴鐺 <span>4</span></a></li>
						<li class="menu-cart"><a
							href="<%=request.getContextPath()%>/cart.html">CART <span>1</span></a></li>
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
		<div class="banner-shape-1">
			<img
				src="<%=request.getContextPath()%>/assets/img/banner/shape-1.png"
				alt="img">
		</div>
		<div class="banner-shape-2">
			<img
				src="<%=request.getContextPath()%>/assets/img/banner/shape-2.png"
				alt="img">
		</div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6 align-self-center">
					<div class="banner-inner text-center">
						<h3>Blog Details</h3>
						<h1>Food Blog</h1>
						<nav aria-label="breadcrumb">
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="home.html">Home</a></li>
								<li class="breadcrumb-item"><a href="blog.html">Blog</a></li>
								<li class="breadcrumb-item active" aria-current="page">Blog
									Details</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- bredcrumb Area End -->

	<!-- blog single start -->
	<div class="blog-single-area pd-top-120 pd-bottom-90">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="blog-details-inner">
						<!-- <div class="thumb pb-4">
                            <img src="<%=request.getContextPath()%>/assets/img/blog/single.png" alt="img">
                        </div>  -->
						<div class="author">


							<!--   取作者id     -->
							<div class="authorname"><%=faVO.getUserId()%></div>

						</div>
						<span class="cat"> <span class="date"> <i
								class="ri-calendar-todo-fill"></i> <%=faVO.getArticleDate()%>
						</span> <input type="hidden" value="時間"> <a href="#"
							class="tag me-0"> <i class="ri-price-tag-3-fill"></i>Burgar
						</a>
						</span>
						<h3><%=faVO.getArticleTitle()%></h3>
						<input type="hidden" value="文章標題">

						<p>
							<%=faVO.getArticleContent()%>
						</p>


						<div class="row">
							<div class="col-6">

								 <c:forEach var="adf" items="${list}" varStatus="index">
								       <img class="w-100" src="<%=request.getContextPath()%>/PictureBasesServlet?id=${index.index}">                                
								 </c:forEach>
						   </div>

						</div>								                               
							

					</div>
					<div class="tag-share-area">
						<div class="row">
							<div class="col-sm-6 align-self-center">
								<div class="tag-inner">
									<span>Tags: </span> <a href="#">Fresh Food, </a> <a href="#">Spicy,
									</a> <a href="#">Delicious</a>
								</div>
							</div>
							<div class="col-sm-6 mt-3 mt-sm-0 align-items-center">
								<ul class="social-area text-sm-end mt-md-0 mt-2">
									<li><a href="https://zh-tw.facebook.com/"><i
											class="fab fa-facebook-f"></i></a></li>
									<li><a href="#"><i class="fab fa-twitter"></i></a></li>
									<li><a href="#"><i class="fab fa-behance"></i></a></li>
									<li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
									<li><a href="#"><i class="fab fa-google-plus-g"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="comment-area">
						<h5 class="title">03 Comments</h5>

						<c:forEach var="msgVO" items="${msgList}">
							<div class="media">
								<!--                             <div class="media-left"> -->
								<%--                                 <img src="<%=request.getContextPath()%>/assets/img/blog/comment.png" alt="img"> --%>
								<!--                             </div>                             -->
								<div class="media-body">
									<h6>${msgVO.userId}</h6>
									<span>${msgVO.msgDate}</span>
									<p>${msgVO.msgContent}</p>
									<input type="hidden" value="${msgVO.sta}">
								</div>
							</div>
						</c:forEach>

					</div>


					<form class="default-form-wrap" method="post" action="msg.do">
						<h5 class="title">留言</h5>
						<div class="row">
							<div class="col-md-6">
								<div class="single-input-wrap">
									<input type="text" class="form-control" placeholder="Your Name"
										name="userId"> <input type="hidden" name="articleNo"
										value="<%=faVO.getArticleNo()%>" />
								</div>
							</div>
							<div class="col-md-6">
								<!--                                  <div class="single-input-wrap"> -->
								<!--                                      <input type="text" class="form-control" placeholder="Your Email">  -->
								<!--                                  </div>   -->


							</div>
							<div class="col-12">
								<div class="single-textarea-wrap">

									<textarea rows="4" placeholder="Message..." name="msgContent"></textarea>
									<input type="hidden" value="1" name="sta">

								</div>
							</div>
						</div>
						<button type="submit" class="btn btn-base">Submit your
							Message</button>
						<input type="hidden" name="action" value="msgAdd">
					</form>
				</div>
				
				<div class="col-lg-4">
					<div class="sidebar-area">
						<div class="widget widget_search">
							<form class="search-form">
								<div class="form-group">
									<input type="text" placeholder="Search your itmes">
								</div>
								<button class="submit-btn" type="submit">
									<i class="ri-search-line"></i>
								</button>
							</form>
						</div>
						<div class="widget widget-recent-post">
							<h4 class="widget-title">熱門食記(待處理)</h4>
							<ul>
								<li>
									<div class="media">
										<div class="media-left">
											<img
												src="<%=request.getContextPath()%>/assets/img/widget/1.png"
												alt="widget">
										</div>
										<div class="media-body">
											<h6 class="title">
												<a href="#">Greek yogurt breakfast bowls with toppings</a>
											</h6>
										</div>
									</div>
								</li>
								<li>
									<div class="media">
										<div class="media-left">
											<img
												src="<%=request.getContextPath()%>/assets/img/widget/2.png"
												alt="widget">
										</div>
										<div class="media-body">
											<h6 class="title">
												<a href="#">Broad, garlic & mozzarella cheese bruschetta
												</a>
											</h6>
										</div>
									</div>
								</li>
								<li>
									<div class="media">
										<div class="media-left">
											<img
												src="<%=request.getContextPath()%>/assets/img/widget/3.png"
												alt="widget">
										</div>
										<div class="media-body">
											<h6 class="title">
												<a href="#">Make authentic Italian margherita pizza at
													home </a>
											</h6>
										</div>
									</div>
								</li>
								<li>
									<div class="media">
										<div class="media-left">
											<img
												src="<%=request.getContextPath()%>/assets/img/widget/4.png"
												alt="widget">
										</div>
										<div class="media-body">
											<h6 class="title">
												<a href="#">BBQ Chicken Classic Pizza Large</a>
											</h6>
										</div>
									</div>
								</li>
							</ul>
						</div>
						<div class="widget widget-newsletter">
							<h4 class="widget-title">熱門餐廳(待處理)</h4>
							<p>Subscribe to get the latest news, update and offer
								information. Don't worry, we won't send spam!</p>
							<form class="newsletter-form">
								<div class="form-group">
									<input type="email" placeholder="Enter e-mail">
								</div>
								<button class="submit-btn" type="submit">
									<i class="ri-arrow-right-line"></i>
								</button>
							</form>
						</div>
						<!-- <div class="widget widget_categories">
                            <h4 class="widget-title">Categories</h4>
                            <ul>
                                <li><a href="#">Inspiration <span>(5)</span></a></li>
                                <li><a href="#">Recipes <span>(9)</span> </a></li>
                                <li><a href="#">Others <span>(18)</span></a></li>
                            </ul>
                        </div> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- blog single end -->

	<!-- footer area start -->
	<footer class="footer-area pd-top-100">
		<div class="footer-inner padding-top-100 padding-bottom-65">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-sm-6">
						<div class="footer-widget widget">
							<div class="logo">
								<img src="<%=request.getContextPath()%>/assets/img/logo.png"
									alt="img">
							</div>
							<ul class="contact_info_list">
								<li class="single-info-item"><img
									src="<%=request.getContextPath()%>/assets/img/icon/location.png"
									alt="icon">
									<div class="details">4920 Trails End Road Ft United
										States, FL 33311</div></li>
								<li class="single-info-item"><img
									src="<%=request.getContextPath()%>/assets/img/icon/envelope.png"
									alt="icon">
									<div class="details">ordernow@foodka.com</div></li>
								<li class="single-info-item"><img
									src="<%=request.getContextPath()%>/assets/img/icon/phone.png"
									alt="icon">
									<div class="details">+997 509 153 849</div></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="footer-widget widget widget_link">
							<h4 class="widget-title">Hot Menu</h4>
							<ul>
								<li><a href="<%=request.getContextPath()%>/menu-list.html">Burger
										King Whopper</a></li>
								<li><a href="<%=request.getContextPath()%>/menu-list.html">Five
										Guys Cheeseburger</a></li>
								<li><a href="<%=request.getContextPath()%>/menu-list.html">KFC
										Original Recipe Chicken</a></li>
								<li><a href="<%=request.getContextPath()%>/menu-list.html">Wendy's
										Frosty</a></li>
								<li><a href="<%=request.getContextPath()%>/menu-list.html">McDonald's
										Happy Meal</a></li>
								<li><a href="<%=request.getContextPath()%>/menu-list.html">Domino's
										Pepperoni Pizza</a></li>
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
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/instagram/1.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/instagram/2.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/instagram/3.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/instagram/4.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/instagram/5.png"
										alt="instagram" /></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/instagram/6.png"
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
	<script src="<%=request.getContextPath()%>/assets/js/jquery.3.6.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/imageloded.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/counterup.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/waypoint.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/magnific.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/isotope.pkgd.min.js"></script>
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
</body>
</html>