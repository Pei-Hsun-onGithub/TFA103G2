<%@page import="java.util.List"%>
<%@page import="com.meal.model.MealService"%>
<%@page import="com.meal.model.MealVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Advertisement</title>
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

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/vendors/DataTables/datatables.css">
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

div.my-aside-left-container img {
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

div.my-chooseType ul li button {
	width: 100px;
	height: 50px;
	border-radius: 5px;
	background: white;
	text-align: center;
	vertical-align: middle;
	border: 1px solid #198754;
	color: #198754;
	line-height: 56px;
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
					<a class="main-logo" href="<%=request.getContextPath()%>/pei_pages/BackgroundManager.jsp"><img
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
						<li style="visibility: hidden;"><a class="search" href="#"><i
								class="ri-search-line"></i></a></li>
						<li class="menu-cart"><a href="#" style="visibility: hidden;">小鈴鐺
								<span>4</span>
						</a></li>
						<li class="menu-cart"><a href="cart.html"
							style="visibility: hidden;">CART <span>1</span></a></li>



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
						<h5 class="card-title">廣告看板</h5>

						<div style="overflow: hidden;">
							<h4 class="my-query-title" style="float: left;">餐廳圖片清單</h4>
						</div>

						<!-- RestaurantList start -->
						<section class="work-area">
							<div class="container my-content">

								<div class="row justify-content-center">
								
									<table id="table_id" class="display">
										<thead>
						<tr>
							<th>餐點編號</th>
							<th>狀態</th>
							<th>餐點名稱</th>
							<th>餐點類型</th>
							<th>單價</th>
							<th>上市日期</th>
							<th>上市天數</th>
							<th>餐點描述</th>
							<th>餐點照片</th>
							
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<%
						
						MealService mealSvc = new MealService();
						List<MealVO> list = mealSvc.getAll();
						request.setAttribute("list", list);
						
						%>

						<c:forEach var="mealVO" items="${list}">

							<tr>
								<td>${mealVO.mealId}</td>
								<td>${(mealVO.sta == 2)? "下架" : "熱賣中"}</td>
								<td>${mealVO.mealName}</td>
								<td>${mealVO.mealType}</td>
								<td>${mealVO.unitPrice}</td>
								<td>${mealVO.launchDate}</td>
								<td>${mealVO.launchDays}</td>
								<td>${mealVO.mealDescription}</td>
								<td><img
									src="/TFA103G2/meal/photoServlet?id=${mealVO.mealId}" /></td>
								
								<td>
									<FORM METHOD="post"
										ACTION="/TFA103G2/meal/meal.do?action=getOne_For_Update"
										style="margin-bottom: 0px;">
										<input type="submit" class="btn btn-warning my-btn" value="修改">
										<input type="hidden" name="mealId" value="${mealVO.mealId}">
									</FORM>
								</td>
								<td>
									<FORM METHOD="post"
										ACTION="/TFA103G2/meal/meal.do?action=delete"
										style="margin-bottom: 0px;">

										<input type="submit" class="btn btn-warning my-btn"
											id="my-delete-submit" value="下架"> <input
											type="hidden" name="mealId" value="${mealVO.mealId}">


									</FORM>
								</td>

							</tr>
						</c:forEach>
					</tbody>
									</table>
									
									
								</div>
								
							</div>
						</section>
						<!-- RestaurantList End -->
					
					
					<br>
					
					<div style="overflow: hidden;">
							<h4 class="my-query-title" style="float: left;">食記清單</h4>
						</div>

						<!-- FoodArticle start -->
						<section class="work-area">
							<div class="container my-content">

								<div class="row justify-content-center">
								
									<table id="table_id" class="display">
										<thead>
											<tr>
												<th>成就編號</th>
												<th>成就名稱</th>
												<th>描述</th>
												<th>開始日期</th>
												<th>有效天數</th>
												<th>達標食記數量</th>
												<th>達標訂單數量</th>
												<th>獲得飼料數目</th>
												<th>獲得金幣數目</th>
												<th>徽章圖案</th>

												<th></th>
												<th></th>
											</tr>
										</thead>
										<tbody>
				

											<c:forEach var="achieveVO" items="${lis}">

											<tr>
													<td>${achieveVO.achiId}</td>
													<td>${achieveVO.achiName}</td>
													<td>${achieveVO.descript}</td>
													<td>${achieveVO.openDate}</td>
													<td>${achieveVO.validDays}</td>
													<td>${achieveVO.achiArticle}</td>
													<td>${achieveVO.achiOrder}</td>
													<td>${achieveVO.gainFeed}</td>
													<td>${achieveVO.gainGold}</td>
													<td><img
														src="/TFA103G2/meal/photoServlet?id=${achieveVO.achiId}" /></td>

													<td>
														<FORM METHOD="post"
															ACTION="/TFA103G2/meal/meal.do?action=getOne_For_Update"
															style="margin-bottom: 0px;">
															<input type="submit" class="btn btn-warning my-btn"
																value="修改"> <input type="hidden" name="mealId"
																value="${achieveVO.achiId}">
														</FORM>
													</td>
													<td>
														<FORM METHOD="post"
															ACTION="/TFA103G2/achieve/AchieveQualify.do?action=triggerAchieveMission&achieveId=${achieveVO.achiId}"
															style="margin-bottom: 0px;">

															<input type="submit" class="btn btn-warning my-btn"
																id="my-delete-submit" value="上線"> <input
																type="hidden" name="mealId" value="${achieveVO.achiId}">


														</FORM>
													</td>
													
													

												</tr>
											</c:forEach>
										</tbody>
									</table>
									
									
								</div>
								
							</div>
						</section>
						<!-- FoodArticle End -->
					
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

	<script type="text/javascript" charset="utf8"
		src="<%=request.getContextPath()%>/vendors/DataTables/datatables.js"></script>

	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();

		});
	</script>


</body>
</html>
