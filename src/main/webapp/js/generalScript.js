$(document).on('click','#backButton',function(){
	var route = $("#backButton").val();
	var infoBackPage = $("#infoBackPage").val();
	
	switch(route)
	{
	case "continent":
			$("#infoBackPage").val("");
			showContinents();
		break;
		
	case "country":
			$("#infoCurrentPage").val("");
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
	if (order == "" || order == "Z-a") {
		order = "A-z";
	} else {
		order = "Z-a";
	}
	
	showCities(coutryCode,order);
}
	
	jQuery.each( [ "put", "delete" ], function( i, method ) {
		  jQuery[ method ] = function( url, data, callback, type ) {
		    if ( jQuery.isFunction( data ) ) {
		      type = type || callback;
		      callback = data;
		      data = undefined;
		    }
		 
		    return jQuery.ajax({
		      url: url,
		      type: method,
		      dataType: type,
		      data: data,
		      success: callback
		    });
		  };
		});
