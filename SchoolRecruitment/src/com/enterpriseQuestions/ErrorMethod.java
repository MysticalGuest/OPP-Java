 package com.enterpriseQuestions;

 /**
 * @author MysteryGuest
 * @date 2021/10/26
 */
public class ErrorMethod {

    /**
     * @param args
     * @implNote 下面代码是否编译出错？如果编译无误，输出结果是多少？说明理由
     */
    public static void main(String[] args) {
        System.out.println(mathod());

    }
    
    public static int mathod() {
        int num=0;
        try {
            num = 5 / num;
            return num;
        } catch (Exception e) {
            System.out.println("此时catch块中num的值为: " + num);
            return num++;
        } finally {
            // 值为1，说明catch块中的return语句中num++执行了，return并未执行成功，但finally块还是会执行
            System.out.println("此时finally块中num的值为: " + num);
            return ++num;
            /**
             * 当finall块中包含return语句时，
             * Eclipse会给出警告“finally block does not complete normally”，原因分析如下：
             *      1、不管try块、catch块中是否有return语句，finally块都会执行!!!!
             *      2、finally块中的return语句会覆盖前面的return语句（try块、catch块中的return语句），
             *      所以如果finally块中有return语句，
             *      Eclipse编译器会报警告“finally block does not complete normally”。
             *      3、如果finally块中包含了return语句，即使前面的catch块重新抛出了异常，则调用该方法的语句也不会获得catch块重新抛出的异常，而是会得到finally块的返回值，并且不会捕获异常。
             * 结论，应避免在finally块中包含return语句。如果你在前面的语句中包含了return语句或重新抛出了异常，
             * 又在finally块中包含了return语句，说明你概念混淆，没有理解finally块的意义。
             * */
        }
        
    }

}
