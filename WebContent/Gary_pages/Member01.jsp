<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.memberinfo.model.*"%>

<%
	MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberinfo");
%>


<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>會員中心-個人檔案</title>
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
	href="<%=request.getContextPath()%>/assets/css/Member01.css">

<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">
<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp" %>

</head>
<body style="background-color: #dbdbdb">
	<%@ include file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp" %>



	<div class="total" style="width:1000px;height:700px;">
		<div class="profile">
			<img
				src="/TFA103G2/memberinfo/MemberPic.do?userId=<%=memberinfo.getUserId()%>"
				alt="img">
			<ul>
				<li class="nickname"><%=memberinfo.getUserName()%></li>
				<li class="edit"><a href="/TFA103G2/login/memberinfo.do?action=getOne">編輯個人資料</a></li>
			</ul>
		</div>

		<div class="memberlist">
    				<ul>
				<li class="one"><a
					href="<%=request.getContextPath()%>/login/memberinfo.do?action=getOne">個人檔案</a></li>
				<li class="two"><a
					href="<%=request.getContextPath()%>/login/memberinfo.do?action=getOnePwd">密碼修改</a></li>
				<li class="three"><a
					href="<%=request.getContextPath()%>/memberinfo/CardServlet.do?action=getAllCard">銀行/信用卡資訊</a></li>
				<li class="four"><a
					href="<%=request.getContextPath()%>/address/address.do?action=getAllAddress">外送地址管理</a></li>
				<li class="five"><a
					href="<%=request.getContextPath()%>/memberinfo/HistoryOrderServlet.do?action=getAllOrderList">歷史訂單</a></li>
				<li class="six"><a
					href="<%=request.getContextPath()%>/article/allFA_member.jsp">文章管理</a></li>
				<li class="seven"><a href="#">我的收藏</a></li>
			</ul>
		</div>
		
		<form method="post" action="/TFA103G2/login/memberinfo.do"
			enctype="multipart/form-data">
			<div class="content">
				<div class="title">
					<div class="titlebigname">個人檔案Profile</div>
					<div class="titlesmallname">管理你的個人資料</div>
					<div class="editarea">



						<div class="information">
							<div class="account">
								<div></div>
								<div class="lebel1">電子郵件帳號</div>
								<div class="input1"><%=memberinfo.getEmail()%>
									<input type="hidden" name="email"
										value="<%=memberinfo.getEmail()%>">
								</div>
							</div>
							<div class="name">
								<div class="lebel2">姓名</div>
								<div class="input2">
									<input type="text"  maxlength="255" name="userName"
										value="<%=memberinfo.getUserName()%>"> <input
										type="hidden" name="userId"
										value="<%=memberinfo.getUserId()%>"> <input
										type="hidden" name="pwd" value="<%=memberinfo.getPwd()%>">
									<input type="hidden" name="registerDate"
										value="<%=memberinfo.getRegisterDate()%>"> <input
										type="hidden" name="gold" value="<%=memberinfo.getGold()%>">
									<input type="hidden" name="feed"
										value="<%=memberinfo.getFeed()%>"> <input
										type="hidden" name="monsterId"
										value="<%=memberinfo.getMonsterId()%>"> <input
										type="hidden" name="monsterNickName"
										value="<%=memberinfo.getMonsterNickName()%>"> <input
										type="hidden" name="lv" value="<%=memberinfo.getLv()%>">
									<input type="hidden" name="exp"
										value="<%=memberinfo.getExp()%>"> <input type="hidden"
										name="sta" value="<%=memberinfo.getSta()%>">
								</div>
							</div>
							<div class="phone">
								<div class="lebel3">電話號碼</div>
								<div class="input3">
									<input type="text" maxlength="255" name="phone"
										value="<%=memberinfo.getPhone()%>">
								</div>
							</div>
							<div class="gender">
								<div class="lebel4">性別</div>
								<div class="input4">
									<input type="radio" name="gender" value="male"
										<%="male".equals(memberinfo.getGender()) ? "checked" : ""%>>男性
									<input type="radio" name="gender" value="female"
										<%="female".equals(memberinfo.getGender()) ? "checked" : ""%>>女性
									<input type="radio" name="gender" value="other"
										<%="other".equals(memberinfo.getGender()) ? "checked" : ""%>>其他
									<p>
								</div>
							</div>
							<div class="birthday">
								<div class="lebel5">生日</div>
								<div class="input5">
									<input id="date" type="date" name="birthday"
										value="<%=memberinfo.getBirthday()%>">
								</div>
							</div>
							<div class="storebutton">
								<input type="hidden" name="action" value="update">
								<button type="submit" name="button">儲存</button>
							</div>
						</div>
						<div class="editpic">
							<div class="pic">
								<img
									src="/TFA103G2/memberinfo/MemberPic.do?userId=<%=memberinfo.getUserId()%>"
									alt="img">
							</div>
							<div class="selectbutton">
								<button id="photo_upload" type="button" name="button">上傳照片</button>
								<input id="img_file" type="file" style="display: none;"
									name="imgfile"
									value="<%=(memberinfo == null) ? null : memberinfo.getPic()%>">
							</div>
							<div class="illustrate">
								檔案大小:最大1MB<br> 檔案限制:.JEPG, .PNG
							</div>
			
							<c:if test="${not empty errorMsgs}">
								<div style="margin-top: 50px; margin-left: 140px">
									<font style="color: red">請修正以下錯誤:</font>
									<ul>
										<c:forEach var="message" items="${errorMsgs}">
											<li style="color: red">${message}</li>
										</c:forEach>
									</ul>
								</div>
							</c:if>
						</div>

					</div>
				</div>
			</div>
		</form>
	</div>

<%@ include file="/assets/webPageSnippet/footerSnippet_home.jsp" %>

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
	<script
		src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.full.js"></script>
	<%@ include file="/assets/webPageSnippet/jsSnippet_navbar_home_3.jsp" %>
	<script>
		$(document)
				.ready(
						function() {

							$('#photo_upload').on("click", function(e) {
								$('#img_file').click();
								return false;
							});

							var pic = document.getElementsByClassName("pic");
							var img_file_element = document
									.getElementById("img_file");
							img_file_element
									.addEventListener(
											"change",
											function(e) {

												let reader = new FileReader();
												reader
														.readAsDataURL(this.files[0]);
												reader
														.addEventListener(
																"load",
																function() {
																	var img_tag = "<img src='" + reader.result + "' class='preview_img'>";
																	console
																			.log(reader.result);
																	//     			pic.insertAdjacentHTML("afterend",img_tag);
																	$('.pic')
																			.html(
																					img_tag);
																	//     			pic.append(img_tag);
																})

											})

						});
	</script>



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


</body>
</html>
