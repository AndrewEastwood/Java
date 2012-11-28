<%@ page import="java.util.Locale "%>

<%
Locale l = request.getLocale();
out.println("Locale is :"+l);
String contextPath = request.getContextPath();

%>

<p>Test Jsp. Context path for this page is : <%=contextPath%></p> 

<p> getServletPath: <%= request.getServletPath() %></p>
<p> getContentType: <%= request.getContentType() %></p>
<p> getLocalAddr: <%= request.getLocalAddr() %></p>
<p> getPathInfo: <%= request.getPathInfo() %></p>
<p> getRequestURI: <%= request.getRequestURI() %></p>
<p> getScheme: <%= request.getScheme() %></p>
<p> getProtocol: <%= request.getProtocol() %></p>
<p> getLocale: <%= request.getLocale() %></p>
<p> getRequestURL: <%= request.getRequestURL() %></p>
<p> getSession().getId: <%= request.getSession().getId() %></p>
<p> getSession().getCreationTime: <%= request.getSession().getCreationTime() %></p>
----------------------------------<br>
${contextPath}
----------------------------------<br>

<a href="CoffeForm.jsp">Open Coffe Form</a>