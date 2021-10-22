<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodArticle Home</title>

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
<body bgcolor='lightblue'>

<table id="table-1">
   <tr><td><h3>FoodArticle: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for FoodArticle: Home</p>

<h3>文章查詢:</h3>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}" >
			<li style="color:red">${message}</li>
		</c:forEach>
	
	</ul>

</c:if>

<ul>
  
  <li><a href="<%=request.getContextPath()%>/article/fa.do?action=getAll" >List</a> all article.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="fa.do" >
        <b>輸入文章編號 :</b>
        <input type="text" name="articleNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="faSvc" scope="page" class="com.foodarticle.model.FoodArticleService" />
   
  <li>
     <FORM METHOD="post" ACTION="fa.do" >
       <b>輸入文章編號:</b>
       <select size="1" name="articleNo">
         <c:forEach var="faVO" items="${faSvc.all}" > 
          <option value="${faVO.articleNo}">${faVO.articleNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  
</ul>


<h3>文章管理</h3>

<ul>
  <li><a href='addFA.jsp'>Add</a> a new FoodArticle.</li>
</ul>

</body>
</html>