<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="styles/common.css">
<title>Laskin</title>
</head>
<body>
	<h1>Laskin</h1>
	<form action="laskin" method="get">

		<input type="text" name="luku1" placeholder="eka kokonaisluku"
			value="<c:out value="${param.luku1}"/>" />

		<button type="submit" name="operaatio" value="summa">+</button>
		<button type="submit" name="operaatio" value="kerto">*</button>

		<input type="text" name="luku2" placeholder="toka kokonaisluku"
			value="<c:out value="${param.luku2}"/>" />
		=
		<c:out value="${tulos}" />
	</form>

</body>
</html>