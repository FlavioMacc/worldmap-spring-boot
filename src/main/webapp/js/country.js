$(document).on('click','a.continent',function(){
	
	var continent = $(this).text();
	showCountries(continent);
});

function showCountries(continent)
{
	$("#backButton").val("continent");
	$("#infoBackPage").val(continent);
	
	$.get("nationjdbc",{continent : continent} ,function(response) {
		var out = "";
		var list="";
		
		out += '<h1><b style="font-size: 70px; color: red;">NAZIONI DEL CONTINENTE </b></h1>';
		
		$.each(response, function (i,list){
			out+='<a class="nation" style="font-size: 60px; color: blue;">'+list.name+'<input type="hidden" value="'+list.code+'"></a><br>';
		});
		$("#list").html(out);
		$("#footer").show();
	});
}
