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
	<% session.setAttribute("page","3"); %>
	<div id="top_page">
	
		<div id="connection_container">
			<jsp:include page="/jsp/content/CONTENT_Connection.jsp" />
		</div>
		<a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Index.jsp">
			<div id="header_container">
				<jsp:include page="/jsp/content/CONTENT_Banner.jsp" />
			</div>
		</a>
	</div>
	<div id="bottom_page">
		<div id="menu">
			<jsp:include page="/jsp/content/CONTENT_Menu.jsp" />
		</div>
		<div id="content_container">
			<jsp:include page="/jsp/content/CONTENT_Background.jsp" />
		</div>
	</div>
</body>
</html>