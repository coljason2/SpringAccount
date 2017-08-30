<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">帳單管理系統</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="#">新增表單 </a></li>
				<li class="nav-item"><a class="nav-link" href="#">藥品管理</a></li>
				<li class="nav-item"><a class="nav-link" href="#">藥廠管理</a></li>
				<li class="nav-item"><a class="nav-link" href="#">醫院管理</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/logout" />">登出</a></li>
			</ul>
		</div>
	</div>
</nav>