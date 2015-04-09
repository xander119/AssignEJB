package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Customer.findByName", query = "select o from Customer o where o.userName = :username"),
		@NamedQuery(name = "Customer.find", query = "select o from Customer o where o.userName = :username") })
public class Customer implements Serializable {

	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String userName;
	private String password;
	private String passwordReset;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Account> accounts = new HashSet<Account>();
	
	@OneToMany(mappedBy = "customer")
	private Set<Orders> orders = new HashSet<Orders>();
	
	@OneToMany(mappedBy = "customer")
	private Set<Review> reviews = new HashSet<Review>();

	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordReset() {
		return passwordReset;
	}

	public void setPasswordReset(String passwordReset) {
		this.passwordReset = passwordReset;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", id=" + id + ", password="
				+ password + ", passwordReset=" + passwordReset + ", accounts="
				+ accounts + ", orders=" + orders + ", reviews=" + reviews
				+ "]";
	}

}
