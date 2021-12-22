package nakasone.odin.collegejpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import nakasone.odin.collegejpa.controller.MyJsonViews;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView({MyJsonViews.SummaryView.class, MyJsonViews.ExtendedSummaryView.class, MyJsonViews.StudentEnrollmentView.class})
	private int studentId;

	@Column(nullable = false)
	@JsonView({MyJsonViews.ExtendedSummaryView.class, MyJsonViews.StudentEnrollmentView.class})
	private String name;

	private double gpa;

	@ManyToMany(mappedBy="studentsCurrentlyEnrolled")	
	@JsonView(MyJsonViews.StudentEnrollmentView.class)
	private List<Course> currentEnrollments = new ArrayList<Course>();
	
	@OneToMany(mappedBy="student")
	private List<PastEnrollment> pastEnrollments = new ArrayList<PastEnrollment>();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public List<Course> getCurrentEnrollments() {
		return currentEnrollments;
	}

	public void setCurrentEnrollments(List<Course> currentEnrollments) {
		this.currentEnrollments = currentEnrollments;
	}

	public List<PastEnrollment> getPastEnrollments() {
		return pastEnrollments;
	}

	public void setPastEnrollments(List<PastEnrollment> pastEnrollments) {
		this.pastEnrollments = pastEnrollments;
	}
	
	

}
