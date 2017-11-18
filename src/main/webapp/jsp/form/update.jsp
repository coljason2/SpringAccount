<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>編號${item.oid}</title>
</head>
<style>
#ob {
	width: 100%;
	vertical-align: middle;
	text-align: left;
	position: absolute;
}
</style>
<body>
	<div id="app">
		<form class="form-control">
			<!-- Form Name -->
			<label>帳單編號：</label>${item.accountform.oid }<input type="hidden"
				id="formid" value="${item.accountform.id }" />
			<div>
				<label>帳單月份：</label> ${item.accountform.acctDate }
			</div>
			<div>
				<label>所屬醫院：</label>${item.accountform.hospital.hos_name }</div>
			<div>
				<label>項目編號：</label>${item.oid }<input type="hidden"
					id="itemid" value="${item.id }" />
			</div>
			<!-- Select Basic -->
			<div>
				<label>藥廠：</label> <select id="company" v-model="newMed.company">
					<c:if test="${companys != '無藥廠'}">
						<c:forEach items="${companys}" var="company">
							<option value="${company.com_name}">${company.com_name}</option>
						</c:forEach>
						<input type="hidden" id="firstCompany"
							value="${companys[0].com_name}" />
					</c:if>
					<c:if test="${companys == '無藥廠'}">
						<option value="${companys}">${companys}</option>
						<input type="hidden" id="firstCompany" value="${companys}" />
					</c:if>
				</select> 
				<label>藥品：</label> <select id="medicine" v-model="newMed.name">
					<c:if test="${meds != '無藥品'}">
						<c:forEach items="${meds}" var="m">
							<option value="${m.med_name}">${m.med_name}</option>
						</c:forEach>
						<input type="hidden" id="firstMed" value="${meds[0].med_name}" />
					</c:if>
					<c:if test="${meds == '無藥品'}">
						<option value="${meds}">${meds}</option>
						<input type="hidden" id="firstMed" value="${meds}" />
					</c:if>
				</select> <label>進貨日期：</label> <input id="inputday" name="inputday"
					v-model="newMed.inputday" type="text" value="${item.inputdate} ">
			</div>
			<!-- Text input-->
			<div>
				<label>價格：</label> <input id="cost" name="cost"
					v-model="newMed.cost" placeholder="進貨價格" type="text"
					value="${item.input_cost}"> <label>數量：</label> <input
					id="count" name="count" v-model="newMed.count" placeholder="藥品數量"
					type="text" value="${item.itemcount}">
			</div>

			<!-- Text input-->
			<div>
				<label>折讓一：</label> <input id="discount1" name="discount1"
					v-model="newMed.discount1" type="text" value="${item.discount1}">
				<label>折讓二：</label> <input id="discount2" name="discount2"
					v-model="newMed.discount2" value="${item.discount2}" type="text">
				<label>折讓三：</label> <input id="discount3" name="discount3"
					v-model="newMed.discount3" value="${item.discount3}" type="text">
			</div>
			<label>總金額：</label><input name="totalResult" type="text"
				v-model="newMed.total" v-bind:class="{totalResult}"
				value="${item.total}" /> <a v-on:click="editMedItems"
				class="btn btn-info">修改藥品項目</a>
		</form>
		<input type="hidden" id="ctx" value="<c:url value="/" />" />
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/company.js" />"></script>
	<script type="text/javascript"
		src="https://unpkg.com/vue@2.1.4/dist/vue.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/addItem.js" />"></script>
	<script>
		$(function() {
			$("#inputday").datepicker({
				dateFormat : "yy-mm-dd",
				orientation : 'bottom auto'
			});
			$("#inputday").datepicker().on("change", function(e) {
				app.$data.newMed.inputday = $(this).val();
			});
		});
	</script>
</body>
</html>
