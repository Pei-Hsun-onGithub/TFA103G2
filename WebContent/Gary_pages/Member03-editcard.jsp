<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.card.model.*"%>
<%@ page import="com.memberinfo.model.*"%>

<%
	CardVO cardVO = (CardVO) request.getAttribute("cardvo");
%>

<%
	MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberinfo");
%>


<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>會員中心-新增信用卡</title>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/Member03-addcard.css">

<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">


</head>

<
<body style="background-color: #dbdbdb";>
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
					<a class="main-logo" href="home-1.html"><img
						src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>
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
	<!-- navbar end -->

	<div class="total">
		<div class="profile">
			<img
				src="/TFA103G2/memberinfo/MemberPic.do?userId=<%=memberinfo.getUserId()%>"
				alt="img">
			<ul>
				<li class="nickname"><%=memberinfo.getUserName()%></li>
				<li class="edit"><a
					href="/TFA103G2/login/memberinfo.do?action=getOne">編輯個人資料</a></li>
			</ul>
		</div>

		<div class="memberlist">
			<ul>
				<li class="one"><a
					href="/TFA103G2/login/memberinfo.do?action=getOne">個人檔案</a></li>
				<li class="two"><a
					href="/TFA103G2/login/memberinfo.do?action=getOnePwd">密碼修改</a></li>
				<li class="three"><a
					href="/TFA103G2/memberinfo/CardServlet.do?action=getAllCard">銀行/信用卡資訊</a></li>
				<li class="four"><a
					href="<%=request.getContextPath()%>/Member04.html">外送地址管理</a></li>
				<li class="five"><a
					href="<%=request.getContextPath()%>/Member05.html">歷史訂單</a></li>
				<li class="six"><a
					href="<%=request.getContextPath()%>/Member06.html">文章管理</a></li>
				<li class="seven"><a href="#">我的收藏</a></li>
			</ul>
		</div>


		<form method="post" action="/TFA103G2/memberinfo/CardServlet.do"
			enctype="multipart/form-data">
			<div class="content">
				<div class="title">
					<div class="titlebigname">修改信用卡UpdateCard</div>
					<div class="titlesmallname">修改信用卡資訊</div>
					<div class="editarea">


						<div class="information">
							<div class="holder">
								<div class="lebel1">持卡人姓名</div>
								<div class="input1">
									<input type="hidden" maxlength="255" name="userId" value="<%=memberinfo.getUserId()%>">
									<input type="text" name="cardholder" maxlength="255" value="<%=cardVO.getCardHolder()%>">
								</div>
							</div>
							<div class="number">
								<div class="lebel2">信用卡卡號</div>
								<div class="input1">
									<input type="text" name="cardnumber" style="width: 300px"
										maxlength="20" oninput="value=value.replace(/[^\d]/g,'')"
										value="<%=cardVO.getCardNumber()%>">
								</div>

							</div>
							<div class="expirydate">
								<div class="lebel3">到期日</div>
								<div class="input3">
									<input type="date" id="date" name="deadline"
										style="width: 141px" min="2021-01" max="2030-12" value="<%=cardVO.getDeadLine()%>">
								</div>
								<div class="CVV">
									<div class="lebel4">CVV</div>
									<div class="input4">
										<input type="text" style="width: 95px; height: 30px"
											name="cvv" maxlength="3"
											oninput="value=value.replace(/[^\d]/g,'')" value="<%=cardVO.getCvv()%>">
									</div>
								</div>
							</div>

							<div class="billaddress">
								<div class="lebel5">帳單地址</div>
								<div class="input5">
									<input type="text" name="billaddress" maxlength="255" value="<%=cardVO.getBillAddress()%>">
								</div>
							</div>
							<div class="zipcode">
								<div class="lebel6">郵遞區號</div>
								<div class="input6">
									<input type="text" name="zipcode" maxlength="6"
										oninput="value=value.replace(/[^\d]/g,'')" value="<%=cardVO.getZipCode()%>"> <input
										type="hidden" maxlength="255" name="sta" value="">
								</div>
							</div>
							<div class="storebutton">
								<input type="hidden" name="action" value="insertOneCard">
								<button type="submit" name="submit">確定</button>
							</div>
							<div class="backbutton">
							<button type="reset" name="button">重填</button>
								
							</div>
						</div>
					</div>
				</div>
					<c:if test="${not empty errorMsgs}">
				<div style="margin-top:300px; margin-left: 750px">
					<font style="color: red">請修正以下錯誤:</font>
					<ul>
						<c:forEach var="message" items="${errorMsgs}">
							<li style="color: red">${message}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			</div>
		
		</form>
	</div>
</body>







<!-- footer area start -->
<!-- <footer class="footer-area pd-top-100">
      <div class="footer-inner padding-top-100 padding-bottom-65">
          <div class="container">
              <div class="row">
                  <div class="col-lg-3 col-sm-6">
                      <div class="footer-widget widget">
                          <div class="logo">
                              <img src="assets/img/logo.png" alt="img">
                          </div>
                          <ul class="contact_info_list">
                              <li class="single-info-item">
                                  <img src="assets/img/icon/location.png" alt="icon">
                                  <div class="details">
                                      4920 Trails End Road Ft  United States, FL 33311
                                  </div>
                              </li>
                              <li class="single-info-item">
                                  <img src="assets/img/icon/envelope.png" alt="icon">
                                  <div class="details">
                                      ordernow@foodka.com
                                  </div>
                              </li>
                              <li class="single-info-item">
                                  <img src="assets/img/icon/phone.png" alt="icon">
                                  <div class="details">
                                      +997 509 153 849
                                  </div>
                              </li>
                          </ul>
                      </div>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <div class="footer-widget widget widget_link">
                          <h4 class="widget-title">Hot Menu</h4>
                          <ul>
                              <li><a href="menu-list.html">Burger King Whopper</a></li>
                              <li><a href="menu-list.html">Five Guys Cheeseburger</a></li>
                              <li><a href="menu-list.html">KFC Original Recipe Chicken</a></li>
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
                              <li>Friday  : 09.00am-10.00pm</li>
                              <li>Saturday & Sunday : <span>Closed</span></li>
                          </ul>
                      </div>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <div class="footer-widget widget widget_instagram_feeds">
                          <h4 class="widget-title">Instagram Feeds</h4>
                          <ul>
                              <li><a href="#"><img src="assets/img/instagram/1.png" alt="instagram" /></a></li>
                              <li><a href="#"><img src="assets/img/instagram/2.png" alt="instagram" /></a></li>
                              <li><a href="#"><img src="assets/img/instagram/3.png" alt="instagram" /></a></li>
                              <li><a href="#"><img src="assets/img/instagram/4.png" alt="instagram" /></a></li>
                              <li><a href="#"><img src="assets/img/instagram/5.png" alt="instagram" /></a></li>
                              <li><a href="#"><img src="assets/img/instagram/6.png" alt="instagram" /></a></li>
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
  </footer> -->
<!-- footer area end -->



</html>
