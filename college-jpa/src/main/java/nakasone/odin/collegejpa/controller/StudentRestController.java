package nakasone.odin.collegejpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import nakasone.odin.collegejpa.model.Student;
import nakasone.odin.collegejpa.model.StudentJpaRepository;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@Autowired
	private StudentJpaRepository repo;
	
	@PostMapping(path="")
	@ResponseStatus(code=HttpStatus.CREATED)
	public int create(@RequestBody Student newStudent) {
		return repo.save(newStudent).getStudentId();
	}
	
	@GetMapping(path="")
	@JsonView(MyJsonViews.SummaryView.class)
	public List<Student> findAll(){
		return repo.findAll();
	}
	
	@GetMapping(path="/{studentId}")
	@JsonView(MyJsonViews.StudentEnrollmentView.class)
	public Student findById(@PathVariable int studentId) {
		Optional<Student> result = repo.findById(studentId);
		return result.get();
//		return result.orElseThrow(() -> new RuntimeException());
	}
	
	@PutMapping(path="/{studentId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void updated(@PathVariable int studentId, @RequestBody Student updates) {
		Student toUpdate = repo.findById(studentId).get();
		toUpdate.setName(updates.getName());
		toUpdate.setGpa(updates.getGpa());
		repo.save(toUpdate);
	}
	
	@DeleteMapping(path="/{studentId")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int studentId) {
		repo.deleteById(studentId);
	}
	
	@GetMapping(path="/searchByName")
	public List<Student> searchByName(@RequestParam String text){
		return repo.findByNameLike("%" + text + "%");
	}
	
	@GetMapping(path="/searchByGpa/{minGpa}")
	public List<Student> searchByGpa(@PathVariable double minGpa){
		return repo.findByGpaIsGreaterThan(minGpa);
	}
	
	@GetMapping(path="/search")
	public List<Student> search(@RequestParam String name, @RequestParam double minGpa){
		return repo.findByNameLikeAndGpaIsGreaterThanEqual("%" + name + "%", minGpa);
	}
}
