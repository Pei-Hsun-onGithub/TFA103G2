<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>ListAll</title>
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

<link rel="stylesheet" type="text/css" href="../vendors/DataTables/datatables.css">
<style>
section.breadcrumb-area {
	height: 80px;
}

section.work-area{
	margin-top: 50px;
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

				<table id="table_id" class="display">
					<thead>
						<tr>
							<th>Column 1</th>
							<th>Column 2</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Row 1 Data 1</td>
							<td>Row 1 Data 2</td>
						</tr>
						<tr>
							<td>Row 2 Data 1</td>
							<td>Row 2 Data 2</td>
						</tr>
					</tbody>
				</table>
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
	
	$(document).ready( function () {
	    $('#table_id').DataTable();
	} );
	
	</script>
</body>
</html>