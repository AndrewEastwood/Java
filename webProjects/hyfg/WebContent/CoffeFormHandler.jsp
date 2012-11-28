<%@ page import="java.util.*"%>

<html>
<head>
<title>Demo</title>
<link href="static/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Coffee Recommandation JSP View</h1>
	<p>

		<%
			List styles = (List) request.getAttribute("styles");
			Iterator it = styles.iterator();
			while (it.hasNext()) {
				out.print("<br>try: " + it.next());
			}
		%>
	<a href="<%=application.getContextPath()%>/CoffeForm.jsp">Open Coffe Form</a>
	<a href="<%=application.getContextPath()%>">Home</a>
	</p>
	<%  
	
	
	%>
</body>
</html>