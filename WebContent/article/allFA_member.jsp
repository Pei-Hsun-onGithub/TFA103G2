<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.foodarticle.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.memberinfo.model.*"%>
<%
	FoodArticleService faSVC = new FoodArticleService();
	List<FoodArticleVO> faList = faSVC.getall();
	pageContext.setAttribute("faList", faList);
	
//測試	
	
	MemberInfoService memSvc = new MemberInfoService();
	String email ="1qaz@y.com";
	String pwd ="1qaz@WSX";
	MemberInfo userNow = memSvc.findByEmail2(email, pwd);

	out.println(userNow);
//	MemberInfo userNow = (MemberInfo) session.getAttribute("memberInfo");
	pageContext.setAttribute("userNow", userNow);
	
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

<%-- <%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp"%> --%>

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

.profile .nickname { 
    font-size: 20px;  
    font-weight: bold; 
    list-style: none; 
}
.profile .my-username{
	font-size: 15px;  
    font-weight: bold; 
    list-style: none;
}

table {
	display: flex;
	justify-content: center;
	align-items: center;
	border: 2px solid black;
	margin-top: 100px;
	width: 800px;
}

table tbody.my-tbody {
	width: 700px;
}

tr {
	width: 100%;
}

th.th1 {
	width: 60%;
}

th.th2 {
	width: 20%;
}
</style>

</head>

<body>

<%-- 	<%@ include --%>
<%-- 		file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp"%> --%>

	<div class="main">

		<!-- 要用boostrap的格線系統要一定要有div class="container nav-container" -->
		<div class="container nav-container">

			<!-- 要給row,告訴html橫列的範圍 -->
			<div class="row justify-content-center">

				<!-- 給格線範圍,再把元素放進格線範圍裡,左+中間+右=12 -->

				<!-- 左邊 -->
				<div class="col-md-4">
					<div class="profile">
						<img src="<%=request.getContextPath()%>/assets/img/girl.png"
							alt="img">
						<ul>
							<li class="nickname my-username">getUserName()</li>
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
				<div class="col-md-8">
					<table>
						<tbody class="my-tbody">
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
										<FORM method="post"
											action="<%=request.getContextPath()%>/article/fa.do"
											style="margin-bottom: 0px;">
											<input type="submit" value="閱讀"> 
											<input type="hidden" name="articleNo" value="${faVO.articleNo}">
											<input type="hidden" name="userId" value="${userNow.userId}">
											<input type="hidden" name="action" value="getOne_For_Display">	 
												
										</FORM>
									</td>

									<td>
										<FORM method="post"
											action="<%=request.getContextPath()%>/article/fa.do"
											style="margin-bottom: 0px;">
											<input type="submit" value="修改"> 
											<input type="hidden" name="articleNo" value="${faVO.articleNo}">
											<input type="hidden" name="userId" value="${userNow.userId}">
											<input type="hidden" name="action" value="getOne_For_Update">
											
										</FORM>
									</td>
								</tr>
							</c:forEach>

						</tbody>

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

<%-- 	<%@ include file="/assets/webPageSnippet/jsSnippet_navbar_home_3.jsp"%> --%>



	<script>
		
	</script>
</body>

</html>