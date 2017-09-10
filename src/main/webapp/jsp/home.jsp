<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增藥品細項</title>
</head>
<body>
	<form class="form-control" action="form/add" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	    <label id="Hospital">${Hospital}</label>
		<div>
			<label>選擇藥廠</label> <select id="company">
				<c:forEach items="${companys}" var="company">
					<option value="${company}">${company}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>進貨日期</label> <input value="2011-08-19" id="inputDate">
		</div>

		<div>
			<label>選擇藥品</label> <select id="medicine">
				<option>請選擇藥品</option>
			</select>
		</div>
		<div>
			<label>數量</label> <input type="text" id="itemcount">
		</div>
		<div>
			<label>價格</label> <input type="text" id="input_cost">
		</div>
		<div>
			<label>折讓一</label> <input type="text" id="discount1">
		</div>
		<div>
			<label>折讓二</label> <input type="text" id="discount2">
		</div>
		<div>
			<label>折讓三</label> <input type="text" id="discount3">
		</div>
		<input class="btn btn-primary" type="submit" value="新增藥品">
	</form>
	<script type="text/javascript">
		$(function() {
			$("#company").change(
					function() {
						var company = $("#company").val();
						var token = $("meta[name='_csrf']").attr("content");
						var header = $("meta[name='_csrf_header']").attr(
								"content");
						$.ajax({
							type : "POST",
							url : "AjaxSelectCompany",
							data : {
								companyId : company

							},
							dataType : "json",
							beforeSend : function(xhr) {
								xhr.setRequestHeader(header, token);
							},
							error : function() {
								alert("資料傳輸有誤")
							},
							success : function(data) {
								$("#medicine").empty();
								$("#medicine").append(
										"<option value=''>選擇藥品</option>");
								$.each(data, function(index, item) {
									$("#medicine").append(
											"<option value='"+item+"'>" + item
													+ "</option>");
								});
							}
						});
					});
		});
	</script>
</body>
</html>