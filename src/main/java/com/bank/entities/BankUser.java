package com.bank.entities;

public class BankUser {

	long userId;
	String userName;
	String userAddress;
	double balance;
	String userpassword;
	long phone;
	String userEmail;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankUser(long userId, String userName, String userAddress, double balance, String userpassword, long phone,
			String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.balance = balance;
		this.userpassword = userpassword;
		this.phone = phone;
		this.userEmail = userEmail;
	}
	
}
