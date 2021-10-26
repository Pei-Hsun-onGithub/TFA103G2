<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.foodarticle.model.*"%>
<%@ page import="com.picturebase.model.*"%>


<% 

	FoodArticleService faSvc = new FoodArticleService();
    List<FoodArticleVO> faList =faSvc.getall();
    List<FoodArticleVO> popularList = faSvc.getPopularArticle();
    pageContext.setAttribute("faList",faList);
    pageContext.setAttribute("popularList",popularList);   	

%>



<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>All FoodArticle</title>
    <!--fivicon icon-->
    <link rel="icon" href="<%=request.getContextPath()%>/assets/img/fevicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/animate.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/magnific.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/nice-select.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/jquery-ui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/owl.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/slick-slide.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontawesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/remixicon/remixicon.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/responsive.css">

    <!--Google Fonts-->
    <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap" rel="stylesheet">
	
	<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp" %>
        
    <style>
    form.search-form {
    position: relative;
    background: #fff;
    border-radius: 6px;
    width: 80%;
    margin: auto;
    } 
    
    img.articleimg{   
    width: 450px;
    height: 430px;    
    }
    
    p.ellipsis{
    overflow: hidden;
    display: -webkit-box;
    text-overflow: ellipsis;
    -webkit-line-clamp: 6; /*行數*/
    -webkit-box-orient: vertical;
    white-space: normal;
    
    
    }  

    </style>
	

</head>
<body class='sc5'>
    <!-- preloader area start -->
    <div class="preloader" id="preloader">
        <div class="preloader-inner">
            <div id="wave1">
            </div>
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
            <button type="submit" class="submit-btn"><i class="fa fa-search"></i></button>
        </form>
    </div>
    <!-- //. search Popup -->

    <!-- navbar start -->
    <%@ include file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp" %>
    <!-- navbar end -->

    <!-- bredcrumb Area Start-->
    <section class="breadcrumb-area">
        <div class="banner-bg-img"></div>
        <div class="banner-shape-1"><img src="<%=request.getContextPath()%>/assets/img/banner/shape-1.png" alt="img"></div>
        <div class="banner-shape-2"><img src="<%=request.getContextPath()%>/assets/img/banner/shape-2.png" alt="img"></div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 align-self-center">
                    <div class="banner-inner text-center">
                        <h3>Blog
                        </h3>
                        <h1>Food Blog</h1>
                        <nav aria-label="breadcrumb">
                            <ul class="breadcrumb">
                              <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/home-1.html">Home</a></li>
                              <li class="breadcrumb-item active" aria-current="page">Blog</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- bredcrumb Area End --> 

    <!-- blog Area Start-->
    
    <section class="blog-area pd-top-120 pd-bottom-120">
        
        <div class="widget widget_search">
            <form class="search-form">
                <div class="form-group">
                    <input type="text" placeholder="食記搜尋">
                    <button class="submit-btn" type="submit"><i class="ri-search-line"></i></button>
                </div>
            </form>
        </div>
        
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    
                    <div class="row justify-content-center">
                        
