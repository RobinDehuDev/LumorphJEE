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

<script type="text/javascript">
	var item = 0;
	var map =<%= request.getSession().getAttribute(SessionConstantNames.EDITLEVELMAPDATA)%>;
	
	window.onload = function() {
		
		var tableMap = document.getElementById("mapTableID");
		var tableObject = document.getElementById("objectTableID");
		var object = document.getElementById("elementID");


		if (tableMap != null) {
			for (var i = 0; i < tableMap.rows.length; i++) {
				for (var j = 0; j < tableMap.rows[i].cells.length; j++)
					tableMap.rows[i].cells[j].onclick = function() {
						this.innerHTML = item;
						update(this.id);
					};
			}
		}

		

		if (tableObject != null) {
			for (var i = 0; i < tableObject.rows.length; i++) {

				tableObject.rows[i].onclick = function() {
					object.innerHTML = this.id;
					item = this.id;

				};
			}
		}
	};
	
	function update(coord){
		var i = parseInt(coord.split(" ")[0]);
		var j = parseInt(coord.split(" ")[1]);
		
		map[i][j] = item;
	}
	
	
	function testFunction() {
		alert(map);
	}
</script>

<title><bean:message key="message.editLevel.title" /></title>
</head>
<body>
	<h1>
		<bean:message key="message.editLevel.title" />
		:
		<%=request.getSession().getAttribute(SessionConstantNames.EDITLEVELMAPNAME)%></h1>

	<div>
		<bean:message key="message.editLevel.width" />
		:
		<%=request.getSession().getAttribute(SessionConstantNames.EDITLEVELMAPWIDTH)%>
		<bean:message key="message.editLevel.selection" />
		:
		<var id="elementID">0</var>
		<br>
	</div>
	
	<div>
		<logic:notEmpty name="mapData">

			<table class="pure-table" id="mapTableID">
				<logic:iterate name="mapData" id="mapLine" indexId="lineID">
					<tr>
						<logic:iterate name="mapLine" id="cell" indexId="cellID">
							<td id="${lineID} ${cellID}"><bean:write name="cell" /></td>
						</logic:iterate>
					</tr>
				</logic:iterate>
			</table>

		</logic:notEmpty>
	</div>
	<div>
		<div>
			<logic:notEmpty name="objectsData">

				<table class="pure-table" id="objectTableID">
					<logic:iterate name="objectsData" id="object" indexId="objectID">
						<tr id="<bean:write name="object" property="id"/>">
							<td><bean:write name="object" property="name" /></td>
						</tr>
					</logic:iterate>
				</table>

			</logic:notEmpty>
		</div>
		<div>
			<a class="pure-button" class="pure-button"
				href="/Ludomorph/loadLevel.do"> <bean:message
					key="message.editLevel.load" />
			</a> <a class="pure-button" class="pure-button"
				href="/Ludomorph/ajout.do"> <bean:message
					key="message.editLevel.save" />
			</a>

			<button onclick="testFunction()">test</button>
		</div>
	</div>

</body>
</html>