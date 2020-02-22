package HeiMa;

import java.io.Serializable;

/*
 *   该类必须实现java.io.Serializable 接口， Serializable 是一个标记接口
 */
public class Person implements Serializable{
		//可以自己定义一个final序列号，这样就不会改变了
		private static final long serialVersionUID = 35353;
	private String name;
	private int age;
	
	
	public Person() {
	}
	
	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person{" +
				"name=" + name +','+
				"age=" +age +"}";
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}
