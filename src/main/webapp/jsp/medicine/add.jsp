<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增藥品</title>
</head>
<body>
	<sf:form method="POST" modelAttribute="medicine" class="form-control">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<label>選擇藥廠</label>
		<select id="company">
			<c:forEach items="${companys}" var="company">
				<option value="${company}">${company}</option>
			</c:forEach>
		</select>
		<div>
			<label>藥品名稱</label>
			<sf:input path="med_name" />

		</div>
		<div>
			<label>所屬藥廠</label>
			<sf:input path="company" />
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
		<input type="submit" value="新增藥品" class="btn btn-primary">
	</sf:form>

</body>
</html>