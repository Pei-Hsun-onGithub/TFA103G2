<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
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
    <link rel="icon" href="assets/img/fevicon.png">

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
        
        label.guise_imgs {
            display: block ;
            margin-left:5px ;
            height: 30px;
            line-height: 30px;
            width:90px;
            font-weight: 600;
            font-size: 18px;
            border-radius: 10px;
            background-color: rgb(206, 40, 41);
            color:black;
            text-align:center ;
        }
        
        
         div.preview_imgs {
            margin-top: 5px;
            border: solid 2px black;
            width: 300px;
            min-height: 200px;
        }
        
        div.preview_imgs span {
            border:solid 2px red;
            margin:50% 25% 0 25%;
            
        }

        button.cancel{
            margin-top: 20px;
            margin-left: 220px;
            margin-bottom: 10px;
            border-radius: 10px;
            color:#fff;
            background-color: rgb(206, 40, 41);
            border:none;
            height: 56px;
            padding:0 30px;
            font-weight: 600;           
        }

        button.check_ok{
            margin-left: 40px;
            margin-bottom: 10px;
            border-radius: 10px;
            color:#fff;
            background-color: rgb(206, 40, 41);
            border:none;
            height: 56px;
            padding:0 30px;
            font-weight: 600;
        }        
       
    </style>

</head>

<body>

    <header class="navbar-area ">
        <nav class="navbar navbar-expand-lg">
            <div class="container nav-container">
                <div class="responsive-mobile-menu">
                    <button class="menu toggle-btn d-block d-lg-none" data-target="#themefie_main_menu"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-left"></span>
                        <span class="icon-right"></span>
                    </button>
                </div>
                <div class="logo">
                    <a class="main-logo" href="<%=request.getContextPath()%>/home-1.html"><img src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>
                </div>
                <div class="collapse navbar-collapse" id="themefie_main_menu">
                    <ul class="navbar-nav menu-open">
                        <li class="current-menu-item menu-item-has-children">
                            <a href="home-1.html">訂餐</a>
                            <ul class="sub-menu ps-0">
                                <li><a href="<%=request.getContextPath()%>/shop.html">Shop</a></li>
                                <li><a href="<%=request.getContextPath()%>/menu.html">Menu</a></li>
                                <li><a href="<%=request.getContextPath()%>/cart.html">Cart</a></li>
                                <li><a href="<%=request.getContextPath()%>/checkout.html">Checkout</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/blog.html">食記</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/about.html">ABOUT US</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/contact.html">CONTACTS</a>
                        </li>
                    </ul>
                </div>
                <div class="nav-right-part nav-right-part-mobile">
                    <ul>
                        <li><a class="search" href="#"><i class="ri-search-line"></i></a>
                        </li>
                        <li class="phone-contact d-md-block d-none"><i class="ri-phone-fill float-start"></i>
                            +997 509 153 849
                        </li>
                        <li class="menu-cart"><a href="<%=request.getContextPath()%>/cart.html">CART <span>1</span></a></li>
                        <li>49.50 $</li>
                    </ul>
                </div>
                <div class="nav-right-part nav-right-part-desktop">
                    <ul>
                        <li><a class="search" href="#"><i class="ri-search-line"></i></a>
                        </li>
                        <li class="phone-contact">
                            <a href="#">sign in</a>
                        </li>
                        <li class="menu-cart"><a href="#">小鈴鐺 <span>4</span></a></li>
                        <li class="menu-cart"><a href="<%=request.getContextPath()%>/cart.html">CART <span>1</span></a></li>
                        <li>49.50 $</li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    
    <div class="main">
        <form class="article" method="post" action="fa.do" name="form1">

            <p class="p1">選擇餐廳</p>
            <input class="res_input">
            
            <p class="p1" >標題</p>
            <input class="title_input" type="TEXT" name="articleTitle" size="30"
			 value="<%= (faVO==null)? "" : faVO.getArticleTitle()%>" /> 
            
            <p class="p1">發表日期</p>
            <input name="articleDate" id="f_date1" type="text">
            
            <p class="p1">內容</p>
            
            <textarea class="editor" name="articleContent" >
			 <%= (faVO==null)? "" : faVO.getArticleContent()%>
            </textarea>
            
            <input type="hidden" name="sta" size="2"
			 value="1"/>
            
            
        <!--    <button type="reset" class="cancel">清除</button>-->
        <label class="guise_imgs"><input type="file" class="img" style="display:none;" />選擇圖片</label>      
            <div class="preview_imgs">
                <span class="text">預覽圖</span>
            </div>


            <button type="reset" class="cancel">清除</button>
            <button type="submit" class="check_ok">送出</button>
            <input type="hidden" name="action" value="insert">
        </form>
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
    <script src="assets/js/main.js"></script>







</body>

<% 
  java.sql.Date articleDate = null;
  try {
	  articleDate = faVO.getArticleDate();
   } catch (Exception e) {
	   articleDate = new java.sql.Date(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
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
        
        
        
 
        </script>     
</html>

