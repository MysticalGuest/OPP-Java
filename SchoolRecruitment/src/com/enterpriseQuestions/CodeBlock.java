 package com.enterpriseQuestions;

 /**
 * @author MysteryGuest
 * @date 2021/10/29
 * 考点：构造方法、构造代码块、静态块加载时期
 */
public class CodeBlock {
    private static int x=100;
    public static void main(String[] args) {
        new Block();
        
        // 测试BlockWithVarible
        /**
         * 不new对象的，只调用静态代码块，给staticProperty赋值，所以是2
         * */
        System.out.println(BlockWithVarible.staticProperty);
        System.err.println("分界线-----------------");
        System.out.println(new BlockWithVarible().property);

        // 静态变量
        System.out.println("静态变量意味着该类的所有实例化对象用的都是同一个x...");
        CodeBlock cb1 = new CodeBlock();
        cb1.x++;
        CodeBlock cb2 = new CodeBlock();
        cb2.x+=cb1.x;
        cb1=new CodeBlock();
        cb1.x--;
        CodeBlock.x--;
        System.out.println("x="+cb1.x);
    }

}

/**
 * 加载顺序（从先到后）：静态块->普通代码块->构造器
 * */
class Block {
    private static int x=100;
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

class BlockWithVarible{
    public static String staticProperty="1";
    public String property="a";
    
    static {
        staticProperty="2";
        System.out.println("调用静态代码块...");
    }
    
    /**
     * 
     */
    public BlockWithVarible() {
        this.property="b";
        staticProperty="3";
    }
    
    {
        this.property="c";
        staticProperty="4";
        System.out.println("调用普通代码块...");
    }
}