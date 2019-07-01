<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nazioni</title>
<link href="stile.css" rel="stylesheet" type="text/css">
</head>
<body>

	<h1 align="center">
		<b style="font-size: 60px; color: red;">NAZIONI DEL CONTINENTE
			-${continent}-</b>
	</h1>

	<div align="center" id="list">
		
		
		<script type="text/javascript">
			//var continent = window.location.continent;
		
			var xmlhttp = new XMLHttpRequest();
			var url = "nationjdbc?continent="+continent;

			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var info = JSON.parse(this.responseText);
					//showCountries(countries);
				}
			};
			xmlhttp.open("GET", url, true);
			xmlhttp.send();

			function showContinent(countries) {
				var out = "";
				var i;

				for (i = 0; i < countries.length; i++) {
					out += '<b style="font-size: 60px; color: blue;"><a href="' + countries[i].code+ '">' + countries[i].name
							+ '</a></b><br>';
				}
				document.getElementById("list").innerHTML = out;
			}
			
			
		</script>
		
		

		<!-- <table style="width: 100%">
			<c:forEach items="${result}" var="nazione">

				<tr>
					<td style="width: 50%"><a
						href="cityJdbc?nation=${nazione.code}"><b
							style="font-size: 60px; color: blue;">${nazione.name}</b></a></td>
					<td style="width: 50%"></td>
				</tr>

			</c:forEach>
		</table>  -->
		
	</div>
	
	<div>
	<br> <a href="continent"><img alt="back page button"
			src="backButton.png" width="100px"></a>
	</div>
	
</body>
</html>