<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>編號${form.oid }</title>
</head>
<body>


	<div class="form-control">
		<div>
			<label>所屬醫院：</label> ${form.hospital.hos_name }
		</div>

		<div>
			<label>帳單編號：</label> ${form.oid }
		</div>
		<div>
			<label>帳單月份：</label> ${form.acctDate }
		</div>
	</div>

	<table id="datatable" class="table table-striped table-bordered"
		width="100%" cellspacing="0">
		<thead>
			<tr>
				<th>ID</th>
				<th>進貨日</th>
				<th>藥品名稱</th>
				<th>藥廠</th>
				<th>數量</th>
				<th>進貨價格</th>
				<th>折讓一</th>
				<th>折讓二</th>
				<th>折讓三</th>
				<th>實際價格</th>
				<th>功能</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="meds" items="${meds}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${meds.inputdate}</td>
					<td>${meds.medicine}</td>
					<td>${meds.company}</td>
					<td>${meds.itemcount}</td>
					<td>${meds.input_cost}</td>
					<td>${meds.discount1}</td>
					<td>${meds.discount2}</td>
					<td>${meds.discount3}</td>
					<td>${meds.total}</td>
					<td><spring:url value="${meds.id}/delete" var="deleteUrl" />
						<spring:url value="${meds.id}/update" var="updateUrl" /> <a
						class="btn btn-primary" href="${updateUrl}">編輯</a> <a
						class="btn btn-danger" href="${deleteUrl}">刪除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>