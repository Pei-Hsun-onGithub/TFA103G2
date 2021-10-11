<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.foodarticle.model.*"%>

<%
	FoodArticleVO faVO = (FoodArticleVO) request.getAttribute("faVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�峹�ק� updateFA.jsp</title>
<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>


</head>
<body bgcolor='lightblue'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�峹�ק� - updateFA.jsp</h3>
				<h4>
					<a href="select_pageFA.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>�峹�ק�:</h3>
	
	<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}" >
			<li style="color:red">${message}</li>
		</c:forEach>
	
	</ul>

</c:if>

	<FORM METHOD="post" ACTION="fa.do" name="form1">
	

		<table>
			<tr>
				<td>�峹�s��:<font color=red><b>*</b></font></td>
				<td><%=faVO.getArticleNo()%></td>
			</tr>

			<tr>
				<td>�|��id:</td>
				<td><input type="TEXT" name="userId" size="45"
					value="<%=faVO.getUserId()%>" /></td>
			</tr>
			<tr>
				<td>�\�Uid:</td>
				<td><input type="TEXT" name="restaurantId" size="45"
					value="<%=faVO.getRestaurantId()%>" /></td>
			</tr>
			<tr>
				<td>���D:</td>
				<td><input type="TEXT" name="articleTitle" size="45"
					value="<%=faVO.getArticleTitle()%>" /></td>
			</tr>
			<tr>
				<td>���:</td>
				<td><input name="articleDate" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>���e:</td>
				<td><input type="TEXT" name="articleContent" size="50"
					value="<%=faVO.getArticleContent()%>" /></td>
			</tr>

			<tr>
				<td>���A:</td>
				<td><input type="TEXT" name="sta" size="10"
					value="<%=faVO.getSta()%>" /></td>
			</tr>



		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="articleNo" value="<%=faVO.getArticleNo()%>">
		<input type="submit" value="�e�X�ק�">
	</FORM>



</body>

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
 	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=faVO.getArticleDate()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
           //startDate:	            '2017/07/10',  // �_�l��
           //minDate:               '-1970-01-01', // �h������(���t)���e
           //maxDate:               '+1970-01-01'  // �h������(���t)����
        });
        </script>
</html>