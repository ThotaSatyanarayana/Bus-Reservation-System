$(document).ready(function() {
	$('#month').on('change', function() {
		$.ajax({
			type : "get",
			url : "dates",
			data : "month=" + $("#month").val() + "&year=" + $("#year").val(),
			success : function(result) {
				var result = JSON.parse(result);
				var s='';
				for (var i = 0; i < result.length; i++) {
					s += '<option value="'+result[i]+'">'
							+ result[i] + '</option>';
				}
				$('#day').html(s);
			},
			error : function() {
				alert("error")
			}
		});
	});
});
