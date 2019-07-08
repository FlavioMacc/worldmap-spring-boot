$(document).on('click','a.nation',function(){

	var countryCode=$(this).find('input').val();
	getOrder(countryCode,"");
	//showCities(countryCode,"Z-a");
	
});

function showCities(countryCode,order){
	
	$("#backButton").val("country");
	$("#infoCurrentPage").val(countryCode);
	
	$.get("cityJdbc",{nation : countryCode, order : order} ,function(response) {
		var out = "";
		var list="";
		out += '<h1><b style="font-size: 70px; color: red;">CITTA DELLA NAZIONE</b></h1>';
		out += '<table style="width: 100%">';
		out += '<tr><td><b style="font-size: 40px; color: green;">NOME CITTA<input type="button" id="orderButton" value="'+order+'"></b></td></tr>';
		
		$.each(response, function (i,list){

			out += '<tr><td style="width: 50%"><a class="city" style="font-size: 60px; color: blue;">'+list.name+'</a><br>';
			out += '<td style="width: 25%"><a id="Abutton">DELETE <input type="hidden" value="'+list.ID+'"></a></td>';
			out += '<td style="width: 25%"><a id="Abutton">MODIFY </a></td></tr>';
	
		});
		out += '</table>';
		$("#list").html(out);
		
	});

}



