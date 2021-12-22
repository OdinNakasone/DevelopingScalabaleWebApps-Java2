package nakasone.odin.diary;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/diary")
public class DiaryRestController {
	
	@Autowired
	private DiaryEntryRepository repo;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public void createDiaryEntry(@RequestBody DiaryEntry entry) {
		entry.setCreateDate(LocalDateTime.now());
		repo.save(entry);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<DiaryEntry> findAllEntries(){
		return repo.findAll();
	}

//	@RequestMapping(path="/echo", method=RequestMethod.GET)
//	public String echo(@RequestParam String text) {
//		return text;
//	}
}
