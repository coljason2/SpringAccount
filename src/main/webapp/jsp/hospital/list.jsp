<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>醫院管理</title>
</head>
<body>
	<a class="btn btn-info" href="<c:url value="/hospital/add" />">新增醫院</a>
	<table  id="datatable" class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>醫院</th>
				<th>產生日期</th>
				<th>更新日期</th>
				<th>功能選單</th>
			</tr>
		</thead>
		<c:forEach var="hos" items="${hosptials}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${hos.hos_name}</td>
				<td>${hos.createDate}</td>
				<td>${hos.updateDate}</td>
				<td><spring:url value="${hos.id}/forms" var="listFormsUrl" />
					<spring:url value="${hos.id}/delete" var="deleteUrl" /> <spring:url
						value="${hos.id}/update" var="updateUrl" /> <a
					class="btn btn-info" href="${listFormsUrl}">帳單</a> <a
					class="btn btn-primary" href="${updateUrl}">編輯</a> <a
					class="btn btn-danger" href="${deleteUrl}">刪除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>