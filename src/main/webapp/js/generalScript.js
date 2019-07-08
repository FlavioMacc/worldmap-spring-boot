$(document).on('click','#backButton',function(){
	var route = $("#backButton").val();
	var infoBackPage = $("#infoBackPage").val();
	
	switch(route)
	{
	case "continent":
			showContinents();
		break;
		
	case "country":
			showCountries(infoBackPage);
		break;
	}	
});

$(document).on('click','#orderButton',function(){
	var order= $("#orderButton").val();
	var coutryCode=$("#infoCurrentPage").val();
	getOrder(coutryCode,order);	
});

function getOrder(coutryCode,order){
	if (order == null || order == "Z-a") {
		order = "A-z";
	} else {
		order = "Z-a";
	}
	
	showCities(coutryCode,order);
}