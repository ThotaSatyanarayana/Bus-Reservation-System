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
	<legend id="legend">CancelTicket</legend>
	<img src="resources/img/bus.jpg" width="100%" height="50%" />
	<hr />
	<table>
		<tr>
			<td><input type="button" onclick="location.href='Login';"
				value="Reservation" /></td>
			<td><input type="button"
				onclick="location.href='reservationhistory';" value="History" /></td>
			<td><input type="button" onclick="location.href='CancelTicket';"
				value="CancelTicket" /></td>
		</tr>
	</table>
	<form:form modelAttribute="ticket" action="cancelticket" method="post">
		<table id="register">
			<tr>
				<td></td>
				<td><p style="color: red">${ticketmessage }</p></td>
			</tr>
			<tr>
				<td>TicketNo:</td>
				<td><form:input path="reserve_id" /></td>
				<td><form:errors path="reserve_id" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="CancelTicket" /></td>
			</tr>
		</table>
	</form:form>
</fieldset>
