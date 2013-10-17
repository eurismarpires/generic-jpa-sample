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
@Table(name="PRODUCT")
public class Product {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String description;

	public Product() {
		super();
	}

	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void validate() {
		if(name == null || description == null){
			throw new IllegalArgumentException("Name and description cannot be null");
		}
	}

}
