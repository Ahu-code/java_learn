package HeiMa;

import java.io.File;

public class File03 {
	/*
	 * 判断功能的方法
	 * public boolean exists() ：此File表示的文件或目录是否实际存在。
	 * public boolean isDirectory() ：此File表示的是否为目录。
	 * public boolean isFile() ：此File表示的是否为文件。
	 */
	public static void main(String[] args) {
		show01();
	}

	//public boolean isDirectory() ：此File表示的是否为目录。
	private static void show01() {
		File file = new File("F:\\a.txt");
		if(file.exists()) {
			System.out.println(file.isDirectory());
			System.out.println(file.isFile());
		}
	}
}
