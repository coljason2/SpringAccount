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
	<form class="form-control" action="add" method="post">
		<input type="text" value="${Hospital}" readonly="readonly"
			id="Hospital">
		<div>
			<label>選擇藥廠</label> <select id="company">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>
		<div>
			<label>進貨日期</label> <input value="2011-08-19" id="inputDate">
		</div>

		<div>
			<label>選擇藥品</label> <select id="medicine">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
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
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> 
		<input type="submit" value="新增藥品"  class="btn btn-primary">
	</form>
</body>
</html>