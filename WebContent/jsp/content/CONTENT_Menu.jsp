<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<p class="menu-heading">MENU</p>
<logic:notEmpty name="user_id">
	<ul class="menu-list">

		<logic:equal name="page" value="1">
			<li class="menu-item-selected"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Character.jsp" class="menu-link">Mon
					héro</a></li>
		</logic:equal>
		<logic:notEqual name="page" value="1">
			<li class="menu-item"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Character.jsp" class="menu-link">Mon héro</a></li>
		</logic:notEqual>

		<logic:equal name="page" value="2">
			<li class="menu-item-selected"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Music.jsp" class="menu-link">Mes
					musiques</a></li>
		</logic:equal>
		<logic:notEqual name="page" value="2">
			<li class="menu-item"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Music.jsp" class="menu-link">Mes
					musiques</a></li>
		</logic:notEqual>

		<logic:equal name="page" value="3">
			<li class="menu-item-selected"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Background.jsp" class="menu-link">Background</a></li>
		</logic:equal>
		<logic:notEqual name="page" value="3">
			<li class="menu-item"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Background.jsp" class="menu-link">Background</a></li>
		</logic:notEqual>

		<logic:equal name="page" value="4">
			<li class="menu-item-selected"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Enemy.jsp" class="menu-link">Méchants</a></li>
		</logic:equal>
		<logic:notEqual name="page" value="4">
			<li class="menu-item"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Enemy.jsp" class="menu-link">Méchants</a></li>
		</logic:notEqual>

		<logic:equal name="page" value="5">
			<li class="menu-item-selected"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Trap.jsp" class="menu-link">Pièges</a></li>
		</logic:equal>
		<logic:notEqual name="page" value="5">
			<li class="menu-item"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Trap.jsp" class="menu-link">Pièges</a></li>
		</logic:notEqual>

		<logic:equal name="page" value="6">
			<li class="menu-item-selected"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Level.jsp"
				class="menu-link">Niveaux</a></li>
		</logic:equal>
		<logic:notEqual name="page" value="6">
			<li class="menu-item"><a href="<%=request.getContextPath()%>/jsp/shape/SHAPE_Level.jsp"
				class="menu-link">Niveaux</a></li>
		</logic:notEqual>

	</ul>
</logic:notEmpty>
