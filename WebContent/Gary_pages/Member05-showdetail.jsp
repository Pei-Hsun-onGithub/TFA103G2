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
<%@ page import="com.meal.model.*"%>
<%@ page import="java.util.*"%>

<%
	MemberInfo memberinfo = (MemberInfo) session.getAttribute("memberInfo");
	RsOrderVO rsordervo = (RsOrderVO) request.getAttribute("rsordervo");
	Set<OrderListVO> orderlistset = (Set<OrderListVO>) request.getAttribute("orderlistset");
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
	href="<%=request.getContextPath()%>/assets/css/Member05-showdetail.css">

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

		<jsp:useBean id="addresSvc" scope="page"
			class="com.address.model.AddressService" />
		<jsp:useBean id="orderlistSvc" scope="page"
			class="com.orderlist.model.OrderListDAOService" />
		<jsp:useBean id="mealSvc" scope="page"
			class="com.meal.model.MealService" />
		<jsp:useBean id="cardSvc" scope="page"
			class="com.card.model.CardDAOService" />
		<div class="content" style="overflow-x: hidden; overflow-y: auto;">
			<div class="title">
				<div class="titlebigname">${addresSvc.getOneAddress(rsordervo.deliveryAddId).customerName}，感謝您訂購餐點</div>
				<div class="titlesmallname">這是您本次訂單編號：${rsordervo.orderId}
					的收據。</div>

				<c:forEach var="orderlistVO" items="${orderlistset}">
					<div class="showinfo">

						<div class="pic">
							<img
								src="/TFA103G2/memberinfo/MemberMealPic.do?mealId=${orderlistVO.mealId}"
								alt="img">
						</div>
						<div class="quantity">${orderlistVO.quantity}</div>
						<div class="mealname">${mealSvc.findMealByPrimaryKey(orderlistVO.mealId).mealName}</div>
						<div class="note">加辣，炸酥一點，如果可以的話拜託幫我切</div>
						<div class="price">${orderlistVO.quantity*orderlistVO.unitPrice}</div>
					</div>
				</c:forEach>

				<div class="showinfo2">

					<div class="pic">
						<img src="<%=request.getContextPath()%>/images/Monster03.png">
					</div>
					<div class="quantity">7</div>
					<div class="mealname">甘草芭樂</div>
					<div class="note">如果可以幫我加雙倍梅粉</div>
					<div class="price">訂單金額：
						NT$${orderlistSvc.getTotalPriceByOrderId(rsordervo.orderId)}</div>
				</div>

				<div class="otherinformation">
					<div class="address">
						<div class="atitle"
							style="font-size: 25px; height: 50px; font-weight: bold;">取餐地址</div>
						<div class="customername">${addresSvc.getOneAddress(rsordervo.deliveryAddId).customerName}</div>
						<div class="deliverphone">${addresSvc.getOneAddress(rsordervo.deliveryAddId).deliverPhone}</div>
						<div class="deliveraddress">${addresSvc.getOneAddress(rsordervo.deliveryAddId).deliverAddress}</div>
					</div>
					<div class="creditcard">
						<div class="cardtitle"
							style="font-size: 25px; height: 50px; font-weight: bold;">付款方式</div>
						<div class="payname">信用卡</div>
						<div class="cardnumber">卡號：${cardSvc.getCardDAO(rsordervo.cardId).cardNumber}</div>
					</div>
				</div>

				<div class="OK">
					<input type="button"
						style="position: relative; top: 20px; background-color: rgba(88, 169, 175, 1); border: none; color: white; padding: 5px 25px; text-align: center; text-decoration: none; display: inline-block; font-size: 20px; margin-left: 450px;"
						onclick="javascript:location.href='<%=request.getContextPath()%>/memberinfo/HistoryOrderServlet.do?action=getAllOrderList'"
						value="確定"></input>
				</div>
				<div class="space">111</div>
			</div>

		</div>

	</div>



</body>
</html>
