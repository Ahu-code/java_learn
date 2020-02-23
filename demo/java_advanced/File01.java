package HeiMa;

import java.io.File;

public class File01 {
	/*
	 * C:\develop\a.txt   windows
	 * C:/develop/a.txt   linus
	 * "C"+File.separator+File.pathSeparator+"develop"+File.pathSeparator+"a.txt"
	 */
	/*
	 * public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
	 * public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
	 * 		把路径分成两部分，父路径与子路径可以单独书写
	 * public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
	 */
	public static void main(String[] args) {
		/*String pathSeparator01 = File.pathSeparator;
		System.out.println(pathSeparator01);
		
		String name = File.separator;
		System.out.println(name);*/
		show01();
		show02("F:\\","a.txt");
	}
	
	private static void show01() {
		File f1 = new File("F:\\a.txt");
		System.out.println(f1);		//说明重写了toString方法
	}
	
	/*
	 *  public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
	 * 		把路径分成两部分，父路径与子路径可以单独书写
	 * 		使用灵活
	 */
	private static void show02(String parent, String child) {
		File file = new File(parent,child);
		System.out.println(file);		//说明重写了toString方法
	}
	
	/*
	 * public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
	 */
}
