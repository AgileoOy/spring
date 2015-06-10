<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Esimerkki 15</title>
<link rel="stylesheet" type="text/css"
	href="resources/styles/common.css">
</head>
<body>
<h1><a href="http://agileo.fi" class="companylogo">Agileo<img src="resources/images/agileo_logo.png" alt="Agileo"/></a></h1>
<h1 id="coursetitle">Spring Framework</h1>
<h2>Esimerkki 15</h2>

	<div id="contentbox">
		<h3>Sisältö</h3>
		<ul>
			<li>Internationalization (I18n)</li>
			<li>Localization (L10n)</li>
			<li>Bean validation (JSR 303)</li>
			<li>Custom annotation</li>
			<li>Custom validator</li>
		</ul>
		<h3>Toiminta</h3>
		<p>Käyttäjä voi vaihtaa käyttöliittymän kieltä napin
			painalluksella. Kaikki kieliriippuvaiset tekstit on tallennettu
			kielikohtaisiin properties-tiedostoihin. Henkilön ominaisuuksia on
			laajennettu. Mikäli syötetty data ei ole validia, käyttäjä ohjataan
			takaisin lomakesivulle ja häntä opastetaan korjaamaan virheet.</p>
		<h3>Linkki</h3>
		<p>
			<a href="henkilot/uusi">henkilot/uusi</a>
		</p>
	</div>
</body>
</html>