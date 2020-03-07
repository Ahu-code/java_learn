package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StuFunction {
	public static void StuMain() throws IOException {
		String stuPath = "E://java_project//StuSystem//src//Manager//student.txt";
		while(true) {
			System.out.println("-----欢迎来到学生信息界面-----");
			System.out.println("1、所有学生信息查看");
			System.out.println("2、添加学生信息");
			System.out.println("3、删除学生信息");
			System.out.println("4、修改学生信息");
			System.out.println("5、返回上一步");		
			System.out.println();
			System.out.println("请输入你的选择");
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			
			switch(choice){
			case "1":
				checkStudent(stuPath);
				break;
			case "2":
				addStudent(stuPath);
				break;
			case "3":
				deleteStudent(stuPath);
				break;
			case "4":
				updateStudent(stuPath);
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
		public static void checkStudent(String stuPath) throws IOException {
			ArrayList<Student> arr = new ArrayList<Student>();
			ReadStu(stuPath, arr);
			if(arr.size()==0) {
				System.out.println("没有学生信息！");
				return;
			}
			System.out.println("学号\t姓名\t性别\t班级");
			for (int i = 0; i < arr.size(); i++) {
				Student show = arr.get(i);
				System.out.println(show.getId()+"\t"+show.getName()+"\t"
								  +show.getSex()+"\t"+show.getClassName());
			}		
		}
		
		//添加学生信息到学生txt文件中
		public static void addStudent(String stuPath) throws IOException {
			ArrayList<Student> arr = new ArrayList<Student>();
			ReadStu(stuPath, arr);
			Scanner scan = new Scanner(System.in);
			String id;
			boolean flag = true;
			System.out.println("请输入学号：");//专门讲学号拿出来，判断是否重号
			while(true) {
				id = scan.nextLine();
				for (int i = 0; i < arr.size(); i++) {
					if(arr.get(i).getId().equals(id)) {
						flag = false;
						break;
					}
				}
				
				if(flag==false)
					System.out.println("学号重复！请重新输入学号！");
				else 
					break;
			}
			
			System.out.println("请输入姓名：");
			String name = scan.nextLine();
			System.out.println("请输入性别：");
			String sex = scan.nextLine();
			System.out.println("请输入班级：");
			String className = scan.nextLine();
			
			Student stu = new Student();
			stu.setId(id);
			stu.setName(name);
			stu.setSex(sex);
			stu.setClassName(className);
			arr.add(stu);
			writeStu(stuPath, arr);
			System.out.println("添加成功！");
		}
		
		//删除学生，输入学号
		public static void deleteStudent(String stuPath) throws IOException {
			ArrayList<Student> arr = new ArrayList<Student>();
			ReadStu(stuPath, arr);
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入你要删除学生的学号：");
			
			while(true) {
				String id = scan.nextLine();
				Student stu = new Student();
				int deleteIndex = -1;
				for (int i = 0; i < arr.size(); i++) {
					stu = arr.get(i);
					if(stu.getId().equals(id)) {
						deleteIndex = i;
						break;
					}
				}
				
				if(deleteIndex>=0) {
					arr.remove(deleteIndex);
					writeStu(stuPath, arr);
					System.out.println("删除成功！");
					break;
				}else {
					System.out.println("查询不到此学号！请重新输入！");
				}
			}
		}
		
		//修改学生信息
		public static void updateStudent(String stuPath) throws IOException {
			ArrayList<Student> arr = new ArrayList<Student>();
			ReadStu(stuPath, arr);
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入你要修改学生的学号：");
			while(true) {
				String id = scan.nextLine();
				Student stu = new Student();
				int deleteIndex = -1;
				for (int i = 0; i < arr.size(); i++) {
					stu = arr.get(i);
					if(stu.getId().equals(id)) {
						deleteIndex = i;
						break;
					}
				}
				if(deleteIndex>=0) {
					arr.remove(deleteIndex);
					System.out.println("请修改姓名为：");
					String name = scan.nextLine();
					System.out.println("请修改性别为：");
					String sex = scan.nextLine();
					System.out.println("请修改班级为：");
					String className = scan.nextLine();

					//Student stu = new Student();
					stu.setId(id);
					stu.setName(name);
					stu.setSex(sex);
					stu.setClassName(className);
					arr.add(stu);
					writeStu(stuPath, arr);
					System.out.println("修改成功！");
					break;
				}else {
					System.out.println("查询不到此学号！请重新输入！");
				}
			}
		}
		
			
		//输入流，读入学生信息到文件中
		public static void ReadStu(String path, ArrayList<Student> arr) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while( (line=br.readLine())!=null ) {
				String[] s = line.split(",");
				Student stu = new Student();
				stu.setId(s[0]);
				stu.setName(s[1]);
				stu.setSex(s[2]);
				stu.setClassName(s[3]);
				arr.add(stu);
			}
			br.close();
		}
		
		//输出流，读出文件中的信息
		public static void writeStu(String path, ArrayList<Student> arr) throws IOException {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			for (int i = 0; i < arr.size(); i++) {
				Student stu = arr.get(i);
				StringBuilder sb = new StringBuilder();
				sb.append(stu.getId()+","+stu.getName()+","+stu.getSex()+","+stu.getClassName());
				bw.write(sb.toString());
				bw.newLine();
				bw.flush();
			}
			bw.close();
		}
	
}
	
