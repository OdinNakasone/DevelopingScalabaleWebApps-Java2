package nakasone.odin.collegejpa.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

	List<Student> findByNameLike(String string);

	List<Student> findByGpaIsGreaterThan(double minGpa);

	List<Student> findByNameLikeAndGpaIsGreaterThanEqual(String string, double minGpa);

	@Query("SELECT s 	" + "FROM Student s " + "WHERE s.name LIKE :text" )	
	List<String> queryByNameLike(@Param("text") String text);
}
