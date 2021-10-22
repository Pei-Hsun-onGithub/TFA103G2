<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.foodarticle.model.*"%>


<%
    FoodArticleService faSvc = new FoodArticleService();
    List<FoodArticleVO> list = faSvc.getall();
    pageContext.setAttribute("list",list);        
    
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodArticle</title>

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
	width: 800px;
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
		 <h3>�峹�C�� - listAllFA.jsp</h3>
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
		<th>�ק�</th>
		<th>�R��</th>
		
	</tr>
	<%@ include file="/article/page1.file" %> 
	<c:forEach var="faVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${faVO.articleNo}</td>
			<td>${faVO.userId}</td>
			<td>${faVO.restaurantId}</td>
			<td>${faVO.articleTitle}</td>
			<td>${faVO.articleDate}</td>
			<td>${faVO.articleContent}</td> 
			<td>${faVO.sta}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/article/fa.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="articleNo"  value="${faVO.articleNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/article/fa.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�R��">
			     <input type="hidden" name="articleNo"  value="${faVO.articleNo}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="/article/page2.file" %>


</body>
</html>