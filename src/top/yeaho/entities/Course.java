package top.yeaho.entities;

public class Course {

	private Integer id;//����
	private String courseName;//�γ���
	private int courseNumber;//�γ̺�
	private int hours;//ѧʱ
	private String notes;//�γ̱�ע
	
	public Course() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Course(String courseName, int courseNumber, int hours, String notes) {
		super();
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.hours = hours;
		this.notes = notes;
	}
	
	
/**
 * setters & getters
 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



}
