package com.all;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.account.AccountTest;
import com.calculator.SampleCalculatorTest;
import com.stack.StackTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({AccountTest.class,SampleCalculatorTest.class,StackTest.class})
public class MyTestAll {

}
