<%@page import="com.monsterbook.model.MonsterBookService"%>
<%@page import="com.memberinfo.model.MemberInfoService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap" rel="stylesheet">

  <link href="https://fonts.googleapis.com/css?family=Source+Serif+Pro:400,600&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/vendors/carousel15/fonts/icomoon/style.css">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/vendors/carousel15/css/owl.carousel.min.css">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/vendors/carousel15/css/bootstrap.min.css">

  <!-- Style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/vendors/carousel15/css/style.css">

  <title>MonsterChoose</title>

  <style>
    div.my-container {

      padding-top: 0px;
      padding-bottom: 0px;
      position: relative;
    }

    button.my-modal-trigger-btn {
      position: absolute;
      z-index: 1;
      left: 71%;
      bottom: 15%;
    }

    div.my-main-choose-window-container {

      width: 1110px;
      height: 400px;
    }

    div.my-main-choose-window {
      width: 800px;
      height: 450px;
      margin-left: 350px;
      margin-right: 100px;
      margin-bottom: 13px;
      border: hidden;
    }

    div.my-main-choose-window img.my-main-img {

      width: 400px;
      height: 350px;
    }

    div.modal form img.my-modal-img {
       margin-left: 100px; 
       width: 250px; 
       height: 200px; 

    }
  </style>
</head>

<body>

	<%
		Integer userId = (Integer) session.getAttribute("userId");

		MemberInfoService memInfoSvc = new MemberInfoService();
		
		MonsterBookService monsterBookSvc = new MonsterBookService();
	%>

  <div class="content my-container">

    <div class="container">

      <h1 class="my-5 text-center">?????????????????????!</h1>
      <div class="slider-92911">
        <div class="owl-carousel slide-one-item">

		<!-- ???????????????  ?????? -->
          <div class="d-md-flex testimony-29101 align-items-stretch my-main-choose-window-container" data-monster="1">
            <div class="card mb-3 my-main-choose-window">
              <div class="row g-0">
                <div class="col-md-8">
                  <img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("1").getMonsterId()  %>" class="img-fluid rounded-start my-main-img" alt="...">
<%--                   <img src="<%=request.getContextPath()%>/images/m1.svg" class="img-fluid rounded-start my-main-img" alt="..."> --%>
                </div>
                <div class="col-md-4">
                  <div class="card-body">
                    <h3><%=  monsterBookSvc.getFirstMonsterNumber("1").getMonsterName() %></h3>
                    <br>
                    <h4 class="card-text"><%= monsterBookSvc.getFirstMonsterNumber("1").getMonsterAbility() %></h4>
                    <br>
                    <h5 class="card-text">LV <%= monsterBookSvc.getFirstMonsterNumber("1").getMinDemandLevel() %></h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
       <!-- ???????????????  ?????? -->


	   <!-- ???????????????  ?????? -->
          <div class="d-md-flex testimony-29101 align-items-stretch my-main-choose-window-container" data-monster="2">
            <div class="card mb-3 my-main-choose-window">
              <div class="row g-0">
                <div class="col-md-8">
                  <img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("2").getMonsterId()  %>" class="img-fluid rounded-start my-main-img" alt="...">
<%--                   <img src="<%=request.getContextPath()%>/images/qfe.jpg" class="img-fluid rounded-start my-main-img" alt="..."> --%>
                </div>
                <div class="col-md-4">
                  <div class="card-body">
                    <h3><%=  monsterBookSvc.getFirstMonsterNumber("2").getMonsterName() %></h3>
                    <br>
                    <h4 class="card-text"><%= monsterBookSvc.getFirstMonsterNumber("2").getMonsterAbility() %></h4>
                    <br>
                    <h5 class="card-text">LV <%= monsterBookSvc.getFirstMonsterNumber("2").getMinDemandLevel() %></h5>
                  </div>
                </div>
              </div>
            </div>
          </div> 

 	<!-- ???????????????  ?????? -->


	<!-- ???????????????  ?????? -->
          <div class="d-md-flex testimony-29101 align-items-stretch my-main-choose-window-container" data-monster="3">
            <div class="card mb-3 my-main-choose-window">
              <div class="row g-0">
                <div class="col-md-8">
                  <img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("3").getMonsterId()  %>" class="img-fluid rounded-start my-main-img" alt="...">
