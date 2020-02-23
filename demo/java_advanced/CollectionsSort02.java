package HeiMa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsSort02 {
	public static void main(String[] args) {
		ArrayList<Integer> list01 = new ArrayList<Integer>();
		list01.add(1);
		list01.add(2);
		list01.add(3);
		list01.add(4);
		System.out.println(list01);
		
		Collections.sort(list01,new Comparator<Integer>() {
			//重写比较的规则
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;//降序
			}
		});
		
		System.out.println(list01);
		
		/**************************************************/
		ArrayList<Student> list02 = new ArrayList<Student>();
		list02.add(new Student("a迪丽热巴",18));
		list02.add(new Student("b古力娜扎",20));
		list02.add(new Student("d佟丽娅",18));
		list02.add(new Student("c杨幂",35));
		
		Collections.sort(list02, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// 年龄一样采用姓名来排序
				int result = o1.getAge()-o2.getAge();
				if(result == 0) {
					result = o1.getName().charAt(0)-o2.getName().charAt(0);
				}
				return result;
			}
		});
		
		System.out.println(list02);
		
	}
}
