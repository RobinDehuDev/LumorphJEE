<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	a que coucou
	<html:form action="test">
	<html:text property="name" value="${mapLevel.name}"/>
	<html:text property="width" value="${mapLevel.width}"/>
		<logic:notEmpty name="mapLevel">

			<table class="pure-table" id="mapTableID">
				<tr>
				<logic:iterate name="mapLevel" property="level" id="level" indexId="lineID" >
					
					
						<td id="${lineID} ${cellID}">
							<html:text style="levelData" property="line" indexed="true" value="${level}" name="level"/>
						</td>
					
						
					
				</logic:iterate>
				</tr>
			</table>
		
		</logic:notEmpty>
		<html:submit property="submit"><bean:message
					key="message.editLevel.save" /></html:submit>
	</html:form>
</body>
</html>