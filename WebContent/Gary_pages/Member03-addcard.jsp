<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.card.model.*"%>
<%@ page import="com.memberinfo.model.*"%>
<%@ page import="java.util.Set"%>

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

	<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp"%>
</head>
<body style="background-color: #dbdbdb">
	<%@ include
		file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp"%>
	

	<div class="total" style="width: 1000px; height: 700px;">
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


		<form method="post" action="/TFA103G2/memberinfo/CardServlet.do"
			enctype="multipart/form-data">
			<div class="content">
				<div class="title">
					<div class="titlebigname">新增信用卡AddCard</div>
					<div class="titlesmallname">新增信用卡資訊</div>
					<div class="editarea">


						<div class="information">
							<div class="holder">
								<div class="lebel1">持卡人姓名</div>
								<div class="input1">
									<input type="hidden" maxlength="255" name="userId"
										value="<%=memberinfo.getUserId()%>"> 
									<input type="text" name="cardHolder" maxlength="255" value="">
								</div>
							</div>
							<div class="number">
								<div class="lebel2">信用卡卡號</div>
								<div class="input1">
									<input type="text" name="cardNumber" style="width: 300px"
										maxlength="20" oninput="value=value.replace(/[^\d]/g,'')"
										value="">
								</div>

							</div>
							<div class="expirydate">
								<div class="lebel3">到期日</div>
								<div class="input3">
									<input type="date" id="date" name="deadLine"
										style="width: 141px" min="2021-01" max="2030-12" value="">
								</div>
								<div class="CVV">
									<div class="lebel4">CVV</div>
									<div class="input4">
										<input type="text" style="width: 95px; height: 30px"
											name="cvv" maxlength="3"
											oninput="value=value.replace(/[^\d]/g,'')" value="">
									</div>
								</div>
							</div>

							<div class="billaddress">
								<div class="lebel5">帳單地址</div>
								<div class="input5">
									<input type="text" name="billAddress" maxlength="255" value="">
								</div>
							</div>
							<div class="zipcode">
								<div class="lebel6">郵遞區號</div>
								<div class="input6">
									<input type="text" name="zipCode" maxlength="6"
										oninput="value=value.replace(/[^\d]/g,'')" value=""> <input
										type="hidden" maxlength="255" name="sta" value="">
								</div>
							</div>
							<div class="storebutton">
								<input type="hidden" name="cardId" value=""> 
								<input type="hidden" name="action" value="insertOneCard">
								<button type="submit" id="certain" name="submit">確定</button>
							</div>
							<div class="backbutton">
								<button type="reset" name="button">重填</button>

							</div>
						</div>
					</div>
				</div>
				<c:if test="${not empty errorMsgs}">
					<div style="margin-top: 300px; margin-left: 750px">
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
</body>




</html>
