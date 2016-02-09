<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>

<div id="music_container" class="content">
	<TABLE BORDER="1" class="pure-table">
		<thead>
			<TR>
				<TH>Titre</TH>
				<TH>Ecouter</TH>
				<TH>Option</TH>
			</TR>
		</thead>

		<logic:notEmpty name="musics">
			<logic:iterate name="musics" id="currentMusic" indexId="index">
				<tbody>
					<TR>
						<TD><bean:write name="currentMusic"></bean:write></TD>
						<TD><audio controls>
								<source
									src="/Ludomorph/ressources/musics/${user_id}/<bean:write name="currentMusic"></bean:write>"
									type="audio/mpeg">
							</audio></TD>
						<TD>
						<logic:notEqual name="currentMusic" value="Default_music.mp3">
						<a class="pure-button pure-button-primary"
							style="background: rgb(202, 60, 60)"
							href="/Ludomorph/RemoveMusic.do?index=${index}">X</a>
						</logic:notEqual>
						</TD>
					</TR>
				</tbody>
			</logic:iterate>
		</logic:notEmpty>
	</TABLE>
	<br><br>
	<html:form action="/uploadMusicFile" enctype="multipart/form-data">
          Sélectionner la musique : <html:file property="myFileMusic"/><br>
         <html:submit value="Envoyer Musique"/>

   </html:form>
   <br>
   <br>
   <html:errors/>

</div>