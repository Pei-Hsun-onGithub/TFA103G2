<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.address.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  AddressVO addressVO = (AddressVO) request.getAttribute("addressVO"); //AddressServlet.java(Concroller), 存入req的addressVO物件
%>
3
<html>
<head>
<title>員工資料 - listOneAddress.jsp</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - ListOneAddress.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>外送地址編號</th>
		<th>會員編號</th>
		<th>取餐人姓名</th>
		<th>連絡電話</th>
		<th>地址</th>
		<th>大樓</th>
		<th>備註</th>
		<th>狀態</th>
	</tr>
	<tr>
		<td><%=addressVO.getDeliveryAddId()%></td>
		<td><%=addressVO.getUserId()%></td>
		<td><%=addressVO.getCustomerName()%></td>
		<td><%=addressVO.getDeliverPhone()%></td>
		<td><%=addressVO.getDeliverAddress()%></td>
		<td><%=addressVO.getBuildingName()%></td>
		<td><%=addressVO.getNote()%></td>
		<td><%=addressVO.getSta()%></td>
	</tr>
</table>

</body>
</html>