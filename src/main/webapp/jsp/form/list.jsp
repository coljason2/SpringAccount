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
				<th>所屬醫院</th>
				<th>產生日期</th>
				<th>總金額</th>
				<th>藥品項目</th>
			</tr>
		</thead>
		<c:forEach var="forms" items="${forms}">
			<tr>
				<td>${forms.id}</td>
				<td>${forms.Hospital}</td>
				<td>${forms.createDate}</td>
				<td>${forms.total}</td>
				<%-- <td><c:forEach var="medis" items="${hos.MedItems}"
						varStatus="loop">
						${medis}
    					<c:if test="${not loop.last}">,</c:if>
					</c:forEach></td> --%>
				<td><spring:url value="${forms.id}" var="listmedsUrl" /> <spring:url
						value="${forms.id}/delete" var="deleteUrl" /> <spring:url
						value="${forms.id}/update" var="updateUrl" /> <a
					class="btn btn-info" href="${listmedsUrl}">帳單</a> <a
					class="btn btn-primary" href="${updateUrl}">更新</a> <a
					class="btn btn-danger" href="${deleteUrl}">刪除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>