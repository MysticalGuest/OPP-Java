 package com.selenium;

 /**
 * @author MysteryGuest
 * @date 2021/10/12
 */

 import java.util.List;
 import java.util.Set;
 import java.util.concurrent.TimeUnit;

 import org.openqa.selenium.By;
 import org.openqa.selenium.Keys;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;

 public class QWBCTF {
     public static void main(String[] args) throws InterruptedException {
         WebDriver driver;
         // 设置驱动的路径
         System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
         // 借助Chrome进行操作
         driver = new ChromeDriver();
         driver.get("http://124.71.156.217:32770/");
         
         // 浏览器窗口最大化
         driver.manage().window().maximize();
         // 浏览器窗口大小自定义
//       driver.manage().window().setSize(new Dimension(480, 800));
         
         /* 
             // 全局隐式等待,与浏览器同步非常重要,必须等待浏览器加载完毕
             // 此处为设定元素查找最长超时时间为10s
             // 打开一个新的页面时,可能页面还没加载出来,此时已经进行下一步操作,元素定位,于是报错.
         */
//         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         // 自动化操作
         // 通过元素的链接名称定位
         while (true) {
//             driver.findElement(By.linkText("下一份")).click();
             driver.findElement(By.className("top-download")).click();
         }
         
  

//       driver.quit();


     }

 }

