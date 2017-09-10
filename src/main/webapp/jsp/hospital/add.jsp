<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增醫院</title>
</head>
<body>
<<<<<<< HEAD
	<form action="add" method="post">
		<input type="text" value="${Hospital}" readonly="readonly"
			id="Hospital" /> 
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
=======
	<sf:form method="POST" modelAttribute="hospital">
>>>>>>> 53c80bd6ca4606a3da86a670c1493f1407459920
		<div>
			<label>醫院名稱</label>
			<sf:input path="hos_name" />
		</div>
		<input type="submit" value="新增醫院">
	</sf:form>
</body>
</html>