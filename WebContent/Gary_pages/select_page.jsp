<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="com.achieveprogress.model.*" %>
<%@ page import="com.memberinfo.model.*" %>
<%@ page import="com.achieve.model.*" %>

<html>
<head>
<title>FoodMonster ���N�i��: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>FoodMonster ���N�i��: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for FoodMonster ���N�i��: Home</p>

<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='<%=request.getContextPath()%>/Gary_pages/listAllAchieveProgress.jsp'>�C�X</a> �Ҧ� ���N�i��.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="achieveprogress.do" >
        <b>��J�|���s�� (�Ʀr):</b>
        <input type="text" name="userid">
        <b>��J���N�s�� (�Ʀr):</b>
        <input type="text" name="achiid">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="AchieveSvc" scope="page" class="com.achieve.model.AchieveService" />
  <jsp:useBean id="MemberInfoSvc" scope="page" class="com.memberinfo.model.MemberInfoService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Gary_pages/achieveprogress.do" >
       <b>��ܷ|���s��:</b>
       <select size="1" name="userid">
         <c:forEach var="memberinfo" items="${MemberInfoSvc.all}" > 
          <option value="${memberinfo.userId}">${memberinfo.userId}
         </c:forEach>   
       </select>
       <b>��ܦ��N�s��:</b>
       <select size="1" name="achiid">
         <c:forEach var="achieve" items="${AchieveSvc.all}" > 
          <option value="${achieve.achiId}">${achieve.achiId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
</ul>


<h3>���N�i�׺޲z</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/Gary_pages/addAchieveProgress.jsp'>�s�W</a> �@���s�����N�i��.</li>
</ul>

</body>
</html>