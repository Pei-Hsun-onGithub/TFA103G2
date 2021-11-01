<%@page import="com.memberinfo.model.MemberInfo"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.foodarticle.model.*"%>
<%@ page import="com.message.model.*"%>
<%@ page import="com.picturebase.model.*"%>
<%@ page import="com.meal.model.*"%>
<%@ page import="com.memberinfo.model.*"%>
<%@ page import="com.favofoodarticle.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
  FoodArticleVO faVO = (FoodArticleVO) request.getAttribute("faVO"); //FoodArticleServlet.java(Concroller), 存入req的faVO物件
  List<MessageVO> msgList = (List<MessageVO>) request.getAttribute("msgList");
//    request.setAttribute("msgList", msgList);

  MealService mealSc = new MealService();
  List<MealVO> mealList = mealSc.getMealNew();
  pageContext.setAttribute("mealList",mealList);
  
  FoodArticleService faSvc = new FoodArticleService();
  List<FoodArticleVO> popularList = faSvc.getPopularArticle();
  pageContext.setAttribute("popularList",popularList);
  
  MemberInfo userNow = (MemberInfo) session.getAttribute("memberInfo");
  session.setAttribute("userNow", userNow);

%>

<jsp:useBean id="memtSvc" scope="page" class="com.memberinfo.model.MemberInfoService" />

<% MemberInfo oneMebVO = memtSvc.getOneMemberInfo(faVO.getUserId());
   pageContext.setAttribute("oneMebVO",oneMebVO);
%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>FoodKa - Food Ordering, Delivery & Restuarent Template</title>
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

<!--Google Fonts-->
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">

<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp" %>

<style>

div.author {
	display:inline-block;

}

div.authorname {
	font-weight: 600;
	font-size: 20px;
}

img.faImage{
	width: 280px;
    height: 280px;
    border-radius: 8px;
}

p.myP{

	color:black;
	font-size:15px;

}
</style>

</head>
<body class='sc5'>
	<!-- preloader area start -->
	<div class="preloader" id="preloader">
		<div class="preloader-inner">
			<div id="wave1"></div>
			<div class="spinner">
				<div class="dot1"></div>
				<div class="dot2"></div>
			</div>
		</div>
	</div>
	<!-- preloader area end -->
	<!-- search popup area start -->
	<div class="body-overlay" id="body-overlay"></div>
	<div class="td-search-popup" id="td-search-popup">
		<form action="index.html" class="search-form">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search.....">
			</div>
			<button type="submit" class="submit-btn">
				<i class="fa fa-search"></i>
			</button>
		</form>
	</div>
	<!-- //. search Popup -->

	<!-- navbar start -->
    <%@ include file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp" %>
	<!-- navbar end -->

	<!-- bredcrumb Area Start-->
	<section class="breadcrumb-area">
		<div class="banner-bg-img"></div>
		<div class="banner-shape-1">
			<img
				src="<%=request.getContextPath()%>/assets/img/banner/shape-1.png"
				alt="img">
		</div>
		<div class="banner-shape-2">
			<img
				src="<%=request.getContextPath()%>/assets/img/banner/shape-2.png"
				alt="img">
		</div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6 align-self-center">
					<div class="banner-inner text-center">
						<h3>delicacy</h3>
						<h1>Dining Brief </h1>
						<nav aria-label="breadcrumb">
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/article/allFA.jsp">Home</a></li>
								<li class="breadcrumb-item"><a href="blog.html">Blog</a></li>
								<li class="breadcrumb-item active" aria-current="page">Blog
									Details</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- bredcrumb Area End -->

	<!-- blog single start -->
	<div class="blog-single-area pd-top-120 pd-bottom-90">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="blog-details-inner">
						<!-- <div class="thumb pb-4">
                            <img src="<%=request.getContextPath()%>/assets/img/blog/single.png" alt="img">
                        </div>  -->	
                        
                        
                        <!--   取作者id     -->											
						<div class="author" >							
							<div class="authorname">${oneMebVO.userName}</div>			                                                                                       
                        </div>
                        
<!--                         <div class="thumb">                                     -->
                            
<!--                          </div> -->
						
						<span class="cat"> <span class="date"> <i
								class="ri-calendar-todo-fill"></i> <%=faVO.getArticleDate()%>
						</span> <input type="hidden" value="時間"> 
						</span>
						<h3><%=faVO.getArticleTitle()%></h3>
						<input type="hidden" value="文章標題">

						<p>
							<%=faVO.getArticleContent()%>
						</p>


						<div class="row">
							
							<c:forEach var="adf" items="${list}" varStatus="index">
							<div class="col-6">								 
								<img class="faImage" src="<%=request.getContextPath()%>/PictureBasesServlet?id=${index.index}">                                								 
						   </div>
						   </c:forEach>

						</div>								                               
							

					</div>
					<div class="tag-share-area">
						<div class="row">
							<div class="col-sm-6 align-self-center">
								<div class="tag-inner">
								  <ul class="social-area mt-md-0 mt-2">
								  	<li>收藏</li>
							  	 
								  	<c:if test="${not empty favfooVO }">
								  	<li id="mycollect">                                 	
                                  	<a class="fav-btn" >
                                  	<i id="myheart" class="fas fa-heart"></i></a>
                                  	</li>
                                  	</c:if>
                                  	
                                  	<c:if test="${empty favfooVO }">
                                  	<li id="mycollect">                                 	
                                  	<a class="fav-btn" >
                                  	<i id="myheart" class="ri-heart-line"></i></a>
                                  	</li>
                                  </c:if>
                                  </ul>
								</div>
							</div>
							<div class="col-sm-6 mt-3 mt-sm-0 align-items-center">
								<ul class="social-area text-sm-end mt-md-0 mt-2">
									
									<li>分享</li>
									<li><a href="https://zh-tw.facebook.com/"><i
											class="fab fa-facebook-f"></i></a></li>
									<li><a href="https://twitter.com/?lang=zh-tw"><i class="fab fa-twitter"></i></a></li>
									
									
									
								</ul>
							</div>
						</div>
					</div>

	
				
					
					<div class="comment-area">
						<h5 class="title">留言區</h5>

						<c:forEach var="msgVO" items="${msgList}">											
							<div class="media">								                         
								<div class="media-body">
																	
									<p class="myP">
									<c:forEach  var="memVO" items="${memtSvc.all}">
									<c:if test ="${msgVO.userId==memVO.userId}">
									 ${memVO.userName}									 
									</c:if>
									</c:forEach>
									</p>																	
									<span>${msgVO.msgDate}</span>
									<p>${msgVO.msgContent}</p>
									<input type="hidden" value="${msgVO.sta}">
								</div>
							</div>
						</c:forEach>

					</div>

