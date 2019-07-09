$(document).on('click','a.nation',function(){

	var countryCode=$(this).find('input').val();
	getOrder(countryCode,"");
	
});

$(document).on('click','a.delete',function(){
	
	var idCity=$(this).find('input').val();
	var countryCode=$("#infoCurrentPage").val();

	$.delete("city/"+idCity+"/delete",function(response){ 
		});
	getOrder(countryCode,"");
	
});

$(document).on('click','a.insertView',function(){
	var countryCode=$("#infoCurrentPage").val();
	
	$("#backButton").val("city");
	$("#list").hide();
	
	getAllCoutries(countryCode);
	//$("input[value = 'submit']").val("INSERISCI");
	$("#formUpdate").show();
});

$(document).on('click','a.insert',function(){
	
	var nameCity="";
	var coutryCode=$("#infoCurrentPage").val();
	
	$.post("city/insert/",{"name" : nameCity, "countrycode": coutryCode},function(response){},"json");
	
	$("#backButton").val("country");
	$("#formUpdate").hide();
	$("#list").show(); 
	
	getOrder(coutryCode,"");
});

$(document).on('click','#orderButton',function(){
	var order= $("#orderButton").val();
	var coutryCode=$("#infoCurrentPage").val();
	getOrder(coutryCode,order);	
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
			out += '<td style="width: 25%"><a class="delete" id="Abutton">DELETE <input type="hidden" value="'+list.idCity+'"></a></td>';
			out += '<td style="width: 25%"><a class="update" id="Abutton">MODIFY </a></td></tr>';
		});
		out += '</table>';
		out += '<br><a class="insertView" id="Abutton">INSERT CITY</a>';
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

function getAllCoutries(countryCode){
	
	$.get("getAllCountries",function(response){
		var list="";
		
		$.each(response, function (i,list){
			if(countryCode != list.code){
				$("select").append('<option value="'+list.code+'">'+list.name+'</option>');
			}
			else{
				$("select").append('<option value="'+list.code+'" selected>'+list.name+'</option>');
			}
		});
	});
	
}




