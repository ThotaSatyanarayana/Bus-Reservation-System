<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="resources/css/style.css">
<fieldset id="fieldset">
	<legend id="legend">Bus Route</legend>
	<img src="resources/img/bus.jpg" width="100%" height="50%" />
	<hr/>
	<form:form>
		<table>
			<tr>
				<td>Origin</td>
				<td>Destination</td>
				<td>Fare</td>
				<td>Departure Time</td>
				<td>Arrival Time</td>
				<td>AvilabiltySeats</td>
				<td>Select</td>
			</tr>
			<c:forEach var="bus" items="${buses }">
				<tr>
					<td>${origin }</td>
					<td>${destination }</td>
					<td>${bus.fare}</td>
					<td>${bus.departuretime}</td>
					<td>${bus.arrivaltime}</td>
					<td>${bus.availablityCount}</td>
					<td><input type="button"
						onclick="location.href='seats/${bus.bus_id}'" value="Seats" /></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</fieldset>
