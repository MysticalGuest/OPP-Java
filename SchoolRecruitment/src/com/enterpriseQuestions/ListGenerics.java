 package com.enterpriseQuestions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author MysteryGuest
 * @category 企业面试题
 * @date 2021/10/24
 */
public class ListGenerics {
    
    /**
     * 考点：泛型
     * 下面代码
     *  listA = listB;和
     *  listB = listA;
     * 是否合法，说明原因？
     * 提示：泛型是JDK5.0的特性，下面代码是在JDK8.0的环境下运行。
     * */
    public static void main(String[] args) {
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        
        // getClass() 返回此对象的运行时类
        System.out.println(listA.getClass()==listB.getClass());  
//        listA = listB;
//        listB = listA;
        /**
         * 语法错误
         * */
    }
    
    @Test
    // 擦除
    public void testErase() {
        ArrayList<String> arrayString = new ArrayList<String>();
        ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
        // ture
        System.out.println( arrayString.getClass() == arrayInteger.getClass() );
        /**
         * 在这个例子中，我们定义了两个ArrayList数组，不过一个是ArrayList<String>泛型类型，只能存储字符串。
         * 一个是ArrayList<Integer>泛型类型，只能存储整型。
         * 最后，我们通过arrayString对象和arrayInteger对象的getClass方法获取它们的类信息并比较，
         * 发现结果为true。
         * 
         * 这是为什么呢，明明我们定义了两种不同的类型？因为，在编译期间，所有的泛型信息都会被擦除，
         * List<Integer>和List<String>类型，在编译后都会变成List类型（原始类型）。
         * Java中的泛型基本上都是在编译器这个层次来实现的，这也是Java的泛型被称为“伪泛型”的原因。
         * */
        
        /**
         * 原始类型：
         * 
         * 原始类型就是泛型类型擦除了泛型信息后，在字节码中真正的类型。无论何时定义一个泛型类型，
         * 相应的原始类型都会被自动提供。原始类型的名字就是删去类型参数后的泛型类型的类名。
         * 擦除 类型变量，并替换为 限定类型（T为无限定的 类型变量，用Object替换）。
         * */
        
        /**
         * //泛型类型
            class Pair<T> {  
                private T value;  
                public T getValue() {  
                    return value;  
                }  
                public void setValue(T  value) {  
                    this.value = value;  
                }  
            }
         * */
        
        /**
         * //原始类型
            class Pair {  
                private Object value;  
                public Object getValue() {  
                    return value;  
                }  
                public void setValue(Object  value) {  
                    this.value = value;  
                }  
            }
         * */
        
        /**
         * 因为在Pair<T>中，T是一个无限定的类型变量，所以用Object替换。
         * 如果是Pair<T extends Number>，擦除后，类型变量用Number类型替换。
         * */
    }
    
    // 突破泛型约束
    @Test
    public void testReflectInGeneric() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        ArrayList<Integer> array=new ArrayList<Integer>();  
        // 这样调用add方法只能存储整形，因为泛型类型的实例为Integer 
        array.add(1); 
        // 通过泛型可以突破泛型类型约束
        array.getClass().getMethod("add", Object.class).invoke(array, "string");  
        for (int i=0;i<array.size();i++) {  
            System.out.println(array.get(i));  
        }
        
