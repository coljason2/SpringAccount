<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<html>
<head>
<%@include file="meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><dec:title /></title>
</head>
<body>
	<%@include file="nav.jsp"%>
	<div class="container">
		<div class="generic-container">
			<dec:body />
		</div>
	</div>
</body>
</html>