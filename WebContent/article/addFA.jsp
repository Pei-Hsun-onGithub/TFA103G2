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
<title>add FoodArticle</title>

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
	<tr><td>
		 <h3>文章新增 - addFA.jsp</h3></td><td>
		 <h4><a href="select_pageFA.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>文章新增:</h3>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="fa.do" name="form1">
<table>
	<tr>
		<td>會員id:</td>
		<td><input type="TEXT" name="userId" size="45" 
			 value="<%= (faVO==null)? "" : faVO.getUserId()%>" /></td>
	</tr>
	<tr>
		<td>餐廳id:</td>
		<td><input type="TEXT" name="restaurantId" size="45"
			 value="<%= (faVO==null)? "" : faVO.getRestaurantId()%>" /></td>
	</tr>
	<tr>
		<td>標題:</td>
		<td><input type="TEXT" name="articleTitle" size="45"
			 value="<%= (faVO==null)? "" : faVO.getArticleTitle()%>" /></td>
	</tr>
	<tr>
		<td>日期:</td>
		<td><input name="articleDate" id="f_date1" type="text"></td>
	</tr>
	<tr>
		<td>內容:</td>
		<td><input type="TEXT" name="articleContent" size="50"
			 value="<%= (faVO==null)? "" : faVO.getArticleContent()%>" /></td>
	</tr>
	
	<tr>
		<td>狀態:</td>
		<td><input type="TEXT" name="sta" size="10"
			 value="<%= (faVO==null)? "" : faVO.getSta()%>" /></td>
	</tr>
	
	

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>



</body>

<% 
  java.sql.Date articleDate = null;
  try {
	  articleDate = faVO.getArticleDate();
   } catch (Exception e) {
	   articleDate = new java.sql.Date(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

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

