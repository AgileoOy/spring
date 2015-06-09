<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Esimerkki 8</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
</head>
<body>
<h1><a href="http://agileo.fi" class="companylogo">Agileo<img src="images/agileo_logo.png" alt="Agileo"/></a></h1>
<h1 id="coursetitle">Spring Framework</h1>
<h2>Esimerkki 8</h2>

	<div id="contentbox">
		<h3>Sisältö</h3>
		<ul>
			<li>PreparedStatement</li>
			<li>SQL Injection</li>
			<li>Oma poikkeusluokka</li>
		</ul>
		<h3>Toiminta</h3>
		<p>Henkilölistaa on laajennettu lisäyslomakkeella. Servletin
			doPost-metodi ottaa vastaan lomakkeen ja pyytää DAO-luokkaa
			suorittamaan lisäyksen. DAO-luokka sisältää uuden lisäysmetodin, joka
			suorittaa uuden henkilön lisäämisen turvallisesti tietokantaan
			käyttäen PreparedStatement-luokkaa. Poikkeustilanteissa heitetään
			DAOPoikkeus takaisin servletille. Mikäli lisäys onnistui
			tietokantaan, servlet ohjaa selaimen uudestaan servletin
			doGet-metodille.</p>
		<h3>Linkki</h3>
		<p>
			<a href="henkilot">henkilot</a>
		</p>
	</div>
</body>
</html>