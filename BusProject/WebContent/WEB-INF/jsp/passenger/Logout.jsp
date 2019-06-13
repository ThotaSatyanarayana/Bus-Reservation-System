<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="/BusProject/resources/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<fieldset id="fieldset">
	<legend id="legend">Logout</legend>
	<img src="/BusProject/resources/img/bus.jpg" width="100%" height="50%" />
	<hr />
	<%
		session.removeAttribute("id");
		session.invalidate();
		response.sendRedirect("Login");
	%>
</fieldset>
