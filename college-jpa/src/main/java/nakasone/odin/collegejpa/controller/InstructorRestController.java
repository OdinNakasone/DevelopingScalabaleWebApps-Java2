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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nakasone.odin.collegejpa.model.Instructor;
import nakasone.odin.collegejpa.model.InstructorJpaRepository;

@RestController
@RequestMapping("/instructor")
public class InstructorRestController {
	
	@Autowired
	private InstructorJpaRepository repo;
	
	@PostMapping(path="")
	@ResponseStatus(code=HttpStatus.CREATED)
	public int create(@RequestBody Instructor newInstructor) {
		return repo.save(newInstructor).getInstructorId();
	}
	
	@GetMapping(path="")
	public List<Instructor> findAll(){
		return repo.findAll();
	}
	
	@GetMapping(path="/{instructorId}")
	public Instructor findById(@PathVariable int instructorId) {
		Optional<Instructor> result = repo.findById(instructorId);
		return result.get();
//		return result.orElseThrow(() -> new RuntimeException());
	}
	
	@PutMapping(path="/{instructorId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void updated(@PathVariable int instructorId, @RequestBody Instructor updates) {
		Instructor toUpdate = repo.findById(instructorId).get();
		toUpdate.setName(updates.getName());
		repo.save(toUpdate);
	}
	
	@DeleteMapping(path="/{instructorId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int instructorId) {
		repo.deleteById(instructorId);
	}

}
