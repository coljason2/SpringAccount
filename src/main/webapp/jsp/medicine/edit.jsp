<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${med.med_name }</title>
</head>
<body>
	<form method="POST" class="form-control" action="update">
		<input type="hidden" name="med_id" value="${med.id}"> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div>
			<label>藥品名稱</label> <input id="med_name" name="med_name"
				value="${med.med_name} " /> <a>${error }</a>

		</div>
		<div>
			<label>目前藥廠</label> <input type="text" id="now_company"
				name="now_company" readonly="readonly"
				value="${med.company.com_name} " /> <input type="hidden"
				name="com_id" value="${med.company.id}">
		</div>
		<div>
			<label>所屬藥廠</label> <select id="company_id" name="company_id">
				<c:forEach items="${coms}" var="coms">
					<option value="${coms.id}">${coms.com_name}</option>
				</c:forEach>
			</select>
		</div>
		<input type="submit" value="更新藥品" class="btn btn-primary">
	</form>
</body>
</html>