package com.textIO;

public class TestFileClass {

	public static void main(String[] args) {
//		java.io.File file = new java.io.File("E:\\eclipse-workspace\\JavaLearning\\image\\us.gif");
		java.io.File file = new java.io.File("image/us.gif"); // 文件路径是与src同级的文件夹
		System.out.println("Does it exit? " + file.exists());
		System.out.println("The file has " + file.length() + " bytes");
		System.out.println("Can it be read? " + file.canRead());
		System.out.println("Can it be written? " + file.canWrite());
		System.out.println("Is it a directory? " + file.isDirectory()); // 对象代表的是一个目录,返回true
		System.out.println("Is it a file? " + file.isFile());
		System.out.println("Is it absolute? " + file.isAbsolute()); // 对象是采用绝对路径名创建,返回true
		System.out.println("Is it hidden? " + file.isHidden());
		System.out.println("Absolute path is " + file.getAbsolutePath());
		System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
	}

}
