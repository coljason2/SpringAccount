<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>藥廠管理</title>
</head>
<body>
	<a class="btn btn-info" href="<c:url value="/company/add" />">新增藥廠</a>
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
				<%-- <td><c:forEach var="meds" items="${c.Medicines}" 
						varStatus="loop">
						${meds}
    					<c:if test="${not loop.last}">,</c:if>
					</c:forEach></td> --%>
				<td><spring:url value="${c.id}" var="listmedsUrl" /> <spring:url
						value="${c.id}/delete" var="deleteUrl" /> <spring:url
						value="${c.id}/update" var="updateUrl" />
					<button class="btn btn-info"
						onclick="location.href='${listmedsUrl}'">藥品</button>
					<button class="btn btn-primary"
						onclick="location.href='${updateUrl}'">更新</button> <%-- <button class="btn btn-danger"
						onclick="this.disabled=true;post('${deleteUrl}')">刪除</button> --%>
					<a class="btn btn-danger" href="${deleteUrl}">刪除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>