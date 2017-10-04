<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>新增藥品細項</title>
</head>
<body>
	<div id="app">
		<form class="form-control">
			<!-- Form Name -->
			<label>記帳表單</label>
			<!-- Select Basic -->
			<div>
				<label>藥廠：</label> <select id="company" v-model="newMed.company">
					<c:forEach items="${companys}" var="company">
						<option value="${company.com_name}">${company.com_name}</option>
					</c:forEach>
				</select> <label>藥品：</label> <select id="medicine" v-model="newMed.name">
					<option>請選擇藥品</option>
				</select> <label>進貨日期：</label> <input id="inputday" name="inputday"
					v-model="newMed.inputday" type="text">
			</div>
			<!-- Text input-->
			<div>
				<label>價格：</label> <input id="cost" name="cost"
					v-model="newMed.cost" placeholder="進貨價格" type="text"> <label>數量：</label>
				<input id="count" name="count" v-model="newMed.count"
					placeholder="藥品數量" type="text">
			</div>

			<!-- Text input-->
			<div>
				<label>折讓一：</label> <input id="discount1" name="discount1"
					v-model="newMed.discount1" placeholder="折讓金額一" type="text">
				<label>折讓二：</label> <input id="discount2" name="discount2"
					v-model="newMed.discount2" placeholder="折讓金額二" type="text">
				<label>折讓三：</label> <input id="discount3" name="discount3"
					v-model="newMed.discount3" placeholder="折讓金額三" type="text">
			</div>
			<label>總金額：</label><input name="totalResult" type="text"
				v-model="newMed.total" v-bind:class="{totalResult}" /> <a
				class="btn btn-primary" v-on:click="createMedItem">新增藥品</a>
		</form>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>藥廠</th>
					<th>藥名</th>
					<th>進貨日期</th>
					<th>藥價</th>
					<th>數量</th>
					<th>折扣-1</th>
					<th>折扣-2</th>
					<th>折扣-3</th>
					<th>總額</th>
					<th>功能</th>
				</tr>
			</thead>
			<thead>
				<tr v-for="med in MedItems">
					<td>{{ med.company }}</td>
					<td>{{ med.name }}</td>
					<td>{{ med.inputday }}</td>
					<td>{{ med.cost }}</td>
					<td>{{ med.count }}</td>
					<td>{{ med.discount1 }}</td>
					<td>{{ med.discount2 }}</td>
					<td>{{ med.discount3 }}</td>
					<td>{{ med.total }}</td>
					<td><a class="btn btn-danger" v-on:click="deleteMedItem">Delete
					</a></td>
				</tr>
		</table>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/company.js" />"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.0.3/vue.js"></script>
	<script src="<c:url value="/resources/js/addItem.js" />"></script>
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
