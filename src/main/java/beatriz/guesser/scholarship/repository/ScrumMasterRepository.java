package beatriz.guesser.scholarship.repository;

import beatriz.guesser.scholarship.entity.ScrumMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrumMasterRepository extends JpaRepository<ScrumMaster, Long> {
}
