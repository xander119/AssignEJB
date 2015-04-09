package model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import model.Account;
import model.Customer;

/**
 * Entity implementation class for Entity: Reivew
 *
 */
@Entity

@NamedQueries({
	@NamedQuery(name = "Review.findAll", query = "select o from Review o ")
//	@NamedQuery(name = "Item.findById", query = "select o.image,o.manufacturer,o.price,o.stockQuantity,o.title from Item o where o.id=:id")

})
public class Review implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	private String content;
	@ManyToOne
	private Account account;
	@ManyToOne
	private Customer customer;
	private int rate;
	private static final long serialVersionUID = 1L;

	public Review() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}   
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}   
	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
   
}
