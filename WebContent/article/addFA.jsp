<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.foodarticle.model.*"%>
<%@ page import="com.restaurant.*"%>

<%
	FoodArticleVO faVO = (FoodArticleVO) request.getAttribute("faVO");
%>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>add new FoodArticle</title>

<!--fivicon icon-->
<link rel="icon" href="<%=request.getContextPath()%>/assets/img/fevicon.png">

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

form.article {
	margin: 0 auto;
	justify-content: center !important;
	margin-top: 30px;
	padding-top: 60px;
}

.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}



p.p1 {
	margin: 0 auto;
	font-size: 23px;
}

input.title_input {
	width: 496px;
	height: 40px;
	margin: 5px auto;
	border-radius: 10px;
	border: none;
}

input[type="file"] {
	display: block;
}

textarea.editor {
	width: 700px;
	height: 500px;
	resize: none;
	border-radius: 10px;
	border: none;
}


div.preview_img {
	margin-top: 5px;
	border: solid 2px black;
	width: 300px;
	min-height: 200px;
}

div.preview_imgs span {
	border: solid 2px red;
}

button.cancel {
	margin-top: 20px;
	margin-bottom: 10px;
	border-radius: 10px;
	color: #fff;
	background-color: rgb(206, 40, 41);
	border: none;
	height: 56px;
	padding: 0 30px;
	font-weight: 600;
}

button.check_ok {
	margin-left: 40px;
	margin-bottom: 10px;
	border-radius: 10px;
	color: #fff;
	background-color: rgb(206, 40, 41);
	border: none;
	height: 56px;
	padding: 0 30px;
	font-weight: 600;
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
		<div class="container">
			
			<!-- 要給row,告訴html橫列的範圍 -->
			<div class="row justify-content-center">

				<!-- 給格線範圍,再把元素放進格線範圍裡,左+中間+右=12 -->
				
				<!-- 左邊 -->
				<div class="col-md-2">
				  <c:if test="${not empty errorMsgs}">
	                 <div style="margin-top:90px">
	                 <font style="color:red">請修正以下錯誤:</font>
	                 <ul>
		               <c:forEach var="message" items="${errorMsgs}">
			           <li style="color:red">${message}</li>
		          </c:forEach>
	                 </ul>
	                 </div>
                  </c:if>
					
				
				
				
				</div>
				
				<!-- 中間 -->
				<div class="col-md-7">
					<form class="article" method="post" action="fa.do" name="form1" enctype="multipart/form-data">
					    
					    <p class="p1">會員id</p>
						<input class="res_input" name="userId">
						
						<p class="p1">選擇餐廳</p>
						<input class="res_input" name="restaurantId">

						<p class="p1">標題</p>
						<input class="title_input" type="TEXT" name="articleTitle"
							size="30"
							value="<%=(faVO == null) ? "" : faVO.getArticleTitle()%>" />

						<p class="p1">發表日期</p>
						<input name="articleDate" id="f_date1" type="text">

						<p class="p1">內容</p>

						<textarea class="editor" name="articleContent">
			            <%=(faVO == null) ? "" : faVO.getArticleContent()%>
                        </textarea>

						<input type="hidden" name="sta" size="2" value="1" />
						 								
						<div>
						<button class="btn cancel" id="img_file">選擇圖片</button>
						<input type="file" multiple="true" id="add_file" style="display: none;" name="imgfile" >
						</div>						

<!-- 						<div class="preview_img"> -->
<!-- 							<span class="text">預覽圖</span> -->
<!-- 						</div> -->

						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-5">

								<div>
									<button type="reset" class="cancel">清除</button>
									<button type="submit" class="check_ok">送出</button>
									<input type="hidden" name="action" value="insert">
									
									
								</div>


							</div>


						</div>


						
					</form>
				</div>

				<!-- 右邊 -->
				<div class="col-md-3"></div>
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
	<script src="<%=request.getContextPath()%>/assets/js/isotope.pkgd.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/nice-select.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/fontawesome.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/owl.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/slick-slider.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/tweenmax.min.js"></script>
	
	
	<!-- main js  -->
	<script src="<%=request.getContextPath()%>/assets/js/main.js"></script>		
    <script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.full.js"></script>
	
	
			

<%
	java.sql.Date articleDate = null;
	try {
		articleDate = faVO.getArticleDate();
	} catch (Exception e) {
		articleDate = new java.sql.Date(System.currentTimeMillis());
	  }
%>
<script>
	
	$(document).ready(function() {
        
		/*=========老師的日期控制============*/
		$.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=articleDate%>', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	    });
        
        /*============點擊選擇圖片的button的按鈕會帶到input file性質============*/
        $('#img_file').on("click", function(e){
			$('#add_file').click();
 			return false;
		});
        
        /*===============預覽圖=================*/
        
        var img_file_el = document.getElementById("add_file");
        img_file_el.addEventListener("change",function(e){
//        	var preview_img_el =document.getElementsByClassName("preview_img")[0];
//         	console.log(preview_img_el);
//         	console.log("hello");
 
        	
        	for(let i=0;i<this.files.length;i++){
        		let reader = new FileReader();
        		reader.readAsDataURL(this.files[i]);
        		reader.addEventListener("load",function(){
        			let img_tag = "<div class=\"preview_imgs\">"  +"<img src=" + reader.result +  " \" class=\"XXX\" >"+"</div>";
        			img_file_el.insertAdjacentHTML("afterend", img_tag);
        		})
        		
        	}
        	
        })
        	                                
	});
</script>
</body>

</html>

