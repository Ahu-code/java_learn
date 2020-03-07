package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class clsFunction {
	public static void ClsMain() throws IOException {
		String coursePath = "E://java_project//StuSystem//src//Manager//course.txt";
		while(true) {
			System.out.println("-----欢迎来到课程信息界面-----");
			System.out.println("1、所有课程信息查看");
			System.out.println("2、添加课程信息");
			System.out.println("3、删除课程信息");
			System.out.println("4、修改课程信息");
			System.out.println("5、返回上一步");		
			System.out.println();
			System.out.println("请输入你的选择");
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			
			switch(choice){
			case "1":
				checkCourse(coursePath);
				break;
			case "2":
				addCourse(coursePath);
				break;
			case "3":
				deleteCourse(coursePath);
				break;
			case "4":
				updateCourse(coursePath);
				break;
			case "5":
				Manager.MainView();
				break;
			default:
				System.out.println("谢谢您的使用！");
				System.exit(0);
			}
		}
	}
	
	//查看学生基本信息，利用学生txt
	public static void checkCourse(String coursePath) throws IOException {
		ArrayList<Course> arr = new ArrayList<Course>();
		ReadCourse(coursePath, arr);
		if(arr.size()==0) {
			System.out.println("没有课程信息！");
			return;
		}
		System.out.println("课程号\t课程名\t学分");
		for (int i = 0; i < arr.size(); i++) {
			Course show = arr.get(i);
			System.out.println(show.getId()+"\t"+show.getClassName()+"\t"+show.getCredit()+"\t");
		}		
	}
	
	//添加课程信息到学生txt文件中
	public static void addCourse(String coursePath) throws IOException {
		ArrayList<Course> arr = new ArrayList<Course>();
		ReadCourse(coursePath, arr);
		Scanner scan = new Scanner(System.in);
		String id;
		boolean flag = true;
		System.out.println("请输入课程号：");//专门讲学号拿出来，判断是否重号
		while(true) {
			id = scan.nextLine();
			for (int i = 0; i < arr.size(); i++) {
				if(arr.get(i).getId().equals(id)) {
					flag = false;
					break;
				}
			}
			
			if(flag==false)
				System.out.println("课程号重复！请重新输入课程号！");
			else 
				break;
		}
		
		System.out.println("请输入课程名：");
		String name = scan.nextLine();
		System.out.println("请输入学分：");
		String credit = scan.nextLine();
		
		Course course = new Course();
		course.setId(id);
		course.setCredit(credit);
		course.setClassName(name);
		arr.add(course);
		writeCourse(coursePath, arr);
		System.out.println("添加成功！");
	}
	
	//删除课程，输入课程号
	public static void deleteCourse(String coursePath) throws IOException {
		ArrayList<Course> arr = new ArrayList<Course>();
		ReadCourse(coursePath, arr);
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你要删除的课程号：");
		
		while(true) {
			String id = scan.nextLine();
			Course course = new Course();
			int deleteIndex = -1;
			for (int i = 0; i < arr.size(); i++) {
				course = arr.get(i);
				if(course.getId().equals(id)) {
					deleteIndex = i;
					break;
				}
			}
			
			if(deleteIndex>=0) {
				arr.remove(deleteIndex);
				writeCourse(coursePath, arr);
				System.out.println("删除成功！");
				break;
			}else {
				System.out.println("查询不到此课程号！请重新输入！");
			}
		}
	}
	
	//修改学生信息
	public static void updateCourse(String coursePath) throws IOException {
		ArrayList<Course> arr = new ArrayList<Course>();
		ReadCourse(coursePath, arr);
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你要修改课程的课程号：");
		while(true) {
			String id = scan.nextLine();
			Course course = new Course();
			int deleteIndex = -1;
			for (int i = 0; i < arr.size(); i++) {
				course = arr.get(i);
				if(course.getId().equals(id)) {
					deleteIndex = i;
					break;
				}
			}
			if(deleteIndex>=0) {
				arr.remove(deleteIndex);
				System.out.println("请修改课程名为：");
				String name = scan.nextLine();
				System.out.println("请修改学分为：");
				String credit =scan.nextLine();

				//Course course = new Course();
				course.setId(id);
				course.setCredit(credit);
				course.setClassName(name);
				arr.add(course);
				writeCourse(coursePath, arr);
				System.out.println("修改成功！");
				break;
			}else {
				System.out.println("查询不到此课程号！请重新输入！");
			}
		}
	}
	
		
	//输入流，读入课程信息到文件中
	public static void ReadCourse(String path, ArrayList<Course> arr) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while( (line=br.readLine())!=null ) {
			String[] s = line.split(",");
			Course c = new Course();
			c.setId(s[0]);
			c.setClassName(s[1]);
			c.setCredit(s[2]);
			arr.add(c);
		}
		br.close();
	}
	
	//输出流，读出文件中的信息
	public static void writeCourse(String path, ArrayList<Course> arr) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		for (int i = 0; i < arr.size(); i++) {
			Course c = arr.get(i);
			StringBuilder sb = new StringBuilder();
			sb.append(c.getId()+","+c.getClassName()+","+c.getCredit());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

}
	

