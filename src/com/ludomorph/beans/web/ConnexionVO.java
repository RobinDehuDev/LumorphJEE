package com.ludomorph.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * Classe représentant une entité correspondant à un utilisateur lors de sa
 * connexion selon la couche de présentation
 * 
 * @author Delplanque Kévin
 * 
 */
public class ConnexionVO extends ActionForm {

	private String userName;
	private String password;

	public ConnexionVO() {
		super();
	}

	public ConnexionVO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Méthode testant les différents attributs de l'entité
	 */
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errors = new ActionErrors();
		if (StringUtils.isEmpty(this.getUserName())) {
			errors.add("", new ActionMessage("errors.mandatory", "Nom d'utilisateur"));
		}
		if (StringUtils.isEmpty(this.getPassword())) {
			errors.add("", new ActionMessage("errors.mandatory", "Mot de passe"));
		}
		return errors;
	}
}