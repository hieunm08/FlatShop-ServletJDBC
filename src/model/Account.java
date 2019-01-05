package model;

public class Account {
	private int accountID;
	private String userName;
	private String userPassword;
	private int userRole;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int accountID, String userName, String userPassword, int userRole) {
		super();
		this.accountID = accountID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	
	

}
