/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
public class Hero {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public Hero() {
	}

	public Hero(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
