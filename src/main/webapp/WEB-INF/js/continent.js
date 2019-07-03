$(document).ready(function() {
	$.get("continent", function(response) {
		$("#list").html(response);
	});
});

function showContinents(continents) {
	var out = "";
	var i;
	var url = "'nationjdbc'";
	var method = "'GET'";
	var params = "";

	out += '<h1><b style="font-size: 70px; color: red;">CONTINENTI TERRESTRI</b></h1>';

	for (i = 0; i < continents.length; i++) {

		params = "'continent=" + continents[i] + "'";

		out += '<b style="font-size: 60px; color: blue;"><p onclick="requestAtServer('
				+ url
				+ ','
				+ method
				+ ','
				+ params
				+ ')">'
				+ continents[i]
				+ '</p></b>';
	}
	document.getElementById("list").innerHTML = out;
}