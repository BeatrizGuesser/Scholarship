package beatriz.guesser.scholarship.repository;

import beatriz.guesser.scholarship.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
