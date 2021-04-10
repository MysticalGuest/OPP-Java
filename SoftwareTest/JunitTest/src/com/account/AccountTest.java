package com.account;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
//import junit.framework.Test;
//import junit.framework.TestSuite;

public class AccountTest extends TestCase { 
	private Account AccountA; 
	private Account AccountB; 
	
	/*public void setUp(){ 
		AccountA=new Account("notyy",100); 
		AccountB=new Account("bricks",200); 
	}*/
	
	/*public static void main(String args[]) { 
		junit.textui.TestRunner.run(AccountTest.class); 
	}*/
	
	public void testAccount(){ 
		AccountA=new Account("notyy",100); 
		AccountB=new Account("bricks",200); 
		assertEquals("notyy",AccountA.getOwner());
		assertEquals("bricks",AccountB.getOwner());
	}
	
	public void testCredit(){ 
		AccountA=new Account("notyy",100); 
		AccountB=new Account("bricks",200); 
		AccountA.credit(100); 
		//100+100=200 
		assertEquals(200,AccountA.getBalance()); 
		AccountB.credit(150); 
		//200+150=350 
		assertEquals(350,AccountB.getBalance()); 
	} 
	
	public void testDiscount(){ 
		AccountA=new Account("notyy",100); 
		AccountB=new Account("bricks",200); 
		AccountA.discount(50); 
		//100-50=50 
		assertEquals(50,AccountA.getBalance()); 
		AccountB.discount(120); 
		//200-120=80 
		assertEquals(80,AccountB.getBalance()); 
	}
	
	public void testTransfer(){ 
		AccountA=new Account("notyy",100); 
		AccountB=new Account("bricks",200); 
		AccountA.transfer(AccountB,80); 
		//100-80=20 
		//200+80=280 
		assertEquals(20,AccountA.getBalance(),2); 
		assertEquals(280,AccountB.getBalance(),2); 
	}
	
	public static Test suite() {
		return new TestSuite(AccountTest.class); 
	}
}
