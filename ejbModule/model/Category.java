package model;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import model.Item;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Category.findAll", query = "select o from Category o "),
	@NamedQuery(name = "Category.findById", query = "select o from Category o where o.id=:id"),
	@NamedQuery(name = "Category.findByName", query = "select o  from Category o where o.categoryName=:name")

	
	 })

public class Category implements Serializable {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	private String categoryName;

	@OneToMany(mappedBy = "category",fetch=FetchType.EAGER)
	private Set<Item> items = new HashSet<Item>();
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName
				+ "]";
	}
}
