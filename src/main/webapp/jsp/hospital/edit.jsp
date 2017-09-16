<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${hos.hos_name }</title>
</head>
<body>
	<form method="POST" class="form-control">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="hidden" name="hos_id"
			value="${hos.id}" />
		<div>
			<label>藥廠名稱</label> <input value="${hos.hos_name}" name="hos_name" />
		</div>
		<input type="submit" value="確認修改" class="btn btn-primary">
	</form>
</body>
</html>