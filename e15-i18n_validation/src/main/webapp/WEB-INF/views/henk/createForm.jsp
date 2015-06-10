<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="henk.create.title" /></title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>	
<body>

	<div id="langsel">
		<a href="?lang=en">en</a> | <a href="?lang=fi">fi</a>
	</div>

	<h1>
		<spring:message code="henk.create.heading" />
	</h1>
	

	
		<form:form modelAttribute="henkilo" method="post">
		  	<fieldset>		
				<legend><spring:message code="henk.create.legend" /></legend>
				
				<spring:hasBindErrors name="henkilo">
					<p class="Virheotsikko"><spring:message code="henk.create.errors" />:</p>
					<div class="Virheblokki"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
				<p>
					<form:label	path="etunimi"><spring:message code="henk.create.firstname" /></form:label><br/>
					<form:input path="etunimi" cssErrorClass="VirheellinenKentta"/> <form:errors path="etunimi" cssClass="Virheteksti"/>		
				</p>
				<p>	
					<form:label path="sukunimi"><spring:message code="henk.create.lastname" /></form:label><br/>
					<form:input path="sukunimi" cssErrorClass="VirheellinenKentta"/> <form:errors path="sukunimi" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<form:label path="sahkoposti"><spring:message code="henk.create.email" /></form:label><br/>
					<form:input path="sahkoposti" cssErrorClass="VirheellinenKentta"/> <form:errors path="sahkoposti" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<form:label path="lahiosoite"><spring:message code="henk.create.address" /></form:label><br/>
					<form:input path="lahiosoite" cssErrorClass="VirheellinenKentta"/> <form:errors path="lahiosoite" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<form:label path="postinumero"><spring:message code="henk.create.postalcode" /></form:label><br/>
					<form:input path="postinumero" cssErrorClass="VirheellinenKentta"/> <form:errors path="postinumero" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<form:label path="postitoimipaikka"><spring:message code="henk.create.postaloffice" /></form:label><br/>
					<form:input path="postitoimipaikka" cssErrorClass="VirheellinenKentta"/> <form:errors path="postitoimipaikka" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<button type="submit"><spring:message code="henk.create.add" /></button>
				</p>
			</fieldset>
		</form:form>
</body>
</html>