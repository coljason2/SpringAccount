<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>藥廠管理</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>藥廠</th>
				<th>產生日期</th>
				<th>更新日期</th>
			</tr>
		</thead>
		<c:forEach var="c" items="${coms}">
			<tr>
				<td>${c.id}</td>
				<td>${c.com_name}</td>
				<td>${c.createDate}</td>
				<td>${c.updateDate}</td>
				<td><c:forEach var="Medicines" items="${c.Medicines}"
						varStatus="loop">
						${Medicines}
    					<c:if test="${not loop.last}">,</c:if>
					</c:forEach></td>
				<td><spring:url value="/company/${c.id}" var="listmedsUrl" />
					<spring:url value="/company/${c.id}/delete" var="deleteUrl" /> <spring:url
						value="/company/${c.id}/update" var="updateUrl" />
					<button class="btn btn-info"
						onclick="location.href='${listmedsUrl}'">藥品</button>
					<button class="btn btn-primary"
						onclick="location.href='${updateUrl}'">更新</button>
					<button class="btn btn-danger"
						onclick="this.disabled=true;post('${deleteUrl}')">刪除</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>