        /**
         * 为什么呢？我们在介绍泛型时指出向ArrayList<Integer>中插入String类型的对象，编译时会报错。
         * 现在为什么又可以了呢？
         * 
         * 我们在程序中定义了一个ArrayList<Integer>泛型类型，如果直接调用add方法，那么只能存储整形的数据。
         * 不过当我们利用反射调用add方法的时候，却可以存储字符串。
         * 这说明ArrayList<Integer>泛型信息在编译之后被擦除了，只保留了原始类型，类型变量（T）被替换为Object，
         * 在运行时，我们可以行其中插入任意类型的对象。
         * 
         * 再次应证：Java中的泛型基本上都是在编译器这个层次来实现的“伪泛型”。
         * 但是，并不推荐以这种方式操作泛型类型，因为这违背了泛型的初衷（减少强制类型转换以及确保类型安全）。
         * 当我们从集合中获取元素时，默认会将对象强制转换成泛型参数指定的类型（这里是Integer），
         * 如果放入了非法的对象这个强制转换过程就会出现异常。
         * */
    }
    
    @Test
    // 泛型方法的类型推断
    public void testInfer() {
        /**
         * 在调用泛型方法的时候，可以指定泛型类型，也可以不指定。
         * 在不指定泛型类型的情况下，泛型类型为该方法中的几种参数类型的共同父类的最小级，直到Object。
         * 在指定泛型类型的时候，该方法中的所有参数类型必须是该泛型类型或者其子类!!!!!!!!!!!!
         * */
        /**不指定泛型的时候*/  
        int i = ListGenerics.add(1, 2); //这两个参数都是Integer，所以T替换为Integer类型  
        Number f = ListGenerics.add(1, 1.2);//这两个参数一个是Integer，另一个是Float，所以取同一父类的最小级，为Number  
        Object o = ListGenerics.add(1, "asd");//这两个参数一个是Integer，另一个是String，所以取同一父类的最小级，为Object
        System.out.println("i:  " + i + "  f:  "+f + "  o:  "+o);
  
        /**指定泛型的时候*/  
        int a=ListGenerics.<Integer>add(1, 2);//指定了Integer，所以只能为Integer类型或者其子类  
        int b=ListGenerics.<Integer>add(1, 2.2);//编译错误，指定了Integer，不能为Float  
        Number c=ListGenerics.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float  
    }
    
    // 这是一个简单的泛型方法  
    public static <T> T add(T x,T y){  
        return y;  
    }
    
    /**
     * 正确的运转
     * 既然说类型变量会在编译的时候擦除掉，那为什么定义了ArrayList<Integer>泛型类型，
     * 而不允许向其中插入String对象呢？不是说泛型变量Integer会在编译时候擦除变为原始类型Object吗，
     * 为什么不能存放别的类型呢？既然类型擦除了，如何保证我们只能使用泛型变量限定的类型呢？
     * 
     * java是如何解决这个问题的呢？java编译器是通过先检查代码中泛型的类型，然后再进行类型擦除，再进行编译的。
     * 以如下代码为例：
     * */
    @Test
    public void testPair() {
        Pair<Integer> pair=new Pair<Integer> ();
        pair.setValue(3);
        Integer integer = pair.getValue();
        System.out.println(integer);
        /**
         * 擦除getValue()的返回类型后将返回Object类型，编译器自动插入Integer的强制类型转换。
         * 也就是说，编译器把这个方法调用翻译为两条字节码指令：
         *      1.对原始方法Pair.getValue的调用
         *      2.将返回的Object类型强制转换为Integer
         * 此外，存取一个泛型域时，也要插入强制类型转换。因此，我们说Java的泛型是在编译器层次进行实现的，
         * 被称为“伪泛型”，相对于C++。
         * */
    }
    
    @Test
    /**
     * 1、泛型类型引用传递问题
     * 在Java中，像下面形式的引用传递是不允许的：!!!!!!!!!!!!!!!!重要
     * */
    public void testTransmit() {
        ArrayList<String> arrayList1 = new ArrayList<Object>();//编译错误
        ArrayList<Object> arrayList2 = new ArrayList<String>();//编译错误
        
        // 我们先看第一种情况，将第一种情况拓展成下面的形式：
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        arrayList1.add(new Object());
        arrayList1.add(new Object());
        ArrayList<String> arrayList4 = arrayList3;//编译错误
        /**
         * 实际上，在第4行代码处，就会有编译错误。那么，我们先假设它编译没错。
         * 那么当我们使用arrayList2引用用get()方法取值的时候，返回的都是String类型的对象，
         * 可是它里面实际上已经被我们存放了Object类型的对象，这样，就会有ClassCastException了。
         * 所以为了避免这种极易出现的错误，Java不允许进行这样的引用传递。（这也是泛型出现的原因，
         * 就是为了解决类型转换的问题，我们不能违背它的初衷）。
         * 在看第二种情况，将第二种情况拓展成下面的形式：
         * */
        ArrayList<String> arrayList5 = new ArrayList<String>();
        arrayList1.add(new String());
        arrayList1.add(new String());
        ArrayList<Object> arrayList6 = arrayList5;//编译错误
        /**
         * 没错，这样的情况比第一种情况好的多，最起码，
         * 在我们用arrayList2取值的时候不会出现ClassCastException，因为是从String转换为Object。
         * 可是，这样做有什么意义呢，泛型出现的原因，就是为了解决类型转换的问题。
         * 我们使用了泛型，到头来，还是要自己强转，违背了泛型设计的初衷。所以java不允许这么干。
         * 再说，你如果又用arrayList2往里面add()新的对象，那么到时候取得时候，
         * 我怎么知道我取出来的到底是String类型的，还是Object类型的呢？
         * 
         * 所以，要格外注意泛型中引用传递问题。
         * */
    }
    
    /**
     * 2、泛型类型变量不能是基本数据类型
     * 就比如，没有ArrayList<double>，只有ArrayList<Double>。
     * 因为当类型擦除后，ArrayList的原始类中的类型变量（T）替换为Object，但Object类型不能存储double值。
     * */
    
    @Test
    /**
     * 3、运行时类型查询
     * */ 
    public void testRuntimeTypeQuery() {
        // 举个例子:
        ArrayList<String> arrayList = new ArrayList<String>();
        /**
         * 因为类型擦除之后，ArrayList<String>只剩下原始类型，泛型信息String不存在了。
         * 那么，运行时进行类型查询的时候使用下面的方法是错误的
         * */
        if( arrayList instanceof ArrayList<String>) {
            
        }
        /**
         * java限定了这种类型查询的方式，？为通配符，也即非限定符。
         * */
        if( arrayList instanceof ArrayList<?>) {
            
        }
    }
    

      
}

