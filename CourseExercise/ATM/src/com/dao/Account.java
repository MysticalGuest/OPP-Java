package com.dao;

import java.util.ArrayList;

public class Account {
	private int id = 0;
	private String name;
	private double balance = 0;
	private double annualInterestRate=1.5;
	
	ArrayList<Transaction> transactions = new ArrayList<>();
	
	public Account() {
	}
	
	public Account(String name , int id , double balance) {
		this.name = name;
		this.id = id;
		this.balance = balance;
	} 
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void withdraw(double WithdarwMoney) {
		if(WithdarwMoney < balance) {
			balance = balance - WithdarwMoney;
			Transaction trans = new Transaction('W',WithdarwMoney,balance);
			transactions.add(trans);
		}
	}

	public void deposit(double DepositMoney) {
		balance = balance + DepositMoney;
		Transaction trans = new Transaction('D',DepositMoney,balance);
		transactions.add(trans);
	}
	
	public String toString() {
		return transactions.toString();
	}


}
