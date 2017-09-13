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
	<form method="POST" class="form-control" action="add">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div>
			<label>藥品名稱</label> <input id="med_name" name="med_name" />

		</div>
		<div>
			<label>所屬藥廠</label> <select id="company_id" name="company_id">
				<c:forEach items="${coms}" var="coms">
					<option value="${coms.id}">${coms.com_name}</option>
				</c:forEach>
			</select>
		</div>
		<input type="submit" value="新增藥品" class="btn btn-primary">
	</form>
</body>
</html>