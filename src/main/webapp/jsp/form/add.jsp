<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增記帳帳單</title>
</head>
<body>
	<form class="form-control" action="add" method="post">
		<div>
			<label>帳單所屬醫院</label> <select id="hos_id" name="hos_id">
				<c:forEach items="${hos}" var="hos">
					<option value="${hos.id}">${hos.hos_name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>帳單月份</label> <select id="acc_year" name="acc_year">
				<c:forEach items="${year}" var="year">
					<option value="${year}">${year}</option>
				</c:forEach>
			</select> <label>帳單月份</label> <select id="acc_month" name="acc_month">
				<c:forEach items="${month}" var="mon">
					<option value="${mon}">${mon}</option>
				</c:forEach>
			</select>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="新增帳單"
			class="btn btn-primary" />
	</form>
</body>
</html>