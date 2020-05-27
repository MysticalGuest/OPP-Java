package com.dao;

public class Transaction 
		extends Account {
	private java.util.Date dateCreated;
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	public Transaction(char _type,double _amount,double _balance) {
		dateCreated = new java.util.Date();
		type = _type;
		amount = _amount;
		balance = _balance; 
	}
	
	public String toString() {
		description="\nTransaction Time: "+dateCreated+"/Transaction Type: "+type+"/Transaction Amount: "+amount+"/Balance After Transaction: "+balance+"\n";
		return description;
	}

}

