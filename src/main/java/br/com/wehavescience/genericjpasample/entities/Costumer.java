package br.com.wehavescience.genericjpasample.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gabriel
 * 
 * Oct 17, 2013
 */

@Entity
@Table(name = "COSTUMER")
public class Costumer {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String email;
	
	public Costumer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Costumer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void validate(){
		if(name == null){
			throw new IllegalArgumentException("Name cannot be null");
		}
	}
}
