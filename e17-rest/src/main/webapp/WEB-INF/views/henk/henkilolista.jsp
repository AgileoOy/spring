<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="resources/styles/list.css">
<title>Henkil&ouml;t</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>

//dokumentin latautuessa aktivoidaan tapahtumankuuntelijat
$(document).ready(function(){
	
	//tyhjennysnappia painettaessa
	$("#tyhjennysnappi").click(function() {
		$("#lista").empty();
	});
	
	//latausnappia painettaessa
	$("#latausnappi").click(function() {
		
		//ladataan JSON-dataa palvelimelta
		$.getJSON( "henkilot.json", function( data ) {
			$.each( data, function( key, val ) {
				//listaan uusi käyntikortti
				var henk = $("<section class='Olio'/>").appendTo("#lista");
				//nimi käyntikorttiin
				$("<h2/>").text(val.etunimi + " " +val.sukunimi).appendTo(henk);
				//email käyntikorttiin
				var linkki = $("<a/>", {html: val.sahkoposti, href: "mailto:"+val.sahkoposti});
				$("<p/>").append(linkki).appendTo(henk);
				//osoite käyntikorttiin
				$("<p/>").append(val.lahiosoite + ", " + val.postinumero + " " + val.postitoimipaikka).appendTo(henk);
			});
		}).error(function() { //palvelinyhteys aiheutti virheen
			$("<p class='Error'>Virhe: Palvelin ei palauta JSON-dataa. Tarkista tietokantayhteys.</p>").appendTo("#lista");
		});
		
	});
	
});
</script>
</head>
<body>
<h1>Henkil&ouml;t</h1>
<p><button id="latausnappi">Lataa</button> <button id="tyhjennysnappi">Tyhjenn&auml;</button>
<div id="lista" ></div>
</body>
</html>