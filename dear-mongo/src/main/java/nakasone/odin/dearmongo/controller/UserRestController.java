package nakasone.odin.dearmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nakasone.odin.dearmongo.model.Diary;
import nakasone.odin.dearmongo.model.DiaryRepository;
import nakasone.odin.dearmongo.model.User;
import nakasone.odin.dearmongo.model.UserRepository;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserRepository users;
	
	@Autowired
	private DiaryRepository diaries;

	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void create(@RequestBody User user) {
		users.save(user);
	}
	
	@GetMapping("")
	public List<User> findAll(){
		return users.findAll();
	}
	
	@GetMapping("/{username}")
	public User findByUsername(@PathVariable String username) {
		User user = users.findById(username).get();
		Diary diary = diaries.findById(user.getDiaryKey()).get();
		return user;
	}
	
	@DeleteMapping("")
	public void delete() {
		users.deleteAll();
	}
}
