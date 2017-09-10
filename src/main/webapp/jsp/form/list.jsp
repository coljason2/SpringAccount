<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>帳單管理</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>醫院</th>
				<th>產生日期</th>
				<th>總金額</th>
			</tr>
		</thead>
		<c:forEach var="forms" items="${forms}">
			<tr>
				<td>${forms.id}</td>
				<td>${forms.Hospital}</td>
				<td>${forms.createDate}</td>
				<td>${forms.total}</td>
				<td><c:forEach var="medis" items="${hos.MedItems}"
						varStatus="loop">
						${medis}
    					<c:if test="${not loop.last}">,</c:if>
					</c:forEach></td>
				<td><spring:url value="/company/${forms.id}" var="listmedsUrl" />
					<spring:url value="/company/${forms.id}/delete" var="deleteUrl" />
					<spring:url value="/company/${forms.id}/update" var="updateUrl" />
					<button class="btn btn-info"
						onclick="location.href='${listmedsUrl}'">帳單</button>
					<button class="btn btn-primary"
						onclick="location.href='${updateUrl}'">更新</button>
					<button class="btn btn-danger"
						onclick="this.disabled=true;post('${deleteUrl}')">刪除</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>