<%@page import="com.restaurant.model.RestaurantService"%>
<%@page import="util.DistrictCityMapping"%>
<%@page import="com.restaurant.model.RestaurantVO"%>
<%@page import="java.sql.Time"%>
<%@ page import="com.meal.model.MealVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0);
%>

<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>vendor_meal_restaurant_addInfo</title>
<!--fivicon icon-->
<link rel="icon" href="assets/img/fevicon.png">

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
<!-- jquery timepicker -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/vendors/dist/css/timepicker.css">
<script src="../dist/js/timepicker.js"></script>

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

div.my-aside-left-container img {
	width: 42px;
	height: 42px;
}

.timepicker {
	position: absolute;
	z-index: 1000;
	float: left;
	width: 160px;
	padding-bottom: 5px;
	margin: 2px 0 0 0;
	list-style: none;
	font-size: 14px;
	text-align: center;
	background-color: white;
	border: 1px solid #ccc;
	border: 1px solid rgba(0, 0, 0, 0.15);
	border-radius: 4px;
	-webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);
	background-clip: padding-box;
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
<body>

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
						<li style="visibility: hidden;"><a class="search" href="#"><i
								class="ri-search-line"></i></a></li>
						<li class="menu-cart"><a href="#" style="visibility: hidden;">小鈴鐺
								<span>4</span>
						</a></li>
						<li class="menu-cart"><a href="cart.html"
							style="visibility: hidden;">CART <span>1</span></a></li>
						<li class="phone-contact"><a href="#">登出</a></li>


					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class="shop-details-area pd-top-100">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-3">
					<div class="my-aside-left-container">

						<div class="widget widget_categories style-2">
							<h4 class="widget-title" style="visibility: hidden;">Categories</h4>
							<ul>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/images/m1.svg" alt="img">
										餐廳資料 <span>(5)</span></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/images/m2.svg" alt="img">
										餐點上架 <span>(9)</span> </a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/images/m3.svg" alt="img">
										訂單追蹤 <span>(18)</span></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/images/m4.svg" alt="img">
										歷史明細 <span>(14)</span></a></li>
								<li style="visibility: hidden;"><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/category/5.png"
										alt="img"> Fast food <span>(10)</span></a></li>
								<li style="visibility: hidden;"><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/category/6.png"
										alt="img"> Soft drinks <span>(28)</span></a></li>
							</ul>
						</div>
					</div>

				</div>
				<div class="col-md-9">
					<div class="bill-payment-wrap">
						<h5>首次註冊，請新增餐廳資料</h5>


						<!--         新增一筆Meal資料                   -->
						<!-- form 開始 -->
						<form class="default-form-wrap style-2" method="post"
							action="<%=request.getContextPath()%>/restaurant/restaurant.do">


							<%
								RestaurantVO restVO = (RestaurantVO) request.getAttribute("restVO");
								request.setAttribute("restVO", restVO);
							%>


							<div class="row">
								<div class="col-md-5">
									<label>餐廳名稱</label>
									<div class="single-input-wrap">

										<input type="text" class="form-control" name="restaurantName"
											value="欣葉日本料理" onkeyup="errorHandler(0);">
									</div>
								</div>
								
								<div class="col-md-5 my-error-restName">
									<a href="#" tabindex="-1"
										class="btn btn-primary disabled placeholder col-4"
										aria-hidden="true" style="visibility: hidden; height: 45px;"></a>
									<div data-restnameError-empty style="display: none;color: red;">*餐廳名稱不能是空白</div>
									<div data-restnameError-special style="display: none;color: red;">*餐廳名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間</div>
									<div data-restnameError-pass style=""><i class="far fa-check-circle"></i></div>
								</div>

							</div>


							<%
								Time now = new Time(System.currentTimeMillis());
								pageContext.setAttribute("now", now);
							%>


							<div class="row">
								<div class="col-md-5">
									<label>營業時間</label>
								</div>
							</div>

							<div class="row">
								<div class="col-md-2 my-time-setting-block">
									<label>OPEN</label>
								</div>
								<div class="col-md-3">
									<div class="single-input-wrap">
										<input type="text" class="bs-timepicker" name="openTime"
											value=<fmt:formatDate value="${now}" pattern="HH:mm"/>>
									</div>
								</div>

							</div>


							<div class="row">
								<div class="col-md-2 my-time-setting-block">
									<label>CLOSE</label>
								</div>
								<div class="col-md-3">
									<div class="single-input-wrap">
										<input type="text" class="bs-timepicker" name="closeTime"
											value=<fmt:formatDate value="${now}" pattern="HH:mm"/>>
									</div>
								</div>

							</div>

							<%
								RestaurantService restSvc = new RestaurantService();
							%>

							<div class="row">
								<div class="col-md-2 my-time-setting-block">
									<label>每週公休</label>
								</div>
								<div class="col-md-10 my-time-setting-block-weekly-picker">

									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox1" name="Mon"> <label
											class="form-check-label" for="inlineCheckbox1">Mon</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox2" name="Tue"> <label
											class="form-check-label" for="inlineCheckbox2">Tue</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox1" name="Wed"> <label
											class="form-check-label" for="inlineCheckbox1">Wed</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox2" name="Thu"> <label
											class="form-check-label" for="inlineCheckbox2">Thu</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox1" name="Fri"> <label
											class="form-check-label" for="inlineCheckbox1">Fri</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox2" name="Sat"> <label
											class="form-check-label" for="inlineCheckbox2">Sat</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox2" name="Sun"> <label
											class="form-check-label" for="inlineCheckbox2">Sun</label>
									</div>
								</div>

							</div>

							<div class="row" style="display: none;">
								<div class="col-md-2 my-time-setting-block">
									<label>彈性休假日</label>
								</div>
								<div class="col-md-3">
									<div class="single-input-wrap">
										<input type="text" name="dayoffId" value="234">
									</div>
								</div>

							</div>


							<div class="row">
								<div class="col-md-5">
									<label>店家地址</label>
								</div>
							</div>


							<div class="row">
								<div class="col-md-2 my-time-setting-block">
									<label>縣市</label>
								</div>
								<div class="col-md-10">
									<div class="single-input-wrap">
										<select
											class="myclass-select myclass-select-lauchdays my-distrc-select"
											id="inputGroupSelect01" name="district">
											<c:forEach var="distr"
												items="<%=DistrictCityMapping.getDistrcs()%>">
												<option value="${distr}">${distr}
											</c:forEach>
										</select>
									</div>
								</div>



							</div>

							<div class="row">
								<div class="col-md-2 my-time-setting-block">
									<label>地區</label>
								</div>
								<div class="col-md-10">
									<div class="single-input-wrap">
										<select
											class="myclass-select myclass-select-lauchdays my-city-select"
											id="inputGroupSelect01" name="city">
											<c:forEach var="city"
												items="<%=DistrictCityMapping.getCitys(\"台北市\")%>">
												<option value="${city}">${city}
											</c:forEach>
										</select>
									</div>
								</div>

							</div>

							<div class="row">
								<div class="col-md-2 my-time-setting-block">
									<label>位置</label>
								</div>
								<div class="col-md-5">
									<div class="single-input-wrap">

										<input type="text" class="form-control" name="location"
											value="復興北路一段100號" onkeyup="errorHandler(1);">
									</div>
								</div>
								
								<div class="col-md-5 my-error-location">
									<a href="#" tabindex="-1"
										class="btn btn-primary disabled placeholder col-4"
										aria-hidden="true" style="visibility: hidden; height: 5px;margin-top:12px;"></a>
									<div data-locationError-empty style="display: none;color: red;">*地址不能是空白</div>
									<div data-locationError-special style="display: none;color: red;">*地址: 只能是中、英文字母、數字，且長度必需在2到15之間</div>
									<div data-locationError-pass style=""><i class="far fa-check-circle"></i></div>
								</div>
								

							</div>



							<jsp:useBean id="styleSvc" scope="page"
								class="com.style.model.StyleService" />

							<div class="row">
								<div class="col-md-4">
									<label>餐廳類型 (最多挑3項)</label>
									<div class="single-input-wrap">

										<select
											class="myclass-select myclass-select-lauchdays my-pickStyle"
											name="pickStyle" id="inputGroupSelect01">
											<c:forEach var="styleVO" items="${styleSvc.allStyle}">
												<option value="${styleVO.styleId}">${styleVO.styleType}
											</c:forEach>

										</select>
									</div>
								</div>

								<div class="col-md-8">
									<label style="visibility: hidden;">類型候選</label>
									<div class="single-input-wrap my-chooseType">
										<!-- 放一些標籤上來 -->
										<ul>
											<li>

												<button type="button" class="choose1" aria-label="Close"
													hidden></button> <!-- 預設的選項為 50 --> <input type="hidden"
												class="inchoose1" name="style1">
											</li>
											<li>
												<button type="button" class="choose2" aria-label="Close"
													hidden></button> <input type="hidden" class="inchoose2"
												name="style2">
											</li>
											<li>
												<button type="button" class="choose3" aria-label="Close"
													hidden></button> <input type="hidden" class="inchoose3"
												name="style3">
											</li>
										</ul>

									</div>
								</div>

							</div>

							<div class="row">
								<div class="col-md-5">
									<label>負責人</label>
									<div class="single-input-wrap">

										<input type="text" class="form-control" name="boss"
											value="劉德華" onkeyup="errorHandler(2);">
									</div>
								</div>
								
								<div class="col-md-5 my-error-boss">
									<a href="#" tabindex="-1"
										class="btn btn-primary disabled placeholder col-4"
										aria-hidden="true" style="visibility: hidden; height: 55px;margin-top:12px;"></a>
									<div data-bossError-empty style="display: none;color: red;">*名字不能是空白</div>
									<div data-bossError-special style="display: none;color: red;">*名字: 只能是中、英文字母，且長度必需在3到10之間</div>
									<div data-bossError-pass style=""><i class="far fa-check-circle"></i></div>
								</div>

							</div>

							<div class="row">
								<div class="col-md-5">
									<label>連絡電話</label>
									<div class="single-input-wrap">

										<input type="text" class="form-control" name="phone"
											value="0933345667" onkeyup="errorHandler(3);">
									</div>
								</div>
								
								<div class="col-md-5 my-error-phone">
									<a href="#" tabindex="-1"
										class="btn btn-primary disabled placeholder col-4"
										aria-hidden="true" style="visibility: hidden; height: 55px;margin-top:12px;"></a>
									<div data-phoneError-empty style="display: none;color: red;">*電話不能是空白</div>
									<div data-phoneError-special style="display: none;color: red;">*電話: 只能0~9數字，且長度必需在8到10之間</div>
									<div data-phoneError-pass style=""><i class="far fa-check-circle"></i></div>
								</div>

							</div>

							<!-- 隱藏的餐廳狀態 START-->

							<input type="hidden" class="form-control" name="sta" value="1">

							<!-- 隱藏的餐廳狀態 END -->

							<div class="col-md-12">

								<div class="row my-btn-wrapper">
									<div class="col-md-4"></div>
									<div class="col-md-4">
										<input type="hidden" name="action" value="insert">
										<button type="submit" class="btn btn-base" id="btn_submit">新增</button>
									</div>
									<div class="col-md-2"></div>

								</div>
							</div>

						</form>

						<!-- form 結束 -->



					</div>
				</div>
			</div>
		</div>
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

	<!-- jquery timepicker -->
	<script
		src="<%=request.getContextPath()%>/vendors/dist/js/timepicker.js"></script>





	<script>
		$(document)
				.ready(
						function() {

							/**********************************************      timepicker操作         ***************************************************/

							var p_file_el = document.getElementById("p_file");
							var preview_el = document.getElementById("preview");

							$('.bs-timepicker').timepicker();

							$('#my-img-btn').on("click", function(e) {
								$('#p_file').click();

							});

							/**********************************************      餐廳類型選項操作         ***************************************************/

							/**************      將select選取到的option顯示出來      ***************/
							$('.my-pickStyle')
									.on(
											"change",
											function(e) {

												var chosen = $(
														"select[name='pickStyle'] :selected")
														.text().trim();
												var c1 = $('button.choose1')
														.text().trim();
												var c2 = $('button.choose2')
														.text().trim();
												var c3 = $('button.choose3')
														.text().trim();
												// 檯面上顯示的標籤不可以再被重複選取 
												if (c1 === chosen
														|| c2 === chosen
														|| c3 === chosen) {
													//console.log("重複");
													// doNothing!
												} else {
													if ($('button.choose1').is(
															'[hidden]')) {
														$('button.choose1')
																.removeAttr(
																		"hidden");
														$('button.choose1')
																.text(
																		this.options[this.selectedIndex].text);
														$('input.inchoose1')
																.val(this.value);

													} else if ($(
															'button.choose2')
															.is('[hidden]')) {
														$('button.choose2')
																.removeAttr(
																		"hidden");
														$('button.choose2')
																.text(
																		this.options[this.selectedIndex].text);
														$('input.inchoose2')
																.val(this.value);
													} else if ($(
															'button.choose3')
															.is('[hidden]')) {
														$('button.choose3')
																.removeAttr(
																		"hidden");
														$('button.choose3')
																.text(
																		this.options[this.selectedIndex].text);
														$('input.inchoose3')
																.val(this.value);
													}
												}

											});

							/**************      將點選的button關閉並且去值         ****************/
							$('button.choose1').on("click", function(e) {

								this.setAttribute("hidden", "");
								$('button.choose1').text("");
								$('input.inchoose1').val("");

							});

							$('button.choose2').on("click", function(e) {

								this.setAttribute("hidden", "");
								$('button.choose2').text("");
								$('input.inchoose2').val("");
							});

							$('button.choose3').on("click", function(e) {

								this.setAttribute("hidden", "");
								$('button.choose3').text("");
								$('input.inchoose3').val("");
							});

							/*********************************************   縣市地區的操作       **********************************************************/

							// 設定預設的行政區選項是"台北市"
							$("select.my-distrc-select option[value='台北市']")
									.prop("selected", true);

							$('select.my-distrc-select')
									.on(
											'change',
											function(e) {
												var selectedDistrict = this.options[this.selectedIndex].text
														.trim();
												var json =
	<%=DistrictCityMapping.getJsonDistricsMappingToCitys()%>
		;

												if (selectedDistrict === "台北市") {
													// 滾出city的option
													deleteAllCurrentOptions();
													var citys = json.taipei;
													addOptionsToSelect(citys);
												}

												if (selectedDistrict === "桃園市") {
													// 滾出city的option
													deleteAllCurrentOptions();
													var citys = json.taoyuan;
													addOptionsToSelect(citys);

												}

											});

							function deleteAllCurrentOptions() {
								$('select.my-city-select').empty();
							}

							function addOptionsToSelect(citys) {

								citys.forEach(function(city) {
									$('select.my-city-select').append(
											"<option value=\""
									 + city + "\">"
													+ city + "</option>");
								});
							}

							
							
						});

		/*********************************************   錯誤處理       **********************************************************/
			function errorHandler(item) {
							//console.log(item);
							let items = ["restaurantName","location", "boss", "phone"];
							
								$.ajax({
									  url: "<%=request.getContextPath()%>/restaurant/restaurant.do?action=errorVerify&param="+ item,  
									  type: "POST",                  // GET | POST | PUT | DELETE | PATCH
									  data: {"item" : $('input[name=' + items[item] + ']').val()
									  },         // 傳送資料到指定的 url
									  dataType: "json",             // 預期會接收到回傳資料的格式： json | xml | html
									  success: function(data){      // request 成功取得回應後執行
										if(item === 0) {
											
											 $('div.my-error-restName div[data-restnameError-empty]').hide();
											  $('div.my-error-restName div[data-restnameError-special]').hide();
											  $('div.my-error-restName div[data-restnameError-pass]').hide();
											  
											  if(isExistError(data.noEmpty)) {
												  $('div.my-error-restName div[data-restnameError-empty]').show();
											  }
											  else if(isExistError(data.errorFormatName)) {
												  $('div.my-error-restName div[data-restnameError-special]').show();
												  
											  } else {
												  $('div.my-error-restName div[data-restnameError-pass]').show();
											  }
										}
									  
										if(item === 1) {
											
											$('div.my-error-location div[data-locationError-empty]').hide();
											  $('div.my-error-location div[data-locationError-special]').hide();
											  $('div.my-error-location div[data-locationError-pass]').hide();
											  
											  if(isExistError(data.noEmpty)) {
												  $('div.my-error-location div[data-locationError-empty]').show();
											  }
											  else if(isExistError(data.errorFormatName)) {
												  $('div.my-error-location div[data-locationError-special]').show();
												  
											  } else {
												  $('div.my-error-location div[data-locationError-pass]').show();
											  }
											  
											  
										}
										if(item === 2) {
											
											$('div.my-error-boss div[data-bossError-empty]').hide();
											  $('div.my-error-boss div[data-bossError-special]').hide();
											  $('div.my-error-boss div[data-bossError-pass]').hide();
											  
											  if(isExistError(data.noEmpty)) {
												  $('div.my-error-boss div[data-bossError-empty]').show();
											  }
											  else if(isExistError(data.errorFormatName)) {
												  $('div.my-error-boss div[data-bossError-special]').show();
												  
											  } else {
												  $('div.my-error-boss div[data-bossError-pass]').show();
											  }
											  
											  
										}
										if(item === 3) {
											
											$('div.my-error-phone div[data-phoneError-empty]').hide();
											  $('div.my-error-phone div[data-phoneError-special]').hide();
											  $('div.my-error-phone div[data-phoneError-pass]').hide();
											  
											  if(isExistError(data.noEmpty)) {
												  $('div.my-error-phone div[data-phoneError-empty]').show();
											  }
											  else if(isExistError(data.errorFormatName)) {
												  $('div.my-error-phone div[data-phoneError-special]').show();
												  
											  } else {
												  $('div.my-error-phone div[data-phoneError-pass]').show();
											  }
											  
											  
										}
									  
									  }
									  
									  
									  
									});
								
								
								
							}
								
			$('button#btn_submit').on("click", function(e) {
				
				
				// 如果有錯誤導回錯誤處
				if($('div[data-restnameError-pass]').attr('style')) {
					$('input[name="restaurantName"]').focus();
					//要加return false否則一樣會送出
					return false;
				} else if($('div[data-locationError-pass]').attr('style')) {
					$('input[name="location"]').focus();
					return false;
				} else if($('div[data-bossError-pass]').attr('style')) {
					$('input[name="boss"]').focus();
					return false;
				} else if($('div[data-phoneError-pass]').attr('style')) {
					$('input[name="phone"]').focus();
					return false;
				}
				
				
				// 如果沒有錯誤才能submit
				this.click();
				
				
				
				
			});
								
		function isExistError(errorMsg) {
			//console.log(errorMsg);
			if(errorMsg.length != 0)
				return true;
			return false;
		}
			
		
		
	</script>
</body>
</html>