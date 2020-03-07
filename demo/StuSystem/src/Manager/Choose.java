package Manager;

public class Choose {
	private String stuId;
	private String clsId;
	private int grade=0;
	
	public Choose() {
	}
	public Choose(String stuId, String clsId, int grade) {
		this.clsId = clsId;
		this.stuId = stuId;
		this.grade = grade;
	}
	
	public void setClsId(String clsId) {
		this.clsId = clsId;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
	public String getClsId() {
		return clsId;
	}
	public int getGrade() {
		return grade;
	}
	public String getStuId() {
		return stuId;
	}
}
