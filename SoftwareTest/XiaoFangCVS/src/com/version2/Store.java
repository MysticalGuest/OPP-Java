package com.version2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 小芳便利店 主程序
 */
public class Store {
    
    /**
     * 所有商品信息
     */
    private static final Goods[] GOODS = new Goods[] {
        new Goods("Bread", 1.00f),
        new Goods("Cocacola", 1.00f),
        new Goods("Beer", 1.00f),
        new Goods("Chocalate", 1.00f),
        new Goods("Pencil", 0.50f),
        new Goods("Notebook", 3.00f),
    };
    
    /**
     * 菜单顶部
     */
    public static final String MESSAGE_HEADER = 
       "*********************************************\n" +
       "   Welcome to XiaoFang Convenience Store     \n" +
       "*********************************************\n";
    
    /**
     * 菜单底部
     */
    public static final String MESSAGE_FOOTER = 
        "\n" + 
        " (9) CHECK OUT\n" +
        " (0) EXIT\n" +
        "---------------------------------------------\n" +
        " PLEASE SELECT A NUMBER: ";
    
    private static Basket basket;
    
    /**
     * 程序入口
     * @param args 输入的参数
     * @throws Exception 可能抛出的异常
     */
    public static void main(String[] args) throws Exception {
        printMenu();
        basket = new Basket();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = -1;
        while (choice != 0) {
            String input = reader.readLine();
            if (input.equals("")) {
                choice = 100;                
            } else {
                try {
                    choice = Integer.parseInt(input);
                } catch (Exception ex) {
                    choice = -1;
                }
            }
            switch (choice) {
            case 100: printMenu(); break;
            case 9: checkOut(); break;
            case 0: exit(); break;
            default: 
                if (choice < 1 || choice > GOODS.length) {
                    invalidInput();  break;
                } else {
                    addGoods(choice); 
                }
            }
        }
    }

    /**
     * 打印消息退出整个程序
     */
    private static void exit() throws Exception {
        System.out.println("-------------");
        System.out.println("GOOD BYE!");
        System.out.println("[PRESS ENTER TO EXIT...]");
        System.in.read();
    }

    /**
     * 买单，打印所有已经选择的商品
     */
    private static void checkOut() throws Exception {
        if (basket.isEmpty()) {
            System.out.println("YOUR BASKET IS EMPTY!");
            return ;
        }
        System.out.println("\n========= CHECK OUT =========\n");
        for (Goods goods: basket.getAllGoods()) {
            System.out.println("     "+goods.getName()+"\t\t"+goods.getPrice());
        }
        System.out.println("==============================");
        System.out.println("TOTAL:  $" + basket.getTotalPrice());
        System.out.println("THANKS!");
        basket.clear();
        System.in.read();
    }

    /**
     * 当输入错误的时候，打印消息
     */
    private static void invalidInput() {
        System.out.println("\nINVALID INPUT, PLEASE TRY AGAIN!");
        printMenu();
    }

    /**
     * 添加选中的商品
     * @param choice 选中的商品的编号
     */
    private static void addGoods(int choice) {
        basket.addGoods(GOODS[choice-1]);
        Goods goods = GOODS[choice -1];
        System.out.println("\nYOU HAVE SELECTED [" + goods.getName() + "], $" + goods.getPrice() + "\n");
        printMenu();
    }

    /**
     * 打印菜单
     */
    private static void printMenu() {
        System.out.println(MESSAGE_HEADER);
        for (int i = 0; i < GOODS.length ; i++) {
            System.out.println(" ("+(i+1)+") "+GOODS[i].getName()+"\t\t"+GOODS[i].getPrice());
        }
        System.out.print(MESSAGE_FOOTER);
    }

}
