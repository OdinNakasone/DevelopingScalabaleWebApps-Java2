package nakasone.odin.diary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiaryConfiguration {

	@Bean
	public DiaryEntryRepository diaryEntryRepository() {
		return new DiaryEntryRepository();
	}
}
