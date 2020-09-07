package com.lambda;

public class lambda1 {
	
	// 3.静态内部类
	static class StaticEntityLike implements Like {
		@Override
		public void lambda() {
			System.out.println("Static likes lambda!");
			
		}
	}
	
	public static void main(String[] args) {
		Like entityLike = new EntityLike();
		entityLike.lambda();
		
		Like staticEntityLike = new StaticEntityLike();
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

