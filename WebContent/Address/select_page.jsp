<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="com.address.model.*" %>

<html>
<head>
<title>IBM Address: Home</title>

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
   <tr><td><h3>IBM Address: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Address: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='<%=request.getContextPath()%>/address/listAllAddress.jsp'>List</a> all Address.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/address/Address.do" >
        <b>請輸入外送地址編號 (如1):</b>
        <input type="text" name="deliveryAddId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>
  
<jsp:useBean id="AddressSvc" scope="page" class="com.address.model.AddressService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/address/address.do" >
       <b>選擇會員編號:</b>
       <select size="1" name="address">
         <c:forEach var="addressVO" items="${AddressSvc.all}" > 
          <option value="${addressVO.deliveryAddId}">${addressVO.deliveryAddId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
<!--   <li> -->
<%--      <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Address/address.do" > --%>
<!--        <b>選擇員工姓名:</b> -->
<!--        <select size="1" name="deliveryAddId"> -->
<%--          <c:forEach var="AddressVO" items="${AddressSvc.all}" >  --%>
<%--           <option value="${AddressVO.deliveryAddId}">${AddressVO.ename} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="送出"> -->
<!--      </FORM> -->
<!--   </li> -->
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/address/addAddress.jsp'>Add</a> a new Address.</li>
</ul>

</body>
</html>