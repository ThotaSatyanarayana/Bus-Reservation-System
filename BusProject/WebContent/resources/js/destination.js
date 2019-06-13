$(document).ready(function() {
$('#origin').on(
			'change',
			function() {
				$.ajax({
					type : "get",
					url : "destinations",
					data : "origin=" + $("#origin").val(),
					success : function(result) {
						var result = JSON.parse(result);
						var s = '<option value="Select Destination">Select Destination</option>';
						for (var i = 0; i < result.length; i++) {
							s += '<option value="'+result[i].destination+'">'
									+ result[i].destination + '</option>';
						}
						$('#destination').html(s);
						
					},
					error : function() {
						alert("error")
					}
				});
		});
});
