package org.cap.model;

import java.time.LocalDate;

import org.cap.formatter.LocalDateDeserializer;
import org.cap.formatter.LocalDateSerializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Account {
	
	private int accountNo;
	private String accountType;
	@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate openingDate;
	private double amount;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account(int accountNo, String accountType, LocalDate openingDate, double amount) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.amount = amount;
	}
	
	
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", openingDate=" + openingDate
				+ ", amount=" + amount + "]";
	}
	
	

}
