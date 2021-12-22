package nakasone.odin.collegejpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import nakasone.odin.collegejpa.controller.MyJsonViews;

@Entity
public class Course {
	
	@Id
	@JsonView(MyJsonViews.StudentEnrollmentView.class)
	private String courseCode;
	
	private String courseTitle;
	
	@ManyToMany
	private List<Student> studentsCurrentlyEnrolled = new ArrayList<>();
	
	@OneToMany(mappedBy="course")
	private List<PastEnrollment> pastEnrollments = new ArrayList<PastEnrollment>();
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	public List<Student> getStudentsCurrentlyEnrolled() {
		return studentsCurrentlyEnrolled;
	}
	public void setStudentsCurrentlyEnrolled(List<Student> studentsCurrentlyEnrolled) {
		this.studentsCurrentlyEnrolled = studentsCurrentlyEnrolled;
	}
	public List<PastEnrollment> getPastEnrollments() {
		return pastEnrollments;
	}
	public void setPastEnrollments(List<PastEnrollment> pastEnrollments) {
		this.pastEnrollments = pastEnrollments;
	}
	
	
	
	

}
