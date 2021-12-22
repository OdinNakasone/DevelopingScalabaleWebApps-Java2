package nakasone.odin.dearmongo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Diary {
	
	@Id
	private String diaryKey;

	private List<DiaryEntry> entries = new ArrayList<DiaryEntry>();

	
	public String getDiaryKey() {
		return diaryKey;
	}

	public void setDiaryKey(String diaryKey) {
		this.diaryKey = diaryKey;
	}

	public List<DiaryEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<DiaryEntry> entries) {
		this.entries = entries;
	}
	
	
}
