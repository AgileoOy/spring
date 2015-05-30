<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nimen näyttäminen</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
</head>
<body>
<h3>
Tervehdys
<c:out value="${henkilo.etunimi}"/>
<c:out value="${henkilo.sukunimi}"/>!
</h3>
<p><a href="syota_tiedot.jsp">kokeile uudestaan</a></p>
</body>
</html>