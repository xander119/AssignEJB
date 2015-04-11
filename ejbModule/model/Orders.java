package model;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import model.Account;
import model.Customer;
import model.Item;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Orders.findAll", query = "select o from Orders o "),
//	@NamedQuery(name = "Orders.findByItem", query = "select o from Review o where o.item.id = :id")
	@NamedQuery(name = "Orders.remove", query = "delete from Orders o where o.id = :id")

})
public class Orders implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private double totalPrice;
	private String orderDate;
	@ManyToOne
	private Account account;
	@ManyToOne
	private Customer customer;
	
	@OneToMany
	@JoinColumn(name="orders_id")
	private Set<ItemSelect> itemsSelect = new HashSet<ItemSelect>();

	
	private static final long serialVersionUID = 1L;

	public Orders() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Set<ItemSelect> getItemsSelect() {
		return itemsSelect;
	}

	public void setItemsSelect(Set<ItemSelect> itemsSelect) {
		this.itemsSelect = itemsSelect;
	}

	

}
