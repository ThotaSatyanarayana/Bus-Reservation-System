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
<fieldset id="fieldset">
	<legend id="legend">Login Form</legend>
	<img src="resources/img/bus.jpg" width="100%" height="50%" />
	<hr />
	<form:form modelAttribute="passenger" action="login" method="post">
		<table id="register">
			<tr>
				<td></td>
				<td><p style="color: red">${fail }</p></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" /> <input type="button"
					onclick="location.href='Register';" value="Register" /></td>
			</tr>
		</table>
	</form:form>
</fieldset>

<style>
.error {
	color: red;
}
</style>
