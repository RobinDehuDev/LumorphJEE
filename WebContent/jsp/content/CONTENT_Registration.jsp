<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />

<div id="inscription_container">
	<html:form action="/registration">
		<br>
		<p>Inscription</p>
		<div>
			<label>Nom </label><br>
			<html:text property="name" value=""></html:text>
		</div>
		<div>
			<label>Mot de passe </label><br>
			<html:password property="password" value=""></html:password>
		</div>
		<div>
			<label>Adresse mail </label><br>
			<html:text property="email" value=""></html:text>
		</div>

		<div>
			<html:submit property="submit" value="S'inscrire"></html:submit>
			<html:reset property="reset" value="Effacer" />
		</div>

		<div>
			<a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Index.jsp">Accueil</a>
		</div>

		<br>
		<html:errors />

	</html:form>
</div>