class A{}
class B extends A{}
class C extends A{}

//泛型类型
class Pair<T> {  
    private T value;
    public T getValue() {
        return value;
    }
    public void setValue(T  value) {
        this.value = value;
    }  
}

//原始类型
//class Pair {
//    private Object value;
//    public Object getValue() {
//        return value;
//    }
//    public void setValue(Object  value) {
//        this.value = value;
//    }  
//}

/**
 * 4、泛型在静态方法和静态类中的问题
 * 泛型类中的静态方法和静态变量不可以使用泛型类所声明的泛型类型参数
 * */
class Test1<T> {    
    public static T one;   // 编译错误    
    public static  T show(T one){ // 编译错误    
        return null;    
    }    
}
/**
 * 因为泛型类中的泛型参数的实例化是在定义泛型类型对象（例如ArrayList<Integer>）的时候指定的，
 * 而静态变量和静态方法不需要使用对象来调用。对象都没有创建，如何确定这个泛型参数是何种类型，
 * 所以当然是错误的。
 * 但是要注意区分下面的一种情况：
 * */
class Test2<T> {    
    public static <T> T show(T one){// 这是正确的    
        return null;    
    }    
}
//因为这是一个泛型方法，在泛型方法中使用的T是自己在方法中定义的T，而不是泛型类中的T。

