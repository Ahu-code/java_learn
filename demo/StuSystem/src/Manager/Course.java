package Manager;

public class Course {
	private String id;
	private String className;
	private String credit;
	
	public Course() {
	}
	
	public Course(String id, String className, String credit) {
		this.className = className;
		this.credit = credit;
		this.id = id;
	}
	
	public String getClassName() {
		return className;
	}
	public String getCredit() {
		return credit;
	}
	public String getId() {
		return id;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public void setId(String id) {
		this.id = id;
	}
}
