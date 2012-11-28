<html>
<head>
<title>Demo</title>
<link href="static/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Home</h1>

	<%
		if (request.getParameter("isdemo") == "true") {
	%>
	<%@ include file="/demo.jsp"%>
	<%
		}
	%>

	<a href="CoffeForm.jsp">Open Coffe Form</a>
</body>
<html>