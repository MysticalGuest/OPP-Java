package com.main;

import java.util.Scanner;

import com.dao.*;

public class AccountTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Account[] account = new Account[10];
		
		for(int i = 0 ; i < account.length ; i++)
			account[i] = new Account();
		for(int i = 0 ; i < account.length ; i++){
			account[i].setId(i);
			account[i].setBalance(100.0);
		}
		
		while(true) {
			System.out.print("Enter an id: ");
			int id = input.nextInt();
			while(true) {
				System.out.print("\nMain menu\n" + "1: check balance\n" + "2: withdraw\n" + 
									"3: deposit\n" + "4: exit\n" + "Enter a choice: ");
				int choice = input.nextInt();
				if(choice == 1)
					System.out.println("The balance is " + account[id].getBalance());
				else if(choice == 2) {
					System.out.print("Enter an amount to withdraw: ");
					double WithdrawMoney = input.nextDouble();
					account[id].withdraw(WithdrawMoney);
				}
				else if(choice == 3) {
					System.out.print("Enter an amount to deposit: ");
					double DepositMoney = input.nextDouble();
					account[id].deposit(DepositMoney);
				}
				else
					break;
				
			}
			System.out.println("\nTransaction Over!\n\nFollowing Information:\nUser ID: "+id+"\nAnnualInterestRate: "+account[id].getAnnualInterestRate()+"%");
			System.out.println(account[id].toString());
			System.out.print("Input 'Y' to continue transactions or 'N' to exit: ");
			char ch = input.next().charAt(0);
			if(ch=='N')
				break;
		}
		input.close();
	}

}
