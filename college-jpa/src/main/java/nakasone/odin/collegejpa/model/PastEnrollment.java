package nakasone.odin.collegejpa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PastEnrollment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int enrollmentId;
	
	private double finalGrade;
	
	private LocalDate completed;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Course course;

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public LocalDate getCompleted() {
		return completed;
	}

	public void setCompleted(LocalDate completed) {
		this.completed = completed;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
