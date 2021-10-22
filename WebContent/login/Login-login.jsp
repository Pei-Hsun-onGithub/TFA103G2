<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.memberinfo.model.*"%>

<%
	MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberInfo");
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="UTF-8">
<title>Login-long</title>
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
<!-- new css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/Login-login.css">

<!--Google Fonts-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap">

</head>

<body class='sc5'>

	<!-- navbar start -->
	<header class="navbar-area">
		<nav class="navbar navbar-expand-lg">
			<div class="container nav-container">
				<div class="logo">
					<a class="main-logo"
						href="<%=request.getContextPath()%>/login/Login-login.jsp"> <img
						src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>
				</div>
			</div>
		</nav>
	</header>
	<!-- navbar end -->

	<!-- bredcrumb Area Start-->
	<section class="breadcrumb-area test">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6 align-self-center">
					<div class="banner-inner text-center">

						<!---------------------------------- new  ---------------------------------->

						<div class="panel-group">
							<input type="radio" name="panel-radio" id="radio1" class="panel-control" checked> 
							<input type="radio" name="panel-radio" id="radio2" class="panel-control">
							<div class="tab-group">
								<label for="radio1" class="active">會員</label>
								<label for="radio2">廠商</label>
							</div>
							<div class="content-group">

								<!---------------------------------- table內帳號輸入 ---------------------------------->
								<form class="content content1" action="<%=request.getContextPath()%>/loginhandler" method="post">
									<div id="right" class="two-thirds">
										<fieldset>
											<h1 class="lgd" style="color: black">登入帳號</h1>
											<p>直接輸入您的會員帳號密碼登入</p>
											<input type="username" id="username" class="username_email"name="email" placeholder="您的電子郵件地址" required> 
											<input type="password" id="password" class="password1" name="pwd" placeholder="您的密碼" required> 
											<input
												type="submit" value="登入" class="btn" id="submit1"
												onclick="myFormCheck()" />
											<div id="rmbr">
												<input type="checkbox" id="remberme" name="remberme">
												<label for="remberme" id="remberme0">記住我</label>
											</div>
											<div id="sign">
												<a
													href="<%=request.getContextPath()%>/login/Login-forget.jsp" id="member_btn">忘記密碼?</a> <a
													href="<%=request.getContextPath()%>/login/Login-custome-regist.jsp">註冊</a>
											</div>
										</fieldset>
									</div>
									<!--two-thirds-->
								</form>
								<!---------------------------------- table內帳號輸入2 ---------------------------------->
								<form class="content content2" action="<%=request.getContextPath()%>/loginhandler" method="post">
									<div id="right" class="two-thirds">
										<fieldset>
											<h1 class="lgd" style="color: black">登入帳號</h1>
											<p>直接輸入您的廠商帳號密碼登入</p>
											<input type="username" id="username" class="username_email"name="email" placeholder="您的電子郵件地址" required>
											<input type="password" id="password" class="password1" name="pwd" placeholder="您的密碼" required>
											<input type="submit" value="登入" class="btn" id="submit1" onclick="myFormCheck()" />
											<div id="rmbr">
												<input type="checkbox" id="remberme" name="remberme"> 
												<label for="remberme" id="remberme0">記住我</label>
											</div>
											<div id="sign">
												<a href="<%=request.getContextPath()%>/login/Login-forget.jsp" id="member_btn">忘記密碼?</a>
												<a href="<%=request.getContextPath()%>/login/Login-vendor-regist.jsp" id="register">註冊</a>
											</div>
										</fieldset>
									</div>
									<!--two-thirds-->
								</form>
							</div>
						</div>
						<!----------------------------------  end  ---------------------------------->
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- all plugins here -->
	<script src="<%=request.getContextPath()%>/assets/js/jquery.3.6.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/imageloded.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/counterup.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/waypoint.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/magnific.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/isotope.pkgd.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/nice-select.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/fontawesome.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/owl.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/slick-slider.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/tweenmax.min.js"></script>
	<!-- main js  -->
	<script src="<%=request.getContextPath()%>/assets/js/main.js"></script>
	<!-- new js   -->
<%-- 	<script src="<%=request.getContextPath()%>/assets/js/Login-login.js"></script> --%>
</body>

</html>