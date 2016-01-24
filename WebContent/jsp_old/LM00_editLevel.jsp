<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ludomorph.action.Constants"%>
<%@ page import="com.ludomorph.beans.web.LevelVO"%>
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
	var item = 'A';
	var object;
	
	var Level = function(){
		var table= "";
		var begin = -1;
		var end = -1;
		var width;
		
		this.init = function(map){
			var length = 0;
			var widthString = "";
			
			for(var i = 0 ; i < map.length ; i++){
				if(map[i]<'A'){
					length+=1;
					widthString+=map[i];
				}
				if(map[i] == 'B'){
					begin = i;
				}						
				if(map[i] == 'C'){
					end = i;
				}
			}
			width = parseInt(widthString);
			table = map.substring(length).toString();			
		};
		
		var replaceAt = function(index, letter){
			table = table.substring(0,index)+letter+table.substring(index+1);
		};
		
		var reset = function(index){
			var i = Math.floor(index/width);
			var j = index % width;
			document.getElementById(i+","+j).innerHTML = 'A';
		};
		
		this.update = function(i,j){
			var pos = i*width+j;
			if(item == 'B'){
				if(begin >= 0){ 
					replaceAt(begin,'A');
					reset(begin);
				}
				begin=pos;
			}
			if(end >= 0 && item == 'C'){
				if(end >= 0){ 
					replaceAt(end,'A');
					reset(end);
				}
				end=pos;
			}
			replaceAt(pos,item);
		};
		
		this.toString = function(){
			s="Debut : "+begin;
			s+="Fin : "+end;
			s+="largeur : "+width;
			s+="table : "+table;
			alert(s);
			return table;
		};
		
		this.getTable = function(){
			return table;
		}
	};
	
	var level = new Level();
	
	window.onload = function() {
		object = document.getElementById("elementID");
		var s = '<%=request.getSession().getAttribute("dataLevel").toString()%>';
		level.init(s);
	};
	
	function changeCell(i, j, element){
		element.innerHTML = item;
		level.update(i,j);
	}

	function selectObject(value){
		item = String.fromCharCode(value);
		object.innerHTML = item;
	}
	
	function testFunction() {
		alert("test");
	}
	
	function save(){
		document.getElementById("saveData").value = level.getTable();	
	}
</script>

<title><bean:message key="message.editLevel.title" /></title>
</head>
<body>
	<html:form action="editMap">
	<html:errors />
		<h1>
			<bean:message key="message.editLevel.title" />
			:
			<html:text property="name" value="${dataLevel.name}" />
		</h1>

		<div>
			<bean:message key="message.editLevel.width" />
			:
			<html:text property="width" value="${dataLevel.width}" />
			<bean:message key="message.editLevel.selection" />
			:
			<var id="elementID">A</var>
			<br>
		</div>

		<div>
			<logic:notEmpty name="dataLevel">

				<table class="pure-table" id="mapTableID">

					<logic:iterate name="dataLevel" property="level" id="myLine"
						indexId="lineID">
						<tr>
							<logic:iterate id="cell" name="myLine" indexId="cellID">
								<td onclick="changeCell(${lineID},${cellID},this)" id="${lineID},${cellID}"><bean:write
										name="cell" /></td>
							</logic:iterate>
						</tr>
					</logic:iterate>
				</table>

			</logic:notEmpty>
		</div>

		<div>
			<logic:notEmpty name="objectsData">

				<table class="pure-table" id="objectTableID">
					<logic:iterate name="objectsData" id="object" indexId="objectID">
						<tr onclick="selectObject(${object.value})"
							id="<bean:write name="object" property="value"/>">
							<td><bean:write name="object" property="name" /></td>
						</tr>
					</logic:iterate>
				</table>

			</logic:notEmpty>
		</div>

		<div>
			<a class="pure-button" href="/Ludomorph/loadLevel.do"> <bean:message
					key="message.editLevel.load" />
			</a>

			<html:submit property="submit" styleClass="pure-button" onclick="save()">
				<bean:message key="message.editLevel.save" />
			</html:submit>

		</div>
		
	<html:hidden property="id" value="${dataLevel.id}"/>
	<html:hidden property="data" value="" styleId="saveData"/>
	<html:hidden property="toSave" value="true"/>

	</html:form>
	<button onclick="testFunction()">test</button>
</body>
</html>