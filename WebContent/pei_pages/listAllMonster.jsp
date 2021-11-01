<%@page import="com.monsterbook.model.MonsterBook"%>
<%@page import="com.monsterbook.model.MonsterBookService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.meal.model.*"%>






<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>ListAll</title>
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

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/vendors/DataTables/datatables.css">
<style>

header.my-navbar-area {

	background: #a30481;
	border-bottom: none;
}

section.breadcrumb-area {
	height: 80px;
}

section.work-area {
	margin-top: 50px;
}

input.my-btn {
	padding: 0px 10px;
	width: 53px;
	height: 30px;
	line-height: 10px;
	border-radius: 10px;
}

table tr td img {
	width: 60px;
	height: 50px;
}
</style>

</head>
<body class='sc5'>


	<!-- navbar start -->
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
						<li style="visibility: hidden;"><a class="search" href="#"><i class="ri-search-line"></i></a>
						</li>
						<li class="menu-cart"><a href="#" style="visibility: hidden;">小鈴鐺 <span>4</span></a></li>
						<li class="menu-cart"><a href="cart.html" style="visibility: hidden;">CART <span>1</span></a></li>
						
						
						
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- navbar end -->

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
				<table id="table_id" class="display">
					<thead>
						<tr>
							<th>怪獸編號</th>
							<th>minDemandLevel</th>
							<th>怪獸名稱</th>
							<th>怪獸能力</th>
							<th>怪獸圖片</th>
							<th></th>
							
						</tr>
					</thead>
					<tbody>

							
							<% 
							
							MonsterBookService monsterSvc = new MonsterBookService();
							List<MonsterBook> list = monsterSvc.getAll();
							request.setAttribute("list", list);
							%>

						<c:forEach var="monsterVO" items="${list}">

							<tr>
								<td>${monsterVO.monsterId}</td>
								<td>${monsterVO.minDemandLevel}</td>
								<td>${monsterVO.monsterName}</td>
								<td>${monsterVO.monsterAbility}</td>
								<td><img
									src="/TFA103G2/PhotoResolver?id=${monsterVO.monsterId}" /></td>
								
								<td>
									<FORM METHOD="post"
										ACTION="/TFA103G2/monsterbook/MonsterServlet.do?action=getOneMonsterForUpdate"
										style="margin-bottom: 0px;">
										<input type="submit" class="btn btn-warning my-btn" value="更新">
										<input type="hidden" name="monsterId" value="${monsterVO.monsterId}">
									</FORM>
								</td>
								

							</tr>
						</c:forEach>
					</tbody>
				</table>
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