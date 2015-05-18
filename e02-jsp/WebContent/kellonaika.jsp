<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
SimpleDateFormat formatoija = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
Date nykyhetki = new Date();
String muotoiltuAika = formatoija.format(nykyhetki);    
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kellonaika</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
<META HTTP-EQUIV="refresh" CONTENT="1">
</head>
<body>
<h3>Kellonaika</h3>
<p><%=muotoiltuAika %></p>
</body>
</html>