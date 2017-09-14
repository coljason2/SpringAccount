<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${com.com_name }</title>
</head>
<body>
	<div>
		<label>藥廠名稱:</label> <a>${com.com_name}</a>
	</div>
	<div>
		<label>產生日期:</label> <a>${com.createDate}" </a>
	</div>
	<div>
		<label>更新日期:</label> <a>${com.updateDate}</a>
	</div>
	<label>藥品</label>
	<c:forEach var="Medicines" items="${meds}" varStatus="loop">
		<div>
			<a>${Medicines}</a>
		</div>
	</c:forEach>
</body>
</html>