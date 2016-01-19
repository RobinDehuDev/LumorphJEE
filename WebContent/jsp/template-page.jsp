<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div id="top_page">
		<div id="connexion_container">
			<jsp:include page="/jsp/LM03_connexion.jsp" />
		</div>
		<div id="header_container">
		<h1>LUDOMORPH</h1>
		</div>
	</div>
	<div id="bottom_page">
		<div id="menu">
			<jsp:include page="LM01_menu.jsp" />
		</div>
		<div id="content_container">
		<logic:equal name="page" value="1">
			<jsp:include page="/jsp/LM02_character.jsp" />
		</logic:equal>
		
		<logic:equal name="page" value="6">
			<jsp:include page="/jsp/LM00_editLevel.jsp" />
		</logic:equal>
			

		</div>
	</div>
</body>
</html>