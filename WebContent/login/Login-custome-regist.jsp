<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.memberinfo.model.*"%>

<%
<<<<<<< HEAD
	MemberInfo memberlnfo = (MemberInfo) request.getAttribute("memberinfo");
=======
	MemberInfo memberinfo = (MemberInfo) request.getAttribute("memberinfo");
	MemberInfo memberinfo2 = (MemberInfo) request.getAttribute("memberinfo2");
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="BIG5">
<title>Login-custom-register</title>
<!--fivicon icon-->
<<<<<<< HEAD
<link rel="icon" href="assets/img/fevicon.png">
=======
<link rel="icon"
	href="<%=request.getContextPath()%>/assets/img/Image4.png">
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067

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
<<<<<<< HEAD
=======
	
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
<!-- new css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/Login-custome.css">

<!--Google Fonts-->
<<<<<<< HEAD
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@300;400;500;600;700;800&family=Bebas+Neue&family=Satisfy&family=Quattrocento:wght@400;700&display=swap"
	rel="stylesheet">
=======
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
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067

</head>

<body class='sc5'>

	<!-- navbar start -->
	<header class="navbar-area">
		<nav class="navbar navbar-expand-lg">
			<div class="container nav-container">
				<div class="logo">
<<<<<<< HEAD
					<a class="main-logo" href="home-1.html"><img
						src=<%=request.getContextPath()%> /assets/img/logo.png alt="img"></a>
=======
					<a class="main-logo" 
					href="<%=request.getContextPath()%>/home-1.html"><img
						src="<%=request.getContextPath()%>/assets/img/logo.png"></a>
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
				</div>
			</div>
		</nav>
	</header>
	<!-- navbar end -->

	<div class="body">
		<FORM METHOD="post" ACTION="memberinfo.do" name="form1">

			<table>
				<tr>
					<td class="td1">�|�����U</td>
					<td><input type="hidden" size="45" /></td>
				</tr>
				<tr>
					<td class="td1">�q�l�l��:</td>
					<td><input type="TEXT" name="email" size="45"
<<<<<<< HEAD
						value="<%= (memberlnfo==null)? "xxxx@xxxx.com" : memberlnfo.getEmail()%>" /></td>
=======
						value="<%=(memberinfo == null) ? "xxxx@xxxx.com" : memberinfo.getEmail()%>" /></td>
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
				</tr>
				<tr>
					<td class="td1">�K�X:</td>
					<td><input type="password" name="pwd" size="45"
<<<<<<< HEAD
						value="<%= (memberlnfo==null)? "" : memberlnfo.getPwd()%>" /></td>
=======
						value="<%=(memberinfo == null) ? "1qazZXCV@" : memberinfo.getPwd()%>" /></td>
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
				</tr>
				<tr>
					<td class="td1">�ЦA����J�K�X:</td>
					<td><input type="password" name="pwd2" size="45"
<<<<<<< HEAD
						value="<%= (memberlnfo==null)? "" : memberlnfo.getPwd()%>" /></td>
=======
						value="<%=(memberinfo2 == null) ? "1qazZXCV@" : memberinfo2.getPwd()%>" /></td>
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
				</tr>
				<tr>
				<tr>
					<td class="td1">�m�W:</td>
					<td><input type="TEXT" name="userName" size="45"
<<<<<<< HEAD
						value="<%= (memberlnfo==null)? "" : memberlnfo.getUserName()%>" /></td>
=======
						value="<%=(memberinfo == null) ? "�����Z" : memberinfo.getUserName()%>" /></td>
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
				</tr>
				<tr>
					<td class="td1">�ʧO:</td>
					<td><input type="TEXT" name="gender" size="45"
<<<<<<< HEAD
						value="<%= (memberlnfo==null)? "" : memberlnfo.getGender()%>" /></td>
				</tr>
				<tr>
					<td class="td1">�X�ͤ��:</td>
					<td><input name="birthday" id="f_date1" type="date"></td>
=======
						value="<%=(memberinfo == null) ? "�k" : memberinfo.getGender()%>" /></td>
				</tr>
				<tr>
					<td class="td1">�X�ͤ��:</td>
					<td><input name="birthday" id="f_date1" type="TEXT"></td>
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
				</tr>
				<tr>
					<td class="td1">���:</td>
					<td><input type="TEXT" name="phone" size="45"
<<<<<<< HEAD
						value="<%= (memberlnfo==null)? "" : memberlnfo.getPhone()%>" /></td>
=======
						value="<%=(memberinfo == null) ? "0987678567" : memberinfo.getPhone()%>" /></td>
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
				</tr>
			</table>
			<br> <input type="hidden" name="action" value="insert">
			<input type="submit" value="�ӽз|��">
		</FORM>
	</div>

	<%-- ���~��C --%>
<<<<<<< HEAD
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<% 
  java.sql.Date birthday = null;
  try {
	  birthday = memberlnfo.getBirthday();
   } catch (Exception e) {
	   birthday = new java.sql.Date(System.currentTimeMillis());
   }
%>
	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
	<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

	<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

	<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=birthday%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
           //startDate:	            '2017/07/10',  // �_�l��
           //minDate:               '-1970-01-01', // �h������(���t)���e
           //maxDate:               '+1970-01-01'  // �h������(���t)����
        });
        
        
</script>
=======
	
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>




>>>>>>> e2416d499340288b1e43976d39b976a4e6802067
	<!-- all plugins here -->
	<script src="<%=request.getContextPath()%>/assets/js/jquery.3.6.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/imageloded.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/counterup.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/waypoint.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/magnific.min.js"></script>
<<<<<<< HEAD
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

=======
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
	
	<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->
<script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/vendors/datetimepicker/jquery.datetimepicker.full.js"></script>
<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:false,       //timepicker:true,
 	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=birthday%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
           //startDate:	            '2017/07/10',  // �_�l��
           //minDate:               '-1970-01-01', // �h������(���t)���e
           maxDate:               '<%=birthday%>'  // �h������(���t)����
        });

        
</script>
>>>>>>> e2416d499340288b1e43976d39b976a4e6802067



</body>
</html>