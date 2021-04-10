package com.all;

import junit.framework.TestSuite;

import com.account.AccountTest;
import com.calculator.SampleCalculatorTest;
import com.stack.StackTest;

import junit.framework.Test;

/*
 * Junit简介：
 * JUnit是由 Erich Gamma 和 Kent Beck 用java编写的一个进行单元测试（开源）框架。测试可以单个进行，也可以成批进行。
 * JUnit 共有七个包，核心的包就是junit.framework 和junit.runner。
 * Framework包负责整个测试对象的构架，Runner负责测试驱动。
 * 
 * JUnit有四个重要的类：TestCase、TestResult、TestSuite、TestRunner。
 * 前三个类属于Framework包，后一个类在不同的环境下是不同的。各个类的职责如下： 
 * 1.TestResult，负责收集TestCase所执行的结果，它将结果分为两类：可预测的Failure和没有预测的Error。
 *     （Failures：所期望发生的错误；Errors：不是你所期待发生的错误。）
 * 2.TestRunner，调用的起点，负责对整个测试流程的跟踪。能够显示测试的结果，并且报告测试的进度。
 * 3.TestSuite， 负责包装TestCase（将测试用例封装时使用）。
 * 4.TestCase， 客户测试类所要继承的类，负责测试时对客户类进行初始化，以及测试方法调用。
 *     书写测试方法：public void testXXXXX()。
 * 
 * 简单说，Junit进行单元测试的方式就是判断断言是否正确，
 * 我们可以使用以下的断言（参见源码中Assert类（属于junit.framework包））：
 * 
 * assertTrue(String message, boolean condition)
 * assertTrue(boolean condition)
 * assertFalse(String message, boolean condition)
 * assertFalse(boolean condition)
 * assertEquals(String message, Object expected, Object actual)
 * assertEquals(Object expected, Object actual)
 * assertEquals(String message, String expected, String actual)
 * assertEquals(String expected, String actual)
 * assertEquals(String message, double expected, double actual, double delta)
 * assertEquals(double expected, double actual, double delta)
 * assertEquals(String message, float expected, float actual, float delta)
 * assertEquals(float expected, float actual, float delta)
 * ......
 * assertNotNull(String message, Object object)
 * assertNotNull(Object object)
 * assertNull(String message, Object object)
 * assertNull(Object object)
 * 
 * Junit安装：
 * 将Junit.rar（可以在http://www.junit.org下载到最新版本）解压到某一个目录下，
 * 如C:\，之后在classpath中加入：”c:\junit\;c:\junit\junit.jar;“定义类路径。
 * 在命令提示符下运行：java junit.swingui.TestRunner，如果一切正确，就会打开应用程序。
 *     （注：swingui下TestRunner的运行方式是图形界面方式，Junit还有一种文本运行方式，
 *     即在控制台上观察测试结果，方法是运行：java junit.textui.TestRunner）
 * 
 * Junit好处：
 * 1．不需对源程序进行任何修改，减少风险
 * 2．一次可以执行多个测试用例
 * */

public class TestMyAllSample
{
	public static Test suite(){
		TestSuite suite= new TestSuite("All JUnit Tests");
		suite.addTest(AccountTest.suite());
		suite.addTest(SampleCalculatorTest.suite());
		suite.addTest(StackTest.suite());
		return suite;
	}
}
