<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.memberinfo.model.*"%>
<%@ page import="java.util.* ,com.orderlist.controller.Cart"%>
<%@ page import="com.card.model.*" %>
<%@ page import="com.address.model.*" %>
<%@ page import="com.memberinfo.model.*" %>

<%
	Integer userId = (Integer) session.getAttribute("userId");

	AddressService addressSvc = new AddressService();
	Set<AddressVO> addressList = addressSvc.getAddressByUserId(userId);
	pageContext.setAttribute("addressList",addressList); 	
    
    MemberInfoService memberSvc = new MemberInfoService();
	MemberInfo memberVO = memberSvc.getOneMemberInfo(userId);
	
	CardDAOService cardSvc = new CardDAOService();
	Set<CardVO> list = cardSvc.getCardByUserId(userId);
	pageContext.setAttribute("list",list); 
%>


<%
 MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Login-long</title>
<!--fivicon icon-->
<link rel="icon"
 href="<%=request.getContextPath()%>/assets/img/Image4.png">

<!-- Stylesheet -->
<link rel="stylesheet"  href="<%=request.getContextPath()%>/assets/css/animate.min.css">
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
<link rel="stylesheet"
 href=https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap>

<%@ include file="/assets/webPageSnippet/cssSnippet_navbar_home_1.jsp" %>

</head>

<body class='sc5'>
	<%
		@SuppressWarnings("unchecked")
		Vector<Cart> buylist = (Vector<Cart>) session.getAttribute("shoppingcart");
	%>

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

 <!-- navbar start -->
 <%@ include file="/assets/webPageSnippet/navbarSnippet_navbar_home_2.jsp" %> 
 <!-- navbar end -->

  <!-- checkout area start -->
    <div class="checkout-area pd-top-120 pd-bottom-120">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="bill-payment-wrap">
                        <h5>Billing details
                        </h5>
<!--                         <form class="default-form-wrap style-2" action="CheckoutServlet" method="post"> -->
                            <div class="row">
                                <div class="col-md-6">
                                    <label> Name</label>
                                    <div class="single-input-wrap">
                                        <input type="text" class="form-control" value="<%=memberVO.getUserName()%>">
                                        <input type="hidden" class="form-control" name="userId" value="<%=memberVO.getUserId()%>">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <label>Street address</label>
                                    <select class="form-select myselect" name="deliveryAddId" required>
                                        	<option value="" >請選擇地址</option>
											 <c:forEach var="addressVO" items="${addressList}"> 
          									<option value="${addressVO.deliveryAddId}">${addressVO.deliverAddress}
       										 </c:forEach>   
									</select>
                                </div>
                                <div class="col-md-12">
                                    
                      <jsp:useBean id="CardSvc" scope="page" class="com.card.model.CardDAOService" />              
                                        <label>Credit Cart </label>
                                        <select class="form-select myselect" name="cardId" required>
                                        	<option value="" >請選擇信用卡</option>
											 <c:forEach var="cardVO" items="${list}"> 
          									<option value="${cardVO.cardId}" ${(memberVO.restaurantId==resVO.restaurantId)? 'selected':'' }  >${cardVO.cardNumber}
       										 </c:forEach>   
										</select>
										
                                  </div>
                                <input type="submit" class="btn btn-secondary w-100" value="PLACE ORDER" />
                                <input type="hidden" name="action" value="insert"/>
                            </div>                      
                    </div>                    
                </div>
                <div class="col-lg-5">
                    <div class="order-area">
                        <h5 class="title">Your order</h5>
                        <div class="order-product" style="align-items: center;text-align: center">
                            <div class="thumb" style="width:90px">
                                <h6></h6>
                            </div>
                            <div class="thumb" style="width:150px">
                                <h6>產品</h6>
                            </div>
                            <div class="thumb" style="width:80px">
                                <h6>數量</h6>
                            </div>
                            <div class="thumb">
                                <h6>價格</h6>
                            </div>
                        </div>
					<%
									for (int index = 0; index < buylist.size(); index++) {
											Cart order = buylist.get(index);
								%>
                        <div class="order-product" style="align-items: center;text-align: center">
                            <div class="thumb">
                                <img src="<%=request.getContextPath()%>/CartImageUtil?Id=<%=order.getMealId()%>" alt="img">
                            </div>
                            <div class="thumb" style="width:90px;">
                                <h6><%=order.getMealName()%></h6>
                                <input type="hidden" name="mealName" value="<%=order.getMealName()%>">
                            </div>
                            <div class="thumb" style="width:80px">
                                <h6><%=order.getQuantity()%></h6>
                                <input type="hidden" name="quantity" value="<%=order.getQuantity()%>">
                            </div>
                            <div class="thumb">
                                <h6><%=order.getUnitPrice()%></h6>
                                <input type="hidden" name="unitPrice" value="<%=order.getUnitPrice()%>">
                            </div>
                        </div>
<!--                         </form> -->
                        <%}%>
                        <ul class="amount">
                        
                        								
		<%							if (buylist != null && (buylist.size() > 0)) {				
									int itemUnitPrice, itemQuantity, amount, resultAmount = 0;
									
									for (int index = 0; index < buylist.size(); index++) {
										Cart order = buylist.get(index);

										itemUnitPrice = order.getUnitPrice();
										itemQuantity = order.getQuantity();
										amount = (itemUnitPrice * itemQuantity);
										resultAmount += amount;
		%>					
								<li><%=order.getMealName()%><span>$<%=amount%>
								</span></li>
								<%}%>
								<li class="total">Total<span>$<%=resultAmount%></span></li>
								<%}%>
                        </ul>     
                    </div>                
                </div>
            </div>
        </div>
    </div>
    <!-- checkout area end -->


 
<!-- footer area start -->
	<%@ include file="/assets/webPageSnippet/footerSnippet_home.jsp" %>
<!-- footer area end -->
 
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