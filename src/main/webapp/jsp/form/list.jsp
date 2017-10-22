<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<title>帳單總覽</title>
</head>
<body>
	<a class="btn btn-info" href="<c:url value="/form/add" />">新增帳單</a>
	<table id="datatable" class="display nowrap">
		<thead>
			<tr>
				<th>ID</th>
				<th>帳單編號</th>
				<th>所屬醫院</th>
				<th>帳單月份</th>
				<th>產生日期</th>
				<th>總金額</th>
				<th>功能選項</th>
			</tr>
		</thead>
		<c:forEach var="forms" items="${forms}" varStatus="status">
			<spring:url value="${forms.id}/items" var="listmedsUrl" />
			<spring:url value="${forms.id}/delete" var="deleteUrl" />
			<spring:url value="${forms.id}/edit" var="updateUrl" />
			<spring:url value="${forms.id}/exportpdf" var="exportpdf" />
			<spring:url value="${forms.id}/downloadPDF" var="downloadPDF" />
			<spring:url value="${forms.id}/exportexcel" var="exportexcel" />
			<tr>
				<td>${status.index }</td>
				<td><a href="${listmedsUrl}" target="_blank">${forms.oid }</a></td>
				<td>${forms.hospital.hos_name }</td>
				<td>${forms.acctDate }</td>
				<td>${forms.createDate }</td>
				<td>${forms.total }</td>
				<td><a class="btn btn-info" href="${listmedsUrl}">細項</a> <a
					class="btn btn-primary" href="${updateUrl}">編輯</a> <a
					class="btn btn-danger" href="${deleteUrl}">刪除</a><a
					class="btn btn-link" href="${downloadPDF}" target="_blank">PDF</a><a
					class="btn btn-link" href="${exportexcel}" target="_blank">EXCEL</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>