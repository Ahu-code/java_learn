package Lambda01;

public class Person {
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
		// TODO Auto-generated method stub
		return "Person{" + 
				"name=" + name +","+
				"age=" + age +"}";
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
