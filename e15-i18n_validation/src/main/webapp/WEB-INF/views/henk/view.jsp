<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="henk.view.title"/></title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>	
<body>

	<div id="langsel">
		<a href="?lang=en">en</a> | <a href="?lang=fi">fi</a>
	</div>
	
	<h1>
		<spring:message code="henk.view.heading"/>
	</h1>
	<p><c:out value="${henkilo.etunimi}" default="-----"/></p>
	<p><c:out value="${henkilo.sukunimi}" default="-----"/></p>
	<p><c:out value="${henkilo.sahkoposti}" default="-----"/></p>
	<p><c:out value="${henkilo.lahiosoite}" default="-----"/></p>
	<p><c:out value="${henkilo.postinumero}" default="-----"/></p>
	<p><c:out value="${henkilo.postitoimipaikka}" default="-----"/></p>
	<p><a href="uusi"><spring:message code="back"/></a>
</body>
</html>