<%@ page import="com.meal.model.MealVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
header.my-navbar-area {

	background: #a30481;
	border-bottom: none;
}

div.my-aside-left-container img{
	width: 42px;
	height: 42px;
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

form div.my-img-btn-wrapper .my-btn {
	padding: 0px 10px;
	width: 100px;
	height: 40px;
	line-height: 10px;
	border-radius: 10px;
	margin-top: 0;
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
					<a class="main-logo" href="<%=request.getContextPath()%>/pei_pages/vendor_restaurant_updateInfo.jsp"><img
						src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>
				</div>
				<div class="collapse navbar-collapse" id="themefie_main_menu">
					<ul class="navbar-nav menu-open" style="visibility: hidden;">
						<li class="current-menu-item menu-item-has-children"><a
							href="home-1.html">??????</a>
							<ul class="sub-menu ps-0">
								<li><a href="<%=request.getContextPath()%>/shop.html">Shop</a></li>
								<li><a href="<%=request.getContextPath()%>/menu.html">Menu</a></li>
								<li><a href="<%=request.getContextPath()%>/cart.html">Cart</a></li>
								<li><a href="<%=request.getContextPath()%>/checkout.html">Checkout</a></li>
							</ul></li>
						<li><a href="blog.html">??????</a></li>
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
						<li class="menu-cart"><a href="#" style="visibility: hidden;">????????? <span>4</span></a></li>
						<li class="menu-cart"><a href="cart.html" style="visibility: hidden;">CART <span>1</span></a></li>
						<li class="phone-contact"><a href="<%=request.getContextPath()%>/login/Login-login.jsp">??????</a></li>
						
						
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
								<li><a href="<%=request.getContextPath()%>/pei_pages/vendor_restaurant_updateInfo.jsp"><img
										src="<%=request.getContextPath()%>/images/m1.svg"
										alt="img"> ???????????? <span>(5)</span></a></li>
								<li><a href="#"><img
										src="<%=request.getContextPath()%>/images/m2.svg"
										alt="img"> ???????????? <span>(9)</span> </a></li>
								<li><a href="<%=request.getContextPath()%>/pei_pages/vendor_orderTracking_addInfo.jsp"><img
										src="<%=request.getContextPath()%>/images/m3.svg"
										alt="img"> ???????????? <span>(18)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/meal/meal.do?action=getAll"><img
										src="<%=request.getContextPath()%>/images/m4.svg"
										alt="img"> ???????????? <span>(14)</span></a></li>
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
						<h5>????????????</h5>


						<!--         ????????????Meal??????                   -->
						<!-- form ?????? -->
						<form class="default-form-wrap style-2" method="post"
							action="/TFA103G2/meal/meal.do" enctype="multipart/form-data">

							<%
								MealVO mealVO = (MealVO) request.getAttribute("UpdatingMealVO");
							
							%>

							


							<div class="row">
								<div class="row">
									<div class="col-md-8">
									
										<div class="row error-title">
											<div class="col-md-4">
												<label>????????????</label>
											</div>
											<div class="col-md-8 my-error-mealName">
												<div style="height: 10px;"></div>
												<div data-mealNameError-empty style="display: none;color: red;">*???????????????????????????</div>
												<div data-mealNameError-pass style=""><i class="far fa-check-circle"></i></div>
											</div>
										</div>
										
										<div class="single-input-wrap">

											<input type="text" class="form-control" name="mealName"
												value="<%=(mealVO == null) ? "??????????????????" : mealVO.getMealName()%>" onkeyup="errorHandler(0);">
										</div>
									</div>

									<div class="col-md-4">
										<label>????????????</label>
										<div class="single-input-wrap">
											<select class="myclass-select myclass-select-lauchdays"
												id="inputGroupSelect01" name="mealType">
												<option
													value="<%=(mealVO == null) ? "??????" : mealVO.getMealType()%>"
													selected>??????</option>
												<option value="??????">??????</option>
												<option value="??????">??????</option>
												<option value="?????????">?????????</option>
											</select>
										</div>

									</div>

								</div>


								<div class="row">

									<div class="col-md-5">

										<!-- ????????????????????? START-->
										<!-- 1:?????? ??????????????????2:??????   -->
										<input type="hidden" class="form-control" name="sta"
											value="<%=(mealVO == null) ? "1" : mealVO.getSta()%>">

										<!-- ????????????????????? END -->

										<!-- ????????????????????? START -->
										<input type="hidden" class="form-control" name="restaurantId"
											value="<%= session.getAttribute("restaurantId") %>">
										<!-- ????????????????????? END -->


										<div class="row">
											<div class="col-md-6">
												<label>??????</label>
												<div class="single-input-wrap">
													<input type="text" class="form-control" name="unitPrice"
														value="<%=(mealVO == null) ? "369" : mealVO.getUnitPrice()%>" onkeyup="errorHandler(1);">
												</div>
											</div>
											<div class="col-md-5 my-error-unitPrice">
												<a href="#" tabindex="-1"
												class="btn btn-primary disabled placeholder col-4"
												aria-hidden="true" style="visibility: hidden; height: 55px;margin-top:12px;"></a>
												<div data-unitPriceError-empty style="display: none;color: red;">*?????????????????????</div>
												<div data-unitPriceError-special style="display: none;color: red;">*??????: ??????0~9???????????????????????????1???6??????</div>
												<div data-unitPriceError-pass style=""><i class="far fa-check-circle"></i></div>
											</div>
										</div>

										<div class="col-md-12">
											<label>????????????</label>

											<div class="row">
												<div class="col-sm-10s single-input-wrap">
													<input type="text" id="f_date1" class="form-control"
														name="launchDate">
												</div>

											</div>

										</div>


										<div class="row">
											<div class="col-md-6">
												<label>????????????</label>
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

									<!-- ??????????????? -->
									<div class="col-md-7 my-preview-img-container">
										<div class="my-img-zone" id="preview">
											<span>???????????????</span>
										</div>
									</div>


								</div>





								<div class="my-img-btn-wrapper">

									<label>????????????</label>
									<div>
									<button type="button" class="btn btn-warning my-btn" id="my-img-btn">????????????</button>
										<input type="file" id="p_file" class="form-control"
											name="myUploadImg" hidden value="<%=(mealVO == null) ? null : mealVO.getMealImg()%>">
									</div>
								</div>


								<div class="col-md-12">
									<label>????????????</label>
									<div class="col-md-12">
										<div class="single-textarea-wrap">
											<textarea maxlength="450" rows="4"
												placeholder="????????????...(???????????????450)" name="mealDescription"><%=(mealVO == null) ? "????????????" : mealVO.getMealDescription()%></textarea>
										</div>
									</div>
								</div>
								<div class="col-md-12">

									<div class="row my-btn-wrapper">
										<div class="col-md-4"></div>
										<div class="col-md-4">
											<input type="hidden" name="action" value="insert">
											<button type="submit" class="btn btn-base" id="btn_submit">??????</button>
										</div>
										
										

									</div>
								</div>


							</div>
						</form>

						<!-- form ?????? -->
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

	<!-- ???????????????DateTimePicker -->

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
				step : 1, //step: 60 (??????timepicker???????????????60??????)
				format : 'Y-m-d H:i:s', //format:'Y-m-d H:i:s',
				value : '<%=launchDate%>', // value:   new Date(),
							//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // ??????????????????
							//startDate:	            '2017/07/10',  // ?????????
							//minDate:               '-1970-01-01', // ????????????(??????)??????
							//maxDate:               '+1970-01-01'  // ????????????(??????)??????
				});

							/*                ?????? File ???????????????                 */
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
		
		
		/*********************************************   ????????????       **********************************************************/
		function errorHandler(item) {
						//console.log(item);
						let items = ["mealName","unitPrice"];
						
							$.ajax({
								  url: "<%=request.getContextPath()%>/meal/meal.do?action=mealErrorVerify&param="+ item,  
								  type: "POST",                  // GET | POST | PUT | DELETE | PATCH
								  data: {"item" : $('input[name=' + items[item] + ']').val()
								  },         // ???????????????????????? url
								  dataType: "json",             // ?????????????????????????????????????????? json | xml | html
								  success: function(data){      // request ???????????????????????????
									if(item === 0) {
										
										 $('div.my-error-mealName div[data-mealNameError-empty]').hide();
										  $('div.my-error-mealName div[data-mealNameError-pass]').hide();
										  
										  if(isExistError(data.noEmpty)) {
											  $('div.my-error-mealName div[data-mealNameError-empty]').show();
										  }
										 else {
											  $('div.my-error-mealName div[data-mealNameError-pass]').show();
										  }
									}
								  
									if(item === 1) {
										
										$('div.my-error-unitPrice div[data-unitPriceError-empty]').hide();
										  $('div.my-error-unitPrice div[data-unitPriceError-special]').hide();
										  $('div.my-error-unitPrice div[data-unitPriceError-pass]').hide();
										  
										  if(isExistError(data.noEmpty)) {
											  $('div.my-error-unitPrice div[data-unitPriceError-empty]').show();
										  }
										  else if(isExistError(data.errorFormatName)) {
											  $('div.my-error-unitPrice div[data-unitPriceError-special]').show();
											  
										  } else {
											  $('div.my-error-unitPrice div[data-unitPriceError-pass]').show();
										  }
										  
										  
									}
									
									
								  }
								  
								  
								  
							});
						
						
						
					}
		
		$('button#btn_submit').on("click", function(e) {
			
			// ??????????????????????????????
			if($('div[data-mealNameError-pass ]').attr('style') === "display: none;") {
				$('input[name="mealName"]').focus();
				//??????return false?????????????????????
				return false;
			} else if($('div[data-unitPriceError-pass]').attr('style') === "display: none;") {
				$('input[name="unitPrice"]').focus();
				return false;
			}
			
			
			// ????????????????????????submit
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