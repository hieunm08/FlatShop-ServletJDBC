package model;

public class Users {
	private int userID;
	private String Name;
	private String Email;
	private String Phone;
	private int accountID;
 
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(int userID, String name, String email, String phone, int accountID) {
		super();
		this.userID = userID;
		Name = name;
		Email = email;
		Phone = phone;
		this.accountID = accountID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	
}
