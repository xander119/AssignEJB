package session;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import model.Account;
import model.Admin;
import model.Category;
import model.Customer;
import model.Item;
import model.ItemSelect;
import model.Orders;
import model.Review;

/**
 * Session Bean implementation class EntityBeanDAO
 */

@Stateless
public class EntityBeanDAO implements Serializable, EntityBeanDAOLocal {

	@PersistenceContext
	EntityManager em;

	public EntityBeanDAO() {
		// TODO Auto-generated constructor stub
	}

	public String createObject(Object o) {
		// TODO Auto-generated method stub
		String hashedPass;
		if (o instanceof Admin) {
			try {
				hashedPass = PasswordHash.createHash(((Admin) o).getPassword());
				((Admin) o).setPassword(hashedPass);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (o instanceof Customer) {
			try {
				hashedPass = PasswordHash.createHash(((Customer) o).getPassword());
				((Customer) o).setPassword(hashedPass);

			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Creating Object:" + o.toString() );
		em.persist(o);
		return "success";
	}

	// Account
	public Account deleteAccount(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account updateAccount(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		Account acc = em.find(Account.class, id);
		return acc;
	}

	public List<Account> getAllAccount() {
		List<Account> result = em.createNamedQuery("Account.getAll")
				.getResultList();
		return result;

	}

	// Customer

	public boolean login(String name, String psw)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		String correctHash;
		List<Customer> customers = em.createNamedQuery("Customer.findByName")
				.setParameter("username", name).getResultList();
		List<Admin> admin = em.createNamedQuery("Admin.findByName")
				.setParameter("name", name).getResultList();
		if (!customers.isEmpty()) {
			correctHash = customers.get(0).getPassword();
			if (PasswordHash.validatePassword(psw, correctHash)) {
				return true;
			}
		}
		if(!admin.isEmpty()) {
			correctHash = admin.get(0).getPassword();
			if (PasswordHash.validatePassword(psw, correctHash)) {
				return true;
			}
		} 
		return false;

	}

	public Customer deleteCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer updateCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return null;
	}

	// Category

	public Category deleteCategory(Category c) {
		// TODO Auto-generated method stub
		return null;
	}

	public Category updateCategory(Category c) {
		// TODO Auto-generated method stub
		return null;
	}
	public Category findCateByName(String categoryName2){
		List<Category> result = em.createNamedQuery("Category.findByName").setParameter("name", categoryName2).getResultList();
		return result.get(0);
	}

	// Admin
	public Admin adminLogin(String name, String psw)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		String correctHash;
		List<Admin> Admin = em.createNamedQuery("Admin.findByName").setParameter("name", name).getResultList();
		if (!Admin.isEmpty()) {
			correctHash = Admin.get(0).getPassword();
			String password = PasswordHash.createHash(psw);
			if (PasswordHash.validatePassword(password, correctHash)) {
				return Admin.get(0);
			}
			return null;
		} else {
			return null;
		}
	}

	public Admin deleteAdmin(Admin c) {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin updateAdmin(Admin c) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		List<Item> items = em.createNamedQuery("Item.findAllItems").getResultList();
		
		return items;
	}
	public Item deleteItem(Item i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Item updateItem(Item i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Item getItemById(int id){
		List<Item> items = em.createNamedQuery("Item.findById").setParameter("id", id).getResultList();
		return items.get(0);
	}
	public List<Category> getAllCategories(){
		List<Category> c = em.createNamedQuery("Category.findAll").getResultList();
		return c;
	}
	public ItemSelect deleteItemSelect(ItemSelect i) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemSelect updateItemSelect(ItemSelect i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Orders deleteOrder(Orders o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Orders updateOrder(Orders o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Review deleteReview(Review o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Review updateReview(Review o) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Review> getAllReviews(){
		List<Review> r = em.createNamedQuery("Review.findAll").getResultList();
		return r;
		
	}

	

}
