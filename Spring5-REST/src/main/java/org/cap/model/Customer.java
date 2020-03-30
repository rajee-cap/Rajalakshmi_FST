package org.cap.model;

public class Customer {
	private int customerId;
	private String customerName;
	private String contactNo;
	private Account account;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer(int customerId, String customerName, String contactNo, Account account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.account = account;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNo=" + contactNo
				+ ", account=" + account + "]";
	}
	
	

}
