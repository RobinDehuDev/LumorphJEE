<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ludomorph.action.SessionConstantNames"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">


<title><bean:message key="message.editLevel.title" /></title>
</head>
<body>
	Bonjour
	<html:form action="editTestMap">
	<logic:iterate name="testList" property="level" id="testline" indexId="i" type="com.ludomorph.beans.web.LevelLineVO">
		
	       <logic:iterate id="line" name="testline" property="line" indexId = "j">
	       	<html:text style="levelData" property="line" indexed="true" value="0"/>
	
	   	</logic:iterate><br>
   </logic:iterate>
   <html:submit>ok</html:submit>
   </html:form>
</body>
</html>