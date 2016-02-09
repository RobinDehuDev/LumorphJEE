<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>


<div id="character_container" class="content">
	<h2>Current character:</h2>
	<br>

	<TABLE BORDER="1" class="pure-table">
		<thead>
			<TR>
				<TH>base</TH>
				<TH>mouvement 1</TH>
				<TH>mouvement 2</TH>
				<TH>saut</TH>
			</TR>
		</thead>
		<TR>
			<TD><html:image
					src="/Ludomorph/ressources/sprite/${user_id}/character/Idle.png"
					alt="Fail Loading" /></TD>

			<TD><html:image
					src="/Ludomorph/ressources/sprite/${user_id}/character/Move1.png"
					alt="Fail Loading" /></TD>

			<TD><html:image
					src="/Ludomorph/ressources/sprite/${user_id}/character/Move2.png"
					alt="Fail Loading" /></TD>

			<TD><html:image
					src="/Ludomorph/ressources/sprite/${user_id}/character/Jump.png"
					alt="Fail Loading" /></TD>


		</TR>
		<TR>

		<html:form action="/uploadCharacter" enctype="multipart/form-data">

			<TD><html:file property="idle" /></TD>
			<TD><html:file property="move1" /></TD>
			<TD><html:file property="move2" /></TD>
			<TD><html:file property="jump" /></TD>
			
			<html:submit value="Uploader" /><br><br>

		</html:form>
		</TR>
	</TABLE>
	<br> <br>
	<html:errors />
</div>