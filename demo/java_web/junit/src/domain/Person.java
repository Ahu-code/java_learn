package domain;

public class Person {
	private String name;
	private int age;
	public int a;
	public String b;
	private int c;
	public int d;
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person{ name:" + name +
				" , age: " + age + " }"+
				"a:" + a;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println("eat...");
	}
	
	public void eat(String food) {
		System.out.println("eat"+ food +"...");
	}
	
	public void drink() {
		System.out.println("drink....");
	}
}
