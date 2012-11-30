<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page autoFlush="true" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<div class="menu">
<%@ include file="/menu-top.jsp" %>
</div>
<div class="content">
<%@ include file="/content.jsp" %>
</div>

<%! long dt = new Date().getTime(); %>

<%
ResourceBundle resource = ResourceBundle.getBundle("/properties/demo");
System.out.println(resource.getString("welcome"));

%>

<jsp:useBean id="SimpleBean" class="com.trainig.commons.SimpleBean" />
<jsp:setProperty name="SimpleBean" 
                 property="message" 
                 value="demo" />
<H1>Message: <I><%=dt%>
<jsp:getProperty name="SimpleBean" property="message" />
</I></H1>

</body>
</html>