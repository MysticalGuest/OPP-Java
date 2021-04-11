package com.selenium;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestIMoocWithJUnit {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMoocWithJUnit() throws Exception {
		driver.get("https://www.imooc.com/");
		// 浏览器窗口最大化
		driver.manage().window().maximize();
 		// 浏览器窗口大小自定义
// 		driver.manage().window().setSize(new Dimension(480, 800));
 		
 		/* 
         	// 全局隐式等待,与浏览器同步非常重要,必须等待浏览器加载完毕
 			// 此处为设定元素查找最长超时时间为10s
 			// 打开一个新的页面时,可能页面还没加载出来,此时已经进行下一步操作,元素定位,于是报错.
 		*/
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		
 		// 自动化操作
 		// 通过元素的链接名称定位
 		driver.findElement(By.linkText("登录")).click();
 		
 		driver.findElement(By.name("email")).clear();
 		// 通过元素的名称定位
 		driver.findElement(By.name("email")).sendKeys("18700960652");
 		driver.findElement(By.name("password")).clear();
 		// 通过元素的名称定位
// 		driver.findElement(By.name("password")).sendKeys("18700960652");
 		// 通过元素的html中的位置定位xpath
// 		driver.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys("18700960652");
 		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("18700960652!");
 		//*[@name="email"]
 		// 通过元素的ID定位   
 		driver.findElement(By.id("auto-signin")).click();
 		// 通过元素的类名定位
 		driver.findElement(By.className("moco-btn")).click();
 		
 		Thread.sleep(2000);
 		driver.findElement(By.cssSelector("[href=\"//class.imooc.com\"]")).click();
 		
 		
 		// 设置等待时间
 		Thread.sleep(2000);
 				
 		// 刷新页面
 		driver.navigate().refresh();
 		
 		Thread.sleep(2000);
 				
 		// 执行浏览器后退
 		driver.navigate().back();
 		
 		Thread.sleep(2000);
 			    
 		// 执行浏览器前进
 		driver.navigate().forward();
 		
 		Thread.sleep(2000);
 			    
 		driver.findElement(By.id("common-nav-search")).click();
 		WebElement searchItem = driver.findElement(By.className("nav-search-input"));
 		searchItem.sendKeys("java");
// 		WebElement searchItem = driver.findElement(By.className("search-input"));
// 		searchItem.sendKeys("java");
 		// 模拟键盘操作,使用enter键
 		searchItem.sendKeys(Keys.ENTER);
 			    
 		Thread.sleep(2000);
 			    
 		// 获得所有窗口句柄
 		Set<String> handles = driver.getWindowHandles();
 		System.out.println("handles:" + handles);
 		// [CDwindow-0A7D864A2C49F376A63CE911BE494A3A, CDwindow-27B9ACB0B342CB950D01630393A1176C]
 		// 切换窗口
 		driver.switchTo().window((String) handles.toArray()[0]);
 		
 		// 通过元素的部分链接名称定位
// 		driver.findElement(By.partialLinkText("免费")).click();
 		
 		// 通过元素的css属性定位
 		driver.findElement(By.cssSelector("[action-type='my_menu']")).click();
 		
 		// 通过元素的部分链接进行定位
 		driver.findElement(By.partialLinkText("设置")).click();
 		
 		// 层级定位
 		WebElement element = driver.findElement(By.className("menu"));
 		
 		// 获得父元素ul标签
 		// 获得ul标签下的所有li子元素
 		List<WebElement> elements = element.findElements(By.tagName("li"));
 		System.out.println("elements:" + elements);
// 		Thread.sleep(2000);
 		elements.get(2).click();
 		
 		WebElement tableElement=driver.findElement(By.className("oplog-list"));	
 		List<WebElement> rows=tableElement.findElements(By.tagName("tr"));
 		for (int i = 0; i < rows.size(); i++) {
 			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
 			for (int j = 0; j < cols.size(); j++) {
 				System.out.print(cols.get(j).getText()+"\t");
 			}			
 			System.out.println("");
 		}
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