<!-- 要讓頁面在登入狀況下，要加下面這一行 -->
<%-- <%MemberInfo meVO =(MemberInfo)session.getAttribute("MemberInfo");%> --%>



					<form class="default-form-wrap" method="post" action="msg.do">
						<h5 class="title">留言</h5>
						<div class="row">
							
							<div class="col-12">
								<div class="single-textarea-wrap">

									<textarea rows="4" placeholder="Message..." name="msgContent"></textarea>
									<input type="hidden" value="1" name="sta">

								</div>
							</div>
							<div class="col-md-6">
								<div class="single-input-wrap">
									<input id="myid" type="hidden" class="form-control" name="userId" value="<%=userNow.getUserId() %>">
									<input id="myarticleno" type="hidden" name="articleNo" value="<%=faVO.getArticleNo()%>"/>										 
								</div>
							</div>
							<div class="col-md-6"></div>								
							
						</div>
						<button type="submit" class="btn btn-base">Submit your
							Message</button>
						<input type="hidden" name="action" value="msgAdd">
					</form>
				</div>
				
				<div class="col-lg-4">
					<div class="sidebar-area">
						
						<div class="widget widget-recent-post">
							<h4 class="widget-title">最新食記</h4>
							
							<ul>
								<c:forEach  var="latestfaVO" items="${popularList}">
								<li>
									<div class="media">
										<div class="media-left">
											<img
												src="<%=request.getContextPath()%>/article/pic.do?Id=${latestfaVO.articleNo}" alt="圖片">												
										</div>
										<div class="media-body">
											<h6 class="title">
												<a href="<%=request.getContextPath()%>/article/fa.do?action=getOne_For_Display&articleNo=${latestfaVO.articleNo}&userId=${userNow.userId}">${latestfaVO.articleTitle}</a>
											</h6>
										</div>
									</div>
								</li>
								</c:forEach>																						
							</ul>
						
						</div>
						<div class="widget widget-recent-post">
							<h4 class="widget-title">精選餐點</h4>
							<ul>
								<c:forEach var="mealVO" items="${mealList}">
								<li>
									<div class="media">
										<div class="media-left">
											<img
												src="<%=request.getContextPath()%>/article/mealpic.do?Id=${mealVO.mealId}"
												alt="圖片">
										</div>
										<div class="media-body">
											<h6 class="title">
												<a href="<%=request.getContextPath()%>/Mealsingle?mealId=${mealVO.mealId}">${mealVO.mealName}</a>
											</h6>
										</div>
									</div>
								</li>
								</c:forEach>																							
							</ul>
						</div>
						<!-- <div class="widget widget_categories">
                            <h4 class="widget-title">Categories</h4>
                            <ul>
                                <li><a href="#">Inspiration <span>(5)</span></a></li>
                                <li><a href="#">Recipes <span>(9)</span> </a></li>
                                <li><a href="#">Others <span>(18)</span></a></li>
                            </ul>
                        </div> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- blog single end -->

	<!-- footer area start -->
	<%@ include file="/assets/webPageSnippet/footerSnippet_home.jsp" %>
	<!-- footer area end -->

	<!-- back-to-top end -->
	<div class="back-to-top">
		<span class="back-top"><i class="fas fa-angle-double-up"></i></span>
	</div>



	<!-- all plugins here -->
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
	
	<%@ include file="/assets/webPageSnippet/jsSnippet_navbar_home_3.jsp" %>
	
	<script>
	var favoURL ="<%=request.getContextPath()%>/favofoodarticle/FavoArticle.do";
	
	$("#myheart").on("click", function(){
		  if($("#myheart").hasClass("ri-heart-line")){
			  
			  var articleno =$("#myarticleno").val();
			  var userid = $("#myid").val();
			  
			  $.ajax({
				  type:"POST",
				  url:favoURL,
				  data:{
					  "action":"Insert",
					  "articleNo":articleno,
					  "userId":userid					  
				  },				  
				  datatype: "json",
				  success: function(data){
					  console.log("haha");
					  $("#myheart").removeClass("ri-heart-line").addClass("fas fa-heart");
				  }				  
			  })
			  
			  
			  
		  }else{
			  $("#myheart").removeClass("fas fa-heart").addClass("ri-heart-line");
		  }
		
	});
	
		
	
	
	
	
	
	
	
	</script>
</body>
</html>