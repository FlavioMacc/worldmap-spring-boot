$(document).ready(function(){
	$("p").click(function(){
		var continent="";
		continent=$(this).text();
		alert(continent);
	});
});