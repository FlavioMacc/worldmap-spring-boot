
$(document).on('click','a.nation',function(){

	var countryCode=$(this).find('input').val();
	getOrder(countryCode,"");
	
});

$(document).on('click','a.delete',function(){
	
	var idCity=$(this).find('input').val();
	var countryCode=$("#infoCurrentPage").val();

	$.delete("city/"+idCity+"/delete",function(response){});
	setTimeout(function(){getOrder(countryCode,"");}, 500);
	$("#list").show();
});

$(document).on('click','a.insertView',function(){
	var countryCode=$("#infoCurrentPage").val();
	
	$("#backButton").val("city");
	$("#list").hide();
	$("input#send").val("INSERT");
	
	getAllCoutries(countryCode);
	$("#formUpdate").show();
});

$(document).on('click','a.updateView',function(){
	
	var countryCode=$("#infoCurrentPage").val();
	
	$("#backButton").val("city");
	$("#list").hide();
	
	var nameCountry= $(this).parent().parent().find("a.city").text();
	var idCity = $(this).find('input').val();
	$("#nameCity").val(nameCountry);
	$("input#send").val("UPDATE");
	$("#idCity").val(idCity);
	
	getAllCoutries(countryCode);
	$("#formUpdate").show();
	
});

$(document).on('click','#send',function(){
	
	var countryCode=$("#infoCurrentPage").val();
	var nameCity=$("#nameCity").val();
	var coutryCodeIns=$("select#listForm").val();
	var idCity = $("#idCity").val();
	
	if(idCity == ""){
		$.ajax({
			type: "POST",
			url: "city/insert/",
			data: JSON.stringify({"name" : nameCity, "countryCode" : coutryCodeIns}),
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(data){
				console.log(data);
			},
			error: function(err) {
				console.log(err);
			}
		});
	}else{
		$.ajax({
			type: "PUT",
			url: "city/update",
			data: JSON.stringify({"name" : nameCity, "countryCode" : coutryCodeIns, "idCity" : idCity}),
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(data){
				console.log(data);
			},
			error: function(err) {
				console.log(err);
			}
		});
	}
	
	$("#backButton").val("country");
	$("#formUpdate").hide();

	setTimeout(function(){getOrder(countryCode,"");}, 500);
	$("#list").show();
	
});

$(document).on('click','#orderButton',function(){
	var order= $("#orderButton").val();
	var countryCode=$("#infoCurrentPage").val();
	getOrder(countryCode,order);	
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
			out += '<td style="width: 25%"><a class="updateView" id="Abutton">MODIFY <input type="hidden" value="'+list.idCity+'"></a></td></tr>';
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
				$("select").append('<option id="countryCityIns" value="'+list.code+'">'+list.name+'</option>');
			}
			else{
				$("select").append('<option id="countryCityIns" value="'+list.code+'" selected>'+list.name+'</option>');
			}
		});
	});
	
}




