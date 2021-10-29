<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.card.model.*"%>
<%@ page import="com.memberinfo.model.*"%>

<%
	CardVO cardVO = (CardVO) request.getAttribute("cardvo");
%>

<%
	MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberinfo");
%>

<%
  response.setHeader("Cache-Control","no-store"); //HTTP 1.1
  response.setHeader("Pragma","no-cache");        //HTTP 1.0
  response.setDateHeader ("Expires", 0);
%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>會員中心-信用卡資訊</title>
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
	href="<%=request.getContextPath()%>/assets/css/Member03.css">

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
					href="<%=request.getContextPath()%>/Member05.html">歷史訂單</a></li>
				<li class="six"><a
					href="<%=request.getContextPath()%>/Member06.html">文章管理</a></li>
				<li class="seven"><a href="#">我的收藏</a></li>
			</ul>
		</div>


		<div class="content" style="overflow-x: hidden; overflow-y: auto;">
			<div class="title">
				<div class="titlebigname">信用卡資訊CreditCard</div>
				<div class="titlesmallname">管理你的信用卡資訊</div>

				<div class="showinfo">
					<div class="cardNo">編號</div>
					<div class="cardHolder">持卡人姓名</div>
					<div class="cardNumber">信用卡卡號</div>
					<div class="delete">
						<button type="button" name="button">刪除</button>
					</div>
					<div class="edit">
						<button type="button" name="button">編輯</button>
					</div>
				</div>

<%

	session.setAttribute("cardset", request.getAttribute("cardset"));

%>
				<c:forEach var="CardVO" items="${cardset}" varStatus="count">
					<div class="showinfo2">
						<div class="cardNo">${count.count}</div>
						<div class="cardHolder">${CardVO.cardHolder}</div>
						<div class="cardNumber">${CardVO.cardNumber}</div>
						<div class="deletecard">
							<input type="hidden" name="userId"
								value="<%=memberinfo.getUserId()%>"> <input
								type="hidden" name="cvv" value="${CardVO.cvv}"> <input
								type="hidden" name="deadLine" value="${CardVO.deadLine}">
							<input type="hidden" name="billAddress"
								value="${CardVO.billAddress}"> <input type="hidden"
								name="zipCode" value="${CardVO.zipCode}"> <input
								type="hidden" name="sta" value="${CardVO.sta}">
							<FORM METHOD="post" ACTION="/TFA103G2/memberinfo/CardServlet.do"
								style="margin-bottom: 0px;">
								<input type="submit" class="delete" value="刪除"> <input
									type="hidden" name="cardId" value="${CardVO.cardId}"> <input
									type="hidden" name="action" value="deleteCard">
							</FORM>
						</div>
						<div class="editcard">
							<FORM METHOD="post" ACTION="/TFA103G2/memberinfo/CardServlet.do"
								style="margin-bottom: 0px;">
								<input type="submit" class="edit" value="編輯"> <input
									type="hidden" name="cardId" value="${CardVO.cardId}"> <input
									type="hidden" name="action" value="showUpdateCard">
							</FORM>
						</div>
					</div>
				</c:forEach>



				<div class="newcard">
					<!-- 						<button type="button" name="button">新增信用卡</button> -->
					<FORM METHOD="post" ACTION="/TFA103G2/memberinfo/CardServlet.do"
						style="margin-bottom: 0px;">
						<input type="submit" class="insertcard" value="新增信用卡"> <input
							type="hidden" name="action" value="showInsertCard">
					</FORM>
					<%-- <a class="button" name="addcard"

						href="/TFA103G2/memberinfo/CardServlet.do?action=showInsertCard">新增信用卡</a>： --%>
				</div>
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
