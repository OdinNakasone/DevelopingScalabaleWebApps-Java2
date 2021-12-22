package nakasone.odin.dearmongo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaryRepository extends MongoRepository<Diary, String>{

}