/**
泛型相关面试题
1. Java中的泛型是什么 ? 使用泛型的好处是什么?
泛型是一种参数化类型的机制。它可以使得代码适用于各种类型，从而编写更加通用的代码，例如集合框架。

泛型是一种编译时类型确认机制。它提供了编译期的类型安全，确保在泛型类型（通常为泛型集合）上只能使用正确类型的对象，
避免了在运行时出现ClassCastException。

2、Java的泛型是如何工作的 ? 什么是类型擦除 ?
泛型的正常工作是依赖编译器在编译源码的时候，先进行类型检查，
然后进行类型擦除并且在类型参数出现的地方插入强制转换的相关指令实现的。

编译器在编译时擦除了所有类型相关的信息，所以在运行时不存在任何类型相关的信息。
例如List<String>在运行时仅用一个List类型来表示。为什么要进行擦除呢？这是为了避免类型膨胀。

3. 什么是泛型中的限定通配符和非限定通配符 ?
限定通配符对类型进行了限制。有两种限定通配符，一种是<? extends T>它通过确保类型必须是T的子类来设定类型的上界，
另一种是<? super T>它通过确保类型必须是T的父类来设定类型的下界。
泛型类型必须用限定内的类型来进行初始化，否则会导致编译错误。另一方面<?>表示了非限定通配符，
因为<?>可以用任意类型来替代。

4. List<? extends T>和List <? super T>之间有什么区别 ?
这和上一个面试题有联系，有时面试官会用这个问题来评估你对泛型的理解，而不是直接问你什么是限定通配符和非限定通配符。
这两个List的声明都是限定通配符的例子，List<? extends T>可以接受任何继承自T的类型的List，
而List<? super T>可以接受任何T的父类构成的List。
例如List<? extends Number>可以接受List<Integer>或List<Float>。

5. 如何编写一个泛型方法，让它能接受泛型参数并返回泛型类型?
编写泛型方法并不困难，你需要用泛型类型来替代原始类型，比如使用T, E or K,V等被广泛认可的类型占位符。
泛型方法的例子请参阅Java集合类框架。最简单的情况下，一个泛型方法可能会像这样:
public V put(K key, V value) {
    return cache.put(key, value);
}
6. Java中如何使用泛型编写带有参数的类?
这是上一道面试题的延伸。面试官可能会要求你用泛型编写一个类型安全的类，而不是编写一个泛型方法。
关键仍然是使用泛型类型来代替原始类型，而且要使用JDK中采用的标准占位符。
7. 编写一段泛型程序来实现LRU缓存?
对于喜欢Java编程的人来说这相当于是一次练习。给你个提示，LinkedHashMap可以用来实现固定大小的LRU缓存，
当LRU缓存已经满了的时候，它会把最老的键值对移出缓存。LinkedHashMap提供了一个称为removeEldestEntry()的方法，
该方法会被put()和putAll()调用来删除最老的键值对。
8. 你可以把List<String>传递给一个接受List<Object>参数的方法吗？
对任何一个不太熟悉泛型的人来说，这个Java泛型题目看起来令人疑惑，因为乍看起来String是一种Object，
所以List<String>应当可以用在需要List<Object>的地方，但是事实并非如此。真这样做的话会导致编译错误。
如果你再深一步考虑，你会发现Java这样做是有意义的，因为List<Object>可以存储任何类型的对象包括String, 
Integer等等，而List<String>却只能用来存储Strings。
List<Object> objectList;
List<String> stringList;
      
objectList = stringList;  //compilation error incompatible types

9. Array中可以用泛型吗?
这可能是Java泛型面试题中最简单的一个了，当然前提是你要知道Array事实上并不支持泛型，
这也是为什么Joshua Bloch在Effective Java一书中建议使用List来代替Array，
因为List可以提供编译期的类型安全保证，而Array却不能。
10. 如何阻止Java中的类型未检查的警告?
如果你把泛型和原始类型混合起来使用，例如下列代码，Java 5的javac编译器会产生类型未检查的警告
，例如List<String> rawList = new ArrayList()
注意: Hello.java使用了未检查或称为不安全的操作;
这种警告可以使用@SuppressWarnings("unchecked")注解来屏蔽。

11、Java中List<Object>和原始类型List之间的区别?
原始类型和带参数类型<Object>之间的主要区别是，在编译时编译器不会对原始类型进行类型安全检查，
却会对带参数的类型进行检查，通过使用Object作为类型，可以告知编译器该方法可以接受任何类型的对象，
比如String或Integer。这道题的考察点在于对泛型中原始类型的正确理解。它们之间的第二点区别是，
你可以把任何带参数的泛型类型传递给接受原始类型List的方法，
但却不能把List<String>传递给接受List<Object>的方法，因为会产生编译错误。

12、Java中List<?>和List<Object>之间的区别是什么?
这道题跟上一道题看起来很像，实质上却完全不同。List<?> 是一个未知类型的List，
而List<Object>其实是任意类型的List。你可以把List<String>, List<Integer>赋值给List<?>，
却不能把List<String>赋值给List<Object>。
List<?> listOfAnyType;
List<Object> listOfObject = new ArrayList<Object>();
List<String> listOfString = new ArrayList<String>();
List<Integer> listOfInteger = new ArrayList<Integer>();
      
listOfAnyType = listOfString; //legal
listOfAnyType = listOfInteger; //legal
listOfObjectType = (List<Object>) listOfString; //compiler error - in-convertible types

13、List<String>和原始类型List之间的区别.
该题类似于“原始类型和带参数类型之间有什么区别”。带参数类型是类型安全的，而且其类型安全是由编译器保证的，
但原始类型List却不是类型安全的。你不能把String之外的任何其它类型的Object存入String类型的List中，
而你可以把任何类型的对象存入原始List中。使用泛型的带参数类型你不需要进行类型转换，但是对于原始类型，
你则需要进行显式的类型转换。
List listOfRawTypes = new ArrayList();
listOfRawTypes.add("abc");
listOfRawTypes.add(123); //编译器允许这样 - 运行时却会出现异常
String item = (String) listOfRawTypes.get(0); //需要显式的类型转换
item = (String) listOfRawTypes.get(1); //抛ClassCastException，因为Integer不能被转换为String
      
List<String> listOfString = new ArrayList();
listOfString.add("abcd");
listOfString.add(1234); //编译错误，比在运行时抛异常要好
item = listOfString.get(0); //不需要显式的类型转换 - 编译器自动转换
 * */

