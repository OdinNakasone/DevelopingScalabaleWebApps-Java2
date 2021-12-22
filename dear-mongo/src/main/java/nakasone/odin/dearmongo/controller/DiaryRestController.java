package nakasone.odin.dearmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nakasone.odin.dearmongo.model.Diary;
import nakasone.odin.dearmongo.model.DiaryRepository;

@RestController
@RequestMapping("/diary")
public class DiaryRestController {

	@Autowired
	private DiaryRepository diaries;
	
	@PostMapping("")
	public void create(@RequestBody Diary diary) {
		diaries.save(diary);
	}
	
	@GetMapping
	public List<Diary> findAll(){
		return diaries.findAll();
	}
}
