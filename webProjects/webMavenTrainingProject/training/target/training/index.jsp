<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page autoFlush="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<div class="menu">
<%@ include file="/menu-top.jsp" %>
</div>
<div class="content">
<%@ include file="/content.jsp" %>
</div>
апвп
<jsp:useBean id="test" class="com.trainig.commons.SimpleBean" />
<jsp:setProperty name="test" 
                 property="message" 
                 value="Hello WWW" />
<H1>Message: <I>
<jsp:getProperty name="test" property="message" />
</I></H1>

</body>
</html>