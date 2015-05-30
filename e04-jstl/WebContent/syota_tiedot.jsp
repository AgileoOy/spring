<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lomake</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
</head>
<body>
<h3>Mikä nimesi on?</h3>
<form action="nayta_syotetty_nimi" method="post">
<table>
<tr><td>Etunimi</td><td><input type="text" name="etunimi"/></td></tr>
<tr><td>Sukunimi</td><td><input type="text" name="sukunimi"/></td></tr>
<tr><td>&nbsp;</td><td><button type="submit">Lähetä</button></td></tr>
</table>


</form>
</body>
</html>