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

	//account methods
	public Account deleteAccount (Account acc);
	public Account updateAccount (Account acc);
	public Account getAccountById(int id);
	public List<Account> getAllAccount();

	//customer methods
	public Customer deleteCustomer (Customer cus);
	public Customer updateCustomer (Customer cus);
	//Category methods
	public Category deleteCategory (Category c);
	public Category updateCategory (Category c);
	public Category findCateByName(String categoryName2);

	//Admin methods
	public Admin deleteAdmin (Admin c);
	public Admin updateAdmin (Admin c);
	
	//Item methods
	public List<Item> getAllItems();
	public Item deleteItem (Item i);
	public Item updateItem (Item i);
	public Item getItemById(int id);
	public List<Category> getAllCategories();

	
	//ItemSelect methods
	public ItemSelect deleteItemSelect (ItemSelect i);
	public ItemSelect updateItemSelect (ItemSelect i);
	
	//Order methods
	public Orders deleteOrder (Orders o);
	public Orders updateOrder (Orders o);
	
	//Review methods
	public Review deleteReview (Review o);
	public Review updateReview (Review o);
	public List<Review> getAllReviews();
	
	
	
}
