<%@page import="com.monsterbook.model.MonsterBook"%>
<%@page import="com.monsterbook.model.MonsterBookService"%>
<%@page import="com.memberinfo.model.MemberInfo"%>
<%@page import="com.memberinfo.model.MemberInfoService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<!-- navbar start -->

<header class="navbar-area">
	<nav class="navbar navbar-expand-lg">
		<div class="container nav-container">

			<div class="responsive-mobile-menu">
				<button class="menu toggle-btn d-block d-lg-none"
					data-target="#themefie_main_menu" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="icon-left"></span> <span class="icon-right"></span>
				</button>
			</div>


			<div class="logo">
				<a class="main-logo" href="<%=request.getContextPath()%>/home.jsp"><img
					src="<%=request.getContextPath()%>/assets/img/logo.png" alt="img"></a>


			</div>

<%
				MemberInfoService memberSvc = new MemberInfoService();
				Integer usrId = (Integer) session.getAttribute("userId");
				MemberInfo memberVO = memberSvc.getOneMemberInfo(usrId);

				MonsterBookService mstrSvc = new MonsterBookService();
				MonsterBook monsterVO = mstrSvc.getOneMonsterBook(memberVO.getMonsterId());
			%>


			<div class="collapse navbar-collapse" id="themefie_main_menu">
				<ul class="navbar-nav menu-open">
					<li><a href="<%=request.getContextPath()%>/menu.html">訂餐去</a></li>
					<li><a href="<%=request.getContextPath()%>/checkout.html">直接結帳</a></li>
					<li><a href="<%=request.getContextPath()%>/about.html">查詢食記</a></li>
					<li><a href="<%=request.getContextPath()%>/contact.html">食記撰寫</a></li>
				</ul>
			</div>

			<div class="nav-right-part nav-right-part-mobile">
				<ul>
					<li class="phone-contact"><a
						href="/TFA103G2/login/memberinfo.do?action=getOne"><i
							class="far fa-user"></i> <%=memberVO.getUserName()%></a></li>
					<li class="menu-cart"><a
						href="<%=request.getContextPath()%>/cart.html"><i
							class="fas fa-shopping-cart"></i> <span>1</span></a></li>
					<li><i class="fas fa-crown"></i> <span>23</span></li>
				</ul>
			</div>
			

			<div class="nav-right-part nav-right-part-desktop">
				<ul>
					<li>
						<ul class="category-menu">
							<li class="category-wrap"><a href="#"><img
									src="<%=request.getContextPath()%>/MonsterPhotoShow.do"
									class="my-monster-now" alt="category"></a>
								<div class="category-sub-menu"
									style="width: 500px; margin-left: -250px;">
									<div class="row">
										<div class="col-md-4 col-6">
											<div class="single-item-wrap text-center">
												<div class="thumb">
													<img
														src="<%=request.getContextPath()%>/MonsterPhotoShow.do"
														alt="img">
												</div>
												<div class="wrap-details my-monster-detail">
													<h4><%=memberVO.getMonsterNickName()%></h4>
													<div>LV: <%= memberVO.getLv() %></div>
													<div>EXP: <%=memberVO.getExp()%></div>
													<div><%=monsterVO.getMonsterAbility()%></div>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-6">
											<div class="single-item-wrap text-center">
												<div class="thumb">
													<img src="<%=request.getContextPath()%>/images/shh.jpg"
														alt="img">
												</div>
												<div class="wrap-details my-monster-detail">
													<h4>舔舔獸</h4>
													<div>XS: $2.99</div>
													<div>S: $3.99</div>
													<div>M: $4.99</div>
													<div>L: $5.99</div>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-6">
											<div class="single-item-wrap text-center">
												<div class="thumb">
													<img src="<%=request.getContextPath()%>/images/wthwt.jpg"
														alt="img">
												</div>
												<div class="wrap-details">
													<h4>舔舔獸</h4>
													<h5>LV 5</h5>
													<p>愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果</p>
												</div>
											</div>
										</div>

									</div>
								</div></li>
						</ul>

					</li>

					<li class="phone-contact"><a
						href="/TFA103G2/login/memberinfo.do?action=getOne"><i
							class="far fa-user"></i> <%=memberVO.getUserName()%></a></li>

					<li><a id="my-bell" href="#" onclick="toggleTheTooltip()"><i
							class="far fa-bell"></i> <span>4</span></a></li>
					<!--   放入想要提醒的事項!    -->
					<div id="tooltip" role="tooltip">
						<div class="my-mission-title">今日任務</div>
						<div class="my-mission-content">大胃王</div>
						<div class="my-mission-title">完成獎勵</div>
						<div class="my-mission-content">金幣 20 枚</div>
						<div class="my-mission-content">怪獸飼料 100個</div>
						<div class="my-mission-title">描述</div>
						<div class="my-mission-content">成功完成50筆訂單可獲得100個飼料</div>
						<div class="my-mission-title">目前進度</div>
						<div class="my-mission-content">食記提交: 0/0</div>
						<div class="my-mission-content">訂餐成功: 23/50</div>
						<div class="my-mission-title">剩餘天數</div>
						<div class="my-mission-content">39</div>
						<div id="arrow" data-popper-arrow></div>
					</div>

					<li><a href="<%=request.getContextPath()%>/cart.html"><i
							class="fas fa-shopping-cart"></i> <span>1</span></a></li>
					<li><i class="fas fa-crown"></i> <span>23</span></li>
				</ul>
			</div>

		</div>
	</nav>
</header>
<!-- navbar end -->
