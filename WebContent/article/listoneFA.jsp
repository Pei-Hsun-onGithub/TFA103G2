<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.foodarticle.model.*"%>

<%
  FoodArticleVO faVO = (FoodArticleVO) request.getAttribute("faVO"); //FoodArticleServlet.java(Concroller), �s�Jreq��faVO����
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�峹 listoneFA.jsp</title>

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
		 <h3>�峹 - listoneFA.jsp</h3>
		 <h4><a href="select_pageFA.jsp">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�峹�s��</th>
		<th>�|��id</th>
		<th>�\�Uid</th>
		<th>���D</th>
		<th>���</th>
		<th>���e</th>
		<th>���A</th>
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