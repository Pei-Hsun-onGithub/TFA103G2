<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.address.model.*"%>
<%@ page import="com.memberinfo.model.*"%>
<%@ page import="java.util.Set"%>

<%
	MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberinfo");
%>

<%
	AddressVO addressVO = (AddressVO) request.getAttribute("addressvo");
%>



<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>會員中心-新增外送地址</title>
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
	href="<%=request.getContextPath()%>/assets/css/Member04-addaddress.css">

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
				<li class="seven"><a
					href="<%=request.getContextPath()%>/Gary_pages/Member07.jsp">我的收藏</a></li>
			</ul>
		</div>


		<form method="post" action="/TFA103G2/address/address.do"
			enctype="multipart/form-data">
			<div class="content">
				<div class="title">
					<div class="titlebigname">新增外送地址AddAddress</div>
					<div class="titlesmallname">新增外送地址資訊</div>
					<div class="editarea">


						<div class="information">
							<div class="customername">
								<div class="lebel1">取餐者姓名</div>
								<div class="input1">
									<input type="hidden" maxlength="255" name="userId" value="<%=addressVO.getUserId()%>"> 
									<input type="hidden" maxlength="255" name="deliveryAddId" value="<%=addressVO.getDeliveryAddId()%>">
									<input type="hidden" maxlength="255" name="sta" value="<%=addressVO.getSta()%>">
									<input type="text" name="customerName" maxlength="255" value="<%=addressVO.getCustomerName()%>">
								</div>
							</div>
							<div class="deliverphone">
								<div class="lebel2">連絡電話</div>
								<div class="input2">
									<input type="text" name="deliverPhone" maxlength="255" value="<%=addressVO.getDeliverPhone()%>">
								</div>
							</div>
							<div class="deliveraddress">
								<div class="lebel3">外送地址</div>
								<div class="input3">
									<input type="text" name="deliverAddress" maxlength="255" value="<%=addressVO.getDeliverAddress()%>">
								</div>
							</div>
							<div class="buildingname">
								<div class="lebel4">大樓名稱(選填)</div>
								<div class="input4">
									<input type="text" name="buildingName" maxlength="255" value="<%=addressVO.getBuildingName()%>">
								</div>
							</div>
							<div class="note">
								<div class="lebel5">備註(選填)</div>
								<div class="input5">
									<input type="text" name="note" maxlength="255" value="<%=addressVO.getNote()%>">
								</div>
							</div>
							<div class="storebutton">
							<input type="hidden" name="deliveryAddId" value="">
							<input type="hidden" name="action" value="updateOneAddress">
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
