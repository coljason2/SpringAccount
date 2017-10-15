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
	<table id="exportdata" class="table table-striped" width="100%"
		cellspacing="0">
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			$('#exportdata').dataTable({
				"scrollCollapse" : true,
				"jQueryUI" : true,
				dom : 'Bfrtip',
				buttons : [ 'pdfHtml5' ]
			});
			$('#exportdata_wrapper').find('a').trigger('click');
		});
	</script>
</body>
</html>