<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/BusProject/resources/css/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="/BusProject/resources/js/seat.js"></script>
<fieldset id="fieldset">
	<legend id="legend">Seats</legend>
	<img src="/BusProject/resources/img/bus.jpg" width="100%" height="50%" />
	<hr />
	<form:form modelAttribute="seats" action="/BusProject/saveseat"
		method="post">
		<p style="color: red">${seatmessage }</p>
		<fieldset class="group">
			<legend>Book</legend>
			<ul class="checkbox">
				<li><form:checkboxes path="seat" items="${seatslist }" /></li>
			</ul>
			<table align="center">
				<tr>
					<td><input type="submit" value="Book" /></td>
				</tr>

			</table>
		</fieldset>
	</form:form>
</fieldset>
<style>
fieldset.group {
	margin: 0;
	padding: 0;
	margin-bottom: 1.25em;
	padding: .125em;
}

fieldset.group legend {
	margin: 0;
	padding: 0;
	font-weight: bold;
	margin-left: 20px;
	font-size: 100%;
	color: black;
}

ul.checkbox {
	margin: 0;
	padding: 0;
	margin-left: 20px;
	list-style: none;
}

ul.checkbox li span {
	margin-right: 9%;
	margin-left: 9%;
}

ul.checkbox li {
	border: 1px transparent solid;
	display: inline-block;
	width: 45em;
}

ul.checkbox li label {
	margin-left:;
}

input[type=checkbox] {
	zoom: 1.6;
}
</style>
