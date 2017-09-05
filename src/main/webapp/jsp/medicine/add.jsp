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
	<sf:form method="POST" modelAttribute="medicine">
		<div>
			<label>藥品名稱</label>
			<sf:input path="med_name" />
		</div>
		<div>
			<label>所屬藥廠</label>
			<sf:input path="company" />
		</div>
		<input type="submit" value="新增藥品">
	</sf:form>
</body>
</html>