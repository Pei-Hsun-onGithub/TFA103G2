<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.achieveprogress.model.*"%>

<%
  AchieveProgress achieveprogress = (AchieveProgress) request.getAttribute("achieveprogress");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>���N�i�׷s�W - addAchieveProgress.jsp</title>

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
		 <h3>���N�i�׷s�W - addAchieveProgress.jsp</h3></td><td>
		 <h4><a href="<%=request.getContextPath()%>/Gary_pages/select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<h3>��Ʒs�W:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
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
		<td>��ܷ|���s��:</td>
		<td><select size="1" name="userid">
         	<c:forEach var="memberinfo" items="${MemberInfoSvc.all}" > 
          	<option value="${memberinfo.userId}">${memberinfo.userName}
         	</c:forEach>   
       		</select>
		</td>
	</tr>
		<tr>
		<td>��ܦ��N�s��:</td>
		<td><select size="1" name="achiid">
         	<c:forEach var="achieve" items="${AchieveSvc.all}" > 
          	<option value="${achieve.achiId}">${achieve.achiName}
         	</c:forEach>   
       		</select>
		</td>
	</tr>
	<tr>
		<td>��e���O����:</td>
		<td><input type="TEXT" name="currentarticle" size="45"
			 value="<%= (achieveprogress==null)? "" : achieveprogress.getCurrentArticle()%>" /></td>
	</tr>
	<tr>
		<td>��e�q�槹��:</td>
		<td><input type="TEXT" name="currentorder" size="45"
			 value="<%= (achieveprogress==null)? "" : achieveprogress.getCurrentOrder()%>" /></td>
	</tr>
	<tr>
		<td>�}�l�D�Ԥ��:</td>
		<td><input name="begindate" id="date1" type="text"></td>
	</tr>
	<tr>
		<td>���A:</td>
		<td><input type="TEXT" name="sta" size="45"
			 value="<%= (achieveprogress==null)? "" : achieveprogress.getCurrentOrder()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->

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
	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=begindate%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
           //startDate:	            '2017/07/10',  // �_�l��
           //minDate:               '-1970-01-01', // �h������(���t)���e
           //maxDate:               '+1970-01-01'  // �h������(���t)����
        });
        
        
   
        // ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����-----------------------------------------------------------

        //      1.�H�U���Y�@�Ѥ��e������L�k���
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

        
        //      2.�H�U���Y�@�Ѥ��᪺����L�k���
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


        //      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���)
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