package com.selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IMoocOut {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		// 设置驱动的路径
		System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // 借助Chrome进行操作
		driver.get("https://www.imooc.com/user/newlogin");
//		driver.get("https://www.imooc.com/");
		
		// 获取网页的title
        System.out.println("The page title is: " + driver.getTitle());
		
		// 浏览器窗口最大化
		driver.manage().window().maximize();
		// 浏览器窗口大小自定义
//		driver.manage().window().setSize(new Dimension(480, 800));
		
		/* 
	        // 全局隐式等待,与浏览器同步非常重要,必须等待浏览器加载完毕
			// 此处为设定元素查找最长超时时间为10s
			// 打开一个新的页面时,可能页面还没加载出来,此时已经进行下一步操作,元素定位,于是报错.
		*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 自动化操作
		// 
		driver.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys("18700960652");
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("18700960652!");
		// 通过元素的标签名称定位
//		driver.findElement(By.tagName("input")).sendKeys("18700960652");
		// 通过元素的名称定位
//		driver.findElement(By.name("password")).sendKeys("18700960652");
		// 通过元素的ID定位
		driver.findElement(By.id("auto-signin")).click();
		// 通过元素的类名定位
		driver.findElement(By.className("moco-btn")).click();
		
		
		// 获得父元素ul标签
		// 设置等待时间
//		Thread.sleep(2000); 
		WebElement element = driver.findElement(By.className("nav-item"));
		
		// 获得ul标签下的所有li子元素
		List<WebElement> elements = element.findElements(By.tagName("li"));
		
		System.out.println("elements:" + elements);
		System.out.println("elements:" + elements.size());
		System.out.println("elements:" + elements.get(3));
		elements.get(3).click();
		
		// 刷新页面
		driver.navigate().refresh();
		
		// 执行浏览器后退
	    driver.navigate().back();
	    
	    // 执行浏览器前进
	    driver.navigate().forward();
	    
	    driver.findElement(By.id("common-nav-search")).click();
	    WebElement searchItem = driver.findElement(By.className("nav-search-input"));
	    searchItem.sendKeys("java");
	    // 模拟键盘操作,使用enter键
	    searchItem.sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	    
	    // 获得所有窗口句柄
	    Set<String> handles = driver.getWindowHandles();
	    // System.out.println("handles:" + handles);
	    // [CDwindow-0A7D864A2C49F376A63CE911BE494A3A, CDwindow-27B9ACB0B342CB950D01630393A1176C]
		driver.switchTo().window((String) handles.toArray()[0]);
		// 切换窗口
	    
//	    driver.quit();

	}

}
