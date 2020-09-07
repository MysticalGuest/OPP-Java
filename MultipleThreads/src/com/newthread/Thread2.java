package com.newthread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

// 实现多线程同步下载图片
public class Thread2 extends Thread {
	
	private String url;		// Picture url
	private String path;
	private String name;	// Saved file name
	
	public Thread2(String url, String path, String name) {
		super();
		this.url = url;
		this.path = path;
		this.name = name;
	}
	
	@Override
	public void run() {
		WebDownloader webDownloader = new WebDownloader();
		webDownloader.downloader(url, path, name);
		System.out.println("Downloaded the file which name is " + name);
	}
	
	public static void main(String[] args) {
		String path = "src/com/newthread/img/";
		Thread2 t1 = new Thread2("https://wx1.sinaimg.cn/orj360/67e231a6ly1geq8okovekj21hc0u0e42.jpg", path, "tower.jpg");
		Thread2 t2 = new Thread2("https://wx1.sinaimg.cn/orj360/67e231a6ly1geq8oq8jx1j21hc0u0qse.jpg", path, "bike.jpg");
		Thread2 t3 = new Thread2("https://wx1.sinaimg.cn/orj360/67e231a6ly1geq8on2u4gj21hc0u0ngj.jpg", path, "bridge.jpg");

		// simultaneous execution
		t1.start();
		t2.start();
		t3.start();
	}

}

// downloader
class WebDownloader{
	// download function
	public void downloader(String url, String path,String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(path + name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("IO Exception...downloader function has a problem!");
		}
	}
}