<%--                   <img src="<%=request.getContextPath()%>/images/shh.jpg" class="img-fluid rounded-start my-main-img" alt="..."> --%>
                </div>
                <div class="col-md-4">
                  <div class="card-body">
                    <h3><%=  monsterBookSvc.getFirstMonsterNumber("3").getMonsterName() %></h3>
                    <br>
                    <h4 class="card-text"><%= monsterBookSvc.getFirstMonsterNumber("3").getMonsterAbility() %></h4>
                    <br>
                    <h5 class="card-text">LV <%= monsterBookSvc.getFirstMonsterNumber("3").getMinDemandLevel() %></h5>
                  </div>
                </div>
                </div>
              </div>
            </div>
          </div> 
	<!-- ???????????????  ?????? -->
	
        </div>

	<!--  modal ???????????? -->
        <button type="button" class="btn btn-primary my-modal-trigger-btn" data-toggle="modal"
          data-target="#exampleModal" data-whatever="@fat">??????</button>
	

        <!--  modal ?????? -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">?????????????????????!</h5>

              </div>
              <form method="post" action="<%=request.getContextPath()%>/monsterbook/MonsterServlet.do">
                <div class="modal-body">
                  <div class="mb-3">
                    <img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("1").getMonsterId()  %>" alt="..." class="my-modal-img">
                  </div>

                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">??????</label>
                    <input type="text" class="form-control my-nickname" id="recipient-name" name="monsterNickName" value="<%=  monsterBookSvc.getFirstMonsterNumber("1").getMonsterName() %>">
                    
                    <!--   monsterId ??? ??????  -->
                    <input type="hidden" class="form-control my-monsterId" name="monsterId" value="<%= monsterBookSvc.getFirstMonsterNumber("1").getMonsterId() %>">
                    
                  </div>

                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">??????</label>
                    <h4 class="level"><%= monsterBookSvc.getFirstMonsterNumber("1").getMinDemandLevel() %></h4>
                    <!--   originLevel ?????????   -->
                    <input type="hidden" class="form-control my-originLevel" name="originLevel" value="<%= monsterBookSvc.getFirstMonsterNumber("1").getMinDemandLevel() %>">
                  </div>

                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">?????????</label>
                    <h4>0</h4>
                    
                    <!--   originExp ?????????   -->
                    <input type="hidden" class="form-control" name="originExp" value="0">
                  </div>

                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">????????????</label>
                    <h4 class="ability"><%= monsterBookSvc.getFirstMonsterNumber("1").getMonsterAbility() %></h4>
                  </div>

                </div>
                <div class="modal-footer">
                  <input type="hidden" name="action" value="updateMonsterVOtoMemInfo">
                  <button type="submit" class="btn btn-primary" style="margin:0 auto;">??????</button>
                </div>
              </form>
            </div>
          </div>
        </div>
        <!--  modal ?????? -->

        <!-- ????????????  ?????? -->
        <div class="my-5 text-center">
          <ul class="thumbnail">
            <li class="active" data-monster="1"><a href="#"><img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("1").getMonsterId()  %>" alt="Image" class="img-fluid"></a></li>
            <li data-monster="2"><a href="#"><img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("2").getMonsterId()  %>" alt="Image" class="img-fluid"></a></li>
            <li data-monster="3"><a href="#"><img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("3").getMonsterId()  %>" alt="Image" class="img-fluid"></a></li>
<%--             <li class="active" data-monster="1"><a href="#"><img src="<%=request.getContextPath()%>/images/m1.svg" alt="Image" class="img-fluid"></a></li> --%>
<%--             <li data-monster="2"><a href="#"><img src="<%=request.getContextPath()%>/images/qfe.jpg" alt="Image" class="img-fluid"></a></li> --%>
<%--             <li data-monster="3"><a href="#"><img src="<%=request.getContextPath()%>/images/shh.jpg" alt="Image" class="img-fluid"></a></li> --%>
          </ul>
        </div>
        <!-- ????????????  ?????? -->


      </div>


    </div>
  </div>




  <script src="<%=request.getContextPath()%>/vendors/carousel15/js/jquery-3.3.1.min.js"></script>
  <script src="<%=request.getContextPath()%>/vendors/carousel15/js/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>/vendors/carousel15/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/vendors/carousel15/js/owl.carousel.min.js"></script>
  <script src="<%=request.getContextPath()%>/vendors/carousel15/js/main.js"></script>

  <script>
  	
  $(document).ready(function() {
	  
	  
	  let monsterNo = "";
	  let chosenImg_el = "";
	  let chosenName = ""; 
	  let chosenAbility = "";	  
	  let chosenLV = "";
	  let monster1Id = "1001";
	  let monster2Id = "1002";
	  let monster3Id = "1003";
	  
	  $('div.my-5>ul.thumbnail>li').on('click', function() {
		  
		/******  ???????????????????????????    ********/
		  monsterNo = $('div.my-5>ul.thumbnail>li.active').data('monster');
		  
		  chosenImg_el = $('div[data-monster="' + monsterNo + '"]').find('img').parent().html().trim();
		
		  chosenName = $('div[data-monster="' + monsterNo + '"]').find('h3').html();
		
		  chosenAbility = $('div[data-monster="' + monsterNo + '"]').find('h4').html();
		 
		  chosenLV = $('div[data-monster="' + monsterNo + '"]').find('h5').html();
		  chosenLV = chosenLV.replace('LV','').trim();
		  
		   
		   /**** ??????????????????????????????modal ***/
		   $('div.modal form img').replaceWith(chosenImg_el);
		   // ????????????CSS???????????????modal?????????
		   $('div.modal form img').removeClass('my-main-img');
		   $('div.modal form img').addClass('my-modal-img');
		   
		   $('div.modal form input.my-nickname').val(chosenName);
		   
		   /*********    ??????????????????monsterId     ************/
		   if(monsterNo == "1") {
			   $('div.modal form input.my-monsterId').val(monster1Id);
		   } else if(monsterNo == "2") {
			   $('div.modal form input.my-monsterId').val(monster2Id);
		   } else if(monsterNo == "3") {
			   $('div.modal form input.my-monsterId').val(monster3Id);
		   }
		   
		   
		   $('div.modal form h4.level').text(chosenLV);
		  
		   $('div.modal form input.my-originLevel').val(chosenLV);
		   
		   $('div.modal form h4.ability').text(chosenAbility);
		   
	  });
	  
	  
	  
	  
	  
	  
	});
  
  
  
  </script>

</body>

</html>