package com.newthread;

public class StaticProxy {
	public static void main(String[] args) {
		SpringPioneer springPioneer = new SpringPioneer(new Programmer());
		springPioneer.Deploy();
	}
}

interface SpringBootFrame {
	
	void Deploy();
}

// 真实角色，程序员
class Programmer implements SpringBootFrame{

	@Override
	public void Deploy() {
		System.out.println("Programmer SpringBoot deployed successfully!");
	}
	
}

// 代理角色，SpringBoot的作者，帮我们简化开发
class SpringPioneer implements SpringBootFrame{
	
	// 代理谁-->真实目标角色
	private SpringBootFrame target;
	
	public SpringPioneer(SpringBootFrame target) {
		this.target = target;
	}

	@Override
	public void Deploy() {
		before();
		this.target.Deploy();	// 这就是真实对象
		after();
		
	}
	
	private void before() {
		System.out.println("研发出这个SpringBoot框架，并开源。");
	}
	
	private void after() {
		System.out.println("不断推出新的特性。");
	}
	
}