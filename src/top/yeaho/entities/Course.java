package top.yeaho.entities;

public class Course {

	private Integer id;//主键
	private String courseName;//课程名
	private int courseNumber;//课程号
	private int hours;//学时
	private String notes;//课程备注
	
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
