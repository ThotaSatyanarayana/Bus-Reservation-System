$(document).ready(function() {
		$.ajax({
			type : "get",
			url : "/BusProject/avilableseats",
			success : function(result) {
				var result = JSON.parse(result);
				$("input[name='seat']").each(function() {
					if ($(this).checked) { 
					    var sThisVal = ($(this).checked ? $(this).parent().children("span").attr("class") : "");
					    result += (result=="" ? sThisVal : "," + sThisVal);
					    }
				});
				for (var i = 0; i < result.length; i++) {
				$("input[name='seat'][value='"+result[i]+"']").prop('disabled',true)
				}
			}, 
			
			error : function() {
				alert("error")
			}
	});
});