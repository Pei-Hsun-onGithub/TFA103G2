<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.address.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
  AddressVO addressVO = (AddressVO) request.getAttribute("addressVO"); //AddressServlet.java(Concroller), �s�Jreq��addressVO����
%>
3
<html>
<head>
<title>���u��� - listOneAddress.jsp</title>

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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>���u��� - ListOneAddress.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�~�e�a�}�s��</th>
		<th>�|���s��</th>
		<th>���\�H�m�W</th>
		<th>�s���q��</th>
		<th>�a�}</th>
		<th>�j��</th>
		<th>�Ƶ�</th>
		<th>���A</th>
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