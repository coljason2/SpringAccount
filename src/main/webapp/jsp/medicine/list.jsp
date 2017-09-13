<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>藥品管理</title>
</head>
<body>
	<a class="btn btn-info" href="<c:url value="/medicine/add" />">新增藥品</a>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>藥品名稱</th>
				<th>藥廠</th>
				<th>產生日期</th>
				<th>更新日期</th>
			</tr>
		</thead>
		<c:forEach var="meds" items="${meds}">
			<tr>
				<td>${meds.id}</td>
				<td>${meds.med_name}</td>
				<td>${meds.company.com_name}</td>
				<td>${meds.createDate}</td>
				<td>${meds.updateDate}</td>
				<td><spring:url value="${meds.id}" var="listmedsUrl" /> <spring:url
						value="${meds.id}/delete" var="deleteUrl" /> <spring:url
						value="${meds.id}/update" var="updateUrl" /> <a
					class="btn btn-info" href="${listmedsUrl}">藥品</a> <a
					class="btn btn-primary" href="${updateUrl}">更新</a> <a
					class="btn btn-danger" href="${deleteUrl}">刪除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>