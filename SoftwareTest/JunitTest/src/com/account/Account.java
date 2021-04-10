package com.account;

public class Account {
	private String Owner; 
	private int Balance; 
	
	public Account(String aOwner,int aBalance) { 
		Owner=aOwner; 
		Balance=aBalance; 
	}
	
	public String getOwner(){ 
		return Owner; 
	}
	 
	public int getBalance(){ 
		return Balance; 
	}
	 
	public void credit(int aMoney){ 
		Balance-=aMoney;
	}
	
	public void discount(int aMoney){ 
		Balance+=aMoney; 
	}
	
	public void transfer(Account aAccount,int aBalance){
		this.discount(aBalance); 
		aAccount.credit(aBalance); 
	}

}
