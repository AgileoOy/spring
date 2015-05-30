<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Esimerkki 4</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
</head>
<body>

<h1><a href="http://agileo.fi" class="companylogo">Agileo<img src="images/agileo_logo.png" alt="Agileo"/></a></h1>
<h1 id="coursetitle">Spring Framework</h1>
<h2>Esimerkki 4</h2>

<div id="contentbox">
<h3>Sisältö</h3>
<ul>
<li>Request attribute</li>
<li>Request dispatcher forward</li>
<li>Kirjastot</li>
<li>JSTL (JavaServer Pages Standard Tag Library)</li>
<li>HTTP request method POST</li>
<li>Escape XML (suojautuminen XSS:iä vastaan)</li>
</ul>
<h3>Toiminta</h3>
<p>Lomakkeelle syötetään etunimi ja sukunimi, jotka lähetetään servletille. Servlet paketoi parametrit yhteen olioon, tallentaa olion requestin atribuutiksi ja forwardoi pyynnön jsp-sivulle. Jsp-sivu hoitaa tulostuksen muotoilun.</p>
<h3>Linkki</h3>
<p><a href="syota_tiedot.jsp">syota_tiedot.jsp</a></p>
</div>
</body>
</html>