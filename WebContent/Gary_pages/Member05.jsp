<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.memberinfo.model.*"%>
<%@ page import="com.card.model.*"%>
<%@ page import="com.rsorder.model.*"%>
<%@ page import="com.orderlist.model.*"%>
<%@ page import="com.address.model.*"%>
<%@ page import="com.orderlist.model.*"%>
<%@ page import="java.util.*"%>


<%
	MemberInfo memberinfo = (MemberInfo) session.getAttribute("memberInfo");

	RsOrderDAOService rsOrderSvc = new RsOrderDAOService();
	Set<RsOrderVO> rsorderset = rsOrderSvc.getRsOrderByUserId(memberinfo.getUserId());
	pageContext.setAttribute("rsorderset", rsorderset);
%>



<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>會員中心-歷史訂單</title>
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
	href="<%=request.getContextPath()%>/assets/css/Member05.css">

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

		<div class="content" style="overflow-x: hidden; overflow-y: auto;">
			<div class="title">
				<div class="titlebigname">歷史訂單OrderHistory</div>
				<div class="titlesmallname">管理您過去訂購的外送商品</div>
				<div class="showinfo">

					<div class="no">編號</div>
					<div class="ordernumber">訂單編號</div>
					<div class="orderday">訂單完成日期</div>
					<div class="ordername">訂購者姓名</div>
					<div class="totalprice">總金額</div>
					<div class="showtrack">
						<button type="button" name="button">詳細訂單明細</button>
					</div>
				</div>

				<%
					session.setAttribute("rsorderset", request.getAttribute("rsorderset"));
				
					AddressService addressSvc = new AddressService();
					Set<AddressVO> addressset = addressSvc.getAddressByUserId(memberinfo.getUserId());
					pageContext.setAttribute("addressset", addressset);

				%>
				<jsp:useBean id="addresSvc" scope="page" class="com.address.model.AddressService" />
				<jsp:useBean id="orderlistSvc" scope="page" class="com.orderlist.model.OrderListDAOService" />
				<c:forEach var="rsorderVO" items="${rsorderset}" varStatus="count">
					<div class="showinfo2">



						<div class="no">${count.count}</div>
						<div class="ordernumber">${rsorderVO.orderId}</div>
						<div class="orderday">${rsorderVO.orderDay}</div>

						<div class="ordername">${addresSvc.getOneAddress(rsorderVO.deliveryAddId).customerName}</div>
						<div class="totalprice">NT$${orderlistSvc.getTotalPriceByOrderId(rsorderVO.orderId)}</div>
						<FORM METHOD="post" ACTION="/TFA103G2/memberinfo/HistoryOrderServlet.do"
								style="margin-bottom: 0px;">
						<div class="showtrack">
							<input type="submit" class="detail" value="詳細訂單明細"> <input
									type="hidden" name="orderId" value="${rsorderVO.orderId}"> <input
									type="hidden" name="action" value="getOneOrderList">
						</div>
						</FORM>
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


</body>
</html>
