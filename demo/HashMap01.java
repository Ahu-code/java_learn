package HeiMa;

import java.util.HashMap;import java.util.Map;
import java.util.Set;

public class HashMap01 {
	public static void main(String[] args) {
		show01();
		System.out.println("------------------------------");
		show02();
	}
	/*
	 * HashMap 自定义类型键值
	 * key：String类型
	 * 			String类重写hashcode 和equals方法， 以保证key值一定
	 * value：Student类
	 * 			value可以重复（同名同年龄视为一个人）
	 */
	private static void show01() {
		//创建hashmap集合
		HashMap<String, Student> map = new HashMap<String, Student>();
		
		map.put("北京", new Student("张三",18));
		map.put("上海", new Student("李四",25));
		map.put("长沙", new Student("赵六",20));
		map.put("北京", new Student("王五",30));//替换张三
		
		//使用keyset加 增强for循环，遍历map集合
		Set<String> set = map.keySet();
		for(String s:set) {
			Student stu = map.get(s);
			System.out.println(s+"-->"+stu);
		}
	}
	/*
	 * HashMap 自定义类型键值
	 * key：Student类
	 * 			String类重写hashcode 和equals方法， 以保证key值一定
	 * value：String类型
	 * 			value可以重复
	 */
	private static void show02() {
		HashMap<Student, String> map02 = new HashMap<Student, String>();
		
		map02.put(new Student("张三",18),"北京");
		map02.put(new Student("李四",25),"上海");
		map02.put(new Student("张三",18),"长沙");
		map02.put(new Student("王五",30),"北京");//替换张三
		
		//使用entrySet和增强for循环
		Set<Map.Entry<Student, String>> set = map02.entrySet();
		for(Map.Entry<Student, String> entry: set) {
			Student key02 = entry.getKey();
			String value02 = entry.getValue();
			System.out.println(key02+"-->"+value02);
		}
	}
	
}
