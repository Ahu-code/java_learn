package HeiMa;

import java.io.File;

public class File02 {
	/*
	 * 获取功能的方法
	 * public String getAbsolutePath() ：返回此File的绝对路径名字符串。
	 * public String getPath() ：将此File转换为路径名字符串。
	 * public String getName() ：返回由此File表示的文件或目录的名称。
	 * public long length() ：返回由此File表示的文件的长度。
	 */
	public static void main(String[] args) {
		show01();
		show02();
		show03();
		show04();
	}
	//public String getAbsolutePath() ：返回此File的绝对路径名字符串。
	//无论路径绝对还是相对的
	private static void show01() {
		File file = new File("F:\\a.txt");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		
		File file02 = new File("a.txt");
		String absolutePath02 = file02.getAbsolutePath();
		System.out.println(absolutePath02);//E:\java_project\pr01\a.txt		
	}
	
	// public String getPath() ：将此File转换为路径名字符串
	// 获取构造方法中传递的路径 toString源码可知，就是调用的getPath方法
	private static void show02() {
		File file = new File("F:\\a.txt");
		File file02 = new File("a.txt");
		String path01 = file.getPath();
		String path02 = file02.getPath();
		System.out.println(path01);
		System.out.println(path02);
	}
	
	//public String getName() ：返回由此File表示的文件或目录的名称。
	//获取即为构造方法传递路径的结尾部分
	private static void show03() {
		File file01 = new File("F:\\a.txt");
		String name01 = file01.getName();
		System.out.println(name01);
	}
	
	//public long length() ：返回由此File表示的文件的长度。
	private static void show04() {
		File file01 = new File("F:\\a.txt");
		long name01 = file01.length();
		System.out.println(name01);//以字节为单位
		
		File file02 = new File("F:\\b.txt");
		long name02 = file02.length();
		System.out.println(name02);//没有就返回0
	}
}

