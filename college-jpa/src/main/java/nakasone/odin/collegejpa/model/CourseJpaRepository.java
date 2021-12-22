package nakasone.odin.collegejpa.model;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface CourseJpaRepository extends JpaRepository<Course, String> {


	
	//Optional<Course> findById(String courseCode);
	
	@Lock(LockModeType.PESSIMISTIC_READ)
	Optional<Course> findOneByCourseCode(String courseCode);
}
