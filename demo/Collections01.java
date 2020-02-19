package HeiMa;

import java.util.ArrayList;
import java.util.Collections;

public class Collections01 implements Comparable<Collections01>{
	/* 都为静态方法，可以类名直接调用
	 * public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
	 * public static void shuffle(List<?> list) 打乱顺序:打乱集合顺序.
	 * public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。(一般是)
	 * public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排序。
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		/*list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");*/
				
		//public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
		Collections.addAll(list,"a", "b","c","d");
		Collections.addAll(list,"1", "4","2","3");
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		/* 
		 * 我们采用的public static <T> void sort(List<T> list) 这个方法完成的排序，
		 * 实际上要求了被排序的类型需要实现Comparable接口完成比较的功能
		 */
		ArrayList<Collections01> list02 = new ArrayList<Collections01>();
		list02.add(new Collections01("张三",18));
		list02.add(new Collections01("李四",30));
		list02.add(new Collections01("王五",20));
		
		Collections.sort(list02);
		System.out.println(list02);
	}
	
	/*=========Person=============================*/
	private String name;
	private int age;
	
	public Collections01() {
		// TODO Auto-generated constructor stub
	}
	
	public Collections01(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person{" + 
				"name = '" + name + '\'' +
				",age = " + age + 
				" }";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collections01 other = (Collections01) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	//重写排序规则
	public int compareTo(Collections01 o) {
		// TODO Auto-generated method stub		
		//return 0;认为元素都是相同的
		//应当自定义比较规则，比较两个人的年龄
		return this.getAge()-o.getAge();//按年龄升序排序
	}
}
