<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (session != null) {
		if (session.getAttribute("id") != null) {
			int id = (Integer) session.getAttribute("id");
		} else {
			response.sendRedirect("Login");
		}
	}
%>
<link rel="stylesheet" href="resources/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="resources/js/destination.js"></script>
<script src="resources/js/date.js"></script>
<fieldset id="fieldset">
	<legend id="legend">Bus Route</legend>
	<img src="resources/img/bus.jpg" width="100%" height="50%" />
	<hr />
	<ul style="list-style: none">
		<li><input type="button" onclick="location.href='Logout';"
			value="Logout"
			style="color: white; background-color: red; float: right;" /></li>
	</ul>
	<table>
		<tr>
			<td><input type="button"
				onclick="location.href='reservationhistory';" value="History" /></td>
			<td><input type="button" onclick="location.href='CancelTicket';"
				value="CancelTicket" /></td>

		</tr>
	</table>

	<form:form modelAttribute="route" method="post" action="searchbus"
		id="search">
		<table>
			<tr>
				<td>Origin</td>
				<td><form:select path="origin" id="origin">
						<form:option value="Select Source" label="Select Source" />
						<form:options items="${routes }" />
					</form:select></td>
				<td><form:errors path="origin" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><form:select path="destination" id="destination">
						<form:option value="Select Destination" label="Select Destination" />
					</form:select></td>
				<td><form:errors path="destination" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td>Departure</td>
				<td><form:select path="month">
						<form:option value="Select Month" label="Select Month" />
						<form:options items="${monthnames }" />
					</form:select>-<form:select path="day" id="day"></form:select>-<form:select
						path="year" items="${years }">
					</form:select></td>
				<td><form:errors path="month" cssClass="errors"></form:errors></td>
				<td><p style="color: red">${datemessage }</p></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form:form>
</fieldset>
