package HeiMa;

import java.util.HashSet;

/*
 * 存放自定义类型元素时，需要重写对象中的hashCode和equals方法，
 * 建立自己的比较方式，才能保证HashSet集合中的对象唯一
 */

public class HashSet_myself {
	private String name;
	private int age;
	
	public HashSet_myself() {
		// TODO Auto-generated constructor stub
	}
	
	public HashSet_myself(String name, int age) {
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
		HashSet_myself other = (HashSet_myself) obj;
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
	
	public static void main(String[] args) {
		HashSet<HashSet_myself> set = new HashSet<HashSet_myself>();
		HashSet_myself s1 = new HashSet_myself("小美女",18);
		HashSet_myself s2 = new HashSet_myself("小美女",19);
		HashSet_myself s3 = new HashSet_myself("小美女",18);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		System.out.println(set);
	}
}
