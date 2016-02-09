<%@page import="com.ludomorph.action.ConnectionAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<logic:empty name="user_name">
	<html:form action="/connection">
		<br>
		<p>Connexion</p>
		<div>
			<label>Nom </label><br>
			<html:text property="name" value=""></html:text>
		</div>
		<div>
			<label>Mot de passe </label><br>
			<html:password property="password" value=""></</html:password>
		</div>

		<div>
			<html:submit property="submit" value="Se connecter"></html:submit>
			<html:reset property="reset" value="Effacer" />
		</div>

		<div>
			<a
				href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Registration.jsp">Inscription</a>
		</div>

	</html:form>
</logic:empty>
<logic:notEmpty name="user_name">
	<br>
	<br>
	<br>
	<div>
		<jsp:useBean id="user_name" scope="session"
			class="java.lang.String" />
		<p>Bienvenue</p>
		<p><%= user_name.toString() %></p>
	</div>
	<div>
		<a href="/Ludomorph/deconnection.do">Deconnection</a>
	</div>
</logic:notEmpty>

