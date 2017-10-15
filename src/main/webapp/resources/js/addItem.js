var app = new Vue({
	el : '#app',
	data : {
		MedItems : [],
		newMed : {
			company : document.getElementById("firstCompany").value,
			inputday : '',
			name : document.getElementById("firstMed").value,
			cost : 0,
			count : 0,
			discount1 : 0,
			discount2 : 0,
			discount3 : 0,
			total : 0
		}
	},
	computed : {
		totalResult : function() {
			return this.newMed.total = this.newMed.cost - this.newMed.discount1
					- this.newMed.discount2 - this.newMed.discount3;
		},
	},
	methods : {
		createMedItem : function() {
			this.MedItems.push(this.newMed);
			this.newMed = {
				company : document.getElementById("firstCompany").value,
				inputday : '',
				name : document.getElementById("firstMed").value,
				cost : 0,
				count : 0,
				discount1 : 0,
				discount2 : 0,
				discount3 : 0,
				total : 0
			}
		},
		deleteMedItem : function(index) {
			// 刪一個數組元素
			this.MedItems.splice(index, 1);
		},
		addMedItems : function() {
			var vm = this
			var JSONMedItems = vm.MedItems
			var ctx = $("#ctx").val()
			var formid = $("#formid").val()
			var token = $("meta[name='_csrf']").attr("content")
			var header = $("meta[name='_csrf_header']").attr("content")
			$.ajax({
				url : ctx + "/VueAddMedItems",
				type : 'POST',
				dataType : 'json',
				contentType : 'application/json;charset=UTF-8',
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token)
				},
				data : JSON.stringify({
					JSONobject : JSONMedItems,
					formid : formid
				}),
				success : function(data) {
					if (data == true) {
						alert('新增成功')
						window.location.href = ctx + '/form/' + formid
								+ '/items'
					} else {
						alert('無資料新增')
					}
				},
				error : function(data) {
					alert("新增失敗")
				}
			})
		}
	}
});
