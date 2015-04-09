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
	//@NamedQuery(name = "Book.findAll", query = "select o from Book o")
})
public class Account implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	private String address;
	private String paymentMethod;
	private Double balance;
	@ManyToOne
	private Customer customer;
	@OneToMany(mappedBy="account")
	private Set<Orders> orders = new HashSet<Orders>();
	@OneToMany(mappedBy="customer")
	private Set<Review> reviews = new HashSet<Review>();
	
	private static final long serialVersionUID = 1L;
	
	public Account() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
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
				+ ", customer=" + customer + ", orders=" + orders
				+ ", reviews=" + reviews + "]";
	}
   
}
