package com.main;

import java.io.IOException;
import java.util.Scanner;

import com.dao.*;

public class Store {
	
	// 初始化商品
	static Goods Bread = new Goods("Bread", 1);
	static Goods Cocacola = new Goods("Cocacola", 1);
	static Goods Beer = new Goods("Beer ", 1);
	static Goods Chocalate = new Goods("Chocalate", 1);
	static Goods Pencil = new Goods("Pencil", 0.5F);
	static Goods Notebook = new Goods("Notebook", 3);
	static final Goods goods[] = {Bread ,Cocacola ,Beer ,Chocalate ,Pencil ,Notebook};

	private static Basket basket = new Basket();
	
	static int select;
	
	public static void main(String[] args) throws IOException {
//		Scanner input = new Scanner(System.in); 
		// 打印菜单头
//		printMenu();
//		
//		int select = input.nextInt();
//		
//		while (invalidInput(select)) {
//			printMenu();
//			
//			select = input.nextInt();
//		}
//		
//		while(select!=0) {
//			switch (select) {
//			case 1:
//				basket.addGoods(Bread);
//				System.out.println("YOU HAVE SELECTED [Bread], $1.0\n");
//				break;
//			case 2:
//				basket.addGoods(Cocacola);
//				System.out.println("YOU HAVE SELECTED [Cocacola], $1.0\n");
//				break;
//			case 3:
//				basket.addGoods(Beer);
//				System.out.println("YOU HAVE SELECTED [Beer], $1.0\n");
//				break;
//			case 4:
//				basket.addGoods(Chocalate);
//				System.out.println("YOU HAVE SELECTED [Chocalate], $1.0\n");
//				break;
//			case 5:
//				basket.addGoods(Pencil);
//				System.out.println("YOU HAVE SELECTED [Pencil], $0.5\n");
//				break;
//			case 6:
//				basket.addGoods(Notebook);
//				System.out.println("YOU HAVE SELECTED [Notebook], $3.0\n");
//				break;
//			}
//			
//			printMenu();
//			
//			select = input.nextInt();
//			if(select==9) {
//				System.out.println("========= CHECK OUT =========\n");
//				String blank = String.format("%4s", "");
//				String str;  
//				for (Goods good : basket.getAllGoods()) {
//					
//					str=String.format("%-10s", good.getName());
//					System.out.println(blank+str+"\t"+"\t"+good.getPrice());
//				}
//				System.out.println("=============================\n"
//						+ "TOTAL:  $"+basket.getTotalPrice()+"\n"
//						+ "THANKS!\n");
//				
//				// 一轮购物下来, 清空购物车
//				basket.clear();
//				System.out.print("After pressing any key, you can start a new round of shopping!");
//				String key = input.next();
//				key=key+"";
//				System.out.println();
//			}
//			
//			
//			
//		}
//		int select;
		do {
			printMenu();
			
//			select = input.nextInt();
			
			while (invalidInput()) {
				printMenu();
				
//				select = input.nextInt();
			}
			
			switch (select) {
			case 1:
				basket.addGoods(Bread);
				System.out.println("YOU HAVE SELECTED [Bread], $1.0\n");
				break;
			case 2:
				basket.addGoods(Cocacola);
				System.out.println("YOU HAVE SELECTED [Cocacola], $1.0\n");
				break;
			case 3:
				basket.addGoods(Beer);
				System.out.println("YOU HAVE SELECTED [Beer], $1.0\n");
				break;
			case 4:
				basket.addGoods(Chocalate);
				System.out.println("YOU HAVE SELECTED [Chocalate], $1.0\n");
				break;
			case 5:
				basket.addGoods(Pencil);
				System.out.println("YOU HAVE SELECTED [Pencil], $0.5\n");
				break;
			case 6:
				basket.addGoods(Notebook);
				System.out.println("YOU HAVE SELECTED [Notebook], $3.0\n");
				break;
			}
			
			
			
			if(select==9) {
				System.out.println("========= CHECK OUT =========\n");
				String blank = String.format("%4s", "");
				String str;  
				for (Goods good : basket.getAllGoods()) {
					
					str=String.format("%-10s", good.getName());
					System.out.println(blank+str+"\t"+"\t"+good.getPrice());
				}
				System.out.println("=============================\n"
						+ "TOTAL:  $"+basket.getTotalPrice()+"\n"
						+ "THANKS!\n");
				
				basket.clear();
				System.out.print("After pressing any key, you can start a new round of shopping!");
				System.in.read();
				System.out.println();
			}
			
		} while (select!=0);

//		input.close();
		
		
	}
	
	public static void printMenu() {
		String MESSAGE_HEADER="********************************************\n"
				+ "   Welcome to XiaoFang Convenience Store\n"
				+ "********************************************\n";
		
		
		String MESSAGE_FOOTER="\n(9)CHECK OUT\n"
				+ "(0)EXIT\n"
				+ "--------------------------------------------\n"
				+ " PLEASE SELECT A NUMBER: ";
		
		System.out.println(MESSAGE_HEADER);
		
		for (int i = 0; i < goods.length; i++) {
			System.out.println("("+(i+1)+")"+goods[i].getName()+"\t"+"\t"+goods[i].getPrice());
		}
		
		System.out.print(MESSAGE_FOOTER);
	}
	
//	public static boolean invalidInput(int select) {
//		if(!(select==1||select==2||select==3||select==4||select==5||select==6||select==9||select==0)) {
//			System.out.println("INUALID INPUT, PLEASE TRY AGAIN!");
//			return true;
//		}
//		return false;
//	}
	
	public static boolean invalidInput() {
		Scanner input = new Scanner(System.in);
		select = input.nextInt();
		if(!(select==1||select==2||select==3||select==4||select==5||select==6||select==9||select==0)) {
			System.out.println("INUALID INPUT, PLEASE TRY AGAIN!");
			return true;
		}
		return false;
	}

}

