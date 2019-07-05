$(document).ready(function() {
	$.get("continent", function(response) {
		var out = "";
		var list="";
		
		out += '<h1><b style="font-size: 70px; color: red;">CONTINENTI TERRESTRI</b></h1>';
		
		$.each(response, function (i,list){
			out+='<b style="font-size: 60px; color: blue;"><p>'+list+'</p></b>';
		});
		$("#list").html(out);
		
	});
});