/**
通配符
通配符上界
常规使用
public class Test {
    public static void printIntValue(List<? extends Number> list) {
        for (Number number : list) {
            System.out.print(number.intValue()+" "); 
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> integerList=new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(2);
        printIntValue(integerList);
        List<Float> floatList=new ArrayList<Float>();
        floatList.add((float) 3.3);
        floatList.add((float) 0.3);
        printIntValue(floatList);
    }
}
输出：
2 2 
3 0 

非法使用
public class Test {
    public static void fillNumberList(List<? extends Number> list) {
        list.add(new Integer(0));//编译错误
        list.add(new Float(1.0));//编译错误
    }
    public static void main(String[] args) {
        List<? extends Number> list=new ArrayList();
        list.add(new Integer(1));//编译错误
        list.add(new Float(1.0));//编译错误
    }
}

List<? extends Number>可以代表List<Integer>或List<Float>，为什么不能像其中加入Integer或者Float呢？
首先，我们知道List<Integer>之中只能加入Integer。并且如下代码是可行的：
List<? extends Number> list1=new ArrayList<Integer>();
List<? extends Number> list2=new ArrayList<Float>();

假设前面的例子没有编译错误，如果我们把list1或者list2传入方法fillNumberList，显然都会出现类型不匹配的情况， 
假设不成立。
因此，我们得出结论：不能往List<? extends T> 中添加任意对象，除了null。

那为什么对List<? extends T>进行迭代可以呢，因为子类必定有父类相同的接口，这正是我们所期望的。
 * */

/**
通配符下界
常规使用
public class Test {
    public static void fillNumberList(List<? super Number> list) {
        list.add(new Integer(0));
        list.add(new Float(1.0));
    }
    public static void main(String[] args) {
        List<? super Number> list=new ArrayList(); 
        list.add(new Integer(1));
        list.add(new Float(1.1));
    }
}
可以添加Number的任何子类，为什么呢？
List<? super Number>可以代表List<T>，其中T为Number父类，（虽然Number没有父类）。
如果说，T为Number的父类，我们想List<T>中加入Number的子类肯定是可以的。
非法使用
对List<? superT>进行迭代是不允许的。为什么呢？你知道用哪种接口去迭代List吗？
只有用Object类的接口才能保证集合中的元素都拥有该接口，显然这个意义不大。其应用场景略。

 * */

/**
无界通配符
知道了通配符的上界和下界，其实也等同于知道了无界通配符，不加任何修饰即可，单独一个“？”。如List<?>，“？”可以代表任意类型，“任意”也就是未知类型。
List<Object>与List<?>并不等同，List<Object>是List<?>的子类。还有不能往List<?> list里添加任意对象，除了null。
 
常规使用
1、当方法是使用原始的Object类型作为参数时，如下：
public static void printList(List<Object> list) {
    for (Object elem : list)
        System.out.println(elem + "");
    System.out.println();
}
可以选择改为如下实现：
public static void printList(List<?> list) {
    for (Object elem: list)
        System.out.print(elem + "");
    System.out.println();
}
这样就可以兼容更多的输出，而不单纯是List<Object>,如下：
List<Integer> li = Arrays.asList(1, 2, 3);
List<String>  ls = Arrays.asList("one", "two", "three");
printList(li);
printList(ls);
 * */