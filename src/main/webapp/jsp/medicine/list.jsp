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
				<th>藥廠</th>
				<th>藥品名稱</th>
				<th>產生日期</th>
				<th>更新日期</th>
			</tr>
		</thead>
		<c:forEach var="user" items="${meds}">
			<tr>
				<td>${com.com_name}</td>
				<td>${coms.createDate}</td>
				<td>${coms.updateDate}</td>
				<td><c:forEach var="Medicines" items="${coms.Medicines}"
						varStatus="loop">
						${Medicines}
    					<c:if test="${not loop.last}">,</c:if>
					</c:forEach></td>
				<td><spring:url value="/company/${com.id}" var="listmedsUrl" />
					<spring:url value="/company/${com.id}/delete" var="deleteUrl" /> <spring:url
						value="/company/${com.id}/update" var="updateUrl" />

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