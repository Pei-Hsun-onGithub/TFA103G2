<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.memberinfo.model.*"%>

<%
 MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberInfo");
 MemberInfo memberinfo2 = (MemberInfo) request.getAttribute("memberInfo2");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="UTF-8">
<title>Login-vendor-register</title>
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
 
<!-- new css -->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/assets/css/Login-custome.css">

<!--Google Fonts-->
<link rel="stylesheet"
 href=https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.css" />
<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
 width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
 height: 151px; /* height:  151px; */
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

 <!-- navbar start -->
 <header class="navbar-area">
  <nav class="navbar navbar-expand-lg">
   <div class="container nav-container">
    <div class="logo">
     <a class="main-logo" 
     href="<%=request.getContextPath()%>/login/Login-login.jsp"><img
      src="<%=request.getContextPath()%>/assets/img/logo.png"></a>
    </div>
   </div>
  </nav>
 </header>
 <!-- navbar end -->

 <div class="body">
  <FORM METHOD="post" ACTION="memberinfo.do" name="form1">

   <table>
    <tr>
     <td class="td1">廠商註冊</td>
     <td><input type="hidden" size="45" /></td>
    </tr>
    <tr>
     <td class="td1">電子郵件:</td>
     <td><input type="TEXT" name="email" size="45"
      value="<%=(memberinfo == null) ? "xxxx@xxxx.com" : memberinfo.getEmail()%>" /></td>
    </tr>
    <tr>
     <td class="td1">密碼:</td>
     <td><input type="password" name="pwd" size="45"
      value="<%=(memberinfo == null) ? "1qazZXCV@" : memberinfo.getPwd()%>" /></td>
    </tr>
    <tr>
     <td class="td1">請再次輸入密碼:</td>
     <td><input type="password" name="pwd2" size="45"
      value="<%=(memberinfo2 == null) ? "1qazZXCV@" : memberinfo2.getPwd()%>" /></td>
    </tr>
    <tr>
    <tr>
     <td class="td1">姓名:</td>
     <td><input type="TEXT" name="userName" size="45"
      value="<%=(memberinfo == null) ? "金城武" : memberinfo.getUserName()%>" /></td>
    </tr>
    <tr>
     <td class="td1">性別:</td>
     <td><input type="TEXT" name="gender" size="45"
      value="<%=(memberinfo == null) ? "男" : memberinfo.getGender()%>" /></td>
    </tr>
    <tr>
     <td class="td1">出生日期:</td>
     <td><input name="birthday" id="f_date1" type="TEXT"></td>
    </tr>
    <tr>
     <td class="td1">手機:</td>
     <td><input type="TEXT" name="phone" size="45"
      value="<%=(memberinfo == null) ? "0987678567" : memberinfo.getPhone()%>" /></td>
    </tr>
   </table>
   <br> <input type="hidden" name="action" value="insert2">
   <input type="submit" value="申請會員">
  </FORM>
 </div>

 <%-- 錯誤表列 --%>

<c:if test="${not empty errorMsgs}">
 <font style="color:red">請修正以下錯誤:</font>
 <ul>
  <c:forEach var="message" items="${errorMsgs}">
   <li style="color:red">${message}</li>
  </c:forEach>
 </ul>
</c:if>


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
 
 <script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.js"></script>
 <script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.full.js"></script>


<%  
  java.sql.Date birthday = null;
   try {
    birthday = memberinfo.getBirthday();
   } catch (Exception e) {
    birthday = new java.sql.Date(System.currentTimeMillis());
   }
 %>
 
 <!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
<script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.full.js"></script>
<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
         timepicker:false,       //timepicker:true,
         step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
         format:'Y-m-d',         //format:'Y-m-d H:i:s',
      value: '<%=birthday%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:             '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           maxDate:               '<%=birthday%>'  // 去除今日(不含)之後
        });

        
</script>



</body>
</html>