<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/kirjoituskone.css">
<title>Kirjoituskone</title>
</head>
<body>
<div class="Keskitetty">

<p id="kirjoitettu">
<c:out value="${kokoteksti}"/>
</p>

<p><a href="tyhjenna_sessio" class="Tyhjenna">TYHJENNÄ</a></p>
<p>
<a href="lisaa_kirjain?k=Q">Q</a>
<a href="lisaa_kirjain?k=W">W</a>
<a href="lisaa_kirjain?k=E">E</a>
<a href="lisaa_kirjain?k=R">R</a>
<a href="lisaa_kirjain?k=T">T</a>
<a href="lisaa_kirjain?k=Y">Y</a>
<a href="lisaa_kirjain?k=U">U</a>
<a href="lisaa_kirjain?k=I">I</a>
<a href="lisaa_kirjain?k=O">O</a>
<a href="lisaa_kirjain?k=P">P</a>
<a href="lisaa_kirjain?k=Å">Å</a>
</p>
<p style="text-indent: 5px">
<a href="lisaa_kirjain?k=A">A</a>
<a href="lisaa_kirjain?k=S">S</a>
<a href="lisaa_kirjain?k=D">D</a>
<a href="lisaa_kirjain?k=F">F</a>
<a href="lisaa_kirjain?k=G">G</a>
<a href="lisaa_kirjain?k=H">H</a>
<a href="lisaa_kirjain?k=J">J</a>
<a href="lisaa_kirjain?k=K">K</a>
<a href="lisaa_kirjain?k=L">L</a>
<a href="lisaa_kirjain?k=Ö">Ö</a>
<a href="lisaa_kirjain?k=Ä">Ä</a>
</p>
<p style="text-indent: 15px">
<a href="lisaa_kirjain?k=Z">Z</a>
<a href="lisaa_kirjain?k=X">X</a>
<a href="lisaa_kirjain?k=C">C</a>
<a href="lisaa_kirjain?k=V">V</a>
<a href="lisaa_kirjain?k=B">B</a>
<a href="lisaa_kirjain?k=N">N</a>
<a href="lisaa_kirjain?k=M">M</a>
<a href="lisaa_kirjain?k=,">,</a>
<a href="lisaa_kirjain?k=.">.</a>
<a href="lisaa_kirjain?k=-">-</a>
</p>
</div>

</body>
</html>