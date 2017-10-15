<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!--meta  -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- SpringSecurity token -->
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<!--CSS  -->
<link href="<c:url value="/resources/css/jquery-ui.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="https://cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://cdn.datatables.net/buttons/1.4.2/css/buttons.dataTables.min.css"
	rel="stylesheet" type="text/css" />
<!--  JavaScript -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.flash.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script
	src="<c:url value="/resources/js/datatable/pdfmake.js" />"></script>
<script
	src="<c:url value="/resources/js/datatable/vfs_fonts.js" />"></script>
<script
	src="<c:url value="/resources/js/datatable/buttons.html5.js" />"></script>
<script
	src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.print.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/datepicker-zh-TW.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/TableScript.js" />"></script>


<style>
body {
	padding-top: 54px;
}

@media ( min-width : 992px) {
	body {
		padding-top: 56px;
	}
}
</style>