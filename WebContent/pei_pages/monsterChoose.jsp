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

      <h1 class="my-5 text-center">選取一隻怪獸吧!</h1>
      <div class="slider-92911">
        <div class="owl-carousel slide-one-item">

		<!-- 第一隻怪獸  開始 -->
          <div class="d-md-flex testimony-29101 align-items-stretch my-main-choose-window-container" data-monster="1">
            <div class="card mb-3 my-main-choose-window">
              <div class="row g-0">
                <div class="col-md-8">
                  <img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("1").getMonsterId()  %>" class="img-fluid rounded-start my-main-img" alt="...">
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
       <!-- 第一隻怪獸  結束 -->


	   <!-- 第二隻怪獸  開始 -->
          <div class="d-md-flex testimony-29101 align-items-stretch my-main-choose-window-container" data-monster="2">
            <div class="card mb-3 my-main-choose-window">
              <div class="row g-0">
                <div class="col-md-8">
                  <img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("2").getMonsterId()  %>" class="img-fluid rounded-start my-main-img" alt="...">
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

 	<!-- 第二隻怪獸  結束 -->


	<!-- 第三隻怪獸  開始 -->
          <div class="d-md-flex testimony-29101 align-items-stretch my-main-choose-window-container" data-monster="3">
            <div class="card mb-3 my-main-choose-window">
              <div class="row g-0">
                <div class="col-md-8">
                  <img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("3").getMonsterId()  %>" class="img-fluid rounded-start my-main-img" alt="...">
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
	<!-- 第三隻怪獸  結束 -->
	
        </div>

	<!--  modal 觸發按鈕 -->
        <button type="button" class="btn btn-primary my-modal-trigger-btn" data-toggle="modal"
          data-target="#exampleModal" data-whatever="@fat">選我</button>
	

        <!--  modal 開始 -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">給我取個名字吧!</h5>

              </div>
              <form method="post" action="<%=request.getContextPath()%>/monsterbook/MonsterServlet.do">
                <div class="modal-body">
                  <div class="mb-3">
                    <img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("1").getMonsterId()  %>" alt="..." class="my-modal-img">
                  </div>

                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">名字</label>
                    <input type="text" class="form-control" id="recipient-name" name="monsterNickName" value="<%=  monsterBookSvc.getFirstMonsterNumber("1").getMonsterName() %>">
                    <input type="hidden" class="form-control" name="monsterId" value="<%= monsterBookSvc.getFirstMonsterNumber("1").getMonsterId() %>">
                    
                  </div>

                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">等級</label>
                    <h4 class="level"><%= monsterBookSvc.getFirstMonsterNumber("1").getMinDemandLevel() %></h4>
                    <input type="hidden" class="form-control" name="originLevel" value="<%= monsterBookSvc.getFirstMonsterNumber("1").getMinDemandLevel() %>">
                  </div>

                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">經驗值</label>
                    <h4>0</h4>
                    <input type="hidden" class="form-control" name="originExp" value="0">
                  </div>

                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">擅長能力</label>
                    <h4 class="ability"><%= monsterBookSvc.getFirstMonsterNumber("1").getMonsterAbility() %></h4>
                  </div>

                </div>
                <div class="modal-footer">
                  <input type="hidden" name="action" value="updateMonsterVOtoMemInfo">
                  <button type="submit" class="btn btn-primary" style="margin:0 auto;">確認</button>
                </div>
              </form>
            </div>
          </div>
        </div>
        <!--  modal 結束 -->

        <!-- 下縮圖區  開始 -->
        <div class="my-5 text-center">
          <ul class="thumbnail">
            <li class="active" data-monster="1"><a href="#"><img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("1").getMonsterId()  %>" alt="Image" class="img-fluid"></a></li>
            <li data-monster="2"><a href="#"><img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("2").getMonsterId()  %>" alt="Image" class="img-fluid"></a></li>
            <li data-monster="3"><a href="#"><img src="<%=request.getContextPath()%>/PhotoResolver?id=<%=monsterBookSvc.getFirstMonsterNumber("3").getMonsterId()  %>" alt="Image" class="img-fluid"></a></li>
          </ul>
        </div>
        <!-- 下縮圖區  結束 -->


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
	  
	  $('div.my-5>ul.thumbnail>li').on('click', function() {
		  
		/******  找到被選取到的怪獸    ********/
		  monsterNo = $('div.my-5>ul.thumbnail>li.active').data('monster');
		  
		  chosenImg_el = $('div[data-monster="' + monsterNo + '"]').find('img').parent().html().trim();
		
		  chosenName = $('div[data-monster="' + monsterNo + '"]').find('h3').html();
		
		  chosenAbility = $('div[data-monster="' + monsterNo + '"]').find('h4').html();
		 
		  chosenLV = $('div[data-monster="' + monsterNo + '"]').find('h5').html();
		  chosenLV = chosenLV.replace('LV','').trim();
		  
		   
		   /**** 將選到的怪獸，設定到modal ***/
		   $('div.modal form img').replaceWith(chosenImg_el);
		   // 調整原圖CSS成為適用於modal的尺寸
		   $('div.modal form img').removeClass('my-main-img');
		   $('div.modal form img').addClass('my-modal-img');
		   
		   $('div.modal form input').val(chosenName);
		   $('div.modal form h4.level').text(chosenLV);
		   $('div.modal form h4.ability').text(chosenAbility);
		   
	  });
	  
	  
	  
	  
	  
	  
	});
  
  
  
  </script>

</body>

</html>