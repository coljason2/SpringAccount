<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>醫院管理</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>醫院</th>
				<th>產生日期</th>
				<th>更新日期</th>
				<th>帳單</th>
			</tr>
		</thead>
		<c:forEach var="hos" items="${hosptials}">
			<tr>
				<td>${hos.id}</td>
				<td>${hos.hos_name}</td>
				<td>${hos.createDate}</td>
				<td>${hos.updateDate}</td>
				<td><c:forEach var="forms" items="${hos.AccountFroms}"
						varStatus="loop">
						${forms}
    					<c:if test="${not loop.last}">,</c:if>
					</c:forEach></td>
				<td><spring:url value="/hospital/${hos.id}" var="listmedsUrl" />
					<spring:url value="/hospital/${hos.id}/delete" var="deleteUrl" /> <spring:url
						value="/hospital/${hos.id}/update" var="updateUrl" />
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