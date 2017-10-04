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
		}

	}
});