<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="resources/css/style.css">
<fieldset id="fieldset">
	<legend id="legend">ReservationHistory</legend>
	<img src="resources/img/bus.jpg" width="100%" height="50%" />
	<hr />
	<table>
		<tr>
			<td><input type="button" onclick="location.href='Route';"
				value="Reservation" /></td>
			<td><input type="button"
				onclick="location.href='reservationhistory';" value="History" /></td>
			<td><input type="button" onclick="location.href='CancelTicket';"
				value="CancelTicket" /></td>
		</tr>
	</table>
	<form:form>
		<table>
			<tr>
				<th>TicketNo</th>
				<th>BusNo</th>
				<th>Date</th>
				<th>Origin</th>
				<th>Destination</th>
				<th>DepartureTime</th>
				<th>ArriavalTime</th>
				<th>Seat</th>
			</tr>
			<c:forEach var="reservation" items="${history }">
				<tr>
					<td>${reservation.reserve_id}</td>
					<td>${reservation.bus_id}</td>
					<td>${reservation.dt}</td>
					<td>${reservation.origin}</td>
					<td>${reservation.destination}</td>
					<td>${reservation.departuretime}</td>
					<td>${reservation.arrivaltime}</td>
					<td>${reservation.seat}</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</fieldset>
