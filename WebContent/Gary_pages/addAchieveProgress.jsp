<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.achieveprogress.model.*"%>

<%
  AchieveProgress achieveprogress = (AchieveProgress) request.getAttribute("achieveprogress");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>成就進度新增 - addAchieveProgress.jsp</title>

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
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>成就進度新增 - addAchieveProgress.jsp</h3></td><td>
		 <h4><a href="<%=request.getContextPath()%>/Gary_pages/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<jsp:useBean id="AchieveSvc" scope="page" class="com.achieve.model.AchieveService" />
<jsp:useBean id="MemberInfoSvc" scope="page" class="com.memberinfo.model.MemberInfoService" />

<FORM METHOD="post" ACTION="achieveprogress.do" name="form1">
<table>
	<tr>
		<td>選擇會員編號:</td>
		<td><select size="1" name="userid">
         	<c:forEach var="memberinfo" items="${MemberInfoSvc.all}" > 
          	<option value="${memberinfo.userId}">${memberinfo.userId}
         	</c:forEach>   
       		</select>
		</td>
	</tr>
		<tr>
		<td>選擇成就編號:</td>
		<td><select size="1" name="achiid">
         	<c:forEach var="achieve" items="${AchieveSvc.all}" > 
          	<option value="${achieve.achiId}">${achieve.achiId}
         	</c:forEach>   
       		</select>
		</td>
	</tr>
	<tr>
		<td>當前食記完成:</td>
		<td><input type="TEXT" name="currentarticle" size="45"
			 value="<%= (achieveprogress==null)? "" : achieveprogress.getCurrentArticle()%>" /></td>
	</tr>
	<tr>
		<td>當前訂單完成:</td>
		<td><input type="TEXT" name="currentorder" size="45"
			 value="<%= (achieveprogress==null)? "" : achieveprogress.getCurrentOrder()%>" /></td>
	</tr>
	<tr>
		<td>開始挑戰日期:</td>
		<td><input name="begindate" id="date1" type="text"></td>
	</tr>
	<tr>
		<td>狀態:</td>
		<td><input type="TEXT" name="sta" size="45"
			 value="<%= (achieveprogress==null)? "" : achieveprogress.getCurrentOrder()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<% 
  java.sql.Date begindate = null;
  try {
	    begindate = achieveprogress.getBeginDate();
   } catch (Exception e) {
	    begindate = new java.sql.Date(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Gary_pages/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/Gary_pages/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/Gary_pages/datetimepicker/jquery.datetimepicker.full.js"></script>

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
        $('#date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=begindate%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
        
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
</script>
</html>