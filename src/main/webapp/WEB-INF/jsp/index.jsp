<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Continenti</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/continent.js"></script>
<script type="text/javascript" src="/js/country.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!--  <script type="text/javascript">


	var order = "A-z";

	function setOrder(execute) {
		order = document.getElementById('orderButton').value;

		if (execute)
			requestAtServer("cityJdbc", "GET", "order=" + order);

		if (order == "A-z") {
			order = "Z-a";
		} else {
			order = "A-z";
		}

	}

	function backPage() {
		var route = document.getElementById('backButton').value;

		switch (route) {
		case "continent":

			requestAtServer("continent", "POST", "");

			break;
		case "country":

			requestAtServer("nationjdbc", "GET", "");

			break;
		}
	}

	function deleteCity(idCity) {
		requestAtServer("/deleteCity", "GET", "idCity=" + idCity);
		requestAtServer("cityJdbc", "GET", "");
	}

	function requestAtServer(url, method, params) {

		var xmlhttp = new XMLHttpRequest();

		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var info = JSON.parse(this.responseText);

				switch (url) {

				case "cityJdbc":

					showCities(info);
					document.getElementById('backButton').value = "country";

					break;

				case "nationjdbc":

					showCountries(info);
					document.getElementById('footer').style.display = 'block';
					document.getElementById('backButton').value = "continent";

					break;

				case "continent":

					showContinents(info);
					document.getElementById('footer').style.display = 'none';

					break;

				}

			}
		};
		xmlhttp.open(method, url + "?" + params, true);
		xmlhttp.send();
		//xmlhttp.send(params);

	}
	
	function showCountries(countries) {
		var out = "";
		var i;
		var url = "'cityJdbc'";
		var method = "'GET'";
		var params = "";

		out += '<h1><b style="font-size: 70px; color: red;">CITTA DELLA NAZIONE</b></h1>';

		for (i = 0; i < countries.length; i++) {

			params = "'nation=" + countries[i].code + "'";

			out += '<b style="font-size: 60px; color: blue;"><p value="'
					+ countries[i].code + '" onclick="requestAtServer(' + url
					+ ',' + method + ',' + params + ')">' + countries[i].name
					+ '</p></b>';
		}

		//var myNode = document.getElementById("list");
		//while (myNode.firstChild) {
		//myNode.removeChild(myNode.firstChild);
		//}

		document.getElementById("list").innerHTML = out;

	}

	function showCities(cities) {
		var out = "";
		var i;

		out += '<h1><b style="font-size: 70px; color: red;">CONTINENTI TERRESTRI</b></h1><br>';
		out += '<table style="width: 100%">';
		out += '<tr><td><b style="font-size: 40px; color: green;">NOME CITTA<input type="button" id="orderButton" value="'
				+ order
				+ '" onload="setOrder('
				+ false
				+ ')" onclick="setOrder(' + true + ')"></b></td></tr>';

		for (i = 0; i < cities.length; i++) {

			out += '<tr style="width: 50%">';
			out += '<td><b style="font-size: 60px; color: blue;"><p value="'+cities[i].idCity+'">'
					+ cities[i].name + '</p></b></td>';
			out += '<td style="width: 25%"><p id="Abutton" onclick="deleteCity('
					+ cities[i].idCity + ')"> DELETE </p></td>';
			out += '<td style="width: 25%"><p id="Abutton"> MODIFY </p></td>';
		document.getElementById("list").innerHTML = out;
	}
</script> -->


</head>
<body>



	<div align="center" id="list"></div>
	<br>
	<div align="center" id="footer" style="display: none;">

		<button type="button" id="backButton" value="" onclick="backPage()">TORNA
			INDIETRO</button>
	</div>


</body>
</html>