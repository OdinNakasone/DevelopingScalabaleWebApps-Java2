package nakasone.odin.dearmongo.model;

import java.time.LocalDateTime;

public class DiaryEntry {

	private LocalDateTime entryTime;
	
	private String text;

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
