package HeiMa;

import java.io.File;

public class Digui01 {
	/*
	 * 3.1 文件搜索
	 * 搜索F:\\FakeWechat 目录中的.xml 文件。
	 * 分析：
	 * 1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
	 * 2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。
	 */
	static int i=0;//计数
	
	public static void main(String[] args) {
		File file = new File("F:\\FakeWechat");
		getAllFile(file);
		System.out.println(i);
	}
	
	private static void getAllFile(File dir) {
		//System.out.println(dir);
		File[] files = dir.listFiles();
		for(File f:files) {
			if(f.isDirectory())
				getAllFile(f);
			else {
				/*
				 * 1.将f对象转化为字符串对象 ——getName()/getPath()/toString()
				 * 2.调用String类中的EndWith
				 * 3.将字符串转化为小写
				 */
				String name = f.getName();
//				String name = f.getPath();
//				String name = f.toString();
				name = name.toLowerCase();
				boolean xmlName = name.endsWith(".xml");
				if(xmlName) {
					System.out.println(name);	
					i++;
				}
			}
		}
	}
}
