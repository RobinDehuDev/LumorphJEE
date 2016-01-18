package com.ludomorph.beans.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "music")
public class MusicDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "path")
	private String path;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserDO user;
	
	

	public MusicDO() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param name
	 * @param value
	 * @param user
	 */
	public MusicDO(String name, String path, UserDO user) {
		super();
		this.name = name;
		this.path = path;
		this.user = user;
	}
	
	



	/**
	 * @param id
	 * @param name
	 * @param value
	 * @param user
	 */
	public MusicDO(int id, String name, String path, UserDO user) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.user = user;
	}
	
	public boolean equals(MusicDO music){
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
