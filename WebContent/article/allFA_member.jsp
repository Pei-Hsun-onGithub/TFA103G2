<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.foodarticle.model.*"%>
<%@ page import="java.util.*"%>

<%
	FoodArticleService faSVC = new FoodArticleService();
	List<FoodArticleVO> faList = faSVC.getall();
	pageContext.setAttribute("faList", faList);
%>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>add new FoodArticle</title>

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
	href="<%=request.getContextPath()%>/assets/css/nice-select.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/jquery-ui.min.css">
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

<!--Date choose-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.css" />



<style>
body {
	margin: 0;
	background-color: #faf7f2;
}

div.main {
	display: flex;
	justify-content: center;
	align-items: center;
}

table {
	display: flex;
	justify-content: center;
	align-items: center;
	border: 2px solid black;
	margin-top:100px;
	width:800px;
}

tr{
width:100%;

}

th.th1 {
	width:60%;

}

th.th2 {
	width:20%;

}

</style>

</head>

<body>

	<header class="navbar-area ">
		<nav class="navbar navbar-expand-lg">

			<!-- 要用boostrap的格線系統要一定要有div class="container nav-container" -->
			<div class="container nav-container">

				<div class="responsive-mobile-menu">
					<button class="menu toggle-btn d-block d-lg-none"
						data-target="#themefie_main_menu" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-left"></span> <span class="icon-right"></span>
					</button>
				</div>
				<div class="logo">
					<a class="main-logo"
						href="<%=request.getContextPath()%>/home-1.html"><img
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
						<li><a href="<%=request.getContextPath()%>/blog.html">食記</a>
						</li>
						<li><a href="<%=request.getContextPath()%>/about.html">ABOUT
								US</a></li>
						<li><a href="<%=request.getContextPath()%>/contact.html">CONTACTS</a>
						</li>
					</ul>
				</div>
				<div class="nav-right-part nav-right-part-mobile">
					<ul>
						<li><a class="search" href="#"><i class="ri-search-line"></i></a>
						</li>
						<li class="phone-contact d-md-block d-none"><i
							class="ri-phone-fill float-start"></i> +997 509 153 849</li>
						<li class="menu-cart"><a
							href="<%=request.getContextPath()%>/cart.html">CART <span>1</span></a></li>
						<li>49.50 $</li>
					</ul>
				</div>
				<div class="nav-right-part nav-right-part-desktop">
					<ul>
						<li><a class="search" href="#"><i class="ri-search-line"></i></a>
						</li>
						<li class="phone-contact"><a href="#">sign in</a></li>
						<li class="menu-cart"><a href="#">小鈴鐺 <span>4</span></a></li>
						<li class="menu-cart"><a
							href="<%=request.getContextPath()%>/cart.html">CART <span>1</span></a></li>
						<li>49.50 $</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<div class="main">

		<!-- 要用boostrap的格線系統要一定要有div class="container nav-container" -->
		<div class="container nav-container">

			<!-- 要給row,告訴html橫列的範圍 -->
			<div class="row justify-content-center">

				<!-- 給格線範圍,再把元素放進格線範圍裡,左+中間+右=12 -->

				<!-- 左邊 -->
				<div class="col-md-2">
					<div class="profile">
						<img src="<%=request.getContextPath()%>/assets/img/girl.png"
							alt="img">
						<ul>
							<li class="nickname">getUserName()</li>
							<li class="edit"><a href="#">編輯個人資料</li>
						</ul>
					</div>

					<div class="memberlist">
						<ul>
							<li class="one"><a
								href="<%=request.getContextPath()%>/Member01.jsp">個人檔案</a></li>
							<li class="two"><a
								href="<%=request.getContextPath()%>/Member02.html">密碼修改</a></li>
							<li class="three"><a
								href="<%=request.getContextPath()%>/Member03.html">銀行/信用卡資訊</a></li>
							<li class="four"><a
								href="<%=request.getContextPath()%>/Member04.html">外送地址管理</a></li>
							<li class="five"><a
								href="<%=request.getContextPath()%>/Member05.html">歷史訂單</a></li>
							<li class="six"><a
								href="<%=request.getContextPath()%>/Member06.html">文章管理</a></li>
							<li class="seven"><a href="#">我的收藏</a></li>
						</ul>
					</div>




				</div>

				<!-- 中間 -->
				<div class="col-md-9">
					<table>
						<tr>							
							<th class="th1">標題</th>
							<th class="th1">時間</th>
							<th class="th2">查詢</th>
							<th class="th2">修改</th>
						</tr>
						<c:forEach var="faVO" items="${faList}">
							<tr>
								<td>${faVO.articleTitle}</td>
								<td>${faVO.articleDate}</td>

								<!--功能鍵 -->
								<td>
								<FORM method="post" action="<%=request.getContextPath()%>/article/fa.do" style="margin-bottom: 0px;">																		
									<input type="submit" value="閱讀"> <input type="hidden"
										name="articleNo" value="${faVO.articleNo}"> <input
										type="hidden" name="action" value="getOne_For_Display">
								</FORM>
	                             </td>
	                             
	                             <td>
								<FORM method="post" action="<%=request.getContextPath()%>/article/fa.do" style="margin-bottom: 0px;">																		
									<input type="submit" value="修改"> 
								    <input type="hidden"name="articleNo" value="${faVO.articleNo}"> 
									<input type="hidden" name="action" value="getOne_For_Update">
								</FORM>
								</td>





							</tr>
						</c:forEach>



					</table>






				</div>

				<!-- 右邊 -->
<!-- 				<div class="col-md-3"></div> -->
			</div>
		</div>
	</div>

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





	<script>
		
	</script>
</body>

</html>