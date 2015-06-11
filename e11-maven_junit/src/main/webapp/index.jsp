<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Esimerkki 11</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
</head>
<body>
<h1><a href="http://agileo.fi" class="companylogo">Agileo<img src="images/agileo_logo.png" alt="Agileo"/></a></h1>
<h1 id="coursetitle">Spring Framework</h1>
<h2>Esimerkki 11</h2>

	<div id="contentbox">
		<h3>Sisältö</h3>
		<ul>
			<li>Maven</li>
			<li>JUnit</li>
		</ul>
		<h3>Toiminta</h3>
		<p>Demo sisältää kaksi sovellusta, laskimen ja kellon.
			Laskin-luokan metodeita on testattu JUnit-yksikkötesteillä.
			SuomiKello-luokan metodeita on myös testattu yksikkötesteillä ja
			ulkoinen KelloLahde on rajattu testistä pois käyttäen Mock-oliota.</p>
		<h4>Kello-sovelluksen luokkakaavio</h4>
		<p>
			<img src="images/kello_luokkakaavio.png" />
		</p>
		<h3>Linkit</h3>
		<ul>
			<li><a href="laskin">laskin</a></li>
			<li><a href="kello">kello</a></li>
		</ul>
	</div>
</body>
</html>