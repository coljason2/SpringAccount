<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>${hos.hos_name }帳單</title>
</head>
<body>
	<div>
		<h2>【${hos.hos_name}】帳單總覽項目</h2>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>帳單編號</th>
				<th>帳單月份</th>
				<th>產生日期</th>
				<th>總金額</th>
				<th>功能選項</th>
			</tr>
		</thead>
		<c:forEach var="forms" items="${forms}" varStatus="status">
			<tr>
				<td>${status.index }</td>
				<td>${forms.oid }</td>
				<td>${forms.acctDate }</td>
				<td>${forms.createDate }</td>
				<td>${forms.total }</td>
				<td><spring:url value="${forms.id}/Items" var="listmedsUrl" />
					<spring:url value="${forms.id}/delete" var="deleteUrl" /> <spring:url
						value="${forms.id}/update" var="updateUrl" /> <a
					class="btn btn-info" href="${listmedsUrl}">細項</a> <a
					class="btn btn-primary" href="${updateUrl}">編輯</a> <a
					class="btn btn-danger" href="${deleteUrl}">刪除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>