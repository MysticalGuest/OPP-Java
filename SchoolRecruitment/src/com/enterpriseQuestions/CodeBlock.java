 package com.enterpriseQuestions;

 /**
 * @author MysteryGuest
 * @date 2021/10/29
 * 考点：构造方法、构造代码块、静态块加载时期
 */
public class CodeBlock {
    public static void main(String[] args) {
        new Block();
    }

}

/**
 * 加载顺序（从先到后）：静态块->普通代码块->构造器
 * */
class Block {
    public Block() {
        System.out.println("A");
    }
    static {
        System.out.println("B");
    }
    {
        System.out.println("C");
    }
}
