package Manager;

public class Student {
	private String id;
	private String name;
	private String sex;
	private String className;
	
	public Student() {
	}
	
	public Student(String id, String name, String sex, String className) {
		this.className = className;
		this.id = id;
		this.sex = sex;
		this.name = name;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setId(String s) {
		this.id = s;
	}
	
	public String getClassName() {
		return className;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
