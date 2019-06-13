<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Style sheet link -->
<link rel="stylesheet" href="resources/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- Validation -->
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script src="resources/js/formvalidation.js"></script>
<script src="resources/js/image.js"></script>
<fieldset id="fieldset">
	<legend id="legend">Register Form</legend>
	<img src="resources/img/bus.jpg" width="100%" height="50%" />
	<hr />
	<form:form modelAttribute="passenger" action="save" method="post"
		enctype="multipart/form-data">
		<table id="register">
			<tr>
				<td></td>
				<td><p style="color: red">${success }</p></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><form:input path="mobile" /></td>
				<td><form:errors path="mobile" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td>ConfirmPassword:</td>
				<td><form:password path="confirmpassword" /></td>
				<td><form:errors path="confirmpassword" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td>Photo:</td>

				<td><input type="file" name="file" id="preview" /></td>

				<td><form:errors path="photo" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><img id="output"
					style="max-width: 160px; max-height: 120px; border: none;" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" /> <input
					type="button" onclick="location.href='Login';" value="Login" /></td>
			</tr>
		</table>
	</form:form>
</fieldset>

<style>
.error {
	color: red;
}
</style>
