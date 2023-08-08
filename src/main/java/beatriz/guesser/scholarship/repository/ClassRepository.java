package beatriz.guesser.scholarship.repository;

import beatriz.guesser.scholarship.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Long> {
}
