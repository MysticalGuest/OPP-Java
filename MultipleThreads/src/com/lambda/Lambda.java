package com.lambda;

public class Lambda {
    
    int non_static_variable = 1;
    static int static_variable = 2;
	
    /*
     * 简单的说就是在一个类的内部又定义了一个类，这个类就称之为内部类（Inner Class）
     * 静态内部类（使用较多）
     * 核心: 学习静态内部类需要联想静态变量和静态方法来理解。
     * 1.定义位置
     *   在类中,方法体和代码块之外,并且必须使用 static来修饰
     * 2.定义语法
     *   [修饰符] class 外部类{
     *     [修饰符] static class 静态内部类{
     *     
     *     }
     *   }
     *   3.注意事项
     *     a)在静态内部类中,不但可以定义成员变量、成员方法、构造方法和构造代码块,还能定义静态变量
     *     b)在静态内部类中,我们只能操作外部类的静态变量和静态方法,不能操作外部类的成员变量和成员
     *     c)使用静态内部类的时候,我们无需创建外部类对象,直接通过外部类名就可以操作静态内部
     *     d)在外部类之外,我们直接操作静态内部类的静态变量和静态方法的语法
     *       操作静态变量: 外部类.静态内部类.静态变量
     *       调用静态方法: 外部类.静态内部类.静态方法(实参列表);
     *   4.静态内部类的创建方式
     *     a)在外部类里面创建
     *       语法: 静态内类对象 = new 静态内部类(实参列表);
     *     b)在外部类外面创建
     *       语法: 外部类.静态内部类对象 = new 外部类.静态内部类(实参列表);
     * */
	// 3.静态内部类
	static class StaticEntityLike implements Like {
		@Override
		public void lambda() {
			System.out.println("Static likes lambda!" + " I can operate the static variable" + static_variable);
			// Cannot make a static reference to the non-static field non_static_variable
//			System.err.println("But I can't operate the no-static variable" + non_static_variable);
		}
	}
	
	public static void main(String[] args) {
		Like entityLike = new EntityLike();
		entityLike.lambda();
		
//		Like staticEntityLike = new StaticEntityLike();
		Lambda.StaticEntityLike staticEntityLike = new StaticEntityLike();
		staticEntityLike.lambda();
		
		// 4.局部内部类
		class InternalEntityLike implements Like {
			@Override
			public void lambda() {
				System.out.println("Internal likes lambda!");
			}
		}
		
		Like internalEntityLike = new InternalEntityLike();
		internalEntityLike.lambda();
		
		// 5.匿名内部类，没有类的名称，必须借助接口或者父类
		Like anonymousEntityLike = new Like() {
			@Override
			public void lambda() {
				System.out.println("Anonymous likes lambda!");
			}
		};
		anonymousEntityLike.lambda();
		
		// 6.用lambda简化
		Like lambdaLike = () -> {
			System.out.println("Lambda likes lambda!");
		};
		lambdaLike.lambda();
		
//		new Like(()->System.out.println("Lambda likes lambda!")).lambda();
		
		// 7.带参数的
		Love lambdaLove = (int t) -> {
			System.out.println("Lambda loves you " + t + " times!");
		};
		lambdaLove.time(520);
		
		// 7.1简化去掉参数类型
		Love love1 = (t) -> {
			System.out.println("Lambda loves you " + t + " times!");
		};
		love1.time(521);
		
		// 7.2简化去掉括号
		Love love2 = t -> {
			System.out.println("Lambda loves you " + t + " times!");
		};
		love2.time(522);
		
		// 7.3简化去掉花括号
		// lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
		Love love3 = t -> System.out.println("Lambda loves you " + t + " times!");
		love3.time(523);
	}

}

// 1.定义一个函数式接口
interface Like {
    /*
     * 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
     * 函数式接口可以被隐式转换为 lambda 表达式。
     * */
	void lambda();
}

// 2.实现类
class EntityLike implements Like {
	@Override
	public void lambda() {
		System.out.println("I like lambda!");
	}
}

// 带参数的
interface Love {
	void time(int t);
}

