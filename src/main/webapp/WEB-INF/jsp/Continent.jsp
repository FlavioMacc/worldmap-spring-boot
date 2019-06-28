<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Continenti</title>
<link href="stile.css" rel="stylesheet" type="text/css">
</head>
<body>


	<div align="center" id="listContinent">

		<h1>
			<b style="font-size: 70px; color: red;">CONTINENTI TERRESTRI</b>
		</h1>

		<script type="text/javascript">
			var xmlhttp = new XMLHttpRequest();
			var url = "continent";

			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var continents = JSON.parse(this.responseText);
					snowContinent(continents);
				}
			};
			xmlhttp.open("POST", url, true);
			xmlhttp.send();


			function snowContinent(continents) {
				var out = "";
			    var i;
			    
			    for(i = 0; i < continents.length; i++) {
			        out += '<a href="' + continents[i]+ '">' + 
			        continents[i]+ '</a><br>';
			    }
			    document.getElementById("listContinent").innerHTML = out;

			}
		</script>


		<!-- <c:forEach items="${result}" var="continente">
			<a href="nationjdbc?continent=${continente}"><b
				style="font-size: 60px; color: blue;">${continente}</b></a>
			<br>
		</c:forEach> -->

	</div>


</body>
</html>