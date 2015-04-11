package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Item
 *
 */

@Entity
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Item.findAllItems", query = "select o from Item o "),
		@NamedQuery(name = "Item.findById", query = "select o from Item o where o.id= :id"),
		@NamedQuery(name = "Item.findByManufacturer", query = "select o from Item o where o.manufacturer like :manufacturer"),
		@NamedQuery(name = "Item.findByCategory", query = "select o from Item o where o.category.categoryName like :category"),
		@NamedQuery(name = "Item.findByTitle", query = "select o from Item o where o.title like :title"),
		@NamedQuery(name = "Item.remove", query = "delete from Item o where o.id = :id")



})
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column
	private String title;

	@Column
	private Double price;

	@ManyToOne
	private Category category;
	@Column
	private String image;

	@Column
	private String manufacturer;
	@Column
	private int stockQuantity;
	
	@OneToMany
	@JoinColumn(name="item_id")
	private Set<ItemSelect> itemSelects = new HashSet<ItemSelect>();
	@OneToMany
	@JoinColumn(name="item_id")
	private Set<Review> reviews = new HashSet<Review>();
	

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Set<ItemSelect> getItemSelects() {
		return itemSelects;
	}

	public void setItemSelects(Set<ItemSelect> itemSelects) {
		this.itemSelects = itemSelects;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", price=" + price
				+ ", category=" + category.toString() + ", image=" + image
				+ ", manufacturer=" + manufacturer + ", stockQuantity="
				+ stockQuantity + "]";
	}

	

}
