$(document).ready(function() {
	
	$.get("continent", function(response) {
		var out = "";
		var list="";
		
		out += '<h1><b style="font-size: 70px; color: red;">CONTINENTI TERRESTRI</b></h1>';
		
		$.each(response, function (i,list){
			out+='<a class="continent" style="font-size: 60px; color: blue;">'+list+'</a> <br>';
		});
		$("#list").html(out);
		
	});
	
});