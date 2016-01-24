package com.ludomorph.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * Classe représentant une entité correspondant à un utilisateur selon la couche de présentation
 * 
 * @author Delplanque Kévin
 * 
 */
public class UserVO extends ActionForm {
	
	private int id;

	private String name;

	private String password;
	
	private String email;
	
	
	public UserVO() {
		super();
	}
	
	


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errors = new ActionErrors();
		if (StringUtils.isEmpty(this.getName())) {
			errors.add("", new ActionMessage("errors.mandatory", "Nom"));
		}
		if (StringUtils.isEmpty(this.getPassword())) {
			errors.add("", new ActionMessage("errors.mandatory", "Mot De Passe"));
		} else {
			if (this.getPassword().length() < 4) {
				errors.add("", new ActionMessage("errors.field.minlength", "Mot De Passe","4"));
			}
		}
		if (StringUtils.isEmpty(this.getEmail())) {
			errors.add("", new ActionMessage("errors.mandatory", "Email"));
		} else {
			if (!this.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
				errors.add("", new ActionMessage("errors.email", "Email"));
			}
		}

		return errors;
	}
}
