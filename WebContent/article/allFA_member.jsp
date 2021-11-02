<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.foodarticle.model.*"%>
<%@ page import="com.memberinfo.model.*"%>
<%@ page import="java.util.*"%>

<%
	MemberInfo memberinfo = (MemberInfo) session.getAttribute("memberInfo");

	FoodArticleService faSVC = new FoodArticleService();
	List<FoodArticleVO> faList = faSVC.getArticlesByUserId(memberinfo.getUserId());
	pageContext.setAttribute("faList", faList);
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
	href="<%=request.getContextPath()%>/assets/css/Member06.css">

<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">

<!--Date choose-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.css" />

<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp"%>


</head>

<body style="background-color: #dbdbdb">

	<%@ include
		file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp"%>

	<div class="total" style="width: 1000px; height: 700px;">
		<div class="profile">
			<img
				src="<%=request.getContextPath()%>/memberinfo/MemberPic.do?userId=<%=memberinfo.getUserId()%>"
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
					href="<%=request.getContextPath()%>/login/memberinfo.do?action=getOne">個人檔案</a></li>
				<li class="two"><a
					href="<%=request.getContextPath()%>/login/memberinfo.do?action=getOnePwd">密碼修改</a></li>
				<li class="three"><a
					href="<%=request.getContextPath()%>/memberinfo/CardServlet.do?action=getAllCard">銀行/信用卡資訊</a></li>
				<li class="four"><a
					href="<%=request.getContextPath()%>/address/address.do?action=getAllAddress">外送地址管理</a></li>
				<li class="five"><a
					href="<%=request.getContextPath()%>/memberinfo/OrderListServlet.do?action=getAllOrderList">歷史訂單</a></li>
				<li class="six"><a
					href="<%=request.getContextPath()%>/article/allFA_member.jsp">文章管理</a></li>
				<li class="seven"><a href="#">我的收藏</a></li>
			</ul>
		</div>

		<div class="content" style="overflow-x: hidden; overflow-y: auto;">
			<div class="title">
				<div class="titlebigname">文章管理ArticleManagement</div>
				<div class="titlesmallname">管理您過去撰寫的文章</div>

				<div class="showinfo">

					<div class="no">編號</div>
					<div class="ordernumber">文章標題</div>
					<div class="orderday">撰寫日期</div>

					<div class="showtrack">
						<button type="button" name="button">查詢</button>
					</div>
					<div class="showtrack">
						<button type="button" name="button">修改</button>
					</div>
				</div>



				<c:forEach var="faVO" items="${faList}" varStatus="count">

					<div class="showinfo2">

						<div class="no">${count.count}</div>
						<div class="ordernumber">${faVO.articleTitle}</div>
						<div class="orderday">${faVO.articleDate}</div>

						<div class="showtrack">
							<FORM method="post"
								action="<%=request.getContextPath()%>/article/fa.do"
								style="margin-bottom: 0px;">
								<input type="submit" class="read" value="閱讀"> 
								<input type="hidden" name="articleNo" value="${faVO.articleNo}">
								<input type="hidden" name="userId" value="${memberInfo.userId}">
								<input type="hidden" name="action" value="getOne_For_Display">
							</FORM>
						
						</div>
						<div class="showtrack">
							<FORM method="post"
								action="<%=request.getContextPath()%>/article/fa.do"
								style="margin-bottom: 0px;">
								<input type="submit" class="edit" value="修改"> 
								<input type="hidden" name="articleNo" value="${faVO.articleNo}"> 
								<input type="hidden" name="action" value="getOne_For_Update">
							</FORM>
						</div>
					</div>


				</c:forEach>










			</div>

			
		</div>
	</div>

<%@ include file="/assets/webPageSnippet/footerSnippet_home.jsp"%>


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

	<%@ include file="/assets/webPageSnippet/jsSnippet_navbar_home_3.jsp"%>



	<script>
		
	</script>
</body>

</html>