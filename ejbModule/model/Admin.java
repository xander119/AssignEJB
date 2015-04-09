package model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */

@NamedQueries({
		@NamedQuery(name = "Admin.findByName", query = "select o from Admin o where o.name = :name"),
		@NamedQuery(name = "Admin.find", query = "select o from Admin o where o.name = :name") })
@Entity

public class Admin implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String name;
	private String password;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
