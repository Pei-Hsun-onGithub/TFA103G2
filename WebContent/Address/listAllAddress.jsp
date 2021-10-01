<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.address.model.*"%>


<%
	AddressDAO dao = new AddressDAO();
	List<AddressVO> list = dao.getAll();
    pageContext.setAttribute("list",list);   
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�Ҧ����u��� - listAllAddress_byDAO.jsp</title>

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
<body bgcolor='white'>

<h4>�����m�߱ĥ� EL ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�Ҧ����u��� - listAllAddress_byDAO.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/address/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<%-- ���~���C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		<th>�~�e�a�}�s��</th>
		<th>�|���s��</th>
		<th>���\�H�m�W</th>
		<th>�s���q��</th>
		<th>�a�}</th>
		<th>�j�ӦW��</th>
		<th>�Ƶ�</th>
		<th>���A</th>
	</tr>
	
	<%@ include file="page\page1.file" %> 
	
	<c:forEach var="AddressVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
	
		<tr>
			<td>${AddressVO.deliveryAddId}</td>
			<td>${AddressVO.userId}</td>
			<td>${AddressVO.customerName}</td>
			<td>${AddressVO.deliverPhone}</td>
			<td>${AddressVO.deliverAddress}</td>
			<td>${AddressVO.buildingName}</td>
			<td>${AddressVO.note}</td>
			<td>${AddressVO.sta}</td>
						<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/address/address.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="deliveryAddId"  value="${AddressVO.deliveryAddId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/address/address.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�R��">
			     <input type="hidden" name="deliveryAddId"  value="${AddressVO.deliveryAddId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="page\page2.file" %>
</body>
</html>