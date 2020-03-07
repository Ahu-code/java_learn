package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChooseCurse {
	
	public static void CCMain() throws IOException {
		String CCPath = "E://java_project//StuSystem//src//Manager//chooseCourse.txt";
		String stuPath = "E://java_project//StuSystem//src//Manager//student.txt";
		String coursePath = "E://java_project//StuSystem//src//Manager//course.txt";
		while(true) {
			System.out.println("-----欢迎来到选课界面-----");
			System.out.println("1、查询学生选课信息");
			System.out.println("2、添加选课信息");
			System.out.println("3、删除选课成绩");
			System.out.println("4、修改选课成绩");
			System.out.println("5、查询平均成绩");
			System.out.println("6、返回上一步");		
			System.out.println();
			System.out.println("请输入你的选择");
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			
			switch(choice){
			case "1":
				checkStudent(CCPath);
				break;
			case "2":
				addStudent(CCPath, stuPath, coursePath);
				break;
			case "3":
				deleteStudent(CCPath);
				break;
			case "4":
				updateStudent(CCPath);
				break;
			case "5":
				checkEqualGrades(CCPath);
				break;
			case "6":
				Manager.MainView();
				break;
			default:
				System.out.println("谢谢您的使用！");
				System.exit(0);
			}
		}
	}
	
	//查看学生的选课信息，利用CCtxt
	public static void checkStudent(String CCPath) throws IOException {
		ArrayList<Choose> arr = new ArrayList<Choose>();
		ReadCC(CCPath, arr);
		if(arr.size()==0) {
			System.out.println("没有选课完成信息！");
			return;
		}
		System.out.println("学号\t课程号\t成绩\t");
		for (int i = 0; i < arr.size(); i++) {
			Choose show = arr.get(i);
			System.out.println(show.getStuId()+"\t"+show.getClsId()+"\t"
					  +show.getGrade()+"\t");
		}		
	}
	
	//添加学生信息到学生txt文件中
	//该方法难点在于需要判断三个文件中是否都有
	public static void addStudent(String CCPath, String stuPath, String coursePath) throws IOException {
		//需要判断学生信息与课程信息是否在之前两个txt文件中存在
		ArrayList<Choose> arr = new ArrayList<Choose>();
		ReadCC(CCPath, arr);
		ArrayList<Student> arrStu = new ArrayList<Student>();
		StuFunction.ReadStu(stuPath, arrStu);
		ArrayList<Course> arrCos = new ArrayList<Course>();
		clsFunction.ReadCourse(coursePath, arrCos);
		
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		/*
		 * 先判断学号
		 * 有两种情况，一是可能学号本身不存在，二是可能与之前录入的名单重复
		 * 课程号同，但在第二种情况发生时，两者要同时判断
		 * 因此先循环判断学号第一种情况，
		 * 在符合第一种情况条件下，进行课程的第一种判断，
		 * 然后再进行是否重名的判断
		 */
		String sId;
		while(true) {
			System.out.println("请输入学号：");
			sId = scan.nextLine();
			if(arrStu.size()==0) {
				System.out.println("没有学生信息！");
				return;
			}
			
			for (int i = 0; i < arrStu.size(); i++) {
				Student show = arrStu.get(i);
				if(show.getId().equals(sId)) {
					flag=true;
					break;
				}
			}
			
			if(flag) {
				break;
			}else {
				System.out.println("输入学号不存在！");
			}
		}
		String cId;
		
		while(true) {
			flag = true;
			boolean flag2 = false;
			System.out.println("请输入课程号：");
			cId = scan.nextLine();
			
			if(arrCos.size()==0) {
				System.out.println("没有课程信息！");
				return;
			}
			
			for (int i = 0; i < arrCos.size(); i++) {
				Course show = arrCos.get(i);
				if(show.getId().equals(cId)) {
					flag=false;
					break;
				}
			}
			
			if(flag==true){
				System.out.println("输入课程号不存在！");
				continue;
			}
			
			for (int j = 0; j < arr.size(); j++) {
				if(arr.get(j).getClsId().equals(cId) && arr.get(j).getStuId().equals(sId)) {
					flag2 =true;
					break;
				}
			}	
			if(flag2==true ) {
				System.out.println("课程号重复！请重新输入课程号！");
			}else
				break;
		}
		
	
		Choose ch = new Choose();
		ch.setStuId(sId);
		ch.setClsId(cId);
		arr.add(ch);
		writeCC(CCPath, arr);
		System.out.println("添加成功！");
	}
	
	//删除选课信息，输入学号
	public static void deleteStudent(String CCPath) throws IOException {
		ArrayList<Choose> arr = new ArrayList<Choose>();
		ReadCC(CCPath, arr);
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你要删除学生的学号：");
		String sId = scan.nextLine();
		System.out.println("请输入课程号：");//再比较课程号拿出来，判断是否重号
		
		while(true) {
			String cId = scan.nextLine();
			Choose ch = new Choose();
			int deleteIndex = -1;
			for (int i = 0; i < arr.size(); i++) {
				ch = arr.get(i);
				if(ch.getClsId().equals(cId)) {
					deleteIndex = i;
					break;
				}
			}
			
			if(deleteIndex>=0) {
				arr.remove(deleteIndex);
				writeCC(CCPath, arr);
				System.out.println("删除成功！");
				break;
			}else {
				System.out.println("查询不到此课程号！请重新输入！");
			}
		}
	}
	
	//修改学生信息
	public static void updateStudent(String CCPath) throws IOException {
		ArrayList<Choose> arr = new ArrayList<Choose>();
		ReadCC(CCPath, arr);
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你要修改学生的学号：");
		String sId = scan.nextLine();
		System.out.println("请输入课程号：");//再比较课程号拿出来，判断是否重号
		
		while(true) {
			String cId = scan.nextLine();
			Choose ch = new Choose();
			int deleteIndex = -1;
			for (int i = 0; i < arr.size(); i++) {
				ch = arr.get(i);
				if(ch.getClsId().equals(cId)) {
					deleteIndex = i;
					break;
				}
			}
			if(deleteIndex>=0) {
				arr.remove(deleteIndex);
				System.out.println("请修改成绩为：");
				String grades = scan.nextLine();
				int transGrades = new Integer(grades);
				
				ch.setClsId(cId);
				ch.setStuId(sId);
				ch.setGrade(transGrades);
				arr.add(ch);
				writeCC(CCPath, arr);
				System.out.println("修改成功！");
				break;
			}else {
				System.out.println("查询不到此课程号！请重新输入！");
			}
		}
	}
	
	//查看平均成绩
	public static void checkEqualGrades(String CCPath) throws IOException {
		ArrayList<Choose> arr = new ArrayList<Choose>();
		ReadCC(CCPath, arr);
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你要查询学生的学号：");
		
		while(true) {
			String sId = scan.nextLine();
			Choose ch = new Choose();
			int gradesSum = 0;
			int classNum = 0;
			for (int i = 0; i < arr.size(); i++) {
				ch = arr.get(i);
				if(ch.getStuId().equals(sId)) {
					gradesSum += ch.getGrade();
					classNum++;
				}
			}
			if(classNum>0) {
				int grade = gradesSum/classNum;
				System.out.println("查询该生平均成绩为："+grade);
				break;
			}else {
				System.out.println("查询不到此学号！请重新输入！");
			}
		}
	}
	
	//输入流，将文件信息读出
	public static void ReadCC(String path, ArrayList<Choose> arr) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while( (line=br.readLine())!=null ) {
			String[] s = line.split(",");
			int transGrade = new Integer(s[2]);
			Choose ch = new Choose();
			ch.setStuId(s[0]);
			ch.setClsId(s[1]);
			ch.setGrade(transGrade);
			arr.add(ch);
		}
		br.close();
	}
	
	//输出流，写入文件中
	public static void writeCC(String path, ArrayList<Choose> arr) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		for (int i = 0; i < arr.size(); i++) {
			Choose ch = arr.get(i);
			StringBuilder sb = new StringBuilder();
			sb.append(ch.getStuId()+","+ch.getClsId()+","+ch.getGrade());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

}
	
