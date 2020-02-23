package HeiMa;

import java.io.File;
//import java.io.FileFilter;
//import java.io.FilenameFilter;

public class Filter01 {
	/*
	 * public interface FilenameFilter
	 * 用于实现此接口的类的实例用于过滤文件名。 
	 * 这些实例都用在过滤目录列表list类的方法File ，并通过抽象窗口工具包的文件对话框组件。 
	 *  方法：accept(File dir, String name)
	 *  File dir 构造方法中传递的被遍历的目录
	 *  String name ：使用listfiles方法遍历目录，得到的每一个文件/文件夹的名称
	 *  
	 *  public interface FileFilter
	 *  抽象路径名的过滤器。
	 *  该接口的实例可以传递给File类的listFiles(FileFilter)方法。
	 *   方法： accept(File pathname)
	 *   使用listfile方法遍历目录，得到的每一个文件对象
	 *   
	 *   注意：
	 *   两个过滤器是没有实现类的，需要我们自己写实现类，重写过滤方法accept，在方法中自己定义过滤规则
	 */
	public static void main(String[] args) {
		File file = new File("F:\\FakeWechat");
		getAllFile(file);
	}
	
	
	/*private static void getAllFile(File dir) {
		File[] files = dir.listFiles(new FileFilterImpl());//调用FileFilterImpl类
		for(File f:files) {
			if(f.isDirectory())
				getAllFile(f);
			else {
				System.out.println(f);			
			}
		}
	}*/
	
	/*//对上述方法进行优化————使用匿名内部类
		public static void getAllFile(File dir) {
			File[] files = dir.listFiles(new FileFilter() {
				@Override//重写过滤规则
				public boolean accept(File f) {
					return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
				}
			});
			for(File f:files) {
				if(f.isDirectory())
					getAllFile(f);
				else {
					System.out.println(f);			
				}
			}
		}
		*/
	
	/*//对一式进行优化————使用FilenameFilter
	public static void getAllFile(File dir) {
		File[] files = dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".xml");
			}
		});
		for(File f:files) {
			if(f.isDirectory())
				getAllFile(f);
			else {
				System.out.println(f);			
			}
		}
	}*/
	
	//再次进行优化，使用lambda类
	//FileFilter/FilenameFilter 是只有一个方法的接口，因此可以用lambda表达式简写。
	public static void getAllFile(File dir) {
//		File[] files = dir.listFiles((File dir02, String name)->{
//			return new File(dir02,name).isDirectory() || name.toLowerCase().endsWith(".xml");
//		});
		File[] files = dir.listFiles((dir02, name)->
			 new File(dir02,name).isDirectory() || name.toLowerCase().endsWith(".xml")
		);
		
		for(File f:files) {
			if(f.isDirectory())
				getAllFile(f);
			else {
				System.out.println(f);			
			}
		}
	}
	
}
