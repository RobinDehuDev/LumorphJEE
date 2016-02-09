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
				}else{
					if(map[i] == 'B'){
						begin = i;
					}						
					if(map[i] == 'C'){
						end = i;
					}
					
					width = parseInt(widthString);
					column = Math.floor((i-length)/width);
					line = (i-length)%width;
					
					document.getElementById(column+","+line).className = "editCell"+map[i];;
						
				}
			}
			
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
		};
	};
	
	var level = new Level();
	
	window.onload = function() {
		object = document.getElementById("elementID");
		var s = '<%=request.getSession().getAttribute("dataLevel").toString()%>';
		level.init(s);
	};
	
	function changeCell(i, j, element){
		element.innerHTML = item;
		element.className = "editCell"+item;
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
	<div class="content">
	<h1>
			<bean:message key="message.editLevel.title" />
	</h1>
	
	
	<html:form action="editSize">
		<h2>
				<bean:message key="message.editLevel.dimensions" /> : 
		</h2>
			<bean:message key="message.editLevel.height" />
			:
			<html:text property="height" value="${dataLevel.height}" />
			<bean:message key="message.editLevel.width" />
			:
			<html:text property="width" value="${dataLevel.width}" />
			
			<html:submit property="submit" styleClass="myBtton">
				<bean:message key="message.editLevel.update" />
			</html:submit>
	</html:form>
	
	
	<html:form action="editMap">
	<html:errors />
		<h2>
			<bean:message key="message.editLevel.levelName" />
			:
			<html:text property="name" value="${dataLevel.name}" />
		</h2>

		<div>
			<bean:message key="message.editLevel.selection" />
			:
			<var id="elementID">A</var>
			<br>
		</div>

		<div id="levelContent">
			<div id="level">
			
				<logic:notEmpty name="dataLevel">
	
					<table id="mapTableID">
	
						<logic:iterate name="dataLevel" property="level" id="myLine"
							indexId="lineID">
							<tr>
								<logic:iterate id="cell" name="myLine" indexId="cellID">
									<td onclick="changeCell(${lineID},${cellID},this)" id="${lineID},${cellID}" class="editCellA">
									<bean:write	name="cell" /></td>
								</logic:iterate>
							</tr>
						</logic:iterate>
					</table>
	
				</logic:notEmpty>
			
			</div>

			<div id="toolBar">
				<logic:notEmpty name="objectsData">
	
					<table id="objectTableID">
						<logic:iterate name="objectsData" id="object" indexId="objectID">
							<tr onclick="selectObject(${object.value})"
								id="<bean:write name="object" property="value"/>">
								<td class="${object.cssClass}">ok</td>
								<td><bean:write name="object" property="name" /></td>
							</tr>
						</logic:iterate>
					</table>
	
				</logic:notEmpty>
			</div>
		<div id="confirm">
			<div>
				
	
				<html:submit property="submit" styleClass="myButton" onclick="save()">
					<bean:message key="message.editLevel.save" />
				</html:submit>
	
			</div>
			
			
			<html:hidden property="id" value="${dataLevel.id}"/>
			<html:hidden property="height" value="${dataLevel.height}"/>
			<html:hidden property="width" value="${dataLevel.width}"/>
			<html:hidden property="data" value="" styleId="saveData"/>
		</div>
	</div>
		</html:form>
	<div>
		<html:form action="loadMap">
		
		<html:select property="id">
		<html:optionsCollection name="listLevel"
			label="name" value="id" /></html:select>
		
		
		<html:submit property="submit" styleClass="myButton">
					<bean:message key="message.editLevel.load" />
		</html:submit>	
		</html:form>
		</div>
	</div>
	
</body>
</html>