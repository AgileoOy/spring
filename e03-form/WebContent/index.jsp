<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Esimerkki 3</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
</head>
<body>
<h1><a href="http://agileo.fi" class="companylogo">Agileo<img src="images/agileo_logo.png" alt="Agileo"/></a></h1>
<h1 id="coursetitle">Spring Framework</h1>
<h2>Esimerkki 3</h2>

<div id="contentbox">
<h3>Sisältö</h3>
<ul>
<li>HTML lomake</li>
<li>HTTP request method GET</li>
<li>Request parameter</li>
<li>XSS (Cross site scripting)</li>
</ul>
<h3>Toiminta</h3>
<p>Lomakkeelle syötetään nimi, joka lähetetään servletille. Servlet nappaa pyynnöstä parametrin ja muodostaa sivun, johon syötetty nimi tulostetaan.</p>
<h3>Linkit</h3>
<ul>
<li><a href="lomake.jsp">lomake.jsp</a></li>
<li><a href="nayta_syotetty_nimi?etunimi=Matti">nayta_syotetty_nimi?etunimi=Matti</a></li>
<li><a href="nayta_syotetty_nimi?etunimi=Matti<script>alert('OH NO!');</script>">nayta_syotetty_nimi?etunimi=Matti&lt;script&gt;alert('OH NO!');&lt;/script&gt;</a></li>
</ul>
</div>
</body>
</html>