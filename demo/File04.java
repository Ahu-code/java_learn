package HeiMa;

import java.io.File;

public class File04 {
	/*
	 * public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
	 * public boolean delete() ：删除由此File表示的文件或目录。
	 * public boolean mkdir() ：创建由此File表示的目录。
	 * public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
	 */
	/*
	 * 目录的遍历
	 * public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
	 * public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
	 */
	public static void main(String[] args) {
		show01();
		show02();
	}
	
	private static void show01() {
		File file = new File("F:\\FakeWechat");
		String[] arr = file.list();
		for(String filename:arr) {
			System.out.println(filename);//res
		}
	}

	private static void show02() {
		File file = new File("F:\\FakeWechat");
		File[] files = file.listFiles();
		for(File filename:files) {
			System.out.println(filename);//F:\FakeWechat\res
		}
	}
}