<%--                        <c:forEach var="faVO" items="${list}"> </c:forEach> --%>
                       
                       <c:forEach var="faVO" items="${faList}"  >
                        <div class="col-sm-6">                                                                                                                 
                            <div class="single-blog-wrap">
                                <div class="thumb">                                    
                                    <img class ="articleimg" src="<%=request.getContextPath()%>/ImageSingleServlet?Id=${faVO.articleNo}" alt="img">                                	
                                </div>
                                <div class="wrap-details">
                                    <span class="cat">
                                        <span class="date">
                                            <i class="ri-calendar-todo-fill"></i>${faVO.articleDate}
                                        </span>
                                        <a href="#" class="tag me-0">
                                            <i class="ri-price-tag-3-fill"></i>Burgar
                                        </a>
                                    </span>

                                     <h5><a href="<%=request.getContextPath()%>/article/fa.do?action=getOne_For_Display&articleNo=${faVO.articleNo}">${faVO.articleTitle}
                                    </a></h5> 
                                    <div class="wrap-hover-area">
                                        <p class="ellipsis"> ${faVO.articleContent}
                                        </p> 
                                        <a class="link-btn" href="<%=request.getContextPath()%>/article/fa.do?action=getOne_For_Display&articleNo=${faVO.articleNo}">Read More</a> 
                                    </div>                       
                                </div> 
                            </div>                                                                                  
                                                       
                        </div>
                       </c:forEach>
                    </div>
                 </div>
                       
                        
                       
                <div class="col-lg-4">
                    <div class="sidebar-area">
                        
                        <div class="widget widget-recent-post">
                            <h4 class="widget-title">熱門食記</h4>
                            <ul>
                                <c:forEach var="popfaVO" items="${popularList}" >
                                <li>
                                    <div class="media">
                                        <div class="media-left">
                                            <img src="<%=request.getContextPath()%>/article/pic.do?Id=${popfaVO.articleNo}" alt="widget">
                                        </div>
                                        <div class="media-body">

                                            <h6 class="title"><a href="<%=request.getContextPath()%>/article/fa.do?action=getOne_For_Display&articleNo=${popfaVO.articleNo}"> ${popfaVO.articleTitle} </a></h6>

                                        </div>
                                    </div>
                                </li>
                                </c:forEach>
                                
                            </ul>
                        </div>
                       
                        <div class="widget widget-recent-post">
                            <h4 class="widget-title">熱門餐廳</h4>
                            <ul>
                                <c:forEach var="popfaVO" items="${popularList}" >
                                <li>
                                    <div class="media">
                                        <div class="media-left">
                                            <img src="<%=request.getContextPath()%>/article/pic.do?Id=${popfaVO.articleNo}" alt="widget">
                                        </div>
                                        <div class="media-body">

                                            <h6 class="title"><a href="<%=request.getContextPath()%>/article/fa.do?action=getOne_For_Display&articleNo=${popfaVO.articleNo}"> ${popfaVO.articleTitle} </a></h6>

                                        </div>
                                    </div>
                                </li>
                                </c:forEach>
                                
                            </ul>
                        </div>
                        <div class="widget widget_categories" style= display:none>                                                                                                          
                        </div>
                    </div>
                </div>
                <div class="col-12">
                    <nav>
                        <ul class="pagination">
                            <li class="page-item">
                            <a class="page-link" href="#">
                                <i class="ri-arrow-left-s-line"></i>
                            </a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                            <a class="page-link" href="#">
                                <i class="ri-arrow-right-s-line"></i>
                            </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- blog Area End -->

    <!-- footer area start -->
    <footer class="footer-area">

		<div class="footer-bottom">
			<div class="container">
				<div class="row align-items-center">

					<div class="col-md-3 text-md-start text-center">
						<img src="assets/img/logo.png" alt="img"
							style="width: 125px; height: 40px;">
					</div>
					<div class="col-md-4 text-md-start text-center">
						<div class="copyright-area">
							<p>© 2021 TFA103G2. All Rights Reserved</p>
						</div>
					</div>
					<div class="col-md-5">
						<ul class="social-area text-md-end text-center mt-md-0 mt-2">
							<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
							<li><a href="#"><i class="fab fa-twitter"></i></a></li>
							<li><a href="#"><i class="fab fa-behance"></i></a></li>
							<li><a href="#"><i class="fab fa-google-plus-g"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>
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
    <script src="<%=request.getContextPath()%>/assets/js/isotope.pkgd.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/nice-select.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/fontawesome.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/owl.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/slick-slider.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/tweenmax.min.js"></script>
    <!-- main js  -->
    <script src="<%=request.getContextPath()%>/assets/js/main.js"></script>
    
    <%@ include file="/assets/webPageSnippet/jsSnippet_navbar_home_3.jsp" %>
</body>
</html>