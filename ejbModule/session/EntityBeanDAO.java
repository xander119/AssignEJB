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

	public String update(Object o) {
		// TODO Auto-generated method stub
		em.merge(o);
		return "success";
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
				hashedPass = PasswordHash.createHash(((Customer) o)
						.getPassword());
				((Customer) o).setPassword(hashedPass);

			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		if(o instanceof Account){
//			System.out.println("Creating Object:" + o.toString());
//			return "success";
//		}
		System.out.println("Creating Object:" + o.toString());
		em.persist(o);
		return "success";
	}

	public void delete(Object o) {
		if (o instanceof Account) {
			em.createNamedQuery("Account.remove").setParameter("id", ((Account) o).getId()).executeUpdate();
		}
		if (o instanceof Item) {
			em.createNamedQuery("Item.remove").setParameter("id", ((Item) o).getId()).executeUpdate();
		}
		if (o instanceof Review) {
			em.createNamedQuery("Review.remove").setParameter("id", ((Review) o).getId()).executeUpdate();
		}
		if(o instanceof Orders) {
			em.createNamedQuery("Orders.remove").setParameter("id", ((Orders) o).getId()).executeUpdate();
		}

	}

	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		List<Account> result = em.createNamedQuery("Account.findById")
				.setParameter("id", id).getResultList();
		return result.get(0);
	}

	public List<Account> getAllAccount() {
		List<Account> result = em.createNamedQuery("Account.getAll")
				.getResultList();
		return result;

	}

	public List<Account> getAccountByCus(Customer c) {
		System.out.println(c.getId());
		List<Account> result = em.createNamedQuery("Account.getAccountByCus")
				.setParameter("id", c.getId()).getResultList();
		// if(!result.isEmpty()){

		return result;
		// }
		// return null;
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
		if (!admin.isEmpty()) {
			correctHash = admin.get(0).getPassword();
			if (PasswordHash.validatePassword(psw, correctHash)) {
				return true;
			}
		}
		return false;

	}

	public Category findCateByName(String categoryName2) {
		List<Category> result = em.createNamedQuery("Category.findByName")
				.setParameter("name", categoryName2).getResultList();
		return result.get(0);
	}

	// Admin
	public Admin adminLogin(String name, String psw)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		String correctHash;
		List<Admin> Admin = em.createNamedQuery("Admin.findByName")
				.setParameter("name", name).getResultList();
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

	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		List<Item> items = em.createNamedQuery("Item.findAllItems")
				.getResultList();

		return items;
	}

	@SuppressWarnings("unchecked")
	public Item getItemById(int id) {
		List<Item> items = (List<Item>) em.createNamedQuery("Item.findById")
				.setParameter("id", id).getResultList();
		System.out.println(items.toString());
		return items.get(0);
	}

	public List<Category> getAllCategories() {
		List<Category> c = em.createNamedQuery("Category.findAll")
				.getResultList();
		return c;
	}

	public List<Review> getAllReviews() {
		List<Review> r = em.createNamedQuery("Review.findAll").getResultList();
		return r;

	}

	public List<Review> getReviewByItem(int id) {
		List<Review> r = em.createNamedQuery("Review.findByItem").setParameter("id", id)
				.getResultList();
			return r;
	}

	public Customer findCustomerByName(String name) {
		List<Customer> customers = em.createNamedQuery("Customer.findByName")
				.setParameter("username", name).getResultList();
		return customers.get(0);

	}

	public List<Item> findItemByManu(String content) {
		List<Item> items = em.createNamedQuery("Item.findByManufacturer")
				.setParameter("manufacturer", content).getResultList();
		if (!items.isEmpty())
			return items;
		return null;
	}

	public List<Item> findItemByCategory(String content) {
		List<Item> items = em.createNamedQuery("Item.findByCategory")
				.setParameter("category", content).getResultList();
		if (!items.isEmpty())
			return items;
		return null;
	}

	public List<Item> findItemByTitle(String content) {
		List<Item> items = em.createNamedQuery("Item.findByTitle")
				.setParameter("title", content).getResultList();
		if (!items.isEmpty())
			return items;
		return null;
	}

}
