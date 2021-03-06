<%@page import="com.monsterbook.model.MonsterBook"%>
<%@page import="com.meal.model.MealVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>AddFakeInfoPage</title>
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


<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}

section.breadcrumb-area {
	height: 80px;
}

section.work-area {
	margin-top: 50px;
}

div.card .card-body {
	display: none;
}

div.card div.active {
	display: block;
}

form .my-btn {
	padding: 0px 10px;
	width: 56px;
	height: 36px;
	line-height: 10px;
	border-radius: 10px;
}

form.my-form input.form-control {
	width: 250px;
}

form select.my-select {
	width: 250px;
}

div.card-body ul.my-form-wrapper li {
	list-style: none;
	text-align: left;
}

div.card-body ul.my-form-wrapper li a {
	padding: 3px 10px;
	width: 100px;
	height: 36px;
	line-height: normal;
	border-radius: 10px;
}
</style>

</head>
<body class='sc5'>


	<!-- navbar start -->
	<header class="navbar-area">
		<nav class="navbar navbar-expand-lg">
			<div class="container nav-container">
				<div class="logo">
					<a class="main-logo" href="/TFA103G2/pei_pages/select-page.jsp"><img
						src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>
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
				<!-- add content here  -->

				<div class="card text-center">
					<div class="card-header">
						<ul class="nav nav-tabs card-header-tabs">
							<!-- using active | disabled  -->
							<li class="nav-item"><a class="nav-link model1 active"
								aria-current="true" href="#">Meal</a></li>
						</ul>
					</div>
					<div class="card-body model1-body active">
						<h5 class="card-title">????????????</h5>

						<div style="overflow: hidden;">
							<h4 class="my-query-title" style="float: left;">????????????</h4>

						</div>

						<br>




						<%-- <jsp:useBean id="monsterBookService" scope="page" --%>
						<%-- 								class="com.monsterbook.model.MonsterBookService" /> --%>

						<%
							MonsterBook updatingmonsterVO = (MonsterBook) request.getAttribute("updatingmonsterVO");
						%>

						<!--         ????????????Meal??????                   -->
						<form class="row row-cols-xxl-auto align-items-center my-form"
							method="post" action="/TFA103G2/monsterbook/MonsterServlet.do"
							enctype="multipart/form-data">


							<div class="row">
								<label class="col-sm-3 col-form-label">????????????</label>
								<div class="col-sm-3">
									<span><%=updatingmonsterVO.getMonsterId()%></span>
									<input type="hidden" class="form-control" name="monsterId"
										value="<%=updatingmonsterVO.getMonsterId()%>">
								</div>
								<div class="col-sm-6"></div>
							</div>

							<div class="row">
								<label class="col-sm-3 col-form-label">???????????? </label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="monsterName"
										value="<%=updatingmonsterVO.getMonsterName()%>">
								</div>
								<div class="col-sm-6"></div>
							</div>





							<div class="row">
								<label class="col-sm-3 col-form-label">minDemandLevel</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="monsterMinDemandLevel" value="<%=updatingmonsterVO.getMinDemandLevel()%>">
								</div>
								<div class="col-sm-6"></div>
							</div>




							<div class="row">
								<label class="col-sm-3 col-form-label">????????????</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="monsterAbility" value="<%=updatingmonsterVO.getMonsterAbility()%>">
								</div>
								<div class="col-sm-6"></div>
							</div>

							<div class="row">
								<label class="col-sm-3 col-form-label">????????????</label>
								<div class="col-sm-3">
									<input type="file" class="form-control" name="myUploadImg">
								</div>
								<div class="col-sm-6"></div>
							</div>

							
							<%--         ???????????????                --%>

							<div class="row">
								<div class="col-sm-3">
									<input type="hidden" name="action" value="updateOneMonster">
									<input type="submit" class="btn btn-primary" value="??????">
								</div>
								<div class="col-sm-3"></div>
								<div class="col-sm-6"></div>
							</div>


						</form>

					</div>

					<!-- 					<div class="card-body model2-body"> -->
					<!-- 						<h5 class="card-title">Model2</h5> -->
					<!-- 					</div> -->

					<!-- 					<div class="card-body model3-body"> -->
					<!-- 						<h5 class="card-title">Model3</h5> -->
					<!-- 					</div> -->
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









</body>
</html>
