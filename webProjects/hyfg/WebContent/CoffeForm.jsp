<html>
<head>
<title>Coffee Advisor></title>
<link href="static/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
  <h1 align="center">Coffee Advisor </h1>
  <form method="POST" action="coffe-form-answer.do">
    Select coffee 
    Type:
    <select name="type" size=1">
      <option value="milky">Milky</option>
      <option value="froffy">Froffy</option>
      <option value="icey">Icey</option>
      <option value="strong">Spaced Out</option>
    </select>
    <br><br>
    <center>
      <input type="Submit">
    </center>
   </form>
	<a href="<%=application.getContextPath()%>">Home</a>
</body>
<html>