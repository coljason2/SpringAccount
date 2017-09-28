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

	<form class="form-control">
		<!-- Form Name -->
		<label>記帳表單</label>
		<!-- Select Basic -->
		<div>
			<label>藥廠：</label> <select id="company">
				<c:forEach items="${companys}" var="company">
					<option value="${company.com_name}">${company.com_name}</option>
				</c:forEach>
			</select> <label>藥品：</label> <select id="medicine">
				<option>請選擇藥品</option>
			</select> <label>進貨日期：</label> <input id="inputday" name="inputday"
				placeholder="選擇日期" type="text">

		</div>
		<!-- Text input-->
		<div>
			<label>價格：</label> <input id="cost" name="cost" v-model="cost"
				placeholder="進貨價格" type="text"> <label>數量：</label> <input
				id="count" name="count" v-model="count" placeholder="藥品數量"
				type="text">
		</div>

		<!-- Text input-->
		<div>
			<label>折讓一：</label> <input id="discount1" name="discount1"
				v-model="discount1" placeholder="折讓金額一" type="text"> <label
				for="discount2">折讓二：</label> <input id="discount2" name="discount2"
				v-model="discount2" placeholder="折讓金額二" type="text"> <label>折讓三：</label><input
				id="discount3" name="discount3" v-model="discount3" number
				placeholder="折讓金額三" type="text">
		</div>
		<label>總金額：</label><input type="text" v-model="total"
			v-bind:class="{totalResult}" /> {{name}}

	</form>
	<div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>藥名</th>
					<th>進貨日期</th>
					<th>藥價</th>
					<th>數量</th>
					<th>折扣1</th>
					<th>折扣2</th>
					<th>折扣3</th>
					<th>總額</th>
				</tr>
			</thead>
		</table>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/company.js" />"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.0.3/vue.js"></script>
	<script>
		var app = new Vue({

			el : '.form-control',
			data : {
				items : [],
				name : '藥名',
				cost : 0,
				count : 0,
				discount1 : 0,
				discount2 : 0,
				discount3 : 0,
				total : 0,
			},
			computed : {
				totalResult : function() {
					return this.total = this.cost - this.discount1
							- this.discount2 - this.discount3;
				}
			}
		});
	</script>
	<script>
		$(function() {
			$("#inputday").datepicker({
				dateFormat : "yy-mm-dd",
				orientation : 'bottom auto'
			});
		});
	</script>
</body>
</html>