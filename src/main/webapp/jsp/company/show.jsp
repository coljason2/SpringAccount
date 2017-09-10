<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${com.com_name }</title>
</head>
<body>
	<div>
		<label>藥廠名稱</label> <input value="${com.com_name}" />
	</div>
	<div>
		<label>產生日期</label> <input value="${com.createDate}" />
	</div>
	<div>
		<label>更新日期</label> <input value="${com.updateDate}" />
	</div>
	<label>藥品</label>
	<c:forEach var="Medicines" items="${com.Medicines}" varStatus="loop">
		<a>${Medicines}</a>
	</c:forEach>
</body>
</html>