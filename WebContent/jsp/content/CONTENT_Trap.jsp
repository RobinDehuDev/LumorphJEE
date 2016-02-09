<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>


<div id="trap_container">
	<h2>Current trap:</h2><br>
	<html:image src="/Ludomorph/ressources/sprite/${user_id}/trap/trap.png" alt="Fail Loading"/>
	<br>
	
	<h2>Load new Image:</h2>
	
	<html:form action="/uploadTrap" enctype="multipart/form-data">
         <html:file property="file"/><br>
         <html:submit value="Uploader"/>

   </html:form>
   
   <br>
   <br>
   <html:errors/>
</div>