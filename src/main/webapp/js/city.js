$(document).on('click','a.nation',function(){
	var countryCode = $(this).value();
	$.get("cityJdbc",{nation : countryCode} ,function(response) {
		var out = "";
		var list="";
		
		out += '<h1><b style="font-size: 70px; color: red;">CITTA DELLA NAZIONE</b></h1>';
		
		$.each(response, function (i,list){
			out+='<a class="city" style="font-size: 60px; color: blue;" value="'+list.ID+'">'+list.name+'</a>';
		});
		$("#list").html(out);
		
	});
	
});
