$(document).on('click','a.nation',function(){

	var countryCode=$(this).find('input').val();
	getOrder(countryCode,"");
	// showCities(countryCode,"Z-a");
	
});

$(document).on('click','a.cityDetele',function(){
	
	var idCity=$(this).find('input').val();
	var countryCode=$("#infoCurrentPages").val();

	$.delete("city/"+idCity+"/delete",function(response){ 
		alert("bueno");
		});
	getOrder(countryCode,"");
	
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
			out += '<td style="width: 25%"><a class="cityDetele" id="Abutton">DELETE <input type="hidden" value="'+list.idCity+'"></a></td>';
			out += '<td style="width: 25%"><a class="cityUpdate" id="Abutton">MODIFY </a></td></tr>';
		});
		out += '</table>';
		$("#list").html(out);
		
	});

}

function getOrder(coutryCode,order){
	if (order == "" || order == "Z-a") {
		order = "A-z";
	} else {
		order = "Z-a";
	}
	
	showCities(coutryCode,order);
}

$(document).on('click','#orderButton',function(){
	var order= $("#orderButton").val();
	var coutryCode=$("#infoCurrentPage").val();
	getOrder(coutryCode,order);	
});


