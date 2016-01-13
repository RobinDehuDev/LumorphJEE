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
	<h1><bean:message key="message.editLevel.title" /> :<%=request.getSession().getAttribute(SessionConstantNames.EDITLEVELMAPNAME)%></h1>
	<div>
		<div>
			<bean:message key="message.editLevel.width" /> :  <%=request.getSession().getAttribute(SessionConstantNames.EDITLEVELMAPNAME)%>
			<bean:message key="message.editLevel.selection" /> : <br>
		</div>
		<div>
			<table class="pure-table">
			<logic:iterate name="mapData" id="mapLine">
				<tr>
				<logic:iterate name="mapLine" id="cell">
					<td><bean:write name="cell"/></td>
				</logic:iterate>
				</tr>
			</logic:iterate>
			</table>
			
		</div>
		<div>
			*liste des objets*
		</div>
		<div>
			<a class="pure-button" class="pure-button" href="/Ludomorph/loadLevel.do">
				<bean:message key="message.editLevel.load" />
			</a>
			
			<a class="pure-button" class="pure-button" href="/Ludomorph/ajout.do">
				<bean:message key="message.editLevel.save" />
			</a>
		</div>
	</div>

</body>
</html>