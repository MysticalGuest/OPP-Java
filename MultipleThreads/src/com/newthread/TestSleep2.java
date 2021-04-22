package com.newthread;

import java.sql.Date;
import java.text.SimpleDateFormat;

// 模拟倒计时
public class TestSleep2 {
    
	public static void main(String[] args) {
		try {
			tenDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 打印当前系统时间
		Date startTime = new Date(System.currentTimeMillis());	// 获取当前系统时间
		
		System.out.println("Start printing system time...");
		
		while (true) {
			try {
				Thread.sleep(1000);
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
				startTime = new Date(System.currentTimeMillis());	// 更新时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void tenDown() throws InterruptedException {
		int num=10;
		while (true) {
			Thread.sleep(1000);
			System.out.println(num--);
			if (num<=0) {
				break;
			}
		}
	}
}
