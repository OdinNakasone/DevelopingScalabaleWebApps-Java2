package nakasone.odin.collegejpa.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import nakasone.odin.collegejpa.model.Course;
import nakasone.odin.collegejpa.model.CourseJpaRepository;
import nakasone.odin.collegejpa.model.InstructorJpaRepository;
import nakasone.odin.collegejpa.model.Student;

@RestController
@RequestMapping("/course")
public class CourseRestController {
	
	@Autowired
	private CourseJpaRepository repo;
	
	@Autowired
	private StudentRestController students;
	
	@PostMapping(path="")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String create(@RequestBody Course newCourse) {
		return repo.save(newCourse).getCourseCode();
	}
	
	@GetMapping(path="")
	public List<Course> findAll(){
		return repo.findAll();
	}
	
	@GetMapping(path="/{courseCode}")
	@JsonView(MyJsonViews.StudentEnrollmentView.class)
	public Course findById(@PathVariable String courseCode) {
		Optional<Course> result = repo.findById(courseCode);
		return result.get();
//		return result.orElseThrow(() -> new RuntimeException());
	}
	
	@PutMapping(path="/{courseCode}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@Transactional
	public void updated(@PathVariable String courseCode, @RequestBody Course updates) {
		Course toUpdate = repo.findOneByCourseCode(courseCode).get();
		toUpdate.setCourseTitle(updates.getCourseTitle());
		repo.save(toUpdate);
	}
	
	@DeleteMapping(path="/{courseCode}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String courseCode) {
		repo.deleteById(courseCode);
	}
	
	@PutMapping("/{courseCode}/addStudent/{studentId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@Transactional
	public void addStudentToCourse(@PathVariable String courseCode, @PathVariable int studentId) {
		Course c = repo.findById(courseCode).get();
		Student s = students.findById(studentId);
		c.getStudentsCurrentlyEnrolled().add(s);
		repo.save(c);
	}

}
