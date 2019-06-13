$(document).ready(function() {
$('#preview').on('change', function() {
		var ext = $(this).val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
			alert("please select only images")
		}else{
		$('#output').attr('src', window.URL.createObjectURL(this.files[0]));
		}
	});
});