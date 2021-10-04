<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>AddMealPage</title>
<!--fivicon icon-->
<link rel="icon" href="../assets/img/fevicon.png">

<!-- Stylesheet -->
<link rel="stylesheet" href="../assets/css/animate.min.css">

<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/css/magnific.min.css">
<link rel="stylesheet" href="../assets/css/jquery-ui.min.css">
<link rel="stylesheet" href="../assets/css/nice-select.min.css">
<link rel="stylesheet" href="../assets/css/owl.min.css">
<link rel="stylesheet" href="../assets/css/slick-slide.min.css">
<link rel="stylesheet" href="../assets/css/fontawesome.min.css">
<link rel="stylesheet" href="../assets/css/remixicon/remixicon.css">
<link rel="stylesheet" href="../assets/css/style.css">
<link rel="stylesheet" href="../assets/css/responsive.css">


<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="../vendors/DataTables/datatables.css">
<style>
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
					<a class="main-logo" href="home-1.html"><img
						src="../assets/img/logo.png" alt="img"></a>
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
						<h5 class="card-title">新增一筆餐點</h5>

						<div style="overflow: hidden;">
							<h4 class="my-query-title" style="float: left;">新增餐點</h4>

						</div>

						<br>

						<!--         新增一筆Meal資料                   -->
						<form class="row row-cols-xxl-auto align-items-center"
							method="post" action="#">

							<div class="row">
								<label for="inputPassword" class="col-sm-3 col-form-label">餐點名稱
								</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="mealId">
								</div>
								<div class="col-sm-7"></div>
							</div>

							<div class="row">
								<label for="inputPassword" class="col-sm-3 col-form-label">餐點狀態
								</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="mealId">
								</div>
								<div class="col-sm-7"></div>
							</div>

							<div class="row">
								<label class="col-sm-3 col-form-label">餐點類型</label>
								<div class="col-sm-2">
									<select class="form-select" aria-label="Default select example">
										<option selected>日式</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
								<div class="col-sm-7"></div>
							</div>

							<div class="row">
								<label for="inputPassword" class="col-sm-3 col-form-label">單價</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="mealId">
								</div>
								<div class="col-sm-7"></div>
							</div>

							<div class="row">
								<label for="inputPassword" class="col-sm-3 col-form-label">上市日期</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="mealId">
								</div>
								<div class="col-sm-7"></div>
							</div>

							<div class="row">
								<label for="inputPassword" class="col-sm-3 col-form-label">上市天數</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="mealId">
								</div>
								<div class="col-sm-7"></div>
							</div>

							<div class="row">
								<label for="inputPassword" class="col-sm-3 col-form-label">餐點描述</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="mealId">
								</div>
								<div class="col-sm-7"></div>
							</div>

							<div class="row">
								<label for="inputPassword" class="col-sm-3 col-form-label">餐點照片</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="mealId">
								</div>
								<div class="col-sm-7"></div>
							</div>

							<div class="row">
								<label for="inputPassword" class="col-sm-3 col-form-label">餐廳</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="mealId">
								</div>
								<div class="col-sm-7"></div>
							</div>
							<%--         送出的按鈕                --%>

							<div class="row">
								<div class="col-sm-3">
									<input type="hidden" name="action" value="insert">
									<input type="submit" class="btn btn-primary" value="送出">
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
	<script src="../assets/js/jquery.3.6.min.js"></script>
	<script src="../assets/js/bootstrap.min.js"></script>
	<script src="../assets/js/imageloded.min.js"></script>
	<script src="../assets/js/counterup.js"></script>
	<script src="../assets/js/waypoint.js"></script>
	<script src="../assets/js/magnific.min.js"></script>
	<script src="../assets/js/isotope.pkgd.min.js"></script>
	<script src="../assets/js/jquery-ui.min.js"></script>
	<script src="../assets/js/nice-select.min.js"></script>
	<script src="../assets/js/fontawesome.min.js"></script>
	<script src="../assets/js/owl.min.js"></script>
	<script src="../assets/js/slick-slider.min.js"></script>
	<script src="../assets/js/wow.min.js"></script>
	<script src="../assets/js/tweenmax.min.js"></script>
	<!-- main js  -->
	<script src="../assets/js/main.js"></script>
	<!-- new js   -->
	<script src="../assets/js/main.js"></script>

	<script type="text/javascript" charset="utf8"
		src="../vendors/DataTables/datatables.js"></script>

	<script>
		$(document).ready(function() {

			/*********************  啟動DataTable  **********************************/
			$('#table_id').DataTable();

			/********************  切換tab分頁  ********************************/
			$("div.card .card-header .nav-link").on("click", function(e) {

				/***************** 切換tab按鈕 ***************************/
				if ($("div.card .card-header .nav-link").hasClass("active"))
					$("div.card .card-header .nav-link").removeClass("active");
				$(this).addClass("active");

				/***************** 切換tab頁面內容****************************/

				if ($("div.card div.card-body").hasClass("active"))
					$("div.card div.card-body").removeClass("active");

				let indexOfModelClass = 1;
				/* 切換到 model1*/
				if ("model1" === e.currentTarget.classList[indexOfModelClass])
					$("div.card div.model1-body").addClass("active");
				/* 切換到 model2*/
				if ("model2" === e.currentTarget.classList[indexOfModelClass])
					$("div.card div.model2-body").addClass("active");
				/* 切換到 model3*/
				if ("model3" === e.currentTarget.classList[indexOfModelClass])
					$("div.card div.model3-body").addClass("active");
			});

		});
	</script>
</body>
</html>