package model;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import model.Customer;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity
@XmlRootElement
@NamedQueries({		
	@NamedQuery(name = "Account.getAll", query = "select o from Account o "),
	@NamedQuery(name = "Account.getAccountByCus", query = "select o from Account o where o.customer.id = :id"),
	@NamedQuery(name = "Account.findById", query = "select o from Account o where o.id = :id"),
	@NamedQuery(name = "Account.remove", query = "delete from Account o where o.id = :id")

})
//.id,o.address,o.paymentMethod,o.balance
public class Account implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String address;
	private String paymentMethod;
	private double balance;
	@ManyToOne
	private Customer customer;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="account_id")
	private Set<Orders> orders = new HashSet<Orders>();
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="account_id")
	private Set<Review> reviews = new HashSet<Review>();
	
	private static final long serialVersionUID = 1L;
	
	public Account() {
		super();
	}   
	 
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}   
	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", address=" + address
				+ ", paymentMethod=" + paymentMethod + ", balance=" + balance
				+ ", customer=" + customer + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
