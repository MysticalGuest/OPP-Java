package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBaidu {

	public static void main(String[] args) {
		WebDriver driver;
		// 设置驱动的路径
		/*
		 * 这里一定要保持chromedriver.exe与已安装的Chrome版本一致
		 * 参看http://npm.taobao.org/mirrors/chromedriver/
		 * */
		System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // 借助Chrome进行操作
		driver.get("http://www.baidu.com");
		
		// 全局隐式等待,与浏览器同步非常重要,必须等待浏览器加载完毕
		// 打开一个新的页面时,可能页面还没加载出来,此时已经进行下一步操作,元素定位,于是报错.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement input = driver.findElement(By.xpath(".//*[@id='kw']"));
		CharSequence[] cs = new CharSequence[1];
		cs[0]="安居客";
		input.sendKeys(cs);
		
		WebElement btn = driver.findElement(By.xpath(".//*[@id='su']"));
		System.out.println("btn:" + btn);
		btn.click();
		
//		WebElement btn1 = driver.findElement(By.xpath(".//*[@id='w-75cn8k']/div/h2/a[1]"));
//		btn1.click();
		System.out.println("Page title is:"+driver.getTitle());
		// Sleep(2000);
//		driver.close();
		
	}

}

