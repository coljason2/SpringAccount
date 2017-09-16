<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>${com.com_name }</title>
</head>
<body>
	<h2>${com.com_name}藥品項目</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>藥品ID</th>
				<th>藥品名稱</th>
				<th>產生日期</th>
				<th>更新日期</th>
				<th>功能選項</th>
			</tr>
		</thead>
		<c:forEach var="meds" items="${meds}" varStatus="loop">
			<tr>
				<td>${loop.index}</td>
				<td>${meds.med_name}</td>
				<td>${meds.createDate}</td>
				<td>${meds.updateDate}</td>
				<td><spring:url value="${meds.id}/delete" var="deleteUrl" /> <spring:url
						value="${meds.id}/update" var="updateUrl" /> <a
					class="btn btn-primary" href="${updateUrl}">編輯</a><a> </a><a
					class="btn btn-danger" href="${deleteUrl}">刪除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>