<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<style>

section.my-recommend-restaurant-title{
	margin-top: 60px;
}
section div.my-recommand-title-wrap {
	margin-top: 40px;
	margin-bottom: 20px;
}

header.navbar-area div.nav-right-part li.category-wrap {
	width: 60px;
}

img.my-monster-now {
	width: 60px;
	height: 50px;
}

div.nav-right-part ul.category-menu li.category-wrap div.my-monster-detail {
	font-family:fantasy;
	color: red;
}

#tooltip div.my-mission-title {
	font-size: 18px;
	color: #cf0846;
}

#tooltip div.my-mission-content {
	color: #01265d;
}
/*********  tooltip的CSS 開始  ********/
#tooltip {
	display: none;
	background: #ffffff;
	color: #643045;
	font-weight: bold;
	padding: 5px 10px;
	font-size: 13px;
	border-radius: 4px;
}

#arrow, #arrow::before {
	position: absolute;
	width: 8px;
	height: 8px;
	background: inherit;
}

#arrow {
	visibility: hidden;
}

#arrow::before {
	visibility: visible;
	content: '';
	transform: rotate(45deg);
}

#tooltip[data-popper-placement^='bottom']>#arrow {
	top: -4px;
}

/*********  tooltip的CSS 結束 ********/
</style>