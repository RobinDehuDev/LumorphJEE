package com.ludomorph.beans.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sprite")
public class SpriteDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "type")
	private TypeDO type;
	
	@Column(name = "path")
	private String path;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserDO user;
	
	

	public SpriteDO() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param name
	 * @param value
	 * @param user
	 */
	public SpriteDO(TypeDO type, String path, UserDO user) {
		super();
		this.type = type;
		this.path = path;
		this.user = user;
	}
	
	



	/**
	 * @param id
	 * @param name
	 * @param value
	 * @param user
	 */
	public SpriteDO(int id, TypeDO type, String path, UserDO user) {
		super();
		this.id = id;
		this.type = type;
		this.path = path;
		this.user = user;
	}
	
	public boolean equals(SpriteDO music){
		return path.equals(music.path);
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
	 * @return the type
	 */
	public TypeDO getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(TypeDO type) {
		this.type = type;
	}



	/**
	 * @return the value
	 */
	public String getPath() {
		return path;
	}



	/**
	 * @param value the value to set
	 */
	public void setPath(String path) {
		this.path = path;
	}



	/**
	 * @return the user
	 */
	public UserDO getUser() {
		return user;
	}



	/**
	 * @param user the user to set
	 */
	public void setUser(UserDO user) {
		this.user = user;
	}
}
