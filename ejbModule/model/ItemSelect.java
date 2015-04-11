package model;

import java.io.Serializable;

import javax.persistence.*;

import model.Item;

/**
 * Entity implementation class for Entity: ItemSelect
 *
 */
@Entity

public class ItemSelect implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private int quantity;
	private double totalPrice;
	@ManyToOne
	private Item item;
	@ManyToOne
	private Orders orders;
	private static final long serialVersionUID = 1L;

	public ItemSelect() {
		super();
	}   
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}   
	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}   
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	public Orders getOrder() {
		return orders;
	}
	public void setOrder(Orders orders) {
		this.orders = orders;
	}
   
}
