package Manager;

import java.io.IOException;
import java.util.Scanner;

public class Manager {
	public static void main(String[] args) throws IOException {
		MainView();
	}
	
	public static void MainView() throws IOException {
		while(true) {
			System.out.println("-----欢迎来到学生管理系统-----");
			System.out.println("1、学生信息及相关功能");
			System.out.println("2、课程信息及相关功能");
			System.out.println("3、选课信息及相关功能");
			System.out.println("4、退出系统");
			System.out.println();
			System.out.println("请输入你的选择");
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			
			switch(choice){
			case "1":
				StuFunction.StuMain();
				break;
			case "2":
				clsFunction.ClsMain();
				break;
			case "3":
				ChooseCurse.CCMain();
				break;
				
			default:
				System.out.println("谢谢您的使用！");
				System.exit(0);
		}
		}
	}
	
}
