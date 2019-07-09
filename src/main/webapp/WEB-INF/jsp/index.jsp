<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/generalScript.js"></script>
<script type="text/javascript" src="/js/continent.js"></script>
<script type="text/javascript" src="/js/country.js"></script>
<script type="text/javascript" src="/js/city.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<div align="center" id="list"></div>
	<br>
	<div align="center" id="footer" style="display: none;">
		<button type="button" id="backButton" value="">TORNA INDIETRO</button>
		<input type="hidden" id="infoBackPage" value=""> 
		<input type="hidden" id="infoCurrentPage" value="">
	</div>

</body>
</html>