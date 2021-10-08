<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>vendor_meal_upload</title>
    <!--fivicon icon-->
    <link rel="icon" href="assets/img/fevicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/magnific.min.css">
    <link rel="stylesheet" href="assets/css/jquery-ui.min.css">
    <link rel="stylesheet" href="assets/css/nice-select.min.css">
    <link rel="stylesheet" href="assets/css/owl.min.css">
    <link rel="stylesheet" href="assets/css/slick-slide.min.css">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    <link rel="stylesheet" href="assets/css/remixicon/remixicon.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/responsive.css">

    <!--Google Fonts-->
    <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap" rel="stylesheet">
    <style>
    /*    fix my aside left     */
         /* .my-aside-left-container .widget {
          width: 280px;
          position: fixed;
          top:15%;
          left:3%;
        } */
        div.my-btn-wrapper{
        
        margin-top: 50px;
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
                    <a class="main-logo" href="home-1.html"><img src="assets/img/logo.png" alt="img"></a>
                </div>
                <div class="collapse navbar-collapse" id="themefie_main_menu">
                    <ul class="navbar-nav menu-open">
                        <li class="current-menu-item menu-item-has-children">
                            <a href="home-1.html">訂餐</a>
                            <ul class="sub-menu ps-0">
                                <li><a href="shop.html">Shop</a></li>
                                <li><a href="menu.html">Menu</a></li>
                                <li><a href="cart.html">Cart</a></li>
                                <li><a href="checkout.html">Checkout</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="blog.html">食記</a>
                        </li>
                        <li>
                            <a href="about.html">ABOUT US</a>
                        </li>
                        <li>
                            <a href="contact.html">CONTACTS</a>
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
                        <li class="menu-cart"><a href="cart.html">CART <span>1</span></a></li>
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
                        <li class="menu-cart"><a href="cart.html">CART <span>1</span></a></li>
                        <li>49.50 $</li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="shop-details-area pd-top-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-3">
                    <div class="my-aside-left-container">

                        <div class="widget widget_categories style-2">
                            <h4 class="widget-title">Categories</h4>
                                <ul>
                                    <li><a href="#"><img src="assets/img/category/1.png" alt="img"> Ramen <span>(5)</span></a></li>
                                    <li><a href="#"><img src="assets/img/category/2.png" alt="img"> Pizza <span>(9)</span> </a></li>
                                    <li><a href="#"><img src="assets/img/category/3.png" alt="img"> 商品上架 <span>(18)</span></a></li>
                                    <li><a href="#"><img src="assets/img/category/4.png" alt="img"> French fries <span>(14)</span></a></li>
                                    <li><a href="#"><img src="assets/img/category/5.png" alt="img"> Fast food <span>(10)</span></a></li>
                                    <li><a href="#"><img src="assets/img/category/6.png" alt="img"> Soft drinks <span>(28)</span></a></li>
                                </ul>
                        </div>
                    </div>
                    
                </div>
                <div class="col-md-9">
                    <div class="bill-payment-wrap">
                        <h5>餐點資料
                        </h5>
                        <form class="default-form-wrap style-2">
                            <div class="row">
                                <div class="row">
                                    <div class="col-md-8">
                                        <label>商品名稱</label>
                                        <div class="single-input-wrap">
                                            <input type="text" class="form-control" placeholder="Type Your Country">
                                        </div>
                                    </div>
    
                                    <div class="col-md-4">
                                        <label>商品類型</label>
                                            <div class="single-input-wrap">
                                                <select class=" myclass-select" id="inputGroupSelect01">
                                                    <option selected>Choose...</option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                  </select>
                                            </div>
                                        
                                    </div>

                                </div>
                               

                                
                                <div class="row">
                                    <div class="col-md-8">
                                        <label>價格</label>
                                        <div class="single-input-wrap">
                                            <input type="text" class="form-control" placeholder="Type Your Country">
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <label>上架天數</label>
                                        <div class="single-input-wrap">
                                            <select class=" myclass-select" id="inputGroupSelect01">
                                                <option selected>Choose...</option>
                                                <option value="1">One</option>
                                                <option value="2">Two</option>
                                                <option value="3">Three</option>
                                              </select>
                                        </div>
                                    </div>

                                </div>
                              
                                <div class="col-md-12">
                                    <label>上架日期</label>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="single-input-wrap">
                                                <select class=" myclass-select2" id="inputGroupSelect01">
                                                    <option selected>Choose...</option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                  </select>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="single-input-wrap">
                                                <select class=" myclass-select2" id="inputGroupSelect01">
                                                    <option selected>Choose...</option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                  </select>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="single-input-wrap">
                                                <select class=" myclass-select2" id="inputGroupSelect01">
                                                    <option selected>Choose...</option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                  </select>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div>
                                    <label>圖片上傳</label>
                                    <div>
                                        <input type="file" class="form-control" >
                                    </div>
                                </div>
                        
                                <div class="col-md-12">
                                    <label>商品介紹</label>
                                    <div class="col-md-12">
                                        <div class="single-textarea-wrap">
                                            <textarea rows="4" placeholder="商品介紹..."></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">

                                    <div class="row my-btn-wrapper">
                                        <div class="col-md-2">
                                        </div>
                                        <div class="col-md-4">
                                            <button type="button" class="btn btn-base" id="btn_submit">確認</button>
                                        </div>
                                        <div class="col-md-4">
                                            <button type="reset" class="btn btn-base">重填</button>
                                        </div>
                                        <div class="col-md-2">
                                        </div>
                                       
                                    </div>
                                </div>
                                
                               
                            </div>
                        </form>
                    </div>  
                </div>
            </div>
        </div>
    </div>

  <!-- all plugins here -->
  <script src="assets/js/jquery.3.6.min.js"></script>
  <script src="assets/js/jquery-ui.min.js"></script>
  <script src="assets/js/bootstrap.min.js"></script>
  <script src="assets/js/imageloded.min.js"></script>
  <script src="assets/js/counterup.js"></script>
  <script src="assets/js/waypoint.js"></script>
  <script src="assets/js/magnific.min.js"></script>
  <script src="assets/js/isotope.pkgd.min.js"></script>
  <script src="assets/js/nice-select.min.js"></script>
  <script src="assets/js/fontawesome.min.js"></script>
  <script src="assets/js/owl.min.js"></script>
  <script src="assets/js/slick-slider.min.js"></script>
  <script src="assets/js/wow.min.js"></script>
  <script src="assets/js/tweenmax.min.js"></script>
  <!-- main js  -->
  <script src="assets/js/main.js"></script>
</body>
</html>