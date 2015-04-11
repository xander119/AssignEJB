package session;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import model.Account;
import model.Admin;
import model.Category;
import model.Customer;
import model.Item;
import model.ItemSelect;
import model.Orders;
import model.Review;

@Local
public interface EntityBeanDAOLocal {
	public String createObject(Object o);
	public boolean login(String name, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
	public String update(Object o);
	public void delete(Object o);
	//account methods
	public Account getAccountById(int id);
	public List<Account> getAllAccount();

	//customer methods
	//Category methods
	public Category findCateByName(String categoryName2);

	//Admin methods
	
	//Item methods
	public List<Item> getAllItems();
	public Item getItemById(int id);
	public List<Category> getAllCategories();
	public List<Item> findItemByManu(String content);
	public List<Item> findItemByTitle(String content);
	public List<Item> findItemByCategory(String content);

	
	//ItemSelect methods
	
	//Order methods
	
	//Review methods
	public List<Review> getAllReviews();
	public Customer findCustomerByName(String name);
	public List<Account> getAccountByCus(Customer c);
	public List<Review> getReviewByItem(int id);
	
	
	
	
}
