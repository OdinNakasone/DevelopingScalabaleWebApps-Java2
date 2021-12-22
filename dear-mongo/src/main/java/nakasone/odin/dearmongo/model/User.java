package nakasone.odin.dearmongo.model;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String username;
	
	private String displayName;
	
	//private Diary diary;
	private String diaryKey;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDiaryKey() {
		return diaryKey;
	}

	public void setDiaryKey(String diaryKey) {
		this.diaryKey = diaryKey;
	}

	
	
	
}
