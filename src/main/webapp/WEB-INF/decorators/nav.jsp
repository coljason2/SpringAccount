<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="<c:url value="/" />">帳單管理系統</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="http://mymedicinequery.herokuapp.com/index" target="_blank">藥品查詢</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/form/list" />">帳單管理 </a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/medicine/list" />">藥品管理</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/company/list" />">藥廠管理</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/hospital/list" />">醫院管理</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/logout" />">登出</a></li>
			</ul>
		</div>
	</div>
</nav>