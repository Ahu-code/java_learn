package Lambda01;

import java.util.Arrays;

public class Arrays01 {
	public static void main(String[] args) {
		Person[] arr = {
				new Person("柳岩", 38),
				new Person("古力娜扎", 20),
				new Person("佟丽娅", 33)
		};
		
		/*Arrays.sort(arr, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge() ;//升序
			}
		});*/
		
		//使用lambda简化
		Arrays.sort(arr, (o1, o2)-> o1.getAge() - o2.getAge());
		
		//遍历数组
		for(Person p:arr) {
			System.out.println(p);
		}
	}
}
