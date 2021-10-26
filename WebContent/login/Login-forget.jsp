<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Login-forget</title>
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
	href="<%=request.getContextPath()%>/assets/css/Login-forget.css">

<!--Google Fonts-->
<link rel="stylesheet"
	href=https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap>

    <style>
        div.overlay{
            /* display:block !important; */
            z-index:100;
        }
    </style>
</head>

<body class='sc5'>
    <!-- preloader area start -->
    <div class="preloader" id="preloader">
        <div class="preloader-inner">
            <div id="wave1">
            </div>
            <div class="spinner">
                <div class="dot1"></div>
                <div class="dot2"></div>
            </div>
        </div>
    </div>
    <!-- preloader area end -->
    
	<!-- navbar start -->
	<header class="navbar-area">
		<nav class="navbar navbar-expand-lg">
			<div class="container nav-container">
				<div class="logo">
					<a class="main-logo"
						href="<%=request.getContextPath()%>/login/Login-login.jsp"> <img
						src="<%=request.getContextPath()%>/assets/img/logo.png"></a>
				</div>
			</div>
		</nav>
	</header>
	<!-- navbar end -->

	<!---------------------------------- new  ---------------------------------->

	<div class="panel-group">
		<input type="radio" name="panel-radio" id="radio1"
			class="panel-control" checked>
		<div class="content-group">
			<div class="back-to-top">
				<span class="back-top"><i class="fas fa-angle-double-up"></i></span>
			</div>
			<div class="overlay" style="border: 1px solid red;">
				<article>
					<h1>驗證信已寄至您的信箱</h1>
					<p></p>
					<button type="button" class="btn_modal_close" 關閉></button>
				</article>
			</div>

			<!---------------------------------- table內帳號輸入 ---------------------------------->
			<form class="content content1" action="javascript:;" method="post">
				<div id="right" class="two-thirds">
					<fieldset>
						<h1 class="lgd" style="color: black;">尋找密碼</h1>
						<p>輸入你電子郵件地址</p>
						<input type="username" id="username" class="username_email"
							name="username" placeholder="您的電子郵件地址" required> <input
							type="button" value="送出" class="btn" id="submit"
							onclick="myFormCheck()" padd />
					</fieldset>
				</div>
			</form>
		</div>
	</div>
	<!--two-thirds-->


	<!----------------------------------  end  ---------------------------------->

	<!-- footer area start -->
	<footer class="footer-area pd-top-25">

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

	<!-- all plugins here -->
	<script src="<%=request.getContextPath()%>/assets/js/jquery.3.6.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/imageloded.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/counterup.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/waypoint.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/magnific.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/isotope.pkgd.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/nice-select.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/fontawesome.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/owl.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/slick-slider.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/tweenmax.min.js"></script>

	<!-- main js  -->
	<script src="<%=request.getContextPath()%>/assets/js/main.js"></script>
	<!-- new js   -->
	<script src="<%=request.getContextPath()%>/assets/js/Login-forget.js"></script>

</body>
</html>