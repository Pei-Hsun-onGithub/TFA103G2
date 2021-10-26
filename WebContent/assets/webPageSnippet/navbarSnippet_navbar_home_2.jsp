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
					<a class="main-logo" href="#"><img src="<%=request.getContextPath()%>/assets/img/logo.png"
						alt="img"></a>


				</div>

				<div class="collapse navbar-collapse" id="themefie_main_menu">
					<ul class="navbar-nav menu-open">
						<li><a href="<%=request.getContextPath()%>/menu.html">訂餐去</a></li>
						<li><a href="<%=request.getContextPath()%>/shop.html">訂餐去2</a></li>
						<li><a href="<%=request.getContextPath()%>/checkout.html">直接結帳</a></li>
						<li><a href="<%=request.getContextPath()%>/about.html">查詢食記</a></li>
						<li><a href="<%=request.getContextPath()%>/contact.html">食記撰寫</a></li>
					</ul>
				</div>

				<div class="nav-right-part nav-right-part-mobile">
					<ul>
						<li class="phone-contact"><a
							href="/TFA103G2/login/memberinfo.do?action=getOne"><i
								class="far fa-user"></i> username</a></li>
						<li class="menu-cart"><a href="<%=request.getContextPath()%>/cart.html"><i class="fas fa-shopping-cart"></i>
								<span>1</span></a></li>
						<li><i class="fas fa-crown"></i> <span>23</span></li>
					</ul>
				</div>
				
				<div class="nav-right-part nav-right-part-desktop">
					<ul>
						<li>
							<ul class="category-menu">
								<li class="category-wrap"><a href="#"><img
										src="<%=request.getContextPath()%>/images/243.jpg" class="my-monster-now" alt="category"></a>
									<div class="category-sub-menu"
										style="width: 500px; margin-left: -250px;">
										<div class="row">
											<div class="col-md-4 col-6">
												<div class="single-item-wrap text-center">
													<div class="thumb">
														<img src="<%=request.getContextPath()%>/images/243.jpg" alt="img">
													</div>
													<div class="wrap-details">
														<h4>舔舔獸</h4>
														<h5>LV 5</h5>
														<p>愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果</p>
													</div>
												</div>
											</div>
											<div class="col-md-4 col-6">
												<div class="single-item-wrap text-center">
													<div class="thumb">
														<img src="<%=request.getContextPath()%>/images/shh.jpg" alt="img">
													</div>
													<div class="wrap-details">
														<h4>舔舔獸</h4>
														<h5>LV 5</h5>
														<p>愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果 愛吃糖果</p>
													</div>
												</div>
											</div>
											<div class="col-md-4 col-6">
												<div class="single-item-wrap text-center">
													<div class="thumb">
														<img src="<%=request.getContextPath()%>/images/wthwt.jpg" alt="img">
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
								class="far fa-user"></i> username</a></li>

						<li><a id="my-bell" href="#" onclick="toggleTheTooltip()"><i
								class="far fa-bell"></i> <span>4</span></a></li>
						<!--   放入想要提醒的事項!    -->
						<div id="tooltip" role="tooltip">
							<div>Popcorn</div>
							<div>sizes</div>
							<div>&amp; Price</div>
							<div>XXS: $1.99</div>
							<div>XS: $2.99</div>
							<div>S: $3.99</div>
							<div>M: $4.99</div>
							<div>L: $5.99</div>
							<div>XL: $6.99</div>
							<div>XXL: $7.99</div>
							<div id="arrow" data-popper-arrow></div>
						</div>

						<li><a href="<%=request.getContextPath()%>/cart.html"><i class="fas fa-shopping-cart"></i>
								<span>1</span></a></li>
						<li><i class="fas fa-crown"></i> <span>23</span></li>
					</ul>
				</div>
				
			</div>
		</nav>
	</header>
	<!-- navbar end -->
