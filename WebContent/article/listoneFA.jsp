<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.foodarticle.model.*"%>

<%
  FoodArticleVO faVO = (FoodArticleVO) request.getAttribute("faVO"); //FoodArticleServlet.java(Concroller), 存入req的faVO物件
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章 listoneFA.jsp</title>

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
<body bgcolor='lightblue'>

<table id="table-1">
	<tr><td>
		 <h3>文章 - listoneFA.jsp</h3>
		 <h4><a href="select_pageFA.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>文章編號</th>
		<th>會員id</th>
		<th>餐廳id</th>
		<th>標題</th>
		<th>日期</th>
		<th>內容</th>
		<th>狀態</th>
	</tr>
	<tr>
		<td><%=faVO.getArticleNo()%></td>
		<td><%=faVO.getUserId()%></td>
		<td><%=faVO.getRestaurantId()%></td>
		<td><%=faVO.getArticleTitle()%></td>
		<td><%=faVO.getArticleDate()%></td>
		<td><%=faVO.getArticleContent()%></td>
		<td><%=faVO.getSta()%></td>
	</tr>
</table>

</body>
</html>