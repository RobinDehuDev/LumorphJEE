<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1><bean:message key="message.editLevel.title" /> : </h1>
	<div>
		<div>
			<bean:message key="message.editLevel.width" /> : 
			<bean:message key="message.editLevel.selection" /> : <br>
		</div>
		<div>
			* Placer le niveau ici*
		</div>
		<div>
			*liste des objets*
		</div>
		<div>
			<a class="pure-button" class="pure-button" href="/Javaquarium/loadLevel.do">
				<bean:message key="message.editLevel.load" />
			</a>
			
			<a class="pure-button" class="pure-button" href="/Javaquarium/ajout.do">
				<bean:message key="message.editLevel.save" />
			</a>
		</div>
	</div>

</body>
</html>