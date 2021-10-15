<%@ page import="com.meal.model.MealVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>vendor_meal_upload</title>
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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.css" />
<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">
<style>
/*    fix my aside left     */
/* .my-aside-left-container .widget {
          width: 280px;
          position: fixed;
          top:15%;
          left:3%;
        } */
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
</style>
</head>
<body>

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
					<a class="main-logo" href="home-1.html"><img
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
						<li><a class="search" href="#"><i class="ri-search-line"></i></a>
						</li>
						<li class="phone-contact"><a href="#">sign in</a></li>
						<li class="menu-cart"><a href="#">小鈴鐺 <span>4</span></a></li>
						<li class="menu-cart"><a href="cart.html">CART <span>1</span></a></li>
						<li>49.50 $</li>
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
							<h4 class="widget-title">Categories</h4>
							<ul>
								<li><a href="<%=request.getContextPath()%>/pei_pages/vendor_restaurant_addInfo.jsp"><img
										src="<%=request.getContextPath()%>/assets/img/category/1.png"
										alt="img"> 餐廳資料 <span>(5)</span></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/category/2.png"
										alt="img"> 餐點上架 <span>(9)</span> </a></li>
								<li><a href="<%=request.getContextPath()%>/pei_pages/vendor_orderTracking_addInfo.jsp"><img
										src="<%=request.getContextPath()%>/assets/img/category/3.png"
										alt="img"> 訂單追蹤 <span>(18)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/meal/meal.do?action=getAll"><img
										src="<%=request.getContextPath()%>/assets/img/category/4.png"
										alt="img"> 歷史明細 <span>(14)</span></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/category/5.png"
										alt="img"> Fast food <span>(10)</span></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/assets/img/category/6.png"
										alt="img"> Soft drinks <span>(28)</span></a></li>
							</ul>
						</div>
					</div>

				</div>
				<div class="col-md-9">
					<div class="bill-payment-wrap">
						<h5>餐點上架</h5>


						<!--         新增一筆Meal資料                   -->
						<!-- form 開始 -->
						<form class="default-form-wrap style-2" method="post"
							action="/TFA103G2/meal/meal.do" enctype="multipart/form-data">

							<%
								MealVO mealVO = (MealVO) request.getAttribute("UpdatingMealVO");
							%>

							<%-- 錯誤表列 --%>
							<c:if test="${not empty errMsgs}">
								<font style="color: red">請修正以下錯誤:</font>
								<ul>
									<c:forEach var="message" items="${errMsgs}">
										<li style="color: red">${message}</li>
									</c:forEach>
								</ul>
							</c:if>


							<div class="row">
								<div class="row">
									<div class="col-md-8">
										<label>餐點名稱</label>
										<div class="single-input-wrap">

											<input type="text" class="form-control" name="mealName"
												value="<%=(mealVO == null) ? "飛騨高山拉麵" : mealVO.getMealName()%>">
										</div>
									</div>

									<div class="col-md-4">
										<label>餐點類型</label>
										<div class="single-input-wrap">
											<select class="myclass-select myclass-select-lauchdays"
												id="inputGroupSelect01" name="mealType">
												<option
													value="<%=(mealVO == null) ? "日式" : mealVO.getMealType()%>"
													selected>日式</option>
												<option value="火鍋">火鍋</option>
												<option value="中式">中式</option>
												<option value="地中海">地中海</option>
											</select>
										</div>

									</div>

								</div>


								<div class="row">

									<div class="col-md-5">

										<!-- 隱藏的餐點狀態 START-->

										<input type="hidden" class="form-control" name="sta"
											value="<%=(mealVO == null) ? "1" : mealVO.getSta()%>">

										<!-- 隱藏的餐點狀態 END -->

										<!-- 隱藏的餐廳編號 START -->
										<input type="hidden" class="form-control" name="restaurantId"
											value="<%=(mealVO == null) ? "7002" : mealVO.getRestaurantId()%>">
										<!-- 隱藏的餐廳編號 END -->


										<div class="row">
											<div class="col-md-6">
												<label>單價</label>
												<div class="single-input-wrap">
													<input type="text" class="form-control" name="unitPrice"
														value="<%=(mealVO == null) ? "369" : mealVO.getUnitPrice()%>">
												</div>
											</div>
										</div>

										<div class="col-md-12">
											<label>上架日期</label>

											<div class="row">
												<div class="col-sm-10s single-input-wrap">
													<input type="text" id="f_date1" class="form-control"
														name="launchDate">
												</div>

											</div>

										</div>


										<div class="row">
											<div class="col-md-6">
												<label>上架天數</label>
												<div class="single-input-wrap">
													<select class="myclass-select myclass-select-lauchdays"
														id="inputGroupSelect01" name="launchDays">
														<option
															value="<%=(mealVO == null) ? "30" : mealVO.getLaunchDays()%>"
															selected>30</option>
														<option value="45">45</option>
														<option value="60">60</option>
														<option value="90">90</option>
													</select>
												</div>
											</div>
										</div>







									</div>

									<!-- 圖片預覽區 -->
									<div class="col-md-7 my-preview-img-container">
										<div class="my-img-zone" id="preview">
											<span>圖片預覽區</span>
										</div>
									</div>


								</div>





								<div>
									<label>圖片上傳</label>
									<div>
									<button type="button" class="btn btn-warning my-btn" id="my-img-btn">選擇圖片</button>
										<input type="file" id="p_file" class="form-control"
											name="myUploadImg" hidden
											value="<%=(mealVO == null) ? null : mealVO.getMealImg()%>">
									</div>
								</div>


								<div class="col-md-12">
									<label>商品介紹</label>
									<div class="col-md-12">
										<div class="single-textarea-wrap">
											<textarea maxlength="450" rows="4"
												placeholder="商品介紹...(字數不超過450)" name="mealDescription"><%=(mealVO == null) ? "排隊美食" : mealVO.getMealDescription()%></textarea>
										</div>
									</div>
								</div>
								<div class="col-md-12">

									<div class="row my-btn-wrapper">
										<div class="col-md-2"></div>
										<div class="col-md-4">
											<input type="hidden" name="action" value="insert">
											<button type="submit" class="btn btn-base" id="btn_submit">確認</button>
										</div>
										<div class="col-md-4">
											<button type="reset" class="btn btn-base">重填</button>
										</div>
										<div class="col-md-2"></div>

									</div>
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

	<!-- 永志老師的DateTimePicker -->

	<script
		src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.full.js"></script>


	<%
		java.sql.Timestamp launchDate = null;
		try {
			launchDate = mealVO.getLaunchDate();
		} catch (Exception e) {
			launchDate = new java.sql.Timestamp(System.currentTimeMillis());
		}
	%>


	<script>
		$(document).ready(function() {

			var p_file_el = document.getElementById("p_file");
			var preview_el = document.getElementById("preview");
			
			$.datetimepicker.setLocale('zh');
			$('#f_date1').datetimepicker({
				theme : '', //theme: 'dark',
				timepicker : false, //timepicker:true,
				step : 1, //step: 60 (這是timepicker的預設間隔60分鐘)
				format : 'Y-m-d H:i:s', //format:'Y-m-d H:i:s',
				value : '<%=launchDate%>', // value:   new Date(),
							//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
							//startDate:	            '2017/07/10',  // 起始日
							//minDate:               '-1970-01-01', // 去除今日(不含)之前
							//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
				});

							/*                透過 File 取得預覽圖                 */
							p_file_el.addEventListener("change",function(e) {
												let file = this.files[0];
												console.log(this);
												console.log(file);
												
												let reader = new FileReader();
												reader.readAsDataURL(file);
												reader.addEventListener("load",function(e) {
													let img_tag = "<img src=" + reader.result +  " \" class=\"preview_img\" >";
													preview_el.innerHTML = img_tag;
												});
											});
							
							
							
			$('#my-img-btn').on("click", function(e) {
				$('#p_file').click();
			
			});

						});
	</script>
</body>
</html>