$(function() {
	$("#company").change(
			function() {
				var company = $("#company").val();
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
				var ctx = window.location.pathname.split("/")[1];
				$
						.ajax({
							type : "POST",
							url : "/" + ctx + "/AjaxSelectCompany",
							data : {
								comName : company

							},
							dataType : "json",
							beforeSend : function(xhr) {
								xhr.setRequestHeader(header, token);
							},
							error : function() {
								alert("資料傳輸有誤")
							},
							success : function(data) {
								$("#medicine").empty();
								//$("#medicine").append(
										//"<option value=''>選擇藥品</option>");
								$.each(data, function(index, item) {
									$("#medicine").append(
											"<option value='" + item + "'>"
													+ item + "</option>");
								});
							}
						});
			});
